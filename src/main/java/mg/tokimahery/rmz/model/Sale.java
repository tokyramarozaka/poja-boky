package mg.tokimahery.rmz.model;

import java.time.Instant;
import java.util.List;
import java.util.UUID;
import lombok.Builder;

@Builder
public record Sale(UUID id, Instant date, Customer customer, List<SaleItem> items) {}
