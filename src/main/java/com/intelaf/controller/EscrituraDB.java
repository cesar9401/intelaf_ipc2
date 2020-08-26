
package com.intelaf.controller;

import com.intelaf.conexion.Conexion;
import com.intelaf.dao.*;
import com.intelaf.model.*;
import java.sql.*;
import java.util.List;
/**
 *
 * @author cesar31
 */
public class EscrituraDB {
   
    private MainControl control;
    List<Tienda> tiendas;
    List<Tiempo> tiempos;
    List<Producto> productos;
    List<Empleado> empleados;
    List<Cliente> clientes;
    List<Pedido> pedidos;
    
    public void initializeControl(MainControl control) {
        this.control = control; 
    }
    
    
    public EscrituraDB(List<Tienda> tiendas, List<Tiempo> tiempos, List<Producto> productos, List<Empleado> empleados, List<Cliente> clientes, List<Pedido> pedidos) {
        this.tiendas = tiendas;
        this.tiempos = tiempos;
        this.productos = productos;
        this.empleados = empleados;
        this.clientes = clientes;
        this.pedidos = pedidos;
    }
    
    public void createData() {
        Connection conexion = null;
        try {
            conexion = Conexion.getConnection();
            conexion.setAutoCommit(false);

            TiendaDAO setTiendas = new TiendaDAO(conexion);
            for(Tienda t : tiendas) {
                setTiendas.insertarTienda(t);
                setTiendas.insertarDestino(t);
            }
            
            TiempoDAO setTiempos = new TiempoDAO(conexion);
            for(Tiempo t : tiempos) {
                setTiempos.insertarTiempo(t);
            }
            
            ProductoDAO setProducto = new ProductoDAO(conexion);
            for(Producto p : productos) {
                setProducto.insertarProductos(p);
            }
            
            EmpleadoDAO setEmpleados = new EmpleadoDAO(conexion);
            for(Empleado e : empleados) {
                setEmpleados.insertarEmpleado(e);
            }
            
            ClienteDAO setClientes = new ClienteDAO(conexion);
            for(Cliente c : clientes) {
                setClientes.insertarCliente(c);
            }
            
            PedidoDAO setPedidos = new PedidoDAO(conexion);
            for(Pedido p : pedidos) {
                setPedidos.insertarPedido(p);
            }
            
            conexion.commit();
            control.cargaCompleta();
            
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
            try {
                conexion.rollback();
                control.cargaIncompleta();
            } catch (SQLException ex1) {
                ex1.printStackTrace(System.out);
            }
        }
    }
}
