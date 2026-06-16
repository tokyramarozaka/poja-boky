package mg.tokimahery.rmz.service;

import jakarta.transaction.Transactional;
import java.util.List;
import java.util.UUID;
import lombok.AllArgsConstructor;
import mg.tokimahery.rmz.exception.NotFoundException;
import mg.tokimahery.rmz.mapper.ArrivalMapper;
import mg.tokimahery.rmz.model.Arrival;
import mg.tokimahery.rmz.repository.ArrivalRepository;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ArrivalService {
  private final ArrivalRepository repository;
  private final ArrivalMapper mapper;

  public List<Arrival> findAll() {
    return repository.findAll().stream().map(mapper::toModel).toList();
  }

  public Arrival findById(UUID id) {
    return mapper.toModel(
        repository
            .findById(id)
            .orElseThrow(() -> new NotFoundException("Arrival with id " + id + " not found")));
  }

  @Transactional
  public List<Arrival> create(List<Arrival> toSave) {
    return toSave.stream().map(this::create).toList();
  }

  public Arrival create(Arrival toSave) {
    var savedJArrival = repository.save(mapper.toEntity(toSave));
    return mapper.toModel(savedJArrival);
  }
}
