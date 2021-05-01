package br.com.zupacademy.rafaela.casadocodigo.State;

import br.com.zupacademy.rafaela.casadocodigo.Country.Country;

import javax.persistence.*;

@Entity
@Table(
        uniqueConstraints = {
                @UniqueConstraint(name="state_name_unique", columnNames = "name")
        }
)
public class State {
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "state_sequence"
    )
    @SequenceGenerator(
            name = "state_sequence",
            sequenceName = "state_sequence",
            allocationSize = 1
    )
    private Long id;

    @Column(nullable = false)
    private String name;

    @ManyToOne(optional = false)
    @JoinColumn(
            name = "country_id",
            referencedColumnName = "id",
            foreignKey = @ForeignKey(name = "country_id_fk")
    )
    private Country country;

    public State(String name, Country country) {
        this.name = name;
        this.country = country;
    }

    @Deprecated
    public State() {
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Country getCountry() {
        return country;
    }
}
