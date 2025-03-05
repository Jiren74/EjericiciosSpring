package com.example.Ejercicio2.exception;

//Excepción personalizada para captar las excepciones al crear una persona
public class ExceptionPersona extends RuntimeException{
    public ExceptionPersona(String mensaje){
        super(mensaje);
    }
}
