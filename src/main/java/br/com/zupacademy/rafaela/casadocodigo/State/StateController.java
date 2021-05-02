package br.com.zupacademy.rafaela.casadocodigo.State;

import br.com.zupacademy.rafaela.casadocodigo.Country.Country;
import br.com.zupacademy.rafaela.casadocodigo.Country.CountryRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@RequestMapping("api/v1/estado")
public class StateController {
    private final StateRepository stateRepository;
    private final CountryRepository countryRepository;

    public StateController(StateRepository stateRepository, CountryRepository countryRepository){
        this.countryRepository = countryRepository;
        this.stateRepository = stateRepository;
    }

    @PostMapping
    @Transactional
    public ResponseEntity<StateResponse> addState(@Valid @RequestBody StateRequest stateRequest){
        Country country = countryRepository.findById(stateRequest.getIdCountry()).get();
        State state = stateRequest.convert(country);
        stateRepository.save(state);

        return ResponseEntity.ok().body(new StateResponse(state));
    }
}
