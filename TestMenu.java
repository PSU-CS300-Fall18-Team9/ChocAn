//import java.io.PrintStream;
import java.io.IOException;
import java.util.*;
import chocan.*;

public class TestMenu
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int oid;
        int menuNum = -1;

//        Data nMember = new Member();
//        Member nMember = new Member();
        Provider nProvider = new Provider();
//        Service nService = new Service();

        nProvider.name = "testing";
        nProvider.number = 123456789;

//        List<Data> testData = new LinkedList<Data>();
//        testData.add(nProvider);
//        testData.add(nProvider);
//        testData.add(nService);

        System.out.println(nProvider);

        try
        {
            PDirectory nPDir = new PDirectory();

            nPDir.addProvider(nProvider);
            System.out.println(nPDir);
            nPDir.removeProvider(nProvider.number);
            System.out.println(nPDir);
        }
        catch(IOException e)
        {
            System.out.println("Exception thrown: " + e);
        }

        System.out.println("Welcome to ChocAn Data Processing System");

        // Operator Login  
        System.out.print("\nLogin to ChocAn Using Provider/Manager ID:");
        oid = sc.nextInt();
        System.out.println("Provider " + oid + " Verified...");

        // Provide menu functionns here:
        while(menuNum != 0)
        {
            System.out.println("\nProvider Operations;");
            // Member Check-In (first verification)
            System.out.println("  1. Member Check-In");
            // Member Check-Out (second verification)
            System.out.println("  2. Member Check-Out");
            // Add Service Provided
            System.out.println("  3. New Service Provided ");
            // List Provider Directory        
            System.out.println("  4. Display Provider Directory ");
            // Generate Provider Directory File 
            System.out.println("  5. Save Provider Directory ");
            // Weekly Member Report
            System.out.println("  6. Generate Member's Report ");
            // Weekly Provider Report
            System.out.println("  7. Generate Provider's Report ");
            // EFT Report
            System.out.println("  8. Generate EFT Report ");
            System.out.println("  0. Exit ChocAn Data Processing System  ");

            System.out.print("\nEnter Selection: ");
            menuNum = sc.nextInt();
            
               
            // Manager menu functions:  
                // Weekly Accoounting  Report
            
            // Operator menu functions:
                // Add New Member
                // Remove Member
                // Update Member Records
                // Add New Provider
                // Remove Provider
                // Update Provider Records
            
            if(menuNum == 0)
            {
                System.out.println("\nThanks for using ChocAn Data Processing System. Good Bye!" );
            }
             
        }
    }
}
