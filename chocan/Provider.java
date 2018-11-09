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
}
