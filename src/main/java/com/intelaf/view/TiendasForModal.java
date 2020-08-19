
package com.intelaf.view;

import com.intelaf.controller.MainControl;
import com.intelaf.model.*;

/**
 *
 * @author cesar31
 */
public class TiendasForModal extends javax.swing.JPanel {

    private MainControl control;
    private boolean isEdit;
    private Tienda tienda;
    
    /**
     * Creates new form createCliente
     */
    public TiendasForModal() {
        initComponents();
    }
    
    public void initializeControl(MainControl control) {
        this.control = control;
    }
    
    public void initializeTienda(Tienda tienda) {
        this.tienda = tienda;
        setEditar();
    }
        
    private void setEditar() {
        isEdit = true;
        codigoText.setEditable(false);
        setDatos();
    }
        
    private void setDatos() {
        if(tienda != null) {
//            codigoText.setText(isEmpleado ? codigo : persona.getNit());
//            nombreText.setText(persona.getNombre());
//            telefono1Text.setText(persona.getTelefono());
//            telefono2Text.setText((persona.getDpi() != null) ? persona.getDpi() : "");
//            emailText.setText((persona.getEmail() != null) ? persona.getEmail() : "");
//            direccionText.setText((persona.getDireccion() != null) ? persona.getDireccion() : "");
//            creditoText.setText(isEmpleado ? persona.getNit() : "Q. " + credito);
        }else {
//            nombreText.setText("");
//            telefono1Text.setText("");
//            telefono2Text.setText("");
//            emailText.setText("");
//            direccionText.setText("");
//            creditoText.setText(isEmpleado ? "" : "Q. 0.00");
        }
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
        codigoLabel = new javax.swing.JLabel();
        codigoText = new javax.swing.JTextField();
        nombreLabel = new javax.swing.JLabel();
        nombreText = new javax.swing.JTextField();
        telefono1Label = new javax.swing.JLabel();
        telefono1Text = new javax.swing.JTextField();
        telefono2Label = new javax.swing.JLabel();
        telefono2Text = new javax.swing.JTextField();
        emailLabel = new javax.swing.JLabel();
        emailText = new javax.swing.JTextField();
        direccionLabel = new javax.swing.JLabel();
        direccionText = new javax.swing.JTextField();
        aceptarButton = new javax.swing.JButton();
        cancelarButton = new javax.swing.JButton();
        horarioLabel = new javax.swing.JLabel();
        horarioText = new javax.swing.JTextField();

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

        codigoLabel.setBackground(new java.awt.Color(248, 147, 31));
        codigoLabel.setFont(new java.awt.Font("sansserif", 1, 16)); // NOI18N
        codigoLabel.setForeground(new java.awt.Color(0, 0, 0));
        codigoLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        codigoLabel.setText("Codigo(*)");
        codigoLabel.setMaximumSize(new java.awt.Dimension(90, 24));
        codigoLabel.setMinimumSize(new java.awt.Dimension(90, 24));
        codigoLabel.setPreferredSize(new java.awt.Dimension(90, 24));

        codigoText.setBackground(new java.awt.Color(255, 255, 255));
        codigoText.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        codigoText.setForeground(new java.awt.Color(0, 0, 0));
        codigoText.setMinimumSize(new java.awt.Dimension(150, 30));
        codigoText.setPreferredSize(new java.awt.Dimension(150, 30));
        codigoText.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                codigoTextKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                codigoTextKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                codigoTextKeyTyped(evt);
            }
        });

        nombreLabel.setBackground(new java.awt.Color(248, 147, 31));
        nombreLabel.setFont(new java.awt.Font("sansserif", 1, 16)); // NOI18N
        nombreLabel.setForeground(new java.awt.Color(0, 0, 0));
        nombreLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        nombreLabel.setText("Nombre(*)");
        nombreLabel.setMaximumSize(new java.awt.Dimension(90, 24));
        nombreLabel.setMinimumSize(new java.awt.Dimension(90, 24));
        nombreLabel.setPreferredSize(new java.awt.Dimension(90, 24));

        nombreText.setBackground(new java.awt.Color(255, 255, 255));
        nombreText.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        nombreText.setForeground(new java.awt.Color(0, 0, 0));
        nombreText.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        nombreText.setMinimumSize(new java.awt.Dimension(402, 30));
        nombreText.setPreferredSize(new java.awt.Dimension(402, 30));

        telefono1Label.setBackground(new java.awt.Color(248, 147, 31));
        telefono1Label.setFont(new java.awt.Font("sansserif", 1, 16)); // NOI18N
        telefono1Label.setForeground(new java.awt.Color(0, 0, 0));
        telefono1Label.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        telefono1Label.setText("Telefono 1(*)");
        telefono1Label.setMaximumSize(new java.awt.Dimension(90, 24));
        telefono1Label.setMinimumSize(new java.awt.Dimension(90, 24));
        telefono1Label.setPreferredSize(new java.awt.Dimension(90, 24));

        telefono1Text.setBackground(new java.awt.Color(255, 255, 255));
        telefono1Text.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        telefono1Text.setForeground(new java.awt.Color(0, 0, 0));
        telefono1Text.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        telefono1Text.setMinimumSize(new java.awt.Dimension(150, 30));
        telefono1Text.setPreferredSize(new java.awt.Dimension(150, 30));

        telefono2Label.setBackground(new java.awt.Color(248, 147, 31));
        telefono2Label.setFont(new java.awt.Font("sansserif", 1, 16)); // NOI18N
        telefono2Label.setForeground(new java.awt.Color(0, 0, 0));
        telefono2Label.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        telefono2Label.setText("Telefono 2");
        telefono2Label.setMaximumSize(new java.awt.Dimension(90, 24));
        telefono2Label.setMinimumSize(new java.awt.Dimension(90, 24));
        telefono2Label.setPreferredSize(new java.awt.Dimension(90, 24));

        telefono2Text.setBackground(new java.awt.Color(255, 255, 255));
        telefono2Text.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        telefono2Text.setForeground(new java.awt.Color(0, 0, 0));
        telefono2Text.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        telefono2Text.setMinimumSize(new java.awt.Dimension(150, 30));
        telefono2Text.setPreferredSize(new java.awt.Dimension(150, 30));

        emailLabel.setBackground(new java.awt.Color(248, 147, 31));
        emailLabel.setFont(new java.awt.Font("sansserif", 1, 16)); // NOI18N
        emailLabel.setForeground(new java.awt.Color(0, 0, 0));
        emailLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        emailLabel.setText("Email");
        emailLabel.setMaximumSize(new java.awt.Dimension(90, 24));
        emailLabel.setMinimumSize(new java.awt.Dimension(90, 24));
        emailLabel.setPreferredSize(new java.awt.Dimension(90, 24));

        emailText.setBackground(new java.awt.Color(255, 255, 255));
        emailText.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        emailText.setForeground(new java.awt.Color(0, 0, 0));
        emailText.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        emailText.setMinimumSize(new java.awt.Dimension(402, 30));
        emailText.setPreferredSize(new java.awt.Dimension(402, 30));

        direccionLabel.setBackground(new java.awt.Color(248, 147, 31));
        direccionLabel.setFont(new java.awt.Font("sansserif", 1, 16)); // NOI18N
        direccionLabel.setForeground(new java.awt.Color(0, 0, 0));
        direccionLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        direccionLabel.setText("Direccion(*)");
        direccionLabel.setMaximumSize(new java.awt.Dimension(90, 24));
        direccionLabel.setMinimumSize(new java.awt.Dimension(90, 24));
        direccionLabel.setPreferredSize(new java.awt.Dimension(90, 24));

        direccionText.setBackground(new java.awt.Color(255, 255, 255));
        direccionText.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        direccionText.setForeground(new java.awt.Color(0, 0, 0));
        direccionText.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        direccionText.setMinimumSize(new java.awt.Dimension(402, 30));
        direccionText.setPreferredSize(new java.awt.Dimension(402, 30));

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

        cancelarButton.setBackground(new java.awt.Color(0, 0, 0));
        cancelarButton.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        cancelarButton.setForeground(new java.awt.Color(248, 147, 31));
        cancelarButton.setText("Cancelar");
        cancelarButton.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(248, 117, 12)));
        cancelarButton.setMinimumSize(new java.awt.Dimension(125, 32));
        cancelarButton.setPreferredSize(new java.awt.Dimension(125, 32));
        cancelarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarButtonActionPerformed(evt);
            }
        });

        horarioLabel.setBackground(new java.awt.Color(248, 147, 31));
        horarioLabel.setFont(new java.awt.Font("sansserif", 1, 16)); // NOI18N
        horarioLabel.setForeground(new java.awt.Color(0, 0, 0));
        horarioLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        horarioLabel.setText("Horario");
        horarioLabel.setMaximumSize(new java.awt.Dimension(90, 24));
        horarioLabel.setMinimumSize(new java.awt.Dimension(90, 24));
        horarioLabel.setPreferredSize(new java.awt.Dimension(90, 24));

        horarioText.setBackground(new java.awt.Color(255, 255, 255));
        horarioText.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        horarioText.setForeground(new java.awt.Color(0, 0, 0));
        horarioText.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        horarioText.setMinimumSize(new java.awt.Dimension(402, 30));
        horarioText.setPreferredSize(new java.awt.Dimension(402, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(nombreLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(codigoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(emailLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(direccionLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(telefono1Label, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(horarioLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(telefono1Text, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                        .addComponent(telefono2Label, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(telefono2Text, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(nombreText, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(emailText, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(direccionText, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(informacionLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(codigoText, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(horarioText, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(76, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(aceptarButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addComponent(cancelarButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(158, 158, 158))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(informacionLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(codigoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(codigoText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nombreLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nombreText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(direccionText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(direccionLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(telefono2Text, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(telefono1Text, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(telefono2Label, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(telefono1Label, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(emailLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(emailText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(horarioText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(horarioLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(aceptarButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cancelarButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(53, 53, 53))
        );
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Metodo para verificar la informacion del ciente antes de procesar la venta
     * @param evt 
     */
    private void aceptarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aceptarButtonActionPerformed
        // TODO add your handling code here:
        String nombre = nombreText.getText();
        String direccion = direccionText.getText();
        String codigo = codigoText.getText();
        String telefono1 = telefono1Text.getText();
        String telefono2 = telefono2Text.getText();
        String email = emailText.getText();
        String horario = horarioText.getText();
        
        if(!nombre.isEmpty() && !direccion.isEmpty() && !codigo.isEmpty() && !telefono1.isEmpty()) {
            if(tienda == null) {
                Tienda tmp = new Tienda(nombre, direccion, codigo, telefono1);
                tmp.setTelefono2(telefono2.isEmpty() ? null : telefono2);
                tmp.setEmail(email.isEmpty() ? null : email);
                tmp.setHorario(horario.isEmpty() ? null : horario);
                
                System.out.println(tmp.toString());
            } else {
                control.crearAlerta("Error", "Ya existe una tienda con ese codigo", null);
                codigoText.setText("");
            }
        } else {
            control.crearAlerta("Error", "Debe de llenar todos los campos obligatorios(*)", null);
        }
    }//GEN-LAST:event_aceptarButtonActionPerformed
    
    private void cancelarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarButtonActionPerformed
        // TODO add your handling code here:
        control.closeModal();
    }//GEN-LAST:event_cancelarButtonActionPerformed

    private void codigoTextKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_codigoTextKeyReleased
        // TODO add your handling code here:
        if(!codigoText.getText().isEmpty() && !codigoText.getText().isBlank()){
            this.tienda = control.getTienda(codigoText.getText());
        } else {
            this.tienda = null;
        }
    }//GEN-LAST:event_codigoTextKeyReleased

    private void codigoTextKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_codigoTextKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_codigoTextKeyPressed

    private void codigoTextKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_codigoTextKeyTyped
        // TODO add your handling code here:
        if(codigoText.getText().length() == 10) {
            evt.consume();
        }
    }//GEN-LAST:event_codigoTextKeyTyped

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton aceptarButton;
    private javax.swing.JButton cancelarButton;
    private javax.swing.JLabel codigoLabel;
    private javax.swing.JTextField codigoText;
    private javax.swing.JLabel direccionLabel;
    private javax.swing.JTextField direccionText;
    private javax.swing.JLabel emailLabel;
    private javax.swing.JTextField emailText;
    private javax.swing.JLabel horarioLabel;
    private javax.swing.JTextField horarioText;
    private javax.swing.JLabel informacionLabel;
    private javax.swing.JLabel nombreLabel;
    private javax.swing.JTextField nombreText;
    private javax.swing.JLabel telefono1Label;
    private javax.swing.JTextField telefono1Text;
    private javax.swing.JLabel telefono2Label;
    private javax.swing.JTextField telefono2Text;
    // End of variables declaration//GEN-END:variables
}
