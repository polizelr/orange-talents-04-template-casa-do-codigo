package br.com.zupacademy.rafaela.casadocodigo.Category;

import br.com.zupacademy.rafaela.casadocodigo.Author.AuthorDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("api/v1/categoria")
public class CategoryController {
    private final CategoryRepository categoryRepository;
    private UniqueCategoryValidator uniqueCategoryValidator;

    @Autowired
    public CategoryController(CategoryRepository categoryRepository, UniqueCategoryValidator uniqueCategoryValidator) {
        this.categoryRepository = categoryRepository;
        this.uniqueCategoryValidator = uniqueCategoryValidator;
    }

    @InitBinder
    public void init(WebDataBinder binder){
        binder.addValidators(uniqueCategoryValidator);
    }

    @PostMapping
    public ResponseEntity<CategoryDTO> addCategory(@RequestBody @Valid CategoryForm form){
        Category newCategory = form.convert();
        categoryRepository.save(newCategory);
        return ResponseEntity.ok().body(new CategoryDTO(newCategory));
    }
}
