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
public class Bird extends Pet
{
    private int wingspan;
    private boolean fly;
    public Bird(String type, String breed, int age, String colour, String regDate,int wingspan, boolean fly)
    {
        super(type,breed,age,colour,regDate);
        this.wingspan = wingspan;
        this.fly = fly;
    }
    public Bird(String type, String name, String breed, int age, String colour, String gender, String regDate,int wingspan, boolean fly)
    {
        super(type,name,breed,age,colour,gender,regDate);
        this.wingspan = wingspan;
        this.fly = fly;
    }

    public int getWingspan()
    {
        return wingspan;
    }

    public boolean isFly()
    {
        return fly;
    }

    public void setWingspan(int wingspan)
    {
        this.wingspan = wingspan;
    }

    public void setFly(boolean fly)
    {
        this.fly = fly;
    }

    @Override
    public String toString()
    {
        return super.toString()+"{" + "wingspan=" + wingspan + ", fly=" + fly + '}';
    }
    
}
