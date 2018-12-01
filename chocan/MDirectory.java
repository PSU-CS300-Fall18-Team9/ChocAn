package chocan;

        import java.util.*;
        import java.io.*;

public class MDirectory
{
    public Map<Integer, Member> MDir = new HashMap();

    public MDirectory()
    {
        initialize();
    }

    public Member findMember(int mid){  //find and return member
        if (MDir.containsKey(mid)){
            return MDir.get(mid);
        }
        else return null;
    }

    public boolean verifyMember(int mid){    //verify member with id mid
        if (MDir.containsKey(mid)){
            return true;
        }
        else return false;
    }

    public int addMember(Member nMember){   //add member to hashtable
        MDir.put(nMember.id, nMember);
        return 0;
    }

    public int removeMember(int mid){    //remove member from table
        MDir.remove(mid);
        return 0;
    }

    public void buildReports(){    //build member report
        for(Map.Entry<Integer, Member> entry: MDir.entrySet()){
            StringBuilder dataFile = new StringBuilder();
            dataFile.append("./reports/member/" + entry.getValue().firstName+entry.getValue().lastName + ".txt");
            entry.getValue().buildReport(dataFile.toString());
        }
    }

    public void initialize(){   //read data from file to fill table
        String dataFile = "./data/MemberList.txt";
        String line = "";
        String delim = "#";

        try {
            FileReader fileIn = new FileReader(dataFile);
            BufferedReader buffIn = new BufferedReader(fileIn);

            while ((line = buffIn.readLine()) != null) {
                String[] tData = line.split(delim);

                Member nMember = new Member(tData[0], tData[1], tData[3], tData[4], tData[5], Integer.parseInt(tData[2]), Integer.parseInt(tData[6]), Boolean.parseBoolean(tData[7]));
                this.addMember(nMember);
            }

            fileIn.close();
        }
        catch(IOException e1)
            {
                System.out.println("Exception thrown:" + e1);
            }
    }

    public void saveFile()  //save current tree to file
    {
        String dataFile = "./data/MemberListOut.txt";

        try
        {
            File outFile = new File(dataFile);
            PrintWriter pw = new PrintWriter(outFile);

            for(Map.Entry<Integer, Member> entry: MDir.entrySet())
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

    public String toString()    //return array of strings for member
    {
        String data = null;

        for(Map.Entry<Integer, Member> entry: MDir.entrySet())
        {
            if(data != null)
                data += entry.getValue().toString();
            else
                data = entry.getValue().toString();
        }

        return data;
    }

    public boolean editMember(int id, String st, int num, boolean status, int choice){ //edit member with id
        Member toEdit = MDir.get(id);
        if (toEdit != null) {
            return toEdit.edit(st, num, choice);
        }
        else return false;
    }
}
