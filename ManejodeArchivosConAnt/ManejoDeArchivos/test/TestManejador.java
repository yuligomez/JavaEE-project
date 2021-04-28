
import com.itextpdf.text.DocumentException;
import java.io.IOException;
import static manejoarchvios.ManejoArchivos.crearArchivo;
import static manejoarchvios.ManejoArchivos.generar;
import static manejoarchvios.ManejoArchivos.generarArchivoPdf;
import static manejoarchvios.ManejoArchivos.generarArchivosTxt_Pdf;
import static manejoarchvios.ManejoArchivos.generarArchivoPdfDesdeTxt;


public class TestManejador {
    public static void main (String [] args) throws IOException, DocumentException
    {
     
   //   crearArchivo(nombreArchivo);
     //  generarArchivoPdf("ok", "hola mundo");
     //generarArchivoPdfDesdeTxt(nombreArchivo);
      // 
      
        
       /* String nombreArchivo = "pruebaOk.txt";
        crearArchivo(nombreArchivo);
 
        ) ;*/
       
        String nombreArchivo = "okay";
        generar( nombreArchivo);
    }
}
