package oop19_ca2_aaron_reihill;

import java.util.Comparator;

/**
 *
 * @author aaron
 */
public class PetAgeComparator implements Comparator<Pet>
{

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
