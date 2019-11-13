/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oop19_ca2_aaron_reihill;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author D00222467
 */
public class Main
{

    public static void main(String[] args)
    {
        
        Pet p1 = new Pet("Dog","kevin", "Poddle", 2, "Black", "male","4-22-10");
        Pet p2 = new Pet("Cat", "sarah","Poddle", 4, "Blue", "female", "20-20-10");
        Pet p3 = new Pet("Fish", "Poddle", 1, "Black", "21-20-10");
        Pet p4 = new Pet("GoldFish", "Poddle", 6, "Yellow", "20-20-10");
        
        Pet p5 = new Pet("Pig",  "christ","Belly", 92, "Black","UNKOWN", "4-22-10");
        Pet p6 = new Pet("Shark", "Great White", 33, "Green", "2-20-6");
        Pet p7 = new Pet("Elephant", "Big", 100, "Yelloq", "21-11-32");

        List<Pet> pets = new ArrayList<>();
        pets.add(p1);
        pets.add(p2);
        pets.add(p3);
        pets.add(p4);
        
        List<Pet> pets2 = new ArrayList<>();
        pets.add(p5);
        pets.add(p6);
        pets.add(p7);
        pets.add(p1);
        Owner bob = new Owner("bob", pets);
        
        displayList(pets);
        displayList(pets2);
    }
    public static void displayList(List<Pet> pets)
    {
        for(Pet p: pets)
        {
            System.out.println(p);
        }
    }
}
