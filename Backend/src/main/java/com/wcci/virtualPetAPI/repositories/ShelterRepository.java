package com.wcci.virtualPetAPI.repositories;

import com.wcci.virtualPetAPI.entities.Shelter;
import org.springframework.data.repository.CrudRepository;

public interface ShelterRepository extends CrudRepository<Shelter, Long> {
}
