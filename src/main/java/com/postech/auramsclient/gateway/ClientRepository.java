package com.postech.auramsclient.gateway;

import com.postech.auramsclient.domain.valueobject.CPF;
import com.postech.auramsclient.gateway.database.jpa.entity.ClientEntity;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository {
    boolean existsByCpf(CPF cpf);
    ClientEntity save(ClientEntity client);
}
