package musialowski.kamil.springpetclinic.services;

import musialowski.kamil.springpetclinic.model.Owner;


public interface OwnerService extends CrudService<Owner, Long> {

    Owner findByLastName(String lastName);
}
