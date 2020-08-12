
package com.intelaf.controller;

import com.intelaf.dao.*;
import com.intelaf.model.*;
import com.intelaf.view.Login;
import com.intelaf.view.MainView;
import java.util.*;

/**
 *
 * @author cesar31
 */
public class MainControl {
    
    List<Tienda> tiendas;
    Login login;
    
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
        login = new Login();
        login.initializeComponents(this, codigos);
        login.setVisible(true);
    }
    
    public void iniciarSesion(String codigo, boolean empleado, String codigoTienda) {
        if(empleado) {
            EmpleadoDAO opeE = new EmpleadoDAO();
            Empleado e = opeE.getEmpleado(codigo);
            if(e != null) {
                //Mostrar ventana principal para empleados
                TiendaDAO opeT = new TiendaDAO();
                Tienda t = opeT.getTienda(codigoTienda);
                System.out.println(e.toString());
                System.out.println(t.toString());
                
                MainView mainView = new MainView();
                mainView.initializeComponents(t, e);
                login.clear();
                login.setVisible(false);
                mainView.setVisible(true);
                
            } else {
                //Enviar codigo incorrecto a ventana login
                System.out.println("Codigo incorrecto");
            }
        } else {
            System.out.println("Cliente " + codigo);
            ClienteDAO opeC = new ClienteDAO();
            Cliente c = opeC.getCliente(codigo);
            if(c != null) {
                //Mostrar ventana principal para clientes
                System.out.println(c.toString());
                
            } else {
                System.out.println("Nit incorrecto");
            }
        }
    }
}
