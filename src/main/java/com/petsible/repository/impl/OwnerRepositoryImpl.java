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
import com.petsible.dto.WildPetDTO;
import com.petsible.repository.OwnerRepository;

import jakarta.annotation.PostConstruct;

/**
 * Repository implementation for managing owners.
 *
 * @author Ganesh Gupta
 */
@Repository
public class OwnerRepositoryImpl implements OwnerRepository {
    private List<OwnerDTO> ownerDTOList;

    /**
     * Constructor initializing the owner list.
     */
    public OwnerRepositoryImpl() {
        this.ownerDTOList = new ArrayList<>();
    }

    /**
     * Initializes some sample owner data.
     */
    @PostConstruct
    public void init() {
        OwnerDTO ownerDTO = new OwnerDTO();
        ownerDTO.setId(1);
        ownerDTO.setFirstName("Ganesh");
        ownerDTO.setLastName("Gupta");
        ownerDTO.setGender(M);
        ownerDTO.setCity("Mumbai");
        ownerDTO.setState("Maharashtra");
        ownerDTO.setMobileNumber("8983971752");
        ownerDTO.setEmailId("eyeganeshgupta@gmail.com");

        DomesticPetDTO domesticPetDTO = new DomesticPetDTO();
        domesticPetDTO.setId(1);
        domesticPetDTO.setName("Max");
        domesticPetDTO.setGender(M);
        domesticPetDTO.setType(DOG);
        domesticPetDTO.setBirthDate(LocalDate.of(2018, 7, 26));
        ownerDTO.setPetDTO(domesticPetDTO);

        ownerDTOList.add(ownerDTO);

        ownerDTO = new OwnerDTO();
        ownerDTO.setId(2);
        ownerDTO.setFirstName("Virat");
        ownerDTO.setLastName("Gupta");
        ownerDTO.setGender(M);
        ownerDTO.setCity("Varanasi");
        ownerDTO.setState("Uttar Pradesh");
        ownerDTO.setMobileNumber("8898234049");
        ownerDTO.setEmailId("viratgupta@gmail.com");

        WildPetDTO wildPetDTO = new WildPetDTO();
        wildPetDTO.setId(2);
        wildPetDTO.setName("Fluffy");
        wildPetDTO.setGender(F);
        wildPetDTO.setType(CAT);
        wildPetDTO.setBirthPlace("Jim Corbett National Park");
        ownerDTO.setPetDTO(wildPetDTO);

        ownerDTOList.add(ownerDTO);
    }

    @Override
    public void save(OwnerDTO ownerDTO) {
        ownerDTOList.add(ownerDTO);
    }

    @Override
    public Optional<OwnerDTO> findById(int ownerId) {
        return ownerDTOList.stream().filter(owner -> owner.getId() == ownerId).findFirst();
    }

    @Override
    public void updatePetDetails(int ownerId, String petName) {
        ownerDTOList.stream().filter(owner -> owner.getId() == ownerId).findFirst()
                .ifPresent(ownerDTO -> ownerDTO.getPetDTO().setName(petName));
    }

    @Override
    public void deleteById(int ownerId) {
        ownerDTOList.removeIf(owner -> owner.getId() == ownerId);
    }

    @Override
    public List<OwnerDTO> findAll() {
        return ownerDTOList;
    }
}
