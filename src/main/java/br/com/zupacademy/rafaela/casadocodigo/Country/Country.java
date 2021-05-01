package br.com.zupacademy.rafaela.casadocodigo.Country;

import javax.persistence.*;

@Entity
@Table(
        uniqueConstraints = {
                @UniqueConstraint(name="country_name_unique", columnNames = "name")
        }
)
public class Country {
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "country_sequence"
    )
    @SequenceGenerator(
            name = "country_sequence",
            sequenceName = "country_sequence",
            allocationSize = 1
    )
    private Long id;

    @Column(nullable = false)
    private String name;

    public Country(String name) {
        this.name = name;
    }

    public Country() {
    }

    public String getName() {
        return name;
    }

    public Long getId() {
        return id;
    }
}
