package com.umanizales.cancha_inteligente.infrastructure.controllers;

import com.umanizales.cancha_inteligente.application.InvoiceImpl;
import com.umanizales.cancha_inteligente.domain.InvoiceDTO;
import com.umanizales.cancha_inteligente.exceptions.CanchaInteligenteException;
import com.umanizales.cancha_inteligente.infrastructure.controllers.dto.ResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(path = "invoice")
public class InvoiceController {

    @Autowired
    private InvoiceImpl invoiceImpl;

    @PostMapping
    public @ResponseBody
    ResponseEntity<ResponseDTO> save(@RequestBody @Valid InvoiceDTO invoiceDTO)
    {
        return new ResponseEntity<>(new ResponseDTO("success",
                invoiceImpl.save(invoiceDTO),null), HttpStatus.OK);
    }
    @GetMapping
    public @ResponseBody ResponseEntity<ResponseDTO> list()
    {
        return new ResponseEntity<>(new ResponseDTO("Success",
                invoiceImpl.list(),null),HttpStatus.OK);
    }

    @DeleteMapping("{idFact}")
    public @ResponseBody ResponseEntity<ResponseDTO> deleteClient(@PathVariable String idFact) throws CanchaInteligenteException
    {
        return new ResponseEntity<>(new ResponseDTO("Success",
                invoiceImpl.delete(idFact),null),HttpStatus.OK);
    }


}
