package chocan;
import java.util.*;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.FileOutputStream;

public class Member extends Data
{
    private ArrayList<String> providers; //Holds Providers of services

    /*--------------------------------
     * Calls Default Constructor
     --------------------------------*/
    public Member()
    {
        super();
        providers = null;
    }

    /*---------------------------------------
     * Constructor : Initialize Member Info
     * @param fName;
     * @param lName;
     * @param address;
     * @param city;
     * @param state;
     * @param zip;
     * @param id;
      -------------------------------------*/
    public Member(String fName, String lName, String address, String city, String state, int id, int zip)
    {
        super(fName, lName, address, city, state, zip, id);
        providers = null;
    }

    /*--------------------
     * Returns Member ID
    --------------------*/
    //May not need this
    public int getID()
    {
        return this.id;
    }

    /*---------------------------------------------------------------------------
     * Adds one service to a list of services that a member receives
     *
     * @param aService;
     * @pre-condition:   if the list of services is empty, the new service to add
     *                  should be the first item on the list, otherwise new
     *                  services are appended to the list
     * @post-condition:  One more item is appended to a list of services
     * @return true: new service successfully appended to the list of services
     * @return false: new service did not append to the list
     ----------------------------------------------------------------------------*/
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



    /*-----------------------------------
     * Displays a member's information
    ----------------------------------- */
    public void displayPerson()
    {
        System.out.println(this);
    }


    /*----------------------------------------------------------------------------
     * Display's a member's information and all services provided to the member
    ----------------------------------------------------------------------------*/
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

    //build member report
    public void buildReport()
    {
        //StringBuilder dataFile = new StringBuilder();
        //dataFile.append("./reports/member/" + this.lastName + this.firstName + ".txt");
        String fileName = "./reports/member/" + this.lastName + this.firstName + ".txt";
        boolean isOpen = true;
        PrintWriter toFile = null;
        try {
            toFile = new PrintWriter(new FileOutputStream(fileName));
        }
        catch(FileNotFoundException e){
            isOpen = false;
        }
        StringBuilder nMember = new StringBuilder();    //string for member info
        StringBuilder nServices = new StringBuilder();  //string for info for all services

        //adds all member data to nMember
        nMember.append("Member Name: " + this.firstName + ", " + this.firstName + "\n");
        nMember.append("Member ID: " + this.id + "\n");
        nMember.append("Member Address: " + this.address + "\n");
        nMember.append("Member City: " + this.city + "\n");
        nMember.append("Member State: " + this.state + "\n");
        nMember.append("Member Zip: " + this.id + "\n");

        //iterates through all services, adds all data to nServices
        for (int i = 0; i < services.size(); i++){
            nServices.append("Service Date: " + services.get(i).month + " / " + services.get(i).day + " / " + services.get(i).year + "\n");
            nServices.append("Provider Name: " + providers.get(i) + "\n");
            nServices.append("Service Name: " + services.get(i).serviceName + "\n");
        }

        //open datafile, write all data from nMember, then nServices to file
        if(isOpen) {
            toFile.close();
        }
        /*
        try {
            File outFile = new File(dataFile);
            PrintWriter pw = new PrintWriter(outFile);
            pw.write(nMember);
            pw.write(nServices);
            pw.close();
        }
        catch(FileNotFoundException e1){
            System.out.println("File Not Found\n");
        }
        */
    }
    public String[] strArray()
    {
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
        String person;
        String location;

        person = "Member Name: " + this.firstName + " " + this.lastName + "\nMember number: " + this.id;
        location = "Member street address: " + this.address + "\nMember city: " + this.city + "\nMember state: " + this.state
                    + "\nMember zip code: " + this.zip;
        return person + "\n" + location + "\n";
    }
}
