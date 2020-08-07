
package com.intelaf.dao;

import com.intelaf.conexion.Conexion;
import com.intelaf.dto.Tiempo;
import java.sql.*;

/**
 *
 * @author cesar31
 */
public class TiempoDAO {
    
    public void insertarTiempo(Tiempo tiempo) {
        String query = "INSERT INTO tiempos(tiendasOrigen, tiendasDestino, tiempoDias) VALUES(?, ?, ?)";
        
        Connection conexion = null;
        PreparedStatement setTime = null;
        try {
            conexion = Conexion.getConnection();
            setTime = conexion.prepareStatement(query);
            setTime.setString(1, tiempo.getTiendaOrigen());
            setTime.setString(2, tiempo.getTiendaDestino());
            setTime.setInt(3, tiempo.getTiempoDias());
            
            setTime.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(setTime);
            Conexion.close(conexion);
        }
    }
}
