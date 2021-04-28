
import java.io.IOException;
import static manejador.ManejadorArchivo.crearArchivo;
import static manejador.ManejadorArchivo.escribirArchivo;


public class TestManejador {
    
    
     public static void main (String [] args) throws IOException
    {
        String nombreArchivo = "C:\\Users\\yulia\\OneDrive\\Escritorio\\prueba2.txt";
        crearArchivo(nombreArchivo);
        escribirArchivo(nombreArchivo, "Hola soy Yuliana");
    }
    
    
}
