package cliente.jpql;

import java.util.Iterator;
import java.util.List;
import javax.persistence.*;
import domain.Persona;
import domain.Usuario;
import org.apache.logging.log4j.*;

public class PruebaJPQL {
    
    static Logger log = LogManager.getRootLogger();
    
    public static void main(String[] args) {
        String jpql = null;
        Query q = null;
        List<Persona> personas = null;
        Persona persona = null;
        Iterator iter = null;
        Object[] tupla = null;
        List<String> nombres = null;
        List<Usuario> usuarios = null;
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("UsuarioPu");
        EntityManager em = emf.createEntityManager();
        
        //1. Consulta de todos los objetos de tipo Persona
        log.debug("\n1. Consulta de todas las Personas");
        jpql = "select p from Persona p";
        personas = em.createQuery(jpql).getResultList();
        mostrarPersonas( personas );
        
        
          //2. Consulta objeto filtrando por id
        log.debug("\n1. Consulta persona con id igual 1");
        jpql = "select p from Persona p where p.idPersona= 1";
        persona = (Persona) em.createQuery(jpql).getSingleResult();
         log.debug(persona);
        
        //3. Consulta objeto filtrando por nombre
        log.debug("\n1. Consulta persona cuyo nombre es Valentina");
        jpql = "select p from Persona p where p.nombre= 'Valentina'";
        personas =  em.createQuery(jpql).getResultList();
        mostrarPersonas( personas );
        
        
        //4. Consulta de datos indiviudales , se crea un arreglo tupla de tipo object de 3 columnas 
        log.debug("\n Consulta de datos indiviudales , se crea un arreglo tupla de tipo object de 3 columnas ");
        jpql= "select p.nombre as Nombre , p.apellido as Apellido, p.email as Email from Persona p";
        iter = em.createQuery(jpql).getResultList().iterator();
        while (iter.hasNext()){
            tupla = (Object[]) iter.next();
            String nombre = (String) tupla[0];
            String apellido = (String) tupla [1];
            String email = (String) tupla[2];
             log.debug("nombres: " +nombre + ",apellido: " + apellido + ",email: "+ email);
    
        }
        
        //5. obtengo el objeto persona y el id, se crea im arreg;p de tipo object con dos columas 
        log.debug("\n obtengo el objeto persona y el id, se crea im arreg;p de tipo object con dos columas");
        jpql= "select p, p.idPersona from Persona p";
        iter = em.createQuery(jpql).getResultList().iterator();
        while (iter.hasNext()){
            tupla = (Object[]) iter.next();
            persona = (Persona) tupla[0];
            int idPersona = (int) tupla [1];
            log.debug("\nobjeto persona:" + persona );
            log.debug("\n id :" + idPersona );
        }
        
        /* Esta no me funciona 
        // 6 consulta de todas las personas
        log.debug("\n inicia consulta 6");
        jpql= "select new domian.Persona ( p.idPersona ) from Persona p";
        personas = em.createQuery(jpql).getResultList();
        mostrarPersonas(personas);
        
       */
        
        //7. Regresa el valor minimmo y maximo del idPersona y contabilizo cuantas personas tengo en la tabla
        log.debug("\n  Regresa el valor minimmo y maximo del idPersona ");
        jpql = "select min(p.idPersona) as MinId, max(p.idPersona) as MaxId, count(p.idPersona) as Contador from Persona p";
        iter = em.createQuery(jpql).getResultList().iterator();
        while (iter.hasNext()){
            tupla = (Object[]) iter.next();
            Integer min = (Integer) tupla[0];
            Integer max = (Integer) tupla[1];
            Long cantidad= (Long) tupla[2];
            log.debug("\n IdMin " + min);
            log.debug("\n IdMax " + max);
            log.debug("\n  Conunt "+ cantidad);
                
        }
        //8. Cuenta los nombres de las personas que son distintos 
        log.debug("\n  Cuenta los nombres de las personas que son distintos  ");
        jpql = "select count(distinct p.nombre) from Persona p";
        Long count = (Long) em.createQuery(jpql).getSingleResult();
        log.debug("\n Numero de personas con nombre distintos  " + count);
        
        
        //9. Concatena y convierte a mayuscula el nombre y apellido
        log.debug("\n  Concatena y convierte a mayuscula el nombre y apellido");
        jpql = "select CONCAT(p.nombre, ' ', p.apellido) as Nombre from Persona p";
        nombres = em.createQuery(jpql).getResultList();
        for(String nombreCompleto :nombres){
            log.debug(nombreCompleto);
        }
        
        //10. Obtiene persona con id igual a 5
        log.debug("\n  Obtiene persona con id igual a 5");
        int id = 5;
        jpql = "select p from Persona p where p.idPersona= :id";
        q= em.createQuery(jpql);
        q.setParameter("id", id);
        persona = (Persona) q.getSingleResult();
        log.debug("Persona con id 5:" + persona);
        
        //11. Obtiene personas que contentgan letra a en el nombre , sin importar si es mayusucla o min
        log.debug("\n   Obtiene personas que contentgan letra a en el nombre , sin importar si es mayusucla o min");
        jpql = "select p from Persona p where upper(p.nombre) like upper(:parametro)";
        q = em.createQuery(jpql);
        String parametroString ="%a%";
        q.setParameter("parametro", parametroString);
        personas = q.getResultList();
        mostrarPersonas(personas);
        
        //12. Between
        log.debug("\n   Uso de between");
        jpql = "select p from Persona p where p.idPersona between 1 and 5";
        personas = em.createQuery(jpql).getResultList();
        mostrarPersonas(personas);
        
        
        //13. Ordenamiento
        log.debug("\n   Uso de ordenamiento");
        jpql = "select p from Persona p where p.idPersona >3 order by p.nombre desc, p.apellido desc";
        personas = em.createQuery(jpql).getResultList();
        mostrarPersonas(personas);
        
            
        //14 .Uso de subquerys  , selecciono la persona que tenga id minimo 
        log.debug("\n  Uso de subquerys ");
        jpql = "select p from Persona p where p.idPersona in (select min(p1.idPersona) from Persona p1)";
        personas = em.createQuery(jpql).getResultList();
        mostrarPersonas(personas);
        
        //15.Uso de join con lazyloading
        log.debug("\n  Uso de join con lazyloading ");
        jpql = "select u from Usuario u join u.persona p";
        usuarios =  em.createQuery(jpql).getResultList();
        mostrarUsuarios(usuarios);
        
        //16.Uso de left join con eager loading
        log.debug("\n Uso de left join con eager loading ");
        jpql = "select u from Usuario u left join fetch u.persona p";
        usuarios =  em.createQuery(jpql).getResultList();
        mostrarUsuarios(usuarios);
      
    }

    private static void mostrarPersonas(List<Persona> personas) {
        for(Persona p: personas){
            log.debug(p);
        }
    }
    
    private static void mostrarUsuarios (List<Usuario> usuarios){
        for (Usuario u:usuarios){
              log.debug(u);
        }
    }
    
}
