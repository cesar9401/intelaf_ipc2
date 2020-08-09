
package com.intelaf.dao;

import com.intelaf.conexion.Conexion;
import com.intelaf.model.Tienda;
import java.sql.*;

/**
 *
 * @author cesar31
 */
public class TiendaDAO {
    
    private Connection transaction;
    
    public TiendaDAO() {  
   }
    
    public TiendaDAO(Connection transaction) {
        this.transaction = transaction;
    }
    
    public void insertarTienda(Tienda tienda) {
        String query = "INSERT INTO tiendas(codigo, nombre, direccion, telefono1) VALUES(?, ?, ?, ?)";
        
        Connection conexion = null;
        PreparedStatement setTienda = null;
        try {
            conexion = (this.transaction != null) ? this.transaction : Conexion.getConnection();
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
            if(this.transaction == null) {
                Conexion.close(conexion);
            }
        }
    }
    
    public void insertarDestino(Tienda tienda) {
        String query = "INSERT INTO tiendasDestinos(tiendasCodigo) VALUES(?)";
        
        Connection conexion = null;
        PreparedStatement setDestino = null;
        try {
            conexion = (this.transaction != null) ? this.transaction : Conexion.getConnection();
            setDestino = conexion.prepareStatement(query);
            setDestino.setString(1, tienda.getCodigo());
            
            setDestino.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(setDestino);
            if(this.transaction == null) {
                Conexion.close(conexion);
            }
        }
    }
}
