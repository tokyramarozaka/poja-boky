package mg.tokimahery.rmz.repository;

import java.util.UUID;
import mg.tokimahery.rmz.repository.model.JSaleItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface SaleItemRepository extends JpaRepository<JSaleItem, UUID> {
  @Query(
      """
      SELECT COALESCE(SUM(si.quantity), 0)
      FROM JSaleItem si
      WHERE si.bookCopy.id = :bookCopyId
      """)
  int getTotalQuantity(@Param("bookCopyId") UUID bookCopyId);
}
