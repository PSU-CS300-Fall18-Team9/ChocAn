package chocan;
import java.util.*;

//public class Data
public abstract class Data
{
    boolean debug = true;

/*    protected Set<Data> services;
    public String firstName;
    public String lastName;
    public int number;
*/    protected String firstName;
    protected String lastName;
    protected int number;
    protected String address;
    protected String city;
    protected String state;
    protected int zip;
//    protected int id;

    public Data()
    {
        if(debug == true)
        {
            System.out.println("Data default constructor");
        }

//        services = null;
        firstName = null;
        lastName = null;
        number = 0;
        address = null;
        city = null;
        state = null;
        zip = 0;
//        id = 0;
    }

    public Data(String fName, String lName, int num, String address, String city, String state, int zip/*, int id*/)
    {
        if(debug == true)
        {
            System.out.println("Data constructor");
            System.out.println("fName = " + fName);
            System.out.println("lName = " + lName);
            System.out.println("num = " + num);
            System.out.println("address = " + address);
            System.out.println("city = " + city);
            System.out.println("state = " + state);
            System.out.println("zip = " + zip);
        }

//        services = null;
        this.firstName = fName;
        this.lastName = lName;
        this.number = num;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zip = zip;
//        this.id = id;
    }

    public String[] report()
    {
        if(debug == true)
        {
            System.out.println("Data report");
        }

        String[] data = new String[7];

//        String data = null;
        data[0] = this.lastName;
        data[1] = this.firstName;
        data[2] = Integer.toString(this.number);
        data[3] = this.address;
        data[4] = this.city;
        data[5] = this.state;
        data[6] = Integer.toString(this.zip);

        return data;
    }
    public String toString()
    {
        if(debug == true)
        {
            System.out.println("Data toString");
        }

        String data = null;
        data = "\nFirst Name: " + this.firstName + "\nLast Name: " + this.lastName + "\nNumber: " + number + "\nAddress: " + this.address + "\nCity: " + this.city + "\nState: " + this.state + "\nZip: " + this.zip;

        return data;
    }
}
