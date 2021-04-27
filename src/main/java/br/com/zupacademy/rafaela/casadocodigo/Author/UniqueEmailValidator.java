package br.com.zupacademy.rafaela.casadocodigo.Author;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Optional;


@Component
public class UniqueEmailValidator implements Validator {
    private final AuthorRepository authorRepository;

    @Autowired
    public UniqueEmailValidator(AuthorRepository authorRepository){
        this.authorRepository = authorRepository;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return AuthorForm.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        if(errors.hasErrors()){
            return;
        }
        AuthorForm form = (AuthorForm) o;
        Optional<Author> authorByEmail = authorRepository.findAuthorByEmail(form.getEmail());

        if(authorByEmail.isPresent()){
            errors.rejectValue("email", null, "Email must be unique");
        }
    }
}
