package br.com.zupacademy.rafaela.casadocodigo.Country;


import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("api/v1/pais")
public class CountryController {
    private final CountryRepository countryRepository;

    @Autowired
    public CountryController(CountryRepository countryRepository){
        this.countryRepository = countryRepository;
    }

    @PostMapping
    public ResponseEntity<CountryResponse> addCountry (@RequestBody @Valid CountryRequest countryRequest){
        Country country = countryRequest.convert();
        countryRepository.save(country);
        return ResponseEntity.ok().body(new CountryResponse(country));
    }
}
