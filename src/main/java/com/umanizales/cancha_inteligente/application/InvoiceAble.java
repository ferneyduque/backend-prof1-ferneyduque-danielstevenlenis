package com.umanizales.cancha_inteligente.application;

import com.umanizales.cancha_inteligente.domain.InvoiceDTO;
import com.umanizales.cancha_inteligente.exceptions.CanchaInteligenteException;

import java.util.List;

public interface InvoiceAble {

    InvoiceDTO save(InvoiceDTO invoiceDTO);
    InvoiceDTO update(InvoiceDTO invoiceDTO);
    boolean delete(String idFact) throws CanchaInteligenteException;
    List<InvoiceDTO> list();

}
