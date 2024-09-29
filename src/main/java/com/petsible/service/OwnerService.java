package com.petsible.service;

import java.util.List;
import com.petsible.dto.OwnerDTO;
import com.petsible.exception.DuplicateOwnerIdException;
import com.petsible.exception.OwnerNotFoundException;

/**
 * Service for managing Owner operations.
 *
 * @author Ganesh Gupta
 */
public interface OwnerService {

    /**
     * Saves a new owner.
     *
     * @param ownerDTO owner details
     * @throws DuplicateOwnerIdException if owner ID already exists
     */
    void saveOwner(OwnerDTO ownerDTO) throws DuplicateOwnerIdException;

    /**
     * Finds an owner by ID.
     *
     * @param ownerId the ID of the owner
     * @return the owner details
     * @throws OwnerNotFoundException if owner not found
     */
    OwnerDTO findOwner(int ownerId) throws OwnerNotFoundException;

    /**
     * Updates the pet's name for an owner.
     *
     * @param ownerId the owner's ID
     * @param petName the new pet name
     * @throws OwnerNotFoundException if owner not found
     */
    void updatePetDetails(int ownerId, String petName) throws OwnerNotFoundException;

    /**
     * Deletes an owner by ID.
     *
     * @param ownerId the owner's ID
     * @throws OwnerNotFoundException if owner not found
     */
    void deleteOwner(int ownerId) throws OwnerNotFoundException;

    /**
     * Gets a list of all owners.
     *
     * @return list of owners
     */
    List<OwnerDTO> findAllOwners();
}
