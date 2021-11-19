package com.umanizales.cancha_inteligente.application;

import com.umanizales.cancha_inteligente.domain.DoorDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoorImpl implements DoorAble {

    @Autowired
    @Qualifier("PostgresDoorRepository")
    private DoorAble doorPersistence;


    @Override
    public DoorDTO save(DoorDTO doorDTO) {
        return doorPersistence.save(doorDTO);
    }

    @Override
    public DoorDTO update(DoorDTO doorDTO) {
        return doorPersistence.update(doorDTO);
    }

    @Override
    public boolean delete(String idDoor) {
        return doorPersistence.delete(idDoor);
    }

    @Override
    public List<DoorDTO> list() {
        return doorPersistence.list();
    }
}
