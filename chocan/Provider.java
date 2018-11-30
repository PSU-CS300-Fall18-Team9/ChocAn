package chocan;

import java.util.*;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.FileOutputStream;

public class Provider extends Data
{
    private int consult; // number of consultations with members
    private boolean privilege;  // the value is true if provider has manager privileges
    private ArrayList <String> memberNames; // stores the name of member for each service provided
    private ArrayList<Integer> memberId;
    private PrintWriter toFile;
    private int totalFees;



    public Provider()
    {
        super();
        consult = 0;
        memberNames = null;
        memberId = null;
        privilege = false;
        toFile = null;
        totalFees = 0;
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
     */
    public Provider(String fName, String lName, String address, String city, String state, int zip, int id, boolean isManager)
    {
        super(fName, lName, address, city, state, zip, id);
        this.consult = 0;
        this.memberNames = null;
        this.memberId = null;
        this.totalFees = 0;
        try
        {
            this.privilege = isManager;
        }
        catch (InputMismatchException e)
        {
            System.out.println("This provider will not have manager privileges.");
            this.privilege = false;
        }
    }



    /** Inserts one service to a list of services. Appends new services to an existing list of services
     *
     * @precondition:
     *              Case 1: The list is empty, and the service is the first item on the list
     *              Case 2: There are services in the list, and inserting a new service
     * @postcondition:  If the list is empty, then a new list is created and the new service becomes the first item on
     *                  the list.  If the list is not empty, the new service is added at the end of a list
     * @param name: holds the name of a member
     * @param id: holds the member's ID number
     * @param toAdd: An object containing service information
     * @return true:  Inserting new service is successful
     * @return false: Inserting new service failed, toAdd may be null
     */
    public boolean addService(Service toAdd, String name, int id)
    {
        if (toAdd != null) {
            // if services is null, create a new list of services
            if (isEmpty()) {
                services = new ArrayList<>();
                memberNames = new ArrayList<>();
                memberId = new ArrayList<>();
            }
            services.add(toAdd);  // insert toAdd to list
            memberNames.add(name);
            memberId.add(id);
            ++ consult; // increment consultation with a member
            totalFees += toAdd.fee;
            return true;
        }
        return false;
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
     * @return true: writing to file is successful, otherwise returns false
     */
    public boolean buildReport(String fileName, boolean append)
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
            toFile.println(finalReport());  // write the provider report to file
            // close file
            toFile.close();
        }
        return isOpen;
    }



    // Returns provider's info as a string.  Able to display on screen or write to a file
    public String toString()
    {
        String person;
        String location;

        person = "Provider Name: " + this.firstName + " " + this.lastName + "\nProvider number: " + this.id;
        location = "Provider street address: " + this.address + "\nProvider city: " + this.city + "\nProvider state: " + this.state
                    + "\nProvider zip code: " + this.zip;
        return person + "\n" + location;
    }



    // Returns provider's service totals and consultations as a string.
    public String serviceTotal()
    {
        String providerService = "Number of consultations with member: " + this.consult + "\n"
                + "Total fee to be paid: " + this.totalFees;

        return providerService;
    }



    // Displays the provider's information, the member's that received service, and all the services the provider provided
    public void displayAll() {
        System.out.println(finalReport());
    }



    /**  Checks if the list of services is empty
     *
     * @return true:  services is null, and the list is empty
     * @return false: There's at least one item in the list of services
     */
    private boolean isEmpty() { return (services == null); }



    /** Returns the provider report to a string in the following format:
     *          Provider name:
     *          Provider number:
     *          Provider street address:
     *          Provider city:
     *          Provider state:
     *          Provider zip code:
     *
     *          --- Services provided ---
     *          Date of service:
     *          Current data and time:
     *          Member name:
     *          Service code:
     *          Fee to be paid:
     *
     * @return reportFormat:  The provider report stored in a string object
     */
    public String finalReport()
    {
        StringBuilder reportFormat = new StringBuilder();
        String [] records;
        int size;

        records = serviceReport();
        // append provider's info
        reportFormat.append(toString() + "\n\n" + "--- Service provided ---\n");
        // if services is not null, append all services
        if (records != null)
        {
            size = records.length;
            for (int i = 0; i < size; ++i)
            {
                reportFormat.append(records[i] + "\n");
            }
        }
        else
        {
            reportFormat.append("No services on record.\n");
        }
        // append fee total and number of consultants
        reportFormat.append(serviceTotal() + "\n\n");
        return reportFormat.toString();
    }



    /**  Format member and service data to the provider report.
     * Format Example:
     *          Date of service:
     *          Current data and time:
     *          Member name:
     *          Service code:
     *          Fee to be paid:
     * @precondition: if the provider does not provide any services, this method will return a null string
     * @postcondition: creates the service portion of the provider report if the list of services in not empty
     * @return servReport: An array of string objects
     */
    private String[] serviceReport()
    {
        int arraySize;
        int count = 0; // keep track of the number of services and members in a list
        int serviceCategories = 4; // The number of fields in services that will be in the report
        String [] servReport = null;

      if (!isEmpty())
       {
            arraySize = (services.size() * serviceCategories) + memberNames.size() + memberId.size();
            servReport = new String[arraySize];
            // load all service and member information that belongs to a provider report
            for (int i = 0; i < arraySize; ++i)
            {
                // date of service need update: call services.get(count).dateOfService();
                servReport[i++] = "Date of service: " + (services.get(count).dateOfService());
                // Need to change to: services.get(count).dataTime()
                servReport[i++] = "Current date and time: " + (services.get(count).dateTime());
                servReport[i++] = "Member name: " + memberNames.get(count);
                servReport[i++] = "Member number: " + memberId.get(count);
                servReport[i++] = "Service code: " + Integer.toString(services.get(count).serviceCode);
                servReport[i] = "Fee to be paid: " + services.get(count).fee + "\n";
                ++count;  // move to the next service and member
            }
        }
        return servReport;
    }
}
