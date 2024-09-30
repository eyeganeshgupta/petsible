package com.petsible.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.petsible.dto.PetDTO;
import com.petsible.exception.PetNotFoundException;
import com.petsible.repository.PetRepository;
import com.petsible.service.PetService;

/**
 * Implementation of the PetService interface.
 *
 * @author Ganesh Gupta
 */
@Service
public class PetServiceImpl implements PetService {
    private final PetRepository petRepository;
    private final String petNotFound;

    /**
     * Constructor with dependency injection.
     *
     * @param petRepository Repository to manage pets
     * @param petNotFound Message for pet not found
     */
    @Autowired
    public PetServiceImpl(PetRepository petRepository, @Value("${pet.not.found}") String petNotFound) {
        this.petRepository = petRepository;
        this.petNotFound = petNotFound;
    }

    @Override
    public PetDTO findPet(int petId) throws PetNotFoundException {
        return petRepository.findById(petId)
                .orElseThrow(() -> new PetNotFoundException(String.format(petNotFound, petId)));
    }
}
