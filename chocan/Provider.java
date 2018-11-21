package chocan;
import java.util.*;

public class Provider extends Data
{
    //private int serviceCode;
    protected int consult; // the number of


    public Provider()
    {
        super();
       // serviceCode = 0;
        consult = 0;
    }



    /** Writes provider's information, all the services the provider provided, the total number of consultations,
     * and the total service fees of the week
     *
     * @precondition:  If a file does not exist, this method creates a new file and writes to the file.
     * @postcondition:  A new file exist or a new member's info is appended to an existing file
     */
    public void buildReport(String fileName) {

    }


    /**
     *
     * @param aService
     * @return
     */
    public boolean addService(Service aService) {
        return false;
    }


    /**
     *
     * @return
     */
    public String getName() {
        return name;
    }


    /**
     *
     * @param serviceCode
     * @return
     */
    public boolean checkServiceCode(int serviceCode) {
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
