package oop19_ca2_aaron_reihill;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author D00222467/Aaron Reihill
 */
public class Main
{

    static Scanner keyboard = new Scanner(System.in);
    static Registry r = new Registry();

    public static void main(String[] args)
    {
        fillReg();
        displayMenu();
    }

    public static void displayMenu()
    {
        System.out.println("Aaron Reihill CA2 (OOP)");
        boolean exit = false;
        while (!exit)
        {
            System.out.println("\nDundalk Pet Registry");
            String[] menuList =
            {
                "Exit", "Add Options", "Search Options", "Remove Options", "Edit Options", "Display Options"
            };
            displayMenuItems(menuList);
            int option = checkUserInputMenu(6);
            switch (option)
            {
                case 0:
                    System.out.println("GoodBye...");
                    exit = true;
                    break;
                case 1:
                    System.out.println("Add Option Selected...");
                    addOptions();
                    break;
                case 2:
                    System.out.println("Search Option Selected...");
                    searchOptions();
                    break;
                case 3:
                    System.out.println("Remove Option Selected...");
                    removeOptions();
                    break;
                case 4:
                    System.out.println("Edit Option Selected...");
                    editOptions();
                    break;
                case 5:
                    System.out.println("Display Option Selected...");
                    displayOptions();
                    break;
                case 6:
                    clearInvalidMenu();
                    break;
            }
            if (option > 6 || option < 0)
            {
                System.out.println("Sorry There Is No Option " + option);
                System.out.println("Please Choose Another Option From The List\n");
            }
        }

    }

    public static void addOptions()
    {
        boolean exit = false;
        while (!exit)
        {
            System.out.println("\nAdd Options");
            String[] menuList =
            {
                "Back", "Add Owner", "Add Pet"
            };
            displayMenuItems(menuList);
            int option = checkUserInputMenu(3);
            switch (option)
            {
                case 0:
                    System.out.println("Returning...\n");
                    exit = true;
                    break;
                case 1:
                    addOwner();
                    break;
                case 2:
                    addPetOption();
                    break;
                case 3:
                    clearInvalidMenu();
                    break;
            }
            if (option > 3 || option < 0)
            {
                System.out.println("Sorry There Is No Option " + option);
                System.out.println("Please Choose Another Option From The List\n");
            }
        }
    }

    public static void addOwner()
    {
        String telephone, address, name, email;
        System.out.print("\nName: ");
        name = checkUserInput("Name");
        System.out.print("Address: ");
        address = keyboard.next();
        System.out.print("Telephone: ");
        telephone = checkTelephone();
        System.out.print("Email? (Y/N): ");
        boolean added = false;
        while (!added)
        {
            String yN = keyboard.next();
            if (yN.equalsIgnoreCase("y"))
            {
                System.out.print("Email: ");
                email = checkEmail();
                r.addOwner(name, email, telephone, address);
                System.out.println("\n" + name + " added, Returning...");
                added = true;

            }
            else if (yN.equalsIgnoreCase("n"))
            {
                r.addOwner(name, telephone, address);
                System.out.println("\n" + name + " added, Returning...");
                added = true;

            }
            else
            {
                System.out.print("Please Enter Either Y or N: ");
            }
        }
    }

    public static void addPetOption()
    {
        boolean back = false;
        int id;

        while (!back)
        {
            System.out.println("\nOptions");
            String[] menuList =
            {
                "Back", "Mammal", "Fish", "Bird", "Unkown"
            };
            displayMenuItems(menuList);
            int option = checkUserInputMenu(5);
            System.out.println("Choose From ");
            r.availableOwners();
            switch (option)
            {
                case 0:
                    System.out.println("Returning...");
                    back = true;
                    break;
                case 1:
                    System.out.print("Owner ID: ");
                    id = checkUserInputInt("Owner ID");
                    if (r.findOwner(id) > -1)
                    {
                        addMammal(id);
                    }
                    else
                    {
                        System.out.println("Owner ID " + id + " Not Found");
                    }
                    break;
                case 2:
                    System.out.print("Owner ID: ");
                    id = checkUserInputInt("Owner ID");
                    if (r.findOwner(id) > -1)
                    {
                        addFish(id);
                    }
                    else
                    {
                        System.out.println("Owner ID " + id + " Not Found");
                    }
                    break;
                case 3:
                    System.out.print("Owner ID: ");
                    id = checkUserInputInt("Owner ID");
                    if (r.findOwner(id) > -1)
                    {
                        addBird(id);
                    }
                    else
                    {
                        System.out.println("Owner ID " + id + " Not Found");
                    }
                    break;
                case 4:
                    System.out.print("Owner ID: ");
                    id = checkUserInputInt("Owner ID");
                    if (r.findOwner(id) > -1)
                    {
                        addPet(id);
                    }
                    else
                    {
                        System.out.println("Owner ID " + id + " Not Found");
                    }
                    break;
                case 5:
                    clearInvalidMenu();
                    break;
            }
            if (option > 5 || option < 0)
            {
                System.out.println("Option " + option + " Is Not Valid");
                System.out.print("Please Enter Valid Option");
            }
        }
    }

    public static void addMammal(int id)
    {
        String type, name, breed, colour, gender;
        int age;
        boolean neutered = false;
        System.out.print("\nType: ");
        type = checkUserInput("Type");
        System.out.print("Name: ");
        name = checkUserInput("Name");
        System.out.print("Breed: ");
        breed = checkUserInput("Breed");
        System.out.print("Age: ");
        age = checkUserInputInt("Age");
        System.out.print("Colour: ");
        colour = checkUserInput("Colour");
        System.out.print("Gender (Male/Female/Other): ");
        gender = selectGender();
        boolean picked = false;
        System.out.print("Neutered(Y/N): ");
        while (!picked)
        {
            String option = keyboard.next();
            if (option.equalsIgnoreCase("y"))
            {
                neutered = true;
                picked = true;
            }
            else if (option.equalsIgnoreCase("n"))
            {
                neutered = false;
                picked = true;
            }
            else
            {
                System.out.print("Please Select A Valid Option:");
            }
        }
        r.getOwnerByID(id).addPet(type, name, breed, age, colour, gender, neutered);
        System.out.println("\nPet " + name + " added");
    }

    public static void addFish(int id)
    {
        String type, name, breed, colour, gender, water = "";
        int age;
        System.out.print("\nType: ");
        type = checkUserInput("Type");
        System.out.print("Name: ");
        name = checkUserInput("Name");
        System.out.print("Breed: ");
        breed = checkUserInput("Breed");
        System.out.print("Age: ");
        age = checkUserInputInt("Age");
        System.out.print("Colour: ");
        colour = checkUserInput("Colour");
        System.out.print("Gender (Male/Female/Other): ");
        gender = selectGender();
        boolean picked = false;
        System.out.print("Water(Freshwater/Seawater/Brackish/Unkown): ");
        while (!picked)
        {
            String option = keyboard.next();
            if (option.equalsIgnoreCase("FRESHWATER"))
            {
                water = option;
                picked = true;
            }
            else if (option.equalsIgnoreCase("SEAWATER"))
            {
                water = option;
                picked = true;
            }
            else if (option.equalsIgnoreCase("BRACKISH"))
            {
                water = option;
                picked = true;
            }
            else if (option.equalsIgnoreCase("UNKOWN"))
            {
                water = option;
                picked = true;
            }
            else
            {
                System.out.print("Please Select A Valid Option:");
            }
        }
        r.getOwnerByID(id).addPet(type, name, breed, age, colour, gender, water);
        System.out.println("\nPet " + name + " added");
    }

    public static void addBird(int id)
    {
        String type, name, breed, colour, gender = "";
        int age, wingspan;
        boolean fly = false;
        System.out.print("\nType: ");
        type = checkUserInput("Type");
        System.out.print("Name: ");
        name = checkUserInput("Name");
        System.out.print("Breed: ");
        breed = checkUserInput("Breed");
        System.out.print("Age: ");
        age = checkUserInputInt("Age");
        System.out.print("Wingspan(ft): ");
        wingspan = keyboard.nextInt();
        System.out.print("Colour: ");
        colour = checkUserInput("Colour");
        System.out.print("Gender (Male/Female/Other): ");
        gender = selectGender();
        boolean picked = false;
        System.out.print("Able To Fly(Y/N): ");
        while (!picked)
        {
            String option = keyboard.next();
            if (option.equalsIgnoreCase("y"))
            {
                fly = true;
                picked = true;
            }
            else if (option.equalsIgnoreCase("n"))
            {
                fly = false;
                picked = true;
            }
            else
            {
                System.out.print("Please Select A Valid Option:");
            }
        }
        r.getOwnerByID(id).addPet(type, name, breed, age, colour, gender, wingspan, fly);
        System.out.println("\nPet " + name + " added");
    }

    public static void addPet(int id)
    {
        String type, name, breed, colour, gender;
        int age;
        System.out.print("\nType: ");
        type = checkUserInput("Type");
        System.out.print("Name: ");
        name = checkUserInput("Name");
        System.out.print("Breed: ");
        breed = checkUserInput("Breed");
        System.out.print("Age: ");
        age = checkUserInputInt("Age");
        System.out.print("Colour: ");
        colour = checkUserInput("Colour");
        System.out.print("Gender (Male/Female/Other): ");
        gender = selectGender();
        r.getOwnerByID(id).addPet(type, name, breed, age, colour, gender);
        System.out.println("\nPet " + name + " added");
    }

    public static void searchOptions()
    {
        boolean back = false;
        while (!back)
        {
            System.out.println("\nSearch Options");
            String[] menuList =
            {
                "Back", "Find Owner", "Find Pet"
            };
            displayMenuItems(menuList);
            int option = checkUserInputMenu(3);
            switch (option)
            {
                case 0:
                    System.out.println("Returning...\n");
                    back = true;
                    break;
                case 1:
                    ownerSearchOptions();
                    break;
                case 2:
                    petSearchOptions();
                    break;
                case 3:
                    clearInvalidMenu();
            }
            if (option > 3 || option < 0)
            {
                System.out.println("Sorry There Is No Option " + option);
                System.out.println("Please Choose Another Option From The List\n");
            }
        }

    }

    public static void ownerSearchOptions()
    {
        String user;
        boolean back = false;
        while (!back)
        {
            System.out.println("\nOwner Search Options");
            String[] menuList =
            {
                "Back", "Find Owner By ID", "Find Owner By Name", "Find Owner By Address", "Find Owner By Telephone", "Find Owner By Email"
            };
            displayMenuItems(menuList);
            int option = checkUserInputMenu(6);
            switch (option)
            {
                case 0:
                    System.out.println("Returning...\n");
                    back = true;
                    break;
                case 1:
                    System.out.print("ID: ");
                    int id = keyboard.nextInt();
                    Owner o = r.getOwnerByID(id);
                    r.displayOwner(o);
                    break;
                case 2:
                    System.out.print("Name: ");
                    user = checkUserInput("Name");
                    r.displayOwnerByName(user);
                    break;
                case 3:
                    System.out.print("Address:");
                    user = keyboard.next();
                    r.displayOwnerByAddress(user);
                    break;
                case 4:
                    System.out.print("Telephone: ");
                    user = checkTelephone();
                    r.displayOwnerByTelephone(user);
                    break;
                case 5:
                    System.out.print("Email: ");
                    user = checkUserInput("Email");
                    r.displayOwnerByEmail(user);
                    break;
                case 6:
                    clearInvalidMenu();
                    break;
            }
            if (option > 6 || option < 0)
            {
                System.out.println("Sorry There Is No Option " + option);
                System.out.println("Please Choose Another Option From The List\n");
            }
        }
    }

    public static void petSearchOptions()
    {

        String user;
        boolean back = false;
        while (!back)
        {
            System.out.println("\nOwner Search Options");
            String[] menuList =
            {
                "Back", "Find Pet By ID", "Find Pet By Name", "Find Pet By Animal Category", "Find Pet By Type"
            };
            displayMenuItems(menuList);
            int option = checkUserInputMenu(5);
            switch (option)
            {
                case 0:
                    System.out.println("Returning...\n");
                    back = true;
                    break;
                case 1:
                    System.out.print("\nID: ");
                    int id = checkUserInputInt("ID");
                    r.displayPetByID(id);
                    break;
                case 2:
                    System.out.print("\nName: ");
                    user = checkUserInput("Name");
                    r.displayPetByName(user);
                    break;
                case 3:
                    System.out.print("\nAnimal Category: ");
                    user = checkUserInput("Animal Category");
                    r.displayPetByCategory(user);
                    break;
                case 4:
                    System.out.print("\nType: ");
                    user = checkUserInput("Type");
                    r.displayPetByType(user);
                    break;
                case 5:
                    clearInvalidMenu();
                    break;
            }
            if (option > 5 || option < 0)
            {
                System.out.println("Sorry There Is No Option " + option);
                System.out.println("Please Choose Another Option From The List\n");
            }
        }
    }

    public static void displayOptions()
    {
        boolean back = false;
        while (!back)
        {
            System.out.println("\nDisplay Options");
            String[] menuList =
            {
                "Back", "Display Owner(s)", "Display Pet(s)"
            };
            displayMenuItems(menuList);
            int option = checkUserInputMenu(3);
            switch (option)
            {
                case 0:
                    System.out.println("Returning...\n");
                    back = true;
                    break;
                case 1:
                    r.displayAllOwners();
                    break;
                case 2:
                    displayPets();
                    break;
                case 3:
                    clearInvalidMenu();
                    break;
            }
            if (option > 3 && option < 0)
            {
                System.out.println("Sorry There Is No Option " + option);
                System.out.println("Please Choose Another Option From The List\n");
            }
        }
    }

    public static void displayPets()
    {
        boolean back = false;
        while (!back)
        {
            System.out.println("\nPet Display");
            String[] menuList =
            {
                "Back", "Display Pet By Owner ID", "Display All Pet(s) Registered", "Display By Animal Category"
            };
            displayMenuItems(menuList);
            int option = checkUserInputMenu(4);
            switch (option)
            {
                case 0:
                    System.out.println("Returning...");
                    back = true;
                    break;
                case 1:
                    System.out.println();
                    r.availableOwners();
                    System.out.print("\nSelect An Owner(ID) To Display There Pets: ");
                    int id = checkUserInputInt("Select An Owner(ID) To Display There Pets");
                    r.displayOwnersPet(id);
                    break;
                case 2:
                    r.displayAllPets();
                    break;
                case 3:
                    displayByAnimalCategory();
                    break;
                case 4:
                    clearInvalidMenu();
                    break;

            }
            if (option > 4 && option < 0)
            {
                System.out.println("Sorry There Is No Option " + option);
                System.out.println("Please Choose Another Option From The List\n");
            }
        }
    }

    public static void displayByAnimalCategory()
    {
        boolean back = false;
        while (!back)
        {
            System.out.println("\nAnimalCategory");
            String[] menuList =
            {
                "Back", "Mammal", "Fish", "Bird"
            };
            displayMenuItems(menuList);
            int option = checkUserInputMenu(4);
            switch (option)
            {
                case 0:
                    System.out.println("Returning...");
                    back = true;
                    break;
                case 1:
                    r.displayMammals();
                    break;
                case 2:
                    r.displayFish();
                    break;
                case 3:
                    r.displayBirds();
                    break;
                case 4:
                    clearInvalidMenu();
                    break;

            }
            if (option > 4 && option < 0)
            {
                System.out.println("Sorry There Is No Option " + option);
                System.out.println("Please Choose Another Option From The List\n");
            }
        }

    }

    public static void removeOptions()
    {
        boolean back = false;
        int id;
        while (!back)
        {
            System.out.println("\nRemove Options");
            String[] menuList =
            {
                "Back", "Remove Owner", "Remove Pet"
            };
            displayMenuItems(menuList);
            int option = checkUserInputMenu(3);
            switch (option)
            {
                case 0:
                    System.out.println("Returning...\n");
                    back = true;
                    break;
                case 1:
                    r.availableOwners();
                    System.out.print("Remove(ID):");
                    id = checkUserInputInt("Remove(ID)");
                    if (r.findOwner(id) != -1)
                    {
                        System.out.println("Owner " + r.getOwnerByID(id).getName() + " removed");
                        r.removeOwner(id);
                    }
                    else
                    {
                        System.out.println("Owner ID " + id + " Not Found");
                    }
                    break;
                case 2:
                    r.availableOwners();
                    System.out.print("Select Pets Owner ID: ");
                    id = checkUserInputInt("Select Pets Owner ID");
                    r.displayOwnersPet(id);
                    System.out.print("\nPet ID: ");
                    int petID = checkUserInputInt("Pet ID");
                    System.out.println(r.petsName(id, petID) + " Removed");
                    r.removePet(id, petID);
                    break;
                case 3:
                    clearInvalidMenu();
                    break;
            }
            if (option > 3 && option < 0)
            {
                System.out.println("Sorry There Is No Option " + option);
                System.out.println("Please Choose Another Option From The List\n");
            }
        }
    }

    public static void editOptions()
    {
        boolean back = false;

        while (!back)
        {
            System.out.println("\nEdit Options");
            String[] menuList =
            {
                "Back", "Edit Owner", "Edit Pet"
            };
            displayMenuItems(menuList);
            int option = checkUserInputMenu(3);
            switch (option)
            {
                case 0:
                    System.out.println("Returning...");
                    back = true;
                    break;
                case 1:
                    editOwner();
                    break;
                case 2:
                    editPet();
                    break;
                case 3:
                    clearInvalidMenu();
                    break;
            }
            if (option > 3 || option < 0)
            {
                System.out.println("Sorry There Is No Option " + option);
                System.out.println("Please Choose Another Option From The List\n");
            }

        }
    }

    public static void editOwner()
    {
        r.availableOwners();
        System.out.print("\nEnter Owner ID To Edit: ");
        int id = checkUserInputInt("Enter Owner ID To Edit");
        int userInput;
        String user;
        boolean back = false;
        while (!back)
        {

            System.out.println("\nEdit Owner Options");
            String[] menuList =
            {
                "Back", "Name", "Id", "Telephone", "Address", "Email"
            };
            displayMenuItems(menuList);
            int option = checkUserInputMenu(6);
            switch (option)
            {
                case 0:
                    System.out.println("Returning...");
                    back = true;
                    break;
                case 1:
                    System.out.print("\nNew Name: ");
                    user = checkUserInput("New Name");
                    r.changeOwnerName(id, user);
                    break;
                case 2:
                    System.out.print("New Id: ");
                    userInput = checkUserInputInt("New Id");
                    r.changeOwnerId(id, userInput);
                    if (r.checkOwnerId(userInput))
                    {
                        id = userInput;
                    }
                    break;
                case 3:
                    System.out.print("\nNew Telephone: ");
                    user = checkTelephone();
                    r.changeOwnerTelephone(id, user);
                    break;
                case 4:
                    System.out.print("New Address: ");
                    user = keyboard.next();
                    r.changeOwnerAddress(id, user);
                    break;
                case 5:
                    System.out.print("New Email: ");
                    user = checkEmail();
                    r.changeOwnerEmail(id, user);
                    break;
                case 6:
                    clearInvalidMenu();
                    break;
            }
            if (option > 6 || option < 0)
            {
                System.out.println("Sorry There Is No Option " + option);
                System.out.println("Please Choose Another Option From The List\n");
            }
        }
    }

    /*
    @TODO Make animal things editable like water and nutered and fly and wingspan
     */
    public static void editPet()
    {
        String user;
        int userInput;
        r.availableOwners();
        System.out.print("\nEnter Pets Owner ID: ");
        int id = checkUserInputInt("Enter Pets Owner ID");
        r.displayOwnersPet(id);
        System.out.print("\nPet ID: ");
        id = checkUserInputInt("Pet ID");

        boolean back = false;
        while (!back)
        {
            System.out.println("\nEdit Pet Options");
            String[] menuList =
            {
                "Back", "Animal Category", "Name", "Breed", "Age", "Next Page"
            };
            displayMenuItems(menuList);
            int option = checkUserInputMenu(6);
            switch (option)
            {
                case 0:
                    System.out.println("Returning...");
                    back = true;
                    break;
                case 1:
                    System.out.println("\nCategory To Change To: ");
                    user = checkUserInput("Category To Change To");
                    r.changePetAnimalCategory(id, user);
                    break;
                case 2:
                    r.displayPetByID(id);
                    System.out.print("\nChange Name To: ");
                    user = checkUserInput("Change Name To");
                    r.changePetName(id, user);
                    break;
                case 3:
                    r.displayPetByID(id);
                    System.out.print("\nChange Breed To: ");
                    user = checkUserInput("Change Breed To");
                    r.changePetBreed(id, user);
                    break;
                case 4:
                    r.displayPetByID(id);
                    System.out.print("\nChange Age To: ");
                    userInput = checkUserInputInt("Change Age To");
                    r.changePetAge(id, userInput);
                    break;
                case 5:
                    Pet p = r.getPetById(id);
                    if (p instanceof Mammal)
                    {
                        editMammal(id);
                    }
                    else if (p instanceof Fish)
                    {

                    }
                    else if (p instanceof Bird)
                    {

                    }
                    else
                    {
                    editPetNextPage(id);
                    }
                    break;
                case 6:
                    clearInvalidMenu();
                    break;
            }
            if (option > 6 || option < 0)
            {
                System.out.println("\nSorry There Is No Option " + option);
                System.out.println("Please Choose Another Option From The List\n");
            }
        }
    }

    public static void editPetNextPage(int id)
    {
        String user;
        int userInput;
        boolean back = false;
        while (!back)
        {
            System.out.println("\nSecond Page...");
            System.out.println("(6) Back");
            System.out.println("(7) Owner");
            System.out.println("(8) Gender");
            System.out.println("(9) Date Registered");
            System.out.print("Select An Option: ");
            int option = checkUserInputMenu(10);
            switch (option)
            {
                case 6:
                    System.out.println("Returning...");
                    back = true;
                    break;
                case 7:
                    r.displayPetByID(id);
                    System.out.print("\nChange Owner Id To: ");
                    userInput = checkUserInputInt("Change Owner Id To");
                    r.changePetOwner(id, userInput);
                    break;
                case 8:
                    r.displayPetByID(id);
                    System.out.print("\nChange Gender To: ");
                    user = checkUserInput("Change Gender To");
                    r.changePetGender(id, user);
                    break;
                case 9:
                    r.displayPetByID(id);
                    System.out.print("\nChange Registered Date To: ");
                    user = keyboard.next();
                    r.changePetRegDate(id, user);
                    break;
                case 10:
                    clearInvalidMenu();
                    break;
            }
            if (option > 10 || option < 0)
            {
                System.out.println("Sorry There Is No Option " + option);
                System.out.println("Please Choose Another Option From The List\n");
            }
        }
    }

    public static void editMammal(int id)
    {
        String user;
        int userInput;
        boolean back = false;
        while (!back)
        {
            System.out.println("\nSecond Page...");
            System.out.println("(6) Back");
            System.out.println("(7) Owner");
            System.out.println("(8) Gender");
            System.out.println("(9) Date Registered");
            System.out.println("(10) Neutered");
            System.out.print("Select An Option: ");
            int option = checkUserInputMenu(11);
            switch (option)
            {
                case 6:
                    System.out.println("Returning...");
                    back = true;
                    break;
                case 7:
                    r.displayPetByID(id);
                    System.out.print("\nChange Owner Id To: ");
                    userInput = checkUserInputInt("Change Owner Id To");
                    r.changePetOwner(id, userInput);
                    break;
                case 8:
                    r.displayPetByID(id);
                    System.out.print("\nChange Gender To: ");
                    user = checkUserInput("Change Gender To");
                    r.changePetGender(id, user);
                    break;
                case 9:
                    r.displayPetByID(id);
                    System.out.print("\nChange Registered Date To: ");
                    user = keyboard.next();
                    r.changePetRegDate(id, user);
                    break;
                case 10:
                    System.out.print("\nChange Neutered Status To: ");
                    user = checkUserInput("Change Neutered Status To");
                    r.changePetNeutered(id,user);
                    break;
                case 11:
                    clearInvalidMenu();
                    break;
            }
            if (option > 11 || option < 0)
            {
                System.out.println("Sorry There Is No Option " + option);
                System.out.println("Please Choose Another Option From The List\n");
            }
        }
    }

    public static void fillReg()
    {
        Owner greg = new Owner("Greg", "greg@gmail.com", "0853151", "Dundalk");
        greg.addPet("bear", "bob", "fire", 404, "green", "male");
        greg.addPet("goldfish", "goldy", "water", 4, "white", "other", "freshwater");
        greg.addPet("cat", "tim", "fire", 224, "pink", "female", false);
        greg.addPet("bird", "bob", "fire", 44, "green", "male", 44, false);

        Owner kevin = new Owner("Kevin", "kevins@gmail.com", "0861415", "Dundalk,Ireland");
        kevin.addPet("beadr", "bob", "fire", 404, "green", "male");
        kevin.addPet("koda", "goldy", "water", 4, "white", "other", "freshwater");
        kevin.addPet("thing", "tim", "fire", 224, "pink", "female", true);
        kevin.addPet("bird", "bob", "fire", 44, "green", "other", 44, false);
        kevin.addPet("beadsr", "bobe", "fire", 404, "green", "male");
        kevin.addPet("koda", "goldy", "water", 4, "white", "other", "freshwater");
        kevin.addPet("thin2g", "tim", "earth", 2224, "green", "female", true);
        kevin.addPet("bird", "bob", "fire", 44, "green", "male", 44, false);
        r.addOwner(greg);
        r.addOwner(kevin);

        //r.loadOwnerData("E:\\Year 2\\Sem 1\\OOJava\\oop19_ca2_aaron_reihill\\src\\oop19_ca2_aaron_reihill\\OwnerData.csv");
        //r.loadPetData("PetData.csv");
    }

    private static void clearInvalidMenu()
    {
        System.out.println("Select A Vaild Option");
        keyboard.nextLine();
    }

    private static int checkUserInputMenu(int failOption)
    {
        int option;
        try
        {
            option = keyboard.nextInt();

        }
        catch (InputMismatchException e)
        {
            System.out.println("\nInput Is Not A Number");
            option = failOption;
        }
        return option;
    }

    private static String checkUserInput(String message)
    {
        boolean word = false;
        String input = keyboard.next();
        while (!word)
        {
            if (input.matches("[a-zA-Z]{1,54}"))
            {
                word = true;
            }
            else
            {
                System.out.println("Invalid Input Try Again");
                System.out.print("\n" + message + ": ");
                input = keyboard.next();
            }
        }
        return input;
    }

    private static String checkTelephone()
    {
        String telephone = "";
        boolean telephoneValid = false;
        while (!telephoneValid)
        {
            telephone = keyboard.next();
            if (telephone.matches("[0-9]{10}"))
            {
                telephoneValid = true;
            }
            else
            {
                System.out.println("Input Is Not A Valid Telephone Number");
                System.out.print("Telephone: ");
            }
        }
        return telephone;
    }

    private static int checkUserInputInt(String message)
    {
        boolean number = false;
        int input = 0;
        while (!number)
        {
            try
            {
                input = keyboard.nextInt();
                number = true;
            }
            catch (InputMismatchException e)
            {
                System.out.println("Invalid Input Try Again");
                System.out.print("\n" + message + ": ");
                keyboard.nextLine();
            }
        }
        return input;
    }

    private static String checkEmail()
    {
        String email = "";
        boolean emailValid = false;
        while (!emailValid)
        {
            email = keyboard.next();
            if (email.matches("^(.+)@(.+)$"))
            {
                emailValid = true;
            }
            else
            {
                System.out.println("Input Is Not A Valid Telephone Number");
                System.out.print("Email: ");
            }
        }
        return email;
    }

    private static void displayMenuItems(String[] list)
    {
        for (int i = 0; i < list.length; i++)
        {
            System.out.println("(" + i + ") " + list[i]);
        }
        System.out.print("Select An Option: ");
    }

    public static String selectGender()
    {
        String gender = "";
        boolean picked = false;
        while (!picked)
        {
            gender = keyboard.next();
            if (gender.equalsIgnoreCase("male"))
            {
                picked = true;
            }
            else if (gender.equalsIgnoreCase("female"))
            {
                picked = true;
            }
            else if (gender.equalsIgnoreCase("UNKOWN"))
            {
                picked = true;
            }
            else
            {
                System.out.print("Please Select A Valid Option:");
            }
        }
        return gender;
    }
}
