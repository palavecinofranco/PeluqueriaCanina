package com.mycompany.peluqueriacanina.persistence;

import com.mycompany.peluqueriacanina.logic.Owner;
import com.mycompany.peluqueriacanina.logic.Pet;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PersistenceController {

    OwnerJpaController ownerJpa = new OwnerJpaController();
    PetJpaController petJpa = new PetJpaController();
    
    public void create(Owner owner, Pet pet) {
        //Create in DB
        ownerJpa.create(owner);
        petJpa.create(pet);
    }

    public List<Pet> read() {
       return petJpa.findPetEntities();
    }

    public void delete(int numberClient) {
        petJpa.delete(numberClient);
    }

    public Pet getPet(int numberClient) {
        return petJpa.findPet(numberClient);
    }

    public void updatePet(Pet pet) {
        try {
            petJpa.edit(pet);
        } catch (Exception ex) {
            Logger.getLogger(PersistenceController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Owner getOwner(int id) {
        return ownerJpa.findOwner(id);
    }

    public void updateOwner(Owner owner) {
        try {
            ownerJpa.edit(owner);
        } catch (Exception ex) {
            Logger.getLogger(PersistenceController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
