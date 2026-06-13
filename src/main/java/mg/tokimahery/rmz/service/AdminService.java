package mg.tokimahery.rmz.service;

import java.util.List;
import lombok.AllArgsConstructor;
import mg.tokimahery.rmz.mapper.AdminMapper;
import mg.tokimahery.rmz.model.Admin;
import mg.tokimahery.rmz.repository.AdminRepository;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AdminService {
  private final AdminRepository repository;
  private final AdminMapper mapper;

  public List<Admin> findAll() {
    return mapper.toModel(repository.findAll());
  }

  public Admin findById(String id) {
    return mapper.toModel(
        repository
            .findById(id)
            .orElseThrow(() -> new RuntimeException("Customer with id " + id + " not found")));
  }
}
