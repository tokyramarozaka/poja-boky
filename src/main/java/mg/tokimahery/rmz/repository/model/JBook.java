package mg.tokimahery.rmz.repository.model;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import mg.tokimahery.rmz.model.Genre;
import org.hibernate.annotations.Check;
import org.hibernate.annotations.UuidGenerator;

@Entity
@Table(name = "book")
@NoArgsConstructor
@AllArgsConstructor
public class JBook {

  @Id @UuidGenerator private String id;

  @Column(nullable = false)
  private String title;

  @Check(constraints = "pages > 0")
  private int pages;

  @ManyToMany
  @JoinTable(
      name = "book_author",
      joinColumns = @JoinColumn(name = "book_id"),
      inverseJoinColumns = @JoinColumn(name = "author_id"))
  private List<JAuthor> authors;

  @ElementCollection
  @Enumerated(EnumType.STRING)
  @CollectionTable(name = "book_genre", joinColumns = @JoinColumn(name = "book_id"))
  @Column(name = "genre")
  private List<Genre> genres;
}
