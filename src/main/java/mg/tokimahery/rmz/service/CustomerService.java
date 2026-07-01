package mg.tokimahery.rmz.service;

import jakarta.transaction.Transactional;
import java.util.List;
import java.util.UUID;
import lombok.AllArgsConstructor;
import mg.tokimahery.rmz.exception.NotFoundException;
import mg.tokimahery.rmz.mapper.CustomerMapper;
import mg.tokimahery.rmz.model.Customer;
import mg.tokimahery.rmz.repository.CustomerRepository;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CustomerService {
  private final CustomerRepository repository;
  private final CustomerMapper mapper;

  public List<Customer> findAll() {
    return mapper.toModel(repository.findAll());
  }

  public Customer findById(UUID id) {
    return mapper.toModel(
        repository
            .findById(id)
            .orElseThrow(() -> new NotFoundException("Customer with id " + id + " not found")));
  }

  @Transactional
  public List<Customer> create(List<Customer> customers) {
    return customers.stream().map(this::create).toList();
  }

  public Customer create(Customer customer) {
    var customerEntity = mapper.toEntity(customer);
    return mapper.toModel(repository.save(customerEntity));
  }
}
