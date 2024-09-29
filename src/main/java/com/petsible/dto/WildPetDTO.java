package com.petsible.dto;

import java.util.Objects;

/**
 * Data Transfer Object (DTO) representing a Wild Pet.
 *
 * @author Ganesh Gupta
 */
public class WildPetDTO extends PetDTO {
    private String birthPlace;

    // Getters and Setters
    public String getBirthPlace() {
        return birthPlace;
    }

    public void setBirthPlace(String birthPlace) {
        this.birthPlace = birthPlace;
    }

    @Override
    public String toString() {
        return String.format(
                "Wild Pet Details:%n" +
                        "┌─────────────────────────────────────────────────%n" +
                        "│ ID: %-45d │%n" +
                        "│ Name: %-44s │%n" +
                        "│ Gender: %-42s │%n" +
                        "│ Type: %-43s │%n" +
                        "│ Birthplace: %-39s │%n" +
                        "│ Owner: %-44s │%n" +
                        "└─────────────────────────────────────────────────",
                getId(),
                getName(),
                getGender(),
                getType(),
                birthPlace,
                Objects.nonNull(getOwnerDTO()) ? getOwnerDTO().toString() : "No owner associated"
        );
    }
}
