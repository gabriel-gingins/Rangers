package com.wcci.virtualPetAPI.repositories;

import com.wcci.virtualPetAPI.entities.NamedPet;
import org.springframework.data.repository.CrudRepository;

public interface NamedPetRepository extends CrudRepository<NamedPet, Long> {
}
