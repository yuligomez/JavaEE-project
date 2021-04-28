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

  
   public static void generarArchivosTxt_Pdf(String nombreArchivo, String contenidoTxt) throws DocumentException {
	

		try {
			File f = new File("C:\\Users\\yulia\\OneDrive\\Escritorio" , nombreArchivo);
			FileWriter writer = new FileWriter(f);
			BufferedWriter salida = new BufferedWriter(writer);
			Date inicio = new Date();
			salida.write(contenidoTxt);
			Date fin = new Date();
			Long diferencia = fin.getTime() - inicio.getTime();
			salida.close();
                        System.out.println("Se ha escrito el archivo de prueba");
			writer.close();

                    String linea;
		    FileReader fr = null;
		    BufferedReader br = null;
		    // Abro el archivo y crea el reader.
		    File InFile = f;
		    fr = new FileReader (InFile);
                    br = new BufferedReader(fr);
                    //Crea el documento pdf de salida.
		    FileOutputStream archivo = new FileOutputStream("C:\\Users\\yulia\\OneDrive\\Escritorio"  + InFile.getName() + ".pdf");
		    Document documentoPdf = new Document();
		    PdfWriter.getInstance(documentoPdf, archivo);
		    documentoPdf.open();
		    try{
		          while((linea=br.readLine())!=null){
		        	  documentoPdf = agregarLineaNueva(documentoPdf,linea);
	            }
		    }catch(Exception e){
		    	e.printStackTrace();
		    }finally{
		      
		         try{
		            if( null != fr ){
		               fr.close();
		            }
		         }catch (Exception e2){
		            e2.printStackTrace();
		         }
		      }
		    documentoPdf.close();
		    System.out.println("se creo el pdf correctamente");
		
		} catch (IOException e) {
                      System.out.println("Error al generar el archivo local");
		}
		
	}
    public static Document agregarLineaNueva(Document doc, String linea) {
        try {
            doc.add(new Paragraph(linea));
        } catch (DocumentException de) {
            de.printStackTrace();
        }
        return doc;
    }
        public static void generar(String nombre) throws FileNotFoundException, DocumentException
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

    public static void generarArchivoPdf(String nombreArchvio, String contenidoTxt) throws DocumentException, FileNotFoundException
    {
        
        Document documento;
        FileOutputStream archivoPdf;
        Paragraph contenido;
        documento = new Document();
        contenido = new Paragraph(contenidoTxt);
        archivoPdf = new FileOutputStream( nombreArchvio + ".pdf"); //va a buscar este
        PdfWriter.getInstance(documento,archivoPdf);
        documento.open();
        documento.add(contenido);
        documento.close();
        /*
        FileOutputStream archivo = new FileOutputStream("C:\\Users\\yulia\\OneDrive\\Escritorio" + nombreArchvio + ".pdf");
        Document documentoPdf = new Document();
        PdfWriter.getInstance(documentoPdf, archivo);
         documentoPdf.open();
        
         Paragraph parrafo = new Paragraph(contenidoTxt);
         parrafo.setAlignment(1);
         documentoPdf.add(parrafo);
         documentoPdf.close();
          System.out.println("Se ha creado el pdf");*/
    }
    public static void anexarContenido(String nombreArchivo, String contenido) throws IOException {
        File archivo = new File(nombreArchivo);
        try {
            PrintWriter salida = new PrintWriter(new FileWriter(archivo, true));
            salida.println(contenido);
            salida.close();
            System.out.println("Se ha anexado informacion al archivo");
        } catch (FileNotFoundException ex) {
            ex.printStackTrace(System.out);
        }

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
    
      public static void generarArchivoPdfDesdeTxt(String nombreArchvio) throws FileNotFoundException, DocumentException, IOException 
      
         {
            String linea;
	    File InFile = null;
	    FileReader fr = null;
	    BufferedReader br = null;
	    //Selecciona el archivo a convertir.
	    // Abre el archivo y crea el reader.
	    InFile = new File ("C:\\Users\\yulia\\OneDrive\\Escritorio\\" + nombreArchvio );
            
     
       
	    fr = new FileReader (InFile);
            br = new BufferedReader(fr);
	    FileOutputStream archivo = new FileOutputStream("C:\\Users\\yulia\\OneDrive\\Escritorio" + InFile.getName() + ".pdf");
	    Document documento = new Document();
	    PdfWriter.getInstance(documento, archivo);
	    documento.open();
	   
	     while((linea=br.readLine())!=null){
             documento = agregarLineaNueva(documento,linea);
    
	     fr.close();
	    //Cerramos el documento PDF.
	    documento.close();
	}
	
             
         

	
         
         
         
    
         

}
