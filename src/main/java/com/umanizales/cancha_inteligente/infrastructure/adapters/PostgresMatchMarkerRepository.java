package com.umanizales.cancha_inteligente.infrastructure.adapters;

import com.umanizales.cancha_inteligente.application.MatchMarkerAble;
import com.umanizales.cancha_inteligente.domain.ClientDTO;
import com.umanizales.cancha_inteligente.domain.MatchMarkerDTO;
import com.umanizales.cancha_inteligente.exceptions.CanchaInteligenteException;
import com.umanizales.cancha_inteligente.infrastructure.repositories.ClientEntity;
import com.umanizales.cancha_inteligente.infrastructure.repositories.MatchMarkerEntity;
import com.umanizales.cancha_inteligente.infrastructure.repositories.MatchMarkerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Qualifier("PostgresMatchMarkerRepository")
@Repository("MatchMarkerPersistence")

public class PostgresMatchMarkerRepository implements MatchMarkerAble {

    @Autowired
    private MatchMarkerRepository matchMarkerRepository;

    @Override
    public MatchMarkerDTO save(MatchMarkerDTO matchMarkerDTO) {

        return matchMarkerRepository.save(new MatchMarkerEntity(matchMarkerDTO)).tomatchMarkerDTODTO();
    }

    @Override
    public MatchMarkerDTO update(MatchMarkerDTO matchMarkerDTO) {
        return null;
    }

    @Override
    public boolean delete(String idMark) throws CanchaInteligenteException {
        if (matchMarkerRepository.existsById(idMark)){

            matchMarkerRepository.deleteById(idMark);
            return true;
        }
        else {
            throw new CanchaInteligenteException("El codigo a borrar no existe");
        }
    }

    @Override
    public List<MatchMarkerDTO> list() {

        List<MatchMarkerEntity> matchs= matchMarkerRepository.findAll();
        List<MatchMarkerDTO> matchsDTO= new ArrayList<>();
        for(MatchMarkerEntity matchMarker:matchs)
        {
            matchsDTO.add(matchMarker.tomatchMarkerDTODTO());
        }

        return matchsDTO;
    }
}
