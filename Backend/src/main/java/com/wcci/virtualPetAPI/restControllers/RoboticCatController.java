package com.wcci.virtualPetAPI.restControllers;

import com.wcci.virtualPetAPI.entities.RoboticCat;
import com.wcci.virtualPetAPI.repositories.NamedPetRepository;
import com.wcci.virtualPetAPI.repositories.RoboticCatRepository;
import com.wcci.virtualPetAPI.repositories.ShelterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class RoboticCatController {
    final ShelterRepository shelterRepository;
    final NamedPetRepository namedPetRepository;

    final RoboticCatRepository roboticCatRepository;

    public RoboticCatController(@Autowired ShelterRepository shelterRepository,
                                NamedPetRepository namedPetRepository,
                                RoboticCatRepository roboticCatRepository) {
        this.shelterRepository = shelterRepository;
        this.namedPetRepository = namedPetRepository;
        this.roboticCatRepository = roboticCatRepository;
    }

    //    curl -s -X POST http://localhost:8080/api/shelters/1/roboticCats -H 'Content-Type: application/json' -d '{"name": "testRobotCat"}'
    @PostMapping("/api/shelters/{shelter_id}/roboticCats")
    public RoboticCat addRoboticPet(@RequestBody RoboticCat roboticCat, final @PathVariable Long shelter_id) {
        roboticCat.setShelter(shelterRepository.findById(shelter_id).get());
        namedPetRepository.save(roboticCat);
        return roboticCat;
    }

    @PutMapping("/api/roboticCat/{roboticCat_id}")
    public void oilRoboticCat(@PathVariable Long roboticCat_id) {
        roboticCatRepository.findById(roboticCat_id).get().giveOil();
        roboticCatRepository.save(roboticCatRepository.findById(roboticCat_id).get());
    }

    //curl -X DELETE http://localhost:8080/api/roboticCat/1 -H 'Content-Type: application/json'
    @DeleteMapping("/api/roboticCat/{roboticCat_id}")
    public void deleteRoboticCat(@PathVariable final long roboticCat_id) {
        roboticCatRepository.delete(roboticCatRepository.findById(roboticCat_id).get());
    }
}
