package mg.tokimahery.rmz.model;

public final class Customer extends User {
  private final String notes;

  public Customer(
      String id, String email, String password, String phone, String address, String notes) {
    super(id, email, password, phone, address);
    this.notes = notes;
  }
}
