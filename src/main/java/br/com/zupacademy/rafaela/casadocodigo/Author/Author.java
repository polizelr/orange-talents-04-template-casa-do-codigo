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

}
