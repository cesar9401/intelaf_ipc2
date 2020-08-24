
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
    private ProcesarPedidoModal procesarPedido;
  
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
    
    public void modalOperacionesPedido(List<Producto> productosC, double total, double min, Tiempo tiempo) {
        modal = new IntelafModal(mainView, true);
        modal.initializeControl(this);
        modal.initOperationPedido(productosC, total, min, tiempo);
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
    
    public void modalOperacionesTiempo(Tienda tienda) {
        modal = new IntelafModal(mainView, true);
        modal.initializeControl(this);
        modal.initOperationTiempo(tienda);
        modal.setVisible(true);
    }
    
    public void modalOperacionesProducto(Producto producto) {
        modal = new IntelafModal(mainView, true);
        modal.initializeControl(this);
        modal.initOperationProducto(producto);
        modal.setVisible(true);
    }
    
    public void modalOperacionesProductoStock(Producto producto) {
        modal = new IntelafModal(mainView, true);
        modal.initializeControl(this);
        modal.initOperationStockProducto(producto);
        modal.setVisible(true);
    }
    
    public void modalOperacionesProductoStock(String codigoTienda) {
        modal = new IntelafModal(mainView, true);
        modal.initializeControl(this);
        modal.initOperationStockProducto(codigoTienda);
        modal.setVisible(true);    
    }
    
    public void initProcesarPedidoModal(Pedido pedido, boolean isHoy, boolean isProcesar) {
        procesarPedido = new ProcesarPedidoModal(mainView, true);
        procesarPedido.initializeControl(this, pedido, isHoy, isProcesar);
        procesarPedido.setVisible(true);
    }
    
    public void closeProcesarPedido() {
        procesarPedido.dispose();
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
    
    /**
     * Metodo para insertar una nueva venta e ingresar un cliente nuevo o actualizar alguno que ya este en la base
     * de datos, segun los parametros que reciba
     * 
     * @param cliente
     * @param credito
     * @param venta
     * @param detalles
     * @param nuevo 
     */
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
            
            //Insertar detalle ventas y actualizar existencias en tienda
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
    
    public void procesarPedido(Cliente cliente, boolean nuevo, double total, double credito, double efectivo, Tiempo tiempo, List<Producto> productos) {
        //Crear pedido para tabla pedidos
        Pedido pedido = new Pedido(cliente.getNit(), tiempo.getTiemposId(), this.date, total, (credito + efectivo));
        
        //Listado para detallesPedidos
        List<Pedido> detalles = new ArrayList<>();
        productos.forEach((p) -> {
            detalles.add(new Pedido(p.getTiendasProductosId(), p.getCodigoProductos(), p.getStock(), p.getPrecio(), p.getSubTotal()));
        });
        
        double descuento = credito * -1;
        setNewPedido(cliente, nuevo, descuento, pedido, detalles);
    }
    
    /**
     * Metodo para insertar un nuevo pedido a la base de datos e ingresar o actualizar los datos del cliente que hace
     * dicho pedido
     * 
     * @param cliente
     * @param nuevo
     * @param descuento
     * @param pedido
     * @param detalles 
     */
    private void setNewPedido(Cliente cliente, boolean nuevo, double descuento, Pedido pedido, List<Pedido> detalles) {
        //Write your code for transaction Pedido
        Connection conexion = null;
        try {
            conexion = Conexion.getConnection();
            conexion.setAutoCommit(false);
            ClienteDAO operC = new ClienteDAO(conexion);
            if(nuevo) {
                operC.insertarCliente(cliente);
            } else {
                operC.updateCliente(cliente, descuento);
            }
            
            PedidoDAO operP = new PedidoDAO(conexion);
            int idPedido = operP.insertOrder(pedido);
            
            //Insertar detalle y actualizar existencias en tienda donde se hace el pedido
            for(Pedido d : detalles) {
                d.setId(idPedido);
                operP.insertOrderDetail(d);
            }
            
            conexion.commit();
            
            //Pedido procesado
            this.closeModal();
            double saldo = pedido.getTotalPedido() - pedido.getAnticipo();
            this.crearAlerta("Informacion", "El codigo de su pedido es: " + idPedido + ", y tiene un saldo pendiente de Q" + saldo , mainView);
            mainView.actualizarPedidos();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
            try {
                conexion.rollback();
            } catch (SQLException ex1) {
                ex.printStackTrace(System.out);
            }
        } finally {
            Conexion.close(conexion);
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
    
    public void setTiempo(Tiempo tiempo) {
        Tiempo tmp = new Tiempo(tiempo.getTiendaDestino(), tiempo.getTiendaOrigen(), tiempo.getTiempoDias());
        Connection conexion = null;
        try {
            conexion = Conexion.getConnection();
            conexion.setAutoCommit(false);
            TiempoDAO operT = new TiempoDAO(conexion);
            operT.insertarTiempo(tiempo);
            operT.insertarTiempo(tmp);
            conexion.commit();
            updateTablesTiempos(tiempo);
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
    
    /**
     * Metodo para insertar productos nuevos a la tabla productos
     * @param producto 
     */
    public void insertProduct(Producto producto) {
        ProductoDAO operP = new ProductoDAO();
        operP.insertProduct(producto);
        
        this.crearAlerta("Informacion", "Se ha agregado exitosamente el producto " + producto.getCodigoProductos(), mainView);
        this.closeModal();
        mainView.actualizarProductos();        
    }
    
    public void insertStockProducto(Producto producto) {
        ProductoDAO operP = new ProductoDAO();
        operP.insertStockProductos(producto);
        
        //Actualizar tabla de tienda
        this.mainView.updateDataStore();
        this.crearAlerta("Informacion", "Se ha ingresado correctamente " + producto.getStock() + " articulos del producto " + producto.getCodigoProductos(), mainView);
        this.closeModal();
        this.modalOperacionesProductoStock(producto.getCodigoTienda());
    }
    
    /**
     * Metodo para actualizar informacion de los productos en la base de datos
     * @param producto 
     */
    public void updateProductos(Producto producto) {
        ProductoDAO operP = new ProductoDAO();
        operP.updateProducto(producto);
        
        this.crearAlerta("Informacion", "Se ha actualizado correctamente el producto " + producto.getCodigoProductos(), mainView);
        this.closeModal();
        mainView.actualizarProductos();
    }
    
    public int updatStockProduct(Producto producto) {
        ProductoDAO operP = new ProductoDAO();
        return operP.updateStockProductos(producto);
    }
    
    public void setUpdateTiempo(Tiempo tiempo) {
        Tiempo tmp = new Tiempo(tiempo.getTiendaDestino(), tiempo.getTiendaOrigen(), tiempo.getTiempoDias());
        Connection conexion = null;
        try {
            conexion = Conexion.getConnection();
            conexion.setAutoCommit(false);
            TiempoDAO operT = new TiempoDAO();
            operT.updateTiempo(tiempo);
            operT.updateTiempo(tmp);
            conexion.commit();
            updateTablesTiempos(tiempo);
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
    
    private void updateTablesTiempos(Tiempo tiempo) {

        //Write code for update Store
        this.crearAlerta("Informacion", "Se ha actualizado correctamente el tiempo a: " + tiempo.getTiempoDias(), mainView);
        this.closeModal();
        Tienda tmp = getTienda(tiempo.getTiendaOrigen());
        this.modalOperacionesTiempo(tmp);
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
    
    public void updatePedidoInStore(Pedido pedido) {
        PedidoDAO operP = new PedidoDAO();
        operP.updatePedidoInStore(pedido);
        
        //Write your code for update data on view
        this.crearAlerta("Informacion", "Se ha procesado existosamente el pedido No. " + pedido.getId(), mainView);
        this.closeProcesarPedido();
        this.mainView.updateDataRegistro();
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
    
    public List<Producto> getProductos() {
        ProductoDAO operP = new ProductoDAO();
        return operP.getListProducto();
    }
    
    public Producto getProducto(String codigo) {
        ProductoDAO operP = new ProductoDAO();
        return operP.getProducto(codigo);
    }
    
    public List<Tienda> getTiendas() {
        TiendaDAO operT = new TiendaDAO();
        return operT.getTiendas();
    }
    
    public List<Tienda> getTiendasExcept(String codigo) {
        TiendaDAO operT = new TiendaDAO();
        return operT.getTiendasExcept(codigo);
    }
    
    public List<Tienda> getTiendasWithTime(String codigo) {
        TiendaDAO operT = new TiendaDAO();
        return operT.getTiendasWithTime(codigo);
    }
    
    public Tiempo getTiempo(String origen, String destino) {
        TiempoDAO operT = new TiempoDAO();
        return operT.getTiempo(origen, destino);
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
    
    public List<Producto> getListProductsNotInStore(String codigoTienda) {
        ProductoDAO operP = new ProductoDAO();
        return operP.getListProductsNotInStore(codigoTienda);
    }
    
    public Tienda getTienda(String codigo) {
        TiendaDAO operT = new TiendaDAO();
        return operT.getTienda(codigo);
    }
    
    public List<Producto> getDetallesPedidoById(int idPedido) {
        PedidoDAO operP = new PedidoDAO();
        return operP.getDetallesPedidoById(idPedido);
    }
    
    public List<Pedido> getOrderByArrivalDate(java.sql.Date date, boolean hoy) {
        PedidoDAO operP = new PedidoDAO();
        return operP.getOrderByArrivalDate(date, hoy);
    }

    public java.sql.Date getDate() {
        return date;
    }

    public void setDate(java.sql.Date date) {
        this.date = date;
    }
}
