package mg.tokimahery.rmz.model;

import lombok.Builder;

@Builder
public record Author(String id, String fullName, Language mainLanguage) {}
