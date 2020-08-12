
package com.intelaf.controller;

import com.intelaf.dao.TiendaDAO;
import com.intelaf.model.Tienda;
import com.intelaf.view.Login;
import java.util.*;
import javax.swing.JFrame;

/**
 *
 * @author cesar31
 */
public class MainControl {
    
    List<Tienda> tiendas;
    
    public MainControl() {
        iniciarComponentes();
    }
    
    private void iniciarComponentes() {
        TiendaDAO storeOp = new TiendaDAO();
        tiendas = storeOp.getTiendas();
    }
    
    public void showLogin() {
        List<String> codigos = new ArrayList<>();
        
        tiendas.forEach((t) -> {
            codigos.add(t.getCodigo());
        });
        JFrame login = new Login(codigos);
        login.setVisible(true);
    }
}
