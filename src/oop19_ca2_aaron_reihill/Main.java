/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oop19_ca2_aaron_reihill;

import java.util.ArrayList;

/**
 *
 * @author D00222467
 */
public class Main
{

    public static void main(String[] args)
    {
        Pet p1 = new Pet("Dog", "Poddle", 2, "Black", "20-20-10");
        Pet p2 = new Pet("Cat", "Poddle", 2, "Black", "20-20-10");
        Pet p3 = new Pet("Fish", "Poddle", 2, "Black", "20-20-10");
        Pet p4 = new Pet("GoldFish", "Poddle", 2, "Black", "20-20-10");

        ArrayList<Pet> pets = new ArrayList<>();
        pets.add(p1);
        pets.add(p2);
        pets.add(p3);
        pets.add(p4);
    }
}
