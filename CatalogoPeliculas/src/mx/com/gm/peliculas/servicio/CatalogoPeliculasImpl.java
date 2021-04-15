package mx.com.gm.peliculas.servicio;

import java.util.List;
import mx.com.gm.peliculas.datos.AccesoDatosImpl;
import mx.com.gm.peliculas.datos.IAccesoDatos;
import mx.com.gm.peliculas.domian.Pelicula;
import mx.com.gm.peliculas.excepciones.AccesoDatosEx;


public class CatalogoPeliculasImpl implements ICatalogoPeliculas {

    private final IAccesoDatos datos;

    public CatalogoPeliculasImpl() {
        this.datos = new AccesoDatosImpl();
    }

    @Override
    public void buscarPelicula(String nombrePelicula) {
        String resultado = null;
        try {
            this.datos.buscar(NOMBRE_RECURSO, nombrePelicula);
            System.out.println("resultado" + resultado);
        } catch (AccesoDatosEx ex) {
            System.out.println("error de acceso a datos en el metodo buscar pelicula");
            ex.printStackTrace(System.out);
        }

    }

    @Override
    public void agregarPelicula(String nombrePelicula) {
        Pelicula pelicula = new Pelicula(nombrePelicula);
        boolean anexar = false;
        try {
            anexar = datos.existe(NOMBRE_RECURSO);
            this.datos.escribir(pelicula, NOMBRE_RECURSO, anexar);

        } catch (AccesoDatosEx ex) {
            System.out.println("error de acceso a datos");
            ex.printStackTrace(System.out);
        }
    }

    @Override
    public void eliminarPelicula(String nombrePelicula) {

    }

    @Override
    public void listarPeliculas() {
        try {
            List<Pelicula> peliculas = this.datos.listarPeliculas(NOMBRE_RECURSO);
            for (Pelicula pelicula : peliculas) {
                System.out.println("peliculas" + pelicula);
            }
        } catch (AccesoDatosEx ex) {
            System.out.println("error de acceso a datos");
            ex.printStackTrace(System.out);
        }
    }

    @Override
    public void iniciarCatalogoPeliculas() {
        try {
            if (this.datos.existe(NOMBRE_RECURSO)) {
                datos.borrar(NOMBRE_RECURSO);
                datos.crear(NOMBRE_RECURSO);

            } else {
                datos.crear(NOMBRE_RECURSO);
            }

        } catch (AccesoDatosEx ex) {
            System.out.println("error de acceso a datos");
            ex.printStackTrace(System.out);
        }
    }

}
