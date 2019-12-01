package oop19_ca2_aaron_reihill;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author D00222467/Aaron Reihill
 */
public class Owner implements Serializable
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

    /**
     * empty constructor
     */
    public Owner()
    {
    }

    /**
     * owner constructor
     *
     * @param name
     * @param telephone
     * @param address
     */
    public Owner(String name, String telephone, String address)
    {
        this.name = name;
        this.telephone = telephone;
        this.address = address;
        this.id = index++;
    }

    /**
     * owner constructor
     *
     * @param id
     * @param name
     * @param telephone
     * @param address
     */
    public Owner(int id, String name, String telephone, String address)
    {
        this.name = name;
        this.telephone = telephone;
        this.address = address;
        this.id = id;
    }

    /**
     * owner constructor
     *
     * @param name
     * @param email
     * @param telephone
     * @param address
     */
    public Owner(String name, String email, String telephone, String address)
    {
        this.name = name;

        this.id = Owner.index++;
        this.email = email;
        this.telephone = telephone;
        this.address = address;
    }

    /**
     * returns owner name
     *
     * @return name
     */
    public String getName()
    {
        return name;
    }

    /**
     * gets static index
     *
     * @return index
     */
    public static int getIndex()
    {
        return index;
    }

    /**
     * gets owner id
     *
     * @return id
     */
    public int getId()
    {
        return id;
    }

    /**
     * gets owner email
     *
     * @return email
     */
    public String getEmail()
    {
        return email;
    }

    /**
     * gets owners pets list
     *
     * @return pets
     */
    public List<Pet> getPets()
    {
        return pets;
    }

    /**
     * gets owners phone number
     *
     * @return telephone
     */
    public String getTelephone()
    {
        return telephone;
    }

    /**
     * gets address
     *
     * @return address
     */
    public String getAddress()
    {
        return address;
    }

    /**
     * sets name
     *
     * @param name
     */
    public void setName(String name)
    {
        this.name = name;
    }

    /**
     * sets static index
     *
     * @param index
     */
    public static void setIndex(int index)
    {
        Owner.index = index;
    }

    /**
     * sets owner id
     *
     * @param id
     */
    public void setId(int id)
    {
        this.id = id;
    }

    /**
     * sets owner email
     *
     * @param email
     */
    public void setEmail(String email)
    {
        this.email = email;
    }

    /**
     * sets owner telephone
     *
     * @param telephone
     */
    public void setTelephone(String telephone)
    {
        this.telephone = telephone;
    }

    /**
     * sets owner pets
     *
     * @param pets
     */
    public void setPets(List<Pet> pets)
    {
        this.pets = pets;
    }

    /**
     * sets owner address
     *
     * @param address
     */
    public void setAddress(String address)
    {
        this.address = address;
    }

    /**
     * adds pet object to owners pet list
     *
     * @param p
     */
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

    /**
     * adds pet object to owners pet list
     *
     * @param type
     * @param name
     * @param breed
     * @param age
     * @param colour
     * @param gender
     */
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

    /**
     * adds pet object to owners pet list
     *
     * @param petId
     * @param type
     * @param name
     * @param breed
     * @param age
     * @param colour
     * @param gender
     */
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

    /**
     * adds pet object to owners pet list
     *
     * @param id
     * @param type
     * @param name
     * @param breed
     * @param age
     * @param colour
     * @param gender
     * @param water
     */
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

    /**
     * adds pet object to owners pet list
     *
     * @param type
     * @param name
     * @param breed
     * @param age
     * @param colour
     * @param gender
     * @param water
     */
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

    /**
     * adds pet object to owners pet list
     *
     * @param type
     * @param name
     * @param breed
     * @param age
     * @param colour
     * @param gender
     * @param neutered
     */
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

    /**
     * adds pet object to owners pet list
     *
     * @param petId
     * @param type
     * @param name
     * @param breed
     * @param age
     * @param colour
     * @param gender
     * @param neutered
     */
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

    /**
     * adds pet object to owners pet list
     *
     * @param type
     * @param name
     * @param breed
     * @param age
     * @param colour
     * @param gender
     * @param wingspan
     * @param fly
     */
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

    /**
     * adds pet object to owners pet list
     *
     * @param petId
     * @param type
     * @param name
     * @param breed
     * @param age
     * @param colour
     * @param gender
     * @param wingspan
     * @param fly
     */
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

    /**
     * removes pet object form owners list
     *
     * @param p
     */
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

    /**
     * removes pet object form owners list
     *
     * @param id
     */
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

    /**
     * clears all owners pets
     */
    public void removeAllPet()
    {
        this.pets.clear();
    }

    /**
     * displays all of owners pets
     */
    public void displayAllPets()
    {
        Pet.displayAllPets(this.pets);

    }

    /**
     * displays all of owners pets by age
     *
     * @param p
     */
    public static void displayAllPetsByAge(List<Pet> p)
    {
        PetAgeComparator ageComparator = new PetAgeComparator();
        Collections.sort(p, ageComparator);
        Pet.displayAllPets(p);
    }

    /**
     * displays all of owners pets by id
     *
     * @param p
     */
    public static void displayAllPetsById(List<Pet> p)
    {
        PetIdComparator idComparator = new PetIdComparator();
        Collections.sort(p, idComparator);
        Pet.displayAllPets(p);
    }

    /**
     * displays all of owners pets by gender
     *
     * @param p
     */
    public static void displayAllPetsByGender(List<Pet> p)
    {
        PetGenderComparator genderComparator = new PetGenderComparator();
        Collections.sort(p, genderComparator);
        Pet.displayAllPets(p);
    }

    /**
     * displays all of owners pets by registered date
     *
     * @param p
     */
    public static void displayAllPetsByRegDate(List<Pet> p)
    {
        PetRegDateComparator regComparator = new PetRegDateComparator();
        Collections.sort(p, regComparator);
        Collections.reverse(p);
        Pet.displayAllPets(p);
    }

    /**
     * returns pet index position in owners pet list
     *
     * @param id
     * @return pets position in list
     */
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
