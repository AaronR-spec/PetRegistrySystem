/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
public class Registry {

    ArrayList<Owner> owners = new ArrayList<>();
    private static String OWNER_ALREADY_REG = "Owner Already Registered";
    private static String OWNER_NOT_FOUND = "Owner Not Found";
    private static String PET_NOT_FOUND = "Pet Not Found";

    public Registry() {
    }

    public Registry(ArrayList<Owner> owners) {
        this.owners = owners;
    }

    public ArrayList<Owner> getOwners() {
        return owners;
    }

    public void setOwners(ArrayList<Owner> owners) {
        this.owners = owners;
    }

    public void addOwner(String name) {
        this.owners.add(new Owner(name));
    }

    public void addOwner(Owner o) {
        if (CheckOwnerDup(o.getName(), o.getAddress()) == -1) {
            this.owners.add(o);
        } else {
            System.out.println(OWNER_ALREADY_REG);
        }
    }

    public void addOwner(String name, String email, String telephone, String address, List<Pet> pets) {
        if (CheckOwnerDup(name, address) == -1) {
            this.owners.add(new Owner(name, email, telephone, address, pets));
        } else {
            System.out.println(OWNER_ALREADY_REG);
        }
    }

    public void addOwner(String name, String telephone, String address) {
        if (CheckOwnerDup(name, address) == -1) {
            this.owners.add(new Owner(name, telephone, address));
        } else {
            System.out.println(OWNER_ALREADY_REG);
        }
    }

    public void addOwner(String name, String email, String telephone, String address) {
        if (CheckOwnerDup(name, address) == -1) {
            this.owners.add(new Owner(name, email, telephone, address));
        } else {
            System.out.println(OWNER_ALREADY_REG);
        }
    }

    public void addOwner(String name, List<Pet> pets) {
        this.owners.add(new Owner(name, pets));
    }

    public void addFish(int owner, String type, String name, String breed, int age, String colour, String gender, String water) {
        Pet.createPet(owner, type, name, breed, age, colour, gender, water);
    }

    public void addMammal(int owner, String type, String name, String breed, int age, String colour, String gender, boolean neutered) {
        Pet.createPet(owner, type, name, breed, age, colour, gender, neutered);
    }

    public void addBird(int owner, String type, String name, String breed, int age, String colour, String gender, int wingspan, boolean fly) {
        Pet.createPet(owner, type, name, breed, age, colour, gender, wingspan, fly);
    }

    public void addPet(int owner, String type, String name, String breed, int age, String colour, String gender) {
        Pet.createPet(owner, type, name, breed, age, colour, gender);
    }

    public void removeOwner(Owner o) {
        if (findOwner(o.getId()) != -1) {
            o.removeAllPet();
            this.owners.remove(o);
        } else {
            System.out.println(OWNER_NOT_FOUND);
        }
    }

    public void removePet(int id, int petID) {
        int ownerIndex = findOwner(id);
        if (ownerIndex != -1) {
            Owner o = getOwnerByID(id);
            o.removePet(petID);
        } else {
            System.out.println(OWNER_NOT_FOUND);
        }
    }

    public String petsName(int id, int petID) {
        String name = "";
        int ownerIndex = findOwner(id);
        if (ownerIndex != -1) {
            Owner o = getOwnerByID(id);
            int index = o.findPet(petID);
            name = o.getPets().get(index).getName();
        }
        return name;
    }

    public void removeOwner(int id) {
        int ownerIndex = findOwner(id);
        if (ownerIndex != -1) {
            this.owners.get(ownerIndex).removeAllPet();
            this.owners.remove(ownerIndex);
        } else {
            System.out.println(OWNER_NOT_FOUND);
        }
    }

    public void displayAllOwners() {

        for (Owner o : this.owners) {
            System.out.println("\nID: " + o.getId() + "\nName: " + o.getName() + "\nEmail: " + o.getEmail() + "\nTelephone: " + o.getTelephone() + "\nAddress: " + o.getAddress() + "\nPets Registered: " + o.getPets().size());
        }
    }

    public void displayOwner(Owner o) {
        System.out.println("\nID: " + o.getId() + "\nName: " + o.getName() + "\nEmail: " + o.getEmail() + "\nTelephone: " + o.getTelephone() + "\nAddress: " + o.getAddress() + "\nPets Registered: " + o.getPets().size());
    }

    public void displayOwnersPet(int id) {
        Owner o = getOwnerByID(id);
        if (findOwnerID(o.getName()) != -1) {
            o.displayAllPets();
        } else {
            System.out.println(OWNER_NOT_FOUND);
        }
    }

    public int findOwnerID(String name) {
        int ownerID = -1;
        boolean found = false;
        int i = 0;
        while (!found && i < this.owners.size()) {
            if (this.owners.get(i).getName().equalsIgnoreCase(name)) {
                ownerID = this.owners.get(i).getId();
                found = true;
            }
            i++;
        }
        return ownerID;
    }

    public void displayOwnerByName(String name) {

        if (findOwnerID(name) != -1) {
            Owner o = this.owners.get(findOwnerID(name));
            displayOwner(o);
        } else {
            System.out.println(OWNER_NOT_FOUND);
        }
    }

    public void displayOwnerByAddress(String address) {

        if (findOwnerAddress(address) != -1) {
            Owner o = this.owners.get(findOwnerAddress(address));
            displayOwner(o);
        } else {
            System.out.println(OWNER_NOT_FOUND);
        }
    }

    public void displayOwnerByTelephone(String address) {

        if (findOwnerAddress(address) != -1) {
            Owner o = this.owners.get(findOwnerAddress(address));
            displayOwner(o);
        } else {
            System.out.println(OWNER_NOT_FOUND);
        }
    }

    public void displayOwnerByEmail(String email) {

        if (findOwnerEmail(email) != -1) {
            Owner o = this.owners.get(findOwnerAddress(email));
            displayOwner(o);
        } else {
            System.out.println(OWNER_NOT_FOUND);
        }
    }

    public void displayAllPets() {
        for (Owner o : this.owners) {
            o.displayAllPets();
        }
    }

    public Owner getOwnerByName(String name) {
        int index = -1;
        int i = 0;
        boolean found = false;
        while (!found && i < this.owners.size()) {
            if (this.owners.get(i).getName().equalsIgnoreCase(name)) {
                index = i;
                found = true;
            }
            i++;
        }
        return this.owners.get(i);
    }

    public Owner getOwnerByID(int id) {
        Owner o = new Owner();
        int i = 0;
        boolean found = false;
        while (!found && i < this.owners.size()) {
            if (this.owners.get(i).getId() == id) {
                o = this.owners.get(i);
                found = true;
            }
            i++;
        }
        return o;
    }

    public int findOwner(int id) {
        int index = -1;
        int i = 0;
        boolean found = false;
        while (!found && i < this.owners.size()) {
            if (this.owners.get(i).getId() == id) {
                index = i;
                found = true;
            }
            i++;
        }
        return index;
    }

    public void displayPetByID(int id) {
        boolean found = false;
        int i = 0, j = 0;
        while (!found && i < this.owners.size()) {
            List<Pet> pets = this.owners.get(i).getPets();
            while (j < pets.size()) {
                if (pets.get(j).getPetID() == id) {
                    pets.get(j).displayPet(pets.get(j));
                    found = true;
                }
                j++;
            }
            i++;
        }
        if (!found) {
            System.out.println(PET_NOT_FOUND);
        }

    }

    public void displayPetByName(String name) {
        boolean found = false;
        int i = 0, j = 0;
        while (i < this.owners.size()) {
            List<Pet> pets = this.owners.get(i).getPets();
            while (j < pets.size()) {
                if (pets.get(j).getName().equalsIgnoreCase(name)) {
                    pets.get(j).displayPet(pets.get(j));
                    found = true;
                }
                j++;
            }
            i++;
        }
        if (!found) {
            System.out.println(PET_NOT_FOUND);
        }

    }

    public int findOwnerAddress(String address) {
        int index = -1, i = 0;
        boolean found = false;
        while (!found && i < this.owners.size()) {
            if (this.owners.get(i).getAddress().equalsIgnoreCase(address)) {
                index = i;
                found = true;
            }
            i++;
        }
        return index;
    }

    public int findOwnerTelephone(String telephone) {
        int index = -1, i = 0;
        boolean found = false;
        while (!found && i < this.owners.size()) {
            if (this.owners.get(i).getTelephone().equalsIgnoreCase(telephone)) {
                index = i;
                found = true;
            }
            i++;
        }
        return index;
    }

    public int findOwnerEmail(String email) {
        int index = -1, i = 0;
        boolean found = false;
        while (!found && i < this.owners.size()) {
            if (this.owners.get(i).getEmail().equalsIgnoreCase(email)) {
                index = i;
                found = true;
            }
            i++;
        }
        return index;
    }

    private int CheckOwnerDup(String name, String address) {
        int ownerIndex = -1;
        boolean found = false;
        Owner owner = new Owner();
        owner.setName(name);
        owner.setAddress(address);
        int i = 0;
        while (!found && i < this.owners.size()) {
            if (this.owners.get(i).equals(i)) {
                ownerIndex = i;
                found = true;
            }
            i++;
        }
        return ownerIndex;
    }

    public void loadData(String file) {

        try {
            Scanner sc = new Scanner(new File(file));

// Delimiter: set the delimiter to be a comma character "," 
//            or a carriage-return '\r', or a newline '\n'
            sc.useDelimiter("[/\r\n]+");
            String type, name, breed, colour, gender;
            int age, id;
            // assuming file format: "name,age,mark" (e.g. Tom,18,65.50)
            while (sc.hasNext()) {
                String animal = sc.next();
                if (animal.equalsIgnoreCase("M")) {
                    id = sc.nextInt();
                    type = sc.next();
                    name = sc.next();
                    breed = sc.next();
                    age = sc.nextInt();
                    colour = sc.next();
                    gender = sc.next();
                    boolean neutered = false;
                    if (sc.next().equalsIgnoreCase("true")) {
                        neutered = true;
                    }
                    this.owners.get(0).addPet(id,type, name, breed, age, colour, gender, neutered);
                } else if (animal.equalsIgnoreCase("F")) {
                    id = sc.nextInt();
                    type = sc.next();
                    name = sc.next();
                    breed = sc.next();
                    age = sc.nextInt();
                    colour = sc.next();
                    gender = sc.next();
                    String water = sc.next();
                    this.owners.get(0).addPet(id, type, name, breed, age, colour, gender, water);
                } else if (animal.equalsIgnoreCase("B")) {
                    id = sc.nextInt();
                    type = sc.next();
                    name = sc.next();
                    breed = sc.next();
                    age = sc.nextInt();
                    colour = sc.next();
                    gender = sc.next();
                    int wingspan = sc.nextInt();
                    boolean fly;
                    if (sc.next().equalsIgnoreCase("true")) {
                        fly = true;
                    } else {
                        fly = false;
                    }
                    this.owners.get(0).addPet(id,type, name, breed, age, colour, gender, wingspan, fly);
                }
                if (animal.equalsIgnoreCase("P")) {
                    id = sc.nextInt();
                    type = sc.next();
                    name = sc.next();
                    breed = sc.next();
                    age = sc.nextInt();
                    colour = sc.next();
                    gender = sc.next();
                    this.owners.get(0).addPet(id, type, name, breed, age, colour, gender);
                } else {
                    //error goes here
                }

            }
            sc.close();

        } catch (IOException e) {
            System.out.println("Exception thrown. " + e);
        }
    }

    @Override
    public String toString() {
        return "Registry{" + "owners=" + owners + '}';
    }

}
