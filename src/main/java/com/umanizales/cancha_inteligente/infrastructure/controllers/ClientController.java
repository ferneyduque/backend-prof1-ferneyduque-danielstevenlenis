package com.umanizales.cancha_inteligente.infrastructure.controllers;

import com.umanizales.cancha_inteligente.application.ClientImpl;
import com.umanizales.cancha_inteligente.domain.ClientDTO;
import com.umanizales.cancha_inteligente.exceptions.CanchaInteligenteException;
import com.umanizales.cancha_inteligente.infrastructure.controllers.dto.ResponseDTO;
import com.umanizales.cancha_inteligente.infrastructure.repositories.ClientEntity;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(path = "client")

public class ClientController {

    @Autowired
    private ClientImpl clientImpl;

    @PostMapping
    public @ResponseBody ResponseEntity<ResponseDTO>save(@RequestBody @Valid ClientDTO clientDTO)
    {
        return new ResponseEntity<>(new ResponseDTO("success",
                clientImpl.save(clientDTO),null), HttpStatus.OK);
    }

    @GetMapping
    public @ResponseBody ResponseEntity<ResponseDTO> list()
    {
        return new ResponseEntity<>(new ResponseDTO("Success",
                clientImpl.list(),null),HttpStatus.OK);
    }

    @DeleteMapping("{IdCli}")
    public @ResponseBody ResponseEntity<ResponseDTO> deleteClient(@PathVariable String IdCli) throws CanchaInteligenteException
    {
        return new ResponseEntity<>(new ResponseDTO("Success",
                clientImpl.delete(IdCli),null),HttpStatus.OK);
    }

    @PutMapping("{IdCli}")
    public @ResponseBody ResponseEntity<ResponseDTO> updateClient(@PathVariable String IdCli,@RequestBody @Valid ClientDTO clientDTO ) throws CanchaInteligenteException
    {
        /*ResponseEntity updateClient = new ResponseEntity(clientDTO);

        ClientDTO clientDT0 = new ClientDTO();
        BeanUtils.copyProperties(clientImpl, clientDTO);

        ClientDTO updateCli = clientImpl.update(clientDTO, IdCli);
        BeanUtils.copyProperties(updateCli, updateClient);
        return updateClient;*/
        return new ResponseEntity<>(new ResponseDTO("success",
                clientImpl.save(clientDTO),null), HttpStatus.OK);
    }
}