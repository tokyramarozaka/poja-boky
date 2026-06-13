package mg.tokimahery.rmz.repository.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.UuidGenerator;

@Entity
@Table(name = "customer")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class JCustomer {
  @Id @UuidGenerator private String id;
  private String firstName;

  @Column(nullable = false)
  private String lastName;

  @Column(nullable = false, unique = true)
  private String email;

  @Column(nullable = false)
  private String password;

  private String phone;
  private String address;
  private String notes;

  @OneToMany(mappedBy = "customer")
  private List<JSale> sales;
}
