package br.com.zupacademy.rafaela.casadocodigo.Client;

import br.com.zupacademy.rafaela.casadocodigo.Country.Country;
import br.com.zupacademy.rafaela.casadocodigo.State.State;

import javax.persistence.*;

@Entity
@Table(
        uniqueConstraints = {
                @UniqueConstraint(name = "email_unique", columnNames = "email"),
                @UniqueConstraint(name = "document_unique", columnNames = "document")
        }
)
public class Client {
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "client_sequence"
    )
    @SequenceGenerator(
            name= "client_sequence",
            sequenceName = "client_sequence",
            allocationSize = 1
    )
    private Long id;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String lastName;

    @Column(nullable = false)
    private String document;

    @Column(nullable = false)
    private String address;

    @Column(nullable = false)
    private String complement;

    @Column(nullable = false)
    private String city;

    @ManyToOne(optional = false)
    @JoinColumn(
            name = "country_id",
            referencedColumnName = "id",
            foreignKey = @ForeignKey(name = "country_id_fk")
    )
    private Country country;

    @ManyToOne
    @JoinColumn(
            name = "state_id",
            referencedColumnName = "id",
            foreignKey = @ForeignKey(name = "state_id_fk")
    )
    private State state;

    @Column(nullable = false)
    private String telephone;

    @Column(nullable = false)
    private String zipCode;

    public Client(String email, String name, String lastName, String document, String address, String complement, String city, Country country, State state, String telephone, String zipCode) {
        this.email = email;
        this.name = name;
        this.lastName = lastName;
        this.document = document;
        this.address = address;
        this.complement = complement;
        this.city = city;
        this.country = country;
        this.state = state;
        this.telephone = telephone;
        this.zipCode = zipCode;
    }

    @Deprecated
    public Client() {
    }

    public Long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public String getDocument() {
        return document;
    }

    public String getAddress() {
        return address;
    }

    public String getComplement() {
        return complement;
    }

    public String getCity() {
        return city;
    }

    public Country getCountry() {
        return country;
    }

    public State getState() {
        return state;
    }

    public String getTelephone() {
        return telephone;
    }

    public String getZipCode() {
        return zipCode;
    }
}
