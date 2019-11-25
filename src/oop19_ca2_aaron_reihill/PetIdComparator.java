/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oop19_ca2_aaron_reihill;

import java.util.Comparator;

/**
 *
 * @author aaron
 */
public class PetIdComparator implements Comparator<Pet>
{
    @Override
    public int compare(Pet a, Pet b)
    {
        if (a.getPetID() < b.getPetID())
        {
            return -1;
        }
        else if (a.getPetID() == b.getPetID())
        {
            return 0;
        }
        else
        {
            return 1;
        }
    }
}
