package oop19_ca2_aaron_reihill;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 *
 * @author D00222467/Aaron Reihill
 */
public class Registry
{

    ArrayList<Owner> owners = new ArrayList<>();
    private static String OWNER_ALREADY_REG = "Owner Already Registered";
    private static String PET_ALREADY_REG = "Pet Already Registered";
    private static String OWNER_NOT_FOUND = "Owner Not Found";
    private static String PET_NOT_FOUND = "Pet Not Found";

    /**
     * empty constructor
     */
    public Registry()
    {
    }

    /**
     * creates registry with owners list
     *
     * @param owners
     */
    public Registry(ArrayList<Owner> owners)
    {
        this.owners = owners;
    }

    /**
     * gets registered owners
     *
     * @return owner list
     */
    public ArrayList<Owner> getOwners()
    {
        return owners;
    }

    /**
     * sets owner list
     *
     * @param owners
     */
    public void setOwners(ArrayList<Owner> owners)
    {
        this.owners = owners;
    }

    /**
     * adds owner to registered list, if already there prints error message
     *
     * @param name
     * @param telephone
     * @param address
     */
    public void addOwner(String name, String telephone, String address)
    {
        if (CheckOwnerDup(name, address) == -1)
        {
            this.owners.add(new Owner(name, telephone, address));
        }
        else
        {
            System.out.println(OWNER_ALREADY_REG);
        }
    }

    /**
     * adds owner to registered list, if already there prints error message
     *
     * @param id
     * @param name
     * @param telephone
     * @param address
     */
    public void addOwner(int id, String name, String telephone, String address)
    {
        if (CheckOwnerDup(name, address) == -1)
        {
            this.owners.add(new Owner(id, name, telephone, address));
        }
        else
        {
            System.out.println(OWNER_ALREADY_REG);
        }
    }

    /**
     * adds owner to registered list, if already there prints error message
     *
     * @param name
     * @param email
     * @param telephone
     * @param address
     */
    public void addOwner(String name, String email, String telephone, String address)
    {
        if (CheckOwnerDup(name, address) == -1)
        {
            this.owners.add(new Owner(name, email, telephone, address));
        }
        else
        {
            System.out.println(OWNER_ALREADY_REG);
        }
    }

    /**
     * adds fish object to registered owner
     *
     * @param owner
     * @param type
     * @param name
     * @param breed
     * @param age
     * @param colour
     * @param gender
     * @param water
     */
    public void addFish(int owner, String type, String name, String breed, int age, String colour, String gender, String water)
    {
        Pet.createPet(owner, type, name, breed, age, colour, gender, water);
    }

    /**
     * adds mammal object to registered owner
     *
     * @param owner
     * @param type
     * @param name
     * @param breed
     * @param age
     * @param colour
     * @param gender
     * @param neutered
     */
    public void addMammal(int owner, String type, String name, String breed, int age, String colour, String gender, boolean neutered)
    {
        Pet.createPet(owner, type, name, breed, age, colour, gender, neutered);
    }

    /**
     * adds bird object to registered owner
     *
     * @param owner
     * @param type
     * @param name
     * @param breed
     * @param age
     * @param colour
     * @param gender
     * @param wingspan
     * @param fly
     */
    public void addBird(int owner, String type, String name, String breed, int age, String colour, String gender, int wingspan, boolean fly)
    {
        Pet.createPet(owner, type, name, breed, age, colour, gender, wingspan, fly);
    }

    /**
     * adds pet object to registered owner
     *
     * @param owner
     * @param type
     * @param name
     * @param breed
     * @param age
     * @param colour
     * @param gender
     */
    public void addPet(int owner, String type, String name, String breed, int age, String colour, String gender)
    {
        Pet.createPet(owner, type, name, breed, age, colour, gender);
    }

    /**
     * removes pet object from registered owner
     *
     * @param id
     * @param petID
     */
    public void removePet(int id, int petID)
    {
        int ownerIndex = findOwner(id);
        if (ownerIndex != -1)
        {
            Owner o = getOwnerByID(id);
            o.removePet(petID);
        }
        else
        {
            System.out.println(OWNER_NOT_FOUND);
        }
    }

    /**
     * gets pets name from pet id and its owner id
     *
     * @param id
     * @param petID
     * @return pets name
     */
    public String petsName(int id, int petID)
    {
        String name = "";
        int ownerIndex = findOwner(id);
        if (ownerIndex != -1)
        {
            Owner o = getOwnerByID(id);
            int index = o.findPet(petID);
            name = o.getPets().get(index).getName();
        }
        return name;
    }

    /**
     * removes owner by id
     *
     * @param id
     */
    public void removeOwner(int id)
    {
        int ownerIndex = findOwner(id);
        if (ownerIndex != -1)
        {
            this.owners.get(ownerIndex).removeAllPet();
            this.owners.remove(ownerIndex);
        }
        else
        {
            System.out.println(OWNER_NOT_FOUND);
        }
    }

    /**
     * displays all owners
     */
    public void displayAllOwners()
    {

        for (Owner o : this.owners)
        {
            System.out.println("\nID: " + o.getId() + "\nName: " + o.getName() + "\nEmail: " + o.getEmail() + "\nTelephone: " + o.getTelephone() + "\nAddress: " + o.getAddress() + "\nPets Registered: " + o.getPets().size());
        }
    }

    /**
     * displays a owner
     *
     * @param o
     */
    public void displayOwner(Owner o)
    {
        System.out.println("\nID: " + o.getId() + "\nName: " + o.getName() + "\nEmail: " + o.getEmail() + "\nTelephone: " + o.getTelephone() + "\nAddress: " + o.getAddress() + "\nPets Registered: " + o.getPets().size());
    }

    /**
     * displays all pets registered to owner by id
     *
     * @param id
     */
    public void displayOwnersPet(int id)
    {
        Owner o = getOwnerByID(id);
        if (findOwnerID(o.getName()) != -1)
        {
            o.displayAllPets();
        }
        else
        {
            System.out.println(OWNER_NOT_FOUND);
        }
    }

    /**
     * finds owner id by owners name
     *
     * @param name
     * @return owners id
     */
    public int findOwnerID(String name)
    {
        int ownerID = -1;
        boolean found = false;
        int i = 0;
        while (!found && i < this.owners.size())
        {
            if (this.owners.get(i).getName().equalsIgnoreCase(name))
            {
                ownerID = this.owners.get(i).getId();
                found = true;
            }
            i++;
        }
        return ownerID;
    }

    /**
     * displays owner by name
     *
     * @param name
     */
    public void displayOwnerByName(String name)
    {

        if (findOwnerID(name) != -1)
        {
            Owner o = this.owners.get(findOwnerID(name));
            displayOwner(o);
        }
        else
        {
            System.out.println(OWNER_NOT_FOUND);
        }
    }

    /**
     * displays owner by address
     *
     * @param address
     */
    public void displayOwnerByAddress(String address)
    {

        if (findOwnerAddress(address) != -1)
        {
            Owner o = this.owners.get(findOwnerAddress(address));
            displayOwner(o);
        }
        else
        {
            System.out.println(OWNER_NOT_FOUND);
        }
    }

    /**
     * displays owner by telephone
     *
     * @param address
     */
    public void displayOwnerByTelephone(String address)
    {

        if (findOwnerAddress(address) != -1)
        {
            Owner o = this.owners.get(findOwnerAddress(address));
            displayOwner(o);
        }
        else
        {
            System.out.println(OWNER_NOT_FOUND);
        }
    }

    /**
     * displays owner by email
     *
     * @param email
     */
    public void displayOwnerByEmail(String email)
    {

        if (findOwnerEmail(email) != -1)
        {
            Owner o = this.owners.get(findOwnerAddress(email));
            displayOwner(o);
        }
        else
        {
            System.out.println(OWNER_NOT_FOUND);
        }
    }

    /**
     * displays all pets registered to all owners
     */
    public void displayAllPets()
    {
        for (Owner o : this.owners)
        {
            o.displayAllPets();
        }
    }

    /**
     * gets owner object with id
     *
     * @param id
     * @return owner object
     */
    public Owner getOwnerByID(int id)
    {
        Owner o = new Owner();
        int i = 0;
        boolean found = false;
        while (!found && i < this.owners.size())
        {
            if (this.owners.get(i).getId() == id)
            {
                o = this.owners.get(i);
                found = true;
            }
            i++;
        }
        return o;
    }

    /**
     * checks to see if owner id is already taken
     *
     * @param id
     * @return true or false if there or not
     */
    public boolean checkOwnerId(int id)
    {
        int i = 0;
        boolean found = false;
        while (!found && i < this.owners.size())
        {
            if (this.owners.get(i).getId() == id)
            {
                found = true;
            }
            i++;
        }
        return found;
    }

    /**
     * finds owner index in list
     *
     * @param id
     * @return owners position
     */
    public int findOwner(int id)
    {
        int index = -1;
        int i = 0;
        boolean found = false;
        while (!found && i < this.owners.size())
        {
            if (this.owners.get(i).getId() == id)
            {
                index = i;
                found = true;
            }
            i++;
        }
        return index;
    }

    /**
     * displays pet by id
     *
     * @param id
     */
    public void displayPetByID(int id)
    {
        boolean found = false;
        int i = 0, j = 0;
        while (!found && i < this.owners.size())
        {
            List<Pet> pets = this.owners.get(i).getPets();
            while (j < pets.size())
            {
                if (pets.get(j).getPetID() == id)
                {
                    pets.get(j).displayPet();
                    found = true;
                }
                j++;
            }
            i++;
        }
        if (!found)
        {
            System.out.println(PET_NOT_FOUND);
        }

    }

    /**
     * returns pet object by there id
     *
     * @param id
     * @return pet object
     */
    public Pet getPetById(int id)
    {
        Pet p = new Pet();
        boolean found = false;
        int i = 0, j = 0;
        while (!found && i < this.owners.size())
        {
            List<Pet> pets = this.owners.get(i).getPets();
            while (j < pets.size())
            {
                if (pets.get(j).getPetID() == id)
                {
                    p = pets.get(j);
                    found = true;
                }
                j++;
            }
            i++;
        }
        if (!found)
        {
            System.out.println(PET_NOT_FOUND);
        }
        return p;
    }

    /**
     * checks to see if pet duplicate
     *
     * @param id
     * @return true or false if duplicate
     */
    public boolean checkPetIdDup(int id)
    {

        boolean found = false;
        int i = 0, j = 0;
        while (!found && i < this.owners.size())
        {
            List<Pet> pets = this.owners.get(i).getPets();
            while (j < pets.size())
            {
                if (pets.get(j).getPetID() == id)
                {
                    found = true;
                }
                j++;
            }
            i++;
        }
        return found;
    }

    /**
     * displays pet by name
     *
     * @param name
     */
    public void displayPetByName(String name)
    {
        boolean found = false;
        int i = 0, j = 0;
        while (i < this.owners.size())
        {
            List<Pet> pets = this.owners.get(i).getPets();
            while (j < pets.size())
            {
                if (pets.get(j).getName().equalsIgnoreCase(name))
                {
                    pets.get(j).displayPet();
                    found = true;
                }
                j++;
            }
            i++;
        }
        if (!found)
        {
            System.out.println(PET_NOT_FOUND);
        }

    }

    /**
     * finds owner by address
     *
     * @param address
     * @return owner position in list
     */
    public int findOwnerAddress(String address)
    {
        int index = -1, i = 0;
        boolean found = false;
        while (!found && i < this.owners.size())
        {
            if (this.owners.get(i).getAddress().equalsIgnoreCase(address))
            {
                index = i;
                found = true;
            }
            i++;
        }
        return index;
    }

    /**
     * finds owner by telephone
     *
     * @param telephone
     * @return owners position
     */
    public int findOwnerTelephone(String telephone)
    {
        int index = -1, i = 0;
        boolean found = false;
        while (!found && i < this.owners.size())
        {
            if (this.owners.get(i).getTelephone().equalsIgnoreCase(telephone))
            {
                index = i;
                found = true;
            }
            i++;
        }
        return index;
    }

    /**
     * finds owner by email
     *
     * @param email
     * @return owners position
     */
    public int findOwnerEmail(String email)
    {
        int index = -1, i = 0;
        boolean found = false;
        while (!found && i < this.owners.size())
        {
            if (this.owners.get(i).getEmail().equalsIgnoreCase(email))
            {
                index = i;
                found = true;
            }
            i++;
        }
        return index;
    }

    private int CheckOwnerDup(String name, String address)
    {
        int ownerIndex = -1;
        boolean found = false;
        Owner owner = new Owner();
        owner.setName(name);
        owner.setAddress(address);
        int i = 0;
        while (!found && i < this.owners.size())
        {
            if (this.owners.get(i).equals(i))
            {
                ownerIndex = i;
                found = true;
            }
            i++;
        }
        return ownerIndex;
    }

    /**
     * displays pet by type
     *
     * @param type
     */
    public void displayPetByType(String type)
    {
        boolean found = false;
        for (Owner o : this.owners)
        {
            for (Pet p : o.getPets())
            {
                if (p.getType().equalsIgnoreCase(type))
                {
                    p.displayPet();
                    found = true;
                }
            }
        }
        if (!found)
        {
            System.out.println("Animal Type Not Found");
        }
    }

    /**
     * displays pet by category
     *
     * @param animal
     */
    public void displayPetByCategory(String animal)
    {
        int category = 0;
        if (animal.equalsIgnoreCase("mammal"))
        {
            category = 1;
        }
        else if (animal.equalsIgnoreCase("fish"))
        {
            category = 2;
        }
        else if (animal.equalsIgnoreCase("bird"))
        {
            category = 3;
        }
        if (category != 0)
        {
            for (Owner o : this.owners)
            {
                for (Pet p : o.getPets())
                {

                    switch (category)
                    {
                        case 1:
                            if (p instanceof Mammal)
                            {
                                p.displayPet();
                            }
                            break;
                        case 2:
                            if (p instanceof Fish)
                            {
                                p.displayPet();
                            }
                            break;
                        case 3:
                            if (p instanceof Bird)
                            {
                                p.displayPet();
                            }
                            break;
                        default:
                            break;
                    }
                }

            }
        }
        else
        {
            System.out.println("Animal Category Not Found");
        }

    }

    /**
     * loads pet data from text file
     *
     * @param file
     */
    public void loadPetData(String file)
    {
        int maxIndex = 0;
        try
        {
            Scanner sc = new Scanner(new File(file));

            sc.useDelimiter("[/\r\n]+");
            String type, name, breed, colour, gender;
            int age, id, ownerId;
            while (sc.hasNext())
            {
                String animal = sc.next();
                if (animal.equalsIgnoreCase("M"))
                {
                    ownerId = sc.nextInt();
                    id = sc.nextInt();
                    type = sc.next();
                    name = sc.next();
                    breed = sc.next();
                    age = sc.nextInt();
                    colour = sc.next();
                    gender = sc.next();
                    boolean neutered = false;
                    if (sc.next().equalsIgnoreCase("true"))
                    {
                        neutered = true;
                    }
                    maxIndex = id;
                    this.owners.get(findOwner(ownerId)).addPet(id, type, name, breed, age, colour, gender, neutered);
                }
                else if (animal.equalsIgnoreCase("F"))
                {
                    ownerId = sc.nextInt();
                    id = sc.nextInt();
                    type = sc.next();
                    name = sc.next();
                    breed = sc.next();
                    age = sc.nextInt();
                    colour = sc.next();
                    gender = sc.next();
                    String water = sc.next();
                    maxIndex = id;
                    this.owners.get(findOwner(ownerId)).addPet(id, type, name, breed, age, colour, gender, water);
                }
                else if (animal.equalsIgnoreCase("B"))
                {
                    ownerId = sc.nextInt();
                    id = sc.nextInt();
                    type = sc.next();
                    name = sc.next();
                    breed = sc.next();
                    age = sc.nextInt();
                    colour = sc.next();
                    gender = sc.next();
                    int wingspan = sc.nextInt();
                    boolean fly;
                    if (sc.next().equalsIgnoreCase("true"))
                    {
                        fly = true;
                    }
                    else
                    {
                        fly = false;
                    }
                    maxIndex = id;
                    this.owners.get(findOwner(ownerId)).addPet(id, type, name, breed, age, colour, gender, wingspan, fly);
                }
                else if (animal.equalsIgnoreCase("P"))
                {
                    ownerId = sc.nextInt();
                    id = sc.nextInt();
                    type = sc.next();
                    name = sc.next();
                    breed = sc.next();
                    age = sc.nextInt();
                    colour = sc.next();
                    gender = sc.next();
                    maxIndex = id;
                    this.owners.get(findOwner(ownerId)).addPet(id, type, name, breed, age, colour, gender);
                }
                else
                {
                    System.out.println("Format Wrong");
                }
            }
            sc.close();
            System.out.println("Pet Records Loaded");
        }
        catch (IOException e)
        {
            System.out.println("File Not Found. " + e.getLocalizedMessage());
        }
        Pet.setIndex(maxIndex + 1);
    }

    /**
     * loads owner data from text file
     *
     * @param file
     */
    public void loadOwnerData(String file)
    {
        int maxIndex = 0;
        try
        {
            Scanner sc = new Scanner(new File(file));

            sc.useDelimiter("[/\r\n]");
            String name, telephone, address, email;
            int id;
            while (sc.hasNext())
            {
                id = sc.nextInt();
                name = sc.next();
                telephone = sc.next();
                address = sc.next();
                if (sc.hasNext())
                {
                    email = sc.next();
                    maxIndex = id;
                    addOwner(id, name, telephone, address);
                }
                else
                {
                    maxIndex = id;
                    addOwner(id, name, telephone, address);
                }
            }
            sc.close();
            System.out.println("Owner Records Loaded");
        }
        catch (IOException e)
        {
            System.out.println("File Not Found. " + e.getLocalizedMessage());
        }
        catch (InputMismatchException e)
        {
            System.out.println("Format Is Wrong" + e.getLocalizedMessage());
        }
        Owner.setIndex(maxIndex + 1);
    }

    /**
     * changes pets category by input if not there prints error message
     *
     * @param id
     * @param category
     */
    public void changePetAnimalCategory(int id, String category)
    {
        Pet p = getPetById(id);
        String user = "";
        int userInput = 0;
        boolean picked = false;
        boolean choice = false;
        Scanner input = new Scanner(System.in);
        if (category.equalsIgnoreCase("Mammal"))
        {
            while (!picked)
            {
                System.out.print("Is The Pet Neutered: ");
                user = input.next();
                if (user.equalsIgnoreCase("yes") || user.equalsIgnoreCase("true"))
                {
                    choice = true;
                    picked = true;
                }
                else if (user.equalsIgnoreCase("no") || user.equalsIgnoreCase("false"))
                {
                    choice = false;
                    picked = true;
                }
                else
                {
                    System.out.println(user + " Is Not A Valid Input (Yes/No)");
                }
            }
            System.out.println(p.getClass().getSimpleName() + " Changed To " + category);
            getOwnerByID(p.getOwnerID()).removePet(p);
            getOwnerByID(p.getOwnerID()).addPet(Pet.createPet(p.getOwnerID(), p.getPetID(), p.getType(), p.getName(), p.getBreed(), p.getAge(), p.getColour(), p.getGenderString(), choice));
        }
        else if (category.equalsIgnoreCase("Bird"))
        {
            while (!picked)
            {
                System.out.print("\nWingspan(ft): ");
                userInput = input.nextInt();
                if (userInput < 0)
                {
                    System.out.println("Invalid Input Defaulating To Zero...");
                    userInput = 0;
                }
                System.out.print("Can The Pet Fly: ");
                user = input.next();
                if (user.equalsIgnoreCase("no") || user.equalsIgnoreCase("false"))
                {
                    choice = false;
                    picked = true;
                }
                else if (user.equalsIgnoreCase("yes") || user.equalsIgnoreCase("true"))
                {
                    choice = true;
                    picked = true;
                }
                else
                {
                    System.out.println(user + " Is Not A Valid Input (Y/N)");
                }
            }
            System.out.println(p.getClass().getSimpleName() + " Changed To " + category);
            getOwnerByID(p.getOwnerID()).removePet(p);
            getOwnerByID(p.getOwnerID()).addPet(Pet.createPet(p.getOwnerID(), p.getPetID(), p.getType(), p.getName(), p.getBreed(), p.getAge(), p.getColour(), p.getGenderString(), userInput, choice));
        }
        else if (category.equalsIgnoreCase("Fish"))
        {
            while (!picked)
            {
                System.out.print("\nWingspan(ft): ");
                userInput = input.nextInt();
                if (userInput < 0)
                {
                    System.out.println("Invalid Input Defaulating To Zero...");
                    userInput = 0;
                }
                System.out.print("Can The Pet Fly: ");
                user = input.next();
                if (user.equalsIgnoreCase("FRESHWATER"))
                {
                    picked = true;
                }
                else if (user.equalsIgnoreCase("SEAWATER"))
                {
                    picked = true;
                }
                else if (user.equalsIgnoreCase("BRACKISH"))
                {
                    picked = true;
                }
                else if (user.equalsIgnoreCase("UNKOWN") || user.equalsIgnoreCase("Dont know"))
                {
                    picked = true;
                }
                else
                {
                    System.out.println(user + " Is Not A Valid Input (FRESHWATER, SEAWATER, BRACKISH, UNKOWN)");
                }
            }
            System.out.println(p.getClass().getSimpleName() + " Changed To " + category);
            getOwnerByID(p.getOwnerID()).removePet(p);
            getOwnerByID(p.getOwnerID()).addPet(Pet.createPet(p.getOwnerID(), p.getPetID(), p.getType(), p.getName(), p.getBreed(), p.getAge(), p.getColour(), p.getGenderString(), user));

        }
        else
        {
            System.out.println("Category Not Found...");
            System.out.println("\nValid Categories: (Mammal)(Bird)(Fish)");
        }
    }

    /**
     * prints all owners registered
     */
    public void availableOwners()
    {
        System.out.println();
        for (int i = 0; i < this.owners.size(); i++)
        {
            System.out.print("(ID: " + this.owners.get(i).getId() + ", Name: " + this.owners.get(i).getName() + " )\n");
        }
    }

    /**
     * changes owner name by id
     *
     * @param id
     * @param name
     */
    public void changeOwnerName(int id, String name)
    {
        if (checkOwnerId(id))
        {
            System.out.println("\nOwner's Name " + getOwnerByID(id).getName() + " Changed To " + name);
            getOwnerByID(id).setName(name);
        }
        else
        {
            System.out.println(OWNER_NOT_FOUND);
        }
    }

    /**
     * changes telephone name by id
     *
     * @param id
     * @param telephone
     */
    public void changeOwnerTelephone(int id, String telephone)
    {
        if (checkOwnerId(id))
        {
            System.out.println("\nOwner's Telephone " + getOwnerByID(id).getTelephone() + " Changed To " + telephone);
            getOwnerByID(id).setTelephone(telephone);
        }
        else
        {
            System.out.println(OWNER_NOT_FOUND);
        }
    }

    /**
     * changes owner email by id
     *
     * @param id
     * @param email
     */
    public void changeOwnerEmail(int id, String email)
    {
        if (checkOwnerId(id))
        {
            System.out.println("\nOwner's Email " + getOwnerByID(id).getEmail() + " Changed To " + email);
            getOwnerByID(id).setEmail(email);
        }
        else
        {
            System.out.println(OWNER_NOT_FOUND);
        }
    }

    /**
     * changes owner address by id
     *
     * @param id
     * @param address
     */
    public void changeOwnerAddress(int id, String address)
    {
        if (checkOwnerId(id))
        {
            System.out.println("\nOwner's Address " + getOwnerByID(id).getAddress() + " Changed To " + address);
            getOwnerByID(id).setTelephone(address);
        }
        else
        {
            System.out.println(OWNER_NOT_FOUND);
        }
    }

    /**
     * changes owner id by id
     *
     * @param id
     * @param newId
     */
    public void changeOwnerId(int id, int newId)
    {
        if (checkOwnerId(id) && !checkOwnerId(newId))
        {
            System.out.println("\nOwner's Id " + getOwnerByID(id).getId() + " Changed To " + newId);
            getOwnerByID(id).setId(newId);
        }
        else
        {
            System.out.println("Could Not Change Id To " + newId);
        }
    }

    /**
     * displays all mammals
     */
    public void displayMammals()
    {
        for (Owner o : this.owners)
        {
            List<Pet> pets = o.getPets();
            for (Pet p : pets)
            {
                if (p instanceof Mammal)
                {
                    p.displayPet();
                }
            }
        }
    }

    /**
     * displays all fish
     */
    public void displayFish()
    {
        for (Owner o : this.owners)
        {
            List<Pet> pets = o.getPets();
            for (Pet p : pets)
            {
                if (p instanceof Fish)
                {
                    p.displayPet();
                }
            }
        }
    }

    /**
     * displays all birds
     */
    public void displayBirds()
    {
        for (Owner o : this.owners)
        {
            List<Pet> pets = o.getPets();
            for (Pet p : pets)
            {
                if (p instanceof Bird)
                {
                    p.displayPet();
                }
            }
        }
    }

    /**
     * prints the pet statistics of all pets registered
     */
    public void petStatistics()
    {
        int maxAge = 0;
        String oldestPet = "";
        int minAge = 100;
        String youngestPet = "";
        int averageAge = 0;
        int mammalCount = 0;
        int birdCount = 0;
        int fishCount = 0;
        int petCount = 0;
        int ownerPetCount = 0;
        int ownerPetCountMax = 0;
        String mostPetReg = "";
        for (Owner o : this.owners)
        {
            List<Pet> pets = o.getPets();
            for (Pet p : pets)
            {
                ownerPetCount++;
                petCount++;
                averageAge += p.getAge();
                if (p.getAge() > maxAge)
                {
                    maxAge = p.getAge();
                    oldestPet = p.getName();
                }
                if (p.getAge() < minAge)
                {
                    minAge = p.getAge();
                    youngestPet = p.getName();
                }
                if (p instanceof Mammal)
                {
                    mammalCount++;
                }
                if (p instanceof Bird)
                {
                    birdCount++;
                }
                if (p instanceof Fish)
                {
                    fishCount++;
                }
                if (ownerPetCount > ownerPetCountMax)
                {
                    mostPetReg = o.getName();
                }
            }
            ownerPetCountMax = ownerPetCount;
            ownerPetCount = 0;
        }
        double mammalPercent = ((double) mammalCount / petCount) * 100;
        double fishPercent = ((double) fishCount / petCount) * 100;
        double birdPercent = ((double) birdCount / petCount) * 100;
        System.out.println("\nNumber Of Total Pets " + petCount);
        System.out.println("Number Of Them Mammals " + mammalCount + ", Fish: " + fishCount + ", Birds: " + birdCount);
        System.out.println("\nPercentage Of Pets Registered\nMammals\tFish\t  Bird");
        System.out.printf("%.2f%%\t %.2f%%\t%.2f%%", mammalPercent, fishPercent, birdPercent);
        System.out.println("\n\n" + mostPetReg + " Has The Most Pets Registered With " + ownerPetCountMax);
        System.out.println("Oldest Registered Pet " + oldestPet + " Aged " + maxAge);
        System.out.println("Youngest Registered Pet " + youngestPet + " Aged " + minAge);
        System.out.println("Average Age Of All Pets: " + averageAge / petCount);
    }

    /**
     * displays pets by age comparator
     */
    public void displayPetsOrderByAge()
    {
        List<Pet> p = new ArrayList<>();
        for (Owner o : this.owners)
        {
            p.addAll(o.getPets());
        }
        Owner.displayAllPetsByAge(p);
    }

    /**
     * displays pets by id comparator
     */
    public void displayPetsOrderById()
    {
        List<Pet> p = new ArrayList<>();
        for (Owner o : this.owners)
        {
            p.addAll(o.getPets());
        }
        Owner.displayAllPetsById(p);
    }

    /**
     * displays pets by gender comparator
     */
    public void displayPetsOrderByGender()
    {
        List<Pet> p = new ArrayList<>();
        for (Owner o : this.owners)
        {
            p.addAll(o.getPets());
        }
        Owner.displayAllPetsByGender(p);
    }

    /**
     * displays pets by registered date comparator
     */
    public void displayPetsOrderByRegDate()
    {
        List<Pet> p = new ArrayList<>();
        for (Owner o : this.owners)
        {
            p.addAll(o.getPets());
        }
        Owner.displayAllPetsByRegDate(p);
    }

    /**
     * displays pets by registered date comparator using owner id
     *
     * @param ownerId
     */
    public void displayPetsOrderByRegDate(int ownerId)
    {
        for (Owner o : this.owners)
        {
            if (o.getId() == ownerId)
            {
                Owner.displayAllPetsByRegDate(o.getPets());
            }
        }
    }

    /**
     * displays pets by gender comparator using owner id
     *
     * @param ownerId
     */
    public void displayPetsOrderByGender(int ownerId)
    {
        for (Owner o : this.owners)
        {
            if (o.getId() == ownerId)
            {
                Owner.displayAllPetsByGender(o.getPets());
            }
        }
    }

    /**
     * displays pets by id comparator using owner id
     *
     * @param ownerId
     */
    public void displayPetsOrderById(int ownerId)
    {
        for (Owner o : this.owners)
        {
            if (o.getId() == ownerId)
            {
                Owner.displayAllPetsById(o.getPets());
            }
        }
    }

    /**
     * displays pets by age comparator using owner id
     *
     * @param ownerId
     */
    public void displayPetsOrderByAge(int ownerId)
    {
        for (Owner o : this.owners)
        {
            if (o.getId() == ownerId)
            {
                Owner.displayAllPetsByAge(o.getPets());
            }
        }
        //Static binding in Java occurs during compile time while dynamic binding occurs during runtime
    }

    /**
     * loads registry from object stream
     *
     * @param file
     */
    public void loadRegistry(String file)
    {
        List<Owner> o = new ArrayList<>();
        try
        {
            File f = new File(file);
            if (f.exists())
            {
                ObjectInputStream in = new ObjectInputStream(new FileInputStream(f));
                o = (ArrayList<Owner>) in.readObject();
                in.close();
                System.out.println("Registry Loaded In");
            }
        }
        catch (IOException e)
        {
            System.out.println("IOException" + e.getLocalizedMessage());
        }
        catch (ClassNotFoundException e)
        {
            System.out.println("ClassNotFoundException" + e.getLocalizedMessage());
        }
        this.owners.addAll(o);
        maxId();
    }

    /**
     * saves registry from object stream
     *
     * @param file
     */
    public void storeRegistry(String file)
    {
        File f = new File(file);
        try
        {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(f));
            out.writeObject(this.owners);
            out.close();
            System.out.println("Registry Saved");
        }
        catch (FileNotFoundException e)
        {
            System.out.println("Stored File Not Found" + e.getLocalizedMessage());
        }
        catch (IOException e)
        {
            System.out.println("Stored File IOException" + e.getLocalizedMessage());
        }
    }

    public void editPet(int id, String variable, String replace)
    {
        Pet p = getPetById(id);
        switch (variable)
        {
            case ("name"):
                p.setName(replace);
                System.out.println("Changed To " + replace);
                break;
            case ("type"):
                p.setType(replace);
                System.out.println("Changed To " + replace);
                break;
            case ("breed"):
                p.setBreed(replace);
                System.out.println("Changed To " + replace);
                break;
            case ("colour"):
                p.setColour(replace);
                System.out.println("Changed To " + replace);
                break;
            case ("gender"):
                p.setGender(replace);
                System.out.println("Changed To " + replace);
                break;
            case ("regDate"):
                p.setRegDate(replace);
                System.out.println("Changed To " + replace);
                break;
        }
        if (p instanceof Mammal)
        {
            if (variable.equalsIgnoreCase("neutered"))
            {
                Mammal m = (Mammal) p;
                m.setNeutered(replace);
                System.out.println("Changed To " + replace);
            }
            if (p instanceof Fish)
            {
                if (variable.equalsIgnoreCase("water"))
                {
                    Fish f = (Fish) p;
                    f.setWater(replace);
                    System.out.println("Changed To " + replace);
                }
            }
            if (p instanceof Bird)
            {
                if (variable.equalsIgnoreCase("fly"))
                {
                    Bird b = (Bird) p;
                    b.setFly(replace);
                    System.out.println("Changed To " + replace);
                }
            }
        }
    }

    public void editPet(int id, String variable, int replace)
    {
        Pet p = getPetById(id);
        if (variable.equalsIgnoreCase("petId"))
        {
            if (!checkPetIdDup(id))
            {
                p.setPetID(replace);
                System.out.println("Changed To " + replace);
            }
            else
            {
                System.out.println(PET_ALREADY_REG);
            }
        }
        else if (variable.equalsIgnoreCase("age"))
        {
            p.setAge(replace);
            System.out.println("Changed To " + replace);
        }
        else if (variable.equalsIgnoreCase("ownerId"))
        {
            if (findOwner(replace) != -1)
            {
                p.setOwnerID(replace);
                this.owners.get(findOwner(replace)).addPet(p);
                System.out.println("Changed To " + replace);
            }
            else
            {
                System.out.println(OWNER_NOT_FOUND);
            }
        }
        else if (p instanceof Bird)
        {
            if (variable.equalsIgnoreCase("wingspan"))
            {
                Bird b = (Bird) p;
                b.setWingspan(replace);
                System.out.println("Changed To " + replace);
            }
        }
    }

    private void maxId()
    {
        int pet = 0, owner = 0;
        for (Owner o : this.owners)
        {
            if (o.getId() > owner)
            {
                owner = o.getId();
            }
            for (Pet p : o.getPets())
            {
                if (p.getPetID() > pet)
                {
                    pet = p.getPetID();
                }
            }
        }
        Owner.setIndex(owner + 1);
        Pet.setIndex(pet + 1);

    }
    
    @Override
    public String toString()
    {
        return "Registry{" + "owners=" + owners + '}';
    }
}