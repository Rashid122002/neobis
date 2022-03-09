package com.neobis.week6.service;

import com.neobis.week6.exception.ClientNotFoundException;
import com.neobis.week6.entity.Client;
import com.neobis.week6.model.ClientModel;
import com.neobis.week6.repository.ClientRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static com.neobis.week6.model.ClientModel.entityToModel;

@Service
public class ClientService implements DAO<Client, ClientModel, Long> {

    private final ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public List<ClientModel> entityListToModelList(Iterable<Client> clients) {
        List<ClientModel> clientModelList = new ArrayList<>();
        for (Client client : clients)
        {
            clientModelList.add(entityToModel(client));
        }
        return clientModelList;
    }

    @Override
    public List<ClientModel> getAll() {
        return entityListToModelList(clientRepository.findAll());
    }

    @Override
    public ClientModel getById(Long id) throws ClientNotFoundException {
        Client client = clientRepository.findById(id)
                .orElseThrow(() -> new ClientNotFoundException(id));
        return entityToModel(client);
    }

    @Override
    public void add(Client client) {
        clientRepository.save(client);
    }

    @Override
    public Client update(ClientModel clientModel, Long id) throws ClientNotFoundException {
        Client client = clientRepository.findById(id)
                .orElseThrow(() -> new ClientNotFoundException(id));
        client.setFirstName(clientModel.getFirstName());
        client.setLastName(clientModel.getLastName());
        client.setPhoneNumber(clientModel.getPhoneNumber());
        client.setNotes(clientModel.getNotes());
        return clientRepository.save(client);
    }

    @Override
    public Long delete(Long id) throws ClientNotFoundException {
        if(!clientRepository.existsById(id)) {
            throw new ClientNotFoundException(id);
        }
        clientRepository.deleteById(id);
        return id;
    }
}
