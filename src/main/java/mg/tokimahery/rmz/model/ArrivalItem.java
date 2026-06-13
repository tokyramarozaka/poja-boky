package mg.tokimahery.rmz.model;

import lombok.Builder;

@Builder
public record ArrivalItem(String id, BookCopy bookCopy, int quantity) {}
