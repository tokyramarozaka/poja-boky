package mg.tokimahery.rmz.model;

import java.time.LocalDate;

public record PriceHistory(String id, double price, LocalDate date) {}
