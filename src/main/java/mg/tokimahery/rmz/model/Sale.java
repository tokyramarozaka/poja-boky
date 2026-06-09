package mg.tokimahery.rmz.model;

import java.time.LocalDate;
import java.util.List;

public record Sale(String id, LocalDate date, Customer customer, List<SaleItem> items) {}
