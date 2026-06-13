package mg.tokimahery.rmz.mapper;

import java.util.List;
import mg.tokimahery.rmz.model.PriceHistory;
import mg.tokimahery.rmz.repository.model.JPriceHistory;
import org.springframework.stereotype.Component;

@Component
public class PriceHistoryMapper {
  public List<PriceHistory> toModel(List<JPriceHistory> jPriceHistories) {
    return jPriceHistories.stream().map(this::toModel).toList();
  }

  public PriceHistory toModel(JPriceHistory jPriceHistory) {
    return PriceHistory.builder()
        .id(jPriceHistory.getId())
        .price(jPriceHistory.getPrice())
        .effectiveDate(jPriceHistory.getEffectiveDate())
        .build();
  }
}
