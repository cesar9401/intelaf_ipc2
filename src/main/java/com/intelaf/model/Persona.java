
package com.intelaf.model;

/**
 *
 * @author cesar31
 */
public class Persona {
    
    private String nombre;
    private String telefono;
    private String nit;
    private String dpi;
    private String email;
    private String direccion;

    public Persona(String nombre, String telefono) {
        this.nombre = nombre;
        this.telefono = telefono;
    }

    public Persona(String nombre, String telefono, String dpi) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.dpi = dpi;
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public String getDpi() {
        return dpi;
    }

    public void setDpi(String dpi) {
        this.dpi = dpi;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    @Override
    public String toString() {
        return "Persona{" + "nombre=" + nombre + ", telefono=" + telefono + ", nit=" + nit + ", dpi=" + dpi + ", email=" + email + ", direccion=" + direccion + '}';
    }
}
