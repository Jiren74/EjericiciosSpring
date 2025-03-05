package com.example.Ejercicio2.service;

import com.example.Ejercicio2.entity.Persona;

import java.util.List;

public interface PersonaService {
    public List<Persona> getPersonas();
    public void addPersona(Persona persona);

    public List<Persona> getPersonasDni();
    public void addPersonaDni(Persona persona);
}
