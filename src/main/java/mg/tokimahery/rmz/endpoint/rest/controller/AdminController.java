package mg.tokimahery.rmz.endpoint.rest.controller;

import java.util.List;
import java.util.UUID;
import lombok.AllArgsConstructor;
import mg.tokimahery.rmz.model.Admin;
import mg.tokimahery.rmz.service.AdminService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class AdminController {
  private final AdminService service;

  @GetMapping("/admin")
  public List<Admin> getAll() {
    return service.findAll();
  }

  @GetMapping("/admin/{id}")
  public Admin getById(@PathVariable UUID id) {
    return service.findById(id);
  }
}
