
package com.intelaf.view;

import com.intelaf.controller.MainControl;
import com.intelaf.model.*;
import java.util.*;

/**
 *
 * @author cesar31
 */
public class UsuarioView extends javax.swing.JPanel {

    private MainControl control;
    private List<Empleado> empleados;
    private List<Cliente> clientes;
    private String[][] listEmpleados;
    private String[][] listClientes;
    
    /**
     * Creates new form VentaView
     */
    public UsuarioView() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        scrollEmpleados = new javax.swing.JScrollPane();
        empleadosTable = new javax.swing.JTable();
        scrollClientes = new javax.swing.JScrollPane();
        clientesTable = new javax.swing.JTable();
        empleadosLabel = new javax.swing.JLabel();
        editarEmpleadoButton = new javax.swing.JButton();
        agregarEmpleadoButton = new javax.swing.JButton();
        clientesLabel = new javax.swing.JLabel();
        editarClienteButton = new javax.swing.JButton();
        agregarClienteButton = new javax.swing.JButton();

        setBackground(new java.awt.Color(248, 147, 31));
        setMinimumSize(new java.awt.Dimension(800, 700));

        empleadosTable.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        empleadosTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        empleadosTable.setEditingColumn(0);
        empleadosTable.setEditingRow(0);
        empleadosTable.setMinimumSize(new java.awt.Dimension(700, 250));
        empleadosTable.setPreferredSize(new java.awt.Dimension(700, 250));
        empleadosTable.setRowHeight(36);
        empleadosTable.setSelectionBackground(new java.awt.Color(0, 0, 0));
        empleadosTable.setSelectionForeground(new java.awt.Color(248, 147, 31));
        empleadosTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        empleadosTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        scrollEmpleados.setViewportView(empleadosTable);
        empleadosTable.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);

        clientesTable.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        clientesTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "NIT", "Nombre", "Telefono", "DPI", "Credito", "Email"
            }
        ));
        clientesTable.setEditingColumn(0);
        clientesTable.setEditingRow(0);
        clientesTable.setMinimumSize(new java.awt.Dimension(700, 200));
        clientesTable.setPreferredSize(new java.awt.Dimension(700, 200));
        clientesTable.setRowHeight(36);
        clientesTable.setSelectionBackground(new java.awt.Color(0, 0, 0));
        clientesTable.setSelectionForeground(new java.awt.Color(248, 147, 31));
        clientesTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        clientesTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        scrollClientes.setViewportView(clientesTable);

        empleadosLabel.setBackground(new java.awt.Color(248, 147, 31));
        empleadosLabel.setFont(new java.awt.Font("sansserif", 0, 24)); // NOI18N
        empleadosLabel.setForeground(new java.awt.Color(255, 255, 255));
        empleadosLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        empleadosLabel.setText("Empleados");
        empleadosLabel.setMaximumSize(new java.awt.Dimension(150, 36));
        empleadosLabel.setMinimumSize(new java.awt.Dimension(150, 36));
        empleadosLabel.setPreferredSize(new java.awt.Dimension(150, 36));

        editarEmpleadoButton.setBackground(new java.awt.Color(0, 0, 0));
        editarEmpleadoButton.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        editarEmpleadoButton.setForeground(new java.awt.Color(248, 147, 31));
        editarEmpleadoButton.setText("Editar");
        editarEmpleadoButton.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(248, 103, 27), 1, true));
        editarEmpleadoButton.setFocusPainted(false);
        editarEmpleadoButton.setMaximumSize(new java.awt.Dimension(125, 32));
        editarEmpleadoButton.setMinimumSize(new java.awt.Dimension(125, 32));
        editarEmpleadoButton.setPreferredSize(new java.awt.Dimension(125, 32));
        editarEmpleadoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editarEmpleadoButtonActionPerformed(evt);
            }
        });

        agregarEmpleadoButton.setBackground(new java.awt.Color(0, 0, 0));
        agregarEmpleadoButton.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        agregarEmpleadoButton.setForeground(new java.awt.Color(248, 147, 31));
        agregarEmpleadoButton.setText("Agregar...");
        agregarEmpleadoButton.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(248, 103, 27), 1, true));
        agregarEmpleadoButton.setFocusPainted(false);
        agregarEmpleadoButton.setMaximumSize(new java.awt.Dimension(125, 32));
        agregarEmpleadoButton.setMinimumSize(new java.awt.Dimension(125, 32));
        agregarEmpleadoButton.setPreferredSize(new java.awt.Dimension(125, 32));
        agregarEmpleadoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agregarEmpleadoButtonActionPerformed(evt);
            }
        });

        clientesLabel.setBackground(new java.awt.Color(248, 147, 31));
        clientesLabel.setFont(new java.awt.Font("sansserif", 0, 24)); // NOI18N
        clientesLabel.setForeground(new java.awt.Color(255, 255, 255));
        clientesLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        clientesLabel.setText("Clientes");
        clientesLabel.setMaximumSize(new java.awt.Dimension(150, 36));
        clientesLabel.setMinimumSize(new java.awt.Dimension(150, 36));
        clientesLabel.setPreferredSize(new java.awt.Dimension(150, 36));

        editarClienteButton.setBackground(new java.awt.Color(0, 0, 0));
        editarClienteButton.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        editarClienteButton.setForeground(new java.awt.Color(248, 147, 31));
        editarClienteButton.setText("Editar");
        editarClienteButton.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(248, 103, 27), 1, true));
        editarClienteButton.setFocusPainted(false);
        editarClienteButton.setMaximumSize(new java.awt.Dimension(125, 32));
        editarClienteButton.setMinimumSize(new java.awt.Dimension(125, 32));
        editarClienteButton.setPreferredSize(new java.awt.Dimension(125, 32));
        editarClienteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editarClienteButtonActionPerformed(evt);
            }
        });

        agregarClienteButton.setBackground(new java.awt.Color(0, 0, 0));
        agregarClienteButton.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        agregarClienteButton.setForeground(new java.awt.Color(248, 147, 31));
        agregarClienteButton.setText("Agregar...");
        agregarClienteButton.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(248, 103, 27), 1, true));
        agregarClienteButton.setFocusPainted(false);
        agregarClienteButton.setMaximumSize(new java.awt.Dimension(125, 32));
        agregarClienteButton.setMinimumSize(new java.awt.Dimension(125, 32));
        agregarClienteButton.setPreferredSize(new java.awt.Dimension(125, 32));
        agregarClienteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agregarClienteButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(empleadosLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(agregarClienteButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(editarClienteButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(agregarEmpleadoButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(editarEmpleadoButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(clientesLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(scrollEmpleados, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(scrollClientes, javax.swing.GroupLayout.DEFAULT_SIZE, 720, Short.MAX_VALUE))
                        .addGap(42, 42, 42))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(empleadosLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(scrollEmpleados, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(agregarEmpleadoButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(editarEmpleadoButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addComponent(clientesLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scrollClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(editarClienteButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(agregarClienteButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(59, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents
        
    /**
     * Metodo actualizar la tabla que muestra la informacion de los clientes
     * traidos de la base de datos
     */
    private void setTableClientes() {
        listClientes = new String[clientes.size()][6];
        
        for(int i=0; i<clientes.size(); i++) {
            listClientes[i][0] = clientes.get(i).getNit();
            listClientes[i][1] = clientes.get(i).getNombre();
            listClientes[i][2] = clientes.get(i).getTelefono();
            listClientes[i][3] = clientes.get(i).getDpi();
            listClientes[i][4] = "Q. " + clientes.get(i).getCreditoCompra();
            listClientes[i][5] = clientes.get(i).getEmail();

        }
        
        clientesTable.setModel(new javax.swing.table.DefaultTableModel(
            listClientes,
            new String [] {
                "NIT", "Nombre", "Telefono", "DPI", "Credito", "Email"
            }
        ));
    }
        
    /**
     * Metodo para editar la informacion de un empleado
     * @param evt 
     */
    private void editarEmpleadoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editarEmpleadoButtonActionPerformed
        // TODO add your handling code here:
        int row = empleadosTable.getSelectedRow();
        if(row != -1) {
            System.out.println(empleados.get(row).toString());
        } else {
            control.crearAlerta("Alerta", "Debe seleccionar un empleado para poder editarlo", null);
        }
    }//GEN-LAST:event_editarEmpleadoButtonActionPerformed

    private void agregarEmpleadoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregarEmpleadoButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_agregarEmpleadoButtonActionPerformed

    private void editarClienteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editarClienteButtonActionPerformed
        // TODO add your handling code here:
        int row = clientesTable.getSelectedRow();
        if(row != -1) {
            System.out.println(clientes.get(row).toString());
        } else {
            control.crearAlerta("Alerta", "Debe seleccionar un cliente para poder editarlo", null);
        }
    }//GEN-LAST:event_editarClienteButtonActionPerformed

    private void agregarClienteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregarClienteButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_agregarClienteButtonActionPerformed
    
    /**
     * Metodo para inicializar componentes necesarios para mostrar informacion de la los usuarios
     * @param control 
     */
    public void initializeComponents(MainControl control) {
        this.control = control;

        obtenerUsuarios();
        setTableEmpleados();
        setTableClientes();
    }
    
    /**
     * Metodo para obtener productos de la base de datos
     */
    private void obtenerUsuarios() {
        empleados = control.getEmpleados();
        clientes = control.getClientes();
    }
    
    /**
     * Metodo para agregar a los empleados a la tabla, traidos de la base de datos
     */
    private void setTableEmpleados() {
        listEmpleados = new String[empleados.size()][6];

        for(int i=0; i<empleados.size(); i++) {
            listEmpleados[i][0] = empleados.get(i).getCodigo();
            listEmpleados[i][1] = empleados.get(i).getNombre();
            listEmpleados[i][2] = empleados.get(i).getTelefono();
            listEmpleados[i][3] = empleados.get(i).getNit();
            listEmpleados[i][4] = empleados.get(i).getDpi();
            listEmpleados[i][5] = empleados.get(i).getEmail();
        }
        
        empleadosTable.setModel(new javax.swing.table.DefaultTableModel(
            listEmpleados,
            new String [] {
                "Codigo", "Nombres", "Telefono", "NIT", "DPI", "E-mail"
            }
        ));
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton agregarClienteButton;
    private javax.swing.JButton agregarEmpleadoButton;
    private javax.swing.JLabel clientesLabel;
    private javax.swing.JTable clientesTable;
    private javax.swing.JButton editarClienteButton;
    private javax.swing.JButton editarEmpleadoButton;
    private javax.swing.JLabel empleadosLabel;
    private javax.swing.JTable empleadosTable;
    private javax.swing.JScrollPane scrollClientes;
    private javax.swing.JScrollPane scrollEmpleados;
    // End of variables declaration//GEN-END:variables
}