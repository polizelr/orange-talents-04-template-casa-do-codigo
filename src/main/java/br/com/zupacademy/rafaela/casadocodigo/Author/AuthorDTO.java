package br.com.zupacademy.rafaela.casadocodigo.Author;

import java.time.LocalDateTime;

public class AuthorDTO {
    private Long Id;

    private String Name;

    private String Email;

    private String Description;

    private LocalDateTime CreatedAt;

   public AuthorDTO(Author author){
       this.Id = author.getId();
       this.Name = author.getName();
       this.Email = author.getEmail();
       this.Description = author.getDescription();
       this.CreatedAt = author.getCreatedAt();
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
