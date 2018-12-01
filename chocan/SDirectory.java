package chocan;

import java.io.*;
import java.util.*;

public class SDirectory
{
    public Map<Integer, Service> SDir = new HashMap<>();

    public SDirectory()
    {
        initialize();
    }

    public int getFee(int SID)
    {
        return SDir.get(SID).fee;
    }

    protected void initialize() //throws IOException
    {
        String dataFile = "./data/ProviderDirectory.txt";
        String line = "";
        String sepChar = "#";

        try
        {
            FileReader fileIn = new FileReader(dataFile);
            BufferedReader buffIn = new BufferedReader(fileIn);

            while((line = buffIn.readLine()) != null)
            {
                String[] tData = line.split(sepChar);

                Service nService = new Service(tData[1], 0, 0, 0, 0, 0, Integer.parseInt(tData[0]), Integer.parseInt(tData[2]), null, 0, 0, 0);

                SDir.put(nService.serviceCode, nService); // Temp fix for error below
            }

            fileIn.close();
        }
        catch (IOException e1)
        {
            System.out.println("Exception thrown:" + e1);
        }
    }

    public boolean verifyService(int sid)
    {
        return SDir.containsKey(sid);
    };

    public String toString()
    {
        StringBuilder data = new StringBuilder();

        for(Map.Entry<Integer, Service> entry: SDir.entrySet())
        {

            data.append(entry.getValue().serviceCode + " " + entry.getValue().serviceName + " " + entry.getValue().fee + "\n");
        }

        return data.toString();
    }
}
