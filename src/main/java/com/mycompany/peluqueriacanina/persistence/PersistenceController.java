package com.mycompany.peluqueriacanina.persistence;

import com.mycompany.peluqueriacanina.logic.Owner;
import com.mycompany.peluqueriacanina.logic.Pet;

public class PersistenceController {

    OwnerJpaController ownerJpa = new OwnerJpaController();
    PetJpaController petJpa = new PetJpaController();
    
    public void save(Owner owner, Pet pet) {
        //Create in DB
        ownerJpa.create(owner);
        petJpa.create(pet);
    }
}
