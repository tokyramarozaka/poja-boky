package mg.tokimahery.rmz.service;

import java.util.List;
import lombok.AllArgsConstructor;
import mg.tokimahery.rmz.mapper.SaleMapper;
import mg.tokimahery.rmz.model.Sale;
import mg.tokimahery.rmz.repository.SaleRepository;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class SaleService {
  private final SaleRepository repository;
  private final SaleMapper mapper;

  public List<Sale> findSales() {
    return repository.findAll().stream().map(mapper::toModel).toList();
  }

  public Sale findSaleById(String id) {
    return mapper.toModel(
        repository
            .findById(id)
            .orElseThrow(() -> new RuntimeException("Sale with id " + id + " not found")));
  }

  public List<Sale> create(List<Sale> sales) {
    return sales.stream().map(this::create).toList();
  }

  public Sale create(Sale sale) {
    var createdJSale = repository.save(mapper.toEntity(sale));
    return mapper.toModel(createdJSale);
  }
}
