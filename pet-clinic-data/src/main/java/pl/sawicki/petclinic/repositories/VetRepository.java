package pl.sawicki.petclinic.repositories;

import org.springframework.data.repository.CrudRepository;
import pl.sawicki.petclinic.model.Vet;

public interface VetRepository extends CrudRepository<Vet, Long> {
}
