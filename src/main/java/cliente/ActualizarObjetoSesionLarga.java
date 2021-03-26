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


public class ActualizarObjetoSesionLarga {
     public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("SgaPU");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        
        //ejecuto SQL select para recuperar un objeto con id 2
        Usuario usuario= em.find(Usuario.class, 2);
        System.out.println("Objeto recuperado :" + usuario);
        
        //cambio el valor que quiero del usuario que recuper'e
        usuario.setUsername("plopez");
        usuario.setUsername("lunalunera");
        
        
        // no hago merge , porque dentro de la transaccion modifico los datos de usuario y no es necesario
        tx.commit();
        
        //Objeto en estado de detached
        System.out.println("Objeto modificado :" + usuario);
        
        //cierro entity manager
        em.close();
        
     }  
   
}
