package com.umanizales.cancha_inteligente.application;


import com.umanizales.cancha_inteligente.domain.MatchMarkerDTO;
import com.umanizales.cancha_inteligente.exceptions.CanchaInteligenteException;

import java.util.List;

public interface MatchMarkerAble {

    MatchMarkerDTO save(MatchMarkerDTO matchMarkerDTO);
    MatchMarkerDTO update(MatchMarkerDTO matchMarkerDTO);
    boolean delete(String idMark) throws CanchaInteligenteException;
    List<MatchMarkerDTO> list();

}
