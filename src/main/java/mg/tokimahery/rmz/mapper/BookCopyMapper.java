package mg.tokimahery.rmz.mapper;

import lombok.AllArgsConstructor;
import mg.tokimahery.rmz.model.BookCopy;
import mg.tokimahery.rmz.repository.model.JBookCopy;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class BookCopyMapper {
  private final BookMapper bookMapper;
  private final PriceHistoryMapper priceHistoryMapper;

  public BookCopy toModel(JBookCopy jBookCopy) {
    return BookCopy.builder()
        .id(jBookCopy.getId())
        .book(bookMapper.toModel(jBookCopy.getBook()))
        .format(jBookCopy.getFormat())
        .priceHistories(priceHistoryMapper.toModel(jBookCopy.getPriceHistories()))
        .language(jBookCopy.getLanguage())
        .build();
  }

  public JBookCopy toEntity(BookCopy bookCopy) {
    return JBookCopy.builder()
        .id(bookCopy.id())
        .book(bookMapper.toEntity(bookCopy.book()))
        .format(bookCopy.format())
        .language(bookCopy.language())
        .build();
  }
}
