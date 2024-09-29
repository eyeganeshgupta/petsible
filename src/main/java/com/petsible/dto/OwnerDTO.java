package com.petsible.dto;

import java.util.Objects;
import com.petsible.enums.Gender;

/**
 * Data Transfer Object (DTO) representing an Owner.
 *
 * @author Ganesh Gupta
 */
public class OwnerDTO {
    // Basic Information
    private int id;
    private String firstName;
    private String lastName;
    private Gender gender;

    // Contact Information
    private String mobileNumber;
    private String emailId;

    // Address Information
    private String city;
    private String state;

    // Associated Pet
    private PetDTO petDTO;

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public PetDTO getPetDTO() {
        return petDTO;
    }

    public void setPetDTO(PetDTO petDTO) {
        this.petDTO = petDTO;
    }

    @Override
    public String toString() {
        return String.format(
                "Owner Details:%n" +
                        "┌─────────────────────────────────────────────────%n" +
                        "│ ID: %-45d │%n" +
                        "│ Name: %-44s │%n" +
                        "│ Gender: %-42s │%n" +
                        "│ Mobile: %-42s │%n" +
                        "│ Email: %-43s │%n" +
                        "│ Location: %-40s │%n" +
                        "│ Pet: %-45s │%n" +
                        "└─────────────────────────────────────────────────",
                id,
                firstName + " " + lastName,
                gender,
                mobileNumber,
                emailId,
                city + ", " + state,
                Objects.nonNull(petDTO) ? petDTO.toString() : "No pet associated"
        );
    }
}
