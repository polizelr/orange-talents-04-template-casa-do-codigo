package br.com.zupacademy.rafaela.casadocodigo.Client;

import org.springframework.lang.Nullable;

import java.util.Optional;

public class ClientResponse {

    private Long id;

    private String email;

    private String name;

    private String lastName;

    private String document;

    private String address;

    private String complement;

    private String city;

    private String country;

    private Optional<String> state;

    private String telephone;

    private String zipCode;

    public ClientResponse(Client client){
        id = client.getId();
        email = client.getEmail();
        name = client.getName();
        lastName = client.getLastName();
        document = client.getDocument();
        address = client.getAddress();
        complement = client.getComplement();
        city = client.getCity();
        country = client.getCountry().getName();
        state = client.getState() != null ? Optional.of(client.getState().getName()) : Optional.empty();
        telephone = client.getTelephone();
        zipCode = client.getZipCode();
    }

    public Long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public String getDocument() {
        return document;
    }

    public String getAddress() {
        return address;
    }

    public String getComplement() {
        return complement;
    }

    public String getCity() {
        return city;
    }

    public String getCountry() {
        return country;
    }

    public Optional<String> getState() {
        return state;
    }

    public String getTelephone() {
        return telephone;
    }

    public String getZipCode() {
        return zipCode;
    }
}
