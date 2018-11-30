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
            return MDir.get(mid);
        }
        else return null;
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
        String[] strArray;

        for(Map.Entry<Integer, Member> entry: MDir.entrySet()){
            strArray = entry.getValue().report();
            StringBuilder nString = new StringBuilder();
            nString.append("Member Name: " + strArray[0] + " " + strArray[1] + "\n");
            nString.append("Member Number: " + strArray[2] + "\n");
            nString.append("Address: " + strArray[3] + "\n");
            nString.append("City: " + strArray[4] + "\n");
            nString.append("State: " + strArray[5] + "\n");
            nString.append("Zip: " + strArray[6] + "\n");

            StringBuilder dataFile = new StringBuilder();

            dataFile.append("./reports/member/" + strArray[0]+strArray[1] + ".txt");

            try {
                File outFile = new File(dataFile.toString());
                PrintWriter pw = new PrintWriter(outFile);
                pw.write(nString.toString());
                pw.close();
            }
            catch (FileNotFoundException e1)
            {
                System.out.println("Exception thrown:" + e1);
            }
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

    public boolean editMember(int id, String st, int num, int status, int choice){ //edit member with id
        Member toEdit = findMember(id);
        if (toEdit != null) {
            return toEdit.edit(st, num, choice);
        }
        else return false;
    }

}
