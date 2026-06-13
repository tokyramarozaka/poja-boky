package mg.tokimahery.rmz.repository;

import mg.tokimahery.rmz.repository.model.JArrival;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArrivalRepository extends JpaRepository<JArrival, String> {}
