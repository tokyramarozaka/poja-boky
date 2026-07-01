package mg.tokimahery.rmz.repository;

import java.util.UUID;
import mg.tokimahery.rmz.repository.model.JArrivalItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ArrivalItemRepository extends JpaRepository<JArrivalItem, UUID> {
  @Query(
      """
      SELECT COALESCE(SUM(ai.quantity), 0)
      FROM JArrivalItem ai
      WHERE ai.bookCopy.id = :bookCopyId
      """)
  int getTotalQuantity(@Param("bookCopyId") UUID bookCopyId);
}
