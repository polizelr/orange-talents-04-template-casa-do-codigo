package br.com.zupacademy.rafaela.casadocodigo.State;

import br.com.zupacademy.rafaela.casadocodigo.Country.CountryResponse;

public class StateResponse {
    private Long id;
    private String name;
    private CountryResponse country;

    public StateResponse(State state){
        id = state.getId();
        name = state.getName();
        country = new CountryResponse(state.getCountry());
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public CountryResponse getCountry() {
        return country;
    }
}
