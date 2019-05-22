package pl.sawicki.petclinic.repositories;

import org.springframework.data.repository.CrudRepository;
import pl.sawicki.petclinic.model.Speciality;

public interface SpecialtyRepository extends CrudRepository<Speciality, Long> {
}
