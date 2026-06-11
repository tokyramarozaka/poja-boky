package mg.tokimahery.rmz.model;

import java.time.Instant;
import java.util.List;

public record Arrival(String id, Instant date, List<ArrivalItem> items) {}
