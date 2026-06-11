package mg.tokimahery.rmz.repository;

import mg.tokimahery.rmz.repository.model.JBook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<JBook, String> {}
