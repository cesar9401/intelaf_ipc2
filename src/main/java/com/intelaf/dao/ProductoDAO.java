
package com.intelaf.dao;

import com.intelaf.conexion.Conexion;
import com.intelaf.model.Producto;
import java.sql.*;
import java.util.*;

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
    
    /**
     * Metodo para obtener un listado de productos según el codigo de tienda que se reciba como parametro
     * @param codigoTienda
     * @return 
     */
    public List<Producto> getListProductobyStore(String codigoTienda) {
        String query = "SELECT id, codigo, nombre, fabricante, precio, descripcion, garantia, stockProductos "
               + "FROM productos INNER JOIN tiendasProductos ON productos.codigo = tiendasProductos.productosCodigo "
               + "WHERE tiendasCodigo = ?";
       
        List<Producto> productos = new ArrayList<>();
        Connection conexion = null;
        PreparedStatement getProd = null;
        ResultSet rs = null;
        try { 
            conexion = Conexion.getConnection();
            getProd = conexion.prepareStatement(query);
            getProd.setString(1, codigoTienda);
            rs = getProd.executeQuery();
            
            while(rs.next()) {
                Producto tmp = new Producto(rs.getString("nombre"), rs.getString("fabricante"), rs.getString("codigo"), rs.getDouble("precio"), rs.getString("descripcion"), rs.getInt("garantia"));
                tmp.setStock(rs.getInt("stockProductos"));
                tmp.setTiendasProductosId(rs.getInt("id"));
                
                productos.add(tmp);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(getProd);
            Conexion.close(conexion);
        }
        
        return productos;
    }
    
    /**
     * Metodo para actualizar la información de algun producto, el codigo no se puede actualizar.
     * @param producto
     * @return 
     */
    public int updateProducto(Producto producto) {
        String query = "UPDATE productos SET nombre = ?, fabricante = ?, precio = ?, descripcion = ?, garantia = ? WHERE codigo = ?";
        int row = 0;
        
        Connection conexion = null;
        PreparedStatement updProd = null;
        try {
            conexion = Conexion.getConnection();
            updProd = conexion.prepareStatement(query);
            updProd.setString(1, producto.getNombre());
            updProd.setString(2, producto.getFabricante());
            updProd.setDouble(3, producto.getPrecio());
            updProd.setString(4, producto.getDescripcion());
            updProd.setInt(5, producto.getGarantia());
            updProd.setString(6, producto.getCodigoProductos());
            
            row = updProd.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(updProd);
            Conexion.close(conexion);
        }
        
        return row;
    }
    
    /**
     * Metodo para actualizar el stock de algun producto segun su codigo y la tienda donde se encuentre,
     * estos son atributos del objeto producto.
     * @param producto
     * @return 
     */
    public int updateStockProductos(Producto producto) {
        String query = "UPDATE tiendasProductos SET stockProductos = stockProductos + ? WHERE tiendasCodigo = ? AND productosCodigo = ?";
        int row = 0;
        
        Connection conexion = null;
        PreparedStatement updProd = null;
        try {
            conexion = Conexion.getConnection();
            updProd = conexion.prepareStatement(query);
            updProd.setInt(1, producto.getStock());
            updProd.setString(2, producto.getCodigoTienda());
            updProd.setString(3, producto.getCodigoProductos());
            
            row = updProd.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(updProd);
            Conexion.close(conexion);
        }
        
        return row;
    }
}
