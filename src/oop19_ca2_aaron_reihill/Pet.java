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
    private Gender gender = Gender.UNKOWN;
    private Date regDate;
    private static int index = 0;
    private int petID = 0;
    private int ownerID;

    public Pet()
    {
    }

    public Pet(String type, String breed, int age, String colour)
    {
        this.type = type;
        this.breed = breed;
        this.age = age;
        this.colour = colour;
        this.regDate = new Date();
        this.petID = Pet.index++;
    }
    public Pet(String type, String breed, int age, String colour,String regDate)
    {
        this.type = type;
        this.breed = breed;
        this.age = age;
        this.colour = colour;
        this.setRegDate(regDate);
        this.petID = Pet.index++;
    }
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

    public Pet(int owner, String type, String breed, int age, String colour)
    {
        this.ownerID = owner;
        this.type = type;
        this.breed = breed;
        this.age = age;
        this.colour = colour;
        this.regDate = new Date();
        this.petID = Pet.index++;
    }

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
    public Pet(int owner, int petId, String type, String name, String breed, int age, String colour, String gender,String regDate)
    {
        this.ownerID = owner;
        this.type = type;
        this.name = name;
        this.breed = breed;
        this.age = age;
        this.colour = colour;
        findGender(gender);
        this.setRegDate(regDate);
        this.petID = petId;
    }
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

    public String getType()
    {
        return type;
    }

    public String getName()
    {
        return name;
    }

    public String getBreed()
    {
        return breed;
    }

    public Date getRegDate()
    {
        return regDate;
    }

    public int getAge()
    {
        return age;
    }

    public static int getIndex()
    {
        return index;
    }

    public String getColour()
    {
        return colour;
    }

    public Gender getGender()
    {
        return gender;
    }

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

    public int getPetID()
    {
        return petID;
    }

    public int getOwnerID()
    {
        return ownerID;
    }

    public void setType(String type)
    {
        this.type = type;
    }
    public void setName(String name)
    {
        this.name = name;
    }

    public void setBreed(String breed)
    {
        this.breed = breed;
    }

    public void setAge(int age)
    {
        try{
        this.age = age;
        }
        catch(InputMismatchException e)
        {
            System.out.println("Error Age Can Not Be String");
        }
    }

    public void setColour(String colour)
    {
        this.colour = colour;
    }

    public void setGender(Gender gender)
    {
        this.gender = gender;
    }

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
        else if (gender.equalsIgnoreCase("UNKOWN")||gender.equalsIgnoreCase("Other"))
        {
            this.gender = Gender.UNKOWN;
            changed = true;
        }
        return changed;
    }

    public void setRegDate(Date regDate)
    {
        this.regDate = regDate;
    }

    public void setRegDate(String regDate)
    {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        Date date = null;
        try
        {
            date = dateFormat.parse(regDate);
        }
        catch (ParseException e)
        {
            System.out.println("Date In Wrong Format");
        }
        this.regDate = date;
    }

    public static void setIndex(int index)
    {
        try{
        Pet.index = index;
        }
        catch(InputMismatchException e)
        {
            System.out.println("Error Index Can Not Be String");
        }
    }
        

    public void setPetID(int petID)
    {
        try{
        this.petID = petID;
                }
        catch(InputMismatchException e)
        {
            System.out.println("Error Pet Id Can Not Be String");
        }
    }

    public void setOwnerID(int ownerID)
    {
        try{
        this.ownerID = ownerID;
                       }
        catch(InputMismatchException e)
        {
            System.out.println("Error Pet Id Can Not Be String");
        }
    }

    public static Pet createPet(int owner, int petId, String type, String name, String breed, int age, String colour, String gender, String water)
    {
        return new Fish(owner, petId, type, name, breed, age, colour, gender, water);
    }

    public static Pet createPet(int owner, String type, String name, String breed, int age, String colour, String gender, String water)
    {
        return new Fish(owner, type, name, breed, age, colour, gender, water);
    }

    public static Pet createPet(int owner, String type, String name, String breed, int age, String colour, String gender, String regDate, String water)
    {
        return new Fish(owner, type, name, breed, age, colour, gender, regDate, water);
    }

    public static Pet createPet(int owner, String type, String name, String breed, int age, String colour, String gender, String regDate, boolean neutered)
    {
        return new Mammal(owner, type, name, breed, age, colour, gender, regDate, neutered);
    }

    public static Pet createPet(int owner, String type, String name, String breed, int age, String colour, String gender, boolean neutered)
    {
        return new Mammal(owner, type, name, breed, age, colour, gender, neutered);
    }

    public static Pet createPet(int owner, int petId, String type, String name, String breed, int age, String colour, String gender, boolean neutered)
    {
        return new Mammal(owner, petId, type, name, breed, age, colour, gender, neutered);
    }

    public static Pet createPet(int owner, String type, String name, String breed, int age, String colour, String gender, String regDate, int wingspan, boolean fly)
    {
        return new Bird(owner, type, name, breed, age, colour, gender, regDate, wingspan, fly);
    }

    public static Pet createPet(int owner, String type, String name, String breed, int age, String colour, String gender, int wingspan, boolean fly)
    {
        return new Bird(owner, type, name, breed, age, colour, gender, wingspan, fly);
    }

    public static Pet createPet(int owner, int petId, String type, String name, String breed, int age, String colour, String gender, int wingspan, boolean fly)
    {
        return new Bird(owner, petId, type, name, breed, age, colour, gender, wingspan, fly);
    }

    public static Pet createPet(int owner, String type, String name, String breed, int age, String colour, String gender)
    {
        return new Pet(owner, type, name, breed, age, colour, gender);
    }

    public static Pet createPet(int owner, int petId, String type, String name, String breed, int age, String colour, String gender)
    {
        return new Pet(owner, petId, type, name, breed, age, colour, gender);
    }
    public static void displayAllPets(List<Pet> pets)
    {
        for (Pet p : pets)
        {
            p.displayPet();
        }
    }

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
            this.gender = Gender.UNKOWN;
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
