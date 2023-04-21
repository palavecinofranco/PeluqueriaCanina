package com.mycompany.peluqueriacanina.logic;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
public class Owner {
    @Getter @Setter @Id @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;
    @Getter @Setter
    private String name;
    @Getter @Setter
    private String cellphone;

    public Owner() {
    }

    public Owner(String name, String cellphone) {
        this.name = name;
        this.cellphone = cellphone;
    }
    
    
}
