package com.umanizales.cancha_inteligente.infrastructure.adapters;

import com.umanizales.cancha_inteligente.application.ServiceAble;
import com.umanizales.cancha_inteligente.domain.ClientDTO;
import com.umanizales.cancha_inteligente.domain.ServiceDTO;
import com.umanizales.cancha_inteligente.exceptions.CanchaInteligenteException;
import com.umanizales.cancha_inteligente.infrastructure.repositories.ClientEntity;
import com.umanizales.cancha_inteligente.infrastructure.repositories.ServiceEntity;
import com.umanizales.cancha_inteligente.infrastructure.repositories.ServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Qualifier("PostgresServiceRepository")
@Repository("ServicePersistence")
public class PostgresServiceRepository implements ServiceAble {

    @Autowired
    private ServiceRepository serviceRepository;


    @Override
    public ServiceDTO save(ServiceDTO serviceDTO) {

        return serviceRepository.save(new ServiceEntity(serviceDTO)).toserviceDTO();

    }

    @Override
    public ServiceDTO update(ServiceDTO serviceDTO) {
        return null;
    }

    @Override
    public boolean delete(String idServ) throws CanchaInteligenteException {

        if (serviceRepository.existsById(idServ)){

            serviceRepository.deleteById(idServ);
            return true;
        }
        else {
            throw new CanchaInteligenteException("El codigo a borrar no existe");
        }
    }

    @Override
    public List<ServiceDTO> list() {

        List<ServiceEntity> services= serviceRepository.findAll();
        List<ServiceDTO> servicesDTO= new ArrayList<>();
        for(ServiceEntity service:services)
        {
            servicesDTO.add(service.toserviceDTO());
        }

        return servicesDTO;

    }
}
