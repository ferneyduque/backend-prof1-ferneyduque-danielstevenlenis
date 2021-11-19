package com.umanizales.cancha_inteligente.infrastructure.controllers.dto;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor

public class ErroDTO {

    private int code;
    private String message;

}
