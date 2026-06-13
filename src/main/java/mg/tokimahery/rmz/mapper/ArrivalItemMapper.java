package mg.tokimahery.rmz.mapper;

import java.util.List;
import lombok.AllArgsConstructor;
import mg.tokimahery.rmz.model.ArrivalItem;
import mg.tokimahery.rmz.repository.model.JArrivalItem;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class ArrivalItemMapper {
  private final BookCopyMapper bookCopyMapper;

  public List<ArrivalItem> toModel(List<JArrivalItem> jArrivalItems) {
    return jArrivalItems.stream().map(this::toModel).toList();
  }

  public ArrivalItem toModel(JArrivalItem jArrivalItem) {
    return ArrivalItem.builder()
        .id(jArrivalItem.getId())
        .quantity(jArrivalItem.getQuantity())
        .bookCopy(bookCopyMapper.toModel(jArrivalItem.getBookCopy()))
        .build();
  }

  public List<JArrivalItem> toEntity(List<ArrivalItem> items) {
    return items.stream().map(this::toEntity).toList();
  }

  public JArrivalItem toEntity(ArrivalItem item) {
    return JArrivalItem.builder()
        .id(item.id())
        .bookCopy(bookCopyMapper.toEntity(item.bookCopy()))
        .quantity(item.quantity())
        .build();
  }
}
