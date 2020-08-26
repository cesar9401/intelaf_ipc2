
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
    
    private ArchivosView archivos;
    private java.sql.Date date;
    private List<Tienda> tiendas;
    private Login login;
    private MainView mainView;
    private ClienteView clienteView;
    private IntelafModal modal;    
    private ProcesarPedidoModal procesarPedido;
  
    public MainControl() {
    }
    
    /**
     * Verifar si la base de datos esta vacia
     */
    public void initDB() {
        tiendas = this.getTiendas();
        if(tiendas.isEmpty()) {
            archivos = new ArchivosView();
            archivos.initializeControl(this);
            archivos.setLocationRelativeTo(null);
            archivos.setVisible(true);
        } else {
            showLogin();
        }
    }
    
    /**
     * Mensajes para estados en la carga de los archivos
     */
    public void cargaCompleta() {
        this.crearAlerta("Informacion", "Carga de datos con exito", archivos);
    }
    
    public void cargaIncompleta() {
        this.crearAlerta("Error", "Verifique que los datos esten correctos", archivos);
    }
    
    public void setDB(String line) {
        archivos.setInfo(line);
    }
    
    public void closeArchivos() {
        archivos.dispose();
    }
    
    /**
     * Para mostrar el login
     */
    public void showLogin() {
        tiendas = this.getTiendas();
        List<String> codigos = new ArrayList<>();
        
        tiendas.forEach((t) -> {
            codigos.add(t.getCodigo());
        });
        login = new Login();
        login.initializeComponents(this, codigos);
        login.setLocationRelativeTo(null);
        login.setVisible(true);
    }
    
    /**
     * Para iniciar sesion en la vista principal o del cliente
     * @param codigo
     * @param empleado
     * @param codigoTienda 
     */
    public void iniciarSesion(String codigo, boolean empleado, String codigoTienda) {
        if(empleado) {
            EmpleadoDAO opeE = new EmpleadoDAO();
            Empleado e = opeE.getEmpleado(codigo);
            if(e != null) {
                //Iniciar fecha
                if(this.date == null) {
                    setInitialDate();
                }
                
                //Mostrar ventana principal para empleados
                TiendaDAO opeT = new TiendaDAO();
                Tienda t = opeT.getTienda(codigoTienda);

                mainView = new MainView();
                mainView.initializeComponents(this, t, e);
                initCalendar();
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
                clienteView = new ClienteView();
                clienteView.initializeControl(this, c);
                login.setVisible(false);
                login.dispose();
                clienteView.setLocationRelativeTo(null);
                clienteView.setVisible(true);
                
            } else {
                crearAlerta("Advertencia", "El nit ingresado es incorrecto", login);
            }
        }
    }
    
    //Establecer la fecha en el calendario
    private void initCalendar() {
        java.util.Date fecha = new java.util.Date(getDate().getTime());
        mainView.initCalendar(fecha);
    }
    
    private void setInitialDate() {
        java.util.Date fecha = new java.util.Date();
        java.sql.Date today = new java.sql.Date(fecha.getTime());
        setDate(today);
    }
        
    /**
     * Modales para las distintas interacciones con los datos del cliente
     * @param productosCliente
     * @param total 
     */
    public void modalOperacionesCliente(List<Producto> productosCliente, double total) {
        modal = new IntelafModal(mainView, true);
        modal.initializeControl(this);
        modal.initOperationCliente(productosCliente ,total);
        modal.setVisible(true);
    }
    
    /**
     * Modal para informacion del cliente cuando se hace un pedido
     * @param productosC
     * @param total
     * @param min
     * @param tiempo 
     */
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
    
    /**
     * Modal para informacion de las tiendas
     * @param tienda 
     */
    public void modalOperacionesTienda(Tienda tienda) {
        modal = new IntelafModal(mainView, true);
        modal.initializeControl(this);
        modal.initOperationTienda(tienda);
        modal.setVisible(true);
    }
    
    /**
     * Para editar tiempos
     * @param tienda 
     */
    public void modalOperacionesTiempo(Tienda tienda) {
        modal = new IntelafModal(mainView, true);
        modal.initializeControl(this);
        modal.initOperationTiempo(tienda);
        modal.setVisible(true);
    }
    
    /**
     * Para registro de productos
     * @param producto 
     */
    public void modalOperacionesProducto(Producto producto) {
        modal = new IntelafModal(mainView, true);
        modal.initializeControl(this);
        modal.initOperationProducto(producto);
        modal.setVisible(true);
    }
    
    /**
     * Para agregar stock
     * @param producto 
     */
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
    
    /**
     * Para entregar pedidos
     * @param pedido
     * @param cliente 
     */
    public void modalOperacionesDeliverOrder(Pedido pedido, Cliente cliente) {
        modal = new IntelafModal(mainView, true);
        modal.initializeControl(this);
        modal.initOperationDeliverOrder(pedido, cliente);
        modal.setVisible(true);
    }

    /**
     * Para detalles de pedidos
     * @param pedido
     * @param isATiempo
     * @param isProcesar 
     */
    public void initProcesarPedidoModal(Pedido pedido, boolean isATiempo, boolean isProcesar) {
        procesarPedido = new ProcesarPedidoModal(mainView, true);
        procesarPedido.initializeControl(this, pedido, isATiempo, isProcesar);
        procesarPedido.setVisible(true);
    }
    
    /**
     * Para cerrar los modales
     */
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
    
    /**
     * Recibe la informacion del pedido y la procesar para enviar a la base de datos
     * @param cliente
     * @param nuevo
     * @param total
     * @param credito
     * @param efectivo
     * @param tiempo
     * @param productos 
     */
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
    
    /**
     * Para entregar pedidos a los clientes y procesarlo como una venta
     * @param pedido
     * @param cliente
     * @param descuento 
     */
    public void procesarPedidoHaciaVenta(Pedido pedido, Cliente cliente, double descuento) {
        //Crear objeto para insertar en la tabla ventas
        Venta venta = new Venta(pedido.getId(), cliente.getNit(), this.getDate(), pedido.getTotalPedido(), descuento);
        Connection conexion = null;
        try {
            conexion = Conexion.getConnection();
            conexion.setAutoCommit(false);

            //Actualizar estado de pedido
            PedidoDAO operP = new PedidoDAO(conexion);
            operP.updatePedidoInStore(pedido);

            //Insertar venta
            VentaDAO operV = new VentaDAO(conexion);
            operV.inserVentaFromOrder(venta);
            
            //Actualizar informacion del cliente
            ClienteDAO operC = new ClienteDAO(conexion);
            operC.updateCliente(cliente, cliente.getCreditoCompra());

            conexion.commit();
            
            //Se hizo commit, actualizar informacion en tablas
            this.closeModal();
            this.closeProcesarPedido();
            this.crearAlerta("Informacion", "Se proceso con exito el pedido " + pedido.getId(), mainView);
            this.mainView.updateDataRegistro();
            
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
     * Metodos para ingresar empleados a la base de datos
     * @param empleado 
     */
    public void setEmpleado(Empleado empleado) {
        EmpleadoDAO operE = new EmpleadoDAO();
        int row = operE.createEmpleado(empleado);
        updateViewUsuarios(row, "Se ha ingresado correctamente al empleado: " + empleado.getCodigo());
    }
    
    /**
     * Ingresar clientes a la base de datos
     * @param cliente 
     */
    public void setCliente(Cliente cliente) {
        ClienteDAO operC = new ClienteDAO();
        int row = operC.createCliente(cliente);
        updateViewUsuarios(row, "Se ha ingresado correctamente al cliente: " + cliente.getNit());
    }
    
    /**
     * Almacenar ventas en la base de datos
     * @param tienda 
     */
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
    
    /**
     * Metodo para ingresar tiempos a la base de datos
     * @param tiempo 
     */
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
    
    /**
     * Agregar un nuevo producto que ya este en el inventario general
     * @param producto 
     */
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
    
    /**
     * Agregar stock de un producto
     * @param producto
     * @return 
     */
    public int updatStockProduct(Producto producto) {
        ProductoDAO operP = new ProductoDAO();
        return operP.updateStockProductos(producto);
    }
    
    /**
     * Actualizar tiempo entre tiendas
     * @param tiempo 
     */
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
    
    /**
     * Actualizar informacion en las tablas del usuario
     * @param tiempo 
     */
    private void updateTablesTiempos(Tiempo tiempo) {
        //Write code for update Store
        this.crearAlerta("Informacion", "Se ha actualizado correctamente el tiempo a: " + tiempo.getTiempoDias(), mainView);
        this.closeModal();
        Tienda tmp = getTienda(tiempo.getTiendaOrigen());
        this.modalOperacionesTiempo(tmp);
    }
    
    /**
     * Actualizar empleado y cliente
     * @param empleado 
     */
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
    
    /**
     * Actualizar vistas de clientes y usuarios
     * @param row
     * @param message 
     */
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
    
    /**
     * Actualizar informacion de una tienda
     * @param tienda 
     */
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
    
    /**
     * Procesar pedidos
     * @param pedido 
     */
    public void updatePedidoInStore(Pedido pedido) {
        PedidoDAO operP = new PedidoDAO();
        operP.updatePedidoInStoreEx(pedido);
        
        //Write your code for update data on view
        this.crearAlerta("Informacion", "Se ha procesado existosamente el pedido No. " + pedido.getId(), mainView);
        this.closeProcesarPedido();
        this.mainView.updateDataRegistro();
    }
    
    /**
     * Para mostrar las distinas alertas que puedan necesitarse
     * @param titulo
     * @param mensaje
     * @param parent 
     */
    public void crearAlerta(String titulo, String mensaje, java.awt.Frame parent) {
        IntelafAlerta alert = new IntelafAlerta((parent != null) ? parent : mainView, true);
        alert.setTitulo(titulo);
        alert.setMensaje(mensaje);
        alert.setVisible(true);
    }
    
    /**
     * Metodo para cerrar sesion del cliente
     */
    public void cerrarSesionCliente() {
        this.clienteView.setVisible(false);
        clienteView.dispose();
        showLogin();
    }
    
    /**
     * Cerrar sesion del empleado
     */
    public void cerrarSesion() {
        this.mainView.setVisible(false);
        mainView.dispose();
        showLogin();
    }
    
    /**
     * Obtener elementos de la base de datos
     * @return 
     */
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
    
    public List<Pedido> getOrderByArrivalDate(java.sql.Date date, boolean hoy, String codigoTienda) {
        PedidoDAO operP = new PedidoDAO();
        return operP.getOrderByArrivalDate(date, hoy, codigoTienda);
    }
    
    public List<Pedido> getOrderByCliente(String nitCliente) {
        PedidoDAO operP = new PedidoDAO();
        return operP.getOrderByCliente(nitCliente);
    }
    
    public List<Pedido> getListPedidoByDelivered(String codigoTienda, boolean entregado) {
        PedidoDAO operP = new PedidoDAO();
        return operP.getListPedidoByDelivered(codigoTienda, entregado);
    }

    /**
     * Fecha para el manejo de operaciones
     * @return 
     */
    public java.sql.Date getDate() {
        return date;
    }

    public void setDate(java.sql.Date date) {
        this.date = date;
    }
}
