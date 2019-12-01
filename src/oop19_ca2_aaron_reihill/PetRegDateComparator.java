package oop19_ca2_aaron_reihill;

import java.util.Comparator;

/**
 *
 * @author D00222467/Aaron Reihill
 */
public class PetRegDateComparator implements Comparator<Pet>
{

    @Override
    public int compare(Pet a, Pet b)
    {
        return a.getRegDate().compareTo(b.getRegDate());
    }
}
