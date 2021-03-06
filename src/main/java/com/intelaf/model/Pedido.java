
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
    private double totalPedido;
    private double anticipo;
    private java.sql.Date fechaLlegada;
    private boolean entregado;
    private boolean aTiempo;
    private java.sql.Date arrivalDate;
    private int dias;

    //Detalles
    private int idDetalle;
    private int cantidad;
    private double precioVentaPedido;
    private double subTotalPedido;  
    private int tiendasProductosId;

    //Tiendas
    private String tiendaOrigen;
    private String tiendaDestino;
    
    //Articulo
    private String codigoProducto;
    
    //Reporte
    private String nombreCliente;
            
    //Constructor para carga de Archivos
    public Pedido(int id, String tiendaOrigen, String tiendaDestino, Date fechaPedido, String nitCliente, String codigoProducto, int cantidad, double subTotalPedido, double anticipo) {
        this.id = id;
        this.tiendaOrigen = tiendaOrigen;
        this.tiendaDestino = tiendaDestino;
        this.fechaPedido = fechaPedido;
        this.nitCliente = nitCliente;
        this.codigoProducto = codigoProducto;
        this.cantidad = cantidad;
        this.subTotalPedido = subTotalPedido;
        this.anticipo = anticipo;
    }
    
    //Constructor para pedidos nuevos
    public Pedido(String nitCliente, int tiemposId, Date fechaPedido, double totalPedido, double anticipo) {
        this.nitCliente = nitCliente;
        this.tiemposId = tiemposId;
        this.fechaPedido = fechaPedido;
        this.totalPedido = totalPedido;
        this.anticipo = anticipo;
    }

    //Constructor para obtener pedidos y validarlos
    public Pedido(int id, String nitCliente, Date fechaPedido, double totalPedido, double anticipo, Date arrivalDate) {
        this.id = id;
        this.nitCliente = nitCliente;
        this.fechaPedido = fechaPedido;
        this.totalPedido = totalPedido;
        this.anticipo = anticipo;
        this.arrivalDate = arrivalDate;
    }

    public Pedido(int id, String nitCliente, Date fechaPedido, double totalPedido, double anticipo, Date fechaLlegada, boolean aTiempo) {
        this.id = id;
        this.nitCliente = nitCliente;
        this.fechaPedido = fechaPedido;
        this.totalPedido = totalPedido;
        this.anticipo = anticipo;
        this.fechaLlegada = fechaLlegada;
        this.aTiempo = aTiempo;
    }    
    
    //Constructor para detallesPedidos
    public Pedido(int tiendasProductosId, String codigoProducto, int cantidad, double precioVentaPedido, double subTotalPedido) {
        this.tiendasProductosId = tiendasProductosId;
        this.codigoProducto = codigoProducto;
        this.cantidad = cantidad;
        this.precioVentaPedido = precioVentaPedido;
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

    public double getTotalPedido() {
        return totalPedido;
    }

    public void setTotalPedido(double totalPedido) {
        this.totalPedido = totalPedido;
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

    public boolean isaTiempo() {
        return aTiempo;
    }

    public void setaTiempo(boolean aTiempo) {
        this.aTiempo = aTiempo;
    }

    public Date getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(Date arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    public int getDias() {
        return dias;
    }

    public void setDias(int dias) {
        this.dias = dias;
    }
    
    public int getIdDetalle() {
        return idDetalle;
    }

    public void setIdDetalle(int idDetalle) {
        this.idDetalle = idDetalle;
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

    public int getTiendasProductosId() {
        return tiendasProductosId;
    }

    public void setTiendasProductosId(int tiendasProductosId) {
        this.tiendasProductosId = tiendasProductosId;
    }

    public String getTiendaOrigen() {
        return tiendaOrigen;
    }

    public void setTiendaOrigen(String tiendaOrigen) {
        this.tiendaOrigen = tiendaOrigen;
    }

    public String getTiendaDestino() {
        return tiendaDestino;
    }

    public void setTiendaDestino(String tiendaDestino) {
        this.tiendaDestino = tiendaDestino;
    }

    public String getCodigoProducto() {
        return codigoProducto;
    }

    public void setCodigoProducto(String codigoProducto) {
        this.codigoProducto = codigoProducto;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }
    
    @Override
    public String toString() {
        return "Pedido{" + "id=" + id + ", tiendaOrigen=" + tiendaOrigen + ", tiendaDestino=" + tiendaDestino + ", fechaPedido=" + fechaPedido + ", nitCliente=" + nitCliente + ", codigoArticulo=" + codigoProducto + ", cantidad=" + cantidad + ", subTotalPedido=" + subTotalPedido + ", anticipo=" + anticipo + '}';
    }
}
