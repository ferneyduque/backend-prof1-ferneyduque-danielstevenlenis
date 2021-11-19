package com.umanizales.cancha_inteligente.application;

import com.umanizales.cancha_inteligente.domain.ClientDTO;
import com.umanizales.cancha_inteligente.exceptions.CanchaInteligenteException;

import java.util.List;

public interface ClientAble {
    // declarar las acciones que el microservicio va a realizar sobre la entidad

    ClientDTO save(ClientDTO clientDTO);
    ClientDTO update(ClientDTO clientDTO);
    boolean delete(String idCli) throws CanchaInteligenteException;
    List<ClientDTO> list();

}
