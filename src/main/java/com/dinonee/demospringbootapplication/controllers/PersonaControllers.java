package com.dinonee.demospringbootapplication.controllers;

import com.dinonee.demospringbootapplication.models.Persona;
import com.dinonee.demospringbootapplication.services.PersonaService;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URI;
import java.util.List;

@Component
@Path("/")
public class PersonaControllers {

   private final PersonaService personaService;

    public PersonaControllers(PersonaService personaService) {
        this.personaService = personaService;
        personaService.add(new Persona("elvis"));
        personaService.add(new Persona("juan"));
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/personas")
    public List<Persona> getAll(){
        return personaService.getAll();
    }

    @POST
    @Path("/personas")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addPersona(Persona persona){
        personaService.add(persona);
        return Response.created(URI.create("/personas/" + persona.getNombre()))
                .build();
    }

    @GET
    @Path("/personas/{nombre}")
    @Produces(MediaType.APPLICATION_JSON)
    public Persona find(@PathParam("nombre") String nombre){
        return personaService.find(nombre);
    }
}
