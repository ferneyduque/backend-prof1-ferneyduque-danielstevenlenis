package com.umanizales.cancha_inteligente.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClientDTO {

    private String idCli;
    @NotNull
    @Size (min = 10, max = 50)
    private String nombreCli;
    @NotNull
    @NotEmpty
    @Size (min = 2, max = 10)
    private String tarjetaCli;


}
