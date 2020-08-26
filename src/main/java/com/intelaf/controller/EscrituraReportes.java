package com.intelaf.controller;

import static j2html.TagCreator.*;

import com.intelaf.dao.ReporteDAO;
import com.intelaf.model.*;
import java.io.*;
import java.util.List;

/**
 *
 * @author cesar31
 */
public class EscrituraReportes {

    ReporteDAO reportes = new ReporteDAO();
    private final String STYLE = "body { margin: 0; background-color: #FDFEFE; } "
            + "\n.container { width: 1024px; margin: auto; }"
            + "\nh1, h2 { text-align: center}"
            + "\ntable { width: 100%; border: 1px solid #000; }"
            + "\nth { font-size: 22px; font-weight: bold; background-color: #ff8800; }"
            + "\ntd, th { width: auto; text-align: center; border-collapse: collapse; padding: 10px; border: 1px solid #000; }"
            + "\ntd { font-size: 18px; }"
            + "\ntr:hover { font-size: 20px; background-color: #EB984E; cursor: pointer; }";

    public void escribirArchivo(String nombre, String data) {
        File archivo = new File(nombre);
        try {
            PrintWriter salida = new PrintWriter(archivo);
            salida.println(data);
            salida.close();
            System.out.println("Se ha escrito la informacino al archivo");
        } catch (FileNotFoundException ex) {
            ex.printStackTrace(System.out);
        }
    }

    /**
     * Reporte 1
     *
     * @param tiendaDestino
     */
    public void allOfTheOrders(String tiendaDestino) {
        List<Pedido> pedidos = reportes.allOfTheOrders(tiendaDestino);

        StringBuilder info = new StringBuilder();
        try {
            html(
                    head(
                            title("Reporte 1 - Intelaf.com"),
                            style(STYLE)
                    ),
                    body(
                            div(
                                    h1("Pedidos que llegaran a la Tienda"),
                                    h2(tiendaDestino),
                                    table(
                                            tbody(
                                                    tr(
                                                            th("Id"),
                                                            th("Cliente"),
                                                            th("Codigo Producto"),
                                                            th("Cantidad"),
                                                            th("SubTotal"),
                                                            th("Fecha Pedido"),
                                                            th("Total"),
                                                            th("Anticipo"),
                                                            th("Origen"),
                                                            th("Tiempo"),
                                                            th("Fecha Estimada")
                                                    ),
                                                    each(pedidos, p -> tr(
                                                    td(String.valueOf(p.getId())),
                                                    td(p.getNitCliente()),
                                                    td(p.getCodigoProducto()),
                                                    td(String.valueOf(p.getCantidad())),
                                                    td(String.valueOf(p.getSubTotalPedido())),
                                                    td(String.valueOf(p.getFechaPedido())),
                                                    td(String.valueOf(p.getTotalPedido())),
                                                    td(String.valueOf(p.getAnticipo())),
                                                    td(p.getTiendaOrigen()),
                                                    td(String.valueOf(p.getDias())),
                                                    td(String.valueOf(p.getArrivalDate()))
                                            ))
                                            )
                                    )
                            ).withClass("container")
                    )
            ).render(info);
        } catch (IOException ex) {
            ex.printStackTrace(System.out);
        }

        escribirArchivo("Reporte1.html", info.toString());
    }

    /**
     * Reporte 2 -> onTime Reporte 3 -> !onTime
     *
     * @param date
     * @param tiendaDestino
     * @param onTime
     */
    public void allOfTheOrdersOnTime(java.sql.Date date, String tiendaDestino, boolean onTime) {
        List<Pedido> pedidos = reportes.allOfTheOrdersOnTime(date, tiendaDestino, onTime);
        StringBuilder info = new StringBuilder();
        String title = onTime ? "Reporte 2" : "Reporte 3";
        String h1 = onTime ? "Pedidos que estan en tiempo pero deben verificar ingreso" : "Pedidos atrasados que llegaran a la tienda";
        String name = onTime ? "Reporte2.html" : "Reporte3.html";
        try {
            html(
                    head(
                            title(title + " - Intelaf.com"),
                            style(STYLE)
                    ),
                    body(
                            div(
                                    h1(h1),
                                    h2(tiendaDestino),
                                    h2(String.valueOf(date)),
                                    table(
                                            tbody(
                                                    tr(
                                                            th("Id"),
                                                            th("Cliente"),
                                                            th("Codigo Producto"),
                                                            th("Cantidad"),
                                                            th("SubTotal"),
                                                            th("Fecha Pedido"),
                                                            th("Total"),
                                                            th("Anticipo"),
                                                            th("Origen"),
                                                            th("Tiempo"),
                                                            th("Fecha Estimada")
                                                    ),
                                                    each(pedidos, p -> tr(
                                                    td(String.valueOf(p.getId())),
                                                    td(p.getNitCliente()),
                                                    td(p.getCodigoProducto()),
                                                    td(String.valueOf(p.getCantidad())),
                                                    td(String.valueOf(p.getSubTotalPedido())),
                                                    td(String.valueOf(p.getFechaPedido())),
                                                    td(String.valueOf(p.getTotalPedido())),
                                                    td(String.valueOf(p.getAnticipo())),
                                                    td(p.getTiendaOrigen()),
                                                    td(String.valueOf(p.getDias())),
                                                    td(String.valueOf(p.getArrivalDate()))
                                            ))
                                            )
                                    )
                            ).withClass("container")
                    )
            ).render(info);
        } catch (IOException ex) {
            ex.printStackTrace(System.out);
        }

        escribirArchivo(name, info.toString());
    }

    /**
     * Reporte 4
     *
     * @param tiendaOrigen
     */
    public void ordersInTransit(String tiendaOrigen) {
        List<Pedido> pedidos = reportes.ordersInTransit(tiendaOrigen);
        StringBuilder info = new StringBuilder();
        try {
            html(
                    head(
                            title("Reporte 4 - Intelaf.com"),
                            style(STYLE)
                    ),
                    body(
                            div(
                                    h1("Pedidos que salieron de la tienda " + tiendaOrigen),
                                    h2("y estan en transito"),
                                    table(
                                            tbody(
                                                    tr(
                                                            th("Id"),
                                                            th("Cliente"),
                                                            th("Codigo Producto"),
                                                            th("Cantidad"),
                                                            th("SubTotal"),
                                                            th("Fecha Pedido"),
                                                            th("Total"),
                                                            th("Anticipo"),
                                                            th("Destino"),
                                                            th("Tiempo"),
                                                            th("Fecha Estimada")
                                                    ),
                                                    each(pedidos, p -> tr(
                                                    td(String.valueOf(p.getId())),
                                                    td(p.getNitCliente()),
                                                    td(p.getCodigoProducto()),
                                                    td(String.valueOf(p.getCantidad())),
                                                    td(String.valueOf(p.getSubTotalPedido())),
                                                    td(String.valueOf(p.getFechaPedido())),
                                                    td(String.valueOf(p.getTotalPedido())),
                                                    td(String.valueOf(p.getAnticipo())),
                                                    td(p.getTiendaDestino()),
                                                    td(String.valueOf(p.getDias())),
                                                    td(String.valueOf(p.getArrivalDate()))
                                            ))
                                            )
                                    )
                            ).withClass("container")
                    )
            ).render(info);
        } catch (IOException ex) {
            ex.printStackTrace(System.out);
        }

        escribirArchivo("Reporte4.html", info.toString());
    }

    /**
     * Reporte 5
     *
     * @param nitCliente
     */
    public void comprasByCliente(String nitCliente) {
        List<Producto> productos = reportes.comprasByCliente(nitCliente);
        StringBuilder info = new StringBuilder();
        try {
            html(
                    head(
                            title("Reporte 5 - Intelaf.com"),
                            style(STYLE)
                    ),
                    body(
                            div(
                                    h1("Listado de compras realizadas por el cliente"),
                                    h2(nitCliente),
                                    table(
                                            tbody(
                                                    tr(
                                                            th("Id"),
                                                            th("Cliente"),
                                                            th("Nombre Cliente"),
                                                            th("Fecha Venta"),
                                                            th("Codigo Producto"),
                                                            th("Cantidad"),
                                                            th("SubTotal"),
                                                            th("Total"),
                                                            th("Tienda")
                                                    ),
                                                    each(productos, p -> tr(
                                                            td(String.valueOf(p.getId())),
                                                            td(p.getClientesNit()),
                                                            td(p.getNombreCliente()),
                                                            td(String.valueOf(p.getFechaVenta())),
                                                            td(p.getCodigoProductos()),
                                                            td(String.valueOf(p.getStock())),
                                                            td(String.valueOf(p.getSubTotal())),
                                                            td(String.valueOf(p.getTotalVenta())),
                                                            td(p.getCodigoTienda())
                                            ))
                                            )
                                    )                            
                            ).withClass("container")
                    )
            ).render(info);
        } catch (IOException ex) {
            ex.printStackTrace(System.out);
        }
        
        escribirArchivo("Reporte5.html", info.toString());
    }
    
    /**
     * Reporte 6
     * @param nitCliente 
     */
    public void ordersByClient(String nitCliente) {
        List<Pedido> pedidos = reportes.ordersByClient(nitCliente);
        StringBuilder info = new StringBuilder();
        try {
            html(
                    head(
                            title("Reporte 6 - Intelaf.com"),
                            style(STYLE)
                    ),
                    body(
                            div(
                                    h1("Pedidos en curso del cliente"),
                                    h2(nitCliente),
                                    table(
                                            tbody(
                                                    tr(
                                                            th("Id"),
                                                            th("Cliente"),
                                                            th("Codigo Producto"),
                                                            th("Cantidad"),
                                                            th("SubTotal"),
                                                            th("Fecha Pedido"),
                                                            th("Total"),
                                                            th("Anticipo"),
                                                            th("Destino"),
                                                            th("Origen"),
                                                            th("Fecha Estimada")
                                                    ),
                                                    each(pedidos, p -> tr(
                                                    td(String.valueOf(p.getId())),
                                                    td(p.getNitCliente()),
                                                    td(p.getCodigoProducto()),
                                                    td(String.valueOf(p.getCantidad())),
                                                    td(String.valueOf(p.getSubTotalPedido())),
                                                    td(String.valueOf(p.getFechaPedido())),
                                                    td(String.valueOf(p.getTotalPedido())),
                                                    td(String.valueOf(p.getAnticipo())),
                                                    td(p.getTiendaDestino()),
                                                    td(p.getTiendaOrigen()),
                                                    td(String.valueOf(p.getArrivalDate()))
                                            ))
                                            )
                                    )
                            ).withClass("container")
                    )
            ).render(info);
        } catch (IOException ex) {
            ex.printStackTrace(System.out);
        }

        escribirArchivo("Reporte6.html", info.toString());        
    }
    
    /**
     * Reporte 7 con tiempo
     * @param dateMin
     * @param dateMax 
     */
    public void productosTop10ByTime(java.sql.Date dateMin, java.sql.Date dateMax) {
        List<Producto> productos = reportes.productosTop10ByTime(dateMin, dateMax);
        StringBuilder info = new StringBuilder();
        try {
            html(
                    head(
                            title("Reporte 7(Tiempos) - Intelaf.com"),
                            style(STYLE)
                    ),
                    body(
                            div(
                                    h1("Top10 Productos"),
                                    h2(dateMin + " - " + dateMax),
                                    table(
                                            tbody(
                                                    tr(
                                                            th("Codigo"),
                                                            th("Nombre"),
                                                            th("Fabricante"),
                                                            th("Cantidad"),
                                                            th("Tiendas"),
                                                            th("Fechas")
                                                    ),
                                                    each(productos, p -> tr(
                                                            td(p.getCodigoProductos()),
                                                            td(p.getNombre()),
                                                            td(p.getFabricante()),
                                                            td(String.valueOf(p.getStock())),
                                                            td(p.getConcatInStore()),
                                                            td(p.getConcatDates())
                                            ))
                                            )
                                    )                            
                            ).withClass("container")
                    )
            ).render(info);
        } catch (IOException ex) {
            ex.printStackTrace(System.out);
        }
        
        escribirArchivo("Reporte7ConTiempos.html", info.toString());        
    }
    
    /**
     * Reporte 7
     */
    public void productosTop10() {
        List<Producto> productos = reportes.productosTop10();
        StringBuilder info = new StringBuilder();
        try {
            html(
                    head(
                            title("Reporte 7 - Intelaf.com"),
                            style(STYLE)
                    ),
                    body(
                            div(
                                    h1("Top10 Productos"),
                                    table(
                                            tbody(
                                                    tr(
                                                            th("Codigo"),
                                                            th("Nombre"),
                                                            th("Fabricante"),
                                                            th("Cantidad"),
                                                            th("Tiendas")
                                                    ),
                                                    each(productos, p -> tr(
                                                            td(p.getCodigoProductos()),
                                                            td(p.getNombre()),
                                                            td(p.getFabricante()),
                                                            td(String.valueOf(p.getStock())),
                                                            td(p.getConcatInStore())
                                            ))
                                            )
                                    )                            
                            ).withClass("container")
                    )
            ).render(info);
        } catch (IOException ex) {
            ex.printStackTrace(System.out);
        }
        
        escribirArchivo("Reporte7SinTiempo.html", info.toString());        
    }
    
    /**
     * Reporte 8 con tiempos
     * @param codigoTienda
     * @param min
     * @param max 
     */
    public void productosTopByTimeAndStore(String codigoTienda, java.sql.Date min, java.sql.Date max) {
        List<Producto> productos = reportes.productosTopByTimeAndStore(codigoTienda, min, max);
        StringBuilder info = new StringBuilder();
        try {
            html(
                    head(
                            title("Reporte 8(Tiempos) - Intelaf.com"),
                            style(STYLE)
                    ),
                    body(
                            div(
                                    h1("Top10 Productos en la tienda " + codigoTienda),
                                    h2(min + " - " + max),
                                    table(
                                            tbody(
                                                    tr(
                                                            th("Codigo"),
                                                            th("Nombre"),
                                                            th("Fabricante"),
                                                            th("Cantidad"),
                                                            th("Fechas")
                                                    ),
                                                    each(productos, p -> tr(
                                                            td(p.getCodigoProductos()),
                                                            td(p.getNombre()),
                                                            td(p.getFabricante()),
                                                            td(String.valueOf(p.getStock())),
                                                            td(p.getConcatDates())
                                            ))
                                            )
                                    )                            
                            ).withClass("container")
                    )
            ).render(info);
        } catch (IOException ex) {
            ex.printStackTrace(System.out);
        }
        
        escribirArchivo("Reporte8ConTiempos.html", info.toString());       
    }
    
    /**
     * Reporte 8 sin tiempos
     * @param codigoTienda 
     */
    public void productosTopByStore(String codigoTienda) {
        List<Producto> productos = reportes.productosTopByStore(codigoTienda);
        StringBuilder info = new StringBuilder();
        try {
            html(
                    head(
                            title("Reporte 8 - Intelaf.com"),
                            style(STYLE)
                    ),
                    body(
                            div(
                                    h1("Top10 Productos en la tienda " + codigoTienda),
                                    table(
                                            tbody(
                                                    tr(
                                                            th("Codigo"),
                                                            th("Nombre"),
                                                            th("Fabricante"),
                                                            th("Cantidad")
                                                    ),
                                                    each(productos, p -> tr(
                                                            td(p.getCodigoProductos()),
                                                            td(p.getNombre()),
                                                            td(p.getFabricante()),
                                                            td(String.valueOf(p.getStock()))
                                            ))
                                            )
                                    )                            
                            ).withClass("container")
                    )
            ).render(info);
        } catch (IOException ex) {
            ex.printStackTrace(System.out);
        }
        
        escribirArchivo("Reporte8.html", info.toString());       
    }    

    /**
     * Reporte 9
     *
     * @param codigoTienda
     */
    public void neverBeenSold(String codigoTienda) {
        List<Producto> productos = reportes.neverBeenSold(codigoTienda);

        StringBuilder info = new StringBuilder();
        try {
            html(
                    header(
                            title("Reporte 9 - Intelaf.com"),
                            style(STYLE)
                    ),
                    body(
                            div(
                                    h1("Productos que nunca se han vendido"),
                                    h2(codigoTienda),
                                    table(
                                            tbody(
                                                    tr(
                                                            th("Codigo Producto"),
                                                            th("Nombre Producto"),
                                                            th("Fabricante"),
                                                            th("Cantidad")
                                                    ),
                                                    each(productos, p -> tr(
                                                    td(p.getCodigoProductos()),
                                                    td(p.getNombre()),
                                                    td(p.getFabricante()),
                                                    td(String.valueOf(p.getStock()))
                                            ))
                                            )
                                    )
                            ).withClass("container")
                    )
            ).render(info);
        } catch (IOException ex) {
            ex.printStackTrace(System.out);
        }

        escribirArchivo("Reporte9.html", info.toString());
    }
}
