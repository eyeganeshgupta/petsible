package com.petsible.dto;

import java.util.Objects;
import com.petsible.enums.Gender;
import com.petsible.enums.PetType;

/**
 * Data Transfer Object (DTO) representing a Pet.
 *
 * @author Ganesh Gupta
 */
public class PetDTO {
    // Basic Information
    private int id;
    private String name;
    private Gender gender;
    private PetType type;

    // Associated Owner
    private OwnerDTO ownerDTO;

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public PetType getType() {
        return type;
    }

    public void setType(PetType type) {
        this.type = type;
    }

    public OwnerDTO getOwnerDTO() {
        return ownerDTO;
    }

    public void setOwnerDTO(OwnerDTO ownerDTO) {
        this.ownerDTO = ownerDTO;
    }

    @Override
    public String toString() {
        return String.format(
                "Pet Details:%n" +
                        "┌─────────────────────────────────────────────────%n" +
                        "│ ID: %-45d │%n" +
                        "│ Name: %-44s │%n" +
                        "│ Gender: %-42s │%n" +
                        "│ Type: %-44s │%n" +
                        "│ Owner: %-43s │%n" +
                        "└─────────────────────────────────────────────────",
                id,
                name,
                gender,
                type,
                Objects.nonNull(ownerDTO) ? ownerDTO.getFirstName() + " " + ownerDTO.getLastName() : "No owner associated"
        );
    }
}
