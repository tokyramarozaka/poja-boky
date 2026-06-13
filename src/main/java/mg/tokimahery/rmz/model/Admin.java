package mg.tokimahery.rmz.model;

import lombok.Builder;

public final class Admin extends User {
  @Builder
  public Admin(
      String id,
      String firstName,
      String lastName,
      String email,
      String password,
      String phone,
      String address) {
    super(id, firstName, lastName, email, password, phone, address);
  }
}
