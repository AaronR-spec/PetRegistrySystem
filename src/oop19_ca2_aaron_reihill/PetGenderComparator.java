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
public class PetGenderComparator implements Comparator<Pet>
{
    	public int compare(Pet a, Pet b)
	{
		return a.getGender().compareTo(b.getGender());

		// String class has a compareTo() method that
		// returns -1, 0, or +1 as appropriate
	}
}
