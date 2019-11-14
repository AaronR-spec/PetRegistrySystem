/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oop19_ca2_aaron_reihill;

import java.util.List;

/**
 *
 * @author D00222467
 */
public class Pet
{

    private String type;
    private String name;
    private String breed;
    private int age;
    private String colour;
    private Gender gender;
    private String regDate;
    private static int index = 0;
    private int petID = 0;
    private int ownerID;

    public Pet()
    {
        this.type = "";
        this.name = "";
        this.breed = "";
        this.age = 0;
        this.colour = "";
        this.gender = gender.UNKOWN;
        this.regDate = "";
        this.petID = this.index++;
    }

    public Pet(String type, String breed, int age, String colour, String regDate)
    {
        this.type = type;
        this.breed = breed;
        this.age = age;
        this.colour = colour;
        this.regDate = regDate;
        this.gender = gender.UNKOWN;
        this.petID = this.index++;
    }

    public Pet(String type, String name, String breed, int age, String colour, String gender, String regDate)
    {
        this.type = type;
        this.name = name;
        this.breed = breed;
        this.age = age;
        this.colour = colour;
        findGender(gender);
        this.regDate = regDate;
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
        this.gender = gender.UNKOWN;
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
        if(this.gender == this.gender.MALE)
        {
            gender = "Male";
        }
        else if(this.gender == this.gender.FEMALE)
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

    public Pet createPet(int owner,String type, String name, String breed, int age, String colour, String gender, String regDate)
    {
        this.petID++;
        return new Pet(owner,type, name, breed, age, colour, gender, regDate);
    }
    public Pet createPet(int owner,String type, String name, String breed, int age, String colour, String gender, String regDate,String water)
    {
        this.petID++;
        return new Fish(owner,type, name, breed, age, colour, gender, regDate,water);
    }
    public Pet createPet(int owner,String type, String name, String breed, int age, String colour, String gender, String regDate,boolean neutered)
    {
        this.petID++;
        return new Mammal(owner,type, name, breed, age, colour, gender, regDate,neutered);
    }
    public Pet createPet(int owner,String type, String name, String breed, int age, String colour, String gender, String regDate,int wingspan,boolean fly)
    {
        this.petID++;
        return new Bird(owner,type, name, breed, age, colour, gender, regDate,wingspan,fly);
    }
    public void displayAllPets(List<Pet> pets)
    {
        for (Pet p : pets)
        {
                        
            if (p instanceof Mammal)
            {
                Mammal m = (Mammal) p;
                System.out.println("(Mammal) "+ "PetID:"+ m.getPetID()+ ", OwnerID: " + m.getOwnerID() + ", Type: " + m.getType() + ", Name: " + m.getName() + ", Age:" + m.getAge() + ", Breed: " + m.getBreed() + ", Colour:" + m.getColour() + ", Gender: " + m.getGender() + ", DateReg: " + m.getRegDate()+", Neutered: " + m.isNeutered());

            }
            else if (p instanceof Bird)
            {
                Bird b = (Bird) p;
                System.out.println("(Bird) "+ "PetID:"+ b.getPetID()+ ", OwnerID: " + b.getOwnerID() + ", Type: " + b.getType() + ", Name: " + b.getName() + ", Age:" + b.getAge() + ", Breed: " + b.getBreed() + ", Colour:" + b.getColour() + ", Gender: " + b.getGender() + ", DateReg: " + b.getRegDate()+", Wingspan: " +b.getWingspan()+"ft"+", Fly: " + b.isFly());

            }
            else if (p instanceof Fish)
            {
                Fish f = (Fish) p;
                System.out.println("(Fish) "+ "PetID:"+ f.getPetID()+ ", OwnerID: " + f.getOwnerID() + ", Type: " + f.getType() + ", Name: " + f.getName() + ", Age:" + f.getAge() + ", Breed: " + f.getBreed() + ", Colour:" + f.getColour() + ", Gender: " + f.getGender() + ", DateReg: " + f.getRegDate()+", Water Type: "+ f.getWater());

            }
            else{
            System.out.println("("+getClass().getSimpleName() +") PetID: " + p.getPetID()+ ", OwnerID: " + p.getOwnerID() + ", Type: " + p.getType() + ", Name: " + p.getName() + ", Age:" + p.getAge() + ", Breed: " + p.getBreed() + ", Colour:" + p.getColour() + ", Gender: " + p.getGender() + ", DateReg: " + p.getRegDate());
        }
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
    public String toString()
    {
        return getClass().getSimpleName() + "{" + "type=" + type + ", name=" + name + ", breed=" + breed + ", age=" + age + ", colour=" + colour + ", gender=" + gender + ", regDate=" + regDate + '}';
    }

}
