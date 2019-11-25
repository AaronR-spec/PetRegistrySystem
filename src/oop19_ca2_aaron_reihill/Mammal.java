
package oop19_ca2_aaron_reihill;

/**
 *
 * @author aaron
 */
public class Mammal extends Pet
{

    private boolean neutered;

    public Mammal()
    {
    }
    public Mammal(String type, String breed, int age, String colour, String regDate, boolean neutered)
    {
        super(type, breed, age, colour, regDate);
        this.neutered = neutered;
    }

    public Mammal(String type, String name, String breed, int age, String colour, String gender, boolean neutered)
    {
        super(type, name, breed, age, colour, gender);
        this.neutered = neutered;
    }
    public Mammal(int owner,int petId,String type, String name, String breed, int age, String colour, String gender, boolean neutered)
    {
        super(owner,petId,type, name, breed, age, colour, gender);
        this.neutered = neutered;
    }

    public Mammal(int owner, String type, String name, String breed, int age, String colour, String gender, String regDate, boolean neutered)
    {
        super(owner, type, name, breed, age, colour, gender, regDate);
        this.neutered = neutered;
    }
    public Mammal(int owner, String type, String name, String breed, int age, String colour, String gender, boolean neutered)
    {
        super(owner, type, name, breed, age, colour, gender);
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
    public void displayPet()
    {
       System.out.println("\n(" + this.getClass().getSimpleName() + ") PetID: " + this.getPetID() + ", OwnerID: " + this.getOwnerID() + ", Type: " + this.getType() + ", Name: " + this.getName() + ", Age: " + this.getAge() + ", Breed: " + this.getBreed() + ", Colour: " + this.getColour() + ", Gender: " + this.getGender() + ", DateReg: " + this.getRegDate() + ", Neutered: " + isNeutered());

    }
    public static Pet createMammal(String type, String name, String breed, int age, String colour, String gender, String regDate, boolean neutered)
    {
        return new Mammal(type, name, breed, age, colour, gender,neutered);
    }

    @Override
    public String toString()
    {
        return super.toString() + "{" + "neutered=" + neutered + '}';
    }

}
