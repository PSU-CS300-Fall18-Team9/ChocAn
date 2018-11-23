package chocan;

import java.io.*;
import java.util.*;

public class SDirectory {

    public Map<Integer, Service> SDir = new HashMap<>();

    SDirectory()
    {
        boolean debug = true;

        if(debug == true)
        {
            System.out.println("SDirectory Default Constructor");
        }

        initialize();
    }

    protected void initialize() //throws IOException
    {
        boolean debug = !true;

        if(debug == true)
        {
            System.out.println("PDirectory initializePDir");
        }

        String dataFile = "./data/ProviderDirectory.txt";
        String line = "";
        String sepChar = "#";

        try
        {
            FileReader fileIn = new FileReader(dataFile);
            BufferedReader buffIn = new BufferedReader(fileIn);

            while((line = buffIn.readLine()) != null)
            {
                if(debug == true)
                {
                    System.out.println(line);
                }

                String[] tData = line.split(sepChar);

                if(debug == true)
                {
                    System.out.println(tData[0]);
                    System.out.println(tData[1]);
                    System.out.println(tData[2]);
                }

                Service nService = new Service(); // Temp fix for error below
//                Service nService = new Service(Integer.parseInt(tData[1]), tData[0], Integer.parseInt(tData[2])); // Not built yet
                SDir.put(0, nService); // Temp fix for error below
//                SDir.put(nService.number, nService); // Not built
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
        boolean debug = true;

        if(debug == true)
        {
            System.out.println("PDirectory verifyProvider");
            System.out.println("pId = " + sid);
        }

        return SDir.containsKey(sid);
    };

    public String toString()
    {
        boolean debug = true;

        if(debug == true)
        {
            System.out.println("SDirectory toString");
        }

        String data = null;

        for(Map.Entry<Integer, Service> entry: SDir.entrySet())
//        for(Map.Entry<Integer, Provider> entry: PDir.entrySet())
        {
            data = entry.getValue().toString();
        }

        return data;
    }
}
