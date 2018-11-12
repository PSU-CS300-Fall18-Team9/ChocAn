java.awt.*;
import java.util.*;

public class Main {
    protected static Scanner input;

    public static void main(String[] args) {
        input = new Scanner(System.in);

        //class objects
        MDirectory MDir = new MDirectory();
        PDirectory PDir = new PDirectory();
        Service svc = new Service();

        boolean auth = false;
        do {
            System.out.print("Please enter your provider ID: ");
            int PID = input.nextInt();
            input.nextLine();

            auth = PDir.verifyProvider(PID);
            if(!auth)
                System.out.print("\n***Authorization failed***");

        }while(false == auth);

        int choice = topMenu();

        //if user does not choose to exit program
        if (3 != choice) {
            //if user chooses management privileges
            if (1 == choice) {
                boolean mgrAuth = true;  //replace w/ method that verifies provider has management privileges

                if(false == mgrAuth)
                    System.out.print("***You are not authorized to view the Management Menu***\n");
                else {
                    System.out.print("***Authorized***\n");
                    int mgrChoice = mgrMainMenu();

                    //while user chooses not to exit the menu
                    while(5 != mgrChoice){
                        //if user selects Member Management menu
                        if(1 == mgrChoice){
                            int mbrMgmtChoice = mbrMgmtMenu();
                            while(5 != mbrMgmtChoice){
                                //if user chooses to add a member
                                if(1 == mbrMgmtChoice){
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

                                    int added = MDir.add(nMember);
                                    if(1 == added)
                                        System.out.print("\n***Member added***\n");
                                    else
                                        System.out.print("\n***Error adding member***\n");
                                }

                                //if user chooses to delete a member
                                else if(2 == mbrMgmtChoice){
                                    System.out.print("\nEnter the 9-digit ID of the member you would like to delete: ");
                                    int MID = input.nextInt();
                                    input.nextLine();

                                    int deleted = MDir.removeMember(MID);
                                    if(1 == deleted)
                                        System.out.print("\n***Member deleted***\n");
                                    else
                                        System.out.print("\n***Error deleting member***\n");
                                }

                                //if user chooses to edit a member
                                else if(3 == mbrMgmtChoice){
                                    int editOption = mbrPvdrEditMenu(mgrChoice);
                                }

                                //if user chooses to display all members
                                else if(4 == mbrMgmtChoice){
                                    //display all members
                                }
                                mbrMgmtChoice = mbrMgmtMenu();
                            }
                            mgrChoice = mgrMainMenu();
                        }

                        //if user selects Provider Management menu
                        else if(2 == mgrChoice){
                            int pvdrMgmtChoice = pvdrMgmtMenu();
                            //while user chooses not to exit the menu
                            while(5 != pvdrMgmtChoice){
                                //if user chooses to add a provider
                                if(1 == pvdrMgmtChoice){
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

                                    int added = PDir.add(nProvider);
                                    if(1 == added)
                                        System.out.print("\n***Provider added***\n");
                                    else
                                        System.out.print("\n***Error adding provider***\n");
                                }

                                //if user chooses to delete a provider
                                else if(2 == pvdrMgmtChoice){
                                    System.out.print("\nEnter the 9-digit ID of the provider you would like to delete: ");
                                    int PID = input.nextInt();
                                    input.nextLine();

                                    int deleted = PDir.removeProvider(PID);
                                    if(1 == deleted)
                                        System.out.print("\n***Provider deleted***\n");
                                    else
                                        System.out.print("\n***Error deleting provider***\n");
                                }

                                //if user chooses to edit a provider
                                else if(3 == pvdrMgmtChoice){
                                    int editOption = mbrPvdrEditMenu(mgrChoice);
                                }

                                //if user chooses to display all providers
                                else if(4 == pvdrMgmtChoice){
                                    //display all providers
                                }
                                pvdrMgmtChoice = pvdrMgmtMenu();
                            }
                            mgrChoice = mgrMainMenu();
                        }

                        //if user selects Bill Member for Service
                        else if(3 == mgrChoice){
                            int svcChoice = svcMenu();
                            while(3 != svcChoice){
                                //if user chooses to display service codes
                                if(1 == svcChoice){
                                    svc.displayAll();
                                }

                                //if user chooses to create service record
                                else if(2 == svcChoice){
                                    boolean added = newSvcRec(MDir, svc);

                                    if(added)
                                        System.out.print("\n***Service record created***");
                                    else
                                        System.out.print("\n***Error creating service record");
                                }
                                svcChoice = svcMenu();
                            }
                            mgrChoice = mgrMainMenu();
                        }

                        //if user selects Reporting Menu
                        else if(4 == mgrChoice){
                            int mgrReportsChoice = mgrReportsMenu();
                            while(4 != mgrReportsChoice){
                                //if user chooses to create member report
                                if(1 == mgrReportsChoice)
                                    MDir.buildReports();

                                //if user chooses to create provider report
                                else if(2 == mgrReportsChoice)
                                    PDir.buildReports();

                                //if user chooses to create manager report
                                else if(3 == mgrReportsChoice)
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
            else if (2 == choice) {
                boolean pvdrAuth = true;
                int pvdrChoice = 0;
                //pvdrAuth = pvdr.auth();
                //if(false == pvdrAuth)
                    //pvdrAuth = mgr.auth();

                if (false == pvdrAuth)
                    System.out.print("\n***You are not authorized to view the Provider Menu***\n");
                else {
                    System.out.print("***Authorized***\n");
                    pvdrChoice = pvdrMainMenu();
                }

                //while user chooses not to exit the menu
                while(4 != pvdrChoice){
                    //if user selects Member Management menu
                    if(1 == pvdrChoice){
                        int mbrMgmtChoice = mbrMgmtMenu();
                        while(5 != mbrMgmtChoice){
                            //if user chooses to add a member
                            if(1 == mbrMgmtChoice){
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

                                int added = MDir.add(nMember);
                                if(1 == added)
                                    System.out.print("\n***Member added***\n");
                                else
                                    System.out.print("\n***Error adding member***\n");
                            }

                            //if user chooses to delete a member
                            else if(2 == mbrMgmtChoice){
                                System.out.print("\nEnter the 9-digit ID of the member you would like to delete: ");
                                int MID = input.nextInt();
                                input.nextLine();

                                int deleted = MDir.removeMember(MID);
                                if(1 == deleted)
                                    System.out.print("\n***Member deleted***\n");
                                else
                                    System.out.print("\n***Error deleting member***\n");
                            }

                            //if user chooses to edit a member
                            else if(3 == mbrMgmtChoice){
                                int editOption = mbrPvdrEditMenu(pvdrChoice);
                            }

                            //if user chooses to display all members
                            else if(4 == mbrMgmtChoice){
                                //display all members
                            }
                            mbrMgmtChoice = mbrMgmtMenu();
                        }
                        pvdrChoice = pvdrMainMenu();
                    }

                    //if user selects Bill Member for Service
                    else if(2 == pvdrChoice){
                        int svcChoice = svcMenu();
                        while(3 != svcChoice){
                            //if user chooses to display service codes
                            if(1 == svcChoice){
                                svc.displayAll();
                            }

                            //if user chooses to create service record
                            else if(2 == svcChoice){
                                boolean added = newSvcRec(MDir, svc);

                                if(added)
                                    System.out.print("\n***Service record created***");
                                else
                                    System.out.print("\n***Error creating service record");
                            }
                            svcChoice = svcMenu();
                        }
                        pvdrChoice = pvdrMainMenu();
                    }

                    //if user selects Reporting Menu
                    else if(3 == pvdrChoice){
                        int pvdrReportsChoice = pvdrReportsMenu();
                        while(3 != pvdrReportsChoice){
                            //if user chooses to create member report
                            if(1 == pvdrReportsChoice)
                                MDir.buildReports();

                            //if user chooses to create provider report
                            else if(2 == pvdrReportsChoice)
                                PDir.buildReports();

                            pvdrReportsChoice = pvdrReportsMenu();
                        }
                        pvdrChoice = pvdrMainMenu();
                    }
                }
                choice = 3;  //exit program
            }
        }
    }

    public static int topMenu() {
        int menuOption = 0;

        do {
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

        } while (1 > menuOption || 3 < menuOption);

        return menuOption;
    }

    public static int mgrMainMenu() {
        int menuOption = 0;

        do {
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

        } while (1 > menuOption || 5 < menuOption);

        return menuOption;
    }

    public static int pvdrMainMenu() {
        int menuOption = 0;

        do {
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

        } while (1 > menuOption || 4 < menuOption);

        return menuOption;
    }

    public static int pvdrMgmtMenu() {
        int menuOption = 0;

        do {
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

        } while (1 > menuOption || 5 < menuOption);

        return menuOption;
    }

    public static int mbrMgmtMenu() {
        int menuOption = 0;

        do {
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

        } while (1 > menuOption || 5 < menuOption);

        return menuOption;
    }

    public static int svcMenu() {
        int menuOption = 0;

        do {
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

        } while (1 > menuOption || 3 < menuOption);

        return menuOption;
    }

    public static int mgrReportsMenu() {
        int menuOption = 0;

        do {
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

        } while (1 > menuOption || 4 < menuOption);

        return menuOption;
    }

    public static int pvdrReportsMenu() {
        int menuOption = 0;

        do {
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

        } while (1 > menuOption || 3 < menuOption);

        return menuOption;
    }

    public static int mbrPvdrEditMenu(int choice) {
        int menuOption = 0;

        do {
            System.out.print("\nWhat field would you like to edit?");
            System.out.print("\nPlease choose from the following options:\n");
            System.out.print("\n1 - Last name");
            System.out.print("\n2 - First name");
            System.out.print("\n3 - ID number");
            System.out.print("\n4 - Street address");
            System.out.print("\n5 - City");
            System.out.print("\n6 - State");
            System.out.print("\n7 - Zip code");

            if(1 == choice)
                System.out.print("\n8 - Payment status\n");
            else if(2 == choice)
                System.out.print("\n8 - Authorization level\n");
            System.out.print("\nEnter menu option here: ");

            menuOption = input.nextInt();
            input.nextLine();
            System.out.print("\n");

            if (1 > menuOption || 8 < menuOption)
                System.out.print("***Option out of range***\n");

        } while (1 > menuOption || 8 < menuOption);

        return menuOption;
    }

    public static void getInfo(int choice, String lastName, String firstName, int id, String address, String city, String state, int zip, boolean status) {
        if(1 == choice)
            System.out.print("\n***Add new member***\n");
        else if(2 == choice)
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

        if (1 == choice) {
            System.out.print("Is member current? (Y/N): ");
            char current = input.next().charAt(0);

            while (('Y' != current) && ('y' != current) && ('N' != current) && ('n' != current)){
                System.out.print("\n***Option out of range***\n");
                System.out.print("\nPlease enter Y/N: ");
                current = input.next().charAt(0);
            }

            if(('Y' == current) || ('y' == current))
                status = true;
            else
                status = false;
        }

        else if(2 == choice){
            System.out.print("\nIs the user a manager? (Y/N): ");
            char mgr = input.next().charAt(0);

            while (('Y' != mgr) && ('y' != mgr) && ('N' != mgr) && ('n' != mgr)){
                System.out.print("\n***Option out of range***\n");
                System.out.print("\nPlease enter Y/N: ");
                mgr = input.next().charAt(0);
            }

            if(('Y' == mgr) || ('y' == mgr))
                status = true;
            else
                status = false;
        }
    }

    public static boolean newSvcRec(MDirectory MDir, Service svc) {
        System.out.print("\nPlease enter the 9-digit Member ID: ");
        int id = input.nextInt();
        input.nextLine();

        boolean valid = MDir.verifyMember(id);  //should we make this an int so we can print "invalid, suspended, validated?"
        if(valid) {
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

            svc.displayAll();

            char correct = 'N';
            int svcCode;
            do {
                System.out.print("\nPlease enter the 6-digit service code: ");
                svcCode = input.nextInt();
                input.nextLine();

                boolean found = svc.find(svcCode);
                while (!found) {
                    System.out.print("\n***Invalid service code***");
                    System.out.print("\nPlease enter the 6-digit service code: ");
                    svcCode = input.nextInt();
                    input.nextLine();
                    found = svc.find(svcCode);
                }

                System.out.print("\nYou entered " + svcCode + ".  Is this correct? (Y/N): ");
                correct = input.next().charAt(0);

                while (('Y' != correct) && ('y' != correct) && ('N' != correct) && ('n' != correct)) {
                    System.out.print("\n***Option out of range***\n");
                    System.out.print("\nPlease enter Y/N: ");
                    correct = input.next().charAt(0);
                }
            } while ('N' == correct || 'n' == correct);

            System.out.print("\nPlease add comments regarding the service provided: ");
            String comments = new String();
            comments = input.nextLine();

            boolean addSvc = svc.createServiceRec(month, day, year, svcCode, comments);
            return addSvc;
        }
        return false;
    }
}
