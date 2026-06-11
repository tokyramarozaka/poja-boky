package mg.tokimahery.rmz.repository.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.UuidGenerator;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class JGenre {
  @Id @UuidGenerator private String id;

  @Column(nullable = false, unique = true)
  private String name;

  @ManyToMany(mappedBy = "genres")
  private List<JBook> books;
}
