package pl.sawicki.petclinic.services.map;

import org.springframework.stereotype.Service;
import pl.sawicki.petclinic.model.PetType;
import pl.sawicki.petclinic.services.PetTypeService;

import java.util.Set;

@Service
public class PetTypeMapService extends AbstractMapService<PetType, Long> implements PetTypeService {

    @Override
    public Set<PetType> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public PetType save(PetType object) {
        return super.save(object);
    }

    @Override
    public void delete(PetType object) {

    }

    @Override
    public PetType findById(Long id) {
        return super.findById(id);
    }
}
