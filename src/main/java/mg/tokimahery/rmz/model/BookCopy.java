package mg.tokimahery.rmz.model;

import java.util.List;
import java.util.UUID;
import lombok.Builder;

@Builder
public record BookCopy(
    UUID id, BookFormat format, List<PriceHistory> priceHistories, Language language, Book book) {}
