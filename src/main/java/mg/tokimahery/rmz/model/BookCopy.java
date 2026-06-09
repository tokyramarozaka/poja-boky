package mg.tokimahery.rmz.model;

import java.util.List;

public record BookCopy(
    String id,
    BookFormat format,
    List<PriceHistory> priceHistories,
    Language language,
    Book book) {}
