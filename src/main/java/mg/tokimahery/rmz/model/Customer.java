package mg.tokimahery.rmz.model;

import lombok.Builder;
import lombok.Getter;

@Getter
public final class Customer extends User {
  private final String notes;

  @Builder
  public Customer(
      String id,
      String firstName,
      String lastName,
      String email,
      String password,
      String phone,
      String address,
      String notes) {
    super(id, firstName, lastName, email, password, phone, address);
    this.notes = notes;
  }
}
