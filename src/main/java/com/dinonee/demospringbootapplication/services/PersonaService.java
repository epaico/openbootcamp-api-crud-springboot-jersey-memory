package com.dinonee.demospringbootapplication.services;

import com.dinonee.demospringbootapplication.models.Persona;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase Servicio para Personas
 * @author epaic
 */
@Service
public class PersonaService {

    private List<Persona> personas = new ArrayList<>();

    /**
     * Metodo que obtiene todos los registros
     * @return Lista tipo Persona
     */
    public List<Persona> getAll(){

        return this.personas;
    }

    /**
     * Metodo que agrega una Persona
     * @param persona Objeto tipo Persona
     */
    public void add(Persona persona){
        personas.add(persona);
    }

    /**
     * Metodo que busca una Persona por su nombre
     * @param nombre Objeto tipo String
     * @return Ojeto tipo Persona
     */
    public Persona find(String nombre){
        return personas.stream()
                .filter(n -> n.getNombre().compareToIgnoreCase(nombre) ==0 )
                .findFirst()
                .orElse(null);
    }
}
