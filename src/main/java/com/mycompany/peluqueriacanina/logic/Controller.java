package com.mycompany.peluqueriacanina.logic;

import com.mycompany.peluqueriacanina.persistence.PersistenceController;
import java.util.List;

public class Controller {
    PersistenceController pc = new PersistenceController();

    public void save(String petName, String race, String color, String observations, String ownerName, String cellPhone, String allergic, String specialAttention) {
        Owner owner = new Owner(ownerName, cellPhone);
        Pet pet = new Pet(petName, race, color, allergic, specialAttention, observations, owner);
        pc.create(owner, pet);
    }

    public List<Pet> getPets() {
        return pc.read();
    }

    public void delete(int numberClient) {
        pc.delete(numberClient);
    }

    public void edit(int numberClient) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public Pet getPet(int numberClient) {
        return pc.getPet(numberClient);
    }

    public void update(Pet pet, String petName, String race, String color, String observations,String allergic, String specialAttention, String ownerName, String cellPhone) {
        //set pet values
        pet.setPetName(petName);
        pet.setRace(race);
        pet.setColor(color);
        pet.setObservations(observations);
        pet.setAllergic(allergic);
        pet.setSpecialAttention(specialAttention);
        //updating the pet
        pc.updatePet(pet);
        //set owner values
        Owner owner = this.searchOwner(pet.getPetOwner().getId());
        owner.setCellphone(cellPhone);
        owner.setName(ownerName);
        //updating the owner
        pc.updateOwner(owner);
    }

    private Owner searchOwner(int id) {
        return pc.getOwner(id);
    }

    
}
