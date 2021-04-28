
package manejador;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.PrintWriter;



public class ManejadorArchivo {
    
        public static void crearArchivo (String nombreArchivo){
        File archivo = new File(nombreArchivo); //creo un objeto de tipo file en memoria
        
        try {
            //para que se guarde en el disco duro
            
            // abro el archivo
            PrintWriter salida = new PrintWriter(archivo);
            
            //creo el archivo en el disco duro
            salida.close();
            System.out.println("Se ha creado el archivo");
            
        } catch (FileNotFoundException ex) {
           ex.printStackTrace(System.out);
        }
    }
        
        public static void escribirArchivo(String nombreArchivo, String contenido)
        {
             File archivo = new File(nombreArchivo); //creo un objeto de tipo file en memoria
        
        try {
            //para que se guarde en el disco duro
            
            // abro el archivo
            PrintWriter salida = new PrintWriter(archivo);
            
            
            //escribo informacion en el archivo
            
            salida.println(contenido);
            System.out.println("Se ha escrito el archivo");
            
            //creo el archivo en el disco duro
            salida.close();
            System.out.println("Se ha creado el archivo");
            
        } catch (FileNotFoundException ex) {
           ex.printStackTrace(System.out);
        }
      }
        
       public static void convertirTxtAPdf (String nombreArchivo, String contenido)
       {
           String linea;
           File inFile = null;
           FileReader fr = null;
           BufferedReader br = null;
           
           
           
            try {
                //abro el archivo a convertir y creo el reader
                inFile = new File (nombreArchivo);
                fr =  new FileReader (nombreArchivo);
                br = new BufferedReader (fr);
                
                //creo el documento de salida
                FileOutputStream archivo = new FileOutputStream ("C:\\Users\\yulia\\OneDrive\\Escritorio" + inFile.getName() + ".pdf");
                Document documentoPdf =new Document();
                PdfWriter.getInstance(documentoPdf,archivo );
                
                
            } catch (FileNotFoundException ex) {
                 ex.printStackTrace(System.out);
            }
       }
       
}
           
           
           
           
           
           
           
           
           
           
           
           
           
           
           
           
       
       }
        
}
+
