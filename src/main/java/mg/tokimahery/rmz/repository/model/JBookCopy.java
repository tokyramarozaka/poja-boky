package mg.tokimahery.rmz.repository.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.List;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mg.tokimahery.rmz.model.BookFormat;
import mg.tokimahery.rmz.model.Language;
import org.hibernate.annotations.UuidGenerator;

@Entity
@Table(name = "book_copy")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class JBookCopy {

  @Id @GeneratedValue @UuidGenerator private UUID id;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "book_id", nullable = false)
  private JBook book;

  @Enumerated(EnumType.STRING)
  @Column(name = "format", nullable = false)
  private BookFormat format;

  @Enumerated(EnumType.STRING)
  @Column(name = "language", nullable = false)
  private Language language;

  @OneToMany(mappedBy = "bookCopy", cascade = CascadeType.ALL, orphanRemoval = true)
  private List<JPriceHistory> priceHistories;
}
