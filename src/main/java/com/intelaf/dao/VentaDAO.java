
package com.intelaf.dao;

import com.intelaf.conexion.Conexion;
import com.intelaf.model.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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
        int row = 0;
        String query = "INSERT INTO ventas(clientesNit, fechaVenta, totalVenta, descuentoPorCredito) VALUES(?, ?, ?, ?)";
        
        Connection conexion = null;
        PreparedStatement setVenta = null;
        try {
            conexion = (this.transaction != null) ? this.transaction : Conexion.getConnection();
            setVenta = conexion.prepareStatement(query);
            //setVenta.setInt(1, venta.getPedidosId());
            setVenta.setString(1, venta.getNitCliente());
            setVenta.setDate(2, venta.getFechaVenta());
            setVenta.setDouble(3, venta.getTotalVenta());
            setVenta.setDouble(4, venta.getDescuentoCredito());
            
            row = setVenta.executeUpdate();
            
        } finally {
            Conexion.close(setVenta);
            if(this.transaction == null) {
                Conexion.close(conexion);
            }
        }
        return row;
    }
    
    public int setVenta(Venta venta) {
        try {
            return insertarVenta(venta);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        return 0;
    }
    
    public void insertarDetalleVenta(Venta venta, DetalleVenta detalle) throws SQLException {
        String query = "INSERT INTO detallesVentas(ventasId, tiendasProductosId, cantidad, precioVenta, subTotal) VALUES("
                + "(SELECT id FROM ventas WHERE clientesNit = ? AND fechaVenta = ? AND totalVenta = ? AND descuentoPorCredito = ? ORDER BY id DESC LIMIT 1)"
                + ", ?, ?, ?, ?)";
        
        String queryExistencias = "UPDATE tiendasProductos SET stockProductos = stockProductos - ? WHERE id = ?";
        
        Connection conexion = null;
        PreparedStatement setD = null;
        PreparedStatement setE = null;
        try {
            conexion = (this.transaction != null) ? this.transaction : Conexion.getConnection();
           
            setD = conexion.prepareStatement(query);
            setD.setString(1, venta.getNitCliente());
            setD.setDate(2, venta.getFechaVenta());
            setD.setDouble(3, venta.getTotalVenta());
            setD.setDouble(4, venta.getDescuentoCredito());
            
            setD.setInt(5, detalle.getTiendasProductosId());
            setD.setInt(6, detalle.getCantidad());
            setD.setDouble(7, detalle.getPrecioVenta());
            setD.setDouble(8, detalle.getSubTotal());
            
            setD.executeUpdate();
            
            setE = conexion.prepareStatement(queryExistencias);
            setE.setInt(1, detalle.getCantidad());
            setE.setInt(2, detalle.getTiendasProductosId());
            setE.executeUpdate();
            
        } finally {
            Conexion.close(setE);
            Conexion.close(setD);
            if(this.transaction == null) {
                Conexion.close(conexion);
            }
        }
    }
    
    public void setDetalleVenta(Venta venta, DetalleVenta detalle) {
        try {
            insertarDetalleVenta(venta, detalle);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
    }
}
