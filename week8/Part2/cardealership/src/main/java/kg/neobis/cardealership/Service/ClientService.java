package kg.neobis.cardealership.Service;

import kg.neobis.cardealership.Exception.EntityNotFoundException;
import kg.neobis.cardealership.Model.Client;
import kg.neobis.cardealership.Repository.ClientRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class ClientService {
    private ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public List<Client> all() {
        return clientRepository.findAll();
    }

    public Client getClientById(Long id) {
        return clientRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Could not find client ", id));
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
                    client.setEmail(newClient.getEmail());
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
            throw new EntityNotFoundException("Could not find client ", id);
        }
        clientRepository.deleteById(id);
    }
}
