
package com.intelaf.dao;

import com.intelaf.conexion.Conexion;
import com.intelaf.model.Tienda;
import java.sql.*;
import java.util.*;

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
        String query = "INSERT INTO tiendas(codigo, nombre, direccion, telefono1, telefono2, email, horario) VALUES(?, ?, ?, ?, ?, ?, ?)";
        
        Connection conexion = null;
        PreparedStatement setTienda = null;
        try {
            conexion = (this.transaction != null) ? this.transaction : Conexion.getConnection();
            setTienda = conexion.prepareStatement(query);
            setTienda.setString(1, tienda.getCodigo());
            setTienda.setString(2, tienda.getNombre());
            setTienda.setString(3, tienda.getDireccion());
            setTienda.setString(4, tienda.getTelefono1());
            setTienda.setString(5, tienda.getTelefono2());
            setTienda.setString(6, tienda.getEmail());
            setTienda.setString(7, tienda.getHorario());
            
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
    
    /**
     * Metodo para actualizar los datos de alguna tienda, el codigo no se puede actualizar
     * @param tienda
     * @return 
     */
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
    
    /**
     * Metodo para obtener la informacion de una tienda en particular segun el codigo que se reciba como parametro
     * @param codigo
     * @return 
     */
    public Tienda getTienda(String codigo) {
        String query = "SELECT * FROM tiendas WHERE codigo = ?";
        Tienda tmp = null;
        
        Connection conexion = null;
        PreparedStatement getT = null;
        ResultSet rs = null;
        try {
            conexion = Conexion.getConnection();
            getT = conexion.prepareStatement(query);
            getT.setString(1, codigo);
            rs = getT.executeQuery();
            
            if(rs.next()) {
                tmp = new Tienda(rs.getString("nombre"), rs.getString("direccion"), rs.getString("codigo"), rs.getString("telefono1"));
                tmp.setTelefono2(rs.getString("telefono2"));
                tmp.setEmail(rs.getString("email"));
                tmp.setHorario(rs.getString("horario"));                
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(getT);
            Conexion.close(conexion);
        }
        
        return tmp;
    }
    
    public List<Tienda> getTiendas() {
        String query = "SELECT * FROM tiendas";
        List<Tienda> tiendas = new ArrayList<>();
        
        Connection conexion = null;
        Statement getT = null;
        ResultSet rs = null;

        try {
            conexion = Conexion.getConnection();
            getT = conexion.createStatement();
            rs = getT.executeQuery(query);
            
            while(rs.next()) {
                Tienda tmp = new Tienda(rs.getString("nombre"), rs.getString("direccion"), rs.getString("codigo"), rs.getString("telefono1"));
                tmp.setTelefono2(rs.getString("telefono2"));
                tmp.setEmail(rs.getString("email"));
                tmp.setHorario(rs.getString("horario"));
                
                tiendas.add(tmp);
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(getT);
            Conexion.close(conexion);
        }
        
        return tiendas;
    }
    
    public List<Tienda> getTiendasExcept(String codigo) {
        String query = "SELECT * FROM tiendas WHERE codigo != ?";
        List<Tienda> tiendas = new ArrayList<>();
        
        Connection conexion = null;
        PreparedStatement getT = null;
        ResultSet rs = null;
        try {
            conexion = Conexion.getConnection();
            getT = conexion.prepareStatement(query);
            getT.setString(1, codigo);
            rs = getT.executeQuery();
            
            while(rs.next()) {
                Tienda tmp = new Tienda(rs.getString("nombre"), rs.getString("direccion"), rs.getString("codigo"), rs.getString("telefono1"));
                tmp.setTelefono2(rs.getString("telefono2"));
                tmp.setEmail(rs.getString("email"));
                tmp.setHorario(rs.getString("horario"));     
                
                tiendas.add(tmp);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(getT);
            Conexion.close(conexion);
        }
        
        return tiendas;
    }    
}
