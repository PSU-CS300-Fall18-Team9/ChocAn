package chocan;
import java.util.*;
// testing push 11/10/2018
//public class Data
public abstract class Data
{
    boolean debug = true;

    protected Set<Data> services;
    public String name;
    public int number;
/*    protected String name;
    protected int number;
    protected String address;
    protected String city;
    protected String state;
    protected int zip;
    protected int id;
*/
    public Data()
    {
        if(debug == true)
        {
            System.out.println("Data constructor");
        }

//        services = null;
        name = null;
        number = 0;
/*        address = null;
        city = null;
        state = null;
        zip = 0;
        id = 0;
*/    }

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
