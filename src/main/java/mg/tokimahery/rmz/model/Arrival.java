package mg.tokimahery.rmz.model;

import java.time.Instant;
import java.util.List;
import lombok.Builder;

@Builder
public record Arrival(String id, Instant date, List<ArrivalItem> items) {}
