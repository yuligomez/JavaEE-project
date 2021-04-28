
import com.itextpdf.text.DocumentException;
import java.io.IOException;
import static manejoarchvios.ManejoArchivos.anexarContenido;
import static manejoarchvios.ManejoArchivos.crearArchivo;
import static manejoarchvios.ManejoArchivos.escrbibirArchivo;
import static manejoarchvios.ManejoArchivos.generarArchivosTxt_Pdf;
import static manejoarchvios.ManejoArchivos.leerArchivo;

public class Test {
    
    public static void main (String [] args) throws IOException, DocumentException
    {
       // String nombreArchivo = "prueba2.txt";
       // crearArchivo(nombreArchivo);
        generarArchivosTxt_Pdf("pruebaOk", "hola mundooooo");
     
       // anexarContenido("prueba2.txt", "hola mundooooooooo");
       // anexarContenido("prueba2.txt", "chau mundo");
      //  leerArchivo ("prueba2.txt");
    }
    
}
