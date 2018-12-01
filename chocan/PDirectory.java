/*
 * TODO:
 * Dependencies:
 *  Need finished Provider class
 *  Need finished Service class
 * Add provider /
 *  Enter data for new provider
 *      Needs finished Provider class
 *  Add new provider to map X
 * Remove provider X
 * Print provider directory X
 * Edit provider /
 *  Edit provider fields (handled by menu?)
 *  Overwrite provider data in map X
 * Verify provider X
 * Verify privilege (can be done by verify provider?)
 *  Needs finished provider class
 * Import data file into Map /
 *  Open/close file X
 *  Throw IO exception if invalid filename/file doesn't exist X
 *  Load provider data into Map /
 *      Needs finished Provider class
 *  Load service data into Map
 * Export data from Map into data file /
 *  Export provider data /
 *      Needs finished provider class
 *  Export service data
 *      Needs finished service class
 * Build reports /
 *  Needs service data
 * Save directory file on exit /
 *  Needs finished provider class
 *  Needs service data
 *      Needs finished service class
 */

package chocan;
import java.nio.Buffer;
import java.util.*;
import java.io.*;

public class PDirectory
{
    public Map<Integer, Provider> PDir = new HashMap<>();

    public PDirectory() //throws IOException
    {
        initialize();
    }

    public int addProvider(Provider nProvider)
    {
        PDir.put(nProvider.id, nProvider);

        return 0;
    };

    public void buildReports()
    {
        for(Map.Entry<Integer, Provider> entry: PDir.entrySet())
        {
            //If reporting handled by Provider class
            Service nService = new Service();
            StringBuilder dataFile = new StringBuilder();
            dataFile.append("./reports/provider/" + entry.getValue().firstName+entry.getValue().lastName+nService.dateOfService() + ".txt");

            entry.getValue().buildReport(dataFile.toString(), false);
//            entry.getValue().buildReport(dataFile.toString(), false);

        }
    };

    public boolean editProvider(int id, String st, int num, boolean status, int choice)
    {
        Provider toEdit = PDir.get(id);

        return toEdit.edit(st, num, choice);
    };

    public Provider findProvider(int pid)
    {
        if (PDir.containsKey(pid)){
            return PDir.get(pid);
        }
        else return null;
    }

    protected void initialize() //throws IOException
    {
        String dataFile = "./data/ProviderList.txt";
        String line = "";
        String sepChar = "#";

        try
        {
            FileReader fileIn = new FileReader(dataFile);
            BufferedReader buffIn = new BufferedReader(fileIn);

            while((line = buffIn.readLine()) != null)
            {
                String[] tData = line.split(sepChar);

                Provider nProvider = new Provider(tData[0], tData[1], tData[3], tData[4], tData[5], Integer.parseInt(tData[6]), Integer.parseInt(tData[2]),Boolean.parseBoolean((tData[7])));
                this.addProvider(nProvider);
            }

            fileIn.close();
        }
        catch (IOException e1)
        {
           System.out.println("Exception thrown:" + e1);
        }
    }

    public int removeProvider(int pid)
    {
        PDir.remove(pid);

        return 0;
    };

    public void saveFile()
    {
        FileOutputStream out = null;
        String dataFile = "./data/ProviderListOut.txt";

        try
        {
            File outFile = new File(dataFile);
            PrintWriter pw = new PrintWriter(outFile);

            for(Map.Entry<Integer, Provider> entry: PDir.entrySet())
            {
                String[] tData = entry.getValue().strArray();

                StringBuilder nString = new StringBuilder();

                nString.append(tData[0] + "#");
                nString.append(tData[1] + "#");
                nString.append(tData[2] + "#");
                nString.append(tData[3] + "#");
                nString.append(tData[4] + "#");
                nString.append(tData[5] + "#");
                nString.append(tData[6] + "#");
                nString.append(tData[7] + "#\n");

                pw.write(nString.toString());
            }

            pw.close();
        }
        catch (FileNotFoundException e1)
        {
            System.out.println("Exception thrown:" + e1);
        }
    }

    public String toString()
    {
        String data = null;

        for(Map.Entry<Integer, Provider> entry: PDir.entrySet())
        {
            if(data != null) // Fix for null on toString
                data += entry.getValue().toString();
            else
                data = entry.getValue().toString();
        }

        return data;
    }

    public boolean verifyProvider(int pid)
    {
        return PDir.containsKey(pid);
    };

    public boolean verifyPrivilege(int pid)
    {
        return PDir.get(pid).privilege;
    };
}
