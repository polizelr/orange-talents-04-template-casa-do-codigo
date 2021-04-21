package br.com.zupacademy.rafaela.casadocodigo.Author;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Author {
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "author_sequence"
    )
    @SequenceGenerator(
            name = "author_sequence",
            sequenceName = "author_sequence",
            allocationSize = 1
    )
    private Long Id;

    @Column(nullable = false)
    private String Name;

    @Column(nullable = false)
    private String Email;

    @Column(
            nullable = false,
            length = 400
    )
    private String Description;

    @Column(
            nullable = false,
            columnDefinition = "TIMESTAMP WITHOUT TIME ZONE"
    )
    private LocalDateTime CreatedAt;

    public Author(String name, String email, String description) {
        Name = name;
        Email = email;
        Description = description;
        CreatedAt = LocalDateTime.now();
    }

    public Long getId() {
        return Id;
    }

    public String getName() {
        return Name;
    }

    public String getEmail() {
        return Email;
    }

    public String getDescription() {
        return Description;
    }

    public LocalDateTime getCreatedAt() {
        return CreatedAt;
    }
}
