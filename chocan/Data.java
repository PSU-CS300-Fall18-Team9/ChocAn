package chocan;
import java.util.*;

public abstract class Data
{
    protected ArrayList<Service> services;

    protected String firstName;
    protected String lastName;
    protected String address;
    protected String city;
    protected String state;
    protected int zip;
    protected int id;

    public Data()
    {
        services = null;
        firstName = null;
        lastName = null;
        address = null;
        city = null;
        state = null;
        zip = 0;
        id = 0;
    }

    public Data(String lName, String fName, String address, String city, String state, int zip, int id)
    {
        services = null;
        this.lastName = lName;
        this.firstName = fName;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.id = id;
    }

    public boolean edit (String info, int number, int choice)
    {
        boolean flag = true;
        if (info != null)
        {
            switch (choice)
            {
                case 1:
                    lastName = info;
                    break;
                case 2:
                    firstName = info;
                    break;
                case 4:
                    address = info;
                    break;
                case 5:
                    city = info;
                    break;
                case 6:
                    state = info;
                    break;
                default:
                    flag = false;
                    break;
            }
        }
        if (number > 0) {

            switch (choice) {
                case 3:
                    id = number;
                    break;
                case 7:
                    zip = number;
                    break;
                default:
                    flag = false;
                    break;
            }
        }
       return flag;
    }

    public String getName()
    {
        StringBuilder data = new StringBuilder();

        data.append(firstName+ " " + lastName);

        return  data.toString();

    }
    // Outputs attributes to a screen or a file, depending on output stream
    public String toString()
    {
        String person;
        String location;

        person = "First Name: " + this.firstName + "\nLast Name: " + this.lastName + "\nID Number: " + this.id;
        location = "Address: " + this.address + "\nCity: " + this.city + "\nState: " + this.state + "\nZip: " + this.zip;
        return person + "\n" + location;

    }

    //Return an array of strings representation of the data, used for saveFile
    public abstract String[] strArray();

    // Allow subclasses to add services to their own list of services
    public abstract boolean addService(Service aService, String name, int id);

    // Allow subclasses to output their data, and all of their services
    public abstract void displayAll();
}
