package com.umanizales.cancha_inteligente.infrastructure.controllers;


import com.umanizales.cancha_inteligente.application.ReservationImpl;
import com.umanizales.cancha_inteligente.domain.ReservationDTO;
import com.umanizales.cancha_inteligente.exceptions.CanchaInteligenteException;
import com.umanizales.cancha_inteligente.infrastructure.controllers.dto.ResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(path = "reservation")
public class ReservationController {

    @Autowired
    private ReservationImpl reservationImpl;

    @PostMapping
    public @ResponseBody
    ResponseEntity<ResponseDTO> save(@RequestBody @Valid ReservationDTO reservationDTO)
    {
        return new ResponseEntity<>(new ResponseDTO("success",
                reservationImpl.save(reservationDTO),null), HttpStatus.OK);
    }

    @GetMapping
    public @ResponseBody ResponseEntity<ResponseDTO> list()
    {
        return new ResponseEntity<>(new ResponseDTO("Success",
                reservationImpl.list(),null),HttpStatus.OK);
    }

    @DeleteMapping("{idRes}")
    public @ResponseBody ResponseEntity<ResponseDTO> deleteClient(@PathVariable String idRes) throws CanchaInteligenteException
    {
        return new ResponseEntity<>(new ResponseDTO("Success",
                reservationImpl.delete(idRes),null),HttpStatus.OK);
    }

}
