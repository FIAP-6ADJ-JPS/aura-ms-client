package com.postech.auramsclient.adapters.dto;

import com.postech.auramsclient.domain.valueobject.CPF;

import java.time.LocalDate;
import java.util.List;

public class ClientDTO {
    private String firstName;
    private String lastName;
    private String cpf;
    private LocalDate birthDate;
    private List<AddressDTO> addresses;

    public ClientDTO() {
    }

    public ClientDTO(String firstName, String lastName, String cpf, LocalDate birthDate, List<AddressDTO> addresses) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.cpf = cpf;
        this.birthDate = birthDate;
        this.addresses = addresses;
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

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public List<AddressDTO> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<AddressDTO> addresses) {
        this.addresses = addresses;
    }
}