package mg.tokimahery.rmz.mapper;

import java.util.List;
import mg.tokimahery.rmz.model.Genre;
import mg.tokimahery.rmz.repository.model.JGenre;
import org.springframework.stereotype.Component;

@Component
public class GenreMapper {
  public List<Genre> toModel(List<JGenre> genres) {
    return genres.stream().map(this::toModel).toList();
  }

  public Genre toModel(JGenre genre) {
    return Genre.builder().id(genre.getId()).name(genre.getName()).build();
  }

  public List<JGenre> toEntity(List<Genre> genres) {
    return genres.stream().map(this::toEntity).toList();
  }

  public JGenre toEntity(Genre genre) {
    return JGenre.builder().id(genre.id()).name(genre.name()).build();
  }
}
