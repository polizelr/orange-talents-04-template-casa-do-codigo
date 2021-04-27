package br.com.zupacademy.rafaela.casadocodigo.Author;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.persistence.UniqueConstraint;
import javax.validation.Valid;

@RequestMapping("api/v1/autor")
@RestController
public class AuthorController {

    private final AuthorRepository authorRepository;
    private UniqueEmailValidator uniqueEmailValidator;

    @Autowired
    public AuthorController(AuthorRepository authorRepository, UniqueEmailValidator uniqueEmailValidator){
        this.authorRepository = authorRepository;
        this.uniqueEmailValidator = uniqueEmailValidator;
    }

    @InitBinder
    public void init(WebDataBinder binder){
        binder.addValidators(uniqueEmailValidator);
    }

    @PostMapping
    public ResponseEntity<AuthorDTO> addAuthor(@Valid @RequestBody AuthorForm authorForm){
        Author author = authorForm.convert();
        authorRepository.save(author);

        return ResponseEntity.ok().body(new AuthorDTO(author));
    }

}
