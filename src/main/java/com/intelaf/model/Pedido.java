
package com.intelaf.model;

import java.sql.Date;

/**
 *
 * @author cesar31
 */
public class Pedido {
    
    private int id;
    private String nitCliente;
    private int tiemposId;
    private java.sql.Date fechaPedido;
    private double anticipo;
    private java.sql.Date fechaLlegada;
    private boolean entregado;

    //Detalles
    private int tiendasProductosId;
    private int cantidad;
    private double precioVentaPedido;
    private double subTotalPedido;  
    
    
    public Pedido(String nitCliente, int tiemposId, Date fechaPedido, Date fechaLlegada, double anticipo) {
        this.nitCliente = nitCliente;
        this.tiemposId = tiemposId;
        this.fechaPedido = fechaPedido;
        this.fechaLlegada = fechaLlegada;
        this.anticipo = anticipo;
    }

    public Pedido(int id, String nitCliente, int tiemposId, Date fechaPedido, double anticipo) {
        this.id = id;
        this.nitCliente = nitCliente;
        this.tiemposId = tiemposId;
        this.fechaPedido = fechaPedido;
        this.anticipo = anticipo;
    }
    
    //Constructores para detallesPedidos
    public Pedido(int id, int tiendasProductosId, int cantidad, double subTotalPedido) {
        this.id = id;
        this.tiendasProductosId = tiendasProductosId;
        this.cantidad = cantidad;
        this.subTotalPedido = subTotalPedido;
    }

    public Pedido(int tiendasProductosId, int cantidad, double subTotalPedido) {
        this.tiendasProductosId = tiendasProductosId;
        this.cantidad = cantidad;
        this.subTotalPedido = subTotalPedido;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNitCliente() {
        return nitCliente;
    }

    public void setNitCliente(String nitCliente) {
        this.nitCliente = nitCliente;
    }

    public int getTiemposId() {
        return tiemposId;
    }

    public void setTiemposId(int tiemposId) {
        this.tiemposId = tiemposId;
    }

    public Date getFechaPedido() {
        return fechaPedido;
    }

    public void setFechaPedido(Date fechaPedido) {
        this.fechaPedido = fechaPedido;
    }

    public double getAnticipo() {
        return anticipo;
    }

    public void setAnticipo(double anticipo) {
        this.anticipo = anticipo;
    }

    public Date getFechaLlegada() {
        return fechaLlegada;
    }

    public void setFechaLlegada(Date fechaLlegada) {
        this.fechaLlegada = fechaLlegada;
    }

    public boolean isEntregado() {
        return entregado;
    }

    public void setEntregado(boolean entregado) {
        this.entregado = entregado;
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
        return "Pedidos{" + "id=" + id + ", nitCliente=" + nitCliente + ", fechaPedido=" + fechaPedido + ", anticipo=" + anticipo + ", entregado=" + entregado + '}';
    }
}
