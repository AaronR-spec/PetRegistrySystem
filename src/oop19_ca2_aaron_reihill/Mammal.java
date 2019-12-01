package oop19_ca2_aaron_reihill;

/**
 *
 * @author D00222467/Aaron Reihill
 */
public class Mammal extends Pet
{

    private boolean neutered;

    /**
     * calls super constructor and creates mammal object 
     * @param type
     * @param name
     * @param breed
     * @param age
     * @param colour
     * @param gender
     * @param neutered
     */
    public Mammal(String type, String name, String breed, int age, String colour, String gender, boolean neutered)
    {
        super(type, name, breed, age, colour, gender);
        this.neutered = neutered;
    }

    /**
     * calls super constructor and creates mammal object 
     * @param owner
     * @param petId
     * @param type
     * @param name
     * @param breed
     * @param age
     * @param colour
     * @param gender
     * @param neutered
     */
    public Mammal(int owner, int petId, String type, String name, String breed, int age, String colour, String gender, boolean neutered)
    {
        super(owner, petId, type, name, breed, age, colour, gender);
        this.neutered = neutered;
    }

    /**
     * calls super constructor and creates mammal object 
     * @param owner
     * @param type
     * @param name
     * @param breed
     * @param age
     * @param colour
     * @param gender
     * @param neutered
     */
    public Mammal(int owner, String type, String name, String breed, int age, String colour, String gender, boolean neutered)
    {
        super(owner, type, name, breed, age, colour, gender);
        this.neutered = neutered;
    }

    /**
     * gets if Neutered
     * @return
     */
    public boolean isNeutered()
    {
        return neutered;
    }

    /**
     * set neutered by boolean input
     * @param neutered
     */
    public void setNeutered(boolean neutered)
    {
        this.neutered = neutered;
    }

    /**
     * sets neutered by string input
     * @param neutered
     */
    public void setNeutered(String neutered)
    {
        if (neutered.equalsIgnoreCase("True") || neutered.equalsIgnoreCase("Yes"))
        {
            this.neutered = true;
        }
        else if (neutered.equalsIgnoreCase("False") || neutered.equalsIgnoreCase("No"))
        {
            this.neutered = false;
        }
        else
        {
            System.out.println("Invalid Option");
        }
    }

    /**
     * override display pet and displays send pet
     */
    @Override
    public void displayPet()
    {
        System.out.println("\n(" + this.getClass().getSimpleName() + ") PetID: " + this.getPetID() + ", OwnerID: " + this.getOwnerID() + ", Type: " + this.getType() + ", Name: " + this.getName() + ", Age: " + this.getAge() + ", Breed: " + this.getBreed() + ", Colour: " + this.getColour() + ", Gender: " + this.getGender() + ", DateReg: " + this.getRegDate() + ", Neutered: " + isNeutered());

    }

    @Override
    public String toString()
    {
        return super.toString() + "{" + "neutered=" + neutered + '}';
    }

}
