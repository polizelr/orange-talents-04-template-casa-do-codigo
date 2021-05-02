package br.com.zupacademy.rafaela.casadocodigo.Client;

import br.com.zupacademy.rafaela.casadocodigo.Country.Country;
import br.com.zupacademy.rafaela.casadocodigo.Country.CountryRepository;
import br.com.zupacademy.rafaela.casadocodigo.State.State;
import br.com.zupacademy.rafaela.casadocodigo.State.StateRepository;
import br.com.zupacademy.rafaela.casadocodigo.config.validation.CountryStateValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Validator;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("api/v1/cliente")
public class ClientController {
    private final ClientRepository clientRepository;
    private final CountryRepository countryRepository;
    private final StateRepository stateRepository;
    private CountryStateValidator countryStateValidator;

    @Autowired
    public ClientController(ClientRepository clientRepository,
                            CountryRepository countryRepository,
                            StateRepository stateRepository,
                            CountryStateValidator countryStateValidator){
        this.clientRepository = clientRepository;
        this.countryRepository = countryRepository;
        this.stateRepository = stateRepository;
        this.countryStateValidator = countryStateValidator;
    }

    @InitBinder
    public void init(WebDataBinder binder){
        binder.addValidators(countryStateValidator);
    }


    @PostMapping
    public ResponseEntity<ClientResponse> addClient(@Valid @RequestBody ClientRequest clientRequest){
        Client client;
        Country country = countryRepository.findById(clientRequest.getIdCountry()).get();

        if(clientRequest.getIdState() != null){
            State state = stateRepository.findById(clientRequest.getIdState()).get();
            client = clientRequest.convert(country, state);
        }
        else{
            client = clientRequest.convert(country, null);
        }

        clientRepository.save(client);
        return ResponseEntity.ok().body(new ClientResponse(client));
    }
}
