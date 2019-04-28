package pl.sawicki.petclinic.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import pl.sawicki.petclinic.model.Owner;
import pl.sawicki.petclinic.model.Vet;
import pl.sawicki.petclinic.services.OwnerService;
import pl.sawicki.petclinic.services.VetService;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;

    public DataLoader(OwnerService ownerService, VetService vetService) {
        this.ownerService = ownerService;

        this.vetService = vetService;
    }

    @Override
    public void run(String... args) throws Exception {

        Owner owner1 = new Owner();
        owner1.setId(1L);
        owner1.setFistName("Maciej");
        owner1.setLastName("Sawicki");

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setId(2L);
        owner2.setFistName("ExampleName");
        owner2.setLastName("ExampleSurname");

        ownerService.save(owner2);

        System.out.println("Owners loading finished...");

        Vet vet1 = new Vet();
        vet1.setId(1L);
        vet1.setFistName("Primary");
        vet1.setLastName("Vet");

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setId(2L);
        vet2.setFistName("Secondary");
        vet2.setLastName("Vet");

        vetService.save(vet2);

        System.out.println("Vet loading finished...");

    }

}
