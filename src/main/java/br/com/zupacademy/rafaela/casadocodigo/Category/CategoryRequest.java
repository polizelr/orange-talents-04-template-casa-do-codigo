package br.com.zupacademy.rafaela.casadocodigo.Category;

import br.com.zupacademy.rafaela.casadocodigo.config.validation.UniqueValue;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotBlank;

public class CategoryRequest {
    @UniqueValue(domainClass = Category.class, fieldName = "name")
    @NotBlank
    private String name;

    public CategoryRequest(@JsonProperty("name") String name){
        this.name = name;
    }

    public Category convert(){
        return new Category(this.name);
    }

    public String getName() {
        return name;
    }
}


