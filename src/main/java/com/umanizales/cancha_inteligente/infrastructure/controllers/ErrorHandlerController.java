package com.umanizales.cancha_inteligente.infrastructure.controllers;

import com.umanizales.cancha_inteligente.exceptions.CanchaInteligenteException;
import com.umanizales.cancha_inteligente.infrastructure.controllers.dto.ErroDTO;
import com.umanizales.cancha_inteligente.infrastructure.controllers.dto.ResponseDTO;
import org.hibernate.cache.CacheException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class ErrorHandlerController {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    protected ResponseEntity<?> handle(MethodArgumentNotValidException ex){
        List<ErroDTO> listErrors = new ArrayList<>();
        ex.getBindingResult().getFieldErrors().forEach((error) -> {
            String fieldName = error.getField();
            String errorMessage = error.getDefaultMessage();
            listErrors.add(new ErroDTO(HttpStatus.BAD_REQUEST.value(), fieldName +" "+ errorMessage));
        });
        String message = "Algunos campos son inválidos o faltantes, por favor corrija los errores y vuelva a intentarlo";
        ResponseDTO response = new ResponseDTO( message,null , listErrors);
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(CanchaInteligenteException.class)
    protected ResponseEntity<?> handle(CanchaInteligenteException ex)
    {
        ResponseDTO response = new ResponseDTO( ex.getMessage(),null , null);
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

}
