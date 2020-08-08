
package com.intelaf.model;

/**
 *
 * @author cesar31
 */
public class Empleado extends Persona {
    
    private String codigo;
        
    //Constructor para carga de archivos
    public Empleado(String nombre, String codigo, String telefono, String dpi) {
        super(nombre, telefono, dpi);
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
