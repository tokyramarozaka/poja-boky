package mg.tokimahery.rmz.mapper;

import java.util.List;
import lombok.AllArgsConstructor;
import mg.tokimahery.rmz.model.SaleItem;
import mg.tokimahery.rmz.repository.model.JSaleItem;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class SaleItemMapper {
  private BookCopyMapper bookCopyMapper;

  public List<SaleItem> toModel(List<JSaleItem> jSaleItems) {
    return jSaleItems.stream().map(this::toModel).toList();
  }

  public SaleItem toModel(JSaleItem jSaleItem) {
    return SaleItem.builder()
        .id(jSaleItem.getId())
        .quantity(jSaleItem.getQuantity())
        .bookCopy(bookCopyMapper.toModel(jSaleItem.getBookCopy()))
        .build();
  }

  public List<JSaleItem> toEntity(List<SaleItem> items) {
    return items.stream().map(this::toEntity).toList();
  }

  public JSaleItem toEntity(SaleItem item) {
    return JSaleItem.builder()
        .id(item.id())
        .bookCopy(bookCopyMapper.toEntity(item.bookCopy()))
        .quantity(item.quantity())
        .build();
  }
}
