package chocan;
import java.util.*;
import java.io*;

public class MDirectory
{
    public Map<Integer, Member> MDir = new HashMap();

    public boolean verifyMember(int mid){
        if (MDir.containsKey){
            return true;
        }
        else return false;
    }

    public int addMember(Member nMember){
        MDir.put(nMember.number, nMember);
        return 0;
    }

    public int removeMember(Member int mid){
        MDir.remove(mid);
        return 0;
    }

    public void buildReports(){
        for (Member value: MDir.values()){
            value.buildReport();
        }
    }

    public void readIn(){
        String lastName;
        String firstName;
        int phone;
        String address;
        String city;
        String state;
        int zip;

        Scanner members = new Scanner("ChocAn/data/MemberList.txt").useDelimiter("#");

        lastName = members.next();
        firstName = members.next();
        phone = members.nextInt();
        address = members.next();
        city = members.next();
        state = members.next();
        zip = members.nextInt();
    }

    public String buildReport(){
        String strArray;

        for(Map.Entry<Integer, Member> entry: MDir.entrySet()){
            strArray = entry.getValue().report();
            StringBuilder nString = new StringBuilder();
            nString.append("Member Name: " + strArray[0] + " " strArray[1] + "\n");
            nString.append("Member Number: " + strArray[2] + "\n");
            nString.append("Address: " + strArray[3] + "\n");
            nString.append("City: " + strArray[4] + "\n");
            nString.append("State: " + strArray[5] + "\n");
            nString.append("Zip: " + strArray[6] + "\n");

            StringBuilder dataFile = new StringBuilder();

            dataFile.append("./reports/member/" + tData[0]+tData[1] + ".txt");

            File outFile = new File(dataFile.toString());
            PrintWriter pw = new PrintWrite(outFile);
            pw.write(nString.toString());
            pw.close();
        }

    }

    public void initialize(){
        String dataFile = "./data/MemberList.txt";
        String line = "";
        String delim = "#";

        try{
            FileReader fileIn = new FileReader(dataFile);
            BufferedReader buffIn = new BufferedReader(fileIn);
        }

        while ((line = buffIn.readLine()) != null){
            String[] tData = line.split(delim);

            Member nMember = new Member(tData[0], tData[1], tData[2], tData[3], tData[4], tData[5], tData[6], tData[7]);
            this.addMember(nMember);
        }

        fileIn.close();

        catch (IOException e1)
        {
            System.out.println("Exception thrown:" + e1);
        }
    }

    public void saveFile()
    {
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

    public String toString()
    {
        boolean debug = !true;

        if(debug == true)
        {
            System.out.println("MDirectory toString");
        }

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


}
