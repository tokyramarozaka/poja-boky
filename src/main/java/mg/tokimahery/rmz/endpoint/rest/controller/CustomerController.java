package mg.tokimahery.rmz.endpoint.rest.controller;

import java.util.List;
import lombok.AllArgsConstructor;
import mg.tokimahery.rmz.model.Customer;
import mg.tokimahery.rmz.service.CustomerService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class CustomerController {
  private final CustomerService service;

  @GetMapping("/customers")
  public List<Customer> getAll() {
    return service.findAll();
  }

  @GetMapping("/customers/{id}")
  public Customer getById(@PathVariable String id) {
    return service.findById(id);
  }
}
