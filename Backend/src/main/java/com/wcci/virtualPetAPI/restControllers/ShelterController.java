package com.wcci.virtualPetAPI.restControllers;

import com.wcci.virtualPetAPI.entities.Shelter;
import com.wcci.virtualPetAPI.repositories.ShelterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ShelterController {
    final ShelterRepository shelterRepository;

    public ShelterController(@Autowired ShelterRepository shelterRepository) {
        this.shelterRepository = shelterRepository;
    }

    //curl -X GET http://localhost:8080/api/shelters -H 'Content-Type: application/json'
    @GetMapping("/api/shelters")
    public Iterable<Shelter> getShelters() {
        return shelterRepository.findAll();
    }


    //curl -X GET http://localhost:8080/api/shelters/1 -H 'Content-Type: application/json'
    @GetMapping("/api/shelters/{shelter_id}")
    public Shelter getShelter(@PathVariable final long shelter_id) {
        return shelterRepository.findById(shelter_id).get();
    }

    /* curl -X POST http://localhost:8080/api/shelters -H 'Content-Type: application/json' -d '{"name": "testShelter"}'*/
    @PostMapping("/api/shelters")
    public Shelter addShelter(@RequestBody Shelter shelter) {
        return shelterRepository.save(shelter);
    }

    /* curl -X PUT http://localhost:8080/api/shelters/1 -H 'Content-Type: application/json' -d '{"id":1, "name": "test"}' */
    @PutMapping("/api/shelters/{shelter_id}")
    public void putShelter(@PathVariable final long shelter_id, @RequestBody Shelter shelter) throws Exception {
        if (shelter.getId() != shelter_id) {
            throw new Exception("Shelter body has id " + shelter.getId() + " but url had id " + shelter_id);
        }
        shelterRepository.save(shelter);
    }

    //curl -X DELETE http://localhost:8080/api/shelters/1 -H 'Content-Type: application/json'
    @DeleteMapping("/api/shelters/{shelter_id}")
    public void deleteShelter(@PathVariable final long shelter_id) {
        shelterRepository.delete(shelterRepository.findById(shelter_id).get());
    }


}