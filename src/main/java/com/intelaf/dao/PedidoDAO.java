
package com.intelaf.dao;

import com.intelaf.conexion.Conexion;
import com.intelaf.model.Pedido;
import java.sql.*;

/**
 *
 * @author cesar31
 */
public class PedidoDAO {
    
    public void insertarPedido(Pedido pedido) {
        String queryConsulta = "SELECT * FROM pedidos WHERE id = ?";
        String queryPedido = "INSERT INTO pedidos(id, clientesNit, tiemposId, fechaPedido, anticipo) VALUES (?, ?, ?, ?, ?)";
        String queryDetallePedido = "INSERT INTO detallesPedidos(pedidosId, tiendasProductosId, cantidad, subTotalPedido) VALUES(?, ?, ?, ?)";
        
        Pedido tmp = null;
        Connection conexion = null;
        PreparedStatement getPedido = null;
        PreparedStatement setPedido = null;
        PreparedStatement setDetalleP = null;
        ResultSet rs = null;
        
        try {
            conexion = Conexion.getConnection();
            conexion.setAutoCommit(false);
            
            getPedido = conexion.prepareStatement(queryConsulta);
            getPedido.setInt(1, pedido.getId());
            rs = getPedido.executeQuery();
            
            if(rs.next()) {
                tmp = new Pedido(rs.getInt("id"), rs.getString("clientesNit"), rs.getInt("tiemposId"), rs.getDate("fechaPedido"), rs.getDouble("anticipo"));
            }
            
            if(tmp == null) {
                setPedido = conexion.prepareStatement(queryPedido);
                setPedido.setInt(1, pedido.getId());
                setPedido.setString(2, pedido.getNitCliente());
                setPedido.setInt(3, pedido.getTiemposId());
                setPedido.setDate(4, pedido.getFechaPedido());
                setPedido.setDouble(5, pedido.getAnticipo());
                setPedido.executeUpdate();
                
                setDetalleP = conexion.prepareStatement(queryDetallePedido);
                setDetalleP.setInt(1, pedido.getId());
                setDetalleP.setInt(2, pedido.getTiendasProductosId());
                setDetalleP.setInt(3, pedido.getCantidad());
                setDetalleP.setDouble(4, pedido.getSubTotalPedido());
                setDetalleP.executeUpdate();
            } else {
                setDetalleP = conexion.prepareStatement(queryDetallePedido);
                setDetalleP.setInt(1, pedido.getId());
                setDetalleP.setInt(2, pedido.getTiendasProductosId());
                setDetalleP.setInt(3, pedido.getCantidad());
                setDetalleP.setDouble(4, pedido.getSubTotalPedido());
                setDetalleP.executeUpdate();
            }
            
            conexion.commit();
        } catch (SQLException ex) {
            try {
                conexion.rollback();
            } catch (SQLException ex1) {
                ex1.printStackTrace(System.out);
            }
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(setDetalleP);
            Conexion.close(setPedido);
            Conexion.close(getPedido);
            Conexion.close(conexion);
        }
    }
}
