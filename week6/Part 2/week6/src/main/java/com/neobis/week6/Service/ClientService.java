package com.neobis.week6.Service;

import com.neobis.week6.Exceptions.ClientNotFoundException;
import com.neobis.week6.Model.Client;
import com.neobis.week6.Repository.ClientRepository;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Component
public class ClientService {

    private final ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public List<Client> all() {
        return clientRepository.findAll();
    }

    public Client getClientById(Long id) {
        return clientRepository.findById(id).orElseThrow(() -> new ClientNotFoundException(id));
    }

    public void addNewClient(@RequestBody Client newClient) {
        clientRepository.save(newClient);
    }

    public Client replaceClient(@RequestBody Client newClient, @PathVariable Long id) {
        return clientRepository.findById(id)
                .map(client -> {
                    client.setFirstName(newClient.getFirstName());
                    client.setLastName(newClient.getLastName());
                    client.setPhoneNumber(newClient.getPhoneNumber());
                    client.setNotes(newClient.getNotes());
                    return clientRepository.save(client);
                })
                .orElseGet(() -> {
                    newClient.setClientId(id);
                    return clientRepository.save(newClient);
                });
    }

    public void deleteClientById(@PathVariable Long id) {
        boolean exists = clientRepository.existsById(id);
        if(!exists){
            throw new ClientNotFoundException(id);
        }
        clientRepository.deleteById(id);
    }
}
