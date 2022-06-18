package com.dinonee.demospringbootapplication.services;

import com.dinonee.demospringbootapplication.models.Persona;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonaService {

    private List<Persona> personas = new ArrayList<>();

    public List<Persona> getAll(){

        return this.personas;
    }

    public void add(Persona persona){
        personas.add(persona);
    }

    public Persona find(String nombre){
        return personas.stream()
                .filter(n -> n.getNombre().compareToIgnoreCase(nombre) ==0 )
                .findFirst()
                .orElse(null);
    }
}
