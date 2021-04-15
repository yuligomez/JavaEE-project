package mx.com.gm.peliculas.datos;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import mx.com.gm.peliculas.domian.Pelicula;
import mx.com.gm.peliculas.excepciones.AccesoDatosEx;
import mx.com.gm.peliculas.excepciones.EscrituraDatosEx;
import mx.com.gm.peliculas.excepciones.LecturaDatosEx;

public class AccesoDatosImpl implements IAccesoDatos {

    @Override
    public boolean existe(String nombreRecurso) throws AccesoDatosEx {
        File archivo = new File(nombreRecurso);
        return archivo.exists();
    }

    @Override
    public List<Pelicula> listarPeliculas(String nombreRecurso) throws LecturaDatosEx {
        File archivo = new File(nombreRecurso);
        List<Pelicula> peliculas = new ArrayList<>();
        try {
            BufferedReader entrada = new BufferedReader(new FileReader(archivo));
            String linea = null;
            linea = entrada.readLine();
            while (linea != null) {
                Pelicula pelicula = new Pelicula(linea);
                peliculas.add(pelicula);
                linea = entrada.readLine();
            }
            entrada.close();

        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
            throw new LecturaDatosEx("Excepeion al listar peliculas " + ex.getMessage());
        } catch (IOException ex) {
            ex.printStackTrace();
            throw new LecturaDatosEx("Excepeion al listar peliculas " + ex.getMessage());
        }
        return peliculas;
    }

    @Override
    public void escribir(Pelicula pelicula, String nombreRecuerso, boolean anexar) throws EscrituraDatosEx {
        PrintWriter salida = null;
        try {
            File archivo = new File(nombreRecuerso);
            salida = new PrintWriter(new FileWriter(archivo, anexar));
            salida.println(pelicula.toString()); //escibo en el archivo nombreRecuerso  el nombre de la pelicula 
            salida.close();
            System.out.println("Se ha escriyo infomracion al archivo>" + pelicula);
        } catch (IOException ex) {
            ex.printStackTrace();
            throw new EscrituraDatosEx("Excepeion al escrbir peliculas " + ex.getMessage());
        }
    }

    @Override
    public String buscar(String nombreRecuerso, String buscar) throws LecturaDatosEx {

        BufferedReader entrada = null;
        String resultado = null;
        try {
            File archivo = new File(nombreRecuerso);
            entrada = new BufferedReader(new FileReader(archivo));
            String linea = entrada.readLine();
            int indice = 1;
            while (linea != null) {
                if (buscar != null && buscar.equalsIgnoreCase(linea)) {
                    resultado = "Pelicula" + linea + "encontrada en el indice " + indice;
                    break;
                }
                linea = entrada.readLine();
                indice++;
            }
            entrada.close();

        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
            throw new LecturaDatosEx("Excepeion al buscar peliculas " + ex.getMessage());
        } catch (IOException ex) {
            ex.printStackTrace();
            throw new LecturaDatosEx("Excepeion al buscar peliculas " + ex.getMessage());
        }
        return resultado;

    }

    @Override
    public void crear(String nombreRecuerso) throws AccesoDatosEx {
            File archivo = new File(nombreRecuerso);
        try {
            PrintWriter salida = new PrintWriter(new FileWriter(archivo));
            salida.close();
              System.out.println("Se ha creado  el archivo");
        } catch (IOException ex) {
            ex.printStackTrace();
            throw new AccesoDatosEx("Excepeion al crear el archivo " + ex.getMessage());
        }
    }

    @Override
    public void borrar(String nombreRecuerso)  {
           File archivo = new File(nombreRecuerso);
           if (archivo.exists())
           {
               archivo.delete();
               System.out.println("Se ha borrado  el archivo");
           }
    }

}
