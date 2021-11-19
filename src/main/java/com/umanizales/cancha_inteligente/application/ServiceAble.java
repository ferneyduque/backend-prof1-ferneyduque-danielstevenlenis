package com.umanizales.cancha_inteligente.application;


import com.umanizales.cancha_inteligente.domain.ServiceDTO;
import com.umanizales.cancha_inteligente.exceptions.CanchaInteligenteException;

import java.util.List;

public interface ServiceAble {

    ServiceDTO save(ServiceDTO serviceDTO);
    ServiceDTO update(ServiceDTO serviceDTO);
    boolean delete(String idMark) throws CanchaInteligenteException;
    List<ServiceDTO> list();
}
