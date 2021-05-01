package br.com.zupacademy.rafaela.casadocodigo.State;

import br.com.zupacademy.rafaela.casadocodigo.Country.Country;
import br.com.zupacademy.rafaela.casadocodigo.config.validation.ExistsId;
import br.com.zupacademy.rafaela.casadocodigo.config.validation.UniqueValue;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class StateRequest {
    @NotBlank
    @UniqueValue(domainClass = State.class, fieldName = "name")
    private String name;

    @ExistsId(domainClass = Country.class, fieldName = "id")
    @NotNull
    private Long idCountry;

    public StateRequest(String name, Long idCountry) {
        this.name = name;
        this.idCountry = idCountry;
    }

    public Long getIdCountry() {
        return idCountry;
    }

    public State convert(Country country) {
        return new State(name, country);
    }
}
