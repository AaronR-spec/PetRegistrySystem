package oop19_ca2_aaron_reihill;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author D00222467
 */
public class Owner
{

    private String name = "";
    private static int index = 0;
    private int id;
    private String email = "";
    private String telephone = "";
    private String address = "";
    private List<Pet> pets = new ArrayList<>();
    private static final String PET_ALREADY_REG = "Pet Already Registered";
    private static final String PET_NOT_FOUND = "Pet Not Found";

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

    public Owner(String name, String address)
    {
        this.name = name;
        this.address = address;
        this.id = index++;
    }

    public Owner(String name, String telephone, String address)
    {
        this.name = name;
        this.telephone = telephone;
        this.address = address;
        this.id = index++;
    }

    public Owner(int id, String name, String telephone, String address)
    {
        this.name = name;
        this.telephone = telephone;
        this.address = address;
        this.id = id;
    }

    public Owner(String name, String email, String telephone, String address)
    {
        this.name = name;

        this.id = Owner.index++;
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
            System.out.println(PET_ALREADY_REG);
        }
    }

    public void addPet(String type, String name, String breed, int age, String colour, String gender)
    {
        if (CheckPetDup(type, name, breed, age, colour, gender) == -1)
        {
            this.pets.add(Pet.createPet(this.id, type, name, breed, age, colour, gender));
        }
        else
        {
            System.out.println(PET_ALREADY_REG);
        }
    }

    public void addPet(int petId, String type, String name, String breed, int age, String colour, String gender)
    {
        if (CheckPetDup(type, name, breed, age, colour, gender) == -1)
        {
            this.pets.add(Pet.createPet(this.id, petId, type, name, breed, age, colour, gender));
        }
        else
        {
            System.out.println(PET_ALREADY_REG);
        }
    }

    public void addPet(int id, String type, String name, String breed, int age, String colour, String gender, String water)
    {
        if (CheckPetDup(type, name, breed, age, colour, gender) == -1)
        {
            this.pets.add(Pet.createPet(this.id, id, type, name, breed, age, colour, gender, water));
        }
        else
        {
            System.out.println(PET_ALREADY_REG);
        }
    }

    public void addPet(String type, String name, String breed, int age, String colour, String gender, String water)
    {
        if (CheckPetDup(type, name, breed, age, colour, gender) == -1)
        {
            this.pets.add(Pet.createPet(this.id, type, name, breed, age, colour, gender, water));
        }
        else
        {
            System.out.println(PET_ALREADY_REG);
        }
    }

    public void addPet(String type, String name, String breed, int age, String colour, String gender, String regDate, String water)
    {
        if (CheckPetDup(type, name, breed, age, colour, gender) == -1)
        {
            this.pets.add(Pet.createPet(this.id, type, name, breed, age, colour, gender, regDate, water));
        }
        else
        {
            System.out.println(PET_ALREADY_REG);
        }
    }

    public void addPet(String type, String name, String breed, int age, String colour, String gender, String regDate, boolean neutered)
    {
        if (CheckPetDup(type, name, breed, age, colour, gender) == -1)
        {
            this.pets.add(Pet.createPet(this.id, type, name, breed, age, colour, gender, regDate, neutered));
        }
        else
        {
            System.out.println(PET_ALREADY_REG);
        }
    }

    public void addPet(String type, String name, String breed, int age, String colour, String gender, boolean neutered)
    {
        if (CheckPetDup(type, name, breed, age, colour, gender) == -1)
        {
            this.pets.add(Pet.createPet(this.id, type, name, breed, age, colour, gender, neutered));
        }
        else
        {
            System.out.println(PET_ALREADY_REG);
        }
    }

    public void addPet(int petId, String type, String name, String breed, int age, String colour, String gender, boolean neutered)
    {
        if (CheckPetDup(type, name, breed, age, colour, gender) == -1)
        {
            this.pets.add(Pet.createPet(this.id, petId, type, name, breed, age, colour, gender, neutered));
        }
        else
        {
            System.out.println(PET_ALREADY_REG);
        }
    }

    public void addPet(String type, String name, String breed, int age, String colour, String gender, String regDate, int wingspan, boolean fly)
    {
        if (CheckPetDup(type, name, breed, age, colour, gender) == -1)
        {
            this.pets.add(Pet.createPet(this.id, type, name, breed, age, colour, gender, regDate, wingspan, fly));
        }
        else
        {
            System.out.println(PET_ALREADY_REG);
        }
    }

    public void addPet(String type, String name, String breed, int age, String colour, String gender, int wingspan, boolean fly)
    {
        if (CheckPetDup(type, name, breed, age, colour, gender) == -1)
        {
            this.pets.add(Pet.createPet(this.id, type, name, breed, age, colour, gender, wingspan, fly));
        }
        else
        {
            System.out.println(PET_ALREADY_REG);
        }
    }

    public void addPet(int petId, String type, String name, String breed, int age, String colour, String gender, int wingspan, boolean fly)
    {
        if (CheckPetDup(type, name, breed, age, colour, gender) == -1)
        {
            this.pets.add(Pet.createPet(this.id, petId, type, name, breed, age, colour, gender, wingspan, fly));
        }
        else
        {
            System.out.println(PET_ALREADY_REG);
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
            System.out.println(PET_NOT_FOUND);
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
            System.out.println(PET_NOT_FOUND);
        }
    }

    public void removeAllPet()
    {
        this.pets.clear();
    }

    public void displayAllPets()
    {
        Pet.displayAllPets(this.pets);

    }
    public void displayAllPetsByAge()
    {
        PetAgeComparator age = new PetAgeComparator();
        Pet.displayAllPets(Collections.sort(this.pets,age));

    }
    public int findPet(int id)
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
        pet.setType(type);
        pet.setName(name);
        pet.setBreed(breed);
        pet.setAge(age);
        pet.setColour(colour);
        pet.setGender(gender);
        int petIndex = -1;
        boolean found = false;
        int i = 0;
        while (!found && i < this.pets.size())
        {
            Pet p = this.pets.get(i);
            if (p.equals(pet))
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
        hash = 13 * hash + Objects.hashCode(this.name);
        hash = 13 * hash + this.id;
        hash = 13 * hash + Objects.hashCode(this.email);
        hash = 13 * hash + Objects.hashCode(this.telephone);
        hash = 13 * hash + Objects.hashCode(this.address);
        hash = 13 * hash + Objects.hashCode(this.pets);
        return hash;
    }

    @Override
    public boolean equals(Object obj)
    {
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
