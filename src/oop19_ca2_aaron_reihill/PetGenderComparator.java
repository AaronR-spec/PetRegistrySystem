package oop19_ca2_aaron_reihill;

import java.util.Comparator;

/**
 *
 * @author D00222467/Aaron Reihill
 */
public class PetGenderComparator implements Comparator<Pet>
{

    @Override
    public int compare(Pet a, Pet b)
    {
        return a.getGender().compareTo(b.getGender());
    }
}
