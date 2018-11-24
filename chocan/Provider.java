package chocan;
//import javafx.scene.chart.PieChart; // What is this? -Jaime

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.FileOutputStream;
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



    /**  Constructor:  Initialize provider's info from user's input
     *
     * @param fName: provider's first name
     * @param lName: provider's last name
     * @param address: provider's street address
     * @param city
     * @param state
     * @param zip
     * @param id: provider's identification number
     * @param num: the number of consultations the provider provided to a member
     */
    public Provider(String fName, String lName, String address, String city, String state, int zip, int id, int num)
    {
        super(fName, lName, address, city, state, zip, id);
        consult = num;

    /*    boolean debug = false;

        if(debug == true)
        {
            System.out.println("Provider constructor");
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
     * @param fileName: holds the name of a text file
     * @param append:   If append holds a true value and the text file already exist, this method will append to the
     *                  exiting file.
     *                  If append is false and the text file already exist, this method will overwrite the existing file.
     * @precondition:  If a file does not exist, this method creates a new file and writes to the file regardless of
     *                 the value of append.
     * @postcondition:  A new file exist or a new member's info is appended to an existing file
     */
    public boolean buildReport(String fileName, boolean append)
    {
        // I MAY NEED TO ADD A DATA OBJECT PARAMETER TO THIS METHOD, SO I CAN ACCESS MEMBER'S PUBLIC METHODS
        // EX: public boolean buildReport(String fileName, boolean append, Data person)
        boolean isOpen = true;

        // open file
        try
        {
            toFile = new PrintWriter(new FileOutputStream(fileName, append));
        }
        catch (FileNotFoundException e)
        {
            isOpen = false;
        }
        if (isOpen)
        {
            // write provider to file
            toFile.println(this);  // it will call the string method from the Data class
            // write all services to file
            for(Service s: services)
            {
                // NEED TO WRITE MEMBER'S FULL NAME (FIRST AND LAST): ex:  member.getFName() member.getLName
                // NEED TO WRITE MEMBER'S ID NUMBER ex: member.getID()
                toFile.println(s);
                // NEED TO CALCULATE THE TOTAL FEES OF ALL SERVICES IN THE LIST
                // NEED TO WRITE TOTAL SERVICE FEES FOR THE WEEK
            }
            toFile.println("Total Number of consultation with members: " + consult);
            // close file
            toFile.close();
        }
        return isOpen;

    }



    /** Inserts one service to a list of services. Does not allow duplicates, and appends new services to an existing
     * list of services
     * @precondition:
     *              Case 1: The list is empty, and the service is the first item on the list
     *              Case 2: There are services in the list, and inserting a new service
     * @postcondition:  If the list is empty, then a new list is created and the new service becomes the first item on
     *                  the list.  If the list is not empty, the new service is added at the end of a list
     *
     * @param toAdd: An object containing service information
     * @return true:  Inserting new service is successful
     * @return false: Inserting new service is failed, toAdd may be null
     */
    public boolean addService(Service toAdd)
    {
        if (toAdd != null) {
            // if services is null, create a new list of services
            if (services == null) {
                services = new HashSet<Service>();
            }
            services.add(toAdd);  // insert toAdd to list
            ++ consult; // increment consultation with a member
            return true;
        }
        // if toAdd object is null return false
        return false;
    }


    /** Returns the first name of a provider.  Use this method to write provider's name in member reports
     * @return  the firstName field of this class
     */
    public String getFirstName()
    {
        return this.firstName;
    }


     /** Returns the last name of a provider.  Use this method to write provider's name in member reports
      * @return  the lastName field of this class
     */
    public String getLastName() { return this.lastName; }



    /**  Compares the parameter with the service code stored in the service class
     * @precondition:
     *              Case 1: List is empty
     *              Case 2: List is not empty, service code not found
     *              Case 3: List is not empty, service code found
     * @postcondition:
     *              This method does not search for service code if the list is empty
     *              This method returns true if the service code in Service class matches the parameter.
     *              This method searches all items in the list until it finds a match or reaches the end of the list
     * @param serviceCode: integer value
     * @return  true: Service class's service code matches the parameter
     * @return  false: If the list is not empty, then there are no matching service code. Otherwise the list is empty
     */
    public boolean checkServiceCode(int serviceCode)
    {
        boolean aMatch = false;

        for (Service s: services) {
   //         aMatch = s.compareCode(serviceCode); // NEED A METHOD IN SERVICE CLASS THAT COMPARES SERVICE CODE AND
                                                // RETURNS TRUE IF IT MATCHES
            if (aMatch == true) {
                return aMatch;
            }
        }
        return aMatch;
    }

    public String toString()
    {
        boolean debug = !true;

        if(debug == true)
        {
            System.out.println("Provider toString");
        }

//        String data = null;

        String data = super.toString();

        return data;
    }

    // Displays the provider's information and all the services the provider provided
    public void displayAll()
    {
        // display provider
        System.out.println(this);
        // display all services
        for(Service s: services)
        {
            System.out.println(s);
        }
    }
}
