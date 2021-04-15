/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.gm.peliculas.datos;

import java.util.List;
import mx.com.gm.peliculas.domian.Pelicula;
import mx.com.gm.peliculas.excepciones.AccesoDatosEx;
import mx.com.gm.peliculas.excepciones.EscrituraDatosEx;
import mx.com.gm.peliculas.excepciones.LecturaDatosEx;

/**
 *
 * @author yulia
 */
public interface IAccesoDatos {
    
    boolean existe (String nombreRwcurso) throws AccesoDatosEx;
    
    List <Pelicula> listarPeliculas (String nombreRecurso) throws LecturaDatosEx;
    
    void escribir (Pelicula pelicula, String nombreRecuerso, boolean anexar) throws EscrituraDatosEx;
    
    String buscar(String nombreRecuerso, String buscar) throws LecturaDatosEx ;
    
    void crear (String nombreRecuerso) throws AccesoDatosEx;
    
    void borrar (String nombreRecuerso)  throws AccesoDatosEx;
}
