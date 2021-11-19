package com.umanizales.cancha_inteligente.infrastructure.repositories;

import com.umanizales.cancha_inteligente.domain.InvoiceDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

import javax.persistence.*;

import java.time.LocalDate;

@Entity
@Data
@Table(name = "invoice", schema = "public", catalog = "db_canchainteligente")
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class InvoiceEntity {
    @Id
    @Column(name = "id_fact", nullable = false, length = 10)
    private String idFact;

    @Basic
    @Column(name = "date_fact", nullable = true)
    private LocalDate dateFact;

    @Basic
    @Column(name = "value_fact", nullable = false)
    private int valueFact;

    public InvoiceEntity(InvoiceDTO invoiceDTO) {
        // copiar las propiedes del dto
        // generar el codigo del cliente
        BeanUtils.copyProperties(invoiceDTO,this);
        // como generar un UUID de tipo string
        this.idFact="P_"+this.dateFact;

    }

    public InvoiceDTO toinvoiceDTO()
    {
        InvoiceDTO invoiceDTO= new InvoiceDTO();
        BeanUtils.copyProperties(this,invoiceDTO);
        return invoiceDTO;
    }
}
