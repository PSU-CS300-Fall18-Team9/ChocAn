/*
 * TODO:
 *
 */

package chocan;
import java.util.*;

public class PDirectory
{
    public Map<String, Provider> PDir = new HashMap<String, Provider>();

    public PDirectory()
    {
        boolean debug = true;

        initializePDir();

        if(debug == true)
        {
            System.out.println("PDirectory Constructor");
        }
    }

    protected void initializePDir()
    {
        boolean debug = true;

        if(debug == true)
        {
            System.out.println("initializePDir");
        }
    }

    public int verifyProvider(int pid)
    {
        boolean debug = true;

        if(debug == true)
        {

            System.out.println("verifyProvider");
        }

        return 0;
    };

    public int addProvider(Provider nProvider)
    {
        boolean debug = true;

        if(debug == true)
        {

            System.out.println("addProvider");
        }

        return 0;
    };

    public int removeProvider(Provider rProvider)
    {
        boolean debug = true;

        if(debug == true)
        {
            System.out.println("removeProvider");
        }

        return 0;
    };
    public void buildReports(){};
    {
        boolean debug = true;

        if(debug == true)
        {
            System.out.println("buildReports");
        }

//        return 0;
    };
}
