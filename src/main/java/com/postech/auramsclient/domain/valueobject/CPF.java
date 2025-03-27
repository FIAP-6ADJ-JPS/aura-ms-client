package com.postech.auramsclient.domain.valueobject;

import java.util.Objects;

public class CPF {
    private final String document;

    public CPF(String document) {
        this.document = Objects.requireNonNull(document, "CPF não pode ser nulo");
        if (document.isEmpty()) {
            throw new IllegalArgumentException("CPF não pode ser vazio");
        }
        if (!isValid()) {
            throw new IllegalArgumentException("CPF inválido");
        }
    }

    public boolean isValid() {
        return document.matches("\\d{11}");
    }

    public String getValue() {
        return document;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        CPF cpf = (CPF) o;
        return Objects.equals(document, cpf.document);
    }

}