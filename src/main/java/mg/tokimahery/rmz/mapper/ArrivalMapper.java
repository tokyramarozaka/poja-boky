package mg.tokimahery.rmz.mapper;

import java.util.List;
import lombok.AllArgsConstructor;
import mg.tokimahery.rmz.model.Arrival;
import mg.tokimahery.rmz.repository.model.JArrival;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class ArrivalMapper {
  private final ArrivalItemMapper itemMapper;
  private final ArrivalItemMapper arrivalItemMapper;

  public List<Arrival> toModel(List<JArrival> jArrivals) {
    return jArrivals.stream().map(this::toModel).toList();
  }

  public Arrival toModel(JArrival jArrival) {
    return Arrival.builder()
        .id(jArrival.getId())
        .date(jArrival.getDate())
        .items(itemMapper.toModel(jArrival.getItems()))
        .build();
  }

  public JArrival toEntity(Arrival toSave) {
    return JArrival.builder()
        .id(toSave.id())
        .date(toSave.date())
        .items(arrivalItemMapper.toEntity(toSave.items()))
        .build();
  }
}
