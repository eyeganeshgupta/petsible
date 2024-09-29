package com.petsible.repository;

import java.util.Optional;

import com.petsible.dto.PetDTO;

/**
 * Repository for managing pet data.
 *
 * @author Ganesh Gupta
 */
public interface PetRepository {

    /**
     * Finds a pet by ID.
     *
     * @param petId the ID of the pet
     * @return an Optional containing the pet if found
     */
    Optional<PetDTO> findById(int petId);
}
