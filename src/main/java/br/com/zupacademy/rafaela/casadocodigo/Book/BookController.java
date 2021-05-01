package br.com.zupacademy.rafaela.casadocodigo.Book;

import br.com.zupacademy.rafaela.casadocodigo.Author.Author;
import br.com.zupacademy.rafaela.casadocodigo.Author.AuthorRepository;
import br.com.zupacademy.rafaela.casadocodigo.Category.Category;
import br.com.zupacademy.rafaela.casadocodigo.Category.CategoryRepository;
import br.com.zupacademy.rafaela.casadocodigo.config.validation.ExistsId;
import br.com.zupacademy.rafaela.casadocodigo.config.validation.UniqueValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.validation.Valid;
import java.util.Optional;


@RequestMapping("api/v1/livro")
@RestController
@Validated
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

    @GetMapping
    public Page<BookResponse> getBooks(Pageable pagination){
        Page<Book> books = bookRepository.findAll(pagination);
        return BookResponse.convert(books);
    }

    @GetMapping("/{id}")
//    TODO: @ExistsId doesn't work yet
    public ResponseEntity<BookDetailsSiteResponse> getBook(@PathVariable("id") @ExistsId(domainClass = Book.class, fieldName = "id") Long id){
        Book book = bookRepository.findById(id).get();
        return ResponseEntity.ok().body(new BookDetailsSiteResponse(book));
    }

}
