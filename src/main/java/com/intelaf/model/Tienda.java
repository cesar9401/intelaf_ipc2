
package com.intelaf.model;

/**
 *
 * @author cesar31
 */
public class Tienda {
    
    private String codigo;
    private String nombre;
    private String direccion;
    private String telefono1;
    private String telefono2;
    private String email;
    private String horario;

    //Constructor para tiendasDestinos
    public Tienda(String codigo) {
        this.codigo = codigo;
    }

    public Tienda(String codigo, String nombre, String direccion, String telefono1) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono1 = telefono1;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getTelefono1() {
        return telefono1;
    }

    public void setTelefono1(String telefono1) {
        this.telefono1 = telefono1;
    }

    public String getTelefono2() {
        return telefono2;
    }

    public void setTelefono2(String telefono2) {
        this.telefono2 = telefono2;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    @Override
    public String toString() {
        return "Tienda{" + nombre + ", direccion=" + direccion + ", codigo=" + codigo + ", telefono1=" + telefono1 + ", telefono2=" + telefono2 + ", email=" + email + ", horario=" + horario + '}';
    }
}
