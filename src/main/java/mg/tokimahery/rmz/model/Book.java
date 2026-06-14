package mg.tokimahery.rmz.model;

import java.util.List;
import java.util.UUID;
import lombok.Builder;

@Builder
public record Book(
    UUID id, String isbn, String title, int pages, List<Author> authors, List<Genre> genres) {}
