/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oop19_ca2_aaron_reihill;

/**
 *
 * @author D00222467
 */
public class Pet {
    private String type;
    private String name;
    private String breed;
    private int age;
    private String colour;
    private String gender;
    private String regDate;
    private static int petID;
    private static int ownerID;

    public Pet() 
    {
        this.type = "";
        this.name = "";
        this.breed = "";
        this.age = 0;
        this.colour = "";
        this.gender = "";
        this.regDate = "";
    }

    public Pet(String type, String breed, int age, String colour, String regDate) {
        this.type = type;
        this.breed = breed;
        this.age = age;
        this.colour = colour;
        this.regDate = regDate;
    }

    
    public Pet(String type, String name, String breed, int age, String colour, String gender, String regDate)
    {
        this.type = type;
        this.name = name;
        this.breed = breed;
        this.age = age;
        this.colour = colour;
        this.gender = gender;
        this.regDate = regDate;
    }

    public String getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public String getBreed() {
        return breed;
    }

    public int getAge() {
        return age;
    }

    public String getColour() {
        return colour;
    }

    public String getGender() {
        return gender;
    }

    public String getRegDate() {
        return regDate;
    }

    public static int getPetID() {
        return petID;
    }

    public static int getOwnerID() {
        return ownerID;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setRegDate(String regDate) {
        this.regDate = regDate;
    }

    public static void setPetID(int petID) {
        Pet.petID = petID;
    }

    public static void setOwnerID(int ownerID) {
        Pet.ownerID = ownerID;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName()+ "{" + "type=" + type + ", name=" + name + ", breed=" + breed + ", age=" + age + ", colour=" + colour + ", gender=" + gender + ", regDate=" + regDate + '}';
    }
    
    
}
