
package com.intelaf.dao;

import com.intelaf.conexion.Conexion;
import com.intelaf.dto.Empleado;
import java.sql.*;

/**
 *
 * @author cesar31
 */
public class EmpleadoDAO {
    
    public void insertarEmpleado(Empleado empleado) {
        String query = "INERT INTO empleados(codigo, nombres, telefono, dpi) VALUES(?, ?, ?, ?)";
        
        Connection conexion = null;
        PreparedStatement setEmpleado = null;
        try {
            conexion = Conexion.getConnection();
            setEmpleado = conexion.prepareStatement(query);
            setEmpleado.setString(1, empleado.getCodigo());
            setEmpleado.setString(2, empleado.getNombre());
            setEmpleado.setString(3, empleado.getTelefono());
            setEmpleado.setString(4, empleado.getDpi());
            
            setEmpleado.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(setEmpleado);
            Conexion.close(conexion);
        }
    }
}
