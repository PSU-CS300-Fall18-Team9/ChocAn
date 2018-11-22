package chocan;
import java.util.*;

public class Provider  extends Data
{
    protected int consult; // number of consultations with members
    public Provider()
    {
//        boolean debug = true;

        super();
        consult = 0;

    /*    if(debug == true)
        {
            System.out.println("Provider default constructor ");
        }*/

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
     * @param num
     */
    public Provider(String fName, String lName, String address, String city, String state, int zip, int id, int num)
    {
        super(fName, lName, address, city, state, zip, id);
        consult = num;

    /*    boolean debug = false;

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
//        this.number = num;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zip = zip;
//        this.id = id;
*/
    }


    /** Writes provider's information, all the services the provider provided, the total number of consultations,
     * and the total service fees of the week
     *
     * @precondition:  If a file does not exist, this method creates a new file and writes to the file.
     * @postcondition:  A new file exist or a new member's info is appended to an existing file
     */
    public void buildReport(String fileName)
    {

    }


    /**
     *
     * @param aService
     * @return
     */
    public boolean addService(Service aService)
    {
        return false;
    }


    /**
     *
     * @return
     */
    public String getName()
    {
        return firstName;
    }


    /**
     *
     * @param serviceCode
     * @return
     */
    public boolean checkServiceCode(int serviceCode)
    {
        return false;
    }


    /**
     * @precondition:
     * @postcondition:
     */
    public void displayPerson()
    {

    }


    /**
     * @precondition:
     * @postcondition:
     */
    public void displayAll()
    {

    }
}
