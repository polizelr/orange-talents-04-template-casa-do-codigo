package br.com.zupacademy.rafaela.casadocodigo.Country;

import br.com.zupacademy.rafaela.casadocodigo.config.validation.UniqueValue;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotBlank;

public class CountryRequest {
    @NotBlank
    @UniqueValue(domainClass = Country.class, fieldName = "name")
    private String name;

    public CountryRequest(@JsonProperty("name") String name){
        this.name = name;
    }

    public Country convert(){
        return new Country(name);
    }
}

