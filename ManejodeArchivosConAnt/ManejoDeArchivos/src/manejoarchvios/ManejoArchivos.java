/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manejoarchvios;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

public class ManejoArchivos {

    public static void crearArchivo(String nombreArchivo) throws IOException {
        File archivo = new File("C:\\Users\\yulia\\OneDrive\\Escritorio", nombreArchivo);
        PrintWriter salida;
        try {
            salida = new PrintWriter(archivo);
            salida.close();
            System.out.println("Se ha creado el archivo");
            System.out.println("Attempting to read from file in: "+archivo.getCanonicalPath());
        } catch (FileNotFoundException ex) {
            ex.printStackTrace(System.out);
        }

    }

    public static void escrbibirArchivo(String nombreArchivo, String contenido) {
        File archivo = new File(nombreArchivo);
        PrintWriter salida;
        try {
            salida = new PrintWriter(archivo);
            salida.println(contenido);
            salida.close();
            System.out.println("Se ha escrito el archivo");
        } catch (FileNotFoundException ex) {
            ex.printStackTrace(System.out);
        }

    }

  
  
        public static void generarPdf(String nombre) throws FileNotFoundException, DocumentException
         {
             FileOutputStream archivo = new FileOutputStream( nombre + ".pdf");
             Document documento = new Document();
             PdfWriter.getInstance(documento,archivo);
             documento.open();
             
             
             Paragraph parrafo = new Paragraph("header");
             documento.add(parrafo);
             documento.add(new Paragraph("contenido"));
             documento.add(new Paragraph("fin"));
             
             documento.close();
             
         }

  
    public static void leerArchivo(String nombreArchivo) throws IOException {
        File archivo = new File(nombreArchivo);

        try {
            //creo objeto BuffferReader para poder leer 
            BufferedReader entrada = new BufferedReader(new FileReader(archivo));
            String lectura = entrada.readLine(); //leo primer lineas
            while (lectura != null) {
                System.out.println("el archivo dice " + lectura); // imprimo primer linea
                lectura = entrada.readLine();   // leo la siguiente linea
                entrada.close();
            }
        } catch (FileNotFoundException ex) {
            ex.printStackTrace(System.out);
        }
    }
}
