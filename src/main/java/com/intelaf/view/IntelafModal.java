
package com.intelaf.view;

import com.intelaf.controller.MainControl;
import com.intelaf.model.*;
import java.util.List;

/**
 *
 * @author cesar31
 */
public class IntelafModal extends javax.swing.JDialog {

    private MainControl control;
    
    /**
     * Creates new form ClienteForVenta
     */
    public IntelafModal(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(null);
        this.setResizable(false);
    }
    
    public void initializeControl(MainControl control) {
        this.control = control;
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

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Informacion");
        setBackground(new java.awt.Color(248, 147, 31));
        setMinimumSize(new java.awt.Dimension(600, 450));
        setModal(true);
        setPreferredSize(new java.awt.Dimension(600, 450));

        contenedor.setBackground(new java.awt.Color(248, 147, 31));
        contenedor.setMinimumSize(new java.awt.Dimension(600, 450));
        contenedor.setPreferredSize(new java.awt.Dimension(600, 450));
        contenedor.setLayout(new java.awt.BorderLayout());

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(contenedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(contenedor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void initOperationCliente(List<Producto> productosCliente, double total) {
        ClienteForVenta operCliente = new ClienteForVenta();
        operCliente.initializeControl(this.control, productosCliente, total);
        this.contenedor.setVisible(false);
        this.contenedor.removeAll();
        this.contenedor.add(operCliente);
        this.contenedor.setVisible(true);
    }
    
    public void initOperationPedido(List<Producto> productosC, double total, double min, Tiempo tiempo) {
        ClienteForPedido operPedido = new ClienteForPedido();
        operPedido.initializeControl(this.control, productosC, total, min, tiempo);
        this.contenedor.setVisible(true);
        this.contenedor.removeAll();
        this.contenedor.add(operPedido);
        this.contenedor.setVisible(true);
    }
    
    public void initOperationUsuario(boolean isEmpleado, Empleado empleado, Cliente cliente) {
        UsuarioForModal operUsuario = new UsuarioForModal();
        operUsuario.initializeControl(this.control, isEmpleado);
        if(empleado != null) {
            operUsuario.initializeEmpleado(empleado);
        }
        
        if(cliente != null) {
            operUsuario.initializeCliente(cliente);
        }
        
        this.contenedor.setVisible(false);
        this.contenedor.removeAll();
        this.contenedor.add(operUsuario);
        this.contenedor.setVisible(true);
    }
    
    public void initOperationTienda(Tienda tienda) {
        TiendasForModal operT = new TiendasForModal();
        operT.initializeControl(this.control);
        if(tienda != null) {
            operT.initializeTienda(tienda);
        }
        
        this.contenedor.setVisible(false);
        this.contenedor.removeAll();
        this.contenedor.add(operT);
        this.contenedor.setVisible(true);
    }
    
    public void initOperationTiempo(Tienda tienda) {
        TiempoForModal operT = new TiempoForModal();
        operT.initializeControl(control);
        operT.initializeTienda(tienda);
        this.contenedor.setVisible(false);
        this.contenedor.removeAll();
        this.contenedor.add(operT);
        this.contenedor.setVisible(true);
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel contenedor;
    // End of variables declaration//GEN-END:variables
}
