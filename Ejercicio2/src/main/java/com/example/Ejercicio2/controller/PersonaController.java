package com.example.Ejercicio2.controller;

import com.example.Ejercicio2.entity.Persona;
import com.example.Ejercicio2.exception.ExceptionPersona;
import com.example.Ejercicio2.service.PersonaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.List;

@RestController
@RequestMapping("/personas1")
public class PersonaController {


    //Instancia de clase
    @Autowired
    private PersonaService personaService;

    //Ejercicio 1: Servicio REST de tipo GET
    @GetMapping
    public ResponseEntity<?> getPersonas(){
        List<Persona> personas = personaService.getPersonas();
        return ResponseEntity.ok(personas);
    }



    //Ejercicio 2: Servcio REST de tipo POST
    @PostMapping("/personas2/envioFormulario")
    public ResponseEntity<?> postCliente(@Valid @RequestParam String nombre,
                                 @Valid @RequestParam String apellido1,
                                 @Valid @RequestParam String apellido2,
                                 @Valid @RequestParam String fechaNacimiento,
                                 @Valid @RequestParam String sexo) {
        // Verificar si hay errores de validación

        try {
            //Ningun valor tiene que esta vacío
            if (nombre.isBlank() || apellido1.isBlank() || apellido2.isBlank() || sexo.isBlank()) {
                throw new ExceptionPersona("Los campos no pueden estar vacíos");

            }
            //Comprobar si el sexo es masculino o femenino
            if (!sexo.equalsIgnoreCase("Masculino") && !sexo.equalsIgnoreCase("Femenino")) {
                throw new ExceptionPersona("Sexo debe ser Masculino o Femenino");
            }
            //Comprobar que la fecha sea correcta
            LocalDate fecha = LocalDate.parse(fechaNacimiento);
            if (fecha.isAfter(LocalDate.now())) {
                throw new ExceptionPersona("La fecha de nacimiento debe ser pasada");
            }

            //Creación de la nueva persona
            Persona persona = new Persona(nombre, apellido1, apellido2, fecha, sexo);
            personaService.addPersona(persona);
            return ResponseEntity.status(HttpStatus.CREATED).body("Persona creada exitosamente "+persona.getNombreCompleto());
        } catch (DateTimeParseException e) {
            //En caso de algun dato invalido en la fecha, se recoje una excepción personalizada
            throw new ExceptionPersona("Formato de fecha inválido. Use yyyy-MM-dd");
        } catch (Exception e) {
            //En caso de algun dato invalido, se recoje una excepción personalizada
            throw new ExceptionPersona("Datos inválidos: " + e.getMessage());
        }
    }


    @GetMapping("/personas2")
    public ResponseEntity<?> getPersonas2(){
        List<Persona> personasDni = personaService.getPersonasDni();
        return ResponseEntity.ok(personasDni);
    }

    //Obtener el dato de una persona con un DNI en específico
    @GetMapping("personas2/{dni}")
    public ResponseEntity<?> getPersonas2(@Valid @PathVariable String dni){

        try{
            //Iterar hasta encontrar a la persona
            for(Persona p: personaService.getPersonasDni()){
                if(p.getDni().equalsIgnoreCase(dni)){
                    return ResponseEntity.ok(p);
                }
            }
            //Si no lo encuentra se responde un 404 de no encontrado
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Persona no encontrado con username: " + dni);
        }catch (Exception e){
            //Cualquier dato inválido se recoje en una excepcion personalidad
            throw new ExceptionPersona("Datos inválidos" + e.getMessage());
        }


    }

    //Sobrescribir los datos de la persona encontrada
    @PutMapping("personas2/personas3put")
    public ResponseEntity<?>putPersonas2(@RequestBody Persona personaDni){

        try{
            //Iterar hasta encontrar la persona con el dni y modificar los datos
            for (Persona p: personaService.getPersonasDni()){
                if(p.getDni().equalsIgnoreCase(personaDni.getDni())){
                    p.setDni(personaDni.getDni());
                    p.setNombre(personaDni.getNombre());
                    p.setPrimerApellido(personaDni.getPrimerApellido());
                    p.setSegundoApellido(personaDni.getSegundoApellido());
                    p.setFechaNacimiento(personaDni.getFechaNacimiento());
                    p.setSexo(personaDni.getSexo());

                    return ResponseEntity.ok("Persona modificado correctamente: "+personaDni.getNombreCompleto());
                }
            }
            //Si no lo encuentra se responde un 404 de no encontrado
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Persona no encontrada: "+personaDni.getNombre());
        }catch (Exception e){
            //Cualquier dato inválido se recoje en una excepcion personalidad
            throw new ExceptionPersona("Datos inválidos" + e.getMessage());
        }



    }



}
