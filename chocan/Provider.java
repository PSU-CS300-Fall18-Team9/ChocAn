package chocan;

//import java.io.FileNotFoundException;
//import java.io.PrintWriter;
//import java.io.FileOutputStream;
import java.util.*;

public class Provider  extends Data
{
    protected int consult; // number of consultations with members
    protected ArrayList <String> memberNames; // stores the name of member for each service provided
    protected ArrayList<Integer> memberId;
    public Provider()
    {
//        boolean debug = true;

        super();
        consult = 0;
        memberNames = null;
        memberId = null;

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
     * @param num: the number of consultations the provider provided to members
     */
    public Provider(String fName, String lName, String address, String city, String state, int zip, int id, int num)
    {
        super(fName, lName, address, city, state, zip, id);
        consult = num;
        memberNames = null;
        memberId = null;

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
     *
     * @param fileName: holds the name of a text file
     * @param append:   If append holds a true value and the text file already exist, this method will append to the
     *                  exiting file.
     *                  If append is false and the text file already exist, this method will overwrite the existing file.
     * @precondition:  If a file does not exist, this method creates a new file and writes to the file regardless of
     *                 the value of append.
     * @postcondition:  A new file exist or a new member's info is appended to an existing file
     */
 /*   public boolean buildReport(String fileName, boolean append)
    {
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
            if (isEmpty() == false)
            {
                for (Service s : services) {
                    // NEED TO WRITE MEMBER'S FULL NAME (FIRST AND LAST) for each service
                    // NEED TO WRITE MEMBER'S ID NUMBER for each service
                    toFile.println(s);
                }
                // NEED TO CALCULATE THE TOTAL FEES OF ALL SERVICES IN THE LIST
                // NEED TO WRITE TOTAL SERVICE FEES FOR THE WEEK
                toFile.println("Total Number of consultation with members: " + consult);
            }
            else
            {
                toFile.println("No services provided.");
            }
            // close file
            toFile.close();
        }
        return isOpen;

    }*/



    /** Inserts one service to a list of services. Does not allow duplicates, and appends new services to an existing
     * list of services
     *
     * @precondition:
     *              Case 1: The list is empty, and the service is the first item on the list
     *              Case 2: There are services in the list, and inserting a new service
     * @postcondition:  If the list is empty, then a new list is created and the new service becomes the first item on
     *                  the list.  If the list is not empty, the new service is added at the end of a list
     * @param name: holds the name of a member
     * @param id: holds the member's member number
     * @param toAdd: An object containing service information
     * @return true:  Inserting new service is successful
     * @return false: Inserting new service failed, toAdd may be null
     */
    public boolean addService(Service toAdd, String name, int id)
    {
        if (toAdd != null) {
            // if services is null, create a new list of services
            if (isEmpty() == true) {
 //               services = new LinkedList<>();
                services = new ArrayList<>();
                memberNames = new ArrayList<>();
                memberId = new ArrayList<>();
            }
            services.add(toAdd);  // insert toAdd to list
            memberNames.add(name);
            memberId.add(id);
            ++ consult; // increment consultation with a member
            return true;
        }
        // if toAdd object is null return false
        return false;
    }



    /** Returns the first name of a provider.  Use this method to write provider's name in member reports
     * @return  the firstName field of this class
     */
 /*   public String getFirstName() // WE MAY NOT NEED THIS METHOD
    {
        return this.firstName;
    }*/


     /** Returns the last name of a provider.  Use this method to write provider's name in member reports
      * @return  the lastName field of this class
     */
//    public String getLastName() { return this.lastName; }



    /**  Compares the parameter with the service code stored in the service class
     *
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



    /** Represent provider's info as a string.  Able to dislay on screen or write to a file
     *
     * @return data: Returns the super class' fields and the consult field as strings.
     */
    public String toString()
    {
        boolean debug = !true;

        if(debug == true)
        {
            System.out.println("Provider toString");
        }

//        String data = null;

        String data = super.toString() + "\n" + "Number of consultations with members: " + this.consult;

        return data;
    }



    // Displays the provider's information, the member's that recieved service, and all the services the provider provided
    public void displayAll() {
        int size;

        if (isEmpty() == false) {
            size = services.size();
            // display provider
            System.out.println(this);
            for (int i = 0; i < size; ++i) {
                // display all member's who recieve service from provider
                System.out.println("Member name: " + memberNames.get(i));
                // display each of the member's id
                System.out.println("Member number: " + memberId.get(i));
                // display all services
                System.out.println(services.get(i));
            }
        }
        else
        {
            System.out.println("No services on record");
        }
    }



    /**  Checks if the list of services is empty
     *
     * @return true:  sevices is null, and the list is empty
     * @return false: There's at least one item in the list of services
     */
    private boolean isEmpty() { return (services == null); }



    /** Formats all fields of Provider to a string array.
     *
     * @return data:  The string array containing provider's data
     */
    public String[] report()
    {
/*        boolean debug = true;
        if(debug == true)
        {
            System.out.println("Data report");
        }
*/
        String[] data = new String[8];

//        String data = null;
        data[0] = this.lastName;
        data[1] = this.firstName;
        data[2] = Integer.toString(this.id);
        data[3] = this.address;
        data[4] = this.city;
        data[5] = this.state;
        data[6] = Integer.toString(this.zip);
        data[7] = Integer.toString(this.consult);
        return data;
    }



    /**  Format member and service data to form a provider report.  The method can output to a screen or a file
     * Format Example:
     *          Date of service:
     *          Current data and time:
     *          Member name:
     *          Service code:
     *          Fee to be paid:
     * @precondition: if the provider does not provide any services, this method will return a null string
     * @postcondition: creates the service portion of the provider report if the list of services in not empty
     * @return servReport: A string array
     */
    public String[] serviceReport()
    {
        int arraySize = 0;
        int count = 0; // keep track of the number of services and members in a list
        int serviceCategories = 4; // The number of fields in services that will be in the report
        String [] servReport = null;

//----------  REMOVE COMMENT SYMBOLS BELOW WHEN SERVICE CLASS FIELDS ARE COMPLETE, AND DELETE THIS LINE, DO NOT DELETE CODE -------------
 /*      if (isEmpty() == false)
       {
            arraySize = (services.size() * serviceCategories) + memberNames.size() + memberId.size();
            servReport = new String[arraySize];
            // load all service and member information that belongs to a provider report
            for (int i = 0; i < arraySize; ++i)
            {
                servReport[i++] = "Date of service: " + Integer.toString(services.get(count).currentDate);
                servReport[i++] = "Current date and time: " + Integer.toString(services.get(count).currentDate) +
                                    " " + services.get(count).currentTime;
                servReport[i++] = "Member name: " + memberNames.get(count);
                servReport[i++] = "Member number: " + memberId.get(count);
                servReport[i++] = "Service code: " + Integer.toString(services.get(count).serviceCode);
                servReport[i] = "Fee to be paid: " + services.get(count).fee + "\n";
                ++count;  // move to the next service and member
            }
        }*/
        return servReport;
    }
}
