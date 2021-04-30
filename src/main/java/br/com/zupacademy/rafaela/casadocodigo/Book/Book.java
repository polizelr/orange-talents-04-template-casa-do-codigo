package br.com.zupacademy.rafaela.casadocodigo.Book;

import br.com.zupacademy.rafaela.casadocodigo.Author.Author;
import br.com.zupacademy.rafaela.casadocodigo.Category.Category;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(
        uniqueConstraints = {
                @UniqueConstraint(name = "book_title_unique", columnNames = "title"),
                @UniqueConstraint(name= "book_isbn_unique", columnNames = "isbn")
        }
)
public class Book {
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "book_sequence"
    )
    @SequenceGenerator(
            name= "book_sequence",
            sequenceName = "book_sequence",
            allocationSize = 1
    )
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(
            nullable = false,
            length = 500
    )
    private String synopsis;

    @Column(columnDefinition = "text")
    private String summary;

    @Column(nullable = false)
    @DecimalMin("20.00")
    private BigDecimal price;

    @Column(nullable = false)
    @Min(100)
    private Integer numberOfPages;

    @Column(nullable = false)
    private String isbn;

    @Column(columnDefinition = "date")
    private Date publishingDate;

    @ManyToOne(optional = false)
    @JoinColumn(
            name = "category_id",
            referencedColumnName = "id",
            foreignKey = @ForeignKey(name = "category_id_fk")
    )
    private Category category;

    @ManyToOne(optional = false)
    @JoinColumn(
            name = "author_id",
            referencedColumnName = "id",
            foreignKey = @ForeignKey(name = "author_id_fk")
    )
    private Author author;

    public Book(String title, String synopsis, String summary, BigDecimal price, Integer numberOfPages, String isbn, Date publishingDate, Category category, Author author) {
        this.title = title;
        this.synopsis = synopsis;
        this.summary = summary;
        this.price = price;
        this.numberOfPages = numberOfPages;
        this.isbn = isbn;
        this.publishingDate = publishingDate;
        this.category = category;
        this.author = author;
    }

    @Deprecated
    public Book() {
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

    public Category getCategory() {
        return category;
    }

    public Author getAuthor() {
        return author;
    }
}
