package com.postech.auramsclient.gateway;

import com.postech.auramsclient.domain.valueobject.CPF;
import com.postech.auramsclient.gateway.database.jpa.entity.ClientEntity;
import com.postech.auramsclient.gateway.database.jpa.repository.ClientJpaRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientRepositoryImpl implements ClientRepository {

    public final ClientJpaRepository clientJpaRepository;
    public final ModelMapper modelMapper;

    public ClientRepositoryImpl(ClientJpaRepository clientJpaRepository, ModelMapper modelMapper) {
        this.clientJpaRepository = clientJpaRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public boolean existsByCpf(String cpf) {
        return clientJpaRepository.existsByCpf(cpf);
    }

    @Override
    public ClientEntity save(ClientEntity clientEntity) {
        if (clientEntity != null) {
            return clientJpaRepository.save(clientEntity);
        }
        return clientEntity;
    }

    @Override
    public List<ClientEntity> findAll() {
        return List.of();
    }

    @Override
    public ClientEntity findById(Long id) {
        return null;
    }

    @Override
    public ClientEntity findByCpf(String cpf) {
        return null;
    }

    @Override
    public ClientEntity updateClient(Long id) {
        return null;
    }

    @Override
    public void deleteById(Long id) {

    }
}
