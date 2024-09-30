package com.petsible;

import com.petsible.dto.OwnerDTO;
import com.petsible.dto.PetDTO;
import com.petsible.service.OwnerService;
import com.petsible.service.PetService;
import com.petsible.util.InputUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.Scanner;

@SuppressWarnings("SpellCheckingInspection")
@SpringBootApplication
public class PetsibleApplication implements CommandLineRunner {

	// ========== Services ==========
	private final OwnerService ownerService;
	private final PetService petService;

	// ========== Logger ==========
	private static final Logger LOGGER = LoggerFactory.getLogger(PetsibleApplication.class);

	// ========== Constants ==========
	private static final StringBuilder WELCOME_MESSAGE = new StringBuilder()
			.append("\n")
			.append("╔═══════════════════════════════════════╗\n")
			.append("║           Welcome to Petsible         ║\n")
			.append("╚═══════════════════════════════════════╝");

	private static final StringBuilder MENU = new StringBuilder()
			.append("\n1. Add new owner and pet")
			.append("\n2. Find owner")
			.append("\n3. Update pet details")
			.append("\n4. Delete owner")
			.append("\n5. List all owners")
			.append("\n6. Find pet")
			.append("\n0. Exit")
			.append("\nEnter your choice: ");

	// ========== Constructor ==========
	@Autowired
	public PetsibleApplication(OwnerService ownerService, PetService petService) {
		this.ownerService = ownerService;
		this.petService = petService;
	}

	// ========== Main Method ==========
	public static void main(String[] args) {
		SpringApplication.run(PetsibleApplication.class, args);
	}

	// ========== CommandLineRunner Implementation ==========
	@Override
	public void run(String... args) {
		try (Scanner scanner = new Scanner(System.in)) {
            do {
                System.out.println(WELCOME_MESSAGE);
                System.out.print(MENU);

                int menuOption = InputUtil.acceptMenuOption(scanner);
                if (menuOption == 0) {
                    break;
                }

                processMenuOption(menuOption, scanner);

                if (!InputUtil.wantToContinue(scanner)) {
                    break;
                }
            } while (true);
		} catch (Exception exception) {
			LOGGER.error("An error occurred: {}", exception.getMessage(), exception);
		}
	}

	// ========== Menu Processing ==========
	private void processMenuOption(int menuOption, Scanner scanner) {
		switch (menuOption) {
			case 1 -> addNewOwnerAndPet(scanner);
			case 2 -> findOwner(scanner);
			case 3 -> updatePetDetails(scanner);
			case 4 -> deleteOwner(scanner);
			case 5 -> listAllOwners();
			case 6 -> findPet(scanner);
			default -> System.out.println("Invalid option entered.");
		}
	}

	// ========== Menu Actions ==========
	private void addNewOwnerAndPet(Scanner scanner) {
		OwnerDTO ownerDTO = InputUtil.acceptOwnerDetailsToSave(scanner);
		PetDTO petDTO = InputUtil.acceptPetDetailsToSave(scanner);
		ownerDTO.setPetDTO(petDTO);
		ownerService.saveOwner(ownerDTO);
		System.out.println("Owner and pet have been saved successfully.");
	}

	private void findOwner(Scanner scanner) {
		int ownerId = InputUtil.acceptOwnerIdToOperate(scanner);
		OwnerDTO ownerDTO = ownerService.findOwner(ownerId);
		System.out.println("Owner has been fetched successfully.");
		System.out.println(ownerDTO);
	}

	private void updatePetDetails(Scanner scanner) {
		int ownerId = InputUtil.acceptOwnerIdToOperate(scanner);
		String petName = InputUtil.acceptPetDetailsToUpdate(scanner);
		ownerService.updatePetDetails(ownerId, petName);
		System.out.println("Pet details of owner have been updated successfully.");
	}

	private void deleteOwner(Scanner scanner) {
		int ownerId = InputUtil.acceptOwnerIdToOperate(scanner);
		ownerService.deleteOwner(ownerId);
		System.out.println("Owner has been deleted successfully.");
	}

	private void listAllOwners() {
		List<OwnerDTO> ownerDTOList = ownerService.findAllOwners();
		System.out.println("There are " + ownerDTOList.size() + " owners.");
		ownerDTOList.forEach(System.out::println);
	}

	private void findPet(Scanner scanner) {
		int petId = InputUtil.acceptPetIdToOperate(scanner);
		PetDTO petDTO = petService.findPet(petId);
		System.out.println("Pet has been fetched successfully.");
		System.out.println(petDTO);
	}
}
