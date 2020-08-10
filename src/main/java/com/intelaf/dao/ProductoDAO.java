
package com.intelaf.dao;

import com.intelaf.conexion.Conexion;
import com.intelaf.model.Producto;
import java.sql.*;

/**
 *
 * @author cesar31
 */
public class ProductoDAO {
    
    private Connection transaction;

    public ProductoDAO() {
    }

    public ProductoDAO(Connection transaction) {
        this.transaction = transaction;
    }
    
    /**
     * Metodo para insertar productos a la base de datos
     * @param producto
     * @throws SQLException 
     */
    public void insertarProductos(Producto producto) throws SQLException {
        String queryProducto = "INSERT INTO productos(codigo, nombre, fabricante, precio) VALUES(?, ?, ?, ?)  ON DUPLICATE KEY UPDATE codigo = codigo";
        String queryProductoTienda = "INSERT INTO tiendasProductos (tiendasCodigo, productosCodigo, stockProductos) VALUES(?, ?, ?)";
        
        Connection conexion = null;
        PreparedStatement setProductos = null;
        PreparedStatement setProdTiendas = null;
        
        try {
            conexion = (this.transaction != null) ? this.transaction : Conexion.getConnection();

            setProductos = conexion.prepareStatement(queryProducto);
            setProductos.setString(1, producto.getCodigoProductos());
            setProductos.setString(2, producto.getNombre());
            setProductos.setString(3, producto.getFabricante());
            setProductos.setDouble(4, producto.getPrecio());
            setProductos.executeUpdate();
                
            setProdTiendas = conexion.prepareStatement(queryProductoTienda);
            setProdTiendas.setString(1, producto.getCodigoTienda());
            setProdTiendas.setString(2, producto.getCodigoProductos());
            setProdTiendas.setInt(3, producto.getStock());
            setProdTiendas.executeUpdate();

        } finally {
            Conexion.close(setProdTiendas);
            Conexion.close(setProductos);
            if(this.transaction == null) {
                Conexion.close(conexion);
            }
        }
    }
}
