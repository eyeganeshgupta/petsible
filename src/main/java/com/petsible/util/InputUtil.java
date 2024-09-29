package com.petsible.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Scanner;

import com.petsible.dto.DomesticPetDTO;
import com.petsible.dto.OwnerDTO;
import com.petsible.dto.PetDTO;
import com.petsible.dto.WildPetDTO;
import com.petsible.enums.Gender;
import com.petsible.enums.PetType;

/**
 * Utility class to accept input details from the user.
 *
 * @author Ganesh Gupta
 */
public class InputUtil {

    private InputUtil() {
        // Private constructor to prevent instantiation
    }

    public static int acceptMenuOption(Scanner scanner) {
        System.out.println("┌─────────────────────────────┐");
        System.out.println("│  1. Add new owner            │");
        System.out.println("│  2. Fetch owner details      │");
        System.out.println("│  3. Update pet details       │");
        System.out.println("│  4. Delete owner details     │");
        System.out.println("│  5. Fetch all owners         │");
        System.out.println("│  6. Fetch pet details        │");
        System.out.println("└─────────────────────────────┘");
        int menuOption = scanner.nextInt();
        if (menuOption >= 1 && menuOption <= 6) {
            return menuOption;
        } else {
            System.out.println("Invalid option entered.");
            return acceptMenuOption(scanner);
        }
    }

    public static boolean wantToContinue(Scanner scanner) {
        System.out.println("Press Y to continue or N to exit:");
        char choice = scanner.next().toUpperCase().charAt(0);
        return 'Y' == choice;
    }

    public static OwnerDTO acceptOwnerDetailsToSave(Scanner scanner) {
        System.out.println("Enter the following details for the new owner:");
        System.out.print("ID: ");
        int id = scanner.nextInt();
        System.out.print("First Name: ");
        String firstName = scanner.next();
        System.out.print("Last Name: ");
        String lastName = scanner.next();
        System.out.println("Gender: " + Arrays.asList(Gender.values()));
        String gender = scanner.next().toUpperCase();
        System.out.print("City: ");
        String city = scanner.next();
        System.out.print("State: ");
        String state = scanner.next();
        System.out.print("Mobile Number: ");
        String mobileNumber = scanner.next();
        System.out.print("Email ID: ");
        String emailId = scanner.next();

        try {
            OwnerDTO ownerDTO = new OwnerDTO();
            ownerDTO.setId(id);
            ownerDTO.setFirstName(firstName);
            ownerDTO.setLastName(lastName);
            ownerDTO.setGender(Gender.valueOf(gender));
            ownerDTO.setCity(city);
            ownerDTO.setState(state);
            ownerDTO.setMobileNumber(mobileNumber);
            ownerDTO.setEmailId(emailId);
            return ownerDTO;
        } catch (Exception exception) {
            System.out.println("Error: " + exception.getMessage());
            return acceptOwnerDetailsToSave(scanner);
        }
    }

    public static PetDTO acceptPetDetailsToSave(Scanner scanner) {
        System.out.println("Enter the following details for the new pet:");
        System.out.print("ID: ");
        int petId = scanner.nextInt();
        System.out.print("Name: ");
        String petName = scanner.next();
        System.out.println("Type of Pet (D for Domestic, W for Wild): ");
        char choice = scanner.next().toUpperCase().charAt(0);
        String petPlaceOfBirth = null;
        String petDateOfBirth = null;

        if ('W' == choice) {
            System.out.print("Place of Birth: ");
            petPlaceOfBirth = scanner.next();
        } else if ('D' == choice) {
            System.out.print("Date of Birth (dd-MM-yyyy): ");
            petDateOfBirth = scanner.next();
        }

        System.out.println("Gender of Pet: " + Arrays.asList(Gender.values()));
        String petGender = scanner.next().toUpperCase();
        System.out.println("Type of Pet: " + Arrays.asList(PetType.values()));
        String petType = scanner.next().toUpperCase();

        try {
            PetDTO petDTO = null;
            if ('D' == choice) {
                petDTO = new DomesticPetDTO();
                ((DomesticPetDTO) petDTO).setBirthDate(convertStringToDate(petDateOfBirth));
            } else if ('W' == choice) {
                petDTO = new WildPetDTO();
                ((WildPetDTO) petDTO).setBirthPlace(petPlaceOfBirth);
            } else {
                throw new IllegalArgumentException("Unsupported pet choice: " + choice);
            }
            petDTO.setId(petId);
            petDTO.setName(petName);
            petDTO.setGender(Gender.valueOf(petGender));
            petDTO.setType(PetType.valueOf(petType));
            return petDTO;
        } catch (Exception exception) {
            System.out.println("Error: " + exception.getMessage());
            return acceptPetDetailsToSave(scanner);
        }
    }

    public static String acceptPetDetailsToUpdate(Scanner scanner) {
        System.out.print("Enter updated name of pet: ");
        return scanner.next();
    }

    public static int acceptOwnerIdToOperate(Scanner scanner) {
        System.out.print("Enter owner ID: ");
        return scanner.nextInt();
    }

    public static int acceptPetIdToOperate(Scanner scanner) {
        System.out.print("Enter pet ID: ");
        return scanner.nextInt();
    }

    private static LocalDate convertStringToDate(String stringDate) {
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        return LocalDate.parse(stringDate, format);
    }
}
