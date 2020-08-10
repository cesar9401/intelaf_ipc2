
package com.intelaf.dao;

import com.intelaf.conexion.Conexion;
import com.intelaf.model.Empleado;
import java.sql.*;

/**
 *
 * @author cesar31
 */
public class EmpleadoDAO {
    
    private Connection transaction;

    public EmpleadoDAO() {
    }

    public EmpleadoDAO(Connection transaction) {
        this.transaction = transaction;
    }
    
    /**
     * Metodo para insertar empleados a la base de datos
     * @param empleado
     * @throws SQLException 
     */
    public void insertarEmpleado(Empleado empleado) throws SQLException {
        String query = "INSERT INTO empleados(codigo, nombres, telefono, dpi) VALUES(?, ?, ?, ?)";
        
        Connection conexion = null;
        PreparedStatement setEmpleado = null;
        try {
            conexion = (this.transaction != null) ? this.transaction : Conexion.getConnection();
            setEmpleado = conexion.prepareStatement(query);
            setEmpleado.setString(1, empleado.getCodigo());
            setEmpleado.setString(2, empleado.getNombre());
            setEmpleado.setString(3, empleado.getTelefono());
            setEmpleado.setString(4, empleado.getDpi());
            
            setEmpleado.executeUpdate();
        } finally {
            Conexion.close(setEmpleado);
            if(this.transaction == null) {
                Conexion.close(conexion);
            }
        }
    }
}