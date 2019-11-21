/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oop19_ca2_aaron_reihill;

import java.util.List;
import java.util.Objects;

/**
 *
 * @author D00222467
 */
public class Pet
{

    private String type = "";
    private String name = "";
    private String breed = ""; 
    private int age = 0;
    private String colour = "";
    private Gender gender = Gender.UNKOWN;
    private String regDate = "";
    private static int index = 0;
    private int petID = 0;
    private int ownerID;

    public Pet()
    {
    }

    public Pet(String type, String breed, int age, String colour, String regDate)
    {
        this.type = type;
        this.breed = breed;
        this.age = age;
        this.colour = colour;
        this.regDate = regDate;
        this.petID = this.index++;
    }

    public Pet(String type, String name, String breed, int age, String colour, String gender)
    {
        this.type = type;
        this.name = name;
        this.breed = breed;
        this.age = age;
        this.colour = colour;
        findGender(gender);
        this.petID = this.index++;
    }

    public Pet(int owner, String type, String breed, int age, String colour, String regDate)
    {
        this.ownerID = owner;
        this.type = type;
        this.breed = breed;
        this.age = age;
        this.colour = colour;
        this.regDate = regDate;
        this.petID = this.index++;
    }

    public Pet(int owner, String type, String breed, int age, String colour)
    {
        this.ownerID = owner;
        this.type = type;
        this.breed = breed;
        this.age = age;
        this.colour = colour;
        this.petID = this.index++;
    }
    public Pet(int owner,int petId, String type, String name, String breed, int age, String colour, String gender)
    {
        this.ownerID = owner;
        this.type = type;
        this.name = name;
        this.breed = breed;
        this.age = age;
        this.colour = colour;
        findGender(gender);
        this.petID = petId;
    }
    public Pet(int owner, String type, String name, String breed, int age, String colour, String gender)
    {
        this.ownerID = owner;
        this.type = type;
        this.name = name;
        this.breed = breed;
        this.age = age;
        this.colour = colour;
        findGender(gender);
        this.petID = this.index++;
    }

    public Pet(int owner, String type, String name, String breed, int age, String colour, String gender, String regDate)
    {
        this.ownerID = owner;
        this.type = type;
        this.name = name;
        this.breed = breed;
        this.age = age;
        this.colour = colour;
        findGender(gender);
        this.regDate = regDate;
        this.petID = this.index++;
    }

    public String getType()
    {
        return type;
    }

    public String getName()
    {
        return name;
    }

    public String getBreed()
    {
        return breed;
    }

    public int getAge()
    {
        return age;
    }

    public static int getIndex()
    {
        return index;
    }

    public String getColour()
    {
        return colour;
    }

    public Gender getGender()
    {
        return gender;
    }

    public String getGenderString()
    {
        String gender = "";
        if (this.gender == this.gender.MALE)
        {
            gender = "Male";
        }
        else if (this.gender == this.gender.FEMALE)
        {
            gender = "Female";
        }
        else
        {
            gender = "Unkown";
        }
        return gender;

    }

    public String getRegDate()
    {
        return regDate;
    }

    public int getPetID()
    {
        return petID;
    }

    public int getOwnerID()
    {
        return ownerID;
    }

    public void setType(String type)
    {
        this.type = type;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public void setBreed(String breed)
    {
        this.breed = breed;
    }

    public void setAge(int age)
    {
        this.age = age;
    }

    public void setColour(String colour)
    {
        this.colour = colour;
    }

    public void setGender(Gender gender)
    {
        this.gender = gender;
    }
    public void setGender(String gender)
    {
        if (gender.equalsIgnoreCase("male"))
        {
            this.gender = this.gender.MALE;
        }
        else if (gender.equalsIgnoreCase("female"))
        {
            this.gender = this.gender.FEMALE;
        }
        else
        {
            this.gender = this.gender.UNKOWN;
        }
    }

    public void setRegDate(String regDate)
    {
        this.regDate = regDate;
    }

    public static void setIndex(int index)
    {
        Pet.index = index;
    }

    public void setPetID(int petID)
    {
        this.petID = petID;
    }

    public void setOwnerID(int ownerID)
    {
        this.ownerID = ownerID;
    }
    public static Pet createPet(int owner,int petId, String type, String name, String breed, int age, String colour, String gender, String water)
    {
        return new Fish(owner,petId, type, name, breed, age, colour, gender, water);
    }

    public static Pet createPet(int owner, String type, String name, String breed, int age, String colour, String gender, String water)
    {
        return new Fish(owner, type, name, breed, age, colour, gender, water);
    }

    public static Pet createPet(int owner, String type, String name, String breed, int age, String colour, String gender, String regDate, String water)
    {
        return new Fish(owner, type, name, breed, age, colour, gender, regDate, water);
    }

    public static Pet createPet(int owner, String type, String name, String breed, int age, String colour, String gender, String regDate, boolean neutered)
    {
        return new Mammal(owner, type, name, breed, age, colour, gender, regDate, neutered);
    }

    public static Pet createPet(int owner, String type, String name, String breed, int age, String colour, String gender, boolean neutered)
    {
        return new Mammal(owner, type, name, breed, age, colour, gender, neutered);
    }
    public static Pet createPet(int owner,int petId, String type, String name, String breed, int age, String colour, String gender, boolean neutered)
    {
        return new Mammal(owner,petId, type, name, breed, age, colour, gender, neutered);
    }

    public static Pet createPet(int owner, String type, String name, String breed, int age, String colour, String gender, String regDate, int wingspan, boolean fly)
    {
        return new Bird(owner, type, name, breed, age, colour, gender, regDate, wingspan, fly);
    }

    public static Pet createPet(int owner, String type, String name, String breed, int age, String colour, String gender, int wingspan, boolean fly)
    {
        return new Bird(owner, type, name, breed, age, colour, gender, wingspan, fly);
    }
    public static Pet createPet(int owner,int petId, String type, String name, String breed, int age, String colour, String gender, int wingspan, boolean fly)
    {
        return new Bird(owner,petId, type, name, breed, age, colour, gender, wingspan, fly);
    }

    public static Pet createPet(int owner, String type, String name, String breed, int age, String colour, String gender)
    {
        return new Pet(owner, type, name, breed, age, colour, gender);
    }
        public static Pet createPet(int owner, int petId,String type, String name, String breed, int age, String colour, String gender)
    {
        return new Pet(owner,petId,type, name, breed, age, colour, gender);
    }
//override in class (mammal... etc)
    public void displayAllPets(List<Pet> pets)
    {
        for (Pet p : pets)
        {

            if (p instanceof Mammal)
            {
                Mammal m = (Mammal) p;
                System.out.println("\n("+m.getClass().getSimpleName() + ") PetID:" + m.getPetID() + ", OwnerID: " + m.getOwnerID() + ", Type: " + m.getType() + ", Name: " + m.getName() + ", Age: " + m.getAge() + ", Breed: " + m.getBreed() + ", Colour: " + m.getColour() + ", Gender: " + m.getGender() + ", DateReg: " + m.getRegDate() + ", Neutered: " + m.isNeutered());

            }
            else if (p instanceof Bird)
            {
                Bird b = (Bird) p;
                System.out.println("\n("+b.getClass().getSimpleName() + ") PetID:" + b.getPetID() + ", OwnerID: " + b.getOwnerID() + ", Type: " + b.getType() + ", Name: " + b.getName() + ", Age: " + b.getAge() + ", Breed: " + b.getBreed() + ", Colour: " + b.getColour() + ", Gender: " + b.getGender() + ", DateReg: " + b.getRegDate() + ", Wingspan: " + b.getWingspan() + "ft" + ", Fly: " + b.isFly());

            }
            else if (p instanceof Fish)
            {
                Fish f = (Fish) p;
                System.out.println("\n("+f.getClass().getSimpleName() + ") PetID:" + f.getPetID() + ", OwnerID: " + f.getOwnerID() + ", Type: " + f.getType() + ", Name: " + f.getName() + ", Age: " + f.getAge() + ", Breed: " + f.getBreed() + ", Colour: " + f.getColour() + ", Gender: " + f.getGender() + ", DateReg: " + f.getRegDate() + ", Water Type: " + f.getWater());

            }
            else
            {
                System.out.println("\n(" + getClass().getSimpleName() + ") PetID: " + p.getPetID() + ", OwnerID: " + p.getOwnerID() + ", Type: " + p.getType() + ", Name: " + p.getName() + ", Age: " + p.getAge() + ", Breed: " + p.getBreed() + ", Colour: " + p.getColour() + ", Gender: " + p.getGender() + ", DateReg: " + p.getRegDate());
            }
        }
    }

    public void displayPet(Pet p)
    {
        if (p instanceof Mammal)
        {
            Mammal m = (Mammal) p;
            System.out.println("\n("+m.getClass().getSimpleName() + ") PetID:" + m.getPetID() + ", OwnerID: " + m.getOwnerID() + ", Type: " + m.getType() + ", Name: " + m.getName() + ", Age: " + m.getAge() + ", Breed: " + m.getBreed() + ", Colour: " + m.getColour() + ", Gender: " + m.getGender() + ", DateReg: " + m.getRegDate() + ", Neutered: " + m.isNeutered());

        }
        else if (p instanceof Bird)
        {
            Bird b = (Bird) p;
            System.out.println("\n*("+b.getClass().getSimpleName() + ") PetID:" + b.getPetID() + ", OwnerID: " + b.getOwnerID() + ", Type: " + b.getType() + ", Name: " + b.getName() + ", Age: " + b.getAge() + ", Breed: " + b.getBreed() + ", Colour: " + b.getColour() + ", Gender: " + b.getGender() + ", DateReg: " + b.getRegDate() + ", Wingspan: " + b.getWingspan() + "ft" + ", Fly: " + b.isFly());

        }
        else if (p instanceof Fish)
        {
            Fish f = (Fish) p;
            System.out.println("\n("+f.getClass().getSimpleName() + ") PetID:" + f.getPetID() + ", OwnerID: " + f.getOwnerID() + ", Type: " + f.getType() + ", Name: " + f.getName() + ", Age: " + f.getAge() + ", Breed: " + f.getBreed() + ", Colour: " + f.getColour() + ", Gender: " + f.getGender() + ", DateReg: " + f.getRegDate() + ", Water Type: " + f.getWater());

        }
        else
        {
            System.out.println("\n(" + getClass().getSimpleName() + ") PetID: " + p.getPetID() + ", OwnerID: " + p.getOwnerID() + ", Type: " + p.getType() + ", Name: " + p.getName() + ", Age: " + p.getAge() + ", Breed: " + p.getBreed() + ", Colour: " + p.getColour() + ", Gender: " + p.getGender() + ", DateReg: " + p.getRegDate());
        }
    }

    private void findGender(String g)
    {
        if (g.equalsIgnoreCase("male"))
        {
            this.gender = this.gender.MALE;
        }
        else if (g.equalsIgnoreCase("female"))
        {
            this.gender = this.gender.FEMALE;
        }
        else
        {
            this.gender = this.gender.UNKOWN;
        }
    }

    @Override
    public int hashCode()
    {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.type);
        hash = 59 * hash + Objects.hashCode(this.name);
        hash = 59 * hash + Objects.hashCode(this.breed);
        hash = 59 * hash + this.age;
        hash = 59 * hash + Objects.hashCode(this.colour);
        hash = 59 * hash + Objects.hashCode(this.gender);
        hash = 59 * hash + Objects.hashCode(this.regDate);
        hash = 59 * hash + this.petID;
        hash = 59 * hash + this.ownerID;
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
        final Pet other = (Pet) obj;
        if (this.age != other.age)
        {
            return false;
        }
        if (!Objects.equals(this.type, other.type))
        {
            return false;
        }
        if (!Objects.equals(this.name, other.name))
        {
            return false;
        }
        if (!Objects.equals(this.breed, other.breed))
        {
            return false;
        }
        if (!Objects.equals(this.colour, other.colour))
        {
            return false;
        }
        if (this.gender != other.gender)
        {
            return false;
        }
        return true;
    }

    @Override
    public String toString()
    {
        return getClass().getSimpleName() + "{" + "type=" + type + ", name=" + name + ", breed=" + breed + ", age=" + age + ", colour=" + colour + ", gender=" + gender + ", regDate=" + regDate + '}';
    }

}
