package chocan;
import java.util.*;

public class Member extends Data
{
    public Member()
    {
        super();
    }


    /** Writes member's information, services attended, and the name of providers of each service to a file
     *
     * @precondition:  If a file does not exist, this method creates a new file and writes to the file.
     * @postcondition:  A new file exist or a new member's info is appended to an existing file
     */
    public void buildReport(String fileName) {

    }


    /**  Adds one service to a list of services that a member receives
     *
     * @param aService
     * @precondition:   if the list of services is empty, the new service to add should be the first item on the
     *                  list, otherwise new services are appended to the list
     * @postcondition:  One more item is appended to a list of services
     * @return true: new service successfully appended to the list of services
     * @return false: new service did not append to the list
     */
    public boolean addService(Service aService) {
        return false;
    }



    public String toString()
    {
        if(debug == true)
        {
            System.out.println("Data toString");
        }

        String data = null;
        data = "Name: " + this.name + "\nNumber: " + number;

        return data;
    }

}
