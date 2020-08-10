
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
     * Metodo para insertar pedidos a la base de datos
     * @param pedido
     * @throws SQLException 
     */
    public void insertarPedido(Pedido pedido) throws SQLException {
        String queryPedido = "INSERT INTO pedidos(id, clientesNit, tiemposId, fechaPedido, anticipo) "
                + "VALUES (?, ?, "
                + "(SELECT id FROM tiempos WHERE tiendasOrigen = ? AND tiendasDestino = ? LIMIT 1)"
                + ", ?, ?)"
                + " ON DUPLICATE KEY UPDATE id = id";
        
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
            setPedido.setDouble(6, pedido.getAnticipo());
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
}
