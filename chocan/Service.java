package chocan;
import java.util.*;

public class Service 
{


    boolean debug = true;

    public Service()
    {
        if(debug == true)
        {
            System.out.println("Service default constructor");
        }
    }

    public String toString()
    {
        if(debug == true)
        {
            System.out.println("Service toString");
        }

        String data = null;

        return data;
    }
}
