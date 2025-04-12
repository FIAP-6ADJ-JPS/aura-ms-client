package com.postech.auramsclient.application;

import com.postech.auramsclient.config.exceptions.ResourceNotFoundException;
import com.postech.auramsclient.gateway.ClientRepository;
import com.postech.auramsclient.gateway.database.jpa.entity.ClientEntity;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class DeleteClientUseCase {

    private final ClientRepository clientRepository;
    private final FindClientUseCase findClientUseCase;
    private ModelMapper modelMapper;

    public DeleteClientUseCase(ClientRepository clientRepository, FindClientUseCase findClientUseCase) {
        this.clientRepository = clientRepository;
        this.findClientUseCase = findClientUseCase;
    }

    public void deleteClient(Long id) {
        ClientEntity clientEntity = clientRepository.findById(id);
        if (clientEntity == null) {
            throw new ResourceNotFoundException("Cliente não encontrado");
        }
        clientRepository.deleteById(id);
    }
}