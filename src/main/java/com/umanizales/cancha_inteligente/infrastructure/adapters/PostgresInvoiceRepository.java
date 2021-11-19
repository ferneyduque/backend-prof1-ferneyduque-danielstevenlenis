package com.umanizales.cancha_inteligente.infrastructure.adapters;

import com.umanizales.cancha_inteligente.application.InvoiceAble;
import com.umanizales.cancha_inteligente.domain.ClientDTO;
import com.umanizales.cancha_inteligente.domain.InvoiceDTO;
import com.umanizales.cancha_inteligente.exceptions.CanchaInteligenteException;
import com.umanizales.cancha_inteligente.infrastructure.repositories.ClientEntity;
import com.umanizales.cancha_inteligente.infrastructure.repositories.InvoiceEntity;
import com.umanizales.cancha_inteligente.infrastructure.repositories.InvoiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Qualifier("PostgresInvoiceRepository")
@Repository("InvoicePersistence")

public class PostgresInvoiceRepository implements InvoiceAble {

    @Autowired
    private InvoiceRepository invoiceRepository;

    @Override
    public InvoiceDTO save(InvoiceDTO invoiceDTO) {

        return invoiceRepository.save(new InvoiceEntity(invoiceDTO)).toinvoiceDTO();
    }

    @Override
    public InvoiceDTO update(InvoiceDTO invoiceDTO) {

        return invoiceRepository.save(new InvoiceEntity(invoiceDTO)).toinvoiceDTO();
    }

    @Override
    public boolean delete(String idFact) throws CanchaInteligenteException {

        if (invoiceRepository.existsById(idFact)){

            invoiceRepository.deleteById(idFact);
            return true;
        }
        else {
            throw new CanchaInteligenteException("El codigo a borrar no existe");
        }
    }

    @Override
    public List<InvoiceDTO> list() {

        List<InvoiceEntity> invoices= invoiceRepository.findAll();
        List<InvoiceDTO> invoicesDTO= new ArrayList<>();
        for(InvoiceEntity invoice:invoices)
        {
            invoicesDTO.add(invoice.toinvoiceDTO());
        }

        return invoicesDTO;

    }
}
