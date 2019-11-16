/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oop19_ca2_aaron_reihill;

import java.util.ArrayList;
import java.util.List;
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
            System.out.println("Dundalk Pet Registry");
            System.out.println("(0) Exit");
            System.out.println("(1) Add Options");
            System.out.println("(2) Search Options");
            System.out.println("(3) Remove Options");
            System.out.println("(4) Edit Options");
            System.out.println("(5) Display Options");
            System.out.print("Select an option: ");
            int option = keyboard.nextInt();
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
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    System.out.println("Display Option Selected...");
                    displayOptions();
                    break;
            }
            if (option > 5)
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
            int option = keyboard.nextInt();
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
                    addPet();
                    break;
            }
            if (option > 2)
            {
                System.out.println("Sorry There Is No Option " + option);
                System.out.println("Please Choose Another Option From The List\n");
            }
        }
    }

    public static void addOwner()
    {
        System.out.print("\nName: ");
        String name = keyboard.next();
        System.out.print("Address: ");
        String address = keyboard.next();
        System.out.print("Telephone: ");
        String telephone = keyboard.next();
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
                added = true;
            }
            else
            {
                System.out.print("Please Enter Either Y or N: ");
            }
        }
    }

    public static void addPet()
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
            int option = keyboard.nextInt();
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
                    break;
                case 3:
                    break;
                case 4:
                    break;
            }
            if (option > 4)
            {
                System.out.println("Option " + option + " Is Not Valid");
                System.out.print("Please Enter Valid Option");
            }
        }
    }

    public static void addMammal(int id)
    {
        String type, name, breed, colour, gender ="";
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
            else if(gender.equalsIgnoreCase("UNKOWN"))
            {
                gender = "UNKOWN";
            }
            else
            {
                System.out.print("Please Select A Valid Option:");
            }
        }
        picked = false;
        System.out.println("Neutered(Y/N): ");
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
    }

    public static void displayOptions()
    {
        boolean exit = false;
        while (!exit)
        {
            System.out.println("\nDisplay Options");
            System.out.println("(0) Back");
            System.out.println("(1) Display Owner(s)");
            System.out.println("(2) Display Pet(s)");
            System.out.print("Select an option:  ");
            int option = keyboard.nextInt();
            switch (option)
            {
                case 0:
                    System.out.println("Returning...\n");
                    exit = true;
                    break;
                case 1:
                    displayOwners();
                    break;
                case 2:
                    break;
            }
            if (option > 4)
            {
                System.out.println("Sorry There Is No Option " + option);
                System.out.println("Please Choose Another Option From The List\n");
            }
        }
    }

    public static void displayList(Owner o)
    {
        o.displayAllPets();
    }

    public static void displayOwners()
    {
        r.displayOwners();
    }

    public static void fillReg()
    {
        Pet p1 = new Mammal("Dog", "kevin", "Poddle", 2, "Black", "male", "4-22-10", true);
        Pet p2 = new Bird("Cat", "sarah", "Poddle", 4, "Blue", "female", "20-20-10", 2, false);
        Pet p3 = new Fish("Fish", "Kevin", "Poddle", 1, "Black", "male", "21-20-10", "freshwater");
        Pet p4 = new Pet("GoldFish", "Poddle", 6, "Yellow", "20-20-10");
        Pet p5 = new Mammal("Dog", "kevin", "Poddle", 2, "Black", "male", "4-22-10", true);
        Pet p6 = new Bird("Cat", "sarah", "Poddle", 4, "Blue", "female", "20-20-10", 2, false);
        Pet p7 = new Fish("Fish", "Kevin", "Poddle", 1, "Black", "male", "21-20-10", "freshwater");
        Pet p8 = new Pet("GoldFish", "Poddle", 6, "Yellow", "20-20-10");

        List<Pet> pets = new ArrayList<>();
        pets.add(p1);
        pets.add(p2);
        pets.add(p4);
        List<Pet> pets2 = new ArrayList<>();
        pets.add(p5);
        pets.add(p6);
        List<Pet> pets3 = new ArrayList<>();
        pets.add(p7);
        pets.add(p6);
        pets.add(p8);
        r.addOwner("Greg", pets);
        r.addOwner("Bob", pets2);
        r.addOwner("Kevin", pets3);

    }
}
