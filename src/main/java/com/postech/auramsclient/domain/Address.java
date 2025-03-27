package com.postech.auramsclient.domain;

import java.util.Objects;

public class Address {

    private final String street;
    private final String number;
    private final String zipcode;
    private final String neighborhood;
    private final String city;
    private final String state;

    public Address(String street, String number, String zipcode, String neighborhood, String city, String state) {
        this.street = Objects.requireNonNull(street, "Rua não pode ser nula");
        this.number = Objects.requireNonNull(number, "Número não pode ser nulo");
        this.zipcode = Objects.requireNonNull(zipcode, "CEP não pode ser nulo");
        this.neighborhood = Objects.requireNonNull(neighborhood, "Bairro não pode ser nulo");
        this.city = Objects.requireNonNull(city, "Cidade não pode ser nula");
        this.state = Objects.requireNonNull(state, "Estado não pode ser nulo");

        validate();
    }

    private void validate() {
        if (street.isEmpty()) {
            throw new IllegalArgumentException("Rua não pode ser vazia");
        }
        if (number.isEmpty()) {
            throw new IllegalArgumentException("Número não pode ser vazio");
        }
        if (zipcode.isEmpty()) {
            throw new IllegalArgumentException("CEP não pode ser vazio");
        }
        if (neighborhood.isEmpty()) {
            throw new IllegalArgumentException("Bairro não pode ser vazio");
        }
        if (city.isEmpty()) {
            throw new IllegalArgumentException("Cidade não pode ser vazia");
        }
        if (state.isEmpty()) {
            throw new IllegalArgumentException("Estado não pode ser vazio");
        }
    }

    public String getStreet() {
        return street;
    }

    public String getNumber() {
        return number;
    }

    public String getZipcode() {
        return zipcode;
    }

    public String getNeighborhood() {
        return neighborhood;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }
}