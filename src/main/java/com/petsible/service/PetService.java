package com.petsible.service;

import com.petsible.dto.PetDTO;
import com.petsible.exception.PetNotFoundException;

/**
 * Service for managing Pet operations.
 *
 * @author Ganesh Gupta
 */
public interface PetService {

    /**
     * Finds a pet by ID.
     *
     * @param petId the ID of the pet
     * @return the pet details
     * @throws PetNotFoundException if pet not found
     */
    PetDTO findPet(int petId) throws PetNotFoundException;
}
