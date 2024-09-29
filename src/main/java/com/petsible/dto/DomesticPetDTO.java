package com.petsible.dto;

import java.time.LocalDate;
import java.util.Objects;

/**
 * Data Transfer Object (DTO) representing a Domestic Pet.
 *
 * @author Ganesh Gupta
 */
public class DomesticPetDTO extends PetDTO {
    private LocalDate birthDate;

    // Getters and Setters
    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    @Override
    public String toString() {
        return String.format(
                "Domestic Pet Details:%n" +
                        "┌─────────────────────────────────────────────────%n" +
                        "│ ID: %-45d │%n" +
                        "│ Name: %-44s │%n" +
                        "│ Gender: %-42s │%n" +
                        "│ Type: %-43s │%n" +
                        "│ Birth Date: %-39s │%n" +
                        "│ Owner: %-44s │%n" +
                        "└─────────────────────────────────────────────────",
                getId(),
                getName(),
                getGender(),
                getType(),
                birthDate != null ? birthDate : "N/A",
                Objects.nonNull(getOwnerDTO()) ? getOwnerDTO().toString() : "No owner associated"
        );
    }
}
