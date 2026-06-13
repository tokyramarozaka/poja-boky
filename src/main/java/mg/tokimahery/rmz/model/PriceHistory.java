package mg.tokimahery.rmz.model;

import java.time.LocalDate;
import lombok.Builder;

@Builder
public record PriceHistory(String id, double price, LocalDate effectiveDate) {}
