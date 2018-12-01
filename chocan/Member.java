package chocan;
import java.util.*;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.FileOutputStream;

public class Member extends Data
{
    private ArrayList<String> providers; //Holds Providers of services
    private PrintWriter toFile;
    protected Boolean current;

    public Member()
    {
        super();
        current = false;
        providers = null;
    }

    public Member(String fName, String lName, String address, String city, String state, int id, int zip, boolean current)
    {
        super(fName, lName, address, city, state, zip, id);
        providers = null;
        this.current = current;
    }

    public int getID()
    {
        return this.id;
    }

    public boolean addService(Service aService, String prov_name, int id)
    {
        if (aService != null) {  //Check if aService is null
            if (services == null) { //Check if services list exists
                services = new ArrayList<>();
            }
            if (providers == null) { //Check if providers exists
                providers = new ArrayList<>();
            }
            services.add(aService); //Adding service
            providers.add(prov_name); //Adding provider name
            return true;
        }
        return false; //Error
    }

    public void displayPerson()
    {
        System.out.println(this);
    }

    public void displayAll() {
        System.out.println(this);
        if (services != null) {
            System.out.println("Services:\n\n");
            for (int i = 0; i < services.size(); i++) {
                System.out.println("Provider: " + providers.get(i) + "\n");
                System.out.println(services.get(i));
            }
        } else {
            System.out.println("No services on record\n");
        }
    }

    public boolean buildReport(String fileName)
    {
        boolean isOpen = true;

        try
        {
            toFile = new PrintWriter(fileName);
        }
        catch (FileNotFoundException e)
        {
            isOpen = false;
        }
        if (isOpen)
        {
            toFile.println(finalReport());  // write the provider report to file
            toFile.close();
        }
        return isOpen;
    }

    public String finalReport()
    {
        StringBuilder reportFormat = new StringBuilder();
        String [] records;
        int size;

        records = serviceReport();
        reportFormat.append(toString() + "--- Service provided ---\n");

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
        return reportFormat.toString();
    }

    private String[] serviceReport()
    {
        int arraySize;
        int count = 0; // keep track of the number of services and members in a list
        int serviceCategories = 2; // The number of fields in services that will be in the report
        String [] servReport = null;

      if (services != null)
       {
            arraySize = (services.size() * serviceCategories) + providers.size();
            servReport = new String[arraySize];
            // load all service and member information that belongs to a provider report
            for (int i = 0; i < arraySize; ++i)
            {
                servReport[i++] = "Date of service: " + (services.get(count).dateOfService());
                servReport[i++] = "Provider name: " + providers.get(count);
                servReport[i] = "Service code: " + Integer.toString(services.get(count).serviceCode);
                ++count;  // move to the next service and member
            }
        }
        return servReport;
    }

    public String[] strArray()
    {
        String[] data = new String[8];

        data[0] = this.lastName;
        data[1] = this.firstName;
        data[2] = Integer.toString(this.id);
        data[3] = this.address;
        data[4] = this.city;
        data[5] = this.state;
        data[6] = Integer.toString(this.zip);
        data[7] = Boolean.toString(this.current);
        return data;
    }
    public String toString()
    {
        String person;
        String location;

        person = "Member Name: " + this.firstName + " " + this.lastName + "\nMember number: " + this.id;
        location = "Member street address: " + this.address + "\nMember city: " + this.city + "\nMember state: " + this.state
                    + "\nMember zip code: " + this.zip;
        return person + "\n" + location + "\n\n";
    }
}