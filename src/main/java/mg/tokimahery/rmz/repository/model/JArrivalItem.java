package mg.tokimahery.rmz.repository.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mg.tokimahery.rmz.model.Arrival;
import mg.tokimahery.rmz.model.BookCopy;
import org.hibernate.annotations.Check;
import org.hibernate.annotations.UuidGenerator;

@Entity
@Table(name = "arrival_item")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class JArrivalItem {
  @Id @UuidGenerator private String id;

  @ManyToOne
  @JoinColumn(name = "arrival_id", nullable = false)
  private Arrival arrival;

  @ManyToOne
  @JoinColumn(name = "book_copy_id", nullable = false)
  private BookCopy bookCopy;

  @Check(constraints = "quantity > 0")
  private int quantity;
}
