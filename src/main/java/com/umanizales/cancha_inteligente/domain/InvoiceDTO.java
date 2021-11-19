package com.umanizales.cancha_inteligente.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class InvoiceDTO {

    private String idFact;
    @NotNull
    @NotEmpty
    private LocalDate dateFact;
    @NotNull
    @NotEmpty
    @Positive
    private int valueFact;
}
