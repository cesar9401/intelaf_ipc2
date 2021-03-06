
package com.intelaf.view;

import com.intelaf.controller.MainControl;
import com.intelaf.model.*;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.event.FocusEvent;
import java.util.Date;

/**
 *
 * @author cesar31
 */
public class MainView extends javax.swing.JFrame {

    private JDateChooser calendario;
    private MainControl control;
    private Tienda tienda;
    private Empleado empleado;
    
    private MainPanel mainPanel;
    private UsuarioView usuario;
    private TiendaView tiendaView;
    private VentaPedidoView ventaPedido;
    private ProductoView productoView;
    private RegistroView registroView;
    private ReportesView reportesView;
    
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
        setDateButton = new javax.swing.JButton();
        usuariosButton = new javax.swing.JButton();
        tiendasButton = new javax.swing.JButton();
        productosButton = new javax.swing.JButton();
        reportesButton = new javax.swing.JButton();
        registroPedidos = new javax.swing.JButton();
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

        salirButton.setBackground(new java.awt.Color(0, 0, 0));
        salirButton.setFont(new java.awt.Font("sansserif", 1, 20)); // NOI18N
        salirButton.setForeground(new java.awt.Color(255, 140, 0));
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
        pedidosButton.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        pedidosButton.setForeground(new java.awt.Color(255, 255, 255));
        pedidosButton.setText("Nuevo Pedido");
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

        setDateButton.setBackground(new java.awt.Color(0, 0, 0));
        setDateButton.setFont(new java.awt.Font("sansserif", 1, 20)); // NOI18N
        setDateButton.setForeground(new java.awt.Color(255, 140, 0));
        setDateButton.setText("set Date");
        setDateButton.setAlignmentY(0.0F);
        setDateButton.setBorder(null);
        setDateButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        setDateButton.setMinimumSize(new java.awt.Dimension(120, 40));
        setDateButton.setPreferredSize(new java.awt.Dimension(120, 40));
        setDateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                setDateButtonActionPerformed(evt);
            }
        });

        usuariosButton.setBackground(new java.awt.Color(255, 140, 0));
        usuariosButton.setFont(new java.awt.Font("sansserif", 0, 20)); // NOI18N
        usuariosButton.setForeground(new java.awt.Color(255, 255, 255));
        usuariosButton.setText("Usuarios");
        usuariosButton.setAlignmentY(0.0F);
        usuariosButton.setBorder(null);
        usuariosButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        usuariosButton.setMinimumSize(new java.awt.Dimension(120, 40));
        usuariosButton.setPreferredSize(new java.awt.Dimension(120, 40));
        usuariosButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usuariosButtonActionPerformed(evt);
            }
        });

        tiendasButton.setBackground(new java.awt.Color(255, 140, 0));
        tiendasButton.setFont(new java.awt.Font("sansserif", 0, 20)); // NOI18N
        tiendasButton.setForeground(new java.awt.Color(255, 255, 255));
        tiendasButton.setText("Tiendas");
        tiendasButton.setAlignmentY(0.0F);
        tiendasButton.setBorder(null);
        tiendasButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        tiendasButton.setMinimumSize(new java.awt.Dimension(120, 40));
        tiendasButton.setPreferredSize(new java.awt.Dimension(120, 40));
        tiendasButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tiendasButtonActionPerformed(evt);
            }
        });

        productosButton.setBackground(new java.awt.Color(255, 140, 0));
        productosButton.setFont(new java.awt.Font("sansserif", 0, 20)); // NOI18N
        productosButton.setForeground(new java.awt.Color(255, 255, 255));
        productosButton.setText("Productos");
        productosButton.setAlignmentY(0.0F);
        productosButton.setBorder(null);
        productosButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        productosButton.setMinimumSize(new java.awt.Dimension(120, 40));
        productosButton.setPreferredSize(new java.awt.Dimension(120, 40));
        productosButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                productosButtonActionPerformed(evt);
            }
        });

        reportesButton.setBackground(new java.awt.Color(0, 0, 0));
        reportesButton.setFont(new java.awt.Font("sansserif", 1, 20)); // NOI18N
        reportesButton.setForeground(new java.awt.Color(255, 140, 0));
        reportesButton.setText("Reportes");
        reportesButton.setAlignmentY(0.0F);
        reportesButton.setBorder(null);
        reportesButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        reportesButton.setMaximumSize(new java.awt.Dimension(120, 40));
        reportesButton.setMinimumSize(new java.awt.Dimension(120, 40));
        reportesButton.setPreferredSize(new java.awt.Dimension(120, 40));
        reportesButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reportesButtonActionPerformed(evt);
            }
        });

        registroPedidos.setBackground(new java.awt.Color(255, 140, 0));
        registroPedidos.setFont(new java.awt.Font("sansserif", 0, 20)); // NOI18N
        registroPedidos.setForeground(new java.awt.Color(255, 255, 255));
        registroPedidos.setText("Registro");
        registroPedidos.setAlignmentY(0.0F);
        registroPedidos.setBorder(null);
        registroPedidos.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        registroPedidos.setMinimumSize(new java.awt.Dimension(120, 40));
        registroPedidos.setPreferredSize(new java.awt.Dimension(120, 40));
        registroPedidos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registroPedidosActionPerformed(evt);
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
                    .addComponent(pedidosButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(setDateButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(usuariosButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tiendasButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(productosButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(reportesButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(registroPedidos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40))
        );
        navPanelLayout.setVerticalGroup(
            navPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(navPanelLayout.createSequentialGroup()
                .addGap(80, 80, 80)
                .addComponent(setDateButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(inicioButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(ventasButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(pedidosButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(usuariosButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(tiendasButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(productosButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(registroPedidos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(reportesButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(salirButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35))
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

    public void initCalendar(java.util.Date date) {
        calendario = new JDateChooser(date);
        calendario.setBackground(Color.ORANGE);
        calendario.setForeground(Color.black);
        calendario.setBounds(40, 40, 120, 30);
        this.navPanel.add(this.calendario);
        calendario.requestFocusInWindow(FocusEvent.Cause.CLEAR_GLOBAL_FOCUS_OWNER);
    }
        
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
        actualizarVentas();
    }//GEN-LAST:event_ventasButtonActionPerformed

    public void actualizarVentas() {
        //Iniciarlizar ventas
        ventaPedido = null;
        ventaPedido = new VentaPedidoView();
        
        //Agregar a los componentes
        this.contenedorPanel.removeAll();
        this.contenedorPanel.setVisible(false);
        ventaPedido.initializeComponents(control, tienda, false);
        this.contenedorPanel.add(ventaPedido);
        this.contenedorPanel.setVisible(true);        
    }
    
    private void pedidosButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pedidosButtonActionPerformed
        // TODO add your handling code here:
        actualizarPedidos();
    }//GEN-LAST:event_pedidosButtonActionPerformed

    public void actualizarPedidos() {
        ventaPedido = null;
        ventaPedido = new VentaPedidoView();
        
        //Agregar a los componenetes
        this.contenedorPanel.removeAll();
        this.contenedorPanel.setVisible(false);
        ventaPedido.initializeComponents(control, tienda, true);
        this.contenedorPanel.add(ventaPedido);
        this.contenedorPanel.setVisible(true);
    }
    
    private void setDateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_setDateButtonActionPerformed
        // TODO add your handling code here:
        Date newDate = calendario.getDate();
        if(newDate != null) {
            java.sql.Date date = new java.sql.Date(newDate.getTime());
            control.setDate(date);
            control.crearAlerta("Informacion", "La fecha " + date + " ha sido agregada" , this);
        } else {
            control.crearAlerta("Advertencia", "Debe escoger una fecha", this);
        }
    }//GEN-LAST:event_setDateButtonActionPerformed

    private void usuariosButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usuariosButtonActionPerformed
        // TODO add your handling code here:
        actualizarUsuarios();
    }//GEN-LAST:event_usuariosButtonActionPerformed

    public void actualizarUsuarios() {
        usuario = null;
        usuario = new UsuarioView();
        
        //Agregar al panel contenedor
        this.contenedorPanel.removeAll();
        this.contenedorPanel.setVisible(false);
        usuario.initializeComponents(control);
        this.contenedorPanel.add(usuario);
        this.contenedorPanel.setVisible(true);
    }
    
    private void tiendasButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tiendasButtonActionPerformed
        // TODO add your handling code here:
        actualizarTiendas();
    }//GEN-LAST:event_tiendasButtonActionPerformed

    public void actualizarTiendas() {
        tiendaView = null;
        tiendaView = new TiendaView();
        
        //Agregar al contenedor
        this.contenedorPanel.removeAll();
        this.contenedorPanel.setVisible(false);
        tiendaView.initializeComponents(control);
        this.contenedorPanel.add(tiendaView);
        this.contenedorPanel.setVisible(true);
    }
    
    private void productosButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_productosButtonActionPerformed
        // TODO add your handling code here:
        actualizarProductos();
    }//GEN-LAST:event_productosButtonActionPerformed

    public void actualizarProductos() {
        productoView = null;
        productoView = new ProductoView();
        
       //Agregar al contenedor
        this.contenedorPanel.removeAll();
        this.contenedorPanel.setVisible(false);
        productoView.initializeComponents(control);
        this.contenedorPanel.add(productoView);
        this.contenedorPanel.setVisible(true);       
    }
    
    public void updateDataStore() {
        if(productoView != null) {
            productoView.updateDataStore();
        }
    }
    
    private void reportesButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reportesButtonActionPerformed
        // TODO add your handling code here:
        reportesView = null;
        reportesView = new ReportesView();
        
        this.contenedorPanel.removeAll();
        this.contenedorPanel.setVisible(false);
        reportesView.initializeControl(control);
        this.contenedorPanel.add(reportesView);
        this.contenedorPanel.setVisible(true);          
    }//GEN-LAST:event_reportesButtonActionPerformed

    private void registroPedidosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registroPedidosActionPerformed
        // TODO add your handling code here:
        actualizarRegistro();
    }//GEN-LAST:event_registroPedidosActionPerformed

    public void actualizarRegistro() {
        registroView = null;
        registroView = new RegistroView();
        
        //Agregar al contenendor
        this.contenedorPanel.removeAll();
        this.contenedorPanel.setVisible(false);
        registroView.initializeComponents(control, tienda);
        this.contenedorPanel.add(registroView);
        this.contenedorPanel.setVisible(true);           
    }
    
    public void updateDataRegistro() {
        if(registroView != null) {
            registroView.actualizarDatos();
        }
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel contenedorPanel;
    private javax.swing.JButton inicioButton;
    private javax.swing.JPanel navPanel;
    private javax.swing.JButton pedidosButton;
    private javax.swing.JButton productosButton;
    private javax.swing.JButton registroPedidos;
    private javax.swing.JButton reportesButton;
    private javax.swing.JButton salirButton;
    private javax.swing.JButton setDateButton;
    private javax.swing.JButton tiendasButton;
    private javax.swing.JButton usuariosButton;
    private javax.swing.JButton ventasButton;
    // End of variables declaration//GEN-END:variables
}
