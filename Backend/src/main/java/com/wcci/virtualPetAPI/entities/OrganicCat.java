package com.wcci.virtualPetAPI.entities;

import javax.persistence.Entity;

import static com.wcci.virtualPetAPI.entities.NamedPet.PET_TYPE.ORGANIC_CAT;

@Entity
public class OrganicCat extends NamedPet {

    private int hunger = 6;
    private final PET_TYPE type = ORGANIC_CAT;

    public PET_TYPE getType() {
        return type;
    }


    public OrganicCat(String name) {
        super(name);
    }

    public OrganicCat() {
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
