package mg.tokimahery.rmz.mapper;

import java.util.List;
import lombok.AllArgsConstructor;
import mg.tokimahery.rmz.model.Customer;
import mg.tokimahery.rmz.repository.SaleRepository;
import mg.tokimahery.rmz.repository.model.JCustomer;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class CustomerMapper {
  private final SaleRepository saleRepository;

  public List<Customer> toModel(List<JCustomer> jCustomers) {
    return jCustomers.stream().map(this::toModel).toList();
  }

  public Customer toModel(JCustomer jCustomer) {
    return Customer.builder()
        .id(jCustomer.getId())
        .firstName(jCustomer.getFirstName())
        .lastName(jCustomer.getLastName())
        .phone(jCustomer.getPhone())
        .address(jCustomer.getAddress())
        .password(jCustomer.getPassword())
        .email(jCustomer.getEmail())
        .notes(jCustomer.getNotes())
        .build();
  }

  public List<JCustomer> toEntity(List<Customer> customers) {
    return customers.stream().map(this::toEntity).toList();
  }

  public JCustomer toEntity(Customer customer) {
    var customerSales = saleRepository.findAllByCustomer_Id(customer.getId());
    return JCustomer.builder()
        .id(customer.getId())
        .firstName(customer.getFirstName())
        .lastName(customer.getLastName())
        .address(customer.getAddress())
        .password(customer.getPassword())
        .notes(customer.getNotes())
        .email(customer.getEmail())
        .sales(customerSales)
        .build();
  }
}
