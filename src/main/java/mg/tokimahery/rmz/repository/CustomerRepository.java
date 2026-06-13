package mg.tokimahery.rmz.repository;

import mg.tokimahery.rmz.repository.model.JCustomer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<JCustomer, String> {}
