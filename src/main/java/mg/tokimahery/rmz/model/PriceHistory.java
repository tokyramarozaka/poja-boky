package mg.tokimahery.rmz.model;

import java.time.LocalDate;
import java.util.UUID;
import lombok.Builder;

@Builder
public record PriceHistory(UUID id, double price, LocalDate effectiveDate) {}
