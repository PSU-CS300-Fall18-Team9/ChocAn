/*
 * TODO:
 *
 */

package chocan;
import java.util.*;
import java.io.*;

public class PDirectory
{
    public Map<String, Provider> PDir = new HashMap<String, Provider>();
    FileInputStream in = null;
    FileOutputStream out = null;

    public PDirectory() throws IOException
    {
        boolean debug = true;

        if(debug == true)
        {
            System.out.println("PDirectory Constructor");
        }

        initializePDir();
    }

    protected void initializePDir() throws IOException
    {
        boolean debug = true;

        if(debug == true)
        {
            System.out.println("initializePDir");
        }

        try
        {
            in = new FileInputStream("./data/ProviderListNameNumberOnly.txt");
        }
        finally
        {
            in.close();
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

    public void buildReports()
    {
        boolean debug = true;

        if(debug == true)
        {
            System.out.println("buildReports");
        }
    };
}
