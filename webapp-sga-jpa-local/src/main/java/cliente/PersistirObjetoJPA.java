package cliente;

import domain.Usuario;
import javax.persistence.*;


public class PersistirObjetoJPA {
    
    
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("SgaPU");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        
        //Inicia la transaccion
        
        //Paso 1. Crea nuevo objeto
        //Objeto en estado transitivo
        Usuario usuario = new Usuario("Pedro", "Luna");
        
        //Paso 2. Inicia transaccion
        tx.begin();
        
        //Paso 3. Ejecuta SQL
        em.persist( usuario );
        
       
        
        //Paso 4. commit/rollback
        tx.commit();
        
        
        //Cerramos el entity manager
        em.close();
        
    }
    
}
