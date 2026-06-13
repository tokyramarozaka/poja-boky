package mg.tokimahery.rmz.service;

import java.util.List;
import lombok.AllArgsConstructor;
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

  public Book findById(String id) {
    return mapper.toModel(
        repository
            .findById(id)
            .orElseThrow(() -> new RuntimeException("Book with id " + id + " not found")));
  }

  public List<Book> create(List<Book> toSave) {
    var savedJBook = repository.saveAll(mapper.toEntity(toSave));
    return mapper.toModel(savedJBook);
  }
}
