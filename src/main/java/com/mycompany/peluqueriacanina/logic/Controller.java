package com.mycompany.peluqueriacanina.logic;

import com.mycompany.peluqueriacanina.persistence.PersistenceController;

public class Controller {
    PersistenceController pc = new PersistenceController();

    public void save(String petName, String race, String color, String observations, String ownerName, String cellPhone, String allergic, String specialAttention) {
        Owner owner = new Owner(ownerName, cellPhone);
        Pet pet = new Pet(petName, race, color, allergic, specialAttention, observations, owner);
        pc.save(owner, pet);
    }
    
}
