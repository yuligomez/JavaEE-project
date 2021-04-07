/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.gm.sga.servicio;

import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import mx.com.gm.sga.domain.Persona;

//http://localhost:8080/sga-jee-web/webservice/application.wadl

@Path("/personas")
@Stateless
public class PersonaServicesRS {

    @Inject
    PersonaService personaService;

    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON}) // se puede producir respuesta de datos al cliente tanto en formato xml como json
    public List<Persona> listarPersonas() {
        return personaService.listarPersonas();
    }

    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON}) // se puede producir respuesta de datos al cliente tanto en formato xml como json
    @Path("{id}")//hace referencia a /personas/{id}
    public Persona encontrarPersonaPorId(@PathParam("id") int id) {
        return personaService.encontrarPersonaPorId(new Persona(id));
    }

    @POST
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON}) //consume tanto xml como json
    public Response agregarPersona(Persona persona) {
        try {
            personaService.registrarPersona(persona);
            return Response.ok().entity(persona).build();
        } catch (Exception e) {
            e.printStackTrace(System.out);
            return Response.status(Status.INTERNAL_SERVER_ERROR).build();

        }
    }

    @PUT
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON}) //consume tanto xml como json
    @Path("{id}")
    public Response modificarPersona(@PathParam("id") int id, Persona personaModificada) {
        try {
            Persona persona = personaService.encontrarPersonaPorId(new Persona(id));
            if (persona != null) {
                personaService.modificarPersona(personaModificada);
                return Response.ok().entity(personaModificada).build();
            } else {
                return Response.status(Status.NOT_FOUND).build();
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
            return Response.status(Status.INTERNAL_SERVER_ERROR).build();
        }

    }

    @DELETE
    @Path("{id}")
    public Response eliminarPersonaPorId(@PathParam("id") int id) {
        try {
            personaService.eliminarPersona(new Persona(id));
            return Response.ok().build();

        } catch (Exception e) {
            e.printStackTrace(System.out);
            return Response.status(404).build();
        }
    }

}
