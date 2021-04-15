
package mx.com.gm.peliculas.domian;

import java.io.Serializable;


public class Pelicula{
    
    private String nombre;
    
    public Pelicula() {
        
    }

    @Override
    public String toString() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public Pelicula(String nombre) {
        this.nombre = nombre;
    }
    
}
