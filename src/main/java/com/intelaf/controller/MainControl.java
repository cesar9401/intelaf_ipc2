
package com.intelaf.controller;

import com.intelaf.conexion.Conexion;
import com.intelaf.dao.*;
import com.intelaf.model.*;
import com.intelaf.view.*;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.*;

/**
 *
 * @author cesar31
 */
public class MainControl {
    
    private java.sql.Date date;
    private List<Tienda> tiendas;
    private Login login;
    private MainView mainView;
    private IntelafModal modal;    
    
    public MainControl() {
        iniciarComponentes();
    }
    
    private void iniciarComponentes() {
        TiendaDAO storeOp = new TiendaDAO();
        tiendas = storeOp.getTiendas();
    }
    
    public void showLogin() {
        List<String> codigos = new ArrayList<>();
        
        tiendas.forEach((t) -> {
            codigos.add(t.getCodigo());
        });
        login = new Login();
        login.initializeComponents(this, codigos);
        login.setLocationRelativeTo(null);
        login.setVisible(true);
    }
    
    public void iniciarSesion(String codigo, boolean empleado, String codigoTienda) {
        if(empleado) {
            EmpleadoDAO opeE = new EmpleadoDAO();
            Empleado e = opeE.getEmpleado(codigo);
            if(e != null) {
                //Mostrar ventana principal para empleados
                TiendaDAO opeT = new TiendaDAO();
                Tienda t = opeT.getTienda(codigoTienda);
                System.out.println(e.toString());
                System.out.println(t.toString());
                
                mainView = new MainView();
                mainView.initializeComponents(this, t, e);
                login.setVisible(false);
                login.dispose();
                mainView.setLocationRelativeTo(null);
                mainView.setVisible(true);
                
            } else {
                //Enviar codigo incorrecto a ventana login
                crearAlerta("Error", "Codigo Incorrecto", login);
            }
        } else {
            System.out.println("Cliente " + codigo);
            ClienteDAO opeC = new ClienteDAO();
            Cliente c = opeC.getCliente(codigo);
            if(c != null) {
                //Mostrar ventana principal para clientes
                System.out.println(c.toString());
                
            } else {
                crearAlerta("Advertencia", "El nit ingresado es incorrecto", login);
            }
        }
    }
        
    public void modalOperacionesCliente(List<Producto> productosCliente, double total) {
        modal = new IntelafModal(mainView, true);
        modal.initializeControl(this);
        modal.setLocationRelativeTo(null);
        modal.setResizable(false);
        modal.initOperationCliente(this, productosCliente ,total);
        modal.setVisible(true);
    }
    
    /**
     * Metodo para procesar una venta de productos
     * @param cliente
     * @param nuevo
     * @param descuento
     * @param productos 
     * @param total 
     */
    public void procesarVenta(Cliente cliente, boolean nuevo, double descuento, double total, List<Producto> productos) {
        //Write your code here
        Venta venta = new Venta(0, cliente.getNit(), this.date, total, descuento);
        List<DetalleVenta> detalles = new ArrayList<>();
        
        productos.forEach((p) -> {
            detalles.add(new DetalleVenta(p.getTiendasProductosId(), p.getStock(), p.getPrecio(), p.getSubTotal()));
        });
        
        double credito = descuento * -1;
        setNewVenta(cliente, credito, venta, detalles, nuevo);
    }
    
    private void setNewVenta(Cliente cliente, double credito, Venta venta, List<DetalleVenta> detalles, boolean nuevo) {
        Connection conexion = null;
        try {
            conexion = Conexion.getConnection();
            conexion.setAutoCommit(false);
            ClienteDAO setC = new ClienteDAO(conexion);
            if(nuevo) {
                setC.insertarCliente(cliente);
            }else {
                setC.updateCliente(cliente, credito);
            }
            
            VentaDAO setV = new VentaDAO(conexion);
            setV.insertarVenta(venta);
            
            for(DetalleVenta d: detalles) {
                setV.insertarDetalleVenta(venta, d);
            }
            
            conexion.commit();
            //Venta Procesada
            this.closeModal();
            this.crearAlerta("Informacion", "La venta ha sido procesada por un total de Q." + venta.getTotalVenta() , mainView);
            mainView.actualizarVentas();
            
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
            try {
                conexion.rollback();
            } catch (SQLException ex1) {
                ex1.printStackTrace(System.out);
            }
        }
    }
    
    public void closeModal() {
        modal.dispose();
    }
    
    public void crearAlerta(String titulo, String mensaje, java.awt.Frame parent) {
        IntelafAlerta alert = new IntelafAlerta((parent != null) ? parent : mainView, true);
        alert.setTitulo(titulo);
        alert.setMensaje(mensaje);
        alert.setVisible(true);
    }
    
    public void cerrarSesion() {
        this.mainView.setVisible(false);
        mainView.dispose();
        showLogin();
    }
    
    public List<Empleado> getEmpleados() {
        EmpleadoDAO operE = new EmpleadoDAO();
        return operE.getListEmpleado();
    }
    
    public List<Cliente> getClientes() {
        ClienteDAO operC = new ClienteDAO();
        return operC.getListCliente();
    }
    
    public List<Tienda> getTiendas() {
        TiendaDAO operT = new TiendaDAO();
        return operT.getTiendas();
    }
    
    public Cliente getCliente(String nit) {
        ClienteDAO operaciones = new ClienteDAO();
        Cliente cliente = operaciones.getCliente(nit);
        return cliente;
    }
    
    public List<Producto> getProductosTienda(String codigo) {
        ProductoDAO operaciones = new ProductoDAO();
        List<Producto> productos = operaciones.getListProductobyStore(codigo);
        return productos;
    }

    public java.sql.Date getDate() {
        return date;
    }

    public void setDate(java.sql.Date date) {
        this.date = date;
    }
}
