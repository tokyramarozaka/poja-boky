package mg.tokimahery.rmz.endpoint.rest.controller;

import static org.springframework.http.HttpStatus.CREATED;

import java.util.List;
import java.util.UUID;
import lombok.AllArgsConstructor;
import mg.tokimahery.rmz.model.Book;
import mg.tokimahery.rmz.model.BookCopy;
import mg.tokimahery.rmz.service.BookCopyService;
import mg.tokimahery.rmz.service.BookService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class BookController {
  private final BookService service;
  private final BookCopyService bookCopyService;

  @GetMapping("/books")
  public List<Book> getBooks() {
    return service.findAll();
  }

  @GetMapping("/books/{id}")
  public Book getBookById(@PathVariable("id") UUID id) {
    return service.findById(id);
  }

  @GetMapping("/books/{id}/copies")
  public List<BookCopy> getBookCopies(@PathVariable UUID id) {
    return bookCopyService.getAllByBookId(id);
  }

  @PostMapping
  @ResponseStatus(CREATED)
  public List<Book> create(@RequestBody List<Book> toSave) {
    return service.create(toSave);
  }
}
