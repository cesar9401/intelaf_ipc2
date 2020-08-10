
package com.intelaf.model;

/**
 *
 * @author cesar31
 */
public class Producto {
        
    private String nombre;
    private String fabricante;
    private String codigoProductos;
    private double precio;
    private String descripcion;
    private int garantia;
    
    //Tabla tiendasProductos
    private int tiendasProductosId;
    private int stock;
    private String codigoTienda;

    public Producto(String codigoProductos) {
        this.codigoProductos = codigoProductos;
    }

    //Constructor tiendasProductos
    public Producto(int tiendasProdudctosId, String codigoTienda, String codigoProductos, int stock) {
        this.tiendasProductosId = tiendasProdudctosId;
        this.codigoTienda = codigoTienda;
        this.codigoProductos = codigoProductos;
        this.stock = stock;
    }
    
    public Producto(String codigoTienda, String codigoProductos, int stock) {
        this.codigoTienda = codigoTienda;
        this.codigoProductos = codigoProductos;
        this.stock = stock;
    }

    public Producto(String nombre, String fabricante, String codigoProductos, double precio, String descripcion, int garantia) {
        this.nombre = nombre;
        this.fabricante = fabricante;
        this.codigoProductos = codigoProductos;
        this.precio = precio;
        this.descripcion = descripcion;
        this.garantia = garantia;
    }
    
    //Constructor para carga de archivos
    public Producto(String nombre, String fabricante, String codigoProductos, int stock, double precio, String codigoTienda) {
        this.nombre = nombre;
        this.fabricante = fabricante;
        this.codigoProductos = codigoProductos;
        this.stock = stock;
        this.precio = precio;
        this.codigoTienda = codigoTienda;
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

    public String getCodigoProductos() {
        return codigoProductos;
    }

    public void setCodigoProductos(String codigoProductos) {
        this.codigoProductos = codigoProductos;
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

    public int getTiendasProductosId() {
        return tiendasProductosId;
    }

    public void setTiendasProductosId(int tiendasProductosId) {
        this.tiendasProductosId = tiendasProductosId;
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

    @Override
    public String toString() {
        return "Producto{" + "nombre=" + nombre + ", fabricante=" + fabricante + ", codigoProductos=" + codigoProductos + ", precio=" + precio + '}';
    }
}
