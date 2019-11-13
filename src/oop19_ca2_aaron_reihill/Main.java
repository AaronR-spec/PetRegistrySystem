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
        Owner bob = new Owner("bob");
        Owner tim = new Owner("tim");
        Owner sam = new Owner("sam");
        
        Pet p2 = new Pet(sam.getId(),"Cat", "sarah","Poddle", 4, "Blue", "female", "20-20-10");
        Pet p3 = new Pet(bob.getId(),"Fish", "Poddle", 1, "Black", "21-20-10");
        Pet p4 = new Pet(bob.getId(),"GoldFish", "Poddle", 6, "Yellow", "20-20-10");
        Pet p1 = new Pet(sam.getId(),"Dog","kevin", "Poddle", 2, "Black", "male","4-22-10");

        Pet p5 = new Pet(tim.getId(),"Pig",  "christ","Belly", 92, "Black","UNKOWN", "4-22-10");
        Pet p6 = new Pet(sam.getId(),"Shark", "Great White", 33, "Green", "2-20-6");
        Pet p7 = new Pet(tim.getId(),"Elephant", "Big", 100, "Yelloq", "21-11-32");

        List<Pet> pets = new ArrayList<>();
        pets.add(p1);
        pets.add(p2);
        pets.add(p3);
        pets.add(p4);
        bob.setPets(pets);
        
        List<Pet> pets2 = new ArrayList<>();
        pets.add(p5);
        pets.add(p6);
        pets.add(p7);
        pets.add(p1);
        tim.setPets(pets2);
        
        displayList(bob);
        System.out.println("");
        displayList(tim);

    }
    public static void displayList(Owner o)
    {
        o.displayAllPets();
    }
}
