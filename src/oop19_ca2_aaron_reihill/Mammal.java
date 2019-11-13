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
public class Mammal extends Pet
{
    private boolean neutered;

    public Mammal(String type, String breed, int age, String colour, String regDate,boolean neutered)
    {
        super(type,breed,age,colour,regDate);
        this.neutered = neutered;
    }
        public Mammal(String type, String name, String breed, int age, String colour, String gender, String regDate,boolean neutered)
    {
        super(type,name,breed,age,colour,gender,regDate);
        this.neutered = neutered;
    }

    public boolean isNeutered()
    {
        return neutered;
    }

    public void setNeutered(boolean neutered)
    {
        this.neutered = neutered;
    }

    @Override
    public String toString()
    {
        return super.toString()+"{" + "neutered=" + neutered + '}';
    }
        
    
    
}
