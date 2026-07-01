package mg.tokimahery.rmz.endpoint.rest.controller;

import static org.springframework.http.HttpStatus.CREATED;

import java.util.List;
import java.util.UUID;
import lombok.AllArgsConstructor;
import mg.tokimahery.rmz.model.Author;
import mg.tokimahery.rmz.service.AuthorService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/authors")
@AllArgsConstructor
public class AuthorController {
  private final AuthorService service;

  @GetMapping("/")
  public List<Author> getAllAuthors() {
    return service.getAll();
  }

  @GetMapping("/{id}")
  public Author getById(@PathVariable UUID id) {
    return service.getById(id);
  }

  @PostMapping
  @ResponseStatus(CREATED)
  public List<Author> create(List<Author> authors) {
    return service.create(authors);
  }
}
