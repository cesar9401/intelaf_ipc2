
package com.intelaf.dao;

import com.intelaf.conexion.Conexion;
import com.intelaf.model.Cliente;
import java.sql.*;

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
        String query = "INSERT INTO clientes(nit, nombre, telefono, creditoCompra) VALUES(?, ?, ?, ?)";

        Connection conexion = null;
        PreparedStatement setCliente = null;
        
        try {
            conexion = (this.transaction != null) ? this.transaction : Conexion.getConnection();
            setCliente = conexion.prepareStatement(query);
            setCliente.setString(1, cliente.getNit());
            setCliente.setString(2, cliente.getNombre());
            setCliente.setString(3, cliente.getTelefono());
            setCliente.setDouble(4, cliente.getCreditoCompra());
            
            setCliente.executeUpdate();
        } finally {
            Conexion.close(setCliente);
            if(this.transaction == null) {
                Conexion.close(conexion);
            }
        }
    }
}
