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

    public void addOwner(String name, String telephone, String address)
    {
        if (CheckOwnerDup(name, address) == -1)
        {
            this.owners.add(new Owner(name, telephone, address));
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
        if (findOwner(o.getId()) != -1)
        {
            this.owners.remove(o);
        }
        else
        {
            System.out.println("Owner Not Found");
        }
    }

    public void removePet(int id, int petID)
    {
        int ownerIndex = findOwner(id);
        if (ownerIndex != -1)
        {
            Owner o = getOwnerByID(id);
            o.removePet(petID);
        }
        else
        {
            System.out.println("Pet Not Found");
        }
    }

    public String petsName(int id, int petID)
    {
        String name = "";
        int ownerIndex = findOwner(id);
        if (ownerIndex != -1)
        {
            Owner o = getOwnerByID(id);
            int index = o.findPet(petID);
            name = o.getPets().get(index).getName();
        }
        return name;
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

    public void displayOwnersPet(int id)
    {
        Owner o = getOwnerByID(id);
        if (findOwnerID(o.getName()) != -1)
        {
            o.displayAllPets();
        }
        else
        {
            System.out.println("Owner Not Found");
        }
    }
    public int findOwnerID(String name)
    {
        int ownerID = -1;
        boolean found = false;
        int i = 0;
        while (!found && i < this.owners.size())
        {
            if (this.owners.get(i).getName().equalsIgnoreCase(name))
            {
                ownerID = this.owners.get(i).getId();
                found = true;
            }
            i++;
        }
        return ownerID;
    }
    public static void displayOwner(Owner o)
    {
        o.displayOwner(o);
    }
    public Owner getOwnerByID(int id)
    {
        Owner o = new Owner();
        int i = 0;
        boolean found = false;
        while (!found && i < this.owners.size())
        {
            if (this.owners.get(i).getId() == id)
            {
                o = this.owners.get(i);
                found = true;
            }
            i++;
        }
        return o;
    }

    public int findOwner(int id)
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
        Owner owner = new Owner();
        owner.setName(name);
        owner.setAddress(address);
        int i = 0;
        while (!found && i < this.owners.size())
        {
            if (this.owners.get(i).equals(i))
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
