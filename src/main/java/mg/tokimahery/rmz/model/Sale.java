package mg.tokimahery.rmz.model;

import java.time.Instant;
import java.util.List;
import lombok.Builder;

@Builder
public record Sale(String id, Instant date, Customer customer, List<SaleItem> items) {}
