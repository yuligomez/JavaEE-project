
import com.itextpdf.text.DocumentException;
import java.io.IOException;
import static manejoarchvios.ManejoArchivos.crearArchivo;



public class TestManejador {
    public static void main (String [] args) throws IOException, DocumentException
    {
     
      String nombreArchivo = "Prueba";
      crearArchivo(nombreArchivo);
     
    }
}
