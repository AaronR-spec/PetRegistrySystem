/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oop19_ca2_aaron_reihill;

/**
 *
 * @author aaron
 */
public class Fish extends Pet
{
    private Water water;
    
    public Fish(String type, String breed, int age, String colour, String regDate,int wingspan, boolean fly)
    {
        super(type,breed,age,colour,regDate);
        this.water = this.water.UNKOWN;
    }
    public Fish(String type, String name, String breed, int age, String colour, String gender, String regDate,String water)
    {
        super(type,name,breed,age,colour,gender,regDate);
        findWater(water);
    }

    public Water getWater()
    {
        return water;
    }

    public void setWater(Water water)
    {
        this.water = water;
    }
    
    private void findWater(String w)
    {
        if(w.equalsIgnoreCase("FRESHWATER"))
        {
            this.water = this.water.FRESHWATER;
        }
        else if(w.equalsIgnoreCase("BRACKISH"))
        {
            this.water = this.water.BRACKISH;
        }
        else if(w.equalsIgnoreCase("SEAWATER"))
        {
            this.water = this.water.SEAWATER;
        }
        else
        {
            this.water = this.water.UNKOWN;
        }
    }
}
