/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testclientews;

import clientews.servicio.Persona;
import clientews.servicio.PersonaServiceImplService;
import clientews.servicio.PersonaServiceWs;
import java.util.List;

public class testPersonaServiceWs {
    
    public static void main (String [] args)
    {
        //instancio objeto de tipo persona service impl port para poder acceder al web service 
        PersonaServiceWs personaService = new PersonaServiceImplService().getPersonaServiceImplPort();
        
        System.out.println("Ejecutando servicio listar personas ws ");
        List <Persona> personas =  personaService.listarPersonas();
        for  (Persona persona : personas) 
        {
            System.out.println("Personaid: " + persona.getIdPersona() + " ,Nombre:" + persona.getNombre() + " ,Apellido:" + persona.getApellido());
        }
        System.out.println("Fin de servicio listar personas ws "); 
        
    }
    
}
