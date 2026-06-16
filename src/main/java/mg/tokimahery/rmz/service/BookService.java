package mg.tokimahery.rmz.service;

import java.util.List;
import java.util.UUID;
import lombok.AllArgsConstructor;
import mg.tokimahery.rmz.exception.NotFoundException;
import mg.tokimahery.rmz.mapper.BookMapper;
import mg.tokimahery.rmz.model.Book;
import mg.tokimahery.rmz.repository.BookRepository;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class BookService {
  private final BookRepository repository;
  private final BookMapper mapper;

  public List<Book> findAll() {
    return mapper.toModel(repository.findAll());
  }

  public Book findById(UUID id) {
    return mapper.toModel(
        repository
            .findById(id)
            .orElseThrow(() -> new NotFoundException("Book with id " + id + " not found")));
  }

  public List<Book> create(List<Book> toSave) {
    var savedJBook = repository.saveAll(mapper.toEntity(toSave));
    return mapper.toModel(savedJBook);
  }
}
