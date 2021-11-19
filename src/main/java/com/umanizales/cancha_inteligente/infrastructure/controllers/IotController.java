package com.umanizales.cancha_inteligente.infrastructure.controllers;


import com.umanizales.cancha_inteligente.application.IotImpl;
import com.umanizales.cancha_inteligente.domain.IotDTO;
import com.umanizales.cancha_inteligente.exceptions.CanchaInteligenteException;
import com.umanizales.cancha_inteligente.infrastructure.controllers.dto.ResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(path = "iot")
public class IotController {

    @Autowired
    private IotImpl iotImpl;

    @PostMapping
    public @ResponseBody
    ResponseEntity<ResponseDTO> save(@RequestBody @Valid IotDTO iotDTO)
    {
        return new ResponseEntity<>(new ResponseDTO("success",
                iotImpl.save(iotDTO),null), HttpStatus.OK);
    }

    @GetMapping
    public @ResponseBody ResponseEntity<ResponseDTO> list()
    {
        return new ResponseEntity<>(new ResponseDTO("Success",
                iotImpl.list(),null),HttpStatus.OK);
    }

    @DeleteMapping("{idIot}")
    public @ResponseBody ResponseEntity<ResponseDTO> deleteClient(@PathVariable String idIot) throws CanchaInteligenteException
    {
        return new ResponseEntity<>(new ResponseDTO("Success",
                iotImpl.delete(idIot),null),HttpStatus.OK);
    }




}
