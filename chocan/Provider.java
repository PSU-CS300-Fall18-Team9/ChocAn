package chocan;
import java.util.*;

public class Provider  extends Data
{

    public Provider()
    {
        boolean debug = true;

//        super();

        if(debug == true)
        {
            System.out.println("Provider Constructor ");
        }
    }

    public Provider(String fName, String lName, int num, String address, String city, String state, int zip)
    {
        boolean debug = false;

        if(debug == true)
        {
            System.out.println("Data constructor");
            System.out.println("fName = " + fName);
            System.out.println("lName = " + lName);
            System.out.println("num = " + num);
            System.out.println("address = " + address);
            System.out.println("city = " + city);
            System.out.println("state = " + state);
            System.out.println("zip = " + zip);
        }

//        services = null;
        this.firstName = fName;
        this.lastName = lName;
        this.number = num;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zip = zip;
//        this.id = id;
    }
}
