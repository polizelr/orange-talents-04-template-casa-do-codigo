package br.com.zupacademy.rafaela.casadocodigo.Book;

import java.math.BigDecimal;

public class BookDetailsSiteResponse {
    private final AuthorDetailsSiteResponse author;
    private final String isbn;
    private final Integer numberOfPages;
    private final BigDecimal price;
    private final String summary;
    private final String synopsis;
    private final String title;

    public BookDetailsSiteResponse(Book book) {
        author = new AuthorDetailsSiteResponse(book.getAuthor());
        isbn = book.getIsbn();
        numberOfPages = book.getNumberOfPages();
        price = book.getPrice();
        summary = book.getSummary();
        synopsis = book.getSynopsis();
        title = book.getTitle();
    }

    public AuthorDetailsSiteResponse getAuthor() {
        return author;
    }

    public String getIsbn() {
        return isbn;
    }

    public Integer getNumberOfPages() {
        return numberOfPages;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public String getSummary() {
        return summary;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public String getTitle() {
        return title;
    }
}
