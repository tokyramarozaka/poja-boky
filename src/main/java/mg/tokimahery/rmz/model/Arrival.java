package mg.tokimahery.rmz.model;

import java.time.Instant;
import java.util.List;
import java.util.UUID;
import lombok.Builder;

@Builder
public record Arrival(UUID id, Instant date, List<ArrivalItem> items) {}
