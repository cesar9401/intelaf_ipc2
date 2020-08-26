
package com.intelaf.dao;

import com.intelaf.conexion.Conexion;
import com.intelaf.model.*;
import java.sql.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author cesar31
 */
public class PedidoDAO {
    
    private Connection transaction;

    public PedidoDAO() {
    }

    public PedidoDAO(Connection transaction) {
        this.transaction = transaction;
    }
    
    /**
     * Metodo para insertar pedidos a la base de datos desde la carga de archivo
     * @param pedido
     * @throws SQLException 
     */
    public void insertarPedido(Pedido pedido) throws SQLException {
        String queryPedido = "INSERT INTO pedidos(id, clientesNit, tiemposId, fechaPedido, totalPedido, anticipo) "
                + "VALUES (?, ?, "
                + "(SELECT id FROM tiempos WHERE tiendasOrigen = ? AND tiendasDestino = ? LIMIT 1)"
                + ", ?, ?, ?)"
                + " ON DUPLICATE KEY UPDATE totalPedido = totalPedido + ?";
        
        String queryDetallePedido = "INSERT INTO detallesPedidos(pedidosId, productosCodigo, cantidad, subTotalPedido) VALUES(?, ?, ?, ?)";
        
        Connection conexion = null;
        PreparedStatement setPedido = null;
        PreparedStatement setDetalleP = null;
        
        try {
            conexion = (this.transaction != null) ? this.transaction : Conexion.getConnection();

            setPedido = conexion.prepareStatement(queryPedido);
            setPedido.setInt(1, pedido.getId());
            setPedido.setString(2, pedido.getNitCliente());
            setPedido.setString(3, pedido.getTiendaOrigen());
            setPedido.setString(4, pedido.getTiendaDestino());
            setPedido.setDate(5, pedido.getFechaPedido());
            setPedido.setDouble(6, pedido.getSubTotalPedido());
            setPedido.setDouble(7, pedido.getAnticipo());
            setPedido.setDouble(8, pedido.getSubTotalPedido());
            setPedido.executeUpdate();
                
            setDetalleP = conexion.prepareStatement(queryDetallePedido);
            setDetalleP.setInt(1, pedido.getId());
            setDetalleP.setString(2, pedido.getCodigoProducto());
            setDetalleP.setInt(3, pedido.getCantidad());
            setDetalleP.setDouble(4, pedido.getSubTotalPedido());
            setDetalleP.executeUpdate();
            
        } finally {
            Conexion.close(setDetalleP);
            Conexion.close(setPedido);
            if(this.transaction == null) {
                Conexion.close(conexion);
            }
        }
    }
 
    /**
     * 
     * @param pedido
     * @return
     * @throws SQLException 
     */
    public int insertOrder(Pedido pedido) throws SQLException {
        int id = 0;
        String query = "INSERT INTO pedidos(clientesNit, tiemposId, fechaPedido, totalPedido, anticipo) VALUES(?, ?, ?, ?, ?)";
        
        Connection conexion = null;
        PreparedStatement setP = null;
        ResultSet rs = null;
        try {
            conexion = (this.transaction != null) ? this.transaction : Conexion.getConnection();
            setP = conexion.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);
            setP.setString(1, pedido.getNitCliente());
            setP.setInt(2, pedido.getTiemposId());
            setP.setDate(3, pedido.getFechaPedido());
            setP.setDouble(4, pedido.getTotalPedido());
            setP.setDouble(5, pedido.getAnticipo());
            setP.executeUpdate();
            
            rs = setP.getGeneratedKeys();
            if(rs.next()) {
                id = rs.getInt(1);
            }

        } finally {
            Conexion.close(rs);
            Conexion.close(setP);
            if(this.transaction == null) {
                Conexion.close(conexion);
            }
        }
        return id;
    }
    
    public void insertOrderDetail(Pedido pedido) throws SQLException {
        String queryExistencias = "UPDATE tiendasProductos SET stockProductos = stockProductos - ? WHERE id = ?";
        String query = "INSERT INTO detallesPedidos(pedidosId, productosCodigo, cantidad, precioVentaPedido, subTotalPedido) VALUES(?, ?, ?, ?, ?)";
        
        Connection conexion = null;
        PreparedStatement setE = null;
        PreparedStatement setD = null;
        try {
            conexion = (this.transaction != null) ? this.transaction : Conexion.getConnection();
            
            setE = conexion.prepareStatement(queryExistencias);
            setE.setInt(1, pedido.getCantidad());
            setE.setInt(2, pedido.getTiendasProductosId());
            setE.executeUpdate();
            
            setD = conexion.prepareStatement(query);
            setD.setInt(1, pedido.getId());
            setD.setString(2, pedido.getCodigoProducto());
            setD.setInt(3, pedido.getCantidad());
            setD.setDouble(4, pedido.getPrecioVentaPedido());
            setD.setDouble(5, pedido.getSubTotalPedido());
            setD.executeUpdate();
        } finally {
            Conexion.close(setD);
            Conexion.close(setE);
            if(this.transaction == null) {
                Conexion.close(conexion);
            }
        }
    }
    
    /**
     * Obtener pedidos segun la fecha de llegada y tienda de Destino
     * @param date
     * @param hoy
     * @param codigoTienda
     * @return 
     */
    public List<Pedido> getOrderByArrivalDate(java.sql.Date date, boolean hoy, String codigoTienda) {
        List<Pedido> pedidos = new ArrayList<>();
        String tiempo = (hoy ? "=" : "<");
        
        String query = "SELECT * FROM (SELECT p.id, p.clientesNit, p.fechaPedido, p.totalPedido, p.anticipo, p.fechaLlegada, t.tiendasOrigen, t.tiendasDestino, t.tiempoDias, "
                + "DATE_ADD(p.fechaPedido, INTERVAL t.tiempoDias DAY) AS arrivalDate FROM pedidos AS p INNER JOIN tiempos AS t ON p.tiemposId = t.id) AS r "
                + "WHERE r.fechaLlegada IS NULL AND r.arrivalDate " + tiempo + " ? AND r.tiendasDestino = ? ORDER BY r.arrivalDate";
        
        Connection conexion = null;
        PreparedStatement getP = null;
        ResultSet rs = null;
        try {
            conexion = Conexion.getConnection();
            getP = conexion.prepareStatement(query);
            getP.setDate(1, date);
            getP.setString(2, codigoTienda);
            rs = getP.executeQuery();
            
            while(rs.next()) {
                Pedido tmp = new Pedido(rs.getInt("id"), rs.getString("clientesNit"), rs.getDate("fechaPedido"), rs.getDouble("totalPedido"), rs.getDouble("anticipo"), rs.getDate("arrivalDate"));
                tmp.setTiendaOrigen(rs.getString("tiendasOrigen"));
                tmp.setTiendaDestino(rs.getString("tiendasDestino"));
                tmp.setDias(rs.getInt("tiempoDias"));
                
                pedidos.add(tmp);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(getP);
            Conexion.close(conexion);
        }
        
        return pedidos;
    }
    
    public List<Pedido> getOrderByCliente(String nitCliente) {
        List<Pedido> pedidos = new ArrayList<>();
        
        String query = "SELECT * FROM (SELECT p.id, p.clientesNit, p.fechaPedido, p.totalPedido, p.anticipo, p.fechaLlegada, t.tiendasOrigen, t.tiendasDestino, t.tiempoDias, "
                + "DATE_ADD(p.fechaPedido, INTERVAL t.tiempoDias DAY) AS arrivalDate FROM pedidos AS p INNER JOIN tiempos AS t ON p.tiemposId = t.id) AS r "
                + "WHERE r.fechaLlegada IS NULL AND r.clientesNit = ?ORDER BY r.arrivalDate";
        
        Connection conexion = null;
        PreparedStatement getP = null;
        ResultSet rs = null;
        try {
            conexion = Conexion.getConnection();
            getP = conexion.prepareStatement(query);
            getP.setString(1, nitCliente);
            rs = getP.executeQuery();
            
            while(rs.next()) {
                Pedido tmp = new Pedido(rs.getInt("id"), rs.getString("clientesNit"), rs.getDate("fechaPedido"), rs.getDouble("totalPedido"), rs.getDouble("anticipo"), rs.getDate("arrivalDate"));
                tmp.setTiendaOrigen(rs.getString("tiendasOrigen"));
                tmp.setTiendaDestino(rs.getString("tiendasDestino"));
                tmp.setDias(rs.getInt("tiempoDias"));
                
                pedidos.add(tmp);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(getP);
            Conexion.close(conexion);
        }
        return pedidos;
    }    
    
    /**
     * Obtener los detalles de cada pedido(Productos) segun el id del pedido
     * @param pedidoId
     * @return 
     */
    public List<Producto> getDetallesPedidoById(int pedidoId) {
        List<Producto> detallesPedido = new ArrayList<>();
        String query = "SELECT p.codigo, p.nombre, p.fabricante, d.cantidad, d.subTotalPedido FROM productos AS p INNER JOIN "
                + "(SELECT * FROM detallesPedidos WHERE pedidosId = ?) AS d ON p.codigo = d.productosCodigo ORDER BY p.codigo";
        
        Connection conexion = null;
        PreparedStatement getP = null;
        ResultSet rs = null;
        try {
            conexion = Conexion.getConnection();
            getP = conexion.prepareStatement(query);
            getP.setInt(1, pedidoId);
            rs = getP.executeQuery();
            
            while(rs.next()) {
                Producto tmp = new Producto(rs.getString("codigo"));
                tmp.setNombre(rs.getString("nombre"));
                tmp.setFabricante(rs.getString("fabricante"));
                tmp.setStock(rs.getInt("cantidad"));
                tmp.setSubTotal(rs.getDouble("subTotalPedido"));
                
                detallesPedido.add(tmp);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(getP);
            Conexion.close(conexion);
        }        
        return detallesPedido;
    }
    
    /**
     * Lista los pedidos segun la tienda de destino y segun el parametro para verifcar cuales ya fueron entregados y cuales no.
     * @param codigoTienda
     * @param entregado
     * @return 
     */
    public List<Pedido> getListPedidoByDelivered(String codigoTienda, boolean entregado) {
        List<Pedido> pedidos = new ArrayList<>();
        String query = "SELECT p.id, p.clientesNit, p.tiemposId, p.fechaPedido, p.totalPedido, p.anticipo, p.fechaLlegada, p.llegadaATiempo, p.entregado, "
                + "t.tiendasOrigen, t.tiendasDestino, t.tiempoDias FROM pedidos AS p INNER JOIN tiempos AS t ON p.tiemposId = t.id "
                + "WHERE p.fechaLlegada IS NOT NULL AND p.entregado = ? AND t.tiendasDestino = ?";
        
        Connection conexion = null;
        PreparedStatement getP = null;
        ResultSet rs = null;
        try {
            conexion = Conexion.getConnection();
            getP = conexion.prepareStatement(query);
            getP.setBoolean(1, entregado);
            getP.setString(2, codigoTienda);
            rs = getP.executeQuery();
            
            while(rs.next()) {
                Pedido tmp = new Pedido(rs.getInt("id"), rs.getString("clientesNit"), rs.getDate("fechaPedido"), rs.getDouble("totalPedido"), rs.getDouble("anticipo"), rs.getDate("fechaLlegada"), rs.getBoolean("llegadaATiempo"));
                tmp.setTiemposId(rs.getInt("tiemposId"));
                tmp.setEntregado(rs.getBoolean("entregado"));
                tmp.setTiendaOrigen(rs.getString("tiendasOrigen"));
                tmp.setTiendaDestino(rs.getString("tiendasDestino"));
                tmp.setDias(rs.getInt("tiempoDias"));
                
                pedidos.add(tmp);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(getP);
            Conexion.close(conexion);
        }          
        
        return pedidos;
    }
    
    /**
     * Metodo para registrar los pedidos que ya estan en tienda en la base de datos
     * @param pedido 
     * @throws java.sql.SQLException 
     */
    public void updatePedidoInStore(Pedido pedido) throws SQLException {
        String query = "UPDATE pedidos SET fechaLlegada = ?, llegadaATiempo = ?, entregado = ? WHERE id = ?";
        
        Connection conexion = null;
        PreparedStatement operP = null;
        try {
            conexion = (this.transaction != null) ? this.transaction : Conexion.getConnection();
            operP = conexion.prepareStatement(query);
            operP.setDate(1, pedido.getFechaLlegada());
            operP.setBoolean(2, pedido.isaTiempo());
            operP.setBoolean(3, pedido.isEntregado());
            operP.setInt(4, pedido.getId());
            
            operP.executeUpdate();
        } finally {
            Conexion.close(operP);
            if(this.transaction == null) {
                Conexion.close(conexion);
            }
        }      
    }
    
    public void updatePedidoInStoreEx(Pedido pedido) {
        try {
            updatePedidoInStore(pedido);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
    }
}
