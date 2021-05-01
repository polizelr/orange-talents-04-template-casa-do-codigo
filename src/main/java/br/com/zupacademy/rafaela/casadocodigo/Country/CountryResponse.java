package br.com.zupacademy.rafaela.casadocodigo.Country;

public class CountryResponse {
    private Long id;
    private String name;

    public CountryResponse(Country country){
        id = country.getId();
        name = country.getName();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
