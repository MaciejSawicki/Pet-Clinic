package pl.sawicki.petclinic.repositories;

import org.springframework.data.repository.CrudRepository;
import pl.sawicki.petclinic.model.Owner;

public interface OwnerRepository extends CrudRepository<Owner, Long> {

}