package com.intelaf.view;

import com.intelaf.controller.MainControl;
import com.intelaf.model.*;
import java.util.*;

/**
 *
 * @author cesar31
 */
public class PedidosClienteView extends javax.swing.JPanel {

    private MainControl control;
    private Cliente cliente;
    private List<Pedido> pedido;
    private String[][] lista;

    /**
     * Creates new form VentaView
     */
    public PedidosClienteView() {
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

        jScrollPane1 = new javax.swing.JScrollPane();
        productosTable = new javax.swing.JTable();
        productosTiendaLabel = new javax.swing.JLabel();

        setBackground(new java.awt.Color(248, 147, 31));
        setMinimumSize(new java.awt.Dimension(650, 600));
        setPreferredSize(new java.awt.Dimension(650, 600));

        jScrollPane1.setPreferredSize(new java.awt.Dimension(600, 402));

        productosTable.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        productosTable.setModel(new javax.swing.table.DefaultTableModel(
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
        productosTable.setEditingColumn(0);
        productosTable.setEditingRow(0);
        productosTable.setMinimumSize(new java.awt.Dimension(600, 250));
        productosTable.setPreferredSize(new java.awt.Dimension(700, 250));
        productosTable.setRowHeight(36);
        productosTable.setSelectionBackground(new java.awt.Color(0, 0, 0));
        productosTable.setSelectionForeground(new java.awt.Color(248, 147, 31));
        productosTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        productosTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        productosTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                productosTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(productosTable);
        productosTable.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);

        productosTiendaLabel.setBackground(new java.awt.Color(248, 147, 31));
        productosTiendaLabel.setFont(new java.awt.Font("sansserif", 0, 24)); // NOI18N
        productosTiendaLabel.setForeground(new java.awt.Color(255, 255, 255));
        productosTiendaLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        productosTiendaLabel.setText("Mis Pedidos");
        productosTiendaLabel.setMaximumSize(new java.awt.Dimension(150, 36));
        productosTiendaLabel.setMinimumSize(new java.awt.Dimension(150, 36));
        productosTiendaLabel.setPreferredSize(new java.awt.Dimension(150, 36));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(239, 239, 239)
                .addComponent(productosTiendaLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(261, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(19, 19, 19))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(productosTiendaLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(288, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Metodo para inicializar componentes necesarios para mostrar informacion
     * de las tiendas de donde se hacen pedidos
     *
     * @param control
     * @param cliente
     */
    public void initializeComponents(MainControl control, Cliente cliente) {
        this.control = control;
        this.cliente = cliente;
        pedido = control.getOrderByCliente(this.cliente.getNit());
        setTableProductos();
    }

    private void productosTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_productosTableMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_productosTableMouseClicked

    /**
     * Metodo para agregar los pedido de la tienda traidos de la base de
 datos a la tabla
     */
    private void setTableProductos() {
        lista = new String[pedido.size()][7];
        for (int i = 0; i < pedido.size(); i++) {
            lista[i][0] = String.valueOf(pedido.get(i).getFechaPedido());
            lista[i][1] = String.valueOf(pedido.get(i).getAnticipo());
            lista[i][2] = String.valueOf(pedido.get(i).getTotalPedido());
            lista[i][3] = pedido.get(i).getTiendaOrigen();
            lista[i][4] = pedido.get(i).getTiendaDestino();
            lista[i][5] = String.valueOf(pedido.get(i).getArrivalDate());
            lista[i][6] = pedido.get(i).getArrivalDate().before(this.control.getDate()) ? "Atrasado" : "A Tiempo";

        }
        productosTable.setPreferredSize(new java.awt.Dimension(550, 36 * pedido.size()));
        productosTable.setModel(new javax.swing.table.DefaultTableModel(
                lista,
                new String[]{
                    "Fecha", "Anticipo", "Total", "Origen", "Destino", "Llega En", "Estado"
                }
        ));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable productosTable;
    private javax.swing.JLabel productosTiendaLabel;
    // End of variables declaration//GEN-END:variables
}