package mg.tokimahery.rmz.model;

import lombok.Builder;

import java.util.UUID;

public final class Admin extends User {
  @Builder
  public Admin(
      UUID id,
      String firstName,
      String lastName,
      String email,
      String password,
      String phone,
      String address) {
    super(id, firstName, lastName, email, password, phone, address);
  }
}
