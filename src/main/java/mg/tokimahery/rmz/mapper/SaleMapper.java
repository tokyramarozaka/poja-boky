package mg.tokimahery.rmz.mapper;

import java.util.List;
import lombok.AllArgsConstructor;
import mg.tokimahery.rmz.model.Sale;
import mg.tokimahery.rmz.repository.model.JSale;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class SaleMapper {
  private final SaleItemMapper itemMapper;
  private final CustomerMapper customerMapper;

  public List<Sale> toModel(List<JSale> jSales) {
    return jSales.stream().map(this::toModel).toList();
  }

  public Sale toModel(JSale jSale) {
    return Sale.builder()
        .id(jSale.getId())
        .customer(customerMapper.toModel(jSale.getCustomer()))
        .date(jSale.getDate())
        .items(itemMapper.toModel(jSale.getItems()))
        .build();
  }

  public JSale toEntity(Sale sale) {
    return JSale.builder()
        .id(sale.id())
        .customer(customerMapper.toEntity(sale.customer()))
        .date(sale.date())
        .items(itemMapper.toEntity(sale.items()))
        .build();
  }
}
