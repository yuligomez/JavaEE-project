
import java.io.IOException;
import static manejoarchvios.ManejoArchivos.anexarContenido;
import static manejoarchvios.ManejoArchivos.crearArchivo;
import static manejoarchvios.ManejoArchivos.escrbibirArchivo;

public class Test {
    
    public static void main (String [] args) throws IOException
    {
        String nombreArchivo = "prueba2.txt";
        crearArchivo(nombreArchivo);
        anexarContenido("prueba2.txt", "hola mundooooooooo");
        anexarContenido("prueba2.txt", "chau mundo");
    }
    
}
