
package oop19_ca2_aaron_reihill;

import java.util.Comparator;

/**
 *
 * @author D00222467/Aaron Reihill
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
