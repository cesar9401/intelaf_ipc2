
package com.intelaf.view;

import com.intelaf.controller.MainControl;
import com.intelaf.model.*;

/**
 *
 * @author cesar31
 */
public class MainView extends javax.swing.JFrame {

    private MainControl control;
    private Tienda tienda;
    private Empleado empleado;
    
    private MainPanel mainPanel;
    private VentaView venta;
    
    /**
     * Creates new form MainView
     */
    public MainView() {
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

        navPanel = new javax.swing.JPanel();
        inicioButton = new javax.swing.JButton();
        salirButton = new javax.swing.JButton();
        ventasButton = new javax.swing.JButton();
        pedidosButton = new javax.swing.JButton();
        contenedorPanel = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 140, 0));
        setMinimumSize(new java.awt.Dimension(1024, 700));
        setResizable(false);

        navPanel.setBackground(new java.awt.Color(245, 245, 245));
        navPanel.setForeground(new java.awt.Color(255, 153, 51));
        navPanel.setMinimumSize(new java.awt.Dimension(200, 700));
        navPanel.setPreferredSize(new java.awt.Dimension(200, 700));

        inicioButton.setBackground(new java.awt.Color(255, 140, 0));
        inicioButton.setFont(new java.awt.Font("sansserif", 0, 20)); // NOI18N
        inicioButton.setForeground(new java.awt.Color(255, 255, 255));
        inicioButton.setText("Inicio");
        inicioButton.setAlignmentY(0.0F);
        inicioButton.setBorder(null);
        inicioButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        inicioButton.setMinimumSize(new java.awt.Dimension(120, 40));
        inicioButton.setPreferredSize(new java.awt.Dimension(120, 40));
        inicioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inicioButtonActionPerformed(evt);
            }
        });

        salirButton.setBackground(new java.awt.Color(255, 140, 0));
        salirButton.setFont(new java.awt.Font("sansserif", 0, 20)); // NOI18N
        salirButton.setForeground(new java.awt.Color(255, 255, 255));
        salirButton.setText("Salir");
        salirButton.setAlignmentY(0.0F);
        salirButton.setBorder(null);
        salirButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        salirButton.setMaximumSize(new java.awt.Dimension(120, 40));
        salirButton.setMinimumSize(new java.awt.Dimension(120, 40));
        salirButton.setPreferredSize(new java.awt.Dimension(120, 40));
        salirButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salirButtonActionPerformed(evt);
            }
        });

        ventasButton.setBackground(new java.awt.Color(255, 140, 0));
        ventasButton.setFont(new java.awt.Font("sansserif", 0, 20)); // NOI18N
        ventasButton.setForeground(new java.awt.Color(255, 255, 255));
        ventasButton.setText("Nueva Venta");
        ventasButton.setAlignmentY(0.0F);
        ventasButton.setBorder(null);
        ventasButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        ventasButton.setMinimumSize(new java.awt.Dimension(120, 40));
        ventasButton.setPreferredSize(new java.awt.Dimension(120, 40));
        ventasButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ventasButtonActionPerformed(evt);
            }
        });

        pedidosButton.setBackground(new java.awt.Color(255, 140, 0));
        pedidosButton.setFont(new java.awt.Font("sansserif", 0, 20)); // NOI18N
        pedidosButton.setForeground(new java.awt.Color(255, 255, 255));
        pedidosButton.setText("Pedidos");
        pedidosButton.setAlignmentY(0.0F);
        pedidosButton.setBorder(null);
        pedidosButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        pedidosButton.setMinimumSize(new java.awt.Dimension(120, 40));
        pedidosButton.setPreferredSize(new java.awt.Dimension(120, 40));
        pedidosButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pedidosButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout navPanelLayout = new javax.swing.GroupLayout(navPanel);
        navPanel.setLayout(navPanelLayout);
        navPanelLayout.setHorizontalGroup(
            navPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(navPanelLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(navPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(inicioButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(salirButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ventasButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pedidosButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40))
        );
        navPanelLayout.setVerticalGroup(
            navPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(navPanelLayout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(inicioButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(ventasButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(pedidosButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(salirButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28))
        );

        contenedorPanel.setBackground(new java.awt.Color(235, 235, 235));
        contenedorPanel.setMinimumSize(new java.awt.Dimension(800, 700));
        contenedorPanel.setPreferredSize(new java.awt.Dimension(800, 700));
        contenedorPanel.setLayout(new java.awt.BorderLayout());

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(navPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(contenedorPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 818, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(navPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(contenedorPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void initializeComponents(MainControl control, Tienda tienda, Empleado empleado) {
        this.control = control;
        this.tienda = tienda;
        this.empleado = empleado;
        
        //Inicializar MainPanel y componentes
        this.mainPanel = new MainPanel();
        mainPanel.initializeComponents(this.tienda, this.empleado);
        this.contenedorPanel.add(mainPanel); 
    }
    
    private void inicioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inicioButtonActionPerformed
        // TODO add your handling code here:
        this.contenedorPanel.setVisible(false);
        this.contenedorPanel.removeAll();
        this.contenedorPanel.add(mainPanel);        
        this.contenedorPanel.setVisible(true);
    }//GEN-LAST:event_inicioButtonActionPerformed

    private void salirButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salirButtonActionPerformed
        // TODO add your handling code here:
        control.cerrarSesion();
    }//GEN-LAST:event_salirButtonActionPerformed

    private void ventasButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ventasButtonActionPerformed
        // TODO add your handling code here:
        //Iniciarlizar ventas
        venta = new VentaView();
        
        //Agregar a los componentes
        this.contenedorPanel.removeAll();
        this.contenedorPanel.setVisible(false);
        venta.initializeComponents(control, tienda);
        this.contenedorPanel.add(venta);
        this.contenedorPanel.setVisible(true);
    }//GEN-LAST:event_ventasButtonActionPerformed

    private void pedidosButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pedidosButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pedidosButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel contenedorPanel;
    private javax.swing.JButton inicioButton;
    private javax.swing.JPanel navPanel;
    private javax.swing.JButton pedidosButton;
    private javax.swing.JButton salirButton;
    private javax.swing.JButton ventasButton;
    // End of variables declaration//GEN-END:variables
}
