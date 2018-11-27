package chocan;
import java.util.*;

public class Member extends Data
{
    public Member()
    {
        super();
       // System.out.println("Member default constructor ");
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
    public Member(String fName, String lName, String address, String city, String state, int zip, int id)
    {
        super(fName, lName, address, city, state, zip, id);
    }


    /** Writes member's information, services attended, and the name of providers of each service to a file
     *
     * @precondition:  If a file does not exist, this method creates a new file and writes to the file.
     * @postcondition:  A new file exist or a new member's info is appended to an existing file
     */
    /*public void buildReport(String fileName)
    {

    }*/
  /*  public boolean buildReport(String fileName, boolean append) {
        return false;
    }*/


    /**  Adds one service to a list of services that a member receives
     *
     * @param aService
     * @precondition:   if the list of services is empty, the new service to add should be the first item on the
     *                  list, otherwise new services are appended to the list
     * @postcondition:  One more item is appended to a list of services
     * @return true: new service successfully appended to the list of services
     * @return false: new service did not append to the list
     */
    public boolean addService(Service aService, String name, int id)
    {
        return false;
    }



    /** Displays a member's information
     * @precondition:
     * @postcondition:
     */
 /*   public void displayPerson()
    {
        DONT NEED THIS, CAN DELETE
    }*


    /** Display's a member's information and all services provided to the member
     * @precondition:
     * @postcondition:
     */
    public void displayAll()
    {

    }

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

        return data;
    }

}
