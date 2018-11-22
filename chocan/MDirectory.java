package chocan;
import java.util.*;
import java.io*;

public class MDirectory
{
    public Map<Integer, Data> MDir = new HashMap();

    public int verifyMember(int mid){
        if (MDir.containsKey){
            return 1;
        }
        else return 0;
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
}
