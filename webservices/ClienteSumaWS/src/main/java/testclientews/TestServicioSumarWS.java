/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testclientews;

import clientews.servicio.ServicioSumarImplService;
import clientews.servicio.ServicioSumarWS;

public class TestServicioSumarWS {
    
    public static void main (String [] args ) 
    {
    
        ServicioSumarWS servicioSumar = new ServicioSumarImplService().getServicioSumarImplPort();
        System.out.println("Ejecutando servicio sumarws");
        int x = 6;
        int y = 6;
        int result = servicioSumar.sumar(x, y);
       System.out.println("resultado " + result);
       System.out.println("Fin de servicio sumarws");
    }
}
