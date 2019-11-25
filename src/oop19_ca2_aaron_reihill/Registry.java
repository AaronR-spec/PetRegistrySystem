package oop19_ca2_aaron_reihill;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author D00222467
 */
public class Registry
{

    ArrayList<Owner> owners = new ArrayList<>();
    private static String OWNER_ALREADY_REG = "Owner Already Registered";
    private static String PET_ALREADY_REG = "Pet Already Registered";
    private static String OWNER_NOT_FOUND = "Owner Not Found";
    private static String PET_NOT_FOUND = "Pet Not Found";

    public Registry()
    {
    }

    public Registry(ArrayList<Owner> owners)
    {
        this.owners = owners;
    }

    public ArrayList<Owner> getOwners()
    {
        return owners;
    }

    public void setOwners(ArrayList<Owner> owners)
    {
        this.owners = owners;
    }

    public void addOwner(String name)
    {
        this.owners.add(new Owner(name));
    }

    public void addOwner(Owner o)
    {
        if (CheckOwnerDup(o.getName(), o.getAddress()) == -1)
        {
            this.owners.add(o);
        }
        else
        {
            System.out.println(OWNER_ALREADY_REG);
        }
    }

    public void addOwner(String name, String email, String telephone, String address, List<Pet> pets)
    {
        if (CheckOwnerDup(name, address) == -1)
        {
            this.owners.add(new Owner(name, email, telephone, address, pets));
        }
        else
        {
            System.out.println(OWNER_ALREADY_REG);
        }
    }

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

    public void addOwner(String name, List<Pet> pets)
    {
        this.owners.add(new Owner(name, pets));
    }

    public void addFish(int owner, String type, String name, String breed, int age, String colour, String gender, String water)
    {
        Pet.createPet(owner, type, name, breed, age, colour, gender, water);
    }

    public void addMammal(int owner, String type, String name, String breed, int age, String colour, String gender, boolean neutered)
    {
        Pet.createPet(owner, type, name, breed, age, colour, gender, neutered);
    }

    public void addBird(int owner, String type, String name, String breed, int age, String colour, String gender, int wingspan, boolean fly)
    {
        Pet.createPet(owner, type, name, breed, age, colour, gender, wingspan, fly);
    }

    public void addPet(int owner, String type, String name, String breed, int age, String colour, String gender)
    {
        Pet.createPet(owner, type, name, breed, age, colour, gender);
    }

    public void removeOwner(Owner o)
    {
        if (findOwner(o.getId()) != -1)
        {
            o.removeAllPet();
            this.owners.remove(o);
        }
        else
        {
            System.out.println(OWNER_NOT_FOUND);
        }
    }

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

    public void displayAllOwners()
    {

        for (Owner o : this.owners)
        {
            System.out.println("\nID: " + o.getId() + "\nName: " + o.getName() + "\nEmail: " + o.getEmail() + "\nTelephone: " + o.getTelephone() + "\nAddress: " + o.getAddress() + "\nPets Registered: " + o.getPets().size());
        }
    }

    public void displayOwner(Owner o)
    {
        System.out.println("\nID: " + o.getId() + "\nName: " + o.getName() + "\nEmail: " + o.getEmail() + "\nTelephone: " + o.getTelephone() + "\nAddress: " + o.getAddress() + "\nPets Registered: " + o.getPets().size());
    }

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

    public void displayAllPets()
    {
        for (Owner o : this.owners)
        {
            o.displayAllPets();
        }
    }

    public Owner getOwnerByName(String name)
    {
        int index = -1;
        int i = 0;
        boolean found = false;
        while (!found && i < this.owners.size())
        {
            if (this.owners.get(i).getName().equalsIgnoreCase(name))
            {
                index = i;
                found = true;
            }
            i++;
        }
        return this.owners.get(i);
    }

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

    public void loadPetData(String file)
    {
        int maxIndex = 0;
        try
        {
            Scanner sc = new Scanner(new File(file));

            sc.useDelimiter("[/\r\n]+");
            String type, name, breed, colour, gender;
            int age, id;
            while (sc.hasNext())
            {
                String animal = sc.next();
                if (animal.equalsIgnoreCase("M"))
                {
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
                    this.owners.get(0).addPet(id, type, name, breed, age, colour, gender, neutered);
                }
                else if (animal.equalsIgnoreCase("F"))
                {
                    id = sc.nextInt();
                    type = sc.next();
                    name = sc.next();
                    breed = sc.next();
                    age = sc.nextInt();
                    colour = sc.next();
                    gender = sc.next();
                    String water = sc.next();
                    maxIndex = id;
                    this.owners.get(0).addPet(id, type, name, breed, age, colour, gender, water);
                }
                else if (animal.equalsIgnoreCase("B"))
                {
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
                    this.owners.get(0).addPet(id, type, name, breed, age, colour, gender, wingspan, fly);
                }
                if (animal.equalsIgnoreCase("P"))
                {
                    id = sc.nextInt();
                    type = sc.next();
                    name = sc.next();
                    breed = sc.next();
                    age = sc.nextInt();
                    colour = sc.next();
                    gender = sc.next();
                    maxIndex = id;
                    this.owners.get(0).addPet(id, type, name, breed, age, colour, gender);
                }
                else
                {
                    //error goes here
                }
            }
            sc.close();
        }
        catch (IOException e)
        {
            System.out.println("File Not Found. " + e.getLocalizedMessage());
        }
        Pet.setIndex(maxIndex + 1);
    }

    public void loadOwnerData(String file)
    {
        int maxIndex = 0;
        try
        {
            Scanner sc = new Scanner(new File(file));

            sc.useDelimiter("[/\r\n]+");
            String type, name, telephone, address;
            int id;
            while (sc.hasNext())
            {
                id = sc.nextInt();
                name = sc.next();
                telephone = sc.next();
                address = sc.next();
                maxIndex = id;
                addOwner(id, name, telephone, address);
            }
            sc.close();
        }
        catch (IOException e)
        {
            System.out.println("File Not Found. " + e.getLocalizedMessage());
        }
        Owner.setIndex(maxIndex + 1);
    }

    public void changePetName(int id, String name)
    {
        Pet p = getPetById(id);
        System.out.println("\n" + p.getName() + " Changed To " + name);
        p.setName(name);
    }

    public void changePetBreed(int id, String breed)
    {
        Pet p = getPetById(id);
        System.out.println("\n" + p.getBreed() + " Changed To " + breed);
        p.setBreed(breed);
    }

    public void changePetAge(int id, int age)
    {
        Pet p = getPetById(id);
        System.out.println("\n" + p.getAge() + " Changed To " + age);
        p.setAge(age);
    }

    public void changePetColour(int id, String colour)
    {
        Pet p = getPetById(id);
        System.out.println("\n" + p.getColour() + " Changed To " + colour);
        p.setColour(colour);
    }

    public void changePetId(int id)
    {

        if (!checkPetIdDup(id))
        {
            Pet p = getPetById(id);
            System.out.println("\n" + p.getPetID() + " Changed To " + id);
            p.setPetID(id);
        }
        else
        {
            System.out.println(PET_ALREADY_REG);
        }
    }

    public void changePetOwner(int id, int ownerId)
    {
        Pet p = getPetById(id);
        System.out.println("\n" + p.getOwnerID() + " Changed To " + ownerId);
        if (getOwnerByID(ownerId).findPet(id) == -1)
        {
            getOwnerByID(p.getOwnerID()).removePet(p);
            getOwnerByID(ownerId).addPet(p);
        }
        else
        {
            System.out.println(PET_ALREADY_REG);
        }
    }

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
                    System.out.println(user + " Is Not A Valid Input (Y/N)");
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

    public void changePetGender(int id, String gender)
    {
        String ogGender = getPetById(id).getGenderString();
        if (getPetById(id).setGender(gender))
        {
            System.out.println(ogGender + " Changed To " + getPetById(id).getGender());
        }
        else
        {
            System.out.println("\n" + gender + " Is Not A Valid Option");
            System.out.println("Valid Options (Male,Female,Unkown)");
        }
    }

    public void changePetRegDate(int id, String reg)
    {
        String ogReg = getPetById(id).getRegDate().toString();
        getPetById(id).setRegDate(reg);
        System.out.println(ogReg + " Changed To " + getPetById(id).getRegDate());
    }

    public void availableOwners()
    {
        System.out.println();
        for (int i = 0; i < this.owners.size(); i++)
        {
            System.out.print("(ID: " + this.owners.get(i).getId() + ", Name: " + this.owners.get(i).getName() + " )\n");
        }
    }

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
                if(ownerPetCount >ownerPetCountMax )
                {
                    mostPetReg = o.getName();
                }
            }
            ownerPetCountMax = ownerPetCount;
            ownerPetCount = 0;
        }
        double mammalPercent = ((double)mammalCount/petCount)*100;
        double fishPercent = ((double)fishCount/petCount)*100;
        double birdPercent = ((double)birdCount/petCount)*100;
        System.out.println("Number Of Total Pets " + petCount);
        System.out.println("Number Of Them Mammals " + mammalCount + ", Fish: " + fishCount + ", Birds: " + birdCount);
        System.out.printf("Percentage Of Pets Registered As Mammals:%.2f " ,mammalPercent);
        System.out.print("%\n");
        System.out.printf("\nPercentage Of Pets Registered As Birds:%.2f " ,birdPercent);
        System.out.print("%\n");
        System.out.printf("\nPercentage Of Pets Registered As Fish:%.2f " ,fishPercent);
        System.out.print("%\n");
        System.out.println("\n"+ mostPetReg + " Has The Most Pets Registered With " + ownerPetCountMax);
        System.out.println("Oldest Registered Pet " +oldestPet +" Aged " + maxAge);
        System.out.println("Youngest Registered Pet " + youngestPet+ " Aged " + minAge);
        System.out.println("Average Age: " + averageAge/petCount);
    }
    
    public void changePetNeutered(int id,String n)
    {
        Mammal m = (Mammal)getPetById(id);
        System.out.print("\nStatus Changed From " + m.isNeutered() +" To ");
        m.setNeutered(n);
        System.out.print(m.isNeutered());
    }
    public void changePetWaterType(int id,String w)
    {
        Fish f = (Fish)getPetById(id);
        String ogWater = f.getWater().toString();
        if(f.setWater(w))
        {
            System.out.print("\nStatus Changed From " + f.getWater() +" To " + ogWater);
        }
        else
        {
            System.out.println("Invalid Option Could Not Change Water Type");
        }
    }
    
    @Override
    public String toString()
    {
        return "Registry{" + "owners=" + owners + '}';
    }
}
