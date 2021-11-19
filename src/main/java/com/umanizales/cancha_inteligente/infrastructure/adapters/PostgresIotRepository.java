package com.umanizales.cancha_inteligente.infrastructure.adapters;

import com.umanizales.cancha_inteligente.application.IotAble;
import com.umanizales.cancha_inteligente.domain.ClientDTO;
import com.umanizales.cancha_inteligente.domain.IotDTO;
import com.umanizales.cancha_inteligente.exceptions.CanchaInteligenteException;
import com.umanizales.cancha_inteligente.infrastructure.repositories.ClientEntity;
import com.umanizales.cancha_inteligente.infrastructure.repositories.IotEntity;
import com.umanizales.cancha_inteligente.infrastructure.repositories.IotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Qualifier("PostgresIotRepository")
@Repository("IotPersistence")
public class PostgresIotRepository implements IotAble {

    @Autowired
    private IotRepository iotRepository;

    @Override
    public IotDTO save(IotDTO iotDTO) {

        return iotRepository.save(new IotEntity(iotDTO)).toiotDTO();

    }

    @Override
    public IotDTO update(IotDTO iotDTO) {
        return null;
    }

    @Override
    public boolean delete(String idIot) throws CanchaInteligenteException {

        if (iotRepository.existsById(idIot)){

            iotRepository.deleteById(idIot);
            return true;
        }
        else {
            throw new CanchaInteligenteException("El codigo a borrar no existe");
        }
    }

    @Override
    public List<IotDTO> list() {

        List<IotEntity> iots= iotRepository.findAll();
        List<IotDTO> iotsDTO= new ArrayList<>();
        for(IotEntity iot:iots)
        {
            iotsDTO.add(iot.toiotDTO());
        }

        return iotsDTO;
    }
}
