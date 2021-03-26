/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cliente.asociaciones;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author yulia
 */
public class ClienteAsociacionesJPA {
    
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("SgaPU");
        EntityManager em = emf.createEntityManager();
        
       // List<Persona> personas = em.createNamedQuery("Persona.findAll").getResultList();
        
        //cerramos la conexion
        em.close();
        
      /*  //Imprimir los objetos de tipo persona
        for(Persona persona : personas){
            log.debug("Persona:" + persona);
            //recuperamos los usuarios de cada persona
            for(Usuario usuario: persona.getUsuarioList()){
                log.debug("Usuario:" + usuario);
            }
        }
    }*/
}
    

}
