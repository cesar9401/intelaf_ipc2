
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
     * @return 
     * @throws SQLException 
     */
    public int insertarEmpleado(Empleado empleado) throws SQLException {
        int row = 0;
        String query = "INSERT INTO empleados(codigo, nombres, telefono, nit, dpi, email, direccion) VALUES(?, ?, ?, ?, ?, ?, ?)";
        
        Connection conexion = null;
        PreparedStatement setEmpleado = null;
        try {
            conexion = (this.transaction != null) ? this.transaction : Conexion.getConnection();
            setEmpleado = conexion.prepareStatement(query);
            setEmpleado.setString(1, empleado.getCodigo());
            setEmpleado.setString(2, empleado.getNombre());
            setEmpleado.setString(3, empleado.getTelefono());
            setEmpleado.setString(4, empleado.getNit());
            setEmpleado.setString(5, empleado.getDpi());
            setEmpleado.setString(6, empleado.getEmail());
            setEmpleado.setString(7, empleado.getDireccion());
            
            row = setEmpleado.executeUpdate();
        } finally {
            Conexion.close(setEmpleado);
            if(this.transaction == null) {
                Conexion.close(conexion);
            }
        }
        return row;
    }
    
    public int createEmpleado(Empleado empleado) {
        try {
            return insertarEmpleado(empleado);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
            return 0;
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
     * Metodo para obtener a un empleado de la base de datos segun su codigo.
     * @param codigo
     * @return 
     */
    public Empleado getEmpleado(String codigo) {
        String query = "SELECT * FROM empleados WHERE codigo = ?";
        Empleado emp = null;
        
        Connection conexion = null;
        PreparedStatement getE = null;
        ResultSet rs = null;
        try {
            conexion = Conexion.getConnection();
            getE = conexion.prepareStatement(query);
            getE.setString(1, codigo);
            rs = getE.executeQuery();
            
            while(rs.next()) {
                emp = new Empleado(rs.getString("nombres"), rs.getString("codigo"), rs.getString("telefono"), rs.getString("dpi"));
                emp.setNit(rs.getString("nit"));
                emp.setEmail(rs.getString("email"));
                emp.setDireccion(rs.getString("direccion"));
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(getE);
            Conexion.close(conexion);
        }
        
        return emp;
    }
    
    /**
     * Metodo para actualizar la informacion de los empleados, el codigo no es actualizable
     * @param empleado
     * @return 
     */
    public int updateEmpleado(Empleado empleado) {
        int row = 0;
        String query = "UPDATE empleados SET nombres = ?, telefono = ?, nit = ?, dpi = ?, email = ?, direccion = ? WHERE codigo = ?";
        
        Connection conexion = null;
        PreparedStatement updateEmp = null;
        try {
            conexion = Conexion.getConnection();
            updateEmp = conexion.prepareStatement(query);
            updateEmp.setString(1, empleado.getNombre());
            updateEmp.setString(2, empleado.getTelefono());
            updateEmp.setString(3, empleado.getNit());
            updateEmp.setString(4, empleado.getDpi());
            updateEmp.setString(5, empleado.getEmail());
            updateEmp.setString(6, empleado.getDireccion());
            updateEmp.setString(7, empleado.getCodigo());
            
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
