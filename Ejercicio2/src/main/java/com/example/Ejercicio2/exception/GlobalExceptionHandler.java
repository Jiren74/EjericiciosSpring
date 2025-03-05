package com.example.Ejercicio2.exception;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    //Lógica para manejar excepciones en las peticiones
    @ExceptionHandler(ExceptionPersona.class)
        public ResponseEntity<?> handleExceptionPersona(ExceptionPersona excepcion, HttpServletRequest request){
        String metodoHttp = request.getMethod();
        if("GET".equalsIgnoreCase(metodoHttp)){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuario no econtrado");
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(excepcion.getMessage());
            //return ResponseEntity.status(HttpStatus.CREATED).body(excepcion.getMessage());
        }

}
