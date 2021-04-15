
import static manejoarchvios.ManejoArchivos.crearArchivo;
import static manejoarchvios.ManejoArchivos.escrbibirArchivo;

public class Test {
    
    public static void main (String [] args)
    {
        String nombreArchivo = "prueba2.txt";
        crearArchivo(nombreArchivo);
        escrbibirArchivo("prueba2.txt", "hola mundooooooooo");
    }
    
}
