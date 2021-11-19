package com.umanizales.cancha_inteligente.application;

import com.umanizales.cancha_inteligente.domain.IotDTO;
import com.umanizales.cancha_inteligente.exceptions.CanchaInteligenteException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IotImpl implements IotAble{

    @Autowired
    @Qualifier("PostgresIotRepository")
    private IotAble iotPersistence;


    @Override
    public IotDTO save(IotDTO iotDTO) {
        return iotPersistence.save(iotDTO);
    }

    @Override
    public IotDTO update(IotDTO iotDTO) {
        return iotPersistence.update(iotDTO);
    }

    @Override
    public boolean delete(String idIot) throws CanchaInteligenteException {
        return iotPersistence.delete(idIot);
    }

    @Override
    public List<IotDTO> list() {
        return iotPersistence.list();
    }
}
