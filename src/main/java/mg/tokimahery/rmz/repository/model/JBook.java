package mg.tokimahery.rmz.repository.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Check;
import org.hibernate.annotations.UuidGenerator;

@Entity
@Table(name = "book")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class JBook {

  @Id @UuidGenerator private String id;

  @Column(nullable = false)
  private String title;

  @Check(constraints = "pages > 0")
  private int pages;

  @Column(nullable = false)
  private String isbn;

  @ManyToMany
  @JoinTable(
      name = "book_author",
      joinColumns = @JoinColumn(name = "book_id"),
      inverseJoinColumns = @JoinColumn(name = "author_id"))
  private List<JAuthor> authors;

  @ManyToMany
  @JoinTable(
      name = "book_genres",
      joinColumns = @JoinColumn(name = "book_id"),
      inverseJoinColumns = @JoinColumn(name = "genre_id"))
  private List<JGenre> genres;
}
