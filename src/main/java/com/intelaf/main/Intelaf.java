
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
        Producto tmp = new Producto("ABC-1", "JPJ-196", -100);
        
        ProductoDAO prod = new ProductoDAO();
        System.out.println(prod.updateStockProductos(tmp));
    }
}
