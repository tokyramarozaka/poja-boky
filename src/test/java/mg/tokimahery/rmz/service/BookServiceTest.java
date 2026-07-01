package mg.tokimahery.rmz.service;

import static mg.tokimahery.rmz.model.BookFormat.HARD_COVER;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import java.util.Optional;
import java.util.UUID;
import mg.tokimahery.rmz.exception.NotFoundException;
import mg.tokimahery.rmz.model.Book;
import mg.tokimahery.rmz.model.BookCopy;
import mg.tokimahery.rmz.repository.ArrivalItemRepository;
import mg.tokimahery.rmz.repository.BookCopyRepository;
import mg.tokimahery.rmz.repository.SaleItemRepository;
import mg.tokimahery.rmz.repository.model.JBook;
import mg.tokimahery.rmz.repository.model.JBookCopy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class BookServiceTest {
  private Book harryPotter;
  private BookCopy harryPotterHardCover;
  private UUID harryPotterId;
  private UUID harryPotterHardCoverId;
  @InjectMocks private BookService subject;
  @Mock private ArrivalItemRepository arrivalItemRepository;
  @Mock private SaleItemRepository saleItemRepository;
  @Mock private BookCopyRepository bookCopyRepository;

  @BeforeEach
  void setUp() {
    harryPotterId = UUID.randomUUID();
    harryPotterHardCoverId = UUID.randomUUID();

    harryPotter =
        Book.builder().id(harryPotterId).title("Harry Potter and the Philosopher's Stone").build();
    harryPotterHardCover =
        BookCopy.builder().id(harryPotterHardCoverId).book(harryPotter).format(HARD_COVER).build();
  }

  @Test
  void getBookCopyStock_withValidBookAndCopy_shouldReturnCorrectStock() {
    var jpaHarryPotter = JBook.builder().id(harryPotter.id()).title(harryPotter.title()).build();
    var jpaHarryPotterHardCover =
        JBookCopy.builder().id(harryPotterHardCover.id()).book(jpaHarryPotter).build();

    when(bookCopyRepository.findById(harryPotterHardCoverId))
        .thenReturn(Optional.of(jpaHarryPotterHardCover));
    when(arrivalItemRepository.getTotalQuantity(harryPotterHardCoverId)).thenReturn(20);
    when(saleItemRepository.getTotalQuantity(harryPotterHardCoverId)).thenReturn(2);

    int stock = subject.getBookCopyStock(harryPotterId, harryPotterHardCoverId);
    assertEquals(18, stock);
  }

  @Test
  void getBookCopyStock_withNonExistingCopy_shouldThrow404() {
    when(bookCopyRepository.findById(harryPotterHardCoverId)).thenReturn(Optional.empty());
    assertThrows(
        NotFoundException.class,
        () -> subject.getBookCopyStock(harryPotterId, harryPotterHardCoverId));
  }

  @Test
  void getBookCopyStock_withCopyBelongingToAnotherBook_shouldThrow404() {
    var otherBook = JBook.builder().id(UUID.randomUUID()).title("Some other book").build();
    var jpaHarryPotterHardCover =
        JBookCopy.builder()
            .id(harryPotterHardCover.id())
            .book(otherBook)
            .format(HARD_COVER)
            .build();

    when(bookCopyRepository.findById(harryPotterHardCoverId))
        .thenReturn(Optional.of(jpaHarryPotterHardCover));

    assertThrows(
        NotFoundException.class,
        () -> subject.getBookCopyStock(harryPotterId, harryPotterHardCoverId));
  }
}
