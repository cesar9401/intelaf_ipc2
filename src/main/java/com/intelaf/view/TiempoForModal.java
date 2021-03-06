
package com.intelaf.view;

import com.intelaf.controller.MainControl;
import com.intelaf.model.*;
import java.util.*;

/**
 *
 * @author cesar31
 */
public class TiempoForModal extends javax.swing.JPanel {

    private MainControl control;
    private Tienda tienda;
    private List<Tienda> tiendas;
    private List<Tiempo> tiempos;
    private String[][] listTiendas;
    
    /**
     * Creates new form createCliente
     */
    public TiempoForModal() {
        initComponents();
    }
    
    public void initializeControl(MainControl control) {
        this.control = control;
    }
    
    public void initializeTienda(Tienda tienda) {
        this.tienda = tienda;     
        this.informacionLabel.setText("Sucursal: " + tienda.getCodigo());
        tiendas = this.control.getTiendasExcept(this.tienda.getCodigo());
        getTiempos();
        setTableTiendas();
    }
    
    private void getTiempos() {
        tiendas.forEach((t) -> {
            Tiempo time = control.getTiempo(this.tienda.getCodigo(), t.getCodigo());
            if(time != null) {
                System.out.println(time.toString());
                t.setTiempo(time.getTiempoDias());
            } else {
                t.setTiempo(-1);
            }
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        informacionLabel = new javax.swing.JLabel();
        editarButton = new javax.swing.JButton();
        aceptarButton = new javax.swing.JButton();
        horarioLabel = new javax.swing.JLabel();
        scrollTableTiendas = new javax.swing.JScrollPane();
        tableTiendas = new javax.swing.JTable();
        tiempoText = new javax.swing.JTextField();

        setBackground(new java.awt.Color(248, 147, 31));
        setForeground(new java.awt.Color(0, 0, 0));
        setMinimumSize(new java.awt.Dimension(600, 450));
        setPreferredSize(new java.awt.Dimension(600, 450));

        informacionLabel.setBackground(new java.awt.Color(248, 147, 31));
        informacionLabel.setFont(new java.awt.Font("sansserif", 1, 24)); // NOI18N
        informacionLabel.setForeground(new java.awt.Color(0, 0, 0));
        informacionLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        informacionLabel.setText("Informacion de la Sucursal");
        informacionLabel.setToolTipText("");
        informacionLabel.setMaximumSize(new java.awt.Dimension(350, 30));
        informacionLabel.setMinimumSize(new java.awt.Dimension(350, 30));
        informacionLabel.setPreferredSize(new java.awt.Dimension(350, 30));

        editarButton.setBackground(new java.awt.Color(0, 0, 0));
        editarButton.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        editarButton.setForeground(new java.awt.Color(248, 147, 31));
        editarButton.setText("Editar");
        editarButton.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(248, 117, 12)));
        editarButton.setMinimumSize(new java.awt.Dimension(125, 32));
        editarButton.setPreferredSize(new java.awt.Dimension(125, 32));
        editarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editarButtonActionPerformed(evt);
            }
        });

        aceptarButton.setBackground(new java.awt.Color(0, 0, 0));
        aceptarButton.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        aceptarButton.setForeground(new java.awt.Color(248, 147, 31));
        aceptarButton.setText("Aceptar");
        aceptarButton.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(248, 117, 12)));
        aceptarButton.setMinimumSize(new java.awt.Dimension(125, 32));
        aceptarButton.setPreferredSize(new java.awt.Dimension(125, 32));
        aceptarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aceptarButtonActionPerformed(evt);
            }
        });

        horarioLabel.setBackground(new java.awt.Color(248, 147, 31));
        horarioLabel.setFont(new java.awt.Font("sansserif", 1, 16)); // NOI18N
        horarioLabel.setForeground(new java.awt.Color(0, 0, 0));
        horarioLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        horarioLabel.setText("Dias:");
        horarioLabel.setMaximumSize(new java.awt.Dimension(90, 24));
        horarioLabel.setMinimumSize(new java.awt.Dimension(90, 24));
        horarioLabel.setPreferredSize(new java.awt.Dimension(90, 24));

        scrollTableTiendas.setPreferredSize(new java.awt.Dimension(405, 350));

        tableTiendas.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        tableTiendas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Nombre", "Direccion", "Tiempo"
            }
        ));
        tableTiendas.setPreferredSize(new java.awt.Dimension(525, 150));
        tableTiendas.setRowHeight(36);
        tableTiendas.setSelectionBackground(new java.awt.Color(0, 0, 0));
        tableTiendas.setSelectionForeground(new java.awt.Color(248, 147, 31));
        tableTiendas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableTiendasMouseClicked(evt);
            }
        });
        scrollTableTiendas.setViewportView(tableTiendas);

        tiempoText.setBackground(new java.awt.Color(255, 255, 255));
        tiempoText.setFont(new java.awt.Font("sansserif", 0, 24)); // NOI18N
        tiempoText.setForeground(new java.awt.Color(0, 0, 0));
        tiempoText.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tiempoText.setAutoscrolls(false);
        tiempoText.setMinimumSize(new java.awt.Dimension(75, 36));
        tiempoText.setPreferredSize(new java.awt.Dimension(75, 36));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(scrollTableTiendas, javax.swing.GroupLayout.PREFERRED_SIZE, 525, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(38, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(informacionLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(123, 123, 123))
            .addGroup(layout.createSequentialGroup()
                .addGap(238, 238, 238)
                .addComponent(aceptarButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(horarioLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tiempoText, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(editarButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(130, 130, 130))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(informacionLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(scrollTableTiendas, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(horarioLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(editarButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tiempoText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                .addComponent(aceptarButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40))
        );
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Metodo para verificar la informacion del ciente antes de procesar la venta
     * @param evt 
     */
    private void editarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editarButtonActionPerformed
        // TODO add your handling code here:
        int row = tableTiendas.getSelectedRow();
        if(row != -1) {
            int cantidad = -1;
            if(!tiempoText.getText().isEmpty() && !tiempoText.getText().isBlank()) {
                try {
                    cantidad = Integer.parseInt(tiempoText.getText());
                    if(cantidad >= 0) {
                        System.out.println("Cantidad: " + cantidad);
                        System.out.println("Tienda Destino: " + tiendas.get(row).getCodigo());
                            Tiempo tmp = new Tiempo(this.tienda.getCodigo(), tiendas.get(row).getCodigo(), cantidad);
                            
                        if(tiendas.get(row).getTiempo() == -1) {
                            //Write code for new here
                            control.setTiempo(tmp);
                        }else {
                            //Write code for update here
                            control.setUpdateTiempo(tmp);
                        }
                    } else {
                        control.crearAlerta("Error", "El valor proporcionado no es valido", null);
                    }
                } catch (NumberFormatException e) {
                    control.crearAlerta("Error", "El valor proporcionado no es valido", null);
                }
            } else {
                control.crearAlerta("Error", "Debe indicar el tiempo para los pedidos", null);
            }
        } else {
            control.crearAlerta("Error", "Debe seleccionar una tienda para poder editar", null);
        }
    }//GEN-LAST:event_editarButtonActionPerformed
    
    private void aceptarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aceptarButtonActionPerformed
        // TODO add your handling code here:
        control.closeModal();
    }//GEN-LAST:event_aceptarButtonActionPerformed

    private void tableTiendasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableTiendasMouseClicked
        // TODO add your handling code here:
        int row = tableTiendas.getSelectedRow();
        if(row != -1) {
            this.tiempoText.setText(tiendas.get(row).getTiempo() != -1 ? String.valueOf(tiendas.get(row).getTiempo()) : "");
        }
    }//GEN-LAST:event_tableTiendasMouseClicked

    private void setTableTiendas() {
        listTiendas = new String[tiendas.size()][4];
        
        for (int i=0; i<tiendas.size(); i++) {
            listTiendas[i][0] = tiendas.get(i).getCodigo();
            listTiendas[i][1] = tiendas.get(i).getNombre();
            listTiendas[i][2] = tiendas.get(i).getDireccion();
            listTiendas[i][3] = tiendas.get(i).getTiempo() != -1 ? String.valueOf(tiendas.get(i).getTiempo()) : "NULL";
        }
        
        tableTiendas.setPreferredSize(new java.awt.Dimension(525, 36*tiendas.size()));
        tableTiendas.setModel(new javax.swing.table.DefaultTableModel(
            listTiendas,
            new String [] {
                "Codigo", "Nombre", "Direccion", "Tiempo"
            }
        ));        
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton aceptarButton;
    private javax.swing.JButton editarButton;
    private javax.swing.JLabel horarioLabel;
    private javax.swing.JLabel informacionLabel;
    private javax.swing.JScrollPane scrollTableTiendas;
    private javax.swing.JTable tableTiendas;
    private javax.swing.JTextField tiempoText;
    // End of variables declaration//GEN-END:variables
}
