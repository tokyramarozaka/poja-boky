package mg.tokimahery.rmz.repository.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.time.Instant;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mg.tokimahery.rmz.model.ArrivalItem;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UuidGenerator;

@Entity
@Table(name = "arrival")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class JArrival {
  @Id @UuidGenerator private String id;

  @CreationTimestamp private Instant date;

  @OneToMany(mappedBy = "arrival")
  private List<ArrivalItem> items;
}
