package com.neobis.week6.controller;

import com.neobis.week6.entity.Client;
import com.neobis.week6.exception.ClientNotFoundException;
import com.neobis.week6.model.ClientModel;
import com.neobis.week6.service.ClientService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/v1/clients")
public class ClientController {
    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping
    public ResponseEntity<?> getClients() {
        try{
            return ResponseEntity.ok(clientService.getAll());
        } catch (ClientNotFoundException cnfe) {
            return new ResponseEntity(cnfe.getMessage(), cnfe.getNOT_FOUND_STATUS());
        }
        catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getClientById(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(clientService.getById(id));
        } catch (ClientNotFoundException cnfe) {
            return new ResponseEntity(cnfe.getMessage(), cnfe.getNOT_FOUND_STATUS());
        }
        catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping
    public ResponseEntity<?> addNewClient(@RequestBody Client newClient) {
        try {
            clientService.add(newClient);
            return ResponseEntity.ok("Client was added successfully");
        } catch (ClientNotFoundException cnfe) {
            return new ResponseEntity(cnfe.getMessage(), cnfe.getNOT_FOUND_STATUS());
        }
        catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> replaceClient(@RequestBody ClientModel clientModel, @PathVariable Long id) {
        try{
            return ResponseEntity.ok(clientService.update(clientModel, id));
        } catch (ClientNotFoundException cnfe) {
            return new ResponseEntity(cnfe.getMessage(), cnfe.getNOT_FOUND_STATUS());
        }
        catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteClient(@PathVariable Long id) {
        try {
            clientService.delete(id);
            return ResponseEntity.ok("Deleted client with id = " + id);
        } catch (ClientNotFoundException cnfe) {
            return new ResponseEntity(cnfe.getMessage(), cnfe.getNOT_FOUND_STATUS());
        }
        catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
