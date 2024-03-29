package pl.sawicki.petclinic.repositories;

import org.springframework.data.repository.CrudRepository;
import pl.sawicki.petclinic.model.Pet;

public interface PetRepository extends CrudRepository<Pet, Long> {
}
