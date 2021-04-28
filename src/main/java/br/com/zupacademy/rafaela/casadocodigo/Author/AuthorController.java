package br.com.zupacademy.rafaela.casadocodigo.Author;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;

@RequestMapping("api/v1/autor")
@RestController
public class AuthorController {

    private final AuthorRepository authorRepository;

    @Autowired
    public AuthorController(AuthorRepository authorRepository){
        this.authorRepository = authorRepository;
    }

    @PostMapping
    public ResponseEntity<AuthorDTO> addAuthor(@Valid @RequestBody AuthorForm authorForm){
        Author author = authorForm.convert();
        authorRepository.save(author);

        return ResponseEntity.ok().body(new AuthorDTO(author));
    }

}
