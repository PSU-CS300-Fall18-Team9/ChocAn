package chocan;
import java.util.*;
// commit test 11/10/18
//public class Data
public abstract class Data
{
    protected boolean debug = true;

    protected Set<Data> services;
    //public String name;
    //public int number;
    protected String name;
    protected int number;
    protected String address;
    protected String city;
    protected String state;
    protected int zip;
    protected int id;

    //default constructor
    public Data()
    {
      /*  if(debug == true)
        {
            System.out.println("Data constructor");
        }*/

        services = null;
        name = null;
        number = 0;
        address = null;
        city = null;
        state = null;
        zip = 0;
        id = 0;
    }

    /**
     *
     * @param id
     * @return
     */
    //public abstract int checkID(int id);


    /**
     *
     */
    public abstract void buildReport(String fileName);


    /**
     *
     */
    public abstract boolean addService(Service aService);


    /*
    public String toString()
    {
        if(debug == true)
        {
            System.out.println("Data toString");
        }

        String data = null;
        data = "Name: " + this.name + "\nNumber: " + number;

        return data;
    }*/
}
