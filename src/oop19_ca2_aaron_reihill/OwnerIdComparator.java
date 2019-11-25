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
