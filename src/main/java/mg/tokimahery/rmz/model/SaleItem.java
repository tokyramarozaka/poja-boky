package mg.tokimahery.rmz.model;

import lombok.Builder;

@Builder
public record SaleItem(String id, BookCopy bookCopy, int quantity) {}
