package com.petsible.repository;

import java.util.List;
import java.util.Optional;

import com.petsible.dto.OwnerDTO;

/**
 * Repository for managing owner data.
 *
 * @author Ganesh Gupta
 */
public interface OwnerRepository {

    /**
     * Saves an owner.
     *
     * @param ownerDTO the owner to save
     */
    void save(OwnerDTO ownerDTO);

    /**
     * Finds an owner by ID.
     *
     * @param ownerId the ID of the owner
     * @return an Optional containing the owner if found
     */
    Optional<OwnerDTO> findById(int ownerId);

    /**
     * Updates the pet details of an owner.
     *
     * @param ownerId the ID of the owner
     * @param petName the new pet name
     */
    void updatePetDetails(int ownerId, String petName);

    /**
     * Deletes an owner by ID.
     *
     * @param ownerId the ID of the owner
     */
    void deleteById(int ownerId);

    /**
     * Finds all owners.
     *
     * @return a list of all owners
     */
    List<OwnerDTO> findAll();
}
