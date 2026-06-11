package mg.tokimahery.rmz.model;

import java.time.Instant;
import java.util.List;

public record Sale(String id, Instant date, Customer customer, List<SaleItem> items) {}
