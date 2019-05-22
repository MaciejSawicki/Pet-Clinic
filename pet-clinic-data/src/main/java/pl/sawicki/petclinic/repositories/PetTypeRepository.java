package pl.sawicki.petclinic.repositories;

import org.springframework.data.repository.CrudRepository;
import pl.sawicki.petclinic.model.PetType;

public interface PetTypeRepository extends CrudRepository<PetType, Long> {
}
