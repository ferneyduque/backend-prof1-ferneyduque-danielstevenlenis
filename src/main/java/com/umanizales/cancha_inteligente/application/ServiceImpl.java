package com.umanizales.cancha_inteligente.application;

import com.umanizales.cancha_inteligente.domain.ServiceDTO;
import com.umanizales.cancha_inteligente.exceptions.CanchaInteligenteException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceImpl implements ServiceAble{

    @Autowired
    @Qualifier("PostgresServiceRepository")
    private ServiceAble servicePersistence;

    @Override
    public ServiceDTO save(ServiceDTO serviceDTO) {
        return servicePersistence.save(serviceDTO);
    }

    @Override
    public ServiceDTO update(ServiceDTO serviceDTO) {
        return servicePersistence.update(serviceDTO);
    }

    @Override
    public boolean delete(String idServ) throws CanchaInteligenteException {
        return servicePersistence.delete(idServ);
    }

    @Override
    public List<ServiceDTO> list() {
        return servicePersistence.list();
    }
}
