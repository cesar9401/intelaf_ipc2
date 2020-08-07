
package com.intelaf.dto;

import java.sql.Date;

/**
 *
 * @author cesar31
 */
public class Pedidos {
    
    private int id;
    private String nitCliente;
    private int tiemposId;
    private java.sql.Date fechaPedido;
    private double anticipo;
    private java.sql.Date fechaLlegada;
    private boolean entregado;

    public Pedidos(String nitCliente, int tiemposId, Date fechaPedido, Date fechaLlegada, double anticipo) {
        this.nitCliente = nitCliente;
        this.tiemposId = tiemposId;
        this.fechaPedido = fechaPedido;
        this.fechaLlegada = fechaLlegada;
        this.anticipo = anticipo;
    }

    public Pedidos(int id, String nitCliente, int tiemposId, Date fechaPedido, double anticipo, Date fechaLlegada) {
        this.id = id;
        this.nitCliente = nitCliente;
        this.tiemposId = tiemposId;
        this.fechaPedido = fechaPedido;
        this.anticipo = anticipo;
        this.fechaLlegada = fechaLlegada;
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

    @Override
    public String toString() {
        return "Pedidos{" + "id=" + id + ", nitCliente=" + nitCliente + ", tiemposId=" + tiemposId + ", fechaPedido=" + fechaPedido + ", anticipo=" + anticipo + ", fechaLlegada=" + fechaLlegada + ", entregado=" + entregado + '}';
    }
}
