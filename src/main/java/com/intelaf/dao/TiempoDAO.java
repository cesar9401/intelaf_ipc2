
package com.intelaf.dao;

import com.intelaf.conexion.Conexion;
import com.intelaf.model.Tiempo;
import java.sql.*;

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
    
    public void insertarTiempo(Tiempo tiempo) {
        String query = "INSERT INTO tiempos(tiendasOrigen, tiendasDestino, tiempoDias) VALUES(?, ?, ?)";
        
        Connection conexion = null;
        PreparedStatement setTime = null;
        try {
            conexion = (this.transaction != null) ? this.transaction : Conexion.getConnection();
            setTime = conexion.prepareStatement(query);
            setTime.setString(1, tiempo.getTiendaOrigen());
            setTime.setString(2, tiempo.getTiendaDestino());
            setTime.setInt(3, tiempo.getTiempoDias());
            
            setTime.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(setTime);
            if(this.transaction == null) {
                Conexion.close(conexion);
            }
        }
    }
    
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
}
