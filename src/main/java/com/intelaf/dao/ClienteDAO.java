
package com.intelaf.dao;

import com.intelaf.conexion.Conexion;
import com.intelaf.dto.Cliente;
import java.sql.*;

/**
 *
 * @author cesar31
 */
public class ClienteDAO {
    
    public void insertarCliente(Cliente cliente) {
        String query = "INSERT INTO clientes(nit, nombre, telefono, creditoCompra) VALUES(?, ?, ?, ?)";

        Connection conexion = null;
        PreparedStatement setCliente = null;
        
        try {
            conexion = Conexion.getConnection();
            setCliente = conexion.prepareStatement(query);
            setCliente.setString(1, cliente.getNit());
            setCliente.setString(2, cliente.getNombre());
            setCliente.setString(3, cliente.getTelefono());
            setCliente.setDouble(4, cliente.getCreditoCompra());
            
            setCliente.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(setCliente);
            Conexion.close(conexion);
        }
    }
}
