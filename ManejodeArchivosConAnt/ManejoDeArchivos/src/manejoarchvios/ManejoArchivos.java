/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manejoarchvios;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
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
    
    public static void anexarContenido (String nombreArchivo , String contenido) throws IOException
    {
        File archivo = new File (nombreArchivo);
        try {
            PrintWriter salida = new PrintWriter (new FileWriter(archivo, true));
            salida.println(contenido);
            salida.close();
            System.out.println("Se ha anexado informacion al archivo");
        } catch (FileNotFoundException ex) {
            ex.printStackTrace(System.out);
        }
       
    } 
    public static void leerArchivo (String nombreArchivo) throws IOException
    {
        File archivo = new File (nombreArchivo);
        
        try {
            //creo objeto BuffferReader para poder leer 
            BufferedReader entrada = new BufferedReader (new FileReader(archivo));
            String lectura = entrada.readLine(); //leo primer lineas
            while (lectura != null)
            {
                 System.out.println("el archivo dice " + lectura); // imprimo primer linea
                 lectura = entrada.readLine();   // leo la siguiente linea
                 entrada.close();
            }
        } catch (FileNotFoundException ex) {
             ex.printStackTrace(System.out);
        }
    }
    
    
}
