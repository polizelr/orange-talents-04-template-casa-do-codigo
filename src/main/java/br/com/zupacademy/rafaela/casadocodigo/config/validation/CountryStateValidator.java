package br.com.zupacademy.rafaela.casadocodigo.config.validation;

import br.com.zupacademy.rafaela.casadocodigo.Client.ClientRequest;
import br.com.zupacademy.rafaela.casadocodigo.Country.CountryRepository;
import br.com.zupacademy.rafaela.casadocodigo.State.State;
import br.com.zupacademy.rafaela.casadocodigo.State.StateProjection;
import br.com.zupacademy.rafaela.casadocodigo.State.StateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.List;
import java.util.stream.Collectors;


@Component
public class CountryStateValidator implements Validator {
    private StateRepository stateRepository;

    @Autowired
    public CountryStateValidator(StateRepository stateRepository){
        this.stateRepository = stateRepository;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return ClientRequest.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        if(errors.hasErrors()){
            return;
        }

        ClientRequest request = (ClientRequest) o;

        List<StateProjection> countryStatesId = stateRepository.findStateIdByCountryId(request.getIdCountry());
        List<Long> statesId = countryStatesId.stream().map(state -> state.getId()).collect(Collectors.toList());

        if(!statesId.isEmpty() && request.getIdState() == null){
            errors.rejectValue("idState", null, "This country has states. You must inform it.");
        }
        else if((statesId.isEmpty() && request.getIdState() != null) ||
                (!statesId.isEmpty() && !statesId.contains(request.getIdState()))){
            errors.rejectValue("idState", null, "This state doesn't belong to the country informed.");
        }

    }
}
