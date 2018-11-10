/*
 * TODO:
 * Dependencies:
 *  Need finished Provider class
 * Add provider X
 * Remove provider X
 * Print provider directory
 * Edit provider
 * Verify provider X
 * Import data file into Map
 * Export data from Map into data file
 * Build reports
 */

package chocan;
import java.util.*;
import java.io.*;

public class PDirectory
{
    public Map<Integer, Provider> PDir = new HashMap<>();

    FileInputStream in = null;
    FileOutputStream out = null;

    public PDirectory() //throws IOException
    {
        boolean debug = true;

        if(debug == true)
        {
            System.out.println("PDirectory Constructor");
        }

//        initializePDir();
    }

/*    protected void initializePDir() //throws IOException
    {
        boolean debug = true;

        if(debug == true)
        {
            System.out.println("PDirectory initializePDir");
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
*/
    public boolean verifyProvider(int pid)
    {
        boolean debug = true;

        if(debug == true)
        {
            System.out.println("PDirectory verifyProvider");
            System.out.println("pId = " + pid);
        }

        return PDir.containsKey(pid);
    };

    public int addProvider(Provider nProvider)
    {
        boolean debug = true;

        if(debug == true)
        {

            System.out.println("PDirectory addProvider");
        }

        PDir.put(nProvider.number, nProvider);

        return 0;
    };

    public int editProvider(Provider nProvider)
    {
        boolean debug = true;

        if(debug == true)
        {

            System.out.println("PDirectory addProvider");
        }

        PDir.put(nProvider.number, nProvider);

        return 0;
    };
    public int removeProvider(int pid)
    {
        boolean debug = true;

        if(debug == true)
        {
            System.out.println("PDirectory removeProvider");
            System.out.println("pId = " + pid);
        }

        PDir.remove(pid);

        return 0;
    };

    public void buildReports()
    {
        boolean debug = true;

        if(debug == true)
        {
            System.out.println("PDirectory buildReports");
        }
    };

    public String toString()
    {
        boolean debug = true;

        if(debug == true)
        {
            System.out.println("PDirectory toString");
        }

/*        Set<Data> mSet = new Set<Data>;
        mSet = PDir.entrySet();


        Iterator itr = PDir.iterator();
*/
        String data = null;

        for(Map.Entry<Integer, Provider> entry: PDir.entrySet())
        {
//            System.out.println(entry.getValue());
//            data = entry.getValue();
        }

        return data;
    }
}
