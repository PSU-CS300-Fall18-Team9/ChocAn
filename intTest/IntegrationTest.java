import chocan.*;

public class IntegrationTest
{
    public static void main(String[] args)
    {
        System.out.println("Welcome to ChocAn Data Processing Integration Test");

        // Test directory class' instantiation
        PDirectory nPDir = new PDirectory();
        MDirectory nMDir = new MDirectory();

        System.out.println("\nPrinting Provider Directory after initialization:");
        System.out.println(nPDir);

        System.out.println("\nPrinting Member Directory after initialization:");
        System.out.println(nMDir);

        // Test data class' instantiation
        Provider nProvider = new Provider("Smelly", "McGee", "12345 SW Portland Ave", "Portland", "Oregon", 97223, 100000000,false);
        Member nMember = new Member("John", "Smith", "12345 SW Portland Ave", "Portland", "Oregon", 654123987, 97223, true);

        Service nService = new Service(11, 30, 2018, 755601, 100, "New Service");
        nProvider.addService(nService, "John Smith", 100000000);
        nMember.addService(nService, "Smelly McGee", 654123987);

        // Test data class' toString
        System.out.println("\nPrinting new provider information:");
        System.out.println(nProvider);

        System.out.println("\nPrinting new member information:");
        System.out.println(nMember);

        // Test directory class' methods
        nMDir.addMember(nMember);
        nPDir.addProvider(nProvider);

        System.out.println("\nPrinting Provider Directory after addition of new provider:");
        System.out.println(nPDir);

        System.out.println("\nPrinting Member Directory after addition of new member:");
        System.out.println(nMDir);

/*        if(nMDir.verifyMember(654123987))
        {
            System.out.println("ID# 654123987 found, deleting...");
            nMDir.removeMember(654123987);
        }
        System.out.println("\nPrinting Member Directory after removal of new member:");
        System.out.println(nMDir);
*/
/*        if(nPDir.verifyProvider(100000000))
        {
            System.out.println("ID# 1000000000 found, deleting...");
            nPDir.removeProvider(100000000);
        }
        System.out.println("\nPrinting Provider Directory after removal of new provider:");
        System.out.println(nPDir);
*/
        nMDir.buildReports();
        nPDir.buildReports();

        nMDir.saveFile();
        nPDir.saveFile();
    }
}

