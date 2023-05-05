package com.wcci.virtualPetAPI.entities;

import com.wcci.virtualPetAPI.entities.RoboticDog;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RoboticDogTest {

    @Test
    public void testAddRoboticDogReturnsId() {
        RoboticDog roboticDog = new RoboticDog("Fido");
        roboticDog.setId(1);
        assertEquals(1, roboticDog.getId());
    }

    @Test
    public void testConstructAndReturnName() {
        RoboticDog roboticDog = new RoboticDog("Fido");
        assertEquals("Fido", roboticDog.getName());
    }

    @Test
    public void testSetAndGetOil() {
        RoboticDog roboticDog = new RoboticDog("Fido");
        roboticDog.setOil(1);
        assertEquals(1, roboticDog.getOil());
    }

    @Test
    public void testGiveOilSetsOilToZero() {
        RoboticDog roboticDog = new RoboticDog("Fido");
        roboticDog.setOil(10);
        roboticDog.giveOil();
        assertEquals(6, roboticDog.getOil());
    }

    @Test
    public void testTick() {
        RoboticDog roboticDog = new RoboticDog("Fido");
        roboticDog.tick();
        assertEquals(7, roboticDog.getOil());
    }
}