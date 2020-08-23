
package com.intelaf.view;

import com.intelaf.controller.MainControl;
import com.intelaf.model.*;
import java.util.*;

/**
 *
 * @author cesar31
 */
public class ProductoView extends javax.swing.JPanel {

    private MainControl control;
    private List<Tienda> tiendas;
    private List<Producto> productos;
    private String[][] lista;
    private boolean general;
    
    /**
     * Creates new form VentaView
     */
    public ProductoView() {
        initComponents();
        setComponents();
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
        descriptionLabel = new javax.swing.JLabel();
        productosTiendaLabel = new javax.swing.JLabel();
        nuevoProductoButton = new javax.swing.JButton();
        editarProductoButton = new javax.swing.JButton();
        agregarStockButton = new javax.swing.JButton();
        agregarProductoTienda = new javax.swing.JButton();
        tiendasCombo = new javax.swing.JComboBox<>();
        tipoTransaccion = new javax.swing.JComboBox<>();

        setBackground(new java.awt.Color(248, 147, 31));
        setMinimumSize(new java.awt.Dimension(800, 700));
        setPreferredSize(new java.awt.Dimension(800, 700));

        productosTable.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
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
        productosTable.setMinimumSize(new java.awt.Dimension(700, 250));
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

        descriptionLabel.setBackground(new java.awt.Color(248, 147, 31));
        descriptionLabel.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        descriptionLabel.setForeground(new java.awt.Color(0, 0, 0));
        descriptionLabel.setText("Descripción:");
        descriptionLabel.setMinimumSize(new java.awt.Dimension(700, 60));
        descriptionLabel.setPreferredSize(new java.awt.Dimension(700, 80));

        productosTiendaLabel.setBackground(new java.awt.Color(248, 147, 31));
        productosTiendaLabel.setFont(new java.awt.Font("sansserif", 0, 24)); // NOI18N
        productosTiendaLabel.setForeground(new java.awt.Color(255, 255, 255));
        productosTiendaLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        productosTiendaLabel.setText("Productos");
        productosTiendaLabel.setMaximumSize(new java.awt.Dimension(150, 36));
        productosTiendaLabel.setMinimumSize(new java.awt.Dimension(150, 36));
        productosTiendaLabel.setPreferredSize(new java.awt.Dimension(150, 36));

        nuevoProductoButton.setBackground(new java.awt.Color(0, 0, 0));
        nuevoProductoButton.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        nuevoProductoButton.setForeground(new java.awt.Color(248, 147, 31));
        nuevoProductoButton.setText("Nuevo Producto");
        nuevoProductoButton.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(248, 103, 27), 1, true));
        nuevoProductoButton.setFocusPainted(false);
        nuevoProductoButton.setMaximumSize(new java.awt.Dimension(150, 32));
        nuevoProductoButton.setMinimumSize(new java.awt.Dimension(150, 32));
        nuevoProductoButton.setPreferredSize(new java.awt.Dimension(150, 32));
        nuevoProductoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nuevoProductoButtonActionPerformed(evt);
            }
        });

        editarProductoButton.setBackground(new java.awt.Color(0, 0, 0));
        editarProductoButton.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        editarProductoButton.setForeground(new java.awt.Color(248, 147, 31));
        editarProductoButton.setText("Editar Producto");
        editarProductoButton.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(248, 103, 27), 1, true));
        editarProductoButton.setFocusPainted(false);
        editarProductoButton.setMaximumSize(new java.awt.Dimension(150, 32));
        editarProductoButton.setMinimumSize(new java.awt.Dimension(150, 32));
        editarProductoButton.setPreferredSize(new java.awt.Dimension(150, 32));
        editarProductoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editarProductoButtonActionPerformed(evt);
            }
        });

        agregarStockButton.setBackground(new java.awt.Color(0, 0, 0));
        agregarStockButton.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        agregarStockButton.setForeground(new java.awt.Color(248, 147, 31));
        agregarStockButton.setText("Agregar Stock");
        agregarStockButton.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(248, 103, 27), 1, true));
        agregarStockButton.setFocusPainted(false);
        agregarStockButton.setMaximumSize(new java.awt.Dimension(125, 32));
        agregarStockButton.setMinimumSize(new java.awt.Dimension(125, 32));
        agregarStockButton.setPreferredSize(new java.awt.Dimension(125, 32));
        agregarStockButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agregarStockButtonActionPerformed(evt);
            }
        });

        agregarProductoTienda.setBackground(new java.awt.Color(0, 0, 0));
        agregarProductoTienda.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        agregarProductoTienda.setForeground(new java.awt.Color(248, 147, 31));
        agregarProductoTienda.setText("Agregar Producto");
        agregarProductoTienda.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(248, 103, 27), 1, true));
        agregarProductoTienda.setFocusPainted(false);
        agregarProductoTienda.setMaximumSize(new java.awt.Dimension(150, 32));
        agregarProductoTienda.setMinimumSize(new java.awt.Dimension(150, 32));
        agregarProductoTienda.setPreferredSize(new java.awt.Dimension(150, 32));
        agregarProductoTienda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agregarProductoTiendaActionPerformed(evt);
            }
        });

        tiendasCombo.setBackground(new java.awt.Color(0, 0, 0));
        tiendasCombo.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        tiendasCombo.setForeground(new java.awt.Color(248, 147, 31));
        tiendasCombo.setMinimumSize(new java.awt.Dimension(150, 32));
        tiendasCombo.setPreferredSize(new java.awt.Dimension(150, 32));
        tiendasCombo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                tiendasComboItemStateChanged(evt);
            }
        });

        tipoTransaccion.setBackground(new java.awt.Color(0, 0, 0));
        tipoTransaccion.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        tipoTransaccion.setForeground(new java.awt.Color(248, 147, 31));
        tipoTransaccion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Inventario General", "Por Tiendas" }));
        tipoTransaccion.setMinimumSize(new java.awt.Dimension(200, 32));
        tipoTransaccion.setPreferredSize(new java.awt.Dimension(200, 32));
        tipoTransaccion.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                tipoTransaccionItemStateChanged(evt);
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
                        .addComponent(editarProductoButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(nuevoProductoButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(agregarProductoTienda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(agregarStockButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(descriptionLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(productosTiendaLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tipoTransaccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(tiendasCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 728, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(42, 42, 42))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(productosTiendaLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tiendasCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tipoTransaccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 346, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(descriptionLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(editarProductoButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nuevoProductoButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(agregarStockButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(agregarProductoTienda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(188, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void setComponents() {
        productos = new ArrayList<>();
        tiendas = new ArrayList<>();
        this.general = true;
    }    
    
    public void initializeComponents(MainControl control) {
        this.control = control;
        actualizarDatos();
    }
            
    private void nuevoProductoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nuevoProductoButtonActionPerformed
        // TODO add your handling code here:
        control.modalOperacionesProducto(null);
    }//GEN-LAST:event_nuevoProductoButtonActionPerformed

    private void editarProductoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editarProductoButtonActionPerformed
        // TODO add your handling code here:
        int row = productosTable.getSelectedRow();
        if(row != -1) {
            control.modalOperacionesProducto(productos.get(row));
        } else {
            control.crearAlerta("Error", "Debe seleccionar un producto para poder editarlo", null);
        }
    }//GEN-LAST:event_editarProductoButtonActionPerformed

    private void agregarStockButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregarStockButtonActionPerformed
        // TODO add your handling code here:
        int row = productosTable.getSelectedRow();
        if(row != -1) {
            control.modalOperacionesProductoStock(productos.get(row));
            getDatosTienda();
        } else {
            control.crearAlerta("Error", "Debe seleccionar un producto para poder editarlo", null);
        }
    }//GEN-LAST:event_agregarStockButtonActionPerformed

    private void agregarProductoTiendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregarProductoTiendaActionPerformed
    }//GEN-LAST:event_agregarProductoTiendaActionPerformed

    private void tiendasComboItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_tiendasComboItemStateChanged
        // TODO add your handling code here:
        getDatosTienda();
    }//GEN-LAST:event_tiendasComboItemStateChanged

    private void getDatosTienda() {
        if(tiendasCombo.getSelectedIndex() != -1) {
            //Limpiar lista de productos
            productos.clear();

            //Actualizar lista de productos
            productos = control.getProductosTienda(tiendasCombo.getSelectedItem().toString());

            //Actualizar tabla por tienda
            setTableByTienda();    
        }    
    }
    
    private void productosTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_productosTableMouseClicked
        // TODO add your handling code here:
        int row = productosTable.getSelectedRow();
        if(row != -1) {
            descriptionLabel.setText(productos.get(row).getDescripcion());
        }
    }//GEN-LAST:event_productosTableMouseClicked

    private void tipoTransaccionItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_tipoTransaccionItemStateChanged
        // TODO add your handling code here:
        this.general = tipoTransaccion.getSelectedIndex() == 0;
        actualizarDatos();
    }//GEN-LAST:event_tipoTransaccionItemStateChanged

   
    private void actualizarDatos() {
        //Limpiar listas
        productos.clear();
        tiendas.clear();
        
        if(general) {
            agregarProductoTienda.setVisible(false);
            agregarStockButton.setVisible(false);
            editarProductoButton.setVisible(true);
            nuevoProductoButton.setVisible(true);
            tiendasCombo.setVisible(false);
            
            //Actualizar lista de productos
            productos = control.getProductos();
            
            //Actualizar tabla general
            setTableGeneral();
        } else {
            agregarProductoTienda.setVisible(true);
            agregarStockButton.setVisible(true);
            editarProductoButton.setVisible(false);
            nuevoProductoButton.setVisible(false);        
            tiendasCombo.setVisible(true);
            
            tiendas = control.getTiendas();  
            if(tiendasCombo.getItemCount() > 0) {
                tiendasCombo.removeAllItems();
            }
            tiendas.forEach((t) -> {
                tiendasCombo.addItem(t.getCodigo());
            });
            
            //Actualizar lista de productos
            productos = control.getProductosTienda(tiendasCombo.getSelectedItem().toString());
            
            //Actualizar tabla por tienda
            setTableByTienda();
        }        
    }
    
    /**
     * Metodo para agregar los productos de la tienda traidos de la base de datos a la tabla
     */
    private void setTableGeneral() {
        lista = new String[productos.size()][5];
        for (int i = 0; i < productos.size(); i++) {
            lista[i][0] = productos.get(i).getCodigoProductos();
            lista[i][1] = productos.get(i).getNombre();
            lista[i][2] = productos.get(i).getFabricante();
            lista[i][3] = "Q. " + productos.get(i).getPrecio();
            lista[i][4] = productos.get(i).getGarantia()+ "";
        }
        productosTable.setPreferredSize(new java.awt.Dimension(700, 36*productos.size()));
        productosTable.setModel(new javax.swing.table.DefaultTableModel(
            lista,
            new String [] {
                "Codigo", "Nombre", "Fabricante", "Precio", "Garantia"
            }
        ));
    }
    
    private void setTableByTienda() {
        lista = new String[productos.size()][6];
        for (int i = 0; i < productos.size(); i++) {
            lista[i][0] = productos.get(i).getCodigoProductos();
            lista[i][1] = productos.get(i).getNombre();
            lista[i][2] = productos.get(i).getFabricante();
            lista[i][3] = "Q. " + productos.get(i).getPrecio();
            lista[i][4] = productos.get(i).getGarantia()+ "";
            lista[i][5] = String.valueOf(productos.get(i).getStock());
        }
        productosTable.setPreferredSize(new java.awt.Dimension(700, 36*productos.size()));
        productosTable.setModel(new javax.swing.table.DefaultTableModel(
            lista,
            new String [] {
                "Codigo", "Nombre", "Fabricante", "Precio", "Garantia", "Existencias"
            }
        ));
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton agregarProductoTienda;
    private javax.swing.JButton agregarStockButton;
    private javax.swing.JLabel descriptionLabel;
    private javax.swing.JButton editarProductoButton;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton nuevoProductoButton;
    private javax.swing.JTable productosTable;
    private javax.swing.JLabel productosTiendaLabel;
    private javax.swing.JComboBox<String> tiendasCombo;
    private javax.swing.JComboBox<String> tipoTransaccion;
    // End of variables declaration//GEN-END:variables
}
