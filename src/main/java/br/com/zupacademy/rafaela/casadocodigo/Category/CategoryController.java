package br.com.zupacademy.rafaela.casadocodigo.Category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("api/v1/categoria")
public class CategoryController {
    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryController(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @PostMapping
    public ResponseEntity<CategoryDTO> addCategory(@RequestBody @Valid CategoryForm form){
        Category newCategory = form.convert();
        categoryRepository.save(newCategory);
        return ResponseEntity.ok().body(new CategoryDTO(newCategory));
    }
}
