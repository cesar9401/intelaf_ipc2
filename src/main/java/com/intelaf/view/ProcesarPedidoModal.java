
package com.intelaf.view;

import com.intelaf.controller.MainControl;
import com.intelaf.model.*;
import java.awt.Color;
import java.util.List;

/**
 *
 * @author cesar31
 */
public class ProcesarPedidoModal extends javax.swing.JDialog {

    private MainControl control;
    private Pedido pedido;
    private boolean isProcesar;
    private boolean isATiempo;
    private Cliente cliente;
    private List<Producto> detallesPedido;
    private String[][] listDetalles;
    
    
    /**
     * Creates new form ClienteForVenta
     * @param parent
     * @param modal
     */
    public ProcesarPedidoModal(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setComponents();
    }
    
    private void setComponents() {
        this.setLocationRelativeTo(null);
        this.setResizable(false);    
    }
    
    public void initializeControl(MainControl control, Pedido pedido, boolean isATiempo, boolean isProcesar) {
        this.control = control;
        this.pedido = pedido;
        this.isATiempo = isATiempo;
        this.isProcesar = isProcesar;
        initializeComponents();
    }
    
    private void initializeComponents() {
        this.cliente = control.getCliente(this.pedido.getNitCliente());
        this.detallesPedido = control.getDetallesPedidoById(this.pedido.getId());
        setDetails();
    }

    private void setDetails() {
        if(!isATiempo) {
            pedidoLabel.setForeground(Color.red);
            pedidoLabel.setText("(R)Pedido No. " + pedido.getId());
        } else {
            pedidoLabel.setText("Pedido No. " + pedido.getId());
        }
        nitText.setText(cliente.getNit());
        nombreText.setText(cliente.getNombre());
        anticipoText.setText("Q. " + pedido.getAnticipo());
        totalText.setText("Q. " + pedido.getTotalPedido());
        
        setTableDetalles();
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        contenedor = new javax.swing.JPanel();
        pedidoLabel = new javax.swing.JLabel();
        scrollProductos = new javax.swing.JScrollPane();
        pedidosTable = new javax.swing.JTable();
        clienteLabel = new javax.swing.JLabel();
        nitText = new javax.swing.JTextField();
        nombreLabel = new javax.swing.JLabel();
        nombreText = new javax.swing.JTextField();
        anticipoLabel = new javax.swing.JLabel();
        anticipoText = new javax.swing.JTextField();
        totalLabel = new javax.swing.JLabel();
        totalText = new javax.swing.JTextField();
        procesarButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Informacion");
        setBackground(new java.awt.Color(248, 147, 31));
        setMinimumSize(new java.awt.Dimension(800, 500));
        setModal(true);
        setPreferredSize(new java.awt.Dimension(800, 500));
        setResizable(false);

        contenedor.setBackground(new java.awt.Color(248, 147, 31));
        contenedor.setMinimumSize(new java.awt.Dimension(800, 500));
        contenedor.setPreferredSize(new java.awt.Dimension(800, 500));

        pedidoLabel.setBackground(new java.awt.Color(248, 147, 31));
        pedidoLabel.setFont(new java.awt.Font("sansserif", 3, 36)); // NOI18N
        pedidoLabel.setForeground(new java.awt.Color(0, 0, 0));
        pedidoLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        pedidoLabel.setText("Pedido No. ");
        pedidoLabel.setPreferredSize(new java.awt.Dimension(400, 44));

        scrollProductos.setPreferredSize(new java.awt.Dimension(700, 200));

        pedidosTable.setFont(new java.awt.Font("sansserif", 0, 15)); // NOI18N
        pedidosTable.setModel(new javax.swing.table.DefaultTableModel(
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
        pedidosTable.setPreferredSize(new java.awt.Dimension(700, 200));
        pedidosTable.setRowHeight(36);
        pedidosTable.setSelectionBackground(new java.awt.Color(0, 0, 0));
        pedidosTable.setSelectionForeground(new java.awt.Color(248, 147, 31));
        scrollProductos.setViewportView(pedidosTable);

        clienteLabel.setBackground(new java.awt.Color(248, 147, 31));
        clienteLabel.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        clienteLabel.setForeground(new java.awt.Color(0, 0, 0));
        clienteLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        clienteLabel.setText("Cliente");
        clienteLabel.setToolTipText("");
        clienteLabel.setPreferredSize(new java.awt.Dimension(80, 26));

        nitText.setEditable(false);
        nitText.setBackground(new java.awt.Color(255, 255, 255));
        nitText.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        nitText.setForeground(new java.awt.Color(0, 0, 0));
        nitText.setText("nit");
        nitText.setPreferredSize(new java.awt.Dimension(150, 30));

        nombreLabel.setBackground(new java.awt.Color(248, 147, 31));
        nombreLabel.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        nombreLabel.setForeground(new java.awt.Color(0, 0, 0));
        nombreLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        nombreLabel.setText("Nombre");
        nombreLabel.setToolTipText("");
        nombreLabel.setPreferredSize(new java.awt.Dimension(80, 26));

        nombreText.setEditable(false);
        nombreText.setBackground(new java.awt.Color(255, 255, 255));
        nombreText.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        nombreText.setForeground(new java.awt.Color(0, 0, 0));
        nombreText.setText("nombre");
        nombreText.setPreferredSize(new java.awt.Dimension(150, 30));

        anticipoLabel.setBackground(new java.awt.Color(248, 147, 31));
        anticipoLabel.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        anticipoLabel.setForeground(new java.awt.Color(0, 0, 0));
        anticipoLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        anticipoLabel.setText("Anticipo");
        anticipoLabel.setToolTipText("");
        anticipoLabel.setPreferredSize(new java.awt.Dimension(80, 26));

        anticipoText.setEditable(false);
        anticipoText.setBackground(new java.awt.Color(255, 255, 255));
        anticipoText.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        anticipoText.setForeground(new java.awt.Color(0, 0, 0));
        anticipoText.setText("anticipo");
        anticipoText.setPreferredSize(new java.awt.Dimension(150, 30));

        totalLabel.setBackground(new java.awt.Color(248, 147, 31));
        totalLabel.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        totalLabel.setForeground(new java.awt.Color(0, 0, 0));
        totalLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        totalLabel.setText("Total");
        totalLabel.setToolTipText("");
        totalLabel.setPreferredSize(new java.awt.Dimension(80, 26));

        totalText.setEditable(false);
        totalText.setBackground(new java.awt.Color(255, 255, 255));
        totalText.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        totalText.setForeground(new java.awt.Color(0, 0, 0));
        totalText.setText("anticipo");
        totalText.setPreferredSize(new java.awt.Dimension(150, 30));

        procesarButton.setBackground(new java.awt.Color(0, 0, 0));
        procesarButton.setFont(new java.awt.Font("sansserif", 0, 24)); // NOI18N
        procesarButton.setForeground(new java.awt.Color(248, 147, 31));
        procesarButton.setText("Procesar");
        procesarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                procesarButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout contenedorLayout = new javax.swing.GroupLayout(contenedor);
        contenedor.setLayout(contenedorLayout);
        contenedorLayout.setHorizontalGroup(
            contenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contenedorLayout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(contenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(scrollProductos, javax.swing.GroupLayout.PREFERRED_SIZE, 686, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(contenedorLayout.createSequentialGroup()
                        .addGroup(contenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(clienteLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(nombreLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(contenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(contenedorLayout.createSequentialGroup()
                                .addComponent(nitText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(anticipoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(anticipoText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(contenedorLayout.createSequentialGroup()
                                .addComponent(nombreText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(totalLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(totalText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(70, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, contenedorLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(contenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, contenedorLayout.createSequentialGroup()
                        .addComponent(pedidoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(200, 200, 200))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, contenedorLayout.createSequentialGroup()
                        .addComponent(procesarButton)
                        .addGap(40, 40, 40))))
        );
        contenedorLayout.setVerticalGroup(
            contenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contenedorLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(pedidoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scrollProductos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addGroup(contenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(clienteLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nitText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(anticipoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(anticipoText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37)
                .addGroup(contenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(totalText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(totalLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nombreText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nombreLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                .addComponent(procesarButton)
                .addGap(40, 40, 40))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(contenedor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(contenedor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void procesarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_procesarButtonActionPerformed
        if(isProcesar) {
            //Write your code to process order here
            pedido.setaTiempo(isATiempo);
            pedido.setFechaLlegada(control.getDate());
            //Asegurarnos que se ingrese como no entregado
            pedido.setEntregado(false);

            //Procesar pedido para que ingrese a tienda
            control.updatePedidoInStore(pedido);
        } else {
            control.modalOperacionesDeliverOrder(pedido, cliente);
        }
    }//GEN-LAST:event_procesarButtonActionPerformed
    
    private void setTableDetalles() {
        listDetalles = new String[detallesPedido.size()][5];
        
        for (int i = 0; i < detallesPedido.size(); i++) {
            listDetalles[i][0] = detallesPedido.get(i).getCodigoProductos();
            listDetalles[i][1] = detallesPedido.get(i).getNombre();
            listDetalles[i][2] = detallesPedido.get(i).getFabricante();
            listDetalles[i][3] = String.valueOf(detallesPedido.get(i).getStock());
            listDetalles[i][4] = String.valueOf(detallesPedido.get(i).getSubTotal());
        }
        
        pedidosTable.setPreferredSize(new java.awt.Dimension(700, 36*detallesPedido.size()));
        pedidosTable.setModel(new javax.swing.table.DefaultTableModel(
            listDetalles,
            new String [] {
                "Codigo", "Nombre", "Fabricante", "Cantidad", "SubTotal"
            }
        ));    
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel anticipoLabel;
    private javax.swing.JTextField anticipoText;
    private javax.swing.JLabel clienteLabel;
    private javax.swing.JPanel contenedor;
    private javax.swing.JTextField nitText;
    private javax.swing.JLabel nombreLabel;
    private javax.swing.JTextField nombreText;
    private javax.swing.JLabel pedidoLabel;
    private javax.swing.JTable pedidosTable;
    private javax.swing.JButton procesarButton;
    private javax.swing.JScrollPane scrollProductos;
    private javax.swing.JLabel totalLabel;
    private javax.swing.JTextField totalText;
    // End of variables declaration//GEN-END:variables
}
