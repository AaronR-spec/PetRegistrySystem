/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oop19_ca2_aaron_reihill;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author D00222467
 */
public class Owner
{

    private String name;
    private static int index = 0;
    private int id;
    private String email;
    private String telephone;
    private String address;
    private List<Pet> pets = new ArrayList<>();

    public Owner()
    {
    }

    public Owner(String name)
    {
        this.name = name;
        this.id = index++;
    }

    public Owner(String name, List<Pet> pets)
    {
        this.name = name;
        this.pets = pets;
        this.id = index++;
    }

    public Owner(String name, String email, String telephone, String address, List<Pet> pets)
    {
        this.name = name;
        this.email = email;
        this.telephone = telephone;
        this.address = address;
        this.pets = pets;
        this.id = index++;
    }

    public Owner(String name, String email, String address)
    {
        this.name = name;
        this.email = email;
        this.address = address;
        this.id = index++;
    }

    public Owner(String name, String email, String telephone, String address)
    {
        this.name = name;
        this.id = index++;
        this.email = email;
        this.telephone = telephone;
        this.address = address;
    }

    public String getName()
    {
        return name;
    }

    public static int getIndex()
    {
        return index;
    }

    public int getId()
    {
        return id;
    }

    public String getEmail()
    {
        return email;
    }

    public List<Pet> getPets()
    {
        return pets;
    }

    public String getTelephone()
    {
        return telephone;
    }

    public String getAddress()
    {
        return address;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public static void setIndex(int index)
    {
        Owner.index = index;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public void setTelephone(String telephone)
    {
        this.telephone = telephone;
    }

    public void setPets(List<Pet> pets)
    {
        this.pets = pets;
    }

    public void setAddress(String address)
    {
        this.address = address;
    }

    public void addPet(Pet p)
    {
        if (CheckPetDup(p.getType(), p.getName(), p.getBreed(), p.getAge(), p.getColour(), p.getGenderString()) == -1)
        {
            this.pets.add(p);
        }
        else
        {
            System.out.println("Pet Already Registered");
        }
    }

    public void addPet(String type, String name, String breed, int age, String colour, String gender, String regDate)
    {
        if (CheckPetDup(type, name, breed, age, colour, gender) == -1)
        {
            Pet p = new Pet();
            this.pets.add(p.createPet(this.id, type, name, breed, age, colour, gender, regDate));
        }
        else
        {
            System.out.println("Pet Already Registered");
        }
    }

    public void addPet(String type, String name, String breed, int age, String colour, String gender, String regDate, String water)
    {
        if (CheckPetDup(type, name, breed, age, colour, gender) == -1)
        {
            Pet p = new Pet();
            this.pets.add(p.createPet(this.id, type, name, breed, age, colour, gender, regDate, water));
        }
        else
        {
            System.out.println("Pet Already Registered");
        }
    }

    public void addPet(String type, String name, String breed, int age, String colour, String gender, String regDate, boolean neutered)
    {
        if (CheckPetDup(type, name, breed, age, colour, gender) == -1)
        {
            Pet p = new Pet();
            this.pets.add(p.createPet(this.id, type, name, breed, age, colour, gender, regDate, neutered));
        }
        else
        {
            System.out.println("Pet Already Registered");
        }
    }

    public void addPet(String type, String name, String breed, int age, String colour, String gender, String regDate, int wingspan, boolean fly)
    {
        if (CheckPetDup(type, name, breed, age, colour, gender) == -1)
        {
            Pet p = new Pet();
            this.pets.add(p.createPet(this.id, type, name, breed, age, colour, gender, regDate, wingspan, fly));
        }
        else
        {
            System.out.println("Pet Already Registered");
        }
    }

    public void removePet(Pet p)
    {
        int petIndex = findPet(p.getPetID());
        if (petIndex != -1)
        {
            this.pets.remove(this.pets.get(petIndex));
        }
        else
        {
            System.out.println("Pet Not Found");
        }
    }

    public void removePet(int id)
    {
        int petIndex = findPet(id);
        if (petIndex != -1)
        {
            this.pets.remove(petIndex);
        }
        else
        {
            System.out.println("Pet Not Found");
        }
    }

    public void displayAllPets()
    {
        Pet p = new Pet();
        p.displayAllPets(this.pets);

    }

    public void displayAllOwners(List<Owner> owners)
    {
        this.index--;
        for (Owner o : owners)
        {
            System.out.println("\nID: " + o.getId() + "\nName: " + o.getName() + "\nEmail: " + o.getEmail() + "\nTelephone: " + o.getTelephone() + "\nAddress: " + o.getAddress() + "\nPets Registered: " + o.getPets().size());
        }
    }

    private int findPet(int id)
    {
        int petIndex = -1;
        boolean found = false;
        int i = 0;
        while (!found && i < this.pets.size())
        {
            if (this.pets.get(i).getPetID() == id)
            {
                petIndex = i;
                found = true;
            }
            i++;
        }
        return petIndex;
    }

    private int CheckPetDup(String type, String name, String breed, int age, String colour, String gender)
    {
        Pet pet = new Pet();
        int petIndex = -1;
        boolean found = false;
        int i = 0;
        while (!found && i < this.pets.size())
        {
            Pet p = this.pets.get(i);
            if (!p.equals(pet))
            {
                petIndex = i;
                found = true;
            }
            i++;
        }
        return petIndex;
    }

    @Override
    public int hashCode()
    {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.name);
        hash = 53 * hash + this.id;
        hash = 53 * hash + Objects.hashCode(this.email);
        hash = 53 * hash + Objects.hashCode(this.telephone);
        hash = 53 * hash + Objects.hashCode(this.address);
        hash = 53 * hash + Objects.hashCode(this.pets);
        return hash;
    }

    @Override
    public boolean equals(Object obj)
    {
        this.index--;
        if (this == obj)
        {
            return true;
        }
        if (obj == null)
        {
            return false;
        }
        if (getClass() != obj.getClass())
        {
            return false;
        }
        final Owner other = (Owner) obj;
        if (!Objects.equals(this.name, other.name))
        {
            return false;
        }
        if (!Objects.equals(this.address, other.address))
        {
            return false;
        }
        return true;
    }

    @Override
    public String toString()
    {
        return getClass().getSimpleName() + "{" + "name=" + name + ", email=" + email + ", telephone=" + telephone + ", address=" + address + ", pets=" + pets + '}';
    }

}
