package mg.tokimahery.rmz.repository;

import java.util.List;
import java.util.UUID;
import mg.tokimahery.rmz.repository.model.JSale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SaleRepository extends JpaRepository<JSale, UUID> {
  List<JSale> findAllByCustomer_Id(UUID customerId);
}
