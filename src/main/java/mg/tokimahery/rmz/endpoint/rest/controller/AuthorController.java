package mg.tokimahery.rmz.endpoint.rest.controller;

import java.util.UUID;
import lombok.AllArgsConstructor;
import mg.tokimahery.rmz.model.Author;
import mg.tokimahery.rmz.service.AuthorService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class AuthorController {
  private final AuthorService service;

  @GetMapping("/authors/{id}")
  public Author getById(UUID id) {
    return service.getById(id);
  }
}
