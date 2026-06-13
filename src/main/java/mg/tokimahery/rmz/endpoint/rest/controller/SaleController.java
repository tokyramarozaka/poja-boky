package mg.tokimahery.rmz.endpoint.rest.controller;

import java.util.List;
import lombok.AllArgsConstructor;
import mg.tokimahery.rmz.model.Sale;
import mg.tokimahery.rmz.service.SaleService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class SaleController {
  private final SaleService service;

  @GetMapping("/sales")
  public List<Sale> getSales() {
    return service.findSales();
  }

  @GetMapping("/sales/{id}")
  public Sale getSaleById(@PathVariable String id) {
    return service.findSaleById(id);
  }

  @PostMapping("/sales")
  public List<Sale> save(@RequestBody List<Sale> sales) {
    return service.create(sales);
  }
}
