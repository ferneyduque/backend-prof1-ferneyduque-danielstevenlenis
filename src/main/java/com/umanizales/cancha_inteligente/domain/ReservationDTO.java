package com.umanizales.cancha_inteligente.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.time.LocalDate;
import java.time.LocalTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReservationDTO {
    private String idRes;
    @NotNull
    @NotEmpty
    private LocalTime horaRes;
    @NotNull
    @NotEmpty
    private LocalDate fechaRes;
    @NotNull
    @NotEmpty
    private String resEstado;
}
