
package com.intelaf.dao;

import com.intelaf.conexion.Conexion;
import com.intelaf.dto.Tienda;
import java.sql.*;

/**
 *
 * @author cesar31
 */
public class TiendaDAO {
    
    public void insertarTienda(Tienda tienda) {
        String query = "INSERT INTO tiendas(codigo, nombre, direccion, telefono1) VALUES(?, ?, ?, ?)";
        
        Connection conexion = null;
        PreparedStatement setTienda = null;
        try {
            conexion = Conexion.getConnection();
            setTienda = conexion.prepareStatement(query);
            setTienda.setString(1, tienda.getCodigo());
            setTienda.setString(2, tienda.getNombre());
            setTienda.setString(3, tienda.getDireccion());
            setTienda.setString(4, tienda.getTelefono1());
            
            setTienda.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(setTienda);
            Conexion.close(conexion);
        }
    }
}
