package br.com.zupacademy.rafaela.casadocodigo.Book;

import java.math.BigDecimal;
import java.util.Date;

public class BookResponse {
    private Long id;

    private String title;

    private String synopsis;

    private String summary;

    private BigDecimal price;

    private Integer numberOfPages;

    private String isbn;

    private Date publishingDate;

    private Long idCategory;

    private Long idAuthor;

    public BookResponse (Book book){
        this.id = book.getId();
        this.title = book.getTitle();
        this.synopsis = book.getSynopsis();
        this.summary = book.getSummary();
        this.price = book.getPrice();
        this.numberOfPages = book.getNumberOfPages();
        this.isbn = book.getIsbn();
        this.publishingDate = book.getPublishingDate();
        this.idCategory = book.getCategory().getId();
        this.idAuthor = book.getAuthor().getId();
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public String getSummary() {
        return summary;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public Integer getNumberOfPages() {
        return numberOfPages;
    }

    public String getIsbn() {
        return isbn;
    }

    public Date getPublishingDate() {
        return publishingDate;
    }

    public Long getIdCategory() {
        return idCategory;
    }

    public Long getIdAuthor() {
        return idAuthor;
    }
}
