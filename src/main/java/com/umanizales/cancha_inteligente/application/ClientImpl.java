package com.umanizales.cancha_inteligente.application;

import com.umanizales.cancha_inteligente.domain.ClientDTO;
import com.umanizales.cancha_inteligente.exceptions.CanchaInteligenteException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientImpl implements ClientAble{

    @Autowired
    @Qualifier("PostgresClientRepository")
    private ClientAble clientPersistence;

    @Override
    public ClientDTO save(ClientDTO clientDTO) {

        return clientPersistence.save(clientDTO);
    }

    @Override
    public ClientDTO update(ClientDTO clientDTO) {

        return clientPersistence.update(clientDTO);
    }

    @Override
    public boolean delete(String IdCli) throws CanchaInteligenteException {

        return clientPersistence.delete(IdCli);

    }

    @Override
    public List<ClientDTO> list() {

        return clientPersistence.list();
    }
}
