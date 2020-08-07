
package com.intelaf.dto;

/**
 *
 * @author cesar31
 */
public class Cliente extends Persona {
    
    private double creditoCompra;

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

    @Override
    public String toString() {
        return super.toString() + "Cliente{" + "creditoCompra=" + creditoCompra + '}';
    }
}
