package mg.tokimahery.rmz.service;

import java.util.List;
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

  public List<Author> getAll() {
    return mapper.toModel(repository.findAll());
  }

  public List<Author> create(List<Author> authors) {
    return authors.stream().map(this::create).toList();
  }

  public Author create(Author author) {
    var authorEntity = mapper.toEntity(author);
    return mapper.toModel(repository.save(authorEntity));
  }
}
