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

    ArrayList<Owner> owners = new ArrayList<>();

    public Registry()
    {
    }

    public Registry(ArrayList<Owner> owners)
    {
        this.owners = owners;
    }

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
        this.owners.add(new Owner(name));
    }

    public void addOwner(Owner o)
    {
        if (CheckOwnerDup(o.getName(), o.getAddress()) == -1)
        {
            this.owners.add(o);
        }
        else
        {
            System.out.println("Owner Already Registered");
        }
    }

    public void addOwner(String name, String email, String telephone, String address, List<Pet> pets)
    {
        if (CheckOwnerDup(name, address) == -1)
        {
            this.owners.add(new Owner(name, email, telephone, address, pets));
        }
        else
        {
            System.out.println("Owner Already Registered");
        }
    }

    public void addOwner(String name, String email, String address)
    {
        if (CheckOwnerDup(name, address) == -1)
        {
            this.owners.add(new Owner(name, email, address));
        }
        else
        {
            System.out.println("Owner Already Registered");
        }
    }

    public void addOwner(String name, String email, String telephone, String address)
    {
        if (CheckOwnerDup(name, address) == -1)
        {
            this.owners.add(new Owner(name, email, telephone, address));
        }
        else
        {
            System.out.println("Owner Already Registered");
        }
    }

    public void addOwner(String name, List<Pet> pets)
    {
        this.owners.add(new Owner(name, pets));
    }

    public void removeOwner(Owner o)
    {
        if (findOwner(o.getId()) == -1)
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
        if (ownerIndex != -1)
        {
            this.owners.remove(ownerIndex);
        }
        else
        {
            System.out.println("Owner Not Found");
        }
    }

    public void displayOwners()
    {
        Owner o = new Owner();
        o.displayAllOwners(owners);
    }

    private int findOwner(int id)
    {
        int index = -1;
        int i = 0;
        boolean found = false;
        while (!found && i < this.owners.size())
        {
            if (this.owners.get(i).getId() == id)
            {
                index = i;
                found = true;
            }
            i++;
        }
        return index;
    }

    private int CheckOwnerDup(String name, String address)
    {
        int ownerIndex = -1;
        boolean found = false;
        int i = 0;
        while (!found && i < this.owners.size())
        {
            Owner o = this.owners.get(i);
            if (o.getName().equalsIgnoreCase(name) && o.getAddress().equalsIgnoreCase(address))
            {
                ownerIndex = i;
                found = true;
            }
            i++;
        }
        return ownerIndex;
    }

    @Override
    public String toString()
    {
        return "Registry{" + "owners=" + owners + '}';
    }

}
