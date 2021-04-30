package br.com.zupacademy.rafaela.casadocodigo.Book;

import br.com.zupacademy.rafaela.casadocodigo.Author.Author;
import br.com.zupacademy.rafaela.casadocodigo.Author.AuthorRepository;
import br.com.zupacademy.rafaela.casadocodigo.Category.Category;
import br.com.zupacademy.rafaela.casadocodigo.Category.CategoryRepository;
import br.com.zupacademy.rafaela.casadocodigo.config.validation.ExistsId;
import br.com.zupacademy.rafaela.casadocodigo.config.validation.UniqueValue;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.util.Date;

public class BookRequest {
    @NotBlank
    @UniqueValue(domainClass = Book.class, fieldName = "title")
    private String title;

    @NotBlank
    @Size(max = 500)
    private String synopsis;

    private String summary;

    @NotNull
    @DecimalMin("20.00")
    private BigDecimal price;

    @NotNull
    @Min(100)
    private Integer numberOfPages;

    @NotBlank
    @UniqueValue(domainClass = Book.class, fieldName = "isbn")
    private String isbn;

    @JsonFormat(pattern = "yyyy-MM-dd", shape = JsonFormat.Shape.STRING)
    @Future
    private Date publishingDate;

    @NotNull
    @ExistsId(domainClass = Category.class, fieldName = "id")
    private Long idCategory;

    @NotNull
    @ExistsId(domainClass = Author.class, fieldName = "id")
    private Long idAuthor;

    public BookRequest(String title, String synopsis, String summary, BigDecimal price, Integer numberOfPages, String isbn, Date publishingDate, Long idCategory, Long idAuthor) {
        this.title = title;
        this.synopsis = synopsis;
        this.summary = summary;
        this.price = price;
        this.numberOfPages = numberOfPages;
        this.isbn = isbn;
        this.publishingDate = publishingDate;
        this.idCategory = idCategory;
        this.idAuthor = idAuthor;
    }

    public Book convert(Author author, Category category) {
        return new Book(title, synopsis, summary, price, numberOfPages, isbn, publishingDate, category, author);
    }

    public Long getIdCategory() {
        return idCategory;
    }

    public Long getIdAuthor() {
        return idAuthor;
    }
}
