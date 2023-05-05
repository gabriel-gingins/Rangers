package com.wcci.virtualPetAPI.entities;

import javax.persistence.Entity;

import static com.wcci.virtualPetAPI.entities.NamedPet.PET_TYPE.ORGANIC_DOG;

@Entity
public class OrganicDog extends NamedPet {

    private int hunger = 6;
    private final PET_TYPE type = ORGANIC_DOG;

    public PET_TYPE getType() {
        return type;
    }

    public OrganicDog(String name) {
        super(name);
    }

    public OrganicDog() {
        super();
    }

    public int getHunger() {
        return hunger;
    }

    public void setHunger(int hunger) {
        this.hunger = hunger;
    }

    public void feed() {
        hunger = hunger - 4;
    }

    @Override
    public void tick() {
        hunger++;
    }

}
