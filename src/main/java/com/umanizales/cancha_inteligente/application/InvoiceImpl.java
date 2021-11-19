package com.umanizales.cancha_inteligente.application;

import com.umanizales.cancha_inteligente.domain.InvoiceDTO;
import com.umanizales.cancha_inteligente.exceptions.CanchaInteligenteException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InvoiceImpl implements InvoiceAble{
    @Autowired
    @Qualifier("PostgresInvoiceRepository")
    private InvoiceAble invoicePersistence;


    @Override
    public InvoiceDTO save(InvoiceDTO invoiceDTO) {
        return invoicePersistence.save(invoiceDTO);
    }

    @Override
    public InvoiceDTO update(InvoiceDTO invoiceDTO) {
        return invoicePersistence.update(invoiceDTO);
    }

    @Override
    public boolean delete(String idFact) throws CanchaInteligenteException {
        return invoicePersistence.delete(idFact);
    }

    @Override
    public List<InvoiceDTO> list() {
        return invoicePersistence.list();
    }
}
