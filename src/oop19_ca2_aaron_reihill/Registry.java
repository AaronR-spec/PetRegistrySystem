/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oop19_ca2_aaron_reihill;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author D00222467
 */
public class Registry 
{
    ArrayList<Owner> owners;

    public ArrayList<Owner> getOwners() 
    {
        return owners;
    }

    public void setOwners(ArrayList<Owner> owners) 
    {
        this.owners = owners;
    }
    public void addOwner(String name)
    {
        owners.add(new Owner(name));
    }
    public void addOwner(String name, String email, String telephone, String address, List<Pet> pets)
    {
        owners.add(new Owner(name,email,telephone,address,pets));
    }
    public void addOwner(String name, String email, String address)
    {
        owners.add(new Owner(name,email,address));
    }
        public void addOwner(String name, int id, String email, String telephone, String address)
    {
        owners.add(new Owner(name,id,email,telephone,address));
    }
    public void addOwner(String name, List<Pet> pets)
    {
        owners.add(new Owner(name,pets));
    }
    public void removeOwner(Owner o)
    {
        int ownerIndex = findOwner(o.getId());
        if(ownerIndex!= -1)
        {
        this.owners.remove(o);
        }
        else
        {
            System.out.println("Owner Not Found");
        }
    }
    public void removeOwner(int id)
    {
        int ownerIndex = findOwner(id);
        if(ownerIndex != -1)
        {
            this.owners.remove(ownerIndex);
        }
        else
        {
            System.out.println("Owner Not Found");
        }
    }
    private int findOwner(int id)
    {
        int index = -1;
        int i = 0;
        boolean found =false;
        while(!found&& i<this.owners.size())
        {
            if(this.owners.get(i).getId()== id)
            {
               index=i;
               found = true;
            }
        }
        return index;
    }
}
