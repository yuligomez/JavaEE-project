/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cliente;

import domain.Usuario;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import org.apache.logging.log4j.LogManager;


/**
 *
 * @author yulia
 */
public class EliminarObjetoJPA {
   
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("SgaPU");
        EntityManager em = emf.createEntityManager();

        //Inicia la transaccion
        //Paso 1. Iniciar una transaccion
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        
        //Paso 2. Ejecuta SQL de tipo select
        Usuario usuario = em.find(Usuario.class, 5);
        
        //Paso 3. termina transaccion 1
        tx.commit();
        
        //objeto en estado detached
        System.out.println("Objeto encontrado :" + usuario);
       
        //Paso 4. Inicia transaccion 2
        EntityTransaction tx2 = em.getTransaction();
        tx2.begin();
        
        //Paso 5. Ejecuta SQL que es un delete
        em.remove( em.merge(usuario));

        //Paso 6. termina transaccion 2
        tx2.commit();
        
        //objeto en estado detached ya eliminado
        System.out.println("Objeto eliminado :" + usuario);
       
        
        //Cerramos el entity manager
        em.close();

    }
    
}
