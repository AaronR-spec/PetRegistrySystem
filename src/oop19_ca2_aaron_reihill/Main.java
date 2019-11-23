/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oop19_ca2_aaron_reihill;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author D00222467
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
            System.out.println("(0) Exit");
            System.out.println("(1) Add Options");
            System.out.println("(2) Search Options");
            System.out.println("(3) Remove Options");
            System.out.println("(4) Edit Options");
            System.out.println("(5) Display Options");
            System.out.print("Select an option: ");
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
            System.out.println("(0) Back");
            System.out.println("(1) Add Owner");
            System.out.println("(2) Add Pet");
            System.out.print("Select an option: ");
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
        boolean inValid = false;
        while (!inValid)
        {
            System.out.print("\nName: ");
            String name = keyboard.next();
            if (!checkUserInput(name))
            {
                System.out.println("Invalid Input\nReturning...");
                return;
            }
            System.out.print("Address: ");
            String address = keyboard.next();
            if (!checkUserInput(address))
            {
                System.out.println("Invalid Input\nReturning...");
                return;
            }
            System.out.print("Telephone: ");
            String telephone = keyboard.next();
            if (!checkUserInput(telephone))
            {
                System.out.println("Invalid Input\nReturning...");
                return;
            }
            System.out.print("Email? (Y/N): ");
            boolean added = false;
            while (!added)
            {
                String yN = keyboard.next();
                if (yN.equalsIgnoreCase("y"))
                {
                    System.out.print("Email: ");
                    String email = keyboard.next();
                    r.addOwner(name, email, telephone, address);
                    System.out.println(name + " added, Returning...");
                    added = true;
                }
                else if (yN.equalsIgnoreCase("n"))
                {
                    r.addOwner(name, telephone, address);
                    System.out.println(name + " added, Returning...");
                    added = true;
                }
                else
                {
                    System.out.print("Please Enter Either Y or N: ");
                }
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
            System.out.println("(0) Back");
            System.out.println("(1) Mammal");
            System.out.println("(2) Fish");
            System.out.println("(3) Bird");
            System.out.println("(4) Unkown");
            System.out.print("Select an option: ");
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
                    id = keyboard.nextInt();
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
                    id = keyboard.nextInt();
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
                    id = keyboard.nextInt();
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
                    id = keyboard.nextInt();
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
            if (option > 4 || option < 0)
            {
                System.out.println("Option " + option + " Is Not Valid");
                System.out.print("Please Enter Valid Option");
            }
        }
    }

    public static void addMammal(int id)
    {
        String type, name, breed, colour, gender = "";
        int age;
        boolean neutered = false;
        System.out.print("\nType: ");
        type = keyboard.next();
        System.out.print("Name: ");
        name = keyboard.next();
        System.out.print("Breed: ");
        breed = keyboard.next();
        System.out.print("Age: ");
        age = keyboard.nextInt();
        System.out.print("Colour: ");
        colour = keyboard.next();
        System.out.print("Gender (Male/Female/Other): ");
        boolean picked = false;
        while (!picked)
        {
            gender = keyboard.next();
            if (gender.equalsIgnoreCase("male"))
            {
                gender = "MALE";
                picked = true;
            }
            else if (gender.equalsIgnoreCase("female"))
            {
                gender = "FEMALE";
                picked = true;
            }
            else if (gender.equalsIgnoreCase("UNKOWN"))
            {
                gender = "UNKOWN";
                picked = true;
            }
            else
            {
                System.out.print("Please Select A Valid Option:");
            }
        }
        picked = false;
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
        System.out.println("Pet " + name + " added");
    }

    public static void addFish(int id)
    {
        String type, name, breed, colour, gender = "", water = "";
        int age;
        System.out.print("\nType: ");
        type = keyboard.next();
        System.out.print("Name: ");
        name = keyboard.next();
        System.out.print("Breed: ");
        breed = keyboard.next();
        System.out.print("Age: ");
        age = keyboard.nextInt();
        System.out.print("Colour: ");
        colour = keyboard.next();
        System.out.print("Gender (Male/Female/Other): ");
        boolean picked = false;
        while (!picked)
        {
            gender = keyboard.next();
            if (gender.equalsIgnoreCase("male"))
            {
                gender = "MALE";
                picked = true;
            }
            else if (gender.equalsIgnoreCase("female"))
            {
                gender = "FEMALE";
                picked = true;
            }
            else if (gender.equalsIgnoreCase("UNKOWN"))
            {
                gender = "UNKOWN";
                picked = true;
            }
            else
            {
                System.out.print("Please Select A Valid Option:");
            }
        }
        picked = false;
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
    }

    public static void addBird(int id)
    {
        String type, name, breed, colour, gender = "";
        int age, wingspan;
        boolean fly = false;
        System.out.print("\nType: ");
        type = keyboard.next();
        System.out.print("Name: ");
        name = keyboard.next();
        System.out.print("Breed: ");
        breed = keyboard.next();
        System.out.print("Age: ");
        age = keyboard.nextInt();
        System.out.print("Wingspan(ft): ");
        wingspan = keyboard.nextInt();
        System.out.print("Colour: ");
        colour = keyboard.next();
        System.out.print("Gender (Male/Female/Other): ");
        boolean picked = false;
        while (!picked)
        {
            gender = keyboard.next();
            if (gender.equalsIgnoreCase("male"))
            {
                gender = "MALE";
                picked = true;
            }
            else if (gender.equalsIgnoreCase("female"))
            {
                gender = "FEMALE";
                picked = true;
            }
            else if (gender.equalsIgnoreCase("UNKOWN"))
            {
                gender = "UNKOWN";
                picked = true;
            }
            else
            {
                System.out.print("Please Select A Valid Option:");
            }
        }
        picked = false;
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
        System.out.println("Pet " + name + " added");
    }

    public static void addPet(int id)
    {
        String type, name, breed, colour, gender = "";
        int age;
        System.out.print("\nType: ");
        type = keyboard.next();
        System.out.print("Name: ");
        name = keyboard.next();
        System.out.print("Breed: ");
        breed = keyboard.next();
        System.out.print("Age: ");
        age = keyboard.nextInt();
        System.out.print("Colour: ");
        colour = keyboard.next();
        System.out.print("Gender (Male/Female/Other): ");
        boolean picked = false;
        while (!picked)
        {
            gender = keyboard.next();
            if (gender.equalsIgnoreCase("male"))
            {
                gender = "MALE";
                picked = true;
            }
            else if (gender.equalsIgnoreCase("female"))
            {
                gender = "FEMALE";
                picked = true;
            }
            else if (gender.equalsIgnoreCase("other"))
            {
                gender = "UNKOWN";
                picked = true;
            }
            else
            {
                System.out.print("Please Select A Valid Option:");
            }
        }
        r.getOwnerByID(id).addPet(type, name, breed, age, colour, gender);
        System.out.println("Pet " + name + " added");
    }

    public static void searchOptions()
    {
        boolean back = false;
        while (!back)
        {
            System.out.println("\nSearch Options");
            System.out.println("(0) Back");
            System.out.println("(1) Find Owner");
            System.out.println("(2) Find Pet");
            System.out.print("Select an option:  ");
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
        String user = "";
        boolean back = false;
        while (!back)
        {
            System.out.println("\nOwner Search Options");
            System.out.println("(0) Back");
            System.out.println("(1) Find Owner By ID");
            System.out.println("(2) Find Owner By Name");
            System.out.println("(3) Find Owner By Address");
            System.out.println("(4) Find Owner By Telephone");
            System.out.println("(5) Find Owner By Email");
            System.out.print("Select an option: ");
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
                    user = keyboard.next();
                    r.displayOwnerByName(user);
                    break;
                case 3:
                    System.out.print("Address:");
                    user = keyboard.next();
                    r.displayOwnerByAddress(user);
                    break;
                case 4:
                    System.out.print("Telephone Number: ");
                    user = keyboard.next();
                    r.displayOwnerByTelephone(user);
                    break;
                case 5:
                    System.out.print("Email: ");
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
            System.out.println("(0) Back");
            System.out.println("(1) Find Pet By ID");
            System.out.println("(2) Find Pet By Name");
            System.out.println("(3) Find Pet By Animal Category");
            System.out.println("(4) Find Pet By Type");
            System.out.print("Select an option: ");
            int option = checkUserInputMenu(5);
            switch (option)
            {
                case 0:
                    System.out.println("Returning...\n");
                    back = true;
                    break;
                case 1:
                    System.out.print("\nID: ");
                    int id = keyboard.nextInt();
                    r.displayPetByID(id);
                    break;
                case 2:
                    System.out.print("\nName: ");
                    user = keyboard.next();
                    r.displayPetByName(user);
                    break;
                case 3:
                    System.out.print("\nAnimal Category: ");
                    user = keyboard.next();
                    r.displayPetByCategory(user);
                    break;
                case 4:
                    System.out.print("\nType: ");
                    user = keyboard.next();
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
            System.out.println("(0) Back");
            System.out.println("(1) Display Owner(s)");
            System.out.println("(2) Display Pet(s)");
            System.out.print("Select an option:  ");
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
            System.out.println("\n(0) Back");
            System.out.println("(1) Display Pet By Owner ID");
            System.out.println("(2) Display All Pet(s) Registered");
            System.out.print("Select an option: ");
            int option = checkUserInputMenu(3);
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
                    int id = keyboard.nextInt();
                    r.displayOwnersPet(id);
                    break;
                case 2:
                    r.displayAllPets();
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

    public static void removeOptions()
    {
        boolean back = false;
        int id;
        while (!back)
        {
            System.out.println("\nDisplay Options");
            System.out.println("(0) Back");
            System.out.println("(1) Remove Owner");
            System.out.println("(2) Remove Pet");
            System.out.print("Select an option:  ");
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
                    id = keyboard.nextInt();
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
                    id = keyboard.nextInt();
                    r.displayOwnersPet(id);
                    System.out.print("\nPet ID: ");
                    int petID = keyboard.nextInt();
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
            System.out.println("(0) Back");
            System.out.println("(1) Edit Owner");
            System.out.println("(2) Edit Pet");
            System.out.print("Select an Option: ");
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
        int id = keyboard.nextInt();
        int userInput;
        String user;
        boolean back = false;
        while (!back)
        {
            System.out.println("\nEdit Owner Options");
            System.out.println("(0) Back");
            System.out.println("(1) Name");
            System.out.println("(2) Id");
            System.out.println("(3) Telephone");
            System.out.println("(4) Address");
            System.out.println("(5) Email");
            System.out.print("Select An Option: ");
            int option = checkUserInputMenu(6);
            switch (option)
            {
                case 0:
                    System.out.println("Returning...");
                    back = true;
                    break;
                case 1:
                    System.out.print("\nNew Name: ");
                    user = keyboard.next();
                    r.changeOwnerName(id, user);
                    break;
                case 2:
                    System.out.print("New Id: ");
                    userInput = keyboard.nextInt();
                    r.changeOwnerId(id, userInput);
                    if (r.checkOwnerId(userInput))
                    {
                        id = userInput;
                    }
                    break;
                case 3:
                    System.out.print("\nNew Telephone: ");
                    user = keyboard.next();
                    r.changeOwnerTelephone(id, user);
                    break;
                case 4:
                    System.out.print("New Address: ");
                    user = keyboard.next();
                    r.changeOwnerAddress(id, user);
                    break;
                case 5:
                    System.out.print("New Email: ");
                    user = keyboard.next();
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

    public static void editPet()
    {
        String user;
        int userInput;
        r.availableOwners();
        System.out.print("\nEnter Pets Owner ID: ");
        int id = keyboard.nextInt();
        r.displayOwnersPet(id);
        System.out.print("\nPet ID: ");
        id = keyboard.nextInt();
        boolean back = false;
        Pet p = r.getPetById(id);
        while (!back)
        {
            System.out.println("\nEdit Pet Options");
            System.out.println("(0) Back");
            System.out.println("(1) Animal Category");
            System.out.println("(2) Name");
            System.out.println("(3) Breed");
            System.out.println("(4) Age");
            System.out.println("(5) Next Page");
            System.out.print("Select An Option: ");
            int option = checkUserInputMenu(6);
            switch (option)
            {
                case 0:
                    System.out.println("Returning...");
                    back = true;
                    break;
                case 1:
                    System.out.println("\nCategory To Change To: ");
                    user = keyboard.next();
                    r.changePetAnimalCategory(id, user);
                    break;
                case 2:
                    r.displayPetByID(id);
                    System.out.print("\nChange Name To: ");
                    user = keyboard.next();
                    r.changePetName(id, user);
                    break;
                case 3:
                    r.displayPetByID(id);
                    System.out.print("\nChange Breed To: ");
                    user = keyboard.next();
                    r.changePetBreed(id, user);
                    break;
                case 4:
                    r.displayPetByID(id);
                    System.out.print("\nChange Age To: ");
                    userInput = keyboard.nextInt();
                    r.changePetAge(id, userInput);
                    break;
                case 5:
                    editPetNextPage(id);
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
        Pet p = r.getPetById(id);
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
                    userInput = keyboard.nextInt();
                    r.changePetOwner(id, userInput);
                    break;
                case 8:
                    r.displayPetByID(id);
                    System.out.print("\nChange Gender To: ");
                    user = keyboard.next();
                    r.changePetGender(id, user);
                    break;
                case 9:
                    //###########################
                    //###########################
                    /*
                    @TODO Make change reg options
                     */
                    //###########################
                    //###########################
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

    public static void fillReg()
    {
        Owner greg = new Owner("Greg", "greg@gmail.com", "0853151", "Dundalk");
        greg.addPet("bear", "bob", "fire", 404, "green", "male");
        greg.addPet("goldfish", "goldy", "water", 4, "white", "other", "freshwater");
        greg.addPet("cat", "tim", "fire", 224, "pink", "female", true);
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

    private static boolean checkUserInput(String input)
    {
        boolean word = false;
        if (input.matches("[a-zA-Z]{1,54}"))
        {
            word = true;
        }
        return word;
    }
}
