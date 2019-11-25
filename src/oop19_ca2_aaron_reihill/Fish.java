/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oop19_ca2_aaron_reihill;

/**
 *
 * @author aaron
 */
public class Fish extends Pet
{

    private Water water = Water.UNKOWN;

    public Fish(String type, String breed, int age, String colour, String regDate)
    {
        super(type, breed, age, colour, regDate);
    }
    public Fish(int owner,int petId, String type, String name, String breed, int age, String colour, String gender, String water)
    {
        super(owner,petId, type, name, breed, age, colour, gender);
        setWater(water);
    }
    public Fish(int owner, String type, String name, String breed, int age, String colour, String gender, String water)
    {
        super(owner, type, name, breed, age, colour, gender);
        setWater(water);
    }

    public Fish(String type, String name, String breed, int age, String colour, String gender, String water)
    {
        super(type, name, breed, age, colour, gender);
        setWater(water);
    }

    public Fish(int owner, String type, String name, String breed, int age, String colour, String gender, String regDate, String water)
    {
        super(owner, type, name, breed, age, colour, gender, regDate);
        setWater(water);
    }

    public Water getWater()
    {
        return water;
    }

    public void setWater(Water water)
    {
        this.water = water;
    }
    @Override
    public void displayPet()
    {
       System.out.println("\n(" + this.getClass().getSimpleName() + ") PetID: " + this.getPetID() + ", OwnerID: " + this.getOwnerID() + ", Type: " + this.getType() + ", Name: " + this.getName() + ", Age: " + this.getAge() + ", Breed: " + this.getBreed() + ", Colour: " + this.getColour() + ", Gender: " + this.getGender() + ", DateReg: " + this.getRegDate() + ", Water Type: " + getWater());

    }
    public boolean setWater(String w)
    {
        boolean set;
        if (w.equalsIgnoreCase("FRESHWATER"))
        {
            this.water = Water.FRESHWATER;
            set = true;
        }
        else if (w.equalsIgnoreCase("BRACKISH"))
        {
            this.water = Water.BRACKISH;
            set = true;
        }
        else if (w.equalsIgnoreCase("SEAWATER"))
        {
            this.water = Water.SEAWATER;
            set = true;
        }
        else if(w.equalsIgnoreCase("UNKOWN")||w.equalsIgnoreCase("Other"))
        {
            this.water = Water.UNKOWN;
            set = true;
        }
        else
        {
            set = false;
        }
        return set;
    }
}
