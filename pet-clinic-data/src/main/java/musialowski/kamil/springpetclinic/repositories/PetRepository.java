package musialowski.kamil.springpetclinic.repositories;

import musialowski.kamil.springpetclinic.model.Pet;
import org.springframework.data.repository.CrudRepository;

public interface PetRepository extends CrudRepository<Pet, Long> {


}
