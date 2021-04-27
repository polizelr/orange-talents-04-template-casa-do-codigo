package br.com.zupacademy.rafaela.casadocodigo.Category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Optional;

@Component
public class UniqueCategoryValidator implements Validator {

    private final CategoryRepository categoryRepository;

    @Autowired
    public UniqueCategoryValidator(CategoryRepository categoryRepository){
        this.categoryRepository = categoryRepository;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return CategoryForm.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        if(errors.hasErrors()){
            return;
        }
        CategoryForm categoryForm = (CategoryForm) o;
        Optional<Category> categoryByName = categoryRepository.findCategoryByName(categoryForm.getName());

        if(categoryByName.isPresent()){
            errors.rejectValue("name", null, "Category name must be unique");
        }

    }
}
