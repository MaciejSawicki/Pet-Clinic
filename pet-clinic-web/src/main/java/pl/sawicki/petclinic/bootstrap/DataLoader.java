package pl.sawicki.petclinic.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import pl.sawicki.petclinic.model.Owner;
import pl.sawicki.petclinic.model.Pet;
import pl.sawicki.petclinic.model.PetType;
import pl.sawicki.petclinic.model.Vet;
import pl.sawicki.petclinic.services.OwnerService;
import pl.sawicki.petclinic.services.PetTypeService;
import pl.sawicki.petclinic.services.VetService;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }

    @Override
    public void run(String... args) throws Exception {

        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");
        PetType savedCatPetType = petTypeService.save(cat);

        System.out.println("Pet Type Loading finished...");

        Owner owner1 = new Owner();
        owner1.setFistName("Maciej");
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
        owner2.setFistName("ExampleName");
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
        vet1.setFistName("Primary");
        vet1.setLastName("Vet");

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFistName("Secondary");
        vet2.setLastName("Vet");

        vetService.save(vet2);

        System.out.println("Vet loading finished...");


    }

}
