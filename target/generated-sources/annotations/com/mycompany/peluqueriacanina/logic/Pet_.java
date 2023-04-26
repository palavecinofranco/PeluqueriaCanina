package com.mycompany.peluqueriacanina.logic;

import com.mycompany.peluqueriacanina.logic.Owner;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2023-04-25T14:24:49", comments="EclipseLink-2.7.10.v20211216-rNA")
@StaticMetamodel(Pet.class)
public class Pet_ { 

    public static volatile SingularAttribute<Pet, String> petName;
    public static volatile SingularAttribute<Pet, String> allergic;
    public static volatile SingularAttribute<Pet, String> race;
    public static volatile SingularAttribute<Pet, String> color;
    public static volatile SingularAttribute<Pet, String> observations;
    public static volatile SingularAttribute<Pet, Owner> petOwner;
    public static volatile SingularAttribute<Pet, Integer> clientNumber;
    public static volatile SingularAttribute<Pet, String> specialAttention;

}