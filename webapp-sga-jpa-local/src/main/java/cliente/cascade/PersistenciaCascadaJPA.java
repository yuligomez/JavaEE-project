package cliente.cascade;

import javax.persistence.*;
import domain.Persona;
import domain.Usuario;
import org.apache.logging.log4j.*;

public class PersistenciaCascadaJPA {
    static Logger log = LogManager.getRootLogger();
    
    public static void main(String[] args) {
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("UsuarioPu");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        
        //Paso 1. Crea nuevo objeto
        //objeto en estado transitivo
        Persona persona1 = new Persona("Mirtha", "Legrand", "mlegrand@mail.com", "553543");
        
        //Crear objeto usuario (tiene dependencia con el objeto persona)
        Usuario usuario1 = new Usuario("eterna", "123", persona1);
        
        //Paso 3. persistimos el objeto usuario unicamente
        em.persist(usuario1);
        
        //Paso 4. commit transaccion
        tx.commit();
        
        //objetos en estados detached
        log.debug("objeto persistido persona:" + persona1);
        log.debug("objeto persistido usuario:" + usuario1);
        
        em.close();
        
    }
}
