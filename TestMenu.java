//import java.io.PrintStream;
import java.io.IOException;
import java.util.*;
import chocan.*;

public class TestMenu
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int oid = -1;
        int menuNum = -1;

        // Test directory class' instantiation
//        MDirectory nMDir = new MDirectory();
        PDirectory nPDir = new PDirectory();

        // Test data class' instantiation
//        Data nMember = new Member();
//        Member nMember = new Member();
//        Data nProvider = new Provider("John", "Smith", "12345 SW Portland Ave", "Portland", "Oregon", 97223, 100000000, 0);
        Provider nProvider = new Provider("John", "Smith", "12345 SW Portland Ave", "Portland", "Oregon", 97223, 100000000, 0);
//        Provider nProvider = new Provider();
//        Service nService = new Service();

        // Test data class' fields
/*        nMember.name = "testing";
//        nMember.number = 100000000;
        nProvider.firstName = "John";
        nProvider.lastName = "Smith";
        nProvider.number = 100000000;
        // Service fields
*/

        // Test data class' toString
//        System.out.println(nMember);
        System.out.println(nProvider);
//        System.out.println(nService);

        // Test directory class' methods
        nPDir.addProvider(nProvider);
        System.out.println(nPDir);
//        nPDir.removeProvider(nProvider.number);
//        System.out.println(nPDir);

        // Start of menu prototype

        nPDir.buildReports();
        nPDir.saveFile();

        System.out.println("Welcome to ChocAn Data Processing System TESTMENU");

        // Operator Login
        boolean opVerified = false;

        while(!opVerified)
        {
            System.out.print("\nLogin to ChocAn Using Provider/Manager ID:");
            oid = sc.nextInt();

            if (nPDir.verifyProvider(oid))
            {
                System.out.println("Provider " + oid + " Verified...");
                opVerified = true;
            }
            else
            {
                System.out.println("Provider " + oid + " could not be verified, try again");
            }
        }

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
