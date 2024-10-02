package com.petsible.repository.impl;

import static com.petsible.enums.Gender.F;
import static com.petsible.enums.Gender.M;
import static com.petsible.enums.PetType.CAT;
import static com.petsible.enums.PetType.DOG;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.petsible.dto.DomesticPetDTO;
import com.petsible.dto.OwnerDTO;
import com.petsible.dto.PetDTO;
import com.petsible.dto.WildPetDTO;
import com.petsible.repository.PetRepository;

import jakarta.annotation.PostConstruct;

/**
 * Repository implementation for managing pets.
 *
 * @author Ganesh Gupta
 */
@Repository
public class PetRepositoryImpl implements PetRepository {
    private List<PetDTO> petDTOList;

    /**
     * Constructor initializing the pet list.
     */
    public PetRepositoryImpl() {
        this.petDTOList = new ArrayList<>();
    }

    /**
     * Initializes some sample pet data.
     */
    @PostConstruct
    public void init() {
        DomesticPetDTO domesticPetDTO = new DomesticPetDTO();
        domesticPetDTO.setId(1);
        domesticPetDTO.setName("Max");
        domesticPetDTO.setGender(M);
        domesticPetDTO.setType(DOG);
        domesticPetDTO.setBirthDate(LocalDate.of(2018, 7, 26));

        OwnerDTO ownerDTO = new OwnerDTO();
        ownerDTO.setId(1);
        ownerDTO.setFirstName("Ganesh");
        ownerDTO.setLastName("Gupta");
        ownerDTO.setGender(M);
        ownerDTO.setCity("Mumbai");
        ownerDTO.setState("Maharashtra");
        ownerDTO.setMobileNumber("8983971752");
        ownerDTO.setEmailId("eyeganeshgupta@gmail.com");
        domesticPetDTO.setOwnerDTO(ownerDTO);

        petDTOList.add(domesticPetDTO);

        WildPetDTO wildPetDTO = new WildPetDTO();
        wildPetDTO.setId(2);
        wildPetDTO.setName("Fluffy");
        wildPetDTO.setGender(F);
        wildPetDTO.setType(CAT);
        wildPetDTO.setBirthPlace("Jim Corbett National Park");

        ownerDTO = new OwnerDTO();
        ownerDTO.setId(2);
        ownerDTO.setFirstName("Virat");
        ownerDTO.setLastName("Gupta");
        ownerDTO.setGender(M);
        ownerDTO.setCity("Varanasi");
        ownerDTO.setState("Uttar Pradesh");
        ownerDTO.setMobileNumber("8898234049");
        ownerDTO.setEmailId("viratgupta@gmail.com");
        wildPetDTO.setOwnerDTO(ownerDTO);

        petDTOList.add(wildPetDTO);
    }

    @Override
    public Optional<PetDTO> findById(int petId) {
        return petDTOList.stream().filter(pet -> pet.getId() == petId).findFirst();
    }
}
