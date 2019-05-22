package pl.sawicki.petclinic.repositories;

import org.springframework.data.repository.CrudRepository;
import pl.sawicki.petclinic.model.Visit;

public interface VisitRepository extends CrudRepository<Visit, Long> {
}
