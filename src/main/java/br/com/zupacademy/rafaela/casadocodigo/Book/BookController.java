package br.com.zupacademy.rafaela.casadocodigo.Book;

import br.com.zupacademy.rafaela.casadocodigo.Author.Author;
import br.com.zupacademy.rafaela.casadocodigo.Author.AuthorRepository;
import br.com.zupacademy.rafaela.casadocodigo.Category.Category;
import br.com.zupacademy.rafaela.casadocodigo.Category.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Optional;

@RequestMapping("api/v1/livro")
@RestController
public class BookController {
    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;
    private final CategoryRepository categoryRepository;

    @Autowired
    public BookController(BookRepository bookRepository, AuthorRepository authorRepository, CategoryRepository categoryRepository){
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
        this.categoryRepository = categoryRepository;
    }

    @PostMapping
    public ResponseEntity<BookResponse> addBook(@Valid @RequestBody BookRequest bookRequest) {
        Author author = authorRepository.findById(bookRequest.getIdAuthor()).get();
        Category category = categoryRepository.findById(bookRequest.getIdCategory()).get();

        Book book = bookRequest.convert(author, category);
        bookRepository.save(book);
        return ResponseEntity.ok().body(new BookResponse(book));
    }

}