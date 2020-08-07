
package com.intelaf.dao;

import com.intelaf.conexion.Conexion;
import com.intelaf.dto.Producto;
import java.sql.*;

/**
 *
 * @author cesar31
 */
public class ProductosDAO {
    /**
     * 
     * 1. Verificar si el producto esta en la base de datos
     * 2. Si esta unicamente ingresar el stock en la tienda y si no agregar a la bd.
     * 
     * Metodo para escribir en la base de datos mediante la carga de archivos
     * 
     * @param producto 
     */
    public void insertarProductos(Producto producto) {
        String queryConsulta = "SELECT * FROM productos WHERE codigo = ?";
        String queryProducto = "INSERT INTO productos(codigo, nombre, fabricante, precio) VALUES(?, ?, ?, ?)";
        String queryProductoTienda = "INSERT INTO tiendasProductos (tiendasCodigo, productosCodigo, stockProductos) VALUES(?, ?, ?)";
        
        Producto tmp = null;
        Connection conexion = null;
        PreparedStatement getProducto = null;
        ResultSet rs = null;
        PreparedStatement setProductos = null;
        PreparedStatement setProdTiendas = null;
        
        try {
            conexion = Conexion.getConnection();
            conexion.setAutoCommit(false);
            
            getProducto = conexion.prepareStatement(queryConsulta);
            getProducto.setString(1, producto.getCodigoProductos());
            rs = getProducto.executeQuery();
            
            if(rs.next()) {
                tmp = new Producto(rs.getString("nombre"), rs.getString("fabricante"), rs.getString("codigo"), rs.getDouble("precio"), rs.getString("descripcion"), rs.getInt("garantia"));
            }
            
            if(tmp == null) {
                setProductos = conexion.prepareStatement(queryProducto);
                setProductos.setString(1, producto.getCodigoProductos());
                setProductos.setString(2, producto.getNombre());
                setProductos.setString(3, producto.getFabricante());
                setProductos.setDouble(4, producto.getPrecio());
                setProductos.executeUpdate();
            } else {
                setProdTiendas = conexion.prepareStatement(queryProductoTienda);
                setProdTiendas.setString(1, producto.getCodigoTienda());
                setProdTiendas.setString(2, producto.getCodigoProductos());
                setProdTiendas.setInt(3, producto.getStock());
                setProdTiendas.executeUpdate();
            }
            
            conexion.commit();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
            try {
                conexion.rollback();
            } catch (SQLException ex1) {
                ex1.printStackTrace(System.out);
            }
        } finally {
            Conexion.close(setProdTiendas);
            Conexion.close(setProductos);
            Conexion.close(rs);
            Conexion.close(getProducto);
            Conexion.close(conexion);
        }
    }
}
