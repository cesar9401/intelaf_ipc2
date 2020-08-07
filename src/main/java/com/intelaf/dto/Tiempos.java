
package com.intelaf.dto;

/**
 *
 * @author cesar31
 */
public class Tiempos {
    
    private int tiemposId;
    private String tiendaOrigen;
    private String tiendaDestino;
    private int tiempoDias;

    public Tiempos(String tiendaOrigen, String tiendaDestino, int tiempoDias) {
        this.tiendaOrigen = tiendaOrigen;
        this.tiendaDestino = tiendaDestino;
        this.tiempoDias = tiempoDias;
    }

    public Tiempos(int tiemposId, String tiendaOrigen, String tiendaDestino, int tiempoDias) {
        this.tiemposId = tiemposId;
        this.tiendaOrigen = tiendaOrigen;
        this.tiendaDestino = tiendaDestino;
        this.tiempoDias = tiempoDias;
    }

    public int getId_tiempos() {
        return tiemposId;
    }

    public void setId_tiempos(int id_tiempos) {
        this.tiemposId = id_tiempos;
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
        return "Tiempos{" + "id_tiempos=" + tiemposId + ", tiendaOrigen=" + tiendaOrigen + ", tiendaDestino=" + tiendaDestino + ", tiempoDias=" + tiempoDias + '}';
    }
}
