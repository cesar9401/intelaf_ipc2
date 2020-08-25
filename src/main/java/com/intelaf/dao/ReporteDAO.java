
package com.intelaf.dao;

import com.intelaf.conexion.Conexion;
import com.intelaf.model.*;
import java.sql.*;
import java.util.*;

/**
 *
 * @author cesar31
 */
public class ReporteDAO {
    
    /**
     * Reporte 1: Listado de todos lo pedidos que llegaran a la tienda
     * @param tiendaDestino
     * @return 
     */
    public List<Pedido> allOfTheOrders(String tiendaDestino) {
        List<Pedido> pedidos = new ArrayList<>();
        String query = "SELECT p.id, p.clientesNit, d.productosCodigo, d.cantidad, d.subTotalPedido, p.fechaPedido, p.totalPedido, p.anticipo, t.tiendasOrigen, "
                + "t.tiendasDestino, t.tiempoDias, DATE_ADD(p.fechaPedido, INTERVAL t.tiempoDias DAY) AS arrivalDate FROM pedidos AS p INNER JOIN tiempos AS t ON "
                + "p.tiemposId = t.id INNER JOIN detallesPedidos AS d on p.id = d.pedidosId WHERE p.fechaLlegada IS NULL AND "
                + "t.tiendasDestino = ? ORDER BY arrivalDate";
        
        Connection conexion = null;
        PreparedStatement getO = null;
        ResultSet rs = null;
        try {
            conexion = Conexion.getConnection();
            getO = conexion.prepareStatement(query);
            getO.setString(1, tiendaDestino);
            rs = getO.executeQuery();
            
            while(rs.next()) {
                Pedido tmp = new Pedido(rs.getInt("id"), rs.getString("clientesNit"), rs.getDate("fechaPedido"), rs.getDouble("totalPedido"), rs.getDouble("anticipo"), rs.getDate("arrivalDate"));
                tmp.setCodigoProducto(rs.getString("productosCodigo"));
                tmp.setCantidad(rs.getInt("cantidad"));
                tmp.setSubTotalPedido(rs.getDouble("subTotalPedido"));
                tmp.setTiendaOrigen(rs.getString("tiendasOrigen"));
                tmp.setTiendaDestino(rs.getString("tiendasDestino"));
                tmp.setDias(rs.getInt("tiempoDias"));
                System.out.println(tmp.toString());
                
                pedidos.add(tmp);            
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(getO);
            Conexion.close(conexion);
        }
        
        return pedidos;
    }
    
    /**
     * Reporte 2: Listado de pedidos que estan en tiempo de estar en tienda pero debe verificar su ingreso, onTime = true
     * Reporte 3: Listado de todos los pedidos atrasados que llegarán a la tienda, onTime = false
     * @param date
     * @param tiendaDestino
     * @param onTime
     * @return 
     */
    public List<Pedido>  allOfTheOrdersOnTime(java.sql.Date date , String tiendaDestino, boolean onTime) {
        List<Pedido> pedidos = new ArrayList<>();
        String time = onTime ? "=" : "<";
        String query = "SELECT * FROM (SELECT p.id, p.clientesNit, d.productosCodigo, d.cantidad, d.subTotalPedido, p.fechaPedido, p.totalPedido, p.anticipo, p.fechaLlegada, "
                + "t.tiendasOrigen, t.tiendasDestino, t.tiempoDias, DATE_ADD(p.fechaPedido, INTERVAL t.tiempoDias DAY) AS arrivalDate FROM pedidos AS p INNER JOIN tiempos AS t "
                + "ON p.tiemposId = t.id INNER JOIN detallesPedidos AS d ON p.id = d.pedidosId) AS r WHERE r.fechaLlegada IS NULL "
                + "AND r.arrivalDate " + time + " ? AND r.tiendasDestino = ? ORDER BY r.arrivalDate";
        
        Connection conexion = null;
        PreparedStatement getO = null;
        ResultSet rs = null;
        try {
            conexion = Conexion.getConnection();
            getO = conexion.prepareStatement(query);
            getO.setDate(1, date);
            getO.setString(2, tiendaDestino);
            rs = getO.executeQuery();
            
            while(rs.next()) {
                Pedido tmp = new Pedido(rs.getInt("id"), rs.getString("clientesNit"), rs.getDate("fechaPedido"), rs.getDouble("totalPedido"), rs.getDouble("anticipo"), rs.getDate("arrivalDate"));
                tmp.setCodigoProducto(rs.getString("productosCodigo"));
                tmp.setCantidad(rs.getInt("cantidad"));
                tmp.setSubTotalPedido(rs.getDouble("subTotalPedido"));
                tmp.setTiendaOrigen(rs.getString("tiendasOrigen"));
                tmp.setTiendaDestino(rs.getString("tiendasDestino"));
                tmp.setDias(rs.getInt("tiempoDias"));
                tmp.setFechaLlegada(rs.getDate("fechaLlegada"));
                
                System.out.println(tmp.toString());
                
                pedidos.add(tmp);            
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(getO);
            Conexion.close(conexion);
        }
        
        return pedidos;    
    }
    
    /**
     * Reporte 4: Listado de todos los pedidos que salieron de la tienda y estan en transito
     * @param tiendaOrigen
     * @return 
     */
    public List<Pedido> ordersInTransit(String tiendaOrigen) {
        List<Pedido> pedidos = new ArrayList<>();
        String query = "SELECT * FROM (SELECT p.id, p.clientesNit, d.productosCodigo, d.cantidad, d.subTotalPedido, p.fechaPedido, p.totalPedido, p.anticipo, "
                + "p.fechaLlegada, t.tiendasOrigen, t.tiendasDestino, t.tiempoDias, DATE_ADD(p.fechaPedido, INTERVAL t.tiempoDias DAY) AS arrivalDate FROM "
                + "pedidos AS p INNER JOIN tiempos AS t ON p.tiemposId = t.id INNER JOIN detallesPedidos AS d ON p.id = d.pedidosId) AS r WHERE "
                + "r.fechaLlegada IS NULL AND r.tiendasOrigen = ? ORDER BY r.arrivalDate;";
        
        Connection conexion = null;
        PreparedStatement getO = null;
        ResultSet rs = null;
        try {
            conexion = Conexion.getConnection();
            getO = conexion.prepareStatement(query);
            getO.setString(1, tiendaOrigen);
            rs = getO.executeQuery();
            
            while(rs.next()) {
                Pedido tmp = new Pedido(rs.getInt("id"), rs.getString("clientesNit"), rs.getDate("fechaPedido"), rs.getDouble("totalPedido"), rs.getDouble("anticipo"), rs.getDate("arrivalDate"));
                tmp.setCodigoProducto(rs.getString("productosCodigo"));
                tmp.setCantidad(rs.getInt("cantidad"));
                tmp.setSubTotalPedido(rs.getDouble("subTotalPedido"));
                tmp.setTiendaOrigen(rs.getString("tiendasOrigen"));
                tmp.setTiendaDestino(rs.getString("tiendasDestino"));
                tmp.setDias(rs.getInt("tiempoDias"));
                tmp.setFechaLlegada(rs.getDate("fechaLlegada"));
                
                System.out.println(tmp.toString());
                
                pedidos.add(tmp);            
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(getO);
            Conexion.close(conexion);
        }
        return pedidos;     
    }
    
    /**
     * Reporte 5: Listado de las compras realizadas por un cliente
     * @param nitCliente
     * @return 
     */
    public List<Producto> comprasByCliente(String nitCliente) {
        List<Producto> productos = new ArrayList<>();
        String query = "SELECT v.id, v.clientesNit, c.nombre, v.fechaVenta, p.codigo, p.nombre AS nombreProducto, d.cantidad, d.subTotal, "
                + "v.totalVenta, e.tiendasCodigo FROM ventas AS v INNER JOIN clientes AS c ON v.clientesNit = c.nit INNER JOIN "
                + "detallesVentas AS d ON v.id = d.ventasId INNER JOIN tiendasProductos AS e ON d.tiendasProductosId = e.id "
                + "INNER JOIN productos AS p ON p.codigo = e.productosCodigo WHERE v.clientesNit = ?";
        
        Connection conexion = null;
        PreparedStatement getP = null;
        ResultSet rs = null;
        try {
            conexion = Conexion.getConnection();
            getP = conexion.prepareStatement(query);
            getP.setString(1, nitCliente);
            rs = getP.executeQuery();
            
            while(rs.next()) {
                Producto tmp = new Producto(rs.getString("tiendasCodigo"), rs.getString("codigo"), rs.getInt("cantidad"));
                tmp.setNombre(rs.getString("nombreProducto"));
                tmp.setId(rs.getInt("id"));
                tmp.setClientesNit(rs.getString("clientesNit"));
                tmp.setNombreCliente(rs.getString("nombre"));
                tmp.setFechaVenta(rs.getDate("fechaVenta"));
                tmp.setSubTotal(rs.getDouble("subTotal"));
                tmp.setTotalVenta(rs.getDouble("totalVenta"));
                
                productos.add(tmp);
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(getP);
            Conexion.close(conexion);
        }        
        return productos;
    }
    
    /**
     * Reporte 6: Listado de todos los pedidos en curso de un cliente
     * @param nitCliente
     * @return 
     */
    public List<Pedido> ordersByClient(String nitCliente) {
        List<Pedido> pedidos = new ArrayList<>();
        String query = "SELECT p.id, p.clientesNit, c.nombre, d.productosCodigo, d.cantidad, d.subTotalPedido, p.fechaPedido, p.totalPedido, "
                + "p.anticipo, t.tiendasOrigen, t.tiendasDestino, t.tiempoDias, DATE_ADD(p.fechaPedido, INTERVAL t.tiempoDias DAY) AS "
                + "arrivalDate FROM pedidos AS p INNER JOIN tiempos AS t ON p.tiemposId = t.id INNER JOIN clientes AS c ON p.clientesNit = c.nit "
                + "INNER JOIN detallesPedidos AS d ON p.id = d.pedidosId WHERE p.fechaLlegada IS NULL AND "
                + "p.clientesNit = ? ORDER BY arrivalDate;";
        
        Connection conexion = null;
        PreparedStatement getO = null;
        ResultSet rs = null;
        try {
            conexion = Conexion.getConnection();
            getO = conexion.prepareStatement(query);
            getO.setString(1, nitCliente);
            rs = getO.executeQuery();
            
            while(rs.next()) {
                Pedido tmp = new Pedido(rs.getInt("id"), rs.getString("clientesNit"), rs.getDate("fechaPedido"), rs.getDouble("totalPedido"), rs.getDouble("anticipo"), rs.getDate("arrivalDate"));
                tmp.setNombreCliente(rs.getString("nombre"));
                tmp.setCodigoProducto(rs.getString("productosCodigo"));
                tmp.setCantidad(rs.getInt("cantidad"));
                tmp.setSubTotalPedido(rs.getDouble("subTotalPedido"));
                tmp.setTiendaOrigen(rs.getString("tiendasOrigen"));
                tmp.setTiendaDestino(rs.getString("tiendasDestino"));
                tmp.setDias(rs.getInt("tiempoDias"));
                
                System.out.println(tmp.toString());
                
                pedidos.add(tmp);            
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(getO);
            Conexion.close(conexion);
        }
        return pedidos;     
    }
    
    /**
     * Reporte 7: Listado de los diez productos mas vendidos en un intervalo de tiempo
     * @param dateMin
     * @param dateMax
     * @return 
     */
    public List<Producto> productosTop10ByTime(java.sql.Date dateMin, java.sql.Date dateMax) {
        List<Producto> productos = new ArrayList<>();
        String query = "SELECT e.productosCodigo, p.nombre, p.fabricante, SUM(d.cantidad) AS quantity, GROUP_CONCAT(DISTINCT e.tiendasCodigo) "
                + "AS inStore, GROUP_CONCAT(DISTINCT v.fechaVenta) AS dates FROM ventas AS v INNER JOIN detallesVentas AS d ON v.id = d.ventasId "
                + "INNER JOIN tiendasProductos AS e ON e.id = d.tiendasProductosId INNER JOIN productos AS p ON p.codigo = e.productosCodigo "
                + "WHERE v.fechaVenta BETWEEN ? AND ? GROUP BY e.productosCodigo ORDER BY quantity DESC LIMIT 10";
        
        Connection conexion = null;
        PreparedStatement getP = null;
        ResultSet rs = null;
        try {
            conexion = Conexion.getConnection();
            getP = conexion.prepareStatement(query);
            getP.setDate(1, dateMin);
            getP.setDate(2, dateMax);
            rs = getP.executeQuery();
            
            while(rs.next()) {
                Producto tmp = new Producto(rs.getString("productosCodigo"));
                tmp.setNombre(rs.getString("nombre"));
                tmp.setFabricante(rs.getString("fabricante"));
                tmp.setStock(rs.getInt("quantity"));
                tmp.setConcatInStore(rs.getString("inStore"));
                tmp.setConcatDates(rs.getString("dates"));
                
                System.out.println(tmp.getConcatDates());
                System.out.println(tmp.toString());
                productos.add(tmp);
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(getP);
            Conexion.close(conexion);
        }        
        return productos;        
    }
    
    /**
     * Reporte 7: Listado de los diez productos mas vendidos
     * @return 
     */
    public List<Producto> productosTop10() {
        List<Producto> productos = new ArrayList<>();
        String query = "SELECT e.productosCodigo, p.nombre, p.fabricante, SUM(d.cantidad) AS quantity, GROUP_CONCAT(DISTINCT e.tiendasCodigo) "
                + "AS inStore, GROUP_CONCAT(DISTINCT v.fechaVenta) AS dates FROM ventas AS v INNER JOIN detallesVentas AS d ON v.id = d.ventasId "
                + "INNER JOIN tiendasProductos AS e ON e.id = d.tiendasProductosId INNER JOIN productos AS p ON p.codigo = e.productosCodigo "
                + "GROUP BY e.productosCodigo ORDER BY quantity DESC LIMIT 10";
        
        Connection conexion = null;
        PreparedStatement getP = null;
        ResultSet rs = null;
        try {
            conexion = Conexion.getConnection();
            getP = conexion.prepareStatement(query);
            rs = getP.executeQuery();
            
            while(rs.next()) {
                Producto tmp = new Producto(rs.getString("productosCodigo"));
                tmp.setNombre(rs.getString("nombre"));
                tmp.setFabricante(rs.getString("fabricante"));
                tmp.setStock(rs.getInt("quantity"));
                tmp.setConcatInStore(rs.getString("inStore"));
                
                System.out.println(tmp.getConcatInStore());
                System.out.println(tmp.toString());
                productos.add(tmp);
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(getP);
            Conexion.close(conexion);
        }        
        return productos;        
    }
    
    /**
     * Reporte 8: Listado de los productos mas vendidos por tienda en un intervalo de tiempo
     * @param codigoTienda
     * @param min
     * @param max
     * @return 
     */
    public List<Producto> productosTopByTimeAndStore(String codigoTienda, java.sql.Date min, java.sql.Date max) {
        List<Producto> productos = new ArrayList<>();
        String query = "SELECT e.productosCodigo, p.nombre, p.fabricante, SUM(d.cantidad) AS quantity, GROUP_CONCAT(DISTINCT v.fechaVenta) "
                + "AS dates FROM ventas AS v INNER JOIN detallesVentas AS d ON v.id = d.ventasId INNER JOIN tiendasProductos AS e "
                + "ON e.id = d.tiendasProductosId INNER JOIN productos AS p ON p.codigo = e.productosCodigo "
                + "WHERE e.tiendasCodigo = ? AND v.fechaVenta BETWEEN ? AND ? GROUP BY e.productosCodigo ORDER BY quantity DESC;";
        
        Connection conexion = null;
        PreparedStatement getP = null;
        ResultSet rs = null;
        try {
            conexion = Conexion.getConnection();
            getP = conexion.prepareStatement(query);
            getP.setString(1, codigoTienda);
            getP.setDate(2, min);
            getP.setDate(3, max);
            rs = getP.executeQuery();
            
            while(rs.next()) {
                Producto tmp = new Producto(rs.getString("productosCodigo"));
                tmp.setNombre(rs.getString("nombre"));
                tmp.setFabricante(rs.getString("fabricante"));
                tmp.setStock(rs.getInt("quantity"));
                tmp.setConcatDates(rs.getString("dates"));
                
                System.out.println(tmp.getConcatDates());
                System.out.println(tmp.toString());
                productos.add(tmp);
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(getP);
            Conexion.close(conexion);
        }        
        return productos;       
    }
    
    /**
     * Reporte 8: Listado de los productos mas vendidos por tienda
     * @param codigoTienda
     * @return 
     */
    public List<Producto> productosTopByStore(String codigoTienda) {
        List<Producto> productos = new ArrayList<>();
        String query = "SELECT e.productosCodigo, p.nombre, p.fabricante, SUM(d.cantidad) AS quantity FROM ventas AS v INNER JOIN "
                + "detallesVentas AS d ON v.id = d.ventasId INNER JOIN tiendasProductos AS e ON e.id = d.tiendasProductosId INNER JOIN "
                + "productos AS p ON p.codigo = e.productosCodigo WHERE e.tiendasCodigo = ? GROUP BY e.productosCodigo ORDER BY quantity DESC;";
        
        Connection conexion = null;
        PreparedStatement getP = null;
        ResultSet rs = null;
        try {
            conexion = Conexion.getConnection();
            getP = conexion.prepareStatement(query);
            getP.setString(1, codigoTienda);
            rs = getP.executeQuery();
            
            while(rs.next()) {
                Producto tmp = new Producto(rs.getString("productosCodigo"));
                tmp.setNombre(rs.getString("nombre"));
                tmp.setFabricante(rs.getString("fabricante"));
                tmp.setStock(rs.getInt("quantity"));
                
                System.out.println(tmp.getStock());
                System.out.println(tmp.toString());
                productos.add(tmp);
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(getP);
            Conexion.close(conexion);
        }        
        return productos;    
    }
    
    /**
     * Reporte 9: Listado de productos que nunca se han vendido por tienda
     * @param codigoTienda
     * @return 
     */
    public List<Producto> neverBeenSold(String codigoTienda) {
        List<Producto> productos = new ArrayList<>();
        String query = "SELECT e.productosCodigo, p.nombre, p.fabricante, e.stockProductos, e.tiendasCodigo FROM tiendasProductos AS e "
                + "INNER JOIN productos AS p ON e.productosCodigo = p.codigo LEFT JOIN detallesVentas AS d ON e.id = d.tiendasProductosId "
                + "WHERE d.id IS NULL AND e.tiendasCodigo = ? ORDER BY e.productosCodigo";
        
        Connection conexion = null;
        PreparedStatement getP = null;
        ResultSet rs = null;
        try {
            conexion = Conexion.getConnection();
            getP = conexion.prepareStatement(query);
            getP.setString(1, codigoTienda);
            rs = getP.executeQuery();
            
            while(rs.next()) {
                Producto tmp = new Producto(rs.getString("productosCodigo"));
                tmp.setNombre(rs.getString("nombre"));
                tmp.setFabricante(rs.getString("fabricante"));
                tmp.setStock(rs.getInt("stockProductos"));
                tmp.setCodigoTienda(rs.getString("tiendasCodigo"));
                
                System.out.println(tmp.getStock());
                System.out.println(tmp.toString());
                productos.add(tmp);
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(getP);
            Conexion.close(conexion);
        }        
        return productos;    
    }    
}
