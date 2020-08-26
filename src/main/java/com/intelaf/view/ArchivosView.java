
package com.intelaf.view;

import com.intelaf.controller.*;
import com.intelaf.model.Tienda;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFileChooser;



/**
 *
 * @author cesar31
 */
public class ArchivosView extends javax.swing.JFrame {

    private MainControl control;
    private List<String> datos;
    private String [][] listDatos;
    
    /**
     * Creates new form ArchivosView
     */
    public ArchivosView() {
        initComponents();
    }
    
    public void initializeControl(MainControl control) {
        this.control = control;
        datos = new ArrayList<>();
    }
    
    public void setInfo(String line){
        datos.add(line);
        updateTable();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainPanel = new javax.swing.JPanel();
        buttonIntelaf = new javax.swing.JButton();
        datosScroll = new javax.swing.JScrollPane();
        datosTable = new javax.swing.JTable();
        aceptarButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Intelaf");
        setBackground(new java.awt.Color(235, 235, 235));
        setMinimumSize(new java.awt.Dimension(800, 500));
        setResizable(false);

        mainPanel.setBackground(new java.awt.Color(248, 147, 31));
        mainPanel.setPreferredSize(new java.awt.Dimension(800, 500));

        buttonIntelaf.setBackground(new java.awt.Color(0, 0, 0));
        buttonIntelaf.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        buttonIntelaf.setForeground(new java.awt.Color(248, 147, 31));
        buttonIntelaf.setText("Cargar Datos..");
        buttonIntelaf.setBorder(null);
        buttonIntelaf.setMaximumSize(new java.awt.Dimension(120, 30));
        buttonIntelaf.setMinimumSize(new java.awt.Dimension(120, 40));
        buttonIntelaf.setPreferredSize(new java.awt.Dimension(150, 36));
        buttonIntelaf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonIntelafActionPerformed(evt);
            }
        });

        datosTable.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        datosTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        datosTable.setPreferredSize(new java.awt.Dimension(750, 144));
        datosTable.setRowHeight(36);
        datosTable.setSelectionBackground(new java.awt.Color(0, 0, 0));
        datosTable.setSelectionForeground(new java.awt.Color(248, 147, 31));
        datosScroll.setViewportView(datosTable);

        aceptarButton.setBackground(new java.awt.Color(0, 0, 0));
        aceptarButton.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        aceptarButton.setForeground(new java.awt.Color(248, 147, 31));
        aceptarButton.setText("Aceptar");
        aceptarButton.setBorder(null);
        aceptarButton.setMaximumSize(new java.awt.Dimension(120, 30));
        aceptarButton.setMinimumSize(new java.awt.Dimension(120, 40));
        aceptarButton.setPreferredSize(new java.awt.Dimension(150, 36));
        aceptarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aceptarButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(aceptarButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(buttonIntelaf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(datosScroll, javax.swing.GroupLayout.PREFERRED_SIZE, 748, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(34, Short.MAX_VALUE))
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(buttonIntelaf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(datosScroll, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(aceptarButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(109, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(mainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void updateTable() {
        listDatos = new String[datos.size()][1];
        
        for (int i = 0; i < datos.size(); i++) {
            listDatos[i][0] = datos.get(i);
        }
        
        datosTable.setPreferredSize(new java.awt.Dimension(750, 36*datos.size()));
        datosTable.setModel(new javax.swing.table.DefaultTableModel(
            listDatos,
            new String [] {
                "DATO"
            }
        ));
    }
    
    private void buttonIntelafActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonIntelafActionPerformed
        // TODO add your handling code here:
        JFileChooser fileChooser = new JFileChooser();
        int seleccion = fileChooser.showOpenDialog(this);
        if(seleccion == JFileChooser.APPROVE_OPTION) {
            File data = fileChooser.getSelectedFile();
            String path = data.getAbsolutePath();
            LecturaArchivos lectura = new LecturaArchivos(this.control);
            lectura.readData(path);
        }
    }//GEN-LAST:event_buttonIntelafActionPerformed

    private void aceptarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aceptarButtonActionPerformed
        // TODO add your handling code here:
        List<Tienda> tiendas = control.getTiendas();
        if(!tiendas.isEmpty()) {
            control.closeArchivos();
            control.showLogin();
        } else {
            control.crearAlerta("Error", "No hay datos para iniciar el sistema", this);
        }
    }//GEN-LAST:event_aceptarButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton aceptarButton;
    private javax.swing.JButton buttonIntelaf;
    private javax.swing.JScrollPane datosScroll;
    private javax.swing.JTable datosTable;
    private javax.swing.JPanel mainPanel;
    // End of variables declaration//GEN-END:variables
}
