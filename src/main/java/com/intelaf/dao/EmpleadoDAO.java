
package com.intelaf.dao;

import com.intelaf.conexion.Conexion;
import com.intelaf.model.Empleado;
import java.sql.*;
import java.util.*;

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
    
    /**
     * Metodo para obtener un listado de los empleados
     * @return 
     */
    public List<Empleado> getListEmpleado() {
        String query = "SELECT * FROM empleados";
        List<Empleado> empleados = new ArrayList<>();
        
        Connection conexion = null;
        Statement getEmpleados = null;
        ResultSet rs = null;
        try {
            conexion = Conexion.getConnection();
            getEmpleados = conexion.createStatement();
            rs = getEmpleados.executeQuery(query);
            
            while(rs.next()) {
                Empleado tmp = new Empleado(rs.getString("nombres"), rs.getString("codigo"), rs.getString("telefono"), rs.getString("dpi"));
                tmp.setNit(rs.getString("nit"));
                tmp.setEmail(rs.getString("email"));
                tmp.setDireccion(rs.getString("direccion"));
                
                empleados.add(tmp);
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(getEmpleados);
            Conexion.close(conexion);
        }
        
        return empleados;
    }
    
    /**
     * Metodo para actualizar la informacion de los empleados, el codigo no es actualizable
     * @param empleado
     * @return 
     */
    public int updateEmpleado(Empleado empleado) {
        int row = 0;
        String query = "UPDATE empleados SET nombres = ?, telefono = ?, nit = ?, email = ?, direccion = ? WHERE codigo = ?";
        
        Connection conexion = null;
        PreparedStatement updateEmp = null;
        try {
            conexion = Conexion.getConnection();
            updateEmp = conexion.prepareStatement(query);
            updateEmp.setString(1, empleado.getNombre());
            updateEmp.setString(2, empleado.getTelefono());
            updateEmp.setString(3, empleado.getNit());
            updateEmp.setString(4, empleado.getEmail());
            updateEmp.setString(5, empleado.getDireccion());
            updateEmp.setString(6, empleado.getCodigo());
            
            row = updateEmp.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(updateEmp);
            Conexion.close(conexion);
        }
        
        return row;
    }
}
