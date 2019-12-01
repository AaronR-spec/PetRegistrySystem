package oop19_ca2_aaron_reihill;

/**
 *
 * @author D00222467/Aaron Reihill
 */
public class Fish extends Pet
{

    private Water water = Water.UNKNOWN;

    /**
     * calls super constructor and creates fish object
     * @param owner
     * @param petId
     * @param type
     * @param name
     * @param breed
     * @param age
     * @param colour
     * @param gender
     * @param water
     */
    public Fish(int owner, int petId, String type, String name, String breed, int age, String colour, String gender, String water)
    {
        super(owner, petId, type, name, breed, age, colour, gender);
        setWater(water);
    }

    /**
     * calls super constructor and creates fish object
     * @param owner
     * @param type
     * @param name
     * @param breed
     * @param age
     * @param colour
     * @param gender
     * @param water
     */
    public Fish(int owner, String type, String name, String breed, int age, String colour, String gender, String water)
    {
        super(owner, type, name, breed, age, colour, gender);
        setWater(water);
    }

    /**
     * gets water enum state
     * @return water enum
     */
    public Water getWater()
    {
        return water;
    }

    /**
     * set water by enum
     * @param water
     */
    public void setWater(Water water)
    {
        this.water = water;
    }

    /**
     * polymorfism override of display pet
     */
    @Override
    public void displayPet()
    {
        System.out.println("\n(" + this.getClass().getSimpleName() + ") PetID: " + this.getPetID() + ", OwnerID: " + this.getOwnerID() + ", Type: " + this.getType() + ", Name: " + this.getName() + ", Age: " + this.getAge() + ", Breed: " + this.getBreed() + ", Colour: " + this.getColour() + ", Gender: " + this.getGender() + ", DateReg: " + this.getRegDate() + ", Water Type: " + getWater());

    }

    /**
     * sets water by string returns if set or not
     * @param w
     * @return true or false if set
     */
    public boolean setWater(String w)
    {
        boolean set;
        if (w.equalsIgnoreCase("FRESHWATER"))
        {
            this.water = Water.FRESHWATER;
            set = true;
        }
        else if (w.equalsIgnoreCase("BRACKISH"))
        {
            this.water = Water.BRACKISH;
            set = true;
        }
        else if (w.equalsIgnoreCase("SEAWATER"))
        {
            this.water = Water.SEAWATER;
            set = true;
        }
        else if (w.equalsIgnoreCase("UNKOWN") || w.equalsIgnoreCase("Other"))
        {
            this.water = Water.UNKNOWN;
            set = true;
        }
        else
        {
            set = false;
        }
        return set;
    }
}
