package com.umanizales.cancha_inteligente.infrastructure.repositories;

import com.umanizales.cancha_inteligente.domain.MatchMarkerDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

import javax.persistence.*;


@Entity
@Data
@Table(name = "match_marker", schema = "public", catalog = "db_canchainteligente")
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class MatchMarkerEntity {

    @Id
    @Column(name = "id_mark", nullable = false, length = 3)
    private String idMark;

    @Basic
    @Column(name = "id_service_mar", nullable = true, length = 10)
    private String idServiceMar;

    @Basic
    @Column(name = "buttom_goal", nullable = true)
    private Integer buttomGoal;

    public MatchMarkerEntity(MatchMarkerDTO matchMarkerDTO) {
        // copiar las propiedes del dto
        // generar el codigo del cliente
        BeanUtils.copyProperties(matchMarkerDTO,this);
        // como generar un UUID de tipo string
        this.idMark="P_";

    }

    public MatchMarkerDTO tomatchMarkerDTODTO()
    {
        MatchMarkerDTO matchMarkerDTO= new MatchMarkerDTO();
        BeanUtils.copyProperties(this,matchMarkerDTO);
        return matchMarkerDTO;
    }

}
