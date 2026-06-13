package mg.tokimahery.rmz.mapper;

import java.util.List;
import lombok.AllArgsConstructor;
import mg.tokimahery.rmz.model.Book;
import mg.tokimahery.rmz.repository.model.JBook;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class BookMapper {
  public final GenreMapper genreMapper;
  public final AuthorMapper authorMapper;

  public List<Book> toModel(List<JBook> jBooks) {
    return jBooks.stream().map(this::toModel).toList();
  }

  public Book toModel(JBook jBook) {
    return Book.builder()
        .id(jBook.getId())
        .title(jBook.getTitle())
        .isbn(jBook.getIsbn())
        .pages(jBook.getPages())
        .genres(genreMapper.toModel(jBook.getGenres()))
        .authors(authorMapper.toModel(jBook.getAuthors()))
        .build();
  }

  public List<JBook> toEntity(List<Book> books) {
    return books.stream().map(this::toEntity).toList();
  }

  public JBook toEntity(Book book) {
    return JBook.builder()
        .id(book.id())
        .title(book.title())
        .pages(book.pages())
        .genres(genreMapper.toEntity(book.genres()))
        .authors(authorMapper.toEntity(book.authors()))
        .isbn(book.isbn())
        .build();
  }
}
