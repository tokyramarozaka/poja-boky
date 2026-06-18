package mg.tokimahery.rmz.endpoint.rest.controller;

import static org.springframework.http.HttpStatus.CREATED;

import java.util.List;
import java.util.UUID;
import lombok.AllArgsConstructor;
import mg.tokimahery.rmz.model.BookCopy;
import mg.tokimahery.rmz.service.BookCopyService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class BookCopyController {
  private final BookCopyService service;

  @GetMapping("/book-copy/{id}")
  public BookCopy findById(UUID id) {
    return service.findById(id);
  }

  @PostMapping("/book-copy")
  @ResponseStatus(CREATED)
  public List<BookCopy> save(@RequestBody List<BookCopy> bookCopies) {
    return service.create(bookCopies);
  }
}
