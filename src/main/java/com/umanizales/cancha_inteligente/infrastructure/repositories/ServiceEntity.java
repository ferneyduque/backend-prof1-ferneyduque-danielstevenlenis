package com.umanizales.cancha_inteligente.infrastructure.repositories;

import com.umanizales.cancha_inteligente.domain.ServiceDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

import javax.persistence.*;


@Entity
@Data
@Table(name = "service", schema = "public", catalog = "db_canchainteligente")
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class ServiceEntity {

    @Id
    @Column(name = "id_serv", nullable = false, length = 10)
    private String idServ;

    @Basic
    @Column(name = "nom_serv", nullable = true, length = 25)
    private String nomServ;

    @Basic
    @Column(name = "id_fact_service", nullable = true, length = 10)
    private String idFactService;

    public ServiceEntity(ServiceDTO serviceDTO) {
        // copiar las propiedes del dto
        // generar el codigo del cliente
        BeanUtils.copyProperties(serviceDTO,this);
        // como generar un UUID de tipo string
        this.idServ="P_"+this.nomServ;

    }

    public ServiceDTO toserviceDTO()
    {
        ServiceDTO serviceDTO= new ServiceDTO();
        BeanUtils.copyProperties(this,serviceDTO);
        return serviceDTO;
    }

}
