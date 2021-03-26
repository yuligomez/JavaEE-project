/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cliente;

import domain.Usuario;
import java.util.logging.LogManager;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import org.apache.logging.log4j.*;

public class EncontrarObjetoJPA {
    //static Logger log = LogManager.getRootLogger();
    
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("SgaPU");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        
        //Inicia la transaccion
         tx.begin();
         
        //Paso 2 sql de tipo select 
        //Objeto en estado transitivo
        Usuario usuario1 = em.find(Usuario.class, 1);
        
       
        
       // log.debug("Objeto recuperado :" + usuario1)
        
        tx.commit();
        
  
        //Cerramos el entity manager
        em.close();
        
        System.out.println("Objeto recuperado :" + usuario1);
        
    }
}
