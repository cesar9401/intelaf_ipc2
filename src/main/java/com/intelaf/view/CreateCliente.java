
package com.intelaf.view;

import com.intelaf.controller.MainControl;
import com.intelaf.model.Cliente;
import com.intelaf.model.Producto;
import java.util.List;

/**
 *
 * @author cesar31
 */
public class CreateCliente extends javax.swing.JPanel {

    private MainControl control;
    private Cliente cliente;
    private List<Producto> productosCliente;
    private double total;
    
    /**
     * Creates new form createCliente
     */
    public CreateCliente() {
        initComponents();
        descuentoText.setText("0");
    }
    
    public void initializeControl(MainControl control, List<Producto> productosCliente, double total) {
        this.control = control;
        this.productosCliente = productosCliente;
        this.total = total;
    }
        
    private void setDatos() {
        if(cliente != null) {
            nombreText.setText(cliente.getNombre());
            telefonoText.setText(cliente.getTelefono());
            dpiText.setText((cliente.getDpi() != null) ? cliente.getDpi() : "");
            emailText.setText((cliente.getEmail() != null) ? cliente.getEmail() : "");
            direccionText.setText((cliente.getDireccion() != null) ? cliente.getDireccion() : "");
            creditoText.setText("Q. " + cliente.getCreditoCompra());
        }else {
            nombreText.setText("");
            telefonoText.setText("");
            dpiText.setText("");
            emailText.setText("");
            direccionText.setText("");
            creditoText.setText("Q. 0.00");
        }
        descuentoText.setText("0");
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
        nitLabel = new javax.swing.JLabel();
        nitText = new javax.swing.JTextField();
        nombreLabel = new javax.swing.JLabel();
        nombreText = new javax.swing.JTextField();
        telefonoLabel = new javax.swing.JLabel();
        telefonoText = new javax.swing.JTextField();
        dpiLabel = new javax.swing.JLabel();
        dpiText = new javax.swing.JTextField();
        emailLabel = new javax.swing.JLabel();
        emailText = new javax.swing.JTextField();
        direccionLabel = new javax.swing.JLabel();
        direccionText = new javax.swing.JTextField();
        creditoLabel = new javax.swing.JLabel();
        creditoText = new javax.swing.JTextField();
        aceptarButton = new javax.swing.JButton();
        buscarButton = new javax.swing.JButton();
        cancelarButton = new javax.swing.JButton();
        descuentoLabel = new javax.swing.JLabel();
        descuentoText = new javax.swing.JTextField();

        setBackground(new java.awt.Color(248, 147, 31));
        setForeground(new java.awt.Color(0, 0, 0));
        setMinimumSize(new java.awt.Dimension(600, 450));
        setPreferredSize(new java.awt.Dimension(600, 450));

        informacionLabel.setBackground(new java.awt.Color(248, 147, 31));
        informacionLabel.setFont(new java.awt.Font("sansserif", 1, 24)); // NOI18N
        informacionLabel.setForeground(new java.awt.Color(0, 0, 0));
        informacionLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        informacionLabel.setText("Informacion del Cliente");
        informacionLabel.setToolTipText("");
        informacionLabel.setMaximumSize(new java.awt.Dimension(300, 30));
        informacionLabel.setMinimumSize(new java.awt.Dimension(300, 30));
        informacionLabel.setPreferredSize(new java.awt.Dimension(300, 30));

        nitLabel.setBackground(new java.awt.Color(248, 147, 31));
        nitLabel.setFont(new java.awt.Font("sansserif", 1, 16)); // NOI18N
        nitLabel.setForeground(new java.awt.Color(0, 0, 0));
        nitLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        nitLabel.setText("NIT");
        nitLabel.setMaximumSize(new java.awt.Dimension(90, 24));
        nitLabel.setMinimumSize(new java.awt.Dimension(90, 24));
        nitLabel.setPreferredSize(new java.awt.Dimension(90, 24));

        nitText.setBackground(new java.awt.Color(255, 255, 255));
        nitText.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        nitText.setForeground(new java.awt.Color(0, 0, 0));
        nitText.setMinimumSize(new java.awt.Dimension(150, 30));
        nitText.setPreferredSize(new java.awt.Dimension(150, 30));
        nitText.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                nitTextKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                nitTextKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                nitTextKeyTyped(evt);
            }
        });

        nombreLabel.setBackground(new java.awt.Color(248, 147, 31));
        nombreLabel.setFont(new java.awt.Font("sansserif", 1, 16)); // NOI18N
        nombreLabel.setForeground(new java.awt.Color(0, 0, 0));
        nombreLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        nombreLabel.setText("Nombre");
        nombreLabel.setMaximumSize(new java.awt.Dimension(90, 24));
        nombreLabel.setMinimumSize(new java.awt.Dimension(90, 24));
        nombreLabel.setPreferredSize(new java.awt.Dimension(90, 24));

        nombreText.setBackground(new java.awt.Color(255, 255, 255));
        nombreText.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        nombreText.setForeground(new java.awt.Color(0, 0, 0));
        nombreText.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        nombreText.setMinimumSize(new java.awt.Dimension(402, 30));
        nombreText.setPreferredSize(new java.awt.Dimension(402, 30));

        telefonoLabel.setBackground(new java.awt.Color(248, 147, 31));
        telefonoLabel.setFont(new java.awt.Font("sansserif", 1, 16)); // NOI18N
        telefonoLabel.setForeground(new java.awt.Color(0, 0, 0));
        telefonoLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        telefonoLabel.setText("Telefono");
        telefonoLabel.setMaximumSize(new java.awt.Dimension(90, 24));
        telefonoLabel.setMinimumSize(new java.awt.Dimension(90, 24));
        telefonoLabel.setPreferredSize(new java.awt.Dimension(90, 24));

        telefonoText.setBackground(new java.awt.Color(255, 255, 255));
        telefonoText.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        telefonoText.setForeground(new java.awt.Color(0, 0, 0));
        telefonoText.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        telefonoText.setMinimumSize(new java.awt.Dimension(150, 30));
        telefonoText.setPreferredSize(new java.awt.Dimension(150, 30));

        dpiLabel.setBackground(new java.awt.Color(248, 147, 31));
        dpiLabel.setFont(new java.awt.Font("sansserif", 1, 16)); // NOI18N
        dpiLabel.setForeground(new java.awt.Color(0, 0, 0));
        dpiLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        dpiLabel.setText("DPI");
        dpiLabel.setMaximumSize(new java.awt.Dimension(90, 24));
        dpiLabel.setMinimumSize(new java.awt.Dimension(90, 24));
        dpiLabel.setPreferredSize(new java.awt.Dimension(90, 24));

        dpiText.setBackground(new java.awt.Color(255, 255, 255));
        dpiText.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        dpiText.setForeground(new java.awt.Color(0, 0, 0));
        dpiText.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        dpiText.setMinimumSize(new java.awt.Dimension(150, 30));
        dpiText.setPreferredSize(new java.awt.Dimension(150, 30));

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
        direccionLabel.setText("Direccion");
        direccionLabel.setMaximumSize(new java.awt.Dimension(90, 24));
        direccionLabel.setMinimumSize(new java.awt.Dimension(90, 24));
        direccionLabel.setPreferredSize(new java.awt.Dimension(90, 24));

        direccionText.setBackground(new java.awt.Color(255, 255, 255));
        direccionText.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        direccionText.setForeground(new java.awt.Color(0, 0, 0));
        direccionText.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        direccionText.setMinimumSize(new java.awt.Dimension(402, 30));
        direccionText.setPreferredSize(new java.awt.Dimension(402, 30));

        creditoLabel.setBackground(new java.awt.Color(248, 147, 31));
        creditoLabel.setFont(new java.awt.Font("sansserif", 1, 16)); // NOI18N
        creditoLabel.setForeground(new java.awt.Color(0, 0, 0));
        creditoLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        creditoLabel.setText("Credito");
        creditoLabel.setMaximumSize(new java.awt.Dimension(90, 24));
        creditoLabel.setMinimumSize(new java.awt.Dimension(90, 24));
        creditoLabel.setPreferredSize(new java.awt.Dimension(90, 24));

        creditoText.setEditable(false);
        creditoText.setBackground(new java.awt.Color(255, 255, 255));
        creditoText.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        creditoText.setForeground(new java.awt.Color(0, 0, 0));
        creditoText.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        creditoText.setText("Q. 0.00");
        creditoText.setMinimumSize(new java.awt.Dimension(150, 30));
        creditoText.setPreferredSize(new java.awt.Dimension(150, 30));

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

        buscarButton.setBackground(new java.awt.Color(0, 0, 0));
        buscarButton.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        buscarButton.setForeground(new java.awt.Color(248, 147, 31));
        buscarButton.setText("Buscar");
        buscarButton.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(248, 117, 12)));
        buscarButton.setMinimumSize(new java.awt.Dimension(125, 32));
        buscarButton.setPreferredSize(new java.awt.Dimension(125, 32));
        buscarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarButtonActionPerformed(evt);
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

        descuentoLabel.setBackground(new java.awt.Color(248, 147, 31));
        descuentoLabel.setFont(new java.awt.Font("sansserif", 1, 16)); // NOI18N
        descuentoLabel.setForeground(new java.awt.Color(0, 0, 0));
        descuentoLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        descuentoLabel.setText("Descuento");
        descuentoLabel.setMaximumSize(new java.awt.Dimension(90, 24));
        descuentoLabel.setMinimumSize(new java.awt.Dimension(90, 24));
        descuentoLabel.setPreferredSize(new java.awt.Dimension(90, 24));

        descuentoText.setBackground(new java.awt.Color(255, 255, 255));
        descuentoText.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        descuentoText.setForeground(new java.awt.Color(0, 0, 0));
        descuentoText.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        descuentoText.setMinimumSize(new java.awt.Dimension(150, 30));
        descuentoText.setPreferredSize(new java.awt.Dimension(150, 30));
        descuentoText.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                descuentoTextKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(150, 150, 150)
                        .addComponent(informacionLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(telefonoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(nombreLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(nitLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(emailLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(direccionLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(creditoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(nitText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(buscarButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(nombreText, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(emailText, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(telefonoText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(dpiLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(dpiText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(direccionText, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(aceptarButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(creditoText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(descuentoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(descuentoText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(41, 41, 41)
                                        .addComponent(cancelarButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                .addContainerGap(71, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(informacionLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nitLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nitText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buscarButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nombreLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nombreText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(telefonoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(telefonoText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dpiLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dpiText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(emailLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(emailText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(direccionText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(direccionLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(creditoText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(creditoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(descuentoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(descuentoText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(aceptarButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cancelarButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(55, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Metodo para verificar la informacion del ciente antes de procesar la venta
     * @param evt 
     */
    private void aceptarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aceptarButtonActionPerformed
        // TODO add your handling code here:
        String nit = nitText.getText();
        String nombre = nombreText.getText();
        String telefono = telefonoText.getText();
        String dpi = dpiText.getText();
        String email = emailText.getText();
        String direccion = direccionText.getText();
        String descString = descuentoText.getText();
        if(!nit.isEmpty() && !nombre.isEmpty() && !telefono.isEmpty()) {
            double descuento = getDescuentoDouble(descString);
            if(descuento >= 0) {
                if(verificarCredito(descuento)) {
                    if(descuento <= this.total) {
                        boolean nuevo = false;
                        if(cliente != null) {
                            cliente.setNombre(nombre);
                            cliente.setTelefono(telefono);
                            cliente.setDpi(dpi);
                            cliente.setEmail(email);
                            cliente.setDireccion(direccion);
                        } else {
                            cliente = new Cliente(nombre, telefono, 0);
                            cliente.setNit(nit);
                            cliente.setDpi(dpi);
                            cliente.setEmail(email);
                            cliente.setDireccion(direccion);
                            nuevo = true;
                        }
                        //Enviar cliente y listado de productos
                        control.procesarVenta(cliente, nuevo, descuento, total, productosCliente);
                        
                    } else {
                        control.crearAlerta("Advertencia", "El descuento(Q. " + descuento + ") no puede ser mayor que el total(Q. " + this.total + ")", null);
                    }
                }else {
                    control.crearAlerta("Error", "El cliente no cuenta con credito sufuciente para esta transacción", null);
                }
            } else {
                control.crearAlerta("Error", "El valor ingresado para descuento no es valido", null);
                descuentoText.setText("");
            }
        } else {
            control.crearAlerta("Error", "Debe llenar los campos nit, nombre y telefono", null);
        }
    }//GEN-LAST:event_aceptarButtonActionPerformed

    private boolean verificarCredito(double descuento) {
        if(descuento == 0) {
            return true;
        }
        
        if(cliente == null && descuento > 0) {
            return false;
        }
        
        return cliente.getCreditoCompra() >= descuento;
    }
    
    private double getDescuentoDouble(String descString) {
        if(descString.isEmpty() || descString.isBlank()) {
            return 0;
        }
        
        try {
            return Double.parseDouble(descString);
        } catch (NumberFormatException e) {
            return -1;
        }
    }
    
    private void cancelarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarButtonActionPerformed
        // TODO add your handling code here:
        control.closeModal();
    }//GEN-LAST:event_cancelarButtonActionPerformed

    private void buscarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarButtonActionPerformed
        // TODO add your handling code here:
        String nit = nitText.getText();
        if(!nit.isEmpty()) {
            this.cliente = control.getCliente(nit);
            setDatos();
            if(this.cliente == null){
                control.crearAlerta("Advertencia", "No hay coincidencias", null);
            } else {
                control.crearAlerta("Informacion", "El cliente: " + cliente.getNit() + " ha sido agregado", null);
            }
        } else {
            control.crearAlerta("Advertencia", "Debe llenar el campo nit", null);
        }
    }//GEN-LAST:event_buscarButtonActionPerformed

    private void nitTextKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nitTextKeyReleased
        // TODO add your handling code here:
        if(!nitText.getText().isEmpty() && !nitText.getText().isBlank()){
            this.cliente = control.getCliente(nitText.getText());
        } else {
            this.cliente = null;
        }
        setDatos();
    }//GEN-LAST:event_nitTextKeyReleased

    private void nitTextKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nitTextKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_nitTextKeyPressed

    private void nitTextKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nitTextKeyTyped
        // TODO add your handling code here:
        if(nitText.getText().length() == 10) {
            evt.consume();
        }
    }//GEN-LAST:event_nitTextKeyTyped

    private void descuentoTextKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_descuentoTextKeyReleased
        // TODO add your handling code here:
        String descuento = descuentoText.getText();
        Double credito = 0.0;
        try {
            credito = Double.parseDouble(descuento);
        } catch (NumberFormatException e) {
            descuentoText.setText("");
        }
    }//GEN-LAST:event_descuentoTextKeyReleased

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton aceptarButton;
    private javax.swing.JButton buscarButton;
    private javax.swing.JButton cancelarButton;
    private javax.swing.JLabel creditoLabel;
    private javax.swing.JTextField creditoText;
    private javax.swing.JLabel descuentoLabel;
    private javax.swing.JTextField descuentoText;
    private javax.swing.JLabel direccionLabel;
    private javax.swing.JTextField direccionText;
    private javax.swing.JLabel dpiLabel;
    private javax.swing.JTextField dpiText;
    private javax.swing.JLabel emailLabel;
    private javax.swing.JTextField emailText;
    private javax.swing.JLabel informacionLabel;
    private javax.swing.JLabel nitLabel;
    private javax.swing.JTextField nitText;
    private javax.swing.JLabel nombreLabel;
    private javax.swing.JTextField nombreText;
    private javax.swing.JLabel telefonoLabel;
    private javax.swing.JTextField telefonoText;
    // End of variables declaration//GEN-END:variables
}
