package com.mycompany.peluqueriacanina.logic;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
public class Pet {
   @Getter @Setter @Id @GeneratedValue(strategy = GenerationType.SEQUENCE)
   private int clientNumber;
   @Getter @Setter
   private String petName;
   @Getter @Setter
   private String race;
   @Getter @Setter
   private String color;
   @Getter @Setter
   private String allergic;
   @Getter @Setter
   private String specialAttention;
   @Getter @Setter
   private String observations;
   @Getter @Setter @OneToOne
   private Owner petOwner;

   public Pet() {
   }

   public Pet(String petName, String race, String color, String allergic, String specialAttention, String observations, Owner petOwner) {
      this.petName = petName;
      this.race = race;
      this.color = color;
      this.allergic = allergic;
      this.observations = observations;
      this.specialAttention = specialAttention;
      this.petOwner = petOwner;
   }
}
