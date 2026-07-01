package mg.tokimahery.rmz.endpoint.rest.controller;

import java.util.List;
import java.util.UUID;
import lombok.AllArgsConstructor;
import mg.tokimahery.rmz.model.Customer;
import mg.tokimahery.rmz.service.CustomerService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customers")
@AllArgsConstructor
public class CustomerController {
  private final CustomerService service;

  @GetMapping
  public List<Customer> getAll() {
    return service.findAll();
  }

  @GetMapping("/{id}")
  public Customer getById(@PathVariable UUID id) {
    return service.findById(id);
  }

  @PostMapping
  public List<Customer> create(List<Customer> customers) {
    return service.create(customers);
  }
}
