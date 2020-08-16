
package com.intelaf.model;

/**
 *
 * @author cesar31
 */
public class Cliente extends Persona {
    
    private double creditoCompra;
    private double descuentoCredito;

    public Cliente(String nombre, String telefono, double creditoCompra) {
        super(nombre, telefono);
        this.creditoCompra = creditoCompra;
    }
    
    public double getCreditoCompra() {
        return creditoCompra;
    }

    public void setCreditoCompra(double creditoCompra) {
        this.creditoCompra = creditoCompra;
    }

    public double getDescuentoCredito() {
        return descuentoCredito;
    }

    public void setDescuentoCredito(double descuentoCredito) {
        this.descuentoCredito = descuentoCredito;
    }
    
    @Override
    public String toString() {
        return super.toString() + "Cliente{" + "creditoCompra=" + creditoCompra + '}';
    }
}
