package mg.tokimahery.rmz.repository.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import mg.tokimahery.rmz.model.Language;
import org.hibernate.annotations.UuidGenerator;

@Entity
@Table(name = "author")
@NoArgsConstructor
@AllArgsConstructor
public class JAuthor {

  @Id @UuidGenerator private String id;

  @Column(name = "full_name", nullable = false)
  private String fullName;

  @Enumerated(EnumType.STRING)
  @Column(name = "main_language", nullable = false)
  private Language mainLanguage;

  @ManyToMany(mappedBy = "authors")
  private List<JBook> books;
}
