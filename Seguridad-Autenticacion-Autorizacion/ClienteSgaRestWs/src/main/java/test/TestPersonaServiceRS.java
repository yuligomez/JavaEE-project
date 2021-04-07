/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import domain.Persona;
import java.util.List;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.client.authentication.HttpAuthenticationFeature;

public class TestPersonaServiceRS {
    //variables que voy a utilizar 
    private static final String URL_BASE = "http://localhost:8080/sga-jee-web/webservice";
    private static Client cliente;
    private static WebTarget webTarget;
    private static Persona persona;
    private static List<Persona> personas;
    private static Invocation.Builder invocationBuilder;
    private static Response response;
    
    public static void main (String [] args )
    {
        HttpAuthenticationFeature feature = HttpAuthenticationFeature.basicBuilder().nonPreemptive().credentials("admin", "admin").build();

        ClientConfig clientConfig = new ClientConfig();
        clientConfig.register(feature);

        cliente = ClientBuilder.newClient(clientConfig);

         
         //Leer una persona (metodo get)
        webTarget = cliente.target(URL_BASE).path("/personas");
        
         //Proporcionamos un idPersona valido
        persona = webTarget.path("/1").request(MediaType.APPLICATION_XML).get(Persona.class);
        System.out.println("Persona recuperada:" + persona);
        
        
        
        //Leer todas las personas (metodo get con readEntity de tipo List<>
        personas = webTarget.request(MediaType.APPLICATION_XML).get(Response.class).readEntity(new GenericType<List<Persona>>(){});
        System.out.println("\nPersonas recuperadas");
        imprimirPersonas(personas);
        
        
         //Agregar una persona (metodo post)
        Persona nuevaPersona = new Persona();
        nuevaPersona.setNombre("Lolita");
        nuevaPersona.setApellido("Miranda");
        nuevaPersona.setEmail("lmiranda3@mail.com");
        nuevaPersona.setTeleofono("99887700");
        
        invocationBuilder = webTarget.request(MediaType.APPLICATION_XML);
        response = invocationBuilder.post(Entity.entity(nuevaPersona, MediaType.APPLICATION_XML));
        System.out.println("");
        System.out.println(response.getStatus());
        //Recuperamos la personas recien agregada para despues modificarla y al final eliminarla
        Persona personaRecuperada = response.readEntity(Persona.class);
        System.out.println("Persona agregada:" + personaRecuperada);
        
       
        //Modificar la persona (metodo put)
        //persona recuperada anteriormente
        Persona personaModificar = personaRecuperada;
        personaModificar.setApellido("Icardi");
        String pathId = "/" + personaModificar.getIdPersona();
        invocationBuilder = webTarget.path(pathId).request(MediaType.APPLICATION_XML);
        response = invocationBuilder.put(Entity.entity(personaModificar, MediaType.APPLICATION_XML));
        
        System.out.println("");
        System.out.println("response:" + response.getStatus());
        System.out.println("Persona modifica:" + response.readEntity(Persona.class));
        
        
        //eliminar una persona
        //persona recuperada anteriormente
        Persona personaEliminar = personaRecuperada;
        String pathEliminarId = "/" + personaEliminar.getIdPersona();
        invocationBuilder = webTarget.path(pathEliminarId).request(MediaType.APPLICATION_XML);
        response = invocationBuilder.delete();
        System.out.println("");
        System.out.println("response:" + response.getStatus());
        System.out.println("Persona Eliminada" + personaEliminar);
        
    }
    
    public static void imprimirPersonas (List<Persona> personas)
    {
        for (Persona p:personas)
        {
            System.out.println("Persona:" + p);
        }
    }
}
