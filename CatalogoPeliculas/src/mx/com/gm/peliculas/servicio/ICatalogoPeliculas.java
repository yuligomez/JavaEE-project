/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.gm.peliculas.servicio;

import java.util.List;
import mx.com.gm.peliculas.domian.Pelicula;
import mx.com.gm.peliculas.excepciones.AccesoDatosEx;
import mx.com.gm.peliculas.excepciones.EscrituraDatosEx;
import mx.com.gm.peliculas.excepciones.LecturaDatosEx;

/**
 *
 * @author yulia
 */
public interface ICatalogoPeliculas {

    String NOMBRE_RECURSO = "pelicas.txt";

    void buscarPelicula(String nombrePelicula);

    void agregarPelicula(String nombrePelicula);
    
     void eliminarPelicula(String nombrePelicula);

    void listarPeliculas();

    void iniciarCatalogoPeliculas();

}
