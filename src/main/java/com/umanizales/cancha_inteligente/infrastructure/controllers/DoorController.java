package com.umanizales.cancha_inteligente.infrastructure.controllers;


import com.umanizales.cancha_inteligente.application.DoorImpl;
import com.umanizales.cancha_inteligente.domain.DoorDTO;
import com.umanizales.cancha_inteligente.exceptions.CanchaInteligenteException;
import com.umanizales.cancha_inteligente.infrastructure.controllers.dto.ResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(path = "door")
public class DoorController {

    @Autowired
    private DoorImpl doorImpl;

    @PostMapping
    public @ResponseBody
    ResponseEntity<ResponseDTO> save(@RequestBody @Valid DoorDTO doorDTO)
    {
        return new ResponseEntity<>(new ResponseDTO("success",
                doorImpl.save(doorDTO),null), HttpStatus.OK);
    }

    @GetMapping
    public @ResponseBody ResponseEntity<ResponseDTO> list()
    {
        return new ResponseEntity<>(new ResponseDTO("Success",
                doorImpl.list(),null),HttpStatus.OK);
    }

    @DeleteMapping("{idDoor}")
    public @ResponseBody ResponseEntity<ResponseDTO> deleteClient(@PathVariable String idDoor) throws CanchaInteligenteException
    {
        return new ResponseEntity<>(new ResponseDTO("Success",
                doorImpl.delete(idDoor),null),HttpStatus.OK);
    }

}
