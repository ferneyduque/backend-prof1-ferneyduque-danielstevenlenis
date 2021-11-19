package com.umanizales.cancha_inteligente.application;


import com.umanizales.cancha_inteligente.domain.IotDTO;
import com.umanizales.cancha_inteligente.exceptions.CanchaInteligenteException;

import java.util.List;

public interface IotAble {

    IotDTO save(IotDTO iotDTO);
    IotDTO update(IotDTO iotDTO);
    boolean delete(String idMark) throws CanchaInteligenteException;
    List<IotDTO> list();

}
