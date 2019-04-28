package pl.sawicki.petclinic.services;

import pl.sawicki.petclinic.model.Owner;

public interface OwnerService extends CrudService<Owner, Long> {

    Owner findByLastName(String lastName);

}
