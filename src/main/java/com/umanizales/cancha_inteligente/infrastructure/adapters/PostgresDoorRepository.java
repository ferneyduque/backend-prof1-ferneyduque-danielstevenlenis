package com.umanizales.cancha_inteligente.infrastructure.adapters;

import com.umanizales.cancha_inteligente.application.DoorAble;
import com.umanizales.cancha_inteligente.domain.ClientDTO;
import com.umanizales.cancha_inteligente.domain.DoorDTO;
import com.umanizales.cancha_inteligente.infrastructure.repositories.ClientEntity;
import com.umanizales.cancha_inteligente.infrastructure.repositories.DoorEntity;
import com.umanizales.cancha_inteligente.infrastructure.repositories.DoorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Qualifier("PostgresDoorRepository")
@Repository("DoorPersistence")

public class PostgresDoorRepository implements DoorAble {

    @Autowired
    private DoorRepository doorRepository;

    @Override
    public DoorDTO save(DoorDTO doorDTO) {


        return doorRepository.save(new DoorEntity(doorDTO)).todoorDTO();

    }

    @Override
    public DoorDTO update(DoorDTO doorDTO) {

        return doorRepository.save(new DoorEntity(doorDTO)).todoorDTO();
    }

    @Override
    public boolean delete(String idDoor) {

        doorRepository.deleteById(idDoor);

        return true;
    }

    @Override
    public List<DoorDTO> list() {

        List<DoorEntity> doors= doorRepository.findAll();
        List<DoorDTO> doorsDTO= new ArrayList<>();
        for(DoorEntity door:doors)
        {
            doorsDTO.add(door.todoorDTO());
        }

        return doorsDTO;

    }
}
