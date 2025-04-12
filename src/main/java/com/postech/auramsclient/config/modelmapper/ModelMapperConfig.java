package com.postech.auramsclient.config.modelmapper;

import com.postech.auramsclient.adapters.dto.ClientDTO;
import com.postech.auramsclient.domain.Client;
import com.postech.auramsclient.domain.valueobject.CPF;
import com.postech.auramsclient.gateway.database.jpa.entity.ClientEntity;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfig {

    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setSkipNullEnabled(true);
        // Add custom mapping for CPF between ClientDTO and Client
        modelMapper.createTypeMap(ClientDTO.class, Client.class)
                .addMappings(mapper -> mapper.skip(Client::setCpf))
                .setPostConverter(context -> {
                    ClientDTO source = context.getSource();
                    Client destination = context.getDestination();
                    if (source.getCpf() != null) {
                        destination.setCpf(new CPF(source.getCpf()));
                    }
                    return destination;
                });

        // Add reverse mapping from Client to ClientDTO
        modelMapper.createTypeMap(Client.class, ClientDTO.class)
                .addMappings(mapper -> mapper.skip(ClientDTO::setCpf))
                .setPostConverter(context -> {
                    Client source = context.getSource();
                    ClientDTO destination = context.getDestination();
                    if (source.getCpf() != null) {
                        destination.setCpf(source.getCpf().getValue());
                    }
                    return destination;
                });

        modelMapper.createTypeMap(Client.class, ClientEntity.class)
                .setPostConverter(context -> {
                    Client source = context.getSource();
                    ClientEntity destination = context.getDestination();
                    if (source.getCpf() != null) {
                        destination.setCpf(source.getCpf().getValue());
                    }
                    return destination;
                });

        modelMapper.createTypeMap(ClientEntity.class, Client.class)
                .setPostConverter(context -> {
                    ClientEntity source = context.getSource();
                    Client destination = context.getDestination();
                    if (source.getCpf() != null) {
                        destination.setCpf(new CPF(source.getCpf()));
                    }
                    return destination;
                });
        return modelMapper;
    }
}
