package com.example.Ejercicio2.entity;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

import java.time.LocalDate;

public class Persona {

    @NotBlank(message = "El dni no puede estar vacío")
    private String dni;
    @NotBlank(message = "El nombre no puede estar vacío")
    private String nombre;
    @NotBlank(message = "El primer apellido no puede estar vacío")
    private String primerApellido;
    @NotBlank(message = "El segundo apellido no puede estar vacío")
    private String segundoApellido;

    private String nombreCompleto;
    @NotNull(message = "La fecha de nacimiento no puede estar vacía")
    private LocalDate fechaNacimiento;
    @NotBlank(message = "El sexo no puede estar vacío")
    @Pattern(regexp = "Masculino|Femenino", message = "El sexo debe ser 'Masculino' o 'Femenino'")
    private String sexo;

    public Persona() {}
    public Persona(String nombre, String primerApellido, String segundoApellido, LocalDate fechaNacimiento, String sexo) {
        this.nombre = nombre;
        this.primerApellido = primerApellido;
        this.segundoApellido = segundoApellido;
        //this.nombreCompleto = nombre+" "+primerApellido+" "+segundoApellido;
        this.fechaNacimiento = fechaNacimiento;
        this.sexo = sexo;
    }

    public Persona(String dni, String nombre, String primerApellido, String segundoApellido, LocalDate fechaNacimiento, String sexo) {
        this.dni = dni;
        this.nombre = nombre;
        this.primerApellido = primerApellido;
        this.segundoApellido = segundoApellido;
        //this.nombreCompleto = nombre+" "+primerApellido+" "+segundoApellido;
        this.fechaNacimiento = fechaNacimiento;
        this.sexo = sexo;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPrimerApellido() {
        return primerApellido;
    }

    public void setPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
    }

    public String getSegundoApellido() {
        return segundoApellido;
    }

    public void setSegundoApellido(String segundoApellido) {
        this.segundoApellido = segundoApellido;
    }

    public String getNombreCompleto() {
        return this.nombre+" "+this.primerApellido+" "+this.segundoApellido;
    }


    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }
}
