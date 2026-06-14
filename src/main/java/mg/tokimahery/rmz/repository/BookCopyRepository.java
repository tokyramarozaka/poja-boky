package mg.tokimahery.rmz.repository;

import java.util.UUID;
import mg.tokimahery.rmz.repository.model.JBookCopy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookCopyRepository extends JpaRepository<JBookCopy, UUID> {
  JBookCopy findByBook_Id(UUID bookId);
}
