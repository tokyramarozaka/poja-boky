package mg.tokimahery.rmz.repository.model;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Check;
import org.hibernate.annotations.UuidGenerator;

@Entity
@Table(name = "sale_item")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class JSaleItem {
  @Id @GeneratedValue
  @UuidGenerator private UUID id;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "sale_id", nullable = false)
  private JSale sale;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "book_copy_id", nullable = false)
  private JBookCopy bookCopy;

  @Check(constraints = "quantity > 0")
  private int quantity;
}
