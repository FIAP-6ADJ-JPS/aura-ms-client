package com.postech.auramsclient.domain;

import com.postech.auramsclient.domain.valueobject.CPF;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.Objects;

public class Client {
    private String firstName;
    private String lastName;
    private CPF cpf;
    private LocalDate birthDate;
    private List<Address> addresses;

    public Client(){}

    public Client(String firstName, String lastName, CPF cpf, LocalDate birthDate, List<Address> addresses) {
        this.firstName = Objects.requireNonNull(firstName, "First name cannot be null");
        this.lastName = Objects.requireNonNull(lastName, "Last name cannot be null");
        this.cpf = Objects.requireNonNull(cpf, "CPF cannot be null");
        this.birthDate = Objects.requireNonNull(birthDate, "Birth date cannot be null");
        this.addresses = Objects.requireNonNull(addresses, "Addresses cannot be null");
        validate();
    }

    public boolean isAdult() {
        return Period.between(birthDate, LocalDate.now()).getYears() >= 18;
    }

    private void validate() {
        if (!cpf.isValid()) {
            throw new IllegalArgumentException("Invalid CPF");
        }
        if (firstName.isEmpty()) {
            throw new IllegalArgumentException("First name cannot be empty");
        }
        if (lastName.isEmpty()) {
            throw new IllegalArgumentException("Last name cannot be empty");
        }
        if (addresses.isEmpty()) {
            throw new IllegalArgumentException("Addresses cannot be empty");
        }
        if (!isAdult()) {
            throw new IllegalArgumentException("Client must be an adult");
        }
    }

    public void addAddress(Address address) {
        Objects.requireNonNull(address, "Address cannot be null");
        this.addresses.add(address);
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public CPF getCpf() {
        return cpf;
    }

    public void setCpf(CPF cpf) {
        this.cpf = cpf;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public List<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }
}