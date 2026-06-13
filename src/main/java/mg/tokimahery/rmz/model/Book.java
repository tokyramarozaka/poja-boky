package mg.tokimahery.rmz.model;

import java.util.List;
import lombok.Builder;

@Builder
public record Book(
    String id, String isbn, String title, int pages, List<Author> authors, List<Genre> genres) {}
