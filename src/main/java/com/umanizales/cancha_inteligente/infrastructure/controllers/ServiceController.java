package com.umanizales.cancha_inteligente.infrastructure.controllers;

import com.umanizales.cancha_inteligente.application.ServiceImpl;
import com.umanizales.cancha_inteligente.domain.ServiceDTO;
import com.umanizales.cancha_inteligente.exceptions.CanchaInteligenteException;
import com.umanizales.cancha_inteligente.infrastructure.controllers.dto.ResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(path = "service")

public class ServiceController {

    @Autowired
    private ServiceImpl serviceImpl;

    @PostMapping
    public @ResponseBody
    ResponseEntity<ResponseDTO> save(@RequestBody @Valid ServiceDTO serviceDTO)
    {
        return new ResponseEntity<>(new ResponseDTO("success",
                serviceImpl.save(serviceDTO),null), HttpStatus.OK);
    }

    @GetMapping
    public @ResponseBody ResponseEntity<ResponseDTO> list()
    {
        return new ResponseEntity<>(new ResponseDTO("Success",
                serviceImpl.list(),null),HttpStatus.OK);
    }

    @DeleteMapping("{IdCli}")
    public @ResponseBody ResponseEntity<ResponseDTO> deleteClient(@PathVariable String idServ) throws CanchaInteligenteException
    {
        return new ResponseEntity<>(new ResponseDTO("Success",
                serviceImpl.delete(idServ),null),HttpStatus.OK);
    }

}
