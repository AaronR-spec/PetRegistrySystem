package oop19_ca2_aaron_reihill;

import java.util.Comparator;

/**
 *
 * @author D00222467/Aaron Reihill
 */
public class OwnerIdComparator implements Comparator<Owner>
{

    @Override
    public int compare(Owner a, Owner b)
    {
        if (a.getId() < b.getId())
        {
            return -1;
        }
        else if (a.getId() == b.getId())
        {
            return 0;
        }
        else
        {
            return 1;
        }
    }
}
