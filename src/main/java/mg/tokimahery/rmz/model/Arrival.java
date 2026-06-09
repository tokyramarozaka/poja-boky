package mg.tokimahery.rmz.model;

import java.time.LocalDate;
import java.util.List;

public record Arrival(String id, LocalDate date, List<ArrivalItem> items) {}
