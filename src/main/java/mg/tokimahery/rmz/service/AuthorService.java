package mg.tokimahery.rmz.service;

import java.util.UUID;
import lombok.AllArgsConstructor;
import mg.tokimahery.rmz.exception.NotFoundException;
import mg.tokimahery.rmz.mapper.AuthorMapper;
import mg.tokimahery.rmz.model.Author;
import mg.tokimahery.rmz.repository.AuthorRepository;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AuthorService {
  private final AuthorRepository repository;
  private final AuthorMapper mapper;

  public Author getById(UUID id) {
    return mapper.toModel(
        repository
            .findById(id)
            .orElseThrow(() -> new NotFoundException("Author with id " + id + " not found")));
  }
}
