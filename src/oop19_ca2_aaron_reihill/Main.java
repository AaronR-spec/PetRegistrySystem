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
        Owner bob = new Owner("bob","etqtq","dundalk");
        Owner kevin = new Owner("kevin");
        Owner greg = new Owner("greg");
        
        Pet p1 = new Mammal(bob.getId(), "Dog", "kevin", "Poddle", 2, "Black", "male", "4-22-10",true);
        Pet p2 = new Bird(bob.getId(), "Cat", "sarah", "Poddle", 4, "Blue", "female", "20-20-10",2,false);
        Pet p3 = new Fish(bob.getId(), "Fish", "Kevin","Poddle", 1, "Black","male", "21-20-10","freshwater");
        Pet p4 = new Pet(bob.getId(), "GoldFish", "Poddle", 6, "Yellow", "20-20-10");

        List<Pet> pets = new ArrayList<>();
        pets.add(p1);
        pets.add(p2);
        pets.add(p4);
        bob.setPets(pets);
        List<Pet> pets2 = new ArrayList<>();
        pets.add(p3);
        kevin.setPets(pets2);
        Registry r = new Registry();
        r.addOwner(bob);
        r.addOwner(kevin);
        r.displayOwners();
    }

    public static void displayList(Owner o)
    {
        o.displayAllPets();
        o.displayAllPets();
    }
}
