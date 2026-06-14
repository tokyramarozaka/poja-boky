package mg.tokimahery.rmz.model;

import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public abstract sealed class User permits Admin, Customer {
  private final UUID id;
  private final String firstName;
  private final String lastName;
  private final String email;
  private final String password;
  private final String phone;
  private final String address;
}
