
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
    
    /**
     * Metodo para insertar una nueva Tienda a la base de datos
     * @param tienda
     * @throws SQLException 
     */
    public void insertarTienda(Tienda tienda) throws SQLException {
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
        } finally {
            Conexion.close(setTienda);
            if(this.transaction == null) {
                Conexion.close(conexion);
            }
        }
    }
    
    /**
     * Metodo para insertar las tiendas que reciben pedidos a la base de datos
     * @param tienda
     * @throws SQLException 
     */
    public void insertarDestino(Tienda tienda) throws SQLException {
        String query = "INSERT INTO tiendasDestinos(tiendasCodigo) VALUES(?)";
        
        Connection conexion = null;
        PreparedStatement setDestino = null;
        try {
            conexion = (this.transaction != null) ? this.transaction : Conexion.getConnection();
            setDestino = conexion.prepareStatement(query);
            setDestino.setString(1, tienda.getCodigo());
            
            setDestino.executeUpdate();
        } finally {
            Conexion.close(setDestino);
            if(this.transaction == null) {
                Conexion.close(conexion);
            }
        }
    }
    
    public int updateTienda(Tienda tienda) {
        String query = "UPDATE tiendas SET nombre = ?, direccion = ?, telefono1 = ?, telefono2 = ?, email = ?, horario = ? WHERE codigo = ?";
        int row = 0;
        
        Connection conexion = null;
        PreparedStatement updT = null;
        try {
            conexion = Conexion.getConnection();
            updT = conexion.prepareStatement(query);
            updT.setString(1, tienda.getNombre());
            updT.setString(2, tienda.getDireccion());
            updT.setString(3, tienda.getTelefono1());
            updT.setString(4, tienda.getTelefono2());
            updT.setString(5, tienda.getEmail());
            updT.setString(6, tienda.getHorario());
            updT.setString(7, tienda.getCodigo());
            
            row = updT.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(updT);
            Conexion.close(conexion);
        }
        return row;
    }
}
