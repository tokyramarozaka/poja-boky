package mg.tokimahery.rmz.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public abstract sealed class User permits Admin, Customer {
  private final String id;
  private final String email;
  private final String password;
  private final String phone;
  private final String address;
}
