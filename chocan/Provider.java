package chocan;
import java.util.*;

public class Provider  extends Data
{
    boolean debug = true;

    public Provider()
    {
        super();

        if(debug == true)
        {
            System.out.println("Provider Constructor ");
        }
    }
    public Provider(String fName, String lName, int num, String address, String city, String state, int zip/*, int id*/)
    {
        super();

        if(debug == true)
        {
            System.out.println("Provider constructor");
        }
    }
}
