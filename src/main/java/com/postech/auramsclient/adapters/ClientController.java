package com.postech.auramsclient.adapters;

import com.postech.auramsclient.adapters.dto.ClientDTO;
import com.postech.auramsclient.application.CreateClientUseCase;
import com.postech.auramsclient.config.exceptions.DuplicateResourceException;
import com.postech.auramsclient.domain.Client;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/clients")
public class ClientController {

    private final CreateClientUseCase createClientUseCase;
    private final ModelMapper modelMapper;

    public ClientController(CreateClientUseCase createClientUseCase, ModelMapper modelMapper) {
        this.createClientUseCase = createClientUseCase;
        this.modelMapper = modelMapper;
    }

    @PostMapping
    public ResponseEntity<ClientDTO> createClient(@RequestBody ClientDTO clientDTO) {
        try {
            Client client = modelMapper.map(clientDTO, Client.class);
            Client createdClient = createClientUseCase.createClient(client);
            ClientDTO createdClientDTO = modelMapper.map(createdClient, ClientDTO.class);
            return new ResponseEntity<>(createdClientDTO, HttpStatus.CREATED);
        } catch (DuplicateResourceException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(null);
        }
    }

    @GetMapping
    public ResponseEntity<?> listAllClients() {
        return null;
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findClientById() {
        return null;
    }

    @GetMapping("/document/{document}")
    public ResponseEntity<?> findClientByDocument() {
        return null;
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateClient() {
        return null;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteClient() {
        return null;
    }
}