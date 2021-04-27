package br.com.zupacademy.rafaela.casadocodigo.Category;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotBlank;

public class CategoryForm {
    @NotBlank
    private String name;

    public CategoryForm(@JsonProperty("name") String name){
        this.name = name;
    }

    public Category convert(){
        return new Category(this.name);
    }

    public String getName() {
        return name;
    }
}


