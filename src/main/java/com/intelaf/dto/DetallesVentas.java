
package com.intelaf.dto;

/**
 *
 * @author cesar31
 */
public class DetallesVentas {
    
    private int idVentas;
    private int tiendasProductosId;
    private int cantidad;
    private double precioVenta;
    private double subTotal;

    public DetallesVentas(int tiendasHasProductos, int cantidad, double precioVenta, double subTotal) {
        this.tiendasProductosId = tiendasHasProductos;
        this.cantidad = cantidad;
        this.precioVenta = precioVenta;
        this.subTotal = subTotal;
    }

    public DetallesVentas(int idVentas, int tiendasHasProductos, int cantidad, double precioVenta, double subTotal) {
        this.idVentas = idVentas;
        this.tiendasProductosId = tiendasHasProductos;
        this.cantidad = cantidad;
        this.precioVenta = precioVenta;
        this.subTotal = subTotal;
    }

    public int getIdVentas() {
        return idVentas;
    }

    public void setIdVentas(int idVentas) {
        this.idVentas = idVentas;
    }

    public int getTiendasProductosId() {
        return tiendasProductosId;
    }

    public void setTiendasProductosId(int tiendasProductosId) {
        this.tiendasProductosId = tiendasProductosId;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(double precioVenta) {
        this.precioVenta = precioVenta;
    }

    public double getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(double subTotal) {
        this.subTotal = subTotal;
    }

    @Override
    public String toString() {
        return "DetallesVentas{" + "idVentas=" + idVentas + ", tiendasProductosId=" + tiendasProductosId + ", cantidad=" + cantidad + ", precioVenta=" + precioVenta + ", subTotal=" + subTotal + '}';
    }
}
