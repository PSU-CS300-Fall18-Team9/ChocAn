package chocan;

import java.util.*;

public class Provider  extends Data
{
    protected int consult; // number of consultations with members
    protected boolean privilege;  // the value is true if provider has manager privileges
    protected ArrayList <String> memberNames; // stores the name of member for each service provided
    protected ArrayList<Integer> memberId;
    private int totalFees;
    public Provider()
    {
        super();
        consult = 0;
        memberNames = null;
        memberId = null;
        privilege = false;
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
     * @param num: the number of consultations the provider provided to members
     */
    public Provider(String fName, String lName, String address, String city, String state, int zip, int id, int num, boolean isManager)
    {
        super(fName, lName, address, city, state, zip, id);
        consult = num;
        memberNames = null;
        memberId = null;
        privilege = isManager;
        totalFees = 0;
    }



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



    /** Represent provider's info as a string.  Able to dislay on screen or write to a file
     *
     * @return data: Returns the super class' fields and the consult field as strings.
     */
    public String toString()
    {
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
        String[] data = new String[9];

//        String data = null;
        data[0] = this.lastName;
        data[1] = this.firstName;
        data[2] = Integer.toString(this.id);
        data[3] = this.address;
        data[4] = this.city;
        data[5] = this.state;
        data[6] = Integer.toString(this.zip);
        data[7] = Integer.toString(this.consult);
        data[8] = Integer.toString(this.totalFees);
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

      if (isEmpty() == false)
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
        }
        return servReport;
    }
}
