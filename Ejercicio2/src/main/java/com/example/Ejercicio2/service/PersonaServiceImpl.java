package com.example.Ejercicio2.service;

import com.example.Ejercicio2.entity.Persona;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class PersonaServiceImpl implements PersonaService{
    List<Persona> personas = new ArrayList<>(Arrays.asList(
            new Persona( "Pepe", "García", "Flores", LocalDate.of(1990, 5, 15),
                    "Masculino"),
            new Persona( "Jose", "Rodriguez", "Mendez", LocalDate.of(1997, 9, 15),
                    "Masculino"),
            new Persona( "María", "Castaño", "Dominguez", LocalDate.of(1999, 1, 14),
                    "Masculino"),
            new Persona( "Luis", "García", "Hernandez", LocalDate.of(1990, 5, 15),
                    "Masculino")
    ));

    List<Persona> personas2 = new ArrayList<>(Arrays.asList(
            new Persona( "00123456W","Pepe", "García", "Flores", LocalDate.of(1990, 5, 15),
                    "Masculino"),
            new Persona( "00123457W","Jose", "Rodriguez", "Mendez", LocalDate.of(1997, 9, 15),
                    "Masculino"),
            new Persona( "00123458W","María", "Castaño", "Dominguez", LocalDate.of(1999, 1, 14),
                    "Masculino"),
            new Persona( "00123459W","Luis", "García", "Hernandez", LocalDate.of(1990, 5, 15),
                    "Masculino"),
            new Persona( "00123451W","Pepe", "García", "Flores", LocalDate.of(1990, 5, 15),
                    "Masculino"),
            new Persona( "00123450W","Jose", "Rodriguez", "Mendez", LocalDate.of(1997, 9, 15),
                    "Masculino"),
            new Persona( "00123452W","María", "Castaño", "Dominguez", LocalDate.of(1999, 1, 14),
                    "Masculino"),
            new Persona( "00123453W","Luis", "García", "Hernandez", LocalDate.of(1990, 5, 15),
                    "Masculino"),
            new Persona( "00123454W","María", "Castaño", "Dominguez", LocalDate.of(1999, 1, 14),
                    "Masculino"),
            new Persona( "00123455W","Luis", "García", "Hernandez", LocalDate.of(1990, 5, 15),
                    "Masculino")
    ));

    //Función para obtener el listado de las personas del ejercicio 1
    @Override
    public List<Persona> getPersonas(){
        return personas;
    }
    //Función para añadir personas del ejercicio 2
    @Override
    public void addPersona(Persona persona){
        personas.add(persona);
    }

    //Función para obtener el listado de las personas del ejercicio 2 Y 3
    @Override
    public List<Persona> getPersonasDni(){
        return personas2;
    }
    //Función para modificar el listado de las personas del ejercicio 2
    @Override
    public void addPersonaDni(Persona persona){
        personas2.add(persona);
    }
}
