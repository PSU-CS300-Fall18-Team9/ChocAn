package chocan;

        import java.util.*;
        import java.io.*;

public class MDirectory
{
    public Map<Integer, Member> MDir = new HashMap();

    public Member findMember(int mid){  //find and return member
        if (MDir.containsKey(mid)){
            return MDir.get(mid);
        }
        else return null;
    }

    public Member verifyMember(int mid){    //verify member with id mid
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

    public void buildReport(){    //build member report
        for(Map.Entry<Integer, Member> entry: MDir.entrySet()){
            MDir.getValue.report();
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

                Member nMember = new Member(tData[0], tData[1], tData[2], tData[3], tData[4], Integer.parseInt(tData[5]), Integer.parseInt(tData[6]));
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
        String dataFile = "./data/MemberList.txt";

        try
        {
            File outFile = new File(dataFile);
            PrintWriter pw = new PrintWriter(outFile);

            for(Map.Entry<Integer, Member> entry: MDir.entrySet())
            {
                String[] tData = entry.getValue().report();

                StringBuilder nString = new StringBuilder();

                nString.append(tData[0] + "#");
                nString.append(tData[1] + "#");
                nString.append(tData[2] + "#");
                nString.append(tData[3] + "#");
                nString.append(tData[4] + "#");
                nString.append(tData[5] + "#");
                nString.append(tData[6] + "#\n");

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


    public boolean editMember(id, st, num, status, choice){ //edit member with id
        Member toEdit = MDir.get(id);
        if (toEdit) {
            return toEdit.edit(String st, num, choice);
        }
        else return false;
    }
}
