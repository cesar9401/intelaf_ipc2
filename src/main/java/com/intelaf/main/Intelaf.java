
package com.intelaf.main;

import com.intelaf.dao.*;
import com.intelaf.model.*;

/**
 *
 * @author cesar31
 */
public class Intelaf {
    public static void main(String[] args) {
        //Write your code here
        TiendaDAO dataTiendas = new TiendaDAO();
        Tienda tienda = new Tienda("Interplaza Xela", "Quetzaltenango", "ABC-1", "77651245");
        tienda.setTelefono2("77653456");
        tienda.setEmail("intelaf.xela@intelaf.com");
        tienda.setHorario("8:30 - 19:00");
        System.out.println(dataTiendas.updateTienda(tienda));
    }
}
