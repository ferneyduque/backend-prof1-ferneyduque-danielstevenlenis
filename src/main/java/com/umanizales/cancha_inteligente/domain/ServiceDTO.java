package com.umanizales.cancha_inteligente.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ServiceDTO {

    private String idServ;
    @NotNull
    @NotEmpty
    private String nomServ;
    private String idFactService;
}
