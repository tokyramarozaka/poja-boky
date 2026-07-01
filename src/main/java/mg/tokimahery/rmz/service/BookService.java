package mg.tokimahery.rmz.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import lombok.AllArgsConstructor;
import mg.tokimahery.rmz.exception.NotFoundException;
import mg.tokimahery.rmz.mapper.BookMapper;
import mg.tokimahery.rmz.model.Book;
import mg.tokimahery.rmz.model.BookCopy;
import mg.tokimahery.rmz.repository.ArrivalItemRepository;
import mg.tokimahery.rmz.repository.BookCopyRepository;
import mg.tokimahery.rmz.repository.BookRepository;
import mg.tokimahery.rmz.repository.SaleItemRepository;
import mg.tokimahery.rmz.repository.model.JBookCopy;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class BookService {
  private final BookMapper mapper;
  private final BookRepository repository;
  private final ArrivalItemRepository arrivalItemRepository;
  private final SaleItemRepository saleItemRepository;
  private final BookCopyRepository bookCopyRepository;

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

  public Map<BookCopy, Integer> getBookStock(UUID bookId) {
    var stockMap = new HashMap<BookCopy, Integer>();
    var book =
        repository
            .findById(bookId)
            .orElseThrow(() -> new NotFoundException("Book with id " + bookId + " not found"));
    var allBookCopies = bookCopyRepository.findAllByBook_Id(bookId);

    allBookCopies.forEach(
        bookCopy -> stockMap.put(bookCopy, getBookCopyStock(book.getId(), bookCopy.id())));

    return stockMap;
  }

  public int getBookCopyStock(UUID bookId, UUID bookCopyId) {
    var bookCopy = getBookCopyIfPresent(bookCopyId);

    if (!bookCopy.getBook().getId().equals(bookId)) {
      throw new NotFoundException(
          "Book copy with id " + bookCopyId + " not found for book with id: " + bookId);
    }

    return arrivalItemRepository.getTotalQuantity(bookCopyId)
        - saleItemRepository.getTotalQuantity(bookCopyId);
  }

  private JBookCopy getBookCopyIfPresent(UUID bookCopyId) {
    var bookCopy =
        bookCopyRepository
            .findById(bookCopyId)
            .orElseThrow(
                () -> new NotFoundException("Book copy with id " + bookCopyId + " not found."));
    return bookCopy;
  }
}
