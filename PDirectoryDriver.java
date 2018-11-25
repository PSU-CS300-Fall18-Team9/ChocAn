//import java.io.PrintStream;
import java.io.IOException;
import java.util.*;
import chocan.*;

public class PDirectoryDriver
{
    public static void main(String[] args)
    {
        System.out.println("Welcome to ChocAn Data Processing System Provider Directory Driver");

        // Test directory class' instantiation
        PDirectory nPDir = new PDirectory();
        System.out.println("\nPrinting Provider Directory after initialization:");
        System.out.println(nPDir);

        // Test data class' instantiation
//        Data nProvider = new Provider("John", "Smith", "12345 SW Portland Ave", "Portland", "Oregon", 97223, 100000000, 0);
        Provider nProvider = new Provider("John", "Smith", "12345 SW Portland Ave", "Portland", "Oregon", 97223, 100000000, 0);
//        Provider nProvider = new Provider();

        // Test data class' fields
/*        nProvider.firstName = "John";
        nProvider.lastName = "Smith";
        nProvider.id = 100000000;
*/

        // Test data class' toString
        System.out.println("\nPrinting new provider information:");
        System.out.println(nProvider);

        // Test directory class' methods
        nPDir.addProvider(nProvider);
        System.out.println("\nPrinting Provider Directory after addition of new provider:");
        System.out.println(nPDir);
        if(nPDir.verifyProvider(100000000))
        {
            System.out.println("ID# 1000000000 found, deleting...");
            nPDir.removeProvider(100000000);
        }
        System.out.println("\nPrinting Provider Directory after removal of new provider:");
        System.out.println(nPDir);

        nPDir.buildReports(); // NullPointerException on Provider.buildReport
        nPDir.saveFile();
    }
}
