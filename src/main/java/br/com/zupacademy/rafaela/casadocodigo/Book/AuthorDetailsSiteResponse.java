package br.com.zupacademy.rafaela.casadocodigo.Book;

import br.com.zupacademy.rafaela.casadocodigo.Author.Author;

public class AuthorDetailsSiteResponse {
    private final String name;
    private final String description;

    public AuthorDetailsSiteResponse(Author author) {
        name = author.getName();
        description = author.getDescription();
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}
