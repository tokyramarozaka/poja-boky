package mg.tokimahery.rmz.endpoint.rest.controller;

import static org.springframework.http.HttpStatus.CREATED;

import java.util.List;
import java.util.Map;
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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/books")
@AllArgsConstructor
public class BookController {
  private final BookService service;
  private final BookCopyService bookCopyService;

  @GetMapping
  public List<Book> getBooks() {
    return service.findAll();
  }

  @GetMapping("/{bookId}")
  public Book getBookById(@PathVariable UUID bookId) {
    return service.findById(bookId);
  }

  @GetMapping("/{bookId}/copies")
  public List<BookCopy> getBookCopies(@PathVariable UUID bookId) {
    return bookCopyService.getAllByBookId(bookId);
  }

  @GetMapping("/{bookId}/stock")
  public Map<BookCopy, Integer> getBookStock(@PathVariable UUID bookId) {
    return service.getBookStock(bookId);
  }

  @GetMapping("/{bookId}/copies/{bookCopyId}/stock")
  public int getBookCopyStock(@PathVariable UUID bookId, @PathVariable UUID bookCopyId) {
    return service.getBookCopyStock(bookId, bookCopyId);
  }

  @PostMapping
  @ResponseStatus(CREATED)
  public List<Book> create(@RequestBody List<Book> toSave) {
    return service.create(toSave);
  }
}
