package mg.tokimahery.rmz.repository.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.math.BigDecimal;
import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.UuidGenerator;

@Entity
@Table(name = "price_history")
@NoArgsConstructor
@AllArgsConstructor
public class JPriceHistory {

  @Id @UuidGenerator private String id;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "book_copy_id", nullable = false)
  private JBookCopy bookCopy;

  @Column(nullable = false)
  private BigDecimal price;

  @Column(name = "effective_date", nullable = false)
  private LocalDate effectiveDate;
}
