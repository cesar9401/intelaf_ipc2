
package com.intelaf.dto;

/**
 *
 * @author cesar31
 */
public class DetallesPedidos {
    
    private int idPedidos;
    private int tiendasProductosId;
    private int cantidad;
    private double precioVentaPedido;
    private double subTotalPedido;

    public DetallesPedidos(int tiendasProductosId, int cantidad, double precioVentaPedido, double subTotalPedido) {
        this.tiendasProductosId = tiendasProductosId;
        this.cantidad = cantidad;
        this.precioVentaPedido = precioVentaPedido;
        this.subTotalPedido = subTotalPedido;
    }

    public DetallesPedidos(int idPedidos, int tiendasProductosId, int cantidad, double precioVentaPedido, double subTotalPedido) {
        this.idPedidos = idPedidos;
        this.tiendasProductosId = tiendasProductosId;
        this.cantidad = cantidad;
        this.precioVentaPedido = precioVentaPedido;
        this.subTotalPedido = subTotalPedido;
    }

    public int getIdPedidos() {
        return idPedidos;
    }

    public void setIdPedidos(int idPedidos) {
        this.idPedidos = idPedidos;
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

    public double getPrecioVentaPedido() {
        return precioVentaPedido;
    }

    public void setPrecioVentaPedido(double precioVentaPedido) {
        this.precioVentaPedido = precioVentaPedido;
    }

    public double getSubTotalPedido() {
        return subTotalPedido;
    }

    public void setSubTotalPedido(double subTotalPedido) {
        this.subTotalPedido = subTotalPedido;
    }

    @Override
    public String toString() {
        return "DetallesPedidos{" + "idPedidos=" + idPedidos + ", tiendasProductosId=" + tiendasProductosId + ", cantidad=" + cantidad + ", precioVentaPedido=" + precioVentaPedido + ", subTotalPedido=" + subTotalPedido + '}';
    }
}
