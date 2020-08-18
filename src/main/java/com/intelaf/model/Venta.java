
package com.intelaf.model;

import java.sql.Date;

/**
 *
 * @author cesar31
 */
public class Venta {
    
    private int id;
    private int pedidosId;
    private String nitCliente;
    private java.sql.Date fechaVenta;
    private double totalVenta;
    private double descuentoCredito;

    public Venta(int pedidosId, String nitCliente, Date fechaVenta, double totalVenta, double descuentoCredito) {
        this.pedidosId = pedidosId;
        this.nitCliente = nitCliente;
        this.fechaVenta = fechaVenta;
        this.totalVenta = totalVenta;
        this.descuentoCredito = descuentoCredito;
    }

    public Venta(int id, int pedidosId, String nitCliente, Date fechaVenta, double totalVenta, double descuentoCredito) {
        this.id = id;
        this.pedidosId = pedidosId;
        this.nitCliente = nitCliente;
        this.fechaVenta = fechaVenta;
        this.totalVenta = totalVenta;
        this.descuentoCredito = descuentoCredito;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPedidosId() {
        return pedidosId;
    }

    public void setPedidosId(int pedidosId) {
        this.pedidosId = pedidosId;
    }

    public String getNitCliente() {
        return nitCliente;
    }

    public void setNitCliente(String nitCliente) {
        this.nitCliente = nitCliente;
    }

    public Date getFechaVenta() {
        return fechaVenta;
    }

    public void setFechaVenta(Date fechaVenta) {
        this.fechaVenta = fechaVenta;
    }

    public double getTotalVenta() {
        return totalVenta;
    }

    public void setTotalVenta(double totalVenta) {
        this.totalVenta = totalVenta;
    }

    public double getDescuentoCredito() {
        return descuentoCredito;
    }

    public void setDescuentoCredito(double descuentoCredito) {
        this.descuentoCredito = descuentoCredito;
    }

    @Override
    public String toString() {
        return "Venta{" + "id=" + id + ", pedidosId=" + pedidosId + ", nitCliente=" + nitCliente + ", fechaVenta=" + fechaVenta + ", totalVenta=" + totalVenta + ", descuentoCredito=" + descuentoCredito + '}';
    }
}
