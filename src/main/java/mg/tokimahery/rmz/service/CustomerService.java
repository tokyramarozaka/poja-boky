package mg.tokimahery.rmz.service;

import java.util.List;
import java.util.UUID;
import lombok.AllArgsConstructor;
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
            .orElseThrow(() -> new RuntimeException("Customer with id " + id + " not found")));
  }
}
