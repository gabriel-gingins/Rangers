package com.wcci.virtualPetAPI.restControllers;

import com.wcci.virtualPetAPI.entities.OrganicCat;
import com.wcci.virtualPetAPI.repositories.NamedPetRepository;
import com.wcci.virtualPetAPI.repositories.OrganicCatRepository;
import com.wcci.virtualPetAPI.repositories.ShelterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class OrganicCatController {
    final ShelterRepository shelterRepository;
    final NamedPetRepository namedPetRepository;
    final OrganicCatRepository organicCatRepository;

    public OrganicCatController(@Autowired ShelterRepository shelterRepository,
                                NamedPetRepository namedPetRepository,
                                OrganicCatRepository organicCatRepository) {

        this.shelterRepository = shelterRepository;
        this.namedPetRepository = namedPetRepository;
        this.organicCatRepository = organicCatRepository;

    }

//    curl -s -X POST http://localhost:8080/api/shelters/{shelter_id}/organicCat -H 'Content-Type: application/json' -d '{"name": "testCat"}'

//    "@{'/api/shelters/' + ${shelter.id} + '/organicCat'}"
    @PostMapping("/api/shelters/{shelter_id}/organicCat")
    public OrganicCat addPet(@RequestBody OrganicCat organicCat, final @PathVariable Long shelter_id) {
        organicCat.setShelter(shelterRepository.findById(shelter_id).get());
        namedPetRepository.save(organicCat);
        return organicCat;
    }

    //curl -s -X PUT http://localhost:8080/api/shelters/{shelter_id}/organicCat/{organicCat_id} -H 'Content-Type: application/json' -d '{"id":1,"name":"testCat2","hunger":6}'
    @PutMapping("/api/shelters/{shelter_id}/organicCat/{organicCat_id}")
    public void updatePet(@PathVariable Long organicCat_id, final @PathVariable Long shelter_id, @RequestBody OrganicCat organicCat) throws Exception {
        if (organicCat.getId() != organicCat_id) {
            throw new Exception("Style body has id " + organicCat.getId() + " but url had id " + organicCat_id);
        }
        organicCatRepository.save(organicCat);
    }

    @PutMapping("api/organicCat/{organicCat_id}")
    public void feedPet(@PathVariable Long organicCat_id) {
        organicCatRepository.findById(organicCat_id).get().feed();
        organicCatRepository.save(organicCatRepository.findById(organicCat_id).get());
    }

    //curl -X DELETE http://localhost:8080/api/organicCat/1 -H 'Content-Type: application/json'
    @DeleteMapping("/api/organicCat/{organicCat_id}")
    public void deleteOrganicCat(@PathVariable final long organicCat_id) {
        organicCatRepository.delete(organicCatRepository.findById(organicCat_id).get());
    }
}
