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

        Pet p1 = new Pet(bob.getId(), "Dog", "kevin", "Poddle", 2, "Black", "male", "4-22-10");
        Pet p2 = new Pet(bob.getId(), "Cat", "sarah", "Poddle", 4, "Blue", "female", "20-20-10");
        Pet p3 = new Pet(bob.getId(), "Fish", "Poddle", 1, "Black", "21-20-10");
        Pet p4 = new Pet(bob.getId(), "GoldFish", "Poddle", 6, "Yellow", "20-20-10");

        List<Pet> pets = new ArrayList<>();
        pets.add(p1);
        pets.add(p2);
        pets.add(p3);
        pets.add(p4);
        bob.setPets(pets);
        
        displayList(bob);
        System.out.println("\n");
        bob.removePet(p1);
        bob.removePet(6);
        displayList(bob);

    }

    public static void displayList(Owner o)
    {
        o.displayAllPets();
    }
}
