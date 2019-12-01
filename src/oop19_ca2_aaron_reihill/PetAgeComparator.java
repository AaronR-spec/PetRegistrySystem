package oop19_ca2_aaron_reihill;

import java.util.Comparator;

/**
 *
 * @author D00222467/Aaron Reihill
 */
public class PetAgeComparator implements Comparator<Pet>
{

    @Override
    public int compare(Pet a, Pet b)
    {
        if (a.getAge() < b.getAge())
        {
            return -1;
        }
        else if (a.getAge() == b.getAge())
        {
            return 0;
        }
        else
        {
            return 1;
        }
    }
}
