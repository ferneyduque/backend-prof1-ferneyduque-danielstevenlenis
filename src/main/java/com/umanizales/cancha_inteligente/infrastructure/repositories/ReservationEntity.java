package com.umanizales.cancha_inteligente.infrastructure.repositories;

import com.umanizales.cancha_inteligente.domain.ReservationDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

import javax.persistence.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Data
@Table(name = "reservation", schema = "public", catalog = "db_canchainteligente")
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class ReservationEntity {

    @Id
    @Column(name = "id_res", nullable = false, length = 10)
    private String idRes;

    @Basic
    @Column(name = "hora_res", nullable = true)
    private LocalTime horaRes;

    @Basic
    @Column(name = "fecha_res", nullable = true)
    private LocalDate fechaRes;

    @Basic
    @Column(name = "res_estado", nullable = true, length = 10)
    private String resEstado;

    public ReservationEntity(ReservationDTO reservationDTO) {
        // copiar las propiedes del dto
        // generar el codigo del cliente
        BeanUtils.copyProperties(reservationDTO,this);
        // como generar un UUID de tipo string
        this.idRes="P_"+this.resEstado;

    }

    public ReservationDTO toreservationDTO()
    {
        ReservationDTO reservationDTO= new ReservationDTO();
        BeanUtils.copyProperties(this,reservationDTO);
        return reservationDTO;
    }

}
