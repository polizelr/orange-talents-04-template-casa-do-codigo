package br.com.zupacademy.rafaela.casadocodigo.Client;

import br.com.zupacademy.rafaela.casadocodigo.Country.Country;
import br.com.zupacademy.rafaela.casadocodigo.State.State;
import br.com.zupacademy.rafaela.casadocodigo.config.validation.ExistsId;
import br.com.zupacademy.rafaela.casadocodigo.config.validation.UniqueValue;
import br.com.zupacademy.rafaela.casadocodigo.config.validation.ValidCpfOrCnpj;
import org.springframework.lang.Nullable;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class ClientRequest {
    @NotBlank
    @Email
    @UniqueValue(domainClass = Client.class, fieldName = "email")
    private String email;

    @NotBlank
    private String name;

    @NotBlank
    private String lastName;

    @ValidCpfOrCnpj
    @UniqueValue(domainClass = Client.class, fieldName = "document")
    private String document;

    @NotBlank
    private String address;

    @NotBlank
    private String complement;

    @NotBlank
    private String city;

    @NotNull
    @ExistsId(domainClass = Country.class, fieldName = "id")
    private Long idCountry;

    private Long idState;

    @NotBlank
    private String telephone;

    @NotBlank
    private String zipCode;

    public ClientRequest(String email, String name, String lastName, String document, String address, String complement, String city, Long idCountry, Long idState, String telephone, String zipCode) {
        this.email = email;
        this.name = name;
        this.lastName = lastName;
        this.document = document;
        this.address = address;
        this.complement = complement;
        this.city = city;
        this.idCountry = idCountry;
        this.idState = idState;
        this.telephone = telephone;
        this.zipCode = zipCode;
    }

    public Long getIdCountry() {
        return idCountry;
    }

    public Long getIdState() {
        return idState;
    }

    public Client convert(Country country, @Nullable State state) {
        return new Client(email, name, lastName, document, address, complement,
                city, country, state, telephone, zipCode);
    }
}
