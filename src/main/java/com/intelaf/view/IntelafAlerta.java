/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.intelaf.view;

/**
 *
 * @author cesar31
 */
public class IntelafAlerta extends javax.swing.JDialog {

    /**
     * Creates new form IntelafAlerta
     * @param parent
     * @param modal
     */
    public IntelafAlerta(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(null);
    }

    /**
     * Agregar titulo
     * @param titulo 
     */
    public void setTitulo(String titulo) {
        this.setTitle(titulo);
    }
    
    /**
     * Agregar mensaje
     * @param mensaje 
     */
    public void setMensaje(String mensaje) {
        this.mensajeLabel.setText(mensaje);
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
        mensajeLabel = new javax.swing.JLabel();
        aceptarButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(450, 200));
        setPreferredSize(new java.awt.Dimension(450, 200));
        setResizable(false);

        mainPanel.setBackground(new java.awt.Color(0, 0, 0));
        mainPanel.setForeground(new java.awt.Color(237, 116, 11));
        mainPanel.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        mainPanel.setMinimumSize(new java.awt.Dimension(450, 200));
        mainPanel.setPreferredSize(new java.awt.Dimension(450, 200));

        mensajeLabel.setBackground(new java.awt.Color(0, 0, 0));
        mensajeLabel.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        mensajeLabel.setForeground(new java.awt.Color(237, 116, 11));
        mensajeLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        mensajeLabel.setText("jLabel1");
        mensajeLabel.setMaximumSize(new java.awt.Dimension(315, 75));
        mensajeLabel.setMinimumSize(new java.awt.Dimension(315, 75));
        mensajeLabel.setPreferredSize(new java.awt.Dimension(315, 75));

        aceptarButton.setBackground(new java.awt.Color(237, 116, 11));
        aceptarButton.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        aceptarButton.setForeground(new java.awt.Color(0, 0, 0));
        aceptarButton.setText("Aceptar");
        aceptarButton.setMaximumSize(new java.awt.Dimension(125, 32));
        aceptarButton.setMinimumSize(new java.awt.Dimension(125, 32));
        aceptarButton.setPreferredSize(new java.awt.Dimension(125, 32));
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
                .addGap(162, 162, 162)
                .addComponent(aceptarButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(mensajeLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 450, Short.MAX_VALUE)
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(mensajeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(aceptarButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(60, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Cerrar modal
     * @param evt 
     */
    private void aceptarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aceptarButtonActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_aceptarButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton aceptarButton;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JLabel mensajeLabel;
    // End of variables declaration//GEN-END:variables
}
