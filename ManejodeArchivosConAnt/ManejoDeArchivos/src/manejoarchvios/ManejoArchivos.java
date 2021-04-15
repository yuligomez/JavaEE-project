/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manejoarchvios;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author yulia
 */
public class ManejoArchivos {
    
    public static void crearArchivo (String nombreArchivo)
    {
        File archivo = new File (nombreArchivo);
        PrintWriter salida;
        try {
            salida = new PrintWriter (archivo);
            salida.close();
            System.out.println("Se ha creado el archivo");
        } catch (FileNotFoundException ex) {
            ex.printStackTrace(System.out);
        }
       
    } 
    
     public static void escrbibirArchivo (String nombreArchivo , String contenido)
    {
        File archivo = new File (nombreArchivo);
        PrintWriter salida;
        try {
            salida = new PrintWriter (archivo);
            salida.println(contenido);
            salida.close();
            System.out.println("Se ha escrito el archivo");
        } catch (FileNotFoundException ex) {
            ex.printStackTrace(System.out);
        }
       
    } 
    
    
}
