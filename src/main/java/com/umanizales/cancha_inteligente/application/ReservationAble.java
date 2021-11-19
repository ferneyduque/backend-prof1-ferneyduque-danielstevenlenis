package com.umanizales.cancha_inteligente.application;

import com.umanizales.cancha_inteligente.domain.ReservationDTO;
import com.umanizales.cancha_inteligente.exceptions.CanchaInteligenteException;

import java.util.List;

public interface ReservationAble {

    ReservationDTO save(ReservationDTO reservationDTO);
    ReservationDTO update(ReservationDTO reservationDTO);
    boolean delete(String idMark) throws CanchaInteligenteException;
    List<ReservationDTO> list();

}
