
package com.intelaf.dao;

import com.intelaf.conexion.Conexion;
import com.intelaf.model.*;
import java.sql.*;

/**
 *
 * @author cesar31
 */
public class VentaDAO {
    
    private Connection transaction;

    public VentaDAO() {
    }

    public VentaDAO(Connection transaction) {
        this.transaction = transaction;
    }
    
    public int insertarVenta(Venta venta) throws SQLException {
        int id = 0;
        String query = "INSERT INTO ventas(clientesNit, fechaVenta, totalVenta, descuentoPorCredito) VALUES(?, ?, ?, ?)";
        
        Connection conexion = null;
        PreparedStatement setVenta = null;
        ResultSet rs = null;
        try {
            conexion = (this.transaction != null) ? this.transaction : Conexion.getConnection();
            setVenta = conexion.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);
            setVenta.setString(1, venta.getNitCliente());
            setVenta.setDate(2, venta.getFechaVenta());
            setVenta.setDouble(3, venta.getTotalVenta());
            setVenta.setDouble(4, venta.getDescuentoCredito());
            
            setVenta.executeUpdate();
            rs = setVenta.getGeneratedKeys();
            if(rs.next()) {
                id = rs.getInt(1);
            }
            
        } finally {
            Conexion.close(rs);
            Conexion.close(setVenta);
            if(this.transaction == null) {
                Conexion.close(conexion);
            }
        }
        return id;
    }
    
    public int setVenta(Venta venta) {
        try {
            return insertarVenta(venta);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        return 0;
    }
    
    public void insertarDetalleVenta(DetalleVenta detalle) throws SQLException {
        String queryExistencias = "UPDATE tiendasProductos SET stockProductos = stockProductos - ? WHERE id = ?";
        String query = "INSERT INTO detallesVentas(ventasId, tiendasProductosId, cantidad, precioVenta, subTotal) VALUES(?, ?, ?, ?, ?)";
        
        Connection conexion = null;
        PreparedStatement setE = null;
        PreparedStatement setD = null;
        try {
            conexion = (this.transaction != null) ? this.transaction : Conexion.getConnection();
            
            setE = conexion.prepareStatement(queryExistencias);
            setE.setInt(1, detalle.getCantidad());
            setE.setInt(2, detalle.getTiendasProductosId());
            setE.executeUpdate();           
            
            setD = conexion.prepareStatement(query);
            setD.setInt(1, detalle.getIdVentas());
            setD.setInt(2, detalle.getTiendasProductosId());
            setD.setInt(3, detalle.getCantidad());
            setD.setDouble(4, detalle.getPrecioVenta());
            setD.setDouble(5, detalle.getSubTotal());
            setD.executeUpdate();
            
        } finally {
            Conexion.close(setD);
            Conexion.close(setE);
            if(this.transaction == null) {
                Conexion.close(conexion);
            }
        }
    }
    
    public void setDetalleVenta(DetalleVenta detalle) {
        try {
            insertarDetalleVenta(detalle);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
    }
}
