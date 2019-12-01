package oop19_ca2_aaron_reihill;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Objects;
import java.util.Date;
import java.util.InputMismatchException;

/**
 *
 * @author D00222467/Aaron Reihill
 */
public class Pet implements Serializable
{

    private String type = "";
    private String name = "";
    private String breed = "";
    private int age = 0;
    private String colour = "";
    private Gender gender = Gender.UNKNOWN;
    private Date regDate;
    private static int index = 0;
    private int petID = 0;
    private int ownerID;

    /**
     * Empty pet constructor
     */
    public Pet()
    {
    }

    /**
     * Pet constructor
     *
     * @param type
     * @param breed
     * @param age
     * @param colour
     * @param regDate
     */
    public Pet(String type, String breed, int age, String colour, String regDate)
    {
        this.type = type;
        this.breed = breed;
        this.age = age;
        this.colour = colour;
        this.setRegDate(regDate);
        this.petID = Pet.index++;
    }

    /**
     * Pet constructor
     *
     * @param type
     * @param name
     * @param breed
     * @param age
     * @param colour
     * @param gender
     */
    public Pet(String type, String name, String breed, int age, String colour, String gender)
    {
        this.type = type;
        this.name = name;
        this.breed = breed;
        this.age = age;
        this.colour = colour;
        findGender(gender);
        this.petID = Pet.index++;
    }

    /**
     * Pet constructor
     *
     * @param owner
     * @param petId
     * @param type
     * @param name
     * @param breed
     * @param age
     * @param colour
     * @param gender
     */
    public Pet(int owner, int petId, String type, String name, String breed, int age, String colour, String gender)
    {
        this.ownerID = owner;
        this.type = type;
        this.name = name;
        this.breed = breed;
        this.age = age;
        this.colour = colour;
        findGender(gender);
        this.regDate = new Date();
        this.petID = petId;
    }

    /**
     * Pet constructor
     *
     * @param owner
     * @param type
     * @param name
     * @param breed
     * @param age
     * @param colour
     * @param gender
     */
    public Pet(int owner, String type, String name, String breed, int age, String colour, String gender)
    {
        this.ownerID = owner;
        this.type = type;
        this.name = name;
        this.breed = breed;
        this.age = age;
        this.colour = colour;
        this.regDate = new Date();
        findGender(gender);
        this.petID = Pet.index++;
    }

    /**
     * Pet constructor
     *
     * @param owner
     * @param type
     * @param name
     * @param breed
     * @param age
     * @param colour
     * @param gender
     * @param regDate
     */
    public Pet(int owner, String type, String name, String breed, int age, String colour, String gender, String regDate)
    {
        this.ownerID = owner;
        this.type = type;
        this.name = name;
        this.breed = breed;
        this.age = age;
        this.colour = colour;
        findGender(gender);
        this.setRegDate(regDate);
        this.petID = Pet.index++;
    }

    /**
     * gets pets type
     *
     * @return type
     */
    public String getType()
    {
        return type;
    }

    /**
     * gets pets name
     *
     * @return name
     */
    public String getName()
    {
        return name;
    }

    /**
     * gets pets breed
     *
     * @return breed
     */
    public String getBreed()
    {
        return breed;
    }

    /**
     * gets pets Registered Date
     *
     * @return Registered Date
     */
    public Date getRegDate()
    {
        return regDate;
    }

    /**
     * gets pets age
     *
     * @return Age
     */
    public int getAge()
    {
        return age;
    }

    /**
     * gets static pets index
     *
     * @return Index
     */
    public static int getIndex()
    {
        return index;
    }

    /**
     * gets pets colour
     *
     * @return colour
     */
    public String getColour()
    {
        return colour;
    }

    /**
     * gets pets gender enum
     *
     * @return gender as enum
     */
    public Gender getGender()
    {
        return gender;
    }

    /**
     * gets pet gender as string
     *
     * @return gender as string
     */
    public String getGenderString()
    {
        String petGender;
        if (null == this.gender)
        {
            petGender = "Unkown";
        }
        else
        {
            switch (this.gender)
            {
                case MALE:
                    petGender = "Male";
                    break;
                case FEMALE:
                    petGender = "Female";
                    break;
                default:
                    petGender = "Unkown";
                    break;
            }
        }
        return petGender;

    }

    /**
     * gets pets id
     *
     * @return pet id
     */
    public int getPetID()
    {
        return petID;
    }

    /**
     * gets pets owner id
     *
     * @return owner id
     */
    public int getOwnerID()
    {
        return ownerID;
    }

    /**
     * sets type to input
     *
     * @param type
     */
    public void setType(String type)
    {
        this.type = type;
    }

    /**
     * sets name to input
     *
     * @param name
     */
    public void setName(String name)
    {
        this.name = name;
    }

    /**
     * sets breed to input
     *
     * @param breed
     */
    public void setBreed(String breed)
    {
        this.breed = breed;
    }

    /**
     * sets age to input
     *
     * @param age
     * @throws InputMismatchException which is handled and printed error message
     */
    public void setAge(int age)
    {
        try
        {
            this.age = age;
        }
        catch (InputMismatchException e)
        {
            System.out.println("Error Age Can Not Be String");
        }
    }

    /**
     * set colour to input
     *
     * @param colour
     */
    public void setColour(String colour)
    {
        this.colour = colour;
    }

    /**
     * set gender to input enum
     *
     * @param gender
     */
    public void setGender(Gender gender)
    {
        this.gender = gender;
    }

    /**
     * sets the pets gender using string input
     *
     * @param gender
     * @return true if gender is set
     */
    public boolean setGender(String gender)
    {
        boolean changed = false;
        if (gender.equalsIgnoreCase("MALE"))
        {
            this.gender = Gender.MALE;
            changed = true;
        }
        else if (gender.equalsIgnoreCase("FEMALE"))
        {
            this.gender = Gender.FEMALE;
            changed = true;
        }
        else if (gender.equalsIgnoreCase("UNKOWN") || gender.equalsIgnoreCase("Other"))
        {
            this.gender = Gender.UNKNOWN;
            changed = true;
        }
        return changed;
    }

    /**
     * sets registered date to date
     *
     * @param regDate
     */
    public void setRegDate(Date regDate)
    {
        this.regDate = regDate;
    }

    /**
     * sets registered date to string
     *
     * @param regDate
     * @throws InputMismatchException which is handled and printed error message
     */
    public void setRegDate(String regDate)
    {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        Date date = null;
        try
        {
            date = dateFormat.parse(regDate);
            this.regDate = date;
        }
        catch (ParseException e)
        {
            System.out.println("Date In Wrong Format");
        }

    }

    /**
     * sets static pet variable index to input
     *
     * @param index
     * @throws InputMismatchException which is handled and printed error message
     */
    public static void setIndex(int index)
    {
        try
        {
            Pet.index = index;
        }
        catch (InputMismatchException e)
        {
            System.out.println("Error Index Can Not Be String");
        }
    }

    /**
     * sets pet id to input
     *
     * @param petID
     * @throws InputMismatchException which is handled and printed error message
     */
    public void setPetID(int petID)
    {
        try
        {
            this.petID = petID;
        }
        catch (InputMismatchException e)
        {
            System.out.println("Error Pet Id Can Not Be String");
        }
    }

    /**
     * sets pet owner id to input
     *
     * @param ownerID
     * @throws InputMismatchException which is handled and printed error message
     */
    public void setOwnerID(int ownerID)
    {
        try
        {
            this.ownerID = ownerID;
        }
        catch (InputMismatchException e)
        {
            System.out.println("Error Pet Id Can Not Be String");
        }
    }

    /**
     * reads input and calls constructor fish to make a fish object
     *
     * @param owner
     * @param petId
     * @param type
     * @param name
     * @param breed
     * @param age
     * @param colour
     * @param gender
     * @param water
     * @return pet object
     */
    public static Pet createPet(int owner, int petId, String type, String name, String breed, int age, String colour, String gender, String water)
    {
        return new Fish(owner, petId, type, name, breed, age, colour, gender, water);
    }

    /**
     * reads input and calls constructor fish to make a fish object
     *
     * @param owner
     * @param type
     * @param name
     * @param breed
     * @param age
     * @param colour
     * @param gender
     * @param water
     * @return pet object
     */
    public static Pet createPet(int owner, String type, String name, String breed, int age, String colour, String gender, String water)
    {
        return new Fish(owner, type, name, breed, age, colour, gender, water);
    }

    /**
     * reads input and calls constructor mammal to make a mammal object
     *
     * @param owner
     * @param type
     * @param name
     * @param breed
     * @param age
     * @param colour
     * @param gender
     * @param neutered
     * @return pet object
     */
    public static Pet createPet(int owner, String type, String name, String breed, int age, String colour, String gender, boolean neutered)
    {
        return new Mammal(owner, type, name, breed, age, colour, gender, neutered);
    }

    /**
     * reads input and calls constructor mammal to make a mammal object
     *
     * @param owner
     * @param petId
     * @param type
     * @param name
     * @param breed
     * @param age
     * @param colour
     * @param gender
     * @param neutered
     * @return pet object
     */
    public static Pet createPet(int owner, int petId, String type, String name, String breed, int age, String colour, String gender, boolean neutered)
    {
        return new Mammal(owner, petId, type, name, breed, age, colour, gender, neutered);
    }

    /**
     * reads input and calls constructor bird to make a bird object
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
     * @return pet objects
     */
    public static Pet createPet(int owner, String type, String name, String breed, int age, String colour, String gender, int wingspan, boolean fly)
    {
        return new Bird(owner, type, name, breed, age, colour, gender, wingspan, fly);
    }

    /**
     * reads input and calls constructor bird to make a bird object
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
     * @return pet objects
     */
    public static Pet createPet(int owner, int petId, String type, String name, String breed, int age, String colour, String gender, int wingspan, boolean fly)
    {
        return new Bird(owner, petId, type, name, breed, age, colour, gender, wingspan, fly);
    }

    /**
     * reads input and calls constructor pet to make a pet object
     *
     * @param owner
     * @param type
     * @param name
     * @param breed
     * @param age
     * @param colour
     * @param gender
     * @return pet object
     */
    public static Pet createPet(int owner, String type, String name, String breed, int age, String colour, String gender)
    {
        return new Pet(owner, type, name, breed, age, colour, gender);
    }

    /**
     * reads input and calls constructor pet to make a pet object
     *
     * @param owner
     * @param petId
     * @param type
     * @param name
     * @param breed
     * @param age
     * @param colour
     * @param gender
     * @return pet object
     */
    public static Pet createPet(int owner, int petId, String type, String name, String breed, int age, String colour, String gender)
    {
        return new Pet(owner, petId, type, name, breed, age, colour, gender);
    }

    /**
     * displays all pets in the list
     *
     * @param pets
     */
    public static void displayAllPets(List<Pet> pets)
    {
        for (Pet p : pets)
        {
            p.displayPet();
        }
    }

    /**
     * displays this pet class
     */
    public void displayPet()
    {
        System.out.println("\n(" + getClass().getSimpleName() + ") PetID: " + this.getPetID() + ", OwnerID: " + this.getOwnerID() + ", Type: " + this.getType() + ", Name: " + this.getName() + ", Age: " + this.getAge() + ", Breed: " + this.getBreed() + ", Colour: " + this.getColour() + ", Gender: " + this.getGender() + ", DateReg: " + this.getRegDate());
    }

    private void findGender(String g)
    {
        if (g.equalsIgnoreCase("male"))
        {
            this.gender = Gender.MALE;
        }
        else if (g.equalsIgnoreCase("female"))
        {
            this.gender = Gender.FEMALE;
        }
        else
        {
            this.gender = Gender.UNKNOWN;
        }
    }

    @Override
    public int hashCode()
    {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.name);
        hash = 37 * hash + Objects.hashCode(this.regDate);
        hash = 37 * hash + this.petID;
        hash = 37 * hash + this.ownerID;
        return hash;
    }

    @Override
    public boolean equals(Object obj)
    {
        if (this == obj)
        {
            return true;
        }
        if (obj == null)
        {
            return false;
        }
        if (getClass() != obj.getClass())
        {
            return false;
        }
        final Pet other = (Pet) obj;
        if (this.age != other.age)
        {
            return false;
        }
        if (!Objects.equals(this.type, other.type))
        {
            return false;
        }
        if (!Objects.equals(this.name, other.name))
        {
            return false;
        }
        if (!Objects.equals(this.breed, other.breed))
        {
            return false;
        }
        if (!Objects.equals(this.colour, other.colour))
        {
            return false;
        }
        if (this.gender != other.gender)
        {
            return false;
        }
        return true;
    }

    @Override
    public String toString()
    {
        return getClass().getSimpleName() + "{" + "type=" + type + ", name=" + name + ", breed=" + breed + ", age=" + age + ", colour=" + colour + ", gender=" + gender + ", regDate=" + regDate + '}';
    }

}
