
package com.intelaf.model;

/**
 *
 * @author cesar31
 */
public class DetalleVenta {
    
    private int id;
    private int idVentas;
    private int tiendasProductosId;
    private int cantidad;
    private double precioVenta;
    private double subTotal;

    public DetalleVenta(int tiendasProductosId, int cantidad, double precioVenta, double subTotal) {
        this.tiendasProductosId = tiendasProductosId;
        this.cantidad = cantidad;
        this.precioVenta = precioVenta;
        this.subTotal = subTotal;
    }

    public DetalleVenta(int idVentas, int tiendasProductosId, int cantidad, double precioVenta, double subTotal) {
        this.idVentas = idVentas;
        this.tiendasProductosId = tiendasProductosId;
        this.cantidad = cantidad;
        this.precioVenta = precioVenta;
        this.subTotal = subTotal;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
