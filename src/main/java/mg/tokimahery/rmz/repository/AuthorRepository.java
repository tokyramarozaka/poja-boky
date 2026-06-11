package mg.tokimahery.rmz.repository;

import mg.tokimahery.rmz.repository.model.JAuthor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends JpaRepository<JAuthor, String> {}
