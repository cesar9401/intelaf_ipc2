
package com.intelaf.dto;

/**
 *
 * @author cesar31
 */
public class Producto {
    
    private int id;
    private String nombre;
    private String fabricante;
    private String codigo;
    private double precio;
    private String descripcion;
    private int garantia;
    
    private int stock;
    private String codigoTienda;
    private int idTienda;

    //Constructor tiendas_has_productos
    public Producto(int id, int stock, int idTienda) {
        this.id = id;
        this.stock = stock;
        this.idTienda = idTienda;
    }
    
    public Producto(String nombre, String fabricante, String codigo, double precio, int stock, String codigoTienda) {
        this.nombre = nombre;
        this.fabricante = fabricante;
        this.codigo = codigo;
        this.precio = precio;
        this.stock = stock;
        this.codigoTienda = codigoTienda;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getGarantia() {
        return garantia;
    }

    public void setGarantia(int garantia) {
        this.garantia = garantia;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getCodigoTienda() {
        return codigoTienda;
    }

    public void setCodigoTienda(String codigoTienda) {
        this.codigoTienda = codigoTienda;
    }

    public int getIdTienda() {
        return idTienda;
    }

    public void setIdTienda(int idTienda) {
        this.idTienda = idTienda;
    }

    @Override
    public String toString() {
        return "Producto{" + "nombre=" + nombre + ", fabricante=" + fabricante + ", codigo=" + codigo + ", precio=" + precio + '}';
    }
}
