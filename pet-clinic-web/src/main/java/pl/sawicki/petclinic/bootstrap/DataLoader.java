package pl.sawicki.petclinic.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import pl.sawicki.petclinic.model.*;
import pl.sawicki.petclinic.services.OwnerService;
import pl.sawicki.petclinic.services.PetTypeService;
import pl.sawicki.petclinic.services.SpecialityService;
import pl.sawicki.petclinic.services.VetService;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialityService specialityService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService, SpecialityService specialityService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialityService = specialityService;
    }

    @Override
    public void run(String... args) throws Exception {
        int count = petTypeService.findAll().size();
        if(count == 0) {
            loadData();
        }
    }

    private void loadData() {
        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");
        PetType savedCatPetType = petTypeService.save(cat);

        System.out.println("Pet Type Loading finished...");

        Speciality radiology = new Speciality();
        radiology.setDescription("Radiology");
        Speciality savedRadiology = specialityService.save(radiology);

        Speciality surgery = new Speciality();
        surgery.setDescription("Surgery");
        Speciality savedSurgery = specialityService.save(surgery);

        Speciality dentistry = new Speciality();
        dentistry.setDescription("Dentistry");
        Speciality savedDentistry = specialityService.save(dentistry);

        System.out.println("Specialties Loading finished...");

        Owner owner1 = new Owner();
        owner1.setFirstName("Maciej");
        owner1.setLastName("Sawicki");
        owner1.setAddress("Jaracza 34");
        owner1.setCity("Łódź");
        owner1.setTelephone("500500500");

        Pet myPet = new Pet();
        myPet.setPetType(savedDogPetType);
        myPet.setOwner(owner1);
        myPet.setBirthDate(LocalDate.now());
        myPet.setName("Majka");

        owner1.getPets().add(myPet);

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("ExampleName");
        owner2.setLastName("ExampleSurname");
        owner2.setAddress("Jaracza 34");
        owner2.setCity("Łódź");
        owner2.setTelephone("500500500");

        Pet pet2 = new Pet();
        pet2.setName("ExamplePet");
        pet2.setBirthDate(LocalDate.now());
        pet2.setOwner(owner2);
        pet2.setPetType(savedCatPetType);

        owner2.getPets().add(pet2);

        ownerService.save(owner2);

        System.out.println("Owners loading finished...");

        Vet vet1 = new Vet();
        vet1.setFirstName("Primary");
        vet1.setLastName("Vet");
        vet1.getSpecialties().add(savedRadiology);
        vet1.getSpecialties().add(savedDentistry);

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Secondary");
        vet2.setLastName("Vet");
        vet2.getSpecialties().add(savedSurgery);

        vetService.save(vet2);

        System.out.println("Vet loading finished...");
    }

}
