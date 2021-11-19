package com.umanizales.cancha_inteligente.application;

import com.umanizales.cancha_inteligente.domain.DoorDTO;

import java.util.List;

public interface DoorAble {

    DoorDTO save(DoorDTO doorDTO);
    DoorDTO update(DoorDTO doorDTO);
    boolean delete(String idDoor);
    List<DoorDTO> list();

}
