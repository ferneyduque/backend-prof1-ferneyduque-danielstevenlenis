package com.umanizales.cancha_inteligente.application;

import com.umanizales.cancha_inteligente.domain.MatchMarkerDTO;
import com.umanizales.cancha_inteligente.exceptions.CanchaInteligenteException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class MatchMarkerImpl implements MatchMarkerAble{

    @Autowired
    @Qualifier("PostgresMatchMarkerRepository")
    private MatchMarkerAble matchMarkerPersistence;


    @Override
    public MatchMarkerDTO save(MatchMarkerDTO matchMarkerDTO) {
        return matchMarkerPersistence.save(matchMarkerDTO);
    }

    @Override
    public MatchMarkerDTO update(MatchMarkerDTO matchMarkerDTO) {
        return matchMarkerPersistence.update(matchMarkerDTO);
    }

    @Override
    public boolean delete(String idMark) throws CanchaInteligenteException {
        return matchMarkerPersistence.delete(idMark);
    }

    @Override
    public List<MatchMarkerDTO> list() {
        return matchMarkerPersistence.list();
    }
}
