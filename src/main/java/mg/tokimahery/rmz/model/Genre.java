package mg.tokimahery.rmz.model;

import java.util.UUID;
import lombok.Builder;

@Builder
public record Genre(UUID id, String name) {}
