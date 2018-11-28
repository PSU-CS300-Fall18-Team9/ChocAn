import java.awt.*;
import java.util.*;
import chocan.*;

public class Menu
{
//    protected Scanner input;
    protected static Scanner input;

    public static void main(String[] args)
    {
        System.out.println("Welcome to ChocAn Data Processing System");
/*        input = new Scanner(System.in);
        int PID = 0;

        //class objects
        MDirectory MDir = new MDirectory();
        PDirectory PDir = new PDirectory();
        SDirectory SDir = new SDirectory();
        Service svc = new Service();

        boolean auth = false;
        do
        {
            System.out.print("Please enter your provider ID: ");
            PID = input.nextInt();
            input.nextLine();

            auth = PDir.verifyProvider(PID);
            if (!auth)
                System.out.print("\n***Authorization failed***");

        }
        while (!auth);

        int choice = topMenu();

        //if user does not choose to exit program
        if (3 != choice)
        {
            //if user chooses management privileges
            if (1 == choice)
            {
                boolean mgrAuth = PDir.verifyPrivilege(PID);
                if (!mgrAuth)
                    System.out.print("***You are not authorized to view the Management Menu***\n");
                else
                {
                    System.out.print("***Authorized***\n");
                    int mgrChoice = mgrMainMenu();

                    //while user chooses not to exit the menu
                    while (5 != mgrChoice)
                    {
                        //if user selects Member Management menu
                        if (1 == mgrChoice)
                        {
                            int mbrMgmtChoice = mbrMgmtMenu();
                            while (5 != mbrMgmtChoice)
                            {
                                //if user chooses to add a member
                                if (1 == mbrMgmtChoice)
                                {
                                    String lastName = new String();
                                    String firstName = new String();
                                    int id = 0;
                                    String address = new String();
                                    String city = new String();
                                    String state = new String();
                                    int zip = 0;
                                    boolean status = false;

                                    getInfo(mgrChoice, lastName, firstName, id, address, city, state, zip, status);
                                    Member nMember = new Member(lastName, firstName, id, address, city, state, zip, status);

                                    int added = MDir.addMember(nMember);
//                                    int added = MDir.add(nMember);
                                    if (1 == added)
                                        System.out.print("\n***Member added***\n");
                                    else
                                        System.out.print("\n***Error adding member***\n");
                                }

                                //if user chooses to delete a member
                                else if (2 == mbrMgmtChoice)
                                {
                                    System.out.print("\nEnter the 9-digit ID of the member you would like to delete: ");
                                    int MID = input.nextInt();
                                    input.nextLine();

                                    boolean found = MDir.verifyMember(MID);
//                                    boolean found = MDir.findMember(MID);

                                    if (!found)
                                        System.out.print("\n***Error: member not found***\n");
                                    else
                                    {
                                        int deleted = MDir.removeMember(MID);
                                        if (1 == deleted)
                                            System.out.print("\n***Member deleted***\n");
                                        else
                                            System.out.print("\n***Error deleting member***\n");
                                    }
                                }

                                //if user chooses to edit a member
                                else if (3 == mbrMgmtChoice)
                                {
                                    //find the member
                                    System.out.print("\nPlease enter the 9-digit ID of the member you would like to edit: ");
                                    int MID = input.nextInt();
                                    input.nextLine();

                                    boolean found = MDir.verifyMember(MID);
//                                    boolean found = MDir.findMember(MID);

                                    if (!found)
                                        System.out.print("\n***Error: member not found***\n");
                                    else
                                    {
                                        int editOption = mbrPvdrEditMenu(mgrChoice);

                                        boolean edited = editMbr(editOption, mgrChoice, MID, MDir); //utility function
                                        if (edited)
                                            System.out.print("\n***Member edited***");
                                        else
                                            System.out.print("\n***Error editing member");
                                    }
                                }

                                //if user chooses to display all members
                                else if (4 == mbrMgmtChoice)
                                    System.out.println(MDir);
//                                    MDir.displayAll();

                                mbrMgmtChoice = mbrMgmtMenu();
                            }
                            mgrChoice = mgrMainMenu();
                        }

                        //if user selects Provider Management menu
                        else if (2 == mgrChoice)
                        {
                            int pvdrMgmtChoice = pvdrMgmtMenu();
                            //while user chooses not to exit the menu
                            while (5 != pvdrMgmtChoice)
                            {
                                //if user chooses to add a provider
                                if (1 == pvdrMgmtChoice)
                                {
                                    String lastName = new String();
                                    String firstName = new String();
                                    int id = 0;
                                    String address = new String();
                                    String city = new String();
                                    String state = new String();
                                    int zip = 0;
                                    boolean status = false;

                                    getInfo(mgrChoice, lastName, firstName, id, address, city, state, zip, status);
                                    Provider nProvider = new Provider(lastName, firstName, id, address, city, state, zip, status);

                                    int added = PDir.addProvider(nProvider);
                                    if (1 == added)
                                        System.out.print("\n***Provider added***\n");
                                    else
                                        System.out.print("\n***Error adding provider***\n");
                                }

                                //if user chooses to delete a provider
                                else if (2 == pvdrMgmtChoice)
                                {
                                    System.out.print("\nEnter the 9-digit ID of the provider you would like to delete: ");
                                    int pid = input.nextInt();
                                    input.nextLine();

                                    boolean found = PDir.verifyProvider(pid);

                                    if (!found)
                                        System.out.print("\n***Error: provider not found***\n");
                                    else
                                    {
                                        int deleted = PDir.removeProvider(pid);
                                        if (1 == deleted)
                                            System.out.print("\n***Provider deleted***\n");
                                        else
                                            System.out.print("\n***Error deleting provider***\n");
                                    }
                                }

                                //if user chooses to edit a provider
                                else if (3 == pvdrMgmtChoice)
                                {
                                    //find the provider
                                    System.out.print("\nPlease enter the 9-digit ID of the provider you would like to edit: ");
                                    int pid = input.nextInt();
                                    input.nextLine();

                                    boolean found = PDir.verifyProvider(pid);

                                    if (!found)
                                        System.out.print("\n***Error: provider not found***\n");
                                    else
                                    {
                                        int editOption = mbrPvdrEditMenu(mgrChoice);

                                        boolean edited = editPvdr(editOption, mgrChoice, pid, PDir);  //utility function
                                        if (edited)
                                            System.out.print("\n***Provider edited***");
                                        else
                                            System.out.print("\n***Error editing provider");
                                    }
                                }

                                //if user chooses to display all providers
                                else if (4 == pvdrMgmtChoice)
                                    System.out.println(PDir);
//                                    PDir.displayAll();

                                pvdrMgmtChoice = pvdrMgmtMenu();
                            }
                            mgrChoice = mgrMainMenu();
                        }

                        //if user selects Bill Member for Service
                        else if (3 == mgrChoice)
                        {
                            int svcChoice = svcMenu();
                            while (3 != svcChoice)
                            {
                                //if user chooses to display service codes
                                if (1 == svcChoice)
                                    System.out.println(svc);
                                    //System.out.println(SDir);  // Print each entry in SDirectory?
//                                    svc.displayAll();
                                    //if user chooses to create service record
                                else if (2 == svcChoice)
                                {
                                    boolean added = newSvcRec(MDir, PDir, svc, PID, SDir);  //utility function

                                    if (added)
                                        System.out.print("\n***Service record created***");
                                    else
                                        System.out.print("\n***Error creating service record");
                                }
                                svcChoice = svcMenu();
                            }
                            mgrChoice = mgrMainMenu();
                        }

                        //if user selects Reporting Menu
                        else if (4 == mgrChoice)
                        {
                            int mgrReportsChoice = mgrReportsMenu();
                            while (4 != mgrReportsChoice)
                            {
                                //if user chooses to create member report
                                if (1 == mgrReportsChoice)
                                    MDir.buildReports();

                                    //if user chooses to create provider report
                                else if (2 == mgrReportsChoice)
                                    PDir.buildReports();

                                    //if user chooses to create manager report
                                else if (3 == mgrReportsChoice)
                                    //create manager report

                                    mgrReportsChoice = mgrReportsMenu();
                            }
                            mgrChoice = mgrMainMenu();
                        }
                    }
                    choice = 3;  //exit program
                }
            }

            //if user chooses provider privileges
            else if (2 == choice)
            {
                boolean pvdrAuth = true;
                int pvdrChoice = 0;

                if (!pvdrAuth)
                    System.out.print("\n***You are not authorized to view the Provider Menu***\n");
                else
                {
                    System.out.print("***Authorized***\n");
                    pvdrChoice = pvdrMainMenu();
                }

                //while user chooses not to exit the menu
                while (4 != pvdrChoice)
                {
                    //if user selects Member Management menu
                    if (1 == pvdrChoice)
                    {
                        int mbrMgmtChoice = mbrMgmtMenu();
                        while (5 != mbrMgmtChoice)
                        {
                            //if user chooses to add a member
                            if (1 == mbrMgmtChoice)
                            {
                                String lastName = new String();
                                String firstName = new String();
                                int id = 0;
                                String address = new String();
                                String city = new String();
                                String state = new String();
                                int zip = 0;
                                boolean status = false;

                                getInfo(pvdrChoice, lastName, firstName, id, address, city, state, zip, status);
                                Member nMember = new Member(lastName, firstName, id, address, city, state, zip, status);

                                int added = MDir.addMember(nMember);
//                                int added = MDir.add(nMember);
                                if (1 == added)
                                    System.out.print("\n***Member added***\n");
                                else
                                    System.out.print("\n***Error adding member***\n");
                            }

                            //if user chooses to delete a member
                            else if (2 == mbrMgmtChoice)
                            {
                                System.out.print("\nEnter the 9-digit ID of the member you would like to delete: ");
                                int MID = input.nextInt();
                                input.nextLine();

                                boolean found = MDir.verifyMember(MID);
//                                boolean found = MDir.findMember(MID);

                                if (!found)
                                    System.out.print("\n***Error: member not found***\n");
                                else
                                {
                                    int deleted = MDir.removeMember(MID);
                                    if (1 == deleted)
                                        System.out.print("\n***Member deleted***\n");
                                    else
                                        System.out.print("\n***Error deleting member***\n");
                                }
                            }

                            //if user chooses to edit a member
                            else if (3 == mbrMgmtChoice)
                            {
                                //find the member
                                System.out.print("\nPlease enter the 9-digit ID of the member you would like to edit: ");
                                int mid = input.nextInt();
                                input.nextLine();

                                boolean found = MDir.verifyMember(mid);
//                                boolean found = MDir.findMember(mid);

                                if (!found)
                                    System.out.print("\n***Error: member not found***\n");
                                else
                                {
                                    int editOption = mbrPvdrEditMenu(pvdrChoice);

                                    boolean edited = editMbr(editOption, pvdrChoice, mid, MDir);
                                    if (edited)
                                        System.out.print("\n***Member edited***");
                                    else
                                        System.out.print("\n***Error editing member");
                                }
                            }

                            //if user chooses to display all members
                            else if (4 == mbrMgmtChoice)
                                System.out.println(MDir);
//                                MDir.displayAll();

                            mbrMgmtChoice = mbrMgmtMenu();
                        }
                        pvdrChoice = pvdrMainMenu();
                    }

                    //if user selects Bill Member for Service
                    else if (2 == pvdrChoice)
                    {
                        int svcChoice = svcMenu();
                        while (3 != svcChoice)
                        {
                            //if user chooses to display service codes
                            if (1 == svcChoice)
                            {
                                  System.out.println(SDir);
//                                svc.displayAll();
                            }
                                //if user chooses to create service record
                            else if (2 == svcChoice)
                            {
                                boolean added = newSvcRec(MDir, PDir, svc, PID, SDir);

                                if (added)
                                    System.out.print("\n***Service record created***");
                                else
                                    System.out.print("\n***Error creating service record");
                            }
                            svcChoice = svcMenu();
                        }
                        pvdrChoice = pvdrMainMenu();
                    }

                    //if user selects Reporting Menu
                    else if (3 == pvdrChoice)
                    {
                        int pvdrReportsChoice = pvdrReportsMenu();
                        while (3 != pvdrReportsChoice)
                        {
                            //if user chooses to create member report
                            if (1 == pvdrReportsChoice)
                                MDir.buildReports();

                                //if user chooses to create provider report
                            else if (2 == pvdrReportsChoice)
                                PDir.buildReports();

                            pvdrReportsChoice = pvdrReportsMenu();
                        }
                        pvdrChoice = pvdrMainMenu();
                    }
                }
                choice = 3;  //exit program
            }
        }

        //save any alterations to data files
        MDir.saveFile();
        PDir.saveFile();
    }

    public static int topMenu()
    {
        int menuOption = 0;

        do
        {
            System.out.print("\nPlease choose from the following options:\n");
            System.out.print("\n1 - Manager Menu");
            System.out.print("\n2 - Provider Menu");
            System.out.print("\n3 - Exit Program\n");
            System.out.print("\nEnter menu option here: ");

            menuOption = input.nextInt();
            input.nextLine();
            System.out.print("\n");

            if (1 > menuOption || 3 < menuOption)
                System.out.print("***Option out of range***\n");

        }
        while (1 > menuOption || 3 < menuOption);

        return menuOption;
    }

    public static int mgrMainMenu()
    {
        int menuOption = 0;

        do
        {
            System.out.print("\nPlease choose from the following options:\n");
            System.out.print("\n1 - Member Management");
            System.out.print("\n2 - Provider Management");
            System.out.print("\n3 - Bill Member for Service");
            System.out.print("\n4 - Reporting Menu");
            System.out.print("\n5 - Exit Program\n");
            System.out.print("\nEnter menu option here: ");

            menuOption = input.nextInt();
            input.nextLine();
            System.out.print("\n");

            if (1 > menuOption || 5 < menuOption)
                System.out.print("***Option out of range***\n");

        }
        while (1 > menuOption || 5 < menuOption);

        return menuOption;
    }

    public static int pvdrMainMenu()
    {
        int menuOption = 0;

        do
        {
            System.out.print("\nPlease choose from the following options:\n");
            System.out.print("\n1 - Member Management");
            System.out.print("\n2 - Bill Member for Service");
            System.out.print("\n3 - Reporting Menu");
            System.out.print("\n4 - Exit Program\n");
            System.out.print("\nEnter menu option here: ");

            menuOption = input.nextInt();
            input.nextLine();
            System.out.print("\n");

            if (1 > menuOption || 4 < menuOption)
                System.out.print("***Option out of range***\n");

        }
        while (1 > menuOption || 4 < menuOption);

        return menuOption;
    }

    public static int pvdrMgmtMenu() {
        int menuOption = 0;

        do
        {
            System.out.print("\nPlease choose from the following options:\n");
            System.out.print("\n1 - Add Provider");
            System.out.print("\n2 - Delete Provider");
            System.out.print("\n3 - Edit Provider");
            System.out.print("\n4 - Display all Providers");
            System.out.print("\n5 - Return to Main Menu\n");
            System.out.print("\nEnter menu option here: ");

            menuOption = input.nextInt();
            input.nextLine();
            System.out.print("\n");

            if (1 > menuOption || 5 < menuOption)
                System.out.print("***Option out of range***\n");

        }
        while (1 > menuOption || 5 < menuOption);

        return menuOption;
    }

    public static int mbrMgmtMenu() {
        int menuOption = 0;

        do
        {
            System.out.print("\nPlease choose from the following options:\n");
            System.out.print("\n1 - Add Member");
            System.out.print("\n2 - Delete Member");
            System.out.print("\n3 - Edit Member");
            System.out.print("\n4 - Display all Members");
            System.out.print("\n5 - Return to Main Menu\n");
            System.out.print("\nEnter menu option here: ");

            menuOption = input.nextInt();
            input.nextLine();
            System.out.print("\n");

            if (1 > menuOption || 5 < menuOption)
                System.out.print("***Option out of range***\n");

        }
        while (1 > menuOption || 5 < menuOption);

        return menuOption;
    }

    public static int svcMenu()
    {
        int menuOption = 0;

        do
        {
            System.out.print("\nPlease choose from the following options:\n");
            System.out.print("\n1 - Display Service Codes");
            System.out.print("\n2 - Create Service Record");
            System.out.print("\n3 - Return to Main Menu\n");
            System.out.print("\nEnter menu option here: ");

            menuOption = input.nextInt();
            input.nextLine();
            System.out.print("\n");

            if (1 > menuOption || 3 < menuOption)
                System.out.print("***Option out of range***\n");

        }
        while (1 > menuOption || 3 < menuOption);

        return menuOption;
    }

    public static int mgrReportsMenu()
    {
        int menuOption = 0;

        do
        {
            System.out.print("\nPlease choose from the following options:\n");
            System.out.print("\n1 - Create Member Report");
            System.out.print("\n2 - Create Provider Report");
            System.out.print("\n3 - Create Management Report");
            System.out.print("\n4 - Return to Main Menu\n");
            System.out.print("\nEnter menu option here: ");

            menuOption = input.nextInt();
            input.nextLine();
            System.out.print("\n");

            if (1 > menuOption || 4 < menuOption)
                System.out.print("***Option out of range***\n");

        }
        while (1 > menuOption || 4 < menuOption);

        return menuOption;
    }

    public static int pvdrReportsMenu()
    {
        int menuOption = 0;

        do
        {
            System.out.print("\nPlease choose from the following options:\n");
            System.out.print("\n1 - Create Member Report");
            System.out.print("\n2 - Create Provider Report");
            System.out.print("\n3 - Return to Main Menu\n");
            System.out.print("\nEnter menu option here: ");

            menuOption = input.nextInt();
            input.nextLine();
            System.out.print("\n");

            if (1 > menuOption || 3 < menuOption)
                System.out.print("***Option out of range***\n");

        }
        while (1 > menuOption || 3 < menuOption);

        return menuOption;
    }

    public static int mbrPvdrEditMenu(int choice)
    {
        int menuOption = 0;

        do
        {
            System.out.print("\nWhat field would you like to edit?");
            System.out.print("\nPlease choose from the following options:\n");
            System.out.print("\n1 - Last name");
            System.out.print("\n2 - First name");
            System.out.print("\n3 - ID number");
            System.out.print("\n4 - Street address");
            System.out.print("\n5 - City");
            System.out.print("\n6 - State");
            System.out.print("\n7 - Zip code");

            if (1 == choice)
                System.out.print("\n8 - Payment status\n");
            else if (2 == choice)
                System.out.print("\n8 - Authorization level\n");
            System.out.print("\nEnter menu option here: ");

            menuOption = input.nextInt();
            input.nextLine();
            System.out.print("\n");

            if (1 > menuOption || 8 < menuOption)
                System.out.print("***Option out of range***\n");

        }
        while (1 > menuOption || 8 < menuOption);

        return menuOption;
    }

    public static void getInfo(int choice, String lastName, String firstName, int id, String address, String city, String state, int zip, boolean status) {
        if (1 == choice)
            System.out.print("\n***Add new member***\n");
        else if (2 == choice)
            System.out.print("\n***Add new provider***\n");
        else
            System.out.print("\n***Invalid entry***\n");

        System.out.print("\nPlease enter the following information:\n");

        System.out.print("\nLast name: ");
        lastName = input.nextLine();

        System.out.print("\nFirst name: ");
        firstName = input.nextLine();

        System.out.print("\n9-digit ID: ");
        id = input.nextInt();
        input.nextLine();

        System.out.print("\nStreet address: ");
        address = input.nextLine();

        System.out.print("\nCity: ");
        city = input.nextLine();

        System.out.print("\nState: ");
        state = input.nextLine();

        System.out.print("\nZip code: ");
        zip = input.nextInt();
        input.nextLine();

        if (1 == choice)
        {
            System.out.print("Is member current? (Y/N): ");
            char current = input.next().charAt(0);

            while (('Y' != current) && ('y' != current) && ('N' != current) && ('n' != current))
            {
                System.out.print("\n***Option out of range***\n");
                System.out.print("\nPlease enter Y/N: ");
                current = input.next().charAt(0);
            }

            if (('Y' == current) || ('y' == current))
                status = true;
            else
                status = false;
        }
        else if (2 == choice)
        {
            System.out.print("\nIs the user a manager? (Y/N): ");
            char mgr = input.next().charAt(0);

            while (('Y' != mgr) && ('y' != mgr) && ('N' != mgr) && ('n' != mgr))
            {
                System.out.print("\n***Option out of range***\n");
                System.out.print("\nPlease enter Y/N: ");
                mgr = input.next().charAt(0);
            }

            if (('Y' == mgr) || ('y' == mgr))
                status = true;
            else
                status = false;
        }
    }

    public static boolean newSvcRec(MDirectory MDir, PDirectory PDir, Service svc, int PID, SDirectory SDir)
    {
        System.out.print("\nPlease enter the 9-digit Member ID: ");
        int MID = input.nextInt();
        input.nextLine();

        boolean valid = MDir.verifyMember(MID);  //should we make this an int so we can print "invalid, suspended, validated?"
        if (valid)
        {
            System.out.print("\n***Validated***\n");
            System.out.print("\nPlease enter the date of service in MM-DD-YYYY format.");

            System.out.print("\nMM: ");
            int month = input.nextInt();
            input.nextLine();

            System.out.print("\nDD: ");
            int day = input.nextInt();
            input.nextLine();

            System.out.print("\nYYYY: ");
            int year = input.nextInt();
            input.nextLine();

            System.out.println(SDir);
            //svc.displayAll();

            char correct = 'N';
            int svcCode;
            do
            {
                System.out.print("\nPlease enter the 6-digit service code: ");
                svcCode = input.nextInt();
                input.nextLine();

                boolean found = svc.find(svcCode);
                while (!found)
                {
                    System.out.print("\n***Invalid service code***");
                    System.out.print("\nPlease enter the 6-digit service code: ");
                    svcCode = input.nextInt();
                    input.nextLine();
                    found = svc.find(svcCode);
                }

                System.out.print("\nYou entered " + svcCode + ".  Is this correct? (Y/N): ");
                correct = input.next().charAt(0);

                while (('Y' != correct) && ('y' != correct) && ('N' != correct) && ('n' != correct))
                {
                    System.out.print("\n***Option out of range***\n");
                    System.out.print("\nPlease enter Y/N: ");
                    correct = input.next().charAt(0);
                }
            }
            while ('N' == correct || 'n' == correct);

            System.out.print("\nPlease add comments regarding the service provided: ");
            String comments = new String();
            comments = input.nextLine();

            boolean addSvc = svc.createServiceRec(month, day, year, svcCode, comments, MID, PID);
            return addSvc;
        }
        return false;
    }

    public static boolean editMbr(int editOption, int choice, int id, MDirectory mDir)
    {
        String st = new String(" ");
        int num = 0;
        boolean status = false;

        //if user chooses to edit boolean info
        if (8 == editOption)
        {
            do
            {
                System.out.print("\nEnter 1 for current, 2 for delinquent: ");
                num = input.nextInt();
                input.nextLine();

                if (1 != num && 2 != num)
                    System.out.print("\n***Input error***\n");
            }
            while (1 != num && 2 != num);

            if (1 == num)
                status = true;
        }

        //if user chooses to edit int info
        else if (3 == editOption || 7 == editOption)
        {
            System.out.print("\nEnter new information here: ");
            num = input.nextInt();
            input.nextLine();
        }

        //if user chooses to edit string info
        else
        {
            System.out.print("\nEnter new information here: ");
            st = input.nextLine();
        }

        boolean edited = mDir.editMember(id, st, num, status, editOption);

        return edited;
    }

    public static boolean editPvdr(int editOption, int choice, int id, PDirectory pDir)
    {
        String st = new String(" ");
        int num = 0;
        boolean status = false;

        //if user chooses to edit boolean info
        if (8 == editOption)
        {
            do
            {
                System.out.print("\nEnter 1 for manager, 2 for provider: ");
                num = input.nextInt();
                input.nextLine();

                if (1 != num && 2 != num)
                    System.out.print("\n***Input error***\n");
            }
            while (1 != num && 2 != num);

            if (1 == num)
                status = true;
        }

        //if user chooses to edit int info
        else if (3 == editOption || 7 == editOption)
        {
            System.out.print("\nEnter new information here: ");
            num = input.nextInt();
            input.nextLine();
        }

        //if user chooses to edit string info
        else
        {
            System.out.print("\nEnter new information here: ");
            st = input.nextLine();
        }

        boolean edited = pDir.editProvider(id, st, num, status, editOption);

        return edited;
*/
    }
}
