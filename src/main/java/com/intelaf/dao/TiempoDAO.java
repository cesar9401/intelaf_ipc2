
package com.intelaf.dao;

import com.intelaf.conexion.Conexion;
import com.intelaf.model.Tiempo;
import java.sql.*;
import java.util.*;

/**
 *
 * @author cesar31
 */
public class TiempoDAO {
    
    private Connection transaction;

    public TiempoDAO() {
    }

    public TiempoDAO(Connection transaction) {
        this.transaction = transaction;
    }
    
    /**
     * Metodo para insertar Tiempo entre tiendas a la base de datos
     * @param tiempo
     * @throws SQLException 
     */
    public int insertarTiempo(Tiempo tiempo) throws SQLException {
        int row = 0;
        String query = "INSERT INTO tiempos(tiendasOrigen, tiendasDestino, tiempoDias) VALUES(?, ?, ?)";
        
        Connection conexion = null;
        PreparedStatement setTime = null;
        try {
            conexion = (this.transaction != null) ? this.transaction : Conexion.getConnection();
            setTime = conexion.prepareStatement(query);
            setTime.setString(1, tiempo.getTiendaOrigen());
            setTime.setString(2, tiempo.getTiendaDestino());
            setTime.setInt(3, tiempo.getTiempoDias());
            
            row = setTime.executeUpdate();
        } finally {
            Conexion.close(setTime);
            if(this.transaction == null) {
                Conexion.close(conexion);
            }
        }
        return row;
    }
    
    public int createTiempo(Tiempo tiempo) {
        try {
            return insertarTiempo(tiempo);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
            return 0;
        }
    }
    
    /**
     * Metodo que obtiene la informacion del tiempo entre tiendas segun los parametros que son los codigos de
     * las tiendas.
     * @param origen
     * @param destino
     * @return 
     */
    public Tiempo getTiempo(String origen, String destino) {
        String query = "SELECT * FROM tiempos WHERE tiendasOrigen = ? AND tiendasDestino = ?";
        Connection conexion = null;
        PreparedStatement getTime = null;
        ResultSet rs = null;
        Tiempo time = null;
        
        try {
            conexion = Conexion.getConnection();
            getTime = conexion.prepareStatement(query);
            getTime.setString(1, origen);
            getTime.setString(2, destino);
            rs = getTime.executeQuery();
            
            if(rs.next()) {
                time = new Tiempo(rs.getInt("id"), rs.getString("tiendasOrigen"), rs.getString("tiendasDestino"), rs.getInt("tiempoDias"));
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(getTime);
            Conexion.close(conexion);
        }

        return time;
    }
    
    /**
     * Metodo para obtener listado de tiempos entre tiendas
     * @return 
     */
    public List<Tiempo> getTiempos() {
        String query = "SELECT * FROM tiempos";
        List<Tiempo> tiempos = new ArrayList<>();
        
        Connection conexion = null;
        Statement getT = null;
        ResultSet rs = null;
        try {
            conexion = Conexion.getConnection();
            getT = conexion.createStatement();
            rs = getT.executeQuery(query);
            
            while(rs.next()) {
                Tiempo tiempo = new Tiempo(rs.getInt("id"), rs.getString("tiendasOrigen"), rs.getString("tiendasDestino"), rs.getInt("tiempoDias"));
                tiempos.add(tiempo);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(getT);
            Conexion.close(conexion);
        }
        return tiempos;
    }
    
    /**
     * Metodo para actualizar el tiempo entre dos tiendas
     * @param tiempo
     * @return 
     * @throws java.sql.SQLException 
     */
    public int updateTiempo(Tiempo tiempo) throws SQLException {
        String query = "UPDATE tiempos SET tiempoDias = ? WHERE tiendasOrigen = ? AND tiendasDestino = ?";
        int row = 0;
        
        Connection conexion = null;
        PreparedStatement updT = null;
        try {
            conexion = (this.transaction != null) ? this.transaction : Conexion.getConnection();
            updT = conexion.prepareStatement(query);
            updT.setInt(1, tiempo.getTiempoDias());
            updT.setString(2, tiempo.getTiendaOrigen());
            updT.setString(3, tiempo.getTiendaDestino());
            
            row = updT.executeUpdate();
        } finally {
            Conexion.close(updT);
            Conexion.close(conexion);
        }
        
        return row;
    }
    
    public int updateTiempoException(Tiempo tiempo) {
        try {
            return updateTiempo(tiempo);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
            return 0;
        }
    }
}
