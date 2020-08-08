
package com.intelaf.model;

/**
 *
 * @author cesar31
 */
public class Tiempo {
    
    private int tiemposId;
    private String tiendaOrigen;
    private String tiendaDestino;
    private int tiempoDias;

    public Tiempo(String tiendaOrigen, String tiendaDestino, int tiempoDias) {
        this.tiendaOrigen = tiendaOrigen;
        this.tiendaDestino = tiendaDestino;
        this.tiempoDias = tiempoDias;
    }

    public Tiempo(int tiemposId, String tiendaOrigen, String tiendaDestino, int tiempoDias) {
        this.tiemposId = tiemposId;
        this.tiendaOrigen = tiendaOrigen;
        this.tiendaDestino = tiendaDestino;
        this.tiempoDias = tiempoDias;
    }

    public int getTiemposId() {
        return tiemposId;
    }

    public void setTiemposId(int tiemposId) {
        this.tiemposId = tiemposId;
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

    public int getTiempoDias() {
        return tiempoDias;
    }

    public void setTiempoDias(int tiempoDias) {
        this.tiempoDias = tiempoDias;
    }

    @Override
    public String toString() {
        return "Tiempos{" + "tiemposId=" + tiemposId + ", tiendaOrigen=" + tiendaOrigen + ", tiendaDestino=" + tiendaDestino + ", tiempoDias=" + tiempoDias + '}';
    }
}
