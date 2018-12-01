package chocan;

import java.util.*;
import java.io.*;

public class Provider extends Data
{
    private int consult; // number of consultations with members
    protected boolean privilege;  // the value is true if provider has manager privileges
    protected ArrayList <String> memberNames; // stores the name of member for each service provided
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

    public Provider(String lName, String fName, String address, String city, String state, int zip, int id, boolean isManager)
    {
        super(lName, fName, address, city, state, zip, id);
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

    public void displayAll() {
        System.out.println(finalReport());
    }

    public String finalReport()
    {
        StringBuilder reportFormat = new StringBuilder();
        String [] records;
        int size;

        records = serviceReport();
        // append provider's info
        reportFormat.append(toString() + "--- Service provided ---\n");
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
            reportFormat.append("No services on record.\n\n");
        }
        // append fee total and number of consultants
        reportFormat.append(serviceTotal());
        return reportFormat.toString();
    }

    private boolean isEmpty() { return (services == null); }

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

    public String serviceTotal()
    {
        String providerService = "Number of consultations with member: " + this.consult + "\n"
                + "Total fee to be paid: " + this.totalFees;

        return providerService;
    }

    public String[] strArray()
    {
        String[] data = new String[9];

        data[0] = this.lastName;
        data[1] = this.firstName;
        data[2] = Integer.toString(this.id);
        data[3] = this.address;
        data[4] = this.city;
        data[5] = this.state;
        data[6] = Integer.toString(this.zip);
        data[7] = Boolean.toString(this.privilege);
        return data;
    }

    public String toString()
    {
        String person;
        String location;

        person = "Provider Name: " + this.firstName + " " + this.lastName + "\nProvider number: " + this.id;
        location = "Provider street address: " + this.address + "\nProvider city: " + this.city + "\nProvider state: " + this.state
                    + "\nProvider zip code: " + this.zip + "\n\n";
        return person + "\n" + location;
    }
}