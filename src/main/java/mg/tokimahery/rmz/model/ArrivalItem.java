package mg.tokimahery.rmz.model;

import java.util.UUID;
import lombok.Builder;

@Builder
public record ArrivalItem(UUID id, BookCopy bookCopy, int quantity) {}
