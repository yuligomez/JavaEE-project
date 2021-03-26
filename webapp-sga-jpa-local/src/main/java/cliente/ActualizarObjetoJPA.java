/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cliente;

import domain.Usuario;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 *
 * @author yulia
 */
public class ActualizarObjetoJPA {
     public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("SgaPU");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        
        //Inicia la transaccion
         tx.begin();
         
        //Paso 2 sql de tipo select para encontrar el objeto que queremos actualizar 
        //Objeto en estado de deteach
        Usuario usuario1 = em.find(Usuario.class, 1);
        tx.commit();
        System.out.println("Objeto recuperado en estado de deteach :" + usuario1);

        
        
        
        //paso 3 modifico un campo del objeto 
        usuario1.setPassword("elbolsonomas");
        //Cerramos el entity manager
        
        
        
        
        //paso 4 inicia transaccion 2 para cargar el user modificado
        EntityTransaction tx2 = em.getTransaction();
        tx2.begin();
        
        
        
       //paso 5 modificamos el objeto en la base de datos
        em.merge(usuario1);
        
        // para que se guarden los cambios en este momento  em.flush(); o commit
       
        
     
        tx2.commit();
        System.out.println("Objeto modificado :" + usuario1);
        
        //cierro em 
        em.close();
        
        
        
    }
}
