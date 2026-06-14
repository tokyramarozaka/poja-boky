package mg.tokimahery.rmz.model;

import java.util.UUID;
import lombok.Builder;

@Builder
public record Author(UUID id, String fullName, Language mainLanguage) {}
