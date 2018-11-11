/*
 * TODO:
 * Dependencies:
 *  Need finished Provider class
 * Add provider /
 *  Enter data for new provider
 *  Add new provider to map X
 * Remove provider X
 * Print provider directory X
 * Edit provider /
 *  Edit provider fields
 *  Overwrite provider data in map X
 * Verify provider X
 * Import data file into Map /
 *  Open/close file X
 *  Throw IO exception if invalid filename/file doesn't exist X
 *  Load data into Map
 * Export data from Map into data file
 * Build reports
 * Save directory file on exit
 */

package chocan;
import java.util.*;
import java.io.*;

public class PDirectory
{
    public Map<Integer, Data> PDir = new HashMap<>();
//    public Map<Integer, Provider> PDir = new HashMap<>();

    FileInputStream in = null;
    FileOutputStream out = null;

    public PDirectory() //throws IOException
    {
        boolean debug = true;

        if(debug == true)
        {
            System.out.println("PDirectory Constructor");
        }

        initializePDir();
    }

    protected void initializePDir() //throws IOException
    {
        boolean debug = true;

        if(debug == true)
        {
            System.out.println("PDirectory initializePDir");
        }

        try
        {
            in = new FileInputStream("./data/ProviderListNameNumberOnly.txt");
//            FileInputStream in = new FileInputStream("./data/ProviderListNameNumberOnly.txt");
//            in = new FileInputStream("./data/ProviderListNameNumberOnly.txt");
//            in = new FileInputStream("./data/DoesNotExist"); // Test exception

/*            String sIn  = NULL;

            while((sIn = in.read()) != '#')
            {

            }
*/
            in.close();
        }
        catch (IOException e1)
        {
           System.out.println("Exception thrown:" + e1);
        }
    }

    public int verifyProvider(int pid)
    {
        boolean debug = true;

        if(debug == true)
        {
            System.out.println("PDirectory verifyProvider");
            System.out.println("pId = " + pid);
        }

        int verPid = 0;

        if (PDir.containsKey(pid))
        {
            verPid = 1;
        }

        return verPid;
    };

    public int addProvider(Data nProvider)
//    public int addProvider(Provider nProvider)
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
            System.out.println("PDirectory editProvider");
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

        String data = null;

        for(Map.Entry<Integer, Data> entry: PDir.entrySet())
//        for(Map.Entry<Integer, Provider> entry: PDir.entrySet())
        {
            data = entry.getValue().toString();
        }

        return data;
    }
}
