package mg.tokimahery.rmz.service;

import java.util.List;
import java.util.UUID;
import lombok.AllArgsConstructor;
import mg.tokimahery.rmz.mapper.BookCopyMapper;
import mg.tokimahery.rmz.model.BookCopy;
import mg.tokimahery.rmz.repository.BookCopyRepository;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class BookCopyService {
  private final BookCopyRepository repository;
  private final BookCopyMapper mapper;

  public BookCopy findById(UUID id) {
    return mapper.toModel(repository.findById(id).orElseThrow());
  }

  public List<BookCopy> create(List<BookCopy> bookCopies) {
    return bookCopies.stream().map(this::create).toList();
  }

  public BookCopy create(BookCopy bookCopy) {
    return mapper.toModel(repository.save(mapper.toEntity(bookCopy)));
  }

  public List<BookCopy> getAllByBookId(UUID bookId) {
    return repository.findAllByBook_Id(bookId);
  }
}
