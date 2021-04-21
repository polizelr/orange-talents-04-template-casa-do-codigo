package br.com.zupacademy.rafaela.casadocodigo.Author;


import javax.validation.constraints.*;

public class AuthorForm {
    @NotNull
    @NotEmpty
    @NotBlank
    private String Name;

    @Email
    @NotNull
    @NotEmpty
    @NotBlank
    private String Email;

    @NotNull
    @NotEmpty
    @NotBlank
    @Size(max = 400)
    private String Description;

    public void setName(String name) {
        Name = name;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public Author convert(){
        return new Author(Name, Email, Description);
    }
}
