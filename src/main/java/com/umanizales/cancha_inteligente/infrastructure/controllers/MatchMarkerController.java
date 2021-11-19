package com.umanizales.cancha_inteligente.infrastructure.controllers;


import com.umanizales.cancha_inteligente.application.MatchMarkerImpl;
import com.umanizales.cancha_inteligente.domain.MatchMarkerDTO;
import com.umanizales.cancha_inteligente.exceptions.CanchaInteligenteException;
import com.umanizales.cancha_inteligente.infrastructure.controllers.dto.ResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(path = "matchmarker")
public class MatchMarkerController {

    @Autowired
    private MatchMarkerImpl matchMarkerImpl;

    @PostMapping
    public @ResponseBody
    ResponseEntity<ResponseDTO> save(@RequestBody @Valid MatchMarkerDTO matchMarkerDTO)
    {
        return new ResponseEntity<>(new ResponseDTO("success",
                matchMarkerImpl.save(matchMarkerDTO),null), HttpStatus.OK);
    }

    @GetMapping
    public @ResponseBody ResponseEntity<ResponseDTO> list()
    {
        return new ResponseEntity<>(new ResponseDTO("Success",
                matchMarkerImpl.list(),null),HttpStatus.OK);
    }

    @DeleteMapping("{idMark}")
    public @ResponseBody ResponseEntity<ResponseDTO> deleteClient(@PathVariable String idMark) throws CanchaInteligenteException
    {
        return new ResponseEntity<>(new ResponseDTO("Success",
                matchMarkerImpl.delete(idMark),null),HttpStatus.OK);
    }

}
