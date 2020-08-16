
package com.intelaf.dao;

import com.intelaf.conexion.Conexion;
import com.intelaf.model.Cliente;
import java.sql.*;
import java.util.*;

/**
 *
 * @author cesar31
 */
public class ClienteDAO {
    
    private Connection transaction;
    
    public ClienteDAO() {
    }

    public ClienteDAO(Connection transaction) {
        this.transaction = transaction;
    }
    
    /**
     * Metodo para insertar cliente a la base de datos
     * @param cliente 
     * @throws java.sql.SQLException 
     */
    public void insertarCliente(Cliente cliente) throws SQLException {
        String query = "INSERT INTO clientes (nit, nombre, telefono, dpi, creditoCompra, email, direccion) VALUES(?, ?, ?, ?, ?, ?, ?)";

        Connection conexion = null;
        PreparedStatement setCliente = null;
        
        try {
            conexion = (this.transaction != null) ? this.transaction : Conexion.getConnection();
            setCliente = conexion.prepareStatement(query);
            setCliente.setString(1, cliente.getNit());
            setCliente.setString(2, cliente.getNombre());
            setCliente.setString(3, cliente.getTelefono());
            setCliente.setString(4, cliente.getDpi());
            setCliente.setDouble(5, cliente.getCreditoCompra());
            setCliente.setString(6, cliente.getEmail());
            setCliente.setString(7, cliente.getDireccion());
            
            setCliente.executeUpdate();
        } finally {
            Conexion.close(setCliente);
            if(this.transaction == null) {
                Conexion.close(conexion);
            }
        }
    }
    
    /**
     * Se llama al metodo insertarCliente y se captura la excepcion con try catch
     * @param cliente 
     */
    public void createCliente(Cliente cliente) {
        try {
            insertarCliente(cliente);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
    }
    
    /**
     * Metodo para obtener el listado de clientes
     * @return 
     */
    public List<Cliente> getListCliente() {
        String query = "SELECT * FROM clientes";
        List<Cliente> clientes = new ArrayList<>();
        
        Connection conexion = null;
        Statement getCli = null;
        ResultSet rs = null;
        
        try {
            conexion = Conexion.getConnection();
            getCli = conexion.createStatement();
            rs = getCli.executeQuery(query);
            
            while(rs.next()) {
                Cliente tmp = new Cliente(rs.getString("nombre"), rs.getString("telefono"), rs.getDouble("creditoCompra"));
                tmp.setNit(rs.getString("nit"));
                tmp.setDpi(rs.getString("dpi"));
                tmp.setEmail(rs.getString("email"));
                tmp.setDireccion(rs.getString("direccion"));
                
                clientes.add(tmp);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(getCli);
            Conexion.close(conexion);
        }
        return clientes;
    }
    
    /**
     * Metodo para obtener un cliente segun el nit que reciba como parametro
     * @param nit
     * @return 
     */
    public Cliente getCliente(String nit) {
        String query = "SELECT * FROM clientes WHERE nit = ?";
        Cliente tmp = null;
        
        Connection conexion = null;
        PreparedStatement getC = null;
        ResultSet rs = null;
        try {
            conexion = Conexion.getConnection();
            getC = conexion.prepareStatement(query);
            getC.setString(1, nit);
            rs = getC.executeQuery();
            
            if(rs.next()) {
                tmp = new Cliente(rs.getString("nombre"), rs.getString("telefono"), rs.getDouble("creditoCompra"));
                tmp.setNit(rs.getString("nit"));
                tmp.setDpi(rs.getString("dpi"));
                tmp.setEmail(rs.getString("email"));
                tmp.setDireccion(rs.getString("direccion"));      
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(getC);
            Conexion.close(conexion);
        }
        
        return tmp;
    }
    
    /**
     * Metodo para actualgetCizar la informacion de algun cliente, el nit no es actualizable
     * @param cliente
     * @return 
     */
    public int updateCliente(Cliente cliente) {
        String query = "UPDATE clientes SET nombre = ?, telefono = ?, dpi = ?, creditoCompra = ?, email = ?, direccion = ? WHERE nit = ?";
        int row = 0;

        Connection conexion = null;
        PreparedStatement updateCl = null;
        
        try {
            conexion = Conexion.getConnection();
            updateCl = conexion.prepareStatement(query);
            updateCl.setString(1, cliente.getNombre());
            updateCl.setString(2, cliente.getTelefono());
            updateCl.setString(3, cliente.getDpi());
            updateCl.setDouble(4, cliente.getCreditoCompra());
            updateCl.setString(5, cliente.getEmail());
            updateCl.setString(6, cliente.getDireccion());
            updateCl.setString(7, cliente.getNit());
            
            row = updateCl.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(updateCl);
            Conexion.close(conexion);
        }
        
        return row;
    }
}
