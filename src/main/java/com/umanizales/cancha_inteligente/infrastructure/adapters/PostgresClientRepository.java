package com.umanizales.cancha_inteligente.infrastructure.adapters;

import com.umanizales.cancha_inteligente.application.ClientAble;
import com.umanizales.cancha_inteligente.domain.ClientDTO;
import com.umanizales.cancha_inteligente.exceptions.CanchaInteligenteException;
import com.umanizales.cancha_inteligente.infrastructure.repositories.ClientEntity;
import com.umanizales.cancha_inteligente.infrastructure.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;


@Qualifier("PostgresClientRepository")
@Repository("ClientPersistence")
public class PostgresClientRepository implements ClientAble {

    //------------ poner para todos
    @Autowired
    private ClientRepository clientRepository;

    @Override
    public ClientDTO save(ClientDTO clientDTO) {

        return clientRepository.save(new ClientEntity(clientDTO)).toclientDTO();

    }

    @Override
    public ClientDTO update(ClientDTO clientDTO) {

        return clientRepository.save(new ClientEntity(clientDTO)).toclientDTO();
    }

    @Override
    public boolean delete(String IdCli) throws CanchaInteligenteException {

        if (clientRepository.existsById(IdCli)){

            clientRepository.deleteById(IdCli);
        return true;
        }
        else {
            throw new CanchaInteligenteException("El codigo a borrar no existe");
        }
    }

    @Override
    public List<ClientDTO> list() {

        List<ClientEntity> clients= clientRepository.findAll();
        List<ClientDTO> clientsDTO= new ArrayList<>();
        for(ClientEntity client:clients)
        {
            clientsDTO.add(client.toclientDTO());
        }

        return clientsDTO;
    }
}
