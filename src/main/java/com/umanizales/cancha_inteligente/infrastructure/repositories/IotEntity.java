package com.umanizales.cancha_inteligente.infrastructure.repositories;

import com.umanizales.cancha_inteligente.domain.ClientDTO;
import com.umanizales.cancha_inteligente.domain.IotDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "iot", schema = "public", catalog = "db_canchainteligente")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class IotEntity {

    @Id
    @Column(name = "id_iot", nullable = false, length = 10)
    private String idIot;

    public IotEntity(IotDTO iotDTO){

        BeanUtils.copyProperties(iotDTO,this);
        // como generar un UUID de tipo string
        this.idIot="P_";
    }

    public IotDTO toiotDTO()
    {
        IotDTO iotDTO= new IotDTO();
        BeanUtils.copyProperties(this,iotDTO);
        return iotDTO;

    }



}
