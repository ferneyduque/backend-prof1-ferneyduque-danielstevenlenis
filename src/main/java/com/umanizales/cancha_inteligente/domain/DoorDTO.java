package com.umanizales.cancha_inteligente.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.time.LocalTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DoorDTO {
    private String idDoor;
    @NotNull
    @NotEmpty
    private String idServiceDoor;

    private LocalTime timeUnlocked;


}
