package chocan;
import java.io.PrintWriter;
import java.util.*;

//public class Data
public abstract class Data
{
//    boolean debug = true;

 //   protected Set<Data> services;   This one may be adding the wrong class
    protected Set<Service> services;
    protected PrintWriter toFile;

/*    public String firstName;
    public String lastName;
    public int number;
 */

    protected String firstName;
    protected String lastName;
    protected int number;  // THIS NEEDS TO BE DELETED AFTER REMOVING number FROM THE PDirecteory Class
    protected String address;
    protected String city;
    protected String state;
    protected int zip;
    protected int id;

    // Default constructor
    public Data()
    {
/*        boolean debug = true;
        if(debug == true)   // May not need this for this class
        {
            System.out.println("Data default constructor");
        }
*/
        services = null;
        toFile = null;
        firstName = null;
        lastName = null;
        number = 0;  // not sure what number is for, but will remain 0 for now
        address = null;
        city = null;
        state = null;
        zip = 0;
        id = 0;
    }

    /**
     *
     * @param fName
     * @param lName
     * @param address
     * @param city
     * @param state
     * @param zip
     * @param id
     */
    public Data(String fName, String lName, String address, String city, String state, int zip, int id)
    {
/*        boolean debug = true;
        // May not print the right info for member or provider
        if(debug == true)
        {
            System.out.println("Data constructor");
            System.out.println("fName = " + fName);
            System.out.println("lName = " + lName);
//            System.out.println("num = " + num);
            System.out.println("address = " + address);
            System.out.println("city = " + city);
            System.out.println("state = " + state);
            System.out.println("zip = " + zip);
        }
*/
        services = null;
        toFile = null;
        this.firstName = fName;
        this.lastName = lName;
//        this.number = num;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.id = id;
    }



    // Outputs attributes to a screen or a file, depending on output stream

    public String[] report()
    {
/*        boolean debug = true;
        if(debug == true)
        {
            System.out.println("Data report");
        }
*/
        String[] data = new String[7];

//        String data = null;
        data[0] = this.lastName;
        data[1] = this.firstName;
        data[2] = Integer.toString(this.id);
        data[3] = this.address;
        data[4] = this.city;
        data[5] = this.state;
        data[6] = Integer.toString(this.zip);

        return data;
    }

    public String toString()
    {
        boolean debug = !true;

        if(debug == true)
        {
            System.out.println("Data toString");
        }

        String data = "\nFirst Name: " + this.firstName + "\nLast Name: " + this.lastName+ "\nAddress: " + this.address + "\nCity: " + this.city + "\nState: " + this.state + "\nZip: " + this.zip + "ID: " + this.id + "\n" ;

        return data;

/*        String info;
        String location;

        info = "First Name: " + this.firstName + "\nLast Name: " + this.lastName + "\nID Number: " + this.id;
        location = "Address: " + this.address + "\nCity: " + this.city + "\nState: " + this.state + "\nZip: " + this.zip;
        return info + "\n" + location;
*/
    }



    //  Allow subclasses to write and append their data to a file
    //public abstract void buildReport(String fileName);   // Old version,  can delete after testing
    public abstract boolean buildReport(String fileName, boolean append);


    // Allow subclasses to add services to their own list of services
    public abstract boolean addService(Service aService);

    // Allows members and providers to display their data only, excluding their services.
 //   public abstract void displayPerson();   // Don't need this method b/c of toString method

    // Allow subclasses to output their data, and all of their services
    public abstract void displayAll();
}
