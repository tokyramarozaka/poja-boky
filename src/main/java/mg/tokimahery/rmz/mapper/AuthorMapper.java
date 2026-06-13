package mg.tokimahery.rmz.mapper;

import java.util.List;
import mg.tokimahery.rmz.model.Author;
import mg.tokimahery.rmz.repository.model.JAuthor;
import org.springframework.stereotype.Component;

@Component
public class AuthorMapper {
  public List<Author> toModel(List<JAuthor> jAuthors) {
    return jAuthors.stream().map(this::toModel).toList();
  }

  public Author toModel(JAuthor jAuthor) {
    return Author.builder()
        .id(jAuthor.getId())
        .fullName(jAuthor.getFullName())
        .mainLanguage(jAuthor.getMainLanguage())
        .build();
  }

  public List<JAuthor> toEntity(List<Author> authors) {
    return authors.stream().map(this::toEntity).toList();
  }

  public JAuthor toEntity(Author author) {
    return JAuthor.builder()
        .id(author.id())
        .fullName(author.fullName())
        .mainLanguage(author.mainLanguage())
        .build();
  }
}
