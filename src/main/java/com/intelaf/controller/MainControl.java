
package com.intelaf.controller;

import com.intelaf.conexion.Conexion;
import com.intelaf.dao.*;
import com.intelaf.model.*;
import com.intelaf.view.*;
import java.sql.*;
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
    }
    
    private void iniciarComponentes() {
        TiendaDAO storeOp = new TiendaDAO();
        tiendas = storeOp.getTiendas();
    }
    
    public void showLogin() {
        iniciarComponentes();
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
                if(this.date == null) {
                    setInitialDate();
                 }
                
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
    
    private void setInitialDate() {
        java.util.Date fecha = new java.util.Date();
        java.sql.Date today = new java.sql.Date(fecha.getTime());
        setDate(today);
        this.crearAlerta("Informacion", "La fecha actual es: " + getDate(), mainView);
    }
        
    public void modalOperacionesCliente(List<Producto> productosCliente, double total) {
        modal = new IntelafModal(mainView, true);
        modal.initializeControl(this);
        modal.initOperationCliente(productosCliente ,total);
        modal.setVisible(true);
    }
    
    public void modalOperacionesUsuario(boolean isEmpleado, Empleado empleado, Cliente cliente) {
        modal = new IntelafModal(mainView, true);
        modal.initializeControl(this);
        modal.initOperationUsuario(isEmpleado, empleado, cliente);
        modal.setVisible(true);
    }
    
    public void modalOperacionesTienda(Tienda tienda) {
        modal = new IntelafModal(mainView, true);
        modal.initializeControl(this);
        modal.initOperationTienda(tienda);
        modal.setVisible(true);
    }
    
    public void closeModal() {
        modal.dispose();
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
            int id = setV.insertarVenta(venta);
            
            for(DetalleVenta d: detalles) {
                d.setIdVentas(id);
                setV.insertarDetalleVenta(d);
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
    
    public void setEmpleado(Empleado empleado) {
        EmpleadoDAO operE = new EmpleadoDAO();
        int row = operE.createEmpleado(empleado);
        updateViewUsuarios(row, "Se ha ingresado correctamente al empleado: " + empleado.getCodigo());
    }
    
    public void setCliente(Cliente cliente) {
        ClienteDAO operC = new ClienteDAO();
        int row = operC.createCliente(cliente);
        updateViewUsuarios(row, "Se ha ingresado correctamente al cliente: " + cliente.getNit());
    }
    
    public void setTienda(Tienda tienda) {
        Connection conexion = null;
        try {
            conexion = Conexion.getConnection();
            conexion.setAutoCommit(false);
            TiendaDAO operT = new TiendaDAO();
            operT.insertarTienda(tienda);
            operT.insertarDestino(tienda);
            conexion.commit();
            
            this.closeModal();
            this.crearAlerta("Informacion", "Se ha agregado exitosamente a la tienda: " + tienda.getCodigo(), mainView);
            mainView.actualizarTiendas();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
            try {
                conexion.rollback();
            } catch (SQLException ex1) {
                ex1.printStackTrace(System.out);
            }
        } finally {
            Conexion.close(conexion);
        }
    }
    
    public void setUpdateEmpleado(Empleado empleado) {
        EmpleadoDAO operE = new EmpleadoDAO();
        int row = operE.updateEmpleado(empleado);
        updateViewUsuarios(row, "Se actualizo al empleado: " + empleado.getCodigo());
    }
    
    public void setUpdateCliente(Cliente cliente) {
        ClienteDAO operC = new ClienteDAO();
        int row = operC.updateClienteEx(cliente, 0);
        updateViewUsuarios(row, "Se actualizo al cliente: " + cliente.getNit());
    }
    
    
    private void updateViewUsuarios(int row, String message) {
        if(row > 0) {
            this.closeModal();
            this.crearAlerta("Informacion", message, mainView);
            mainView.actualizarUsuarios();
        }else {
            this.closeModal();
            this.crearAlerta("Error", "Error con el sistema, intente mas tarde", mainView);
        }          
    }
    
    public void setUpdateTienda(Tienda tienda) {
        TiendaDAO operT = new TiendaDAO();
        int row = operT.updateTienda(tienda);
        
        if(row > 0) {
            this.closeModal();
            this.crearAlerta("Informacion", "Se ha actualizado correctamente la informacion de tienda: " + tienda.getCodigo(), mainView);
            mainView.actualizarTiendas();
        }else {
            this.closeModal();
            this.crearAlerta("Error", "Error en el sistema, intente mas tarde", mainView);
        }
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
        return operaciones.getCliente(nit);
    }
    
    public Empleado getEmpleado(String codigo) {
        EmpleadoDAO operE = new EmpleadoDAO();
        return operE.getEmpleado(codigo);
    }
    
    public List<Producto> getProductosTienda(String codigo) {
        ProductoDAO operaciones = new ProductoDAO();
        return operaciones.getListProductobyStore(codigo);
    }
    
    public Tienda getTienda(String codigo) {
        TiendaDAO operT = new TiendaDAO();
        return operT.getTienda(codigo);
    }

    public java.sql.Date getDate() {
        return date;
    }

    public void setDate(java.sql.Date date) {
        this.date = date;
    }
}
