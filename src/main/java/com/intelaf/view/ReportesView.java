package com.intelaf.view;

import com.intelaf.controller.EscrituraReportes;
import com.intelaf.controller.MainControl;
import com.intelaf.model.*;
import com.toedter.calendar.JDateChooser;
import java.sql.Date;
import java.util.List;

/**
 *
 * @author cesar31
 */
public class ReportesView extends javax.swing.JPanel {

    private MainControl control;
    private List<Tienda> tiendas;
    private List<Cliente> clientes;
    private JDateChooser calendarMin;
    private JDateChooser calendarMax;
    private EscrituraReportes reportes;

    /**
     * Creates new form ReportesView
     */
    public ReportesView() {
        initComponents();
        intervaloRadio.setEnabled(false);
        setDateCalendars();
    }
    
    private void setDateCalendars() {
        java.util.Date date = new java.util.Date();
        calendarMin = new JDateChooser(date);
        calendarMin.setBounds(500, 200, 120, 30);
        calendarMax = new JDateChooser(date);
        calendarMax.setBounds(500, 250, 120, 30);
        
        this.add(calendarMin);
        this.add(calendarMax);
        calendarMin.setEnabled(false);
        calendarMax.setEnabled(false);
    }
    

    public void initializeControl(MainControl control) {
        this.control = control;
        this.clientes = this.control.getClientes();
        this.tiendas = this.control.getTiendas();
        tiendas.forEach((t) -> {
            tiendasClientesCombo.addItem(t.getCodigo());
        });
        reportes = new EscrituraReportes();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        generarButton = new javax.swing.JButton();
        tipoReporte = new javax.swing.JComboBox<>();
        tiendasClientesCombo = new javax.swing.JComboBox<>();
        informacionLabel = new javax.swing.JLabel();
        intervaloRadio = new javax.swing.JRadioButton();

        setBackground(new java.awt.Color(248, 147, 31));
        setMinimumSize(new java.awt.Dimension(800, 700));
        setPreferredSize(new java.awt.Dimension(800, 700));

        generarButton.setBackground(new java.awt.Color(0, 0, 0));
        generarButton.setFont(new java.awt.Font("sansserif", 0, 24)); // NOI18N
        generarButton.setForeground(new java.awt.Color(248, 147, 31));
        generarButton.setText("Generar");
        generarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                generarButtonActionPerformed(evt);
            }
        });

        tipoReporte.setBackground(new java.awt.Color(0, 0, 0));
        tipoReporte.setFont(new java.awt.Font("sansserif", 0, 24)); // NOI18N
        tipoReporte.setForeground(new java.awt.Color(248, 147, 31));
        tipoReporte.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1 - Todos los Pedidos", "2 - Registro Hoy", "3 - Pedidos Atrasados", "4 - Pedidos Enviados", "5 - Compras por Cliente", "6 - Pedidos por Cliente", "7 - Top10", "8 - Mas Vendidos (Tienda)", "9 - Sin Vender (Tienda)" }));
        tipoReporte.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                tipoReporteItemStateChanged(evt);
            }
        });

        tiendasClientesCombo.setBackground(new java.awt.Color(0, 0, 0));
        tiendasClientesCombo.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        tiendasClientesCombo.setForeground(new java.awt.Color(248, 147, 31));
        tiendasClientesCombo.setPreferredSize(new java.awt.Dimension(150, 30));

        informacionLabel.setBackground(new java.awt.Color(248, 147, 31));
        informacionLabel.setFont(new java.awt.Font("sansserif", 0, 20)); // NOI18N
        informacionLabel.setForeground(new java.awt.Color(0, 0, 0));
        informacionLabel.setText("Tienda Destino");

        intervaloRadio.setBackground(new java.awt.Color(248, 147, 31));
        intervaloRadio.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        intervaloRadio.setForeground(new java.awt.Color(0, 0, 0));
        intervaloRadio.setText("Por Intervalo de Tiempo");
        intervaloRadio.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                intervaloRadioItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(69, 69, 69)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tipoReporte, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(generarButton))
                .addGap(79, 79, 79)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(intervaloRadio)
                    .addComponent(informacionLabel)
                    .addComponent(tiendasClientesCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(94, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(61, 61, 61)
                .addComponent(informacionLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tipoReporte, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tiendasClientesCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(intervaloRadio)
                .addGap(25, 25, 25)
                .addComponent(generarButton)
                .addContainerGap(466, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void generarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_generarButtonActionPerformed
        // TODO add your handling code here:
        int index = tipoReporte.getSelectedIndex();
        if (index != -1) {
            generateReport(index);
        }
    }//GEN-LAST:event_generarButtonActionPerformed

    private void generateReport(int index) {
        switch (index) {
            case 0:
                String tiendaDestino = tiendasClientesCombo.getSelectedItem().toString();
                reportes.allOfTheOrders(tiendaDestino);
                break;
            case 1:
                String tiendaD = tiendasClientesCombo.getSelectedItem().toString();
                reportes.allOfTheOrdersOnTime(control.getDate(), tiendaD, true);
                break;
            case 2:
                String tienda = tiendasClientesCombo.getSelectedItem().toString();
                reportes.allOfTheOrdersOnTime(control.getDate(), tienda, false);
                break;
            case 3:
                String store = tiendasClientesCombo.getSelectedItem().toString();
                reportes.ordersInTransit(store);
                break;
            case 4:
                String cliente = tiendasClientesCombo.getSelectedItem().toString();
                reportes.comprasByCliente(cliente);
                break;
            case 5:
               String c = tiendasClientesCombo.getSelectedItem().toString();
               reportes.ordersByClient(c);
                break;
            case 6:
                generateReport7();
                break;
            case 7:
                generateReport8();
                break;
            case 8:
                String t = tiendasClientesCombo.getSelectedItem().toString();
                reportes.neverBeenSold(t);
                break;
        }        
    }
    
    private void generateReport7() {
        if(withTiempo()) {
            if(checkCalendars()) {
                if(checkDates()) {
                    java.sql.Date min = new Date(calendarMin.getDate().getTime());
                    java.sql.Date max = new Date(calendarMax.getDate().getTime());
                    reportes.productosTop10ByTime(min, max);
                }else {
                    control.crearAlerta("Error", "Las fechas ingresadas no son validas", null);
                }
            } else {
                control.crearAlerta("Error", "Debe de seleccionar una fecha valida en los calendarios", null);
            }
        }else {
            reportes.productosTop10();
        }
    }
    
    private void generateReport8() {
        if(withTiempo()) {
            if(checkCalendars()) {
                if(checkDates()) {
                    java.sql.Date min = new Date(calendarMin.getDate().getTime());
                    java.sql.Date max = new Date(calendarMax.getDate().getTime());
                    String codigoTienda = tiendasClientesCombo.getSelectedItem().toString();
                    reportes.productosTopByTimeAndStore(codigoTienda, min, max);
                }else {
                    control.crearAlerta("Error", "Las fechas ingresadas no son validas", null);
                }
            } else {
                control.crearAlerta("Error", "Debe de seleccionar una fecha valida en los calendarios", null);
            }        
        }else {
            String store = tiendasClientesCombo.getSelectedItem().toString();
            reportes.productosTopByStore(store);
        }    
    }
    
    private boolean checkDates() {
        return calendarMin.getDate().before(calendarMax.getDate());
    }
    
    private boolean checkCalendars() {
        return calendarMin.getDate() != null && calendarMax.getDate() != null;
    }
    
    private boolean withTiempo() {
        return intervaloRadio.isSelected();
    }
    
    private void tipoReporteItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_tipoReporteItemStateChanged
        // TODO add your handling code here:
        int index = tipoReporte.getSelectedIndex();
        if (index != -1) {
            changeStatus(index);
        }
    }//GEN-LAST:event_tipoReporteItemStateChanged

    private void intervaloRadioItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_intervaloRadioItemStateChanged
        // TODO add your handling code here:
        if(intervaloRadio.isSelected()) {
            calendarMax.setEnabled(true);
            calendarMin.setEnabled(true);
        } else {
            calendarMax.setEnabled(false);
            calendarMin.setEnabled(false);
        }
    }//GEN-LAST:event_intervaloRadioItemStateChanged

    private void changeStatus(int report) {
        if(tiendasClientesCombo.getItemCount() > 0) {
            tiendasClientesCombo.removeAllItems();
        }
        tiendasClientesCombo.setEnabled(true);
        intervaloRadio.setEnabled(false);
        
        switch (report) {
            case 0:
                tiendas.forEach((t) -> {
                    tiendasClientesCombo.addItem(t.getCodigo());
                });
                informacionLabel.setText("Tienda Destino");
                break;
            case 1:
                tiendas.forEach((t) -> {
                    tiendasClientesCombo.addItem(t.getCodigo());
                });  
                informacionLabel.setText("Tienda Destino");
                break;
            case 2:
                tiendas.forEach((t) -> {
                    tiendasClientesCombo.addItem(t.getCodigo());
                });     
                informacionLabel.setText("Tienda Destino");
                break;
            case 3:
                tiendas.forEach((t) -> {
                    tiendasClientesCombo.addItem(t.getCodigo());
                });
                informacionLabel.setText("Tienda Origen");
                break;
            case 4:
                clientes.forEach((c) -> {
                    tiendasClientesCombo.addItem(c.getNit());
                });
                informacionLabel.setText("Cliente");
                break;
            case 5:
                clientes.forEach((c) -> {
                    tiendasClientesCombo.addItem(c.getNit());
                });
                informacionLabel.setText("Cliente");                
                break;
            case 6:
                tiendasClientesCombo.setEnabled(false);
                informacionLabel.setText("TOP10");
                intervaloRadio.setEnabled(true);

                break;
            case 7:
                tiendas.forEach((t) -> {
                    tiendasClientesCombo.addItem(t.getCodigo());
                });
                informacionLabel.setText("Tienda");
                intervaloRadio.setEnabled(true);
                
                break;
            case 8:
                tiendas.forEach((t) -> {
                    tiendasClientesCombo.addItem(t.getCodigo());
                });
                informacionLabel.setText("Tienda");
                break;
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton generarButton;
    private javax.swing.JLabel informacionLabel;
    private javax.swing.JRadioButton intervaloRadio;
    private javax.swing.JComboBox<String> tiendasClientesCombo;
    private javax.swing.JComboBox<String> tipoReporte;
    // End of variables declaration//GEN-END:variables
}
