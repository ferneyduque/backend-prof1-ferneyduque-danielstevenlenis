package com.umanizales.cancha_inteligente.infrastructure.repositories;

import com.umanizales.cancha_inteligente.domain.DoorDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

import javax.persistence.*;

import java.time.LocalTime;

@Entity
@Data
@Table(name = "door", schema = "public", catalog = "db_canchainteligente")
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class DoorEntity {
    @Id
    @Column(name = "id_door", nullable = false, length = 10)
    private String idDoor;
    @Basic
    @Column(name = "id_service_door", nullable = false, length = 50)
    private String idServiceDoor;
    @Basic
    @Column(name = "time_unlocked", nullable = true)
    private LocalTime timeUnlocked;

    public DoorEntity(DoorDTO doorDTO) {

        BeanUtils.copyProperties(doorDTO,this);

        this.idDoor="P2_"+this.idServiceDoor;
    }

    public DoorDTO todoorDTO()
    {
        DoorDTO doorDTO= new DoorDTO();
        BeanUtils.copyProperties(this,doorDTO);
        return doorDTO;
    }

}
