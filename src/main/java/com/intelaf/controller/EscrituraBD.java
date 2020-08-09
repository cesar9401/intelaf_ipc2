
package com.intelaf.controller;

import com.intelaf.conexion.Conexion;
import com.intelaf.dao.ClienteDAO;
import com.intelaf.dao.EmpleadoDAO;
import com.intelaf.dao.ProductoDAO;
import com.intelaf.dao.TiempoDAO;
import com.intelaf.dao.TiendaDAO;
import com.intelaf.model.*;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author cesar31
 */
public class EscrituraBD {
    
    List<Tienda> tiendas;
    List<Tiempo> tiempos;
    List<Producto> productos;
    List<Empleado> empleados;
    List<Cliente> clientes;
    List<Pedido> pedidos;
    
    public EscrituraBD(List<Tienda> tiendas, List<Tiempo> tiempos, List<Producto> productos, List<Empleado> empleados, List<Cliente> clientes, List<Pedido> pedidos) {
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
            tiendas.forEach((t) -> {
                setTiendas.insertarTienda(t);
                setTiendas.insertarDestino(t);
                System.out.println(t.toString());
            });
            
            TiempoDAO setTiempos = new TiempoDAO(conexion);
            tiempos.forEach((t) -> {
                setTiempos.insertarTiempo(t);
                System.out.println(t.toString());
            });
            
            ProductoDAO setProducto = new ProductoDAO(conexion);
            productos.forEach((p) -> {
                setProducto.insertarProductos(p);
                System.out.println(p.toString());
            });
            
            EmpleadoDAO setEmpleados = new EmpleadoDAO(conexion);
            empleados.forEach((e) -> {
                setEmpleados.insertarEmpleado(e);
                System.out.println(e.toString());
            });
            
            ClienteDAO setClientes = new ClienteDAO(conexion);
            clientes.forEach((c) -> {
                setClientes.insertarCliente(c);
                System.out.println(c.toString());
            });
            
            conexion.commit();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
            try {
                conexion.rollback();
            } catch (SQLException ex1) {
                ex1.printStackTrace(System.out);
            }
        }
    }
}
