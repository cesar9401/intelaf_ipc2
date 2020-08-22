
package com.intelaf.dao;

import com.intelaf.conexion.Conexion;
import com.intelaf.model.Pedido;
import java.sql.*;

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
}
