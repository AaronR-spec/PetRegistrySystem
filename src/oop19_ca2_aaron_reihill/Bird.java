package oop19_ca2_aaron_reihill;

/**
 *
 * @author D00222467/Aaron Reihill
 */
public class Bird extends Pet
{

    private int wingspan;
    private boolean fly;

    /**
     * reads input and calls super constructor bird to make a bird object
     *
     * @param owner
     * @param petId
     * @param type
     * @param name
     * @param breed
     * @param age
     * @param colour
     * @param gender
     * @param wingspan
     * @param fly
     */
    public Bird(int owner, int petId, String type, String name, String breed, int age, String colour, String gender, int wingspan, boolean fly)
    {
        super(owner, petId, type, name, breed, age, colour, gender);
        this.wingspan = wingspan;
        this.fly = fly;
    }

    /**
     * reads input and calls super constructor bird to make a bird object
     *
     * @param owner
     * @param type
     * @param name
     * @param breed
     * @param age
     * @param colour
     * @param gender
     * @param wingspan
     * @param fly
     */
    public Bird(int owner, String type, String name, String breed, int age, String colour, String gender, int wingspan, boolean fly)
    {
        super(owner, type, name, breed, age, colour, gender);
        this.wingspan = wingspan;
        this.fly = fly;
    }

    /**
     * gets wingspan
     *
     * @return wingspan
     */
    public int getWingspan()
    {
        return wingspan;
    }

    /**
     * gets if bird can fly
     *
     * @return true or false if bird can fly
     */
    public boolean isFly()
    {
        return fly;
    }

    /**
     * sets wingspan to input
     *
     * @param wingspan
     */
    public void setWingspan(int wingspan)
    {
        this.wingspan = wingspan;
    }

    /**
     * sets fly to true or false
     *
     * @param fly
     */
    public void setFly(boolean fly)
    {
        this.fly = fly;
    }

    /**
     * takes string in and sets if bird can fly or not
     *
     * @param fly
     * @return true or false
     */
    public boolean setFly(String fly)
    {
        boolean set;
        if (fly.equalsIgnoreCase("true") || fly.equalsIgnoreCase("yes"))
        {
            this.fly = true;
            set = true;

        }
        else if (fly.equalsIgnoreCase("false") || fly.equalsIgnoreCase("no"))
        {
            this.fly = true;
            set = true;
        }
        else
        {
            set = false;
        }
        return set;
    }

    /**
     * polymorfism override of displayPet
     */
    @Override
    public void displayPet()
    {
        System.out.println("\n(" + this.getClass().getSimpleName() + ") PetID: " + this.getPetID() + ", OwnerID: " + this.getOwnerID() + ", Type: " + this.getType() + ", Name: " + this.getName() + ", Age: " + this.getAge() + ", Breed: " + this.getBreed() + ", Colour: " + this.getColour() + ", Gender: " + this.getGender() + ", DateReg: " + this.getRegDate() + ", Wingspan: " + getWingspan() + "ft" + ", Fly: " + isFly());

    }

    @Override
    public String toString()
    {
        return super.toString() + "{" + "wingspan=" + wingspan + ", fly=" + fly + '}';
    }

}
