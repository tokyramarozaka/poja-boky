package mg.tokimahery.rmz.repository.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.time.Instant;
import java.util.List;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UuidGenerator;

@Entity
@Table(name = "arrival")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class JArrival {
  @Id @UuidGenerator private UUID id;

  @CreationTimestamp private Instant date;

  @OneToMany(mappedBy = "arrival")
  private List<JArrivalItem> items;
}
