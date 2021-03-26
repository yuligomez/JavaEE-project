/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cliente.criteria;

import domain.Persona;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author yulia
 */
public class PruebaApiCriteria {
    static Logger log = LogManager.getRootLogger();
    public static void main (String[] args){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("UsuarioPu");
        EntityManager em = emf.createEntityManager();
        
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Persona> criteriaQuery = null;
        Root<Persona> fromPersona = null;
        TypedQuery<Persona> query = null;
        Persona persona = null;
        List<Persona> personas = null;
        
        //Query utilizando el api de criteria 
        //1. Consulta de todas las personas
        
        //paso 1 :El objeto entity manager crea una instancia CriteriaBuilder
        cb= em.getCriteriaBuilder();
        
        //paso 2 : Se crea un objeto CriteriaQuery
        criteriaQuery = cb.createQuery(Persona.class);
        
        //paso 3: Creo el objeto raiz  de query
        fromPersona = criteriaQuery.from(Persona.class);
        
        //paso 4: Seleccionamos lo necesario del from
        criteriaQuery.select(fromPersona);
        
        //paso 5 : Creo el query typedSafe
        query= em.createQuery(criteriaQuery);
        
        //paso 6: Ejecuto la consulta
        personas = query.getResultList();
        mostrarPersonas(personas);
        
        
        
        //2. Consulta de la persona con id 1 
        //jpql="select p from Persona p where p.idPersona=1"
        log.debug("\n1.  Consulta de la persona con id 1 ");
        cb = em.getCriteriaBuilder();
        criteriaQuery = cb.createQuery(Persona.class);
        fromPersona = criteriaQuery.from(Persona.class);
        criteriaQuery.select(fromPersona).where(cb.equal(fromPersona.get("idPersona"), 1));
        persona = em.createQuery(criteriaQuery).getSingleResult();
        log.debug(persona);
        
        
        //3. Consulta de la persona con id 1 con parameter y criterio
        log.debug("\n1.  Consulta de la persona con id 1 con parameter y criterio ");
        cb = em.getCriteriaBuilder();
        criteriaQuery = cb.createQuery(Persona.class);
        fromPersona = criteriaQuery.from(Persona.class);
     
        
        //La calse Predicate nos permite agregar varios criterios dinamicamente 
        List <Predicate> criterios = new ArrayList<Predicate>();
        
        //Verificamos si tenemos criterios que agregar
        Integer idPersonParam =1;
        ParameterExpression<Integer> parameter = cb.parameter(Integer.class, "idPersona");
        criterios.add(cb.equal(fromPersona.get("idPersona"), parameter));
        
        
        //Se agregan los criterios
        if(criterios.isEmpty()){
            throw new RuntimeException("sin criterios");
        }else if (criterios.size()==1){
            criteriaQuery.where(criterios.get(0));
        }
        else{
            criteriaQuery.where(cb.and(criterios.toArray(new Predicate[0]))); // concateno criterios con el operador and
        }
        
        query = em.createQuery(criteriaQuery);
        query.setParameter("idPersona", idPersonParam);
        // ejecuto el query
        persona = query.getSingleResult();
        log.debug(persona);
        
    }
    
    public static void mostrarPersonas (List<Persona> personas){
        for(Persona p:personas){
            log.debug(p);
        }
    }
}
