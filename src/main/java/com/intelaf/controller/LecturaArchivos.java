
package com.intelaf.controller;

import com.intelaf.model.*;
import java.io.*;
import java.text.*;
import java.util.*;

/**
 *
 * @author cesar31
 */
public class LecturaArchivos {
    
    private MainControl control;
    List<Tienda> tiendas;
    List<Tiempo> tiempos;
    List<Producto> productos;
    List<Empleado> empleados;
    List<Cliente> clientes;
    List<Pedido> pedidos;
    
    public LecturaArchivos(MainControl control) {
        this.control = control;
        this.tiendas = new ArrayList<>();
        this.tiempos = new ArrayList<>();
        this.productos = new ArrayList<>();
        this.empleados = new ArrayList<>();
        this.clientes = new ArrayList<>();
        this.pedidos = new ArrayList<>();
    }
    
    public void readData(String path) {
        File archivo = new File(path);
        try {
            BufferedReader br = new BufferedReader(new FileReader(archivo));
            String line = br.readLine();
            while(line != null) {
                control.setDB(line);
                clasificacionData(line);
                line = br.readLine();
            }
            br.close();
            
            EscrituraDB setData = new EscrituraDB(tiendas, tiempos, productos, empleados, clientes, pedidos);
            setData.initializeControl(control);
            setData.createData();

        } catch (FileNotFoundException ex) {
            ex.printStackTrace(System.out);
        } catch (IOException ex) {
            ex.printStackTrace(System.out);
        }
    }
    
    public void clasificacionData(String line) {
        String[] data = line.split(",");
        switch(data[0]) {
            case "TIENDA":
                tiendas.add(new Tienda(data[1], data[2], data[3], data[4]));
            break;
            case "TIEMPO":
                int tiempo = Integer.parseInt(data[3]);
                tiempos.add(new Tiempo(data[1], data[2], tiempo));
                //Tiempo de "regreso"
                tiempos.add(new Tiempo(data[2], data[1], tiempo));
            break;
            case "PRODUCTO":
                int stock = Integer.parseInt(data[4]);
                double precio = Double.parseDouble(data[5]);
                productos.add(new Producto(data[1], data[2], data[3], stock, precio, data[6]));
            break;
            case "EMPLEADO":
                empleados.add(new Empleado(data[1], data[2], data[3], data[4]));
            break;
            case "CLIENTE":
                double credito = Double.parseDouble(data[4]);
                Cliente tmp = new Cliente(data[1], data[3], credito);
                tmp.setNit(data[2]);
                clientes.add(tmp);
            break;
            case "PEDIDO":                
                int codigo = Integer.parseInt(data[1]);
                int cantidad = Integer.parseInt(data[7]);
                double total = Double.parseDouble(data[8]);
                double anticipo = Double.parseDouble(data[9]);
                java.sql.Date date = getDate(data[4]);
                pedidos.add(new Pedido(codigo, data[2], data[3], date, data[5], data[6], cantidad, total, anticipo));
            break;

            default:
                System.out.println("Error: " + line);
            break;
        }
    }
    
    private java.sql.Date getDate(String source) {
        java.sql.Date date = null;
        try {
            SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
            Date fecha = formato.parse(source);
            date = new java.sql.Date(fecha.getTime());
        } catch (ParseException ex) {
            ex.printStackTrace(System.out);
        }
        return date;
    }
}
