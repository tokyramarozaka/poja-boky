package mg.tokimahery.rmz.endpoint.rest.controller;

import static org.springframework.http.HttpStatus.CREATED;

import java.util.List;
import java.util.UUID;
import lombok.AllArgsConstructor;
import mg.tokimahery.rmz.model.Arrival;
import mg.tokimahery.rmz.service.ArrivalService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class ArrivalController {
  private final ArrivalService service;

  @GetMapping("/arrivals")
  public List<Arrival> getArrivals() {
    return service.findAll();
  }

  @GetMapping("/arrivals/{id}")
  public Arrival getArrivalById(@PathVariable UUID id) {
    return service.findById(id);
  }

  @PostMapping("/arrivals")
  @ResponseStatus(CREATED)
  public List<Arrival> save(@RequestBody List<Arrival> arrivals) {
    return service.create(arrivals);
  }
}
