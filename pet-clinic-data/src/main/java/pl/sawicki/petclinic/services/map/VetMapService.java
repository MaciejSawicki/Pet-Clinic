package pl.sawicki.petclinic.services.map;

import org.springframework.stereotype.Service;
import pl.sawicki.petclinic.model.Speciality;
import pl.sawicki.petclinic.model.Vet;
import pl.sawicki.petclinic.services.SpecialityService;
import pl.sawicki.petclinic.services.VetService;

import java.util.Set;

@Service
public class VetMapService extends AbstractMapService<Vet, Long> implements VetService {

    private SpecialityService specialityService;

    public VetMapService(SpecialityService specialityService) {
        this.specialityService = specialityService;
    }

    @Override
    public Set<Vet> findAll() {
        return super.findAll();
    }

    @Override
    public Vet findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Vet save(Vet object) {
        if(object.getSpecialties().size() > 0) {
            object.getSpecialties().forEach(speciality -> {
                if(speciality.getId() == null) {
                    Speciality savedSpeciality = specialityService.save(speciality);
                    speciality.setId(savedSpeciality.getId());
                }
            } );
        }

        return super.save(object);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Vet object) {
        super.delete(object);
    }

}
