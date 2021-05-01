package br.com.zupacademy.rafaela.casadocodigo.Author;

import br.com.zupacademy.rafaela.casadocodigo.config.validation.UniqueValue;

import javax.validation.constraints.*;

public class AuthorRequest {

    @NotBlank
    private String name;

    @Email
    @NotBlank
    @UniqueValue(domainClass = Author.class, fieldName = "email")
    private String email;

    @NotBlank
    @Size(max = 400)
    private String description;

    public AuthorRequest(String name, String email, String description) {
        this.name = name;
        this.email = email;
        this.description = description;
    }

    public Author convert(){
        return new Author(name, email, description);
    }

    public String getEmail() {
        return email;
    }
}
