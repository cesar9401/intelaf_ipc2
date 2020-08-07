
package com.intelaf.dto;

/**
 *
 * @author cesar31
 */
public class Empleado extends Persona {
    
    private String codigo;
    
    public Empleado(String nombre, String telefono, String codigo) {
        super(nombre, telefono);
        this.codigo = codigo;
    }
    
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    @Override
    public String toString() {
        return super.toString() + "Empleado{" + "codigo=" + codigo + '}';
    }
}
