import java.util.*;
import chocan.*;

public class Menu {
    public static void main(String[] args)
    {
        System.out.println("Welcome to ChocAn Data Processing System");
    }

        public static int topMenu () {
        int menuOption = 0;

        Scanner input = new Scanner(System.in); // Fix for input errors

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

        public static int mgrMainMenu () {
        int menuOption = 0;
        Scanner input = new Scanner(System.in); // Fix for input errors

        do {
            System.out.print("\nPlease choose from the following options:\n");
            System.out.print("\n1 - Provider Management");
            System.out.print("\n2 - Member Management");
            System.out.print("\n3 - Bill Member for Service");
            System.out.print("\n4 - Reporting Menu");
            System.out.print("\n5 - Exit Program");
            System.out.print("\nEnter menu option here: ");

            menuOption = input.nextInt();
            input.nextLine();
            System.out.print("\n");

            if (1 > menuOption || 5 < menuOption)
                System.out.print("***Option out of range***\n");

        } while (1 > menuOption || 5 < menuOption);

        return menuOption;
    }

        public static int pvdrMainMenu () {
        int menuOption = 0;
        Scanner input = new Scanner(System.in); // Fix for input errors

        do {
            System.out.print("\nPlease choose from the following options:\n");
            System.out.print("\n1 - Member Management");
            System.out.print("\n2 - Bill Member for Service");
            System.out.print("\n3 - Reporting Menu");
            System.out.print("\n4 - Exit Program");
            System.out.print("\nEnter menu option here: ");

            menuOption = input.nextInt();
            input.nextLine();
            System.out.print("\n");

            if (1 > menuOption || 4 < menuOption)
                System.out.print("***Option out of range***\n");

        } while (1 > menuOption || 4 < menuOption);

        return menuOption;
    }

        public static int pvdrMgmtMenu () {
        int menuOption = 0;
        Scanner input = new Scanner(System.in); // Fix for input errors

        do {
            System.out.print("\nPlease choose from the following options:\n");
            System.out.print("\n1 - Add Provider");
            System.out.print("\n2 - Delete Provider");
            System.out.print("\n3 - Edit Provider");
            System.out.print("\n4 - Return to Main Menu");
            System.out.print("\nEnter menu option here: ");

            menuOption = input.nextInt();
            input.nextLine();
            System.out.print("\n");

            if (1 > menuOption || 4 < menuOption)
                System.out.print("***Option out of range***\n");

        } while (1 > menuOption || 4 < menuOption);

        return menuOption;
    }

        public static int mbrMgmtMenu () {
        int menuOption = 0;
        Scanner input = new Scanner(System.in); // Fix for input errors

        do {
            System.out.print("\nPlease choose from the following options:\n");
            System.out.print("\n1 - Add Member");
            System.out.print("\n2 - Delete Member");
            System.out.print("\n3 - Edit Member");
            System.out.print("\n4 - Return to Main Menu");
            System.out.print("\nEnter menu option here: ");

            menuOption = input.nextInt();
            input.nextLine();
            System.out.print("\n");

            if (1 > menuOption || 4 < menuOption)
                System.out.print("***Option out of range***\n");

        } while (1 > menuOption || 4 < menuOption);

        return menuOption;
    }

        public static int svcMenu () {
        int menuOption = 0;
        Scanner input = new Scanner(System.in); // Fix for input errors

        do {
            System.out.print("\nPlease choose from the following options:\n");
            System.out.print("\n1 - Display Service Codes");
            System.out.print("\n2 - Create Service Record");
            System.out.print("\n3 - Return to Main Menu");
            System.out.print("\nEnter menu option here: ");

            menuOption = input.nextInt();
            input.nextLine();
            System.out.print("\n");

            if (1 > menuOption || 3 < menuOption)
                System.out.print("***Option out of range***\n");

        } while (1 > menuOption || 3 < menuOption);

        return menuOption;
    }

        public static int mgrReportsMenu () {
        int menuOption = 0;
        Scanner input = new Scanner(System.in); // Fix for input errors

        do {
            System.out.print("\nPlease choose from the following options:\n");
            System.out.print("\n1 - Create Member Report");
            System.out.print("\n2 - Create Provider Report");
            System.out.print("\n3 - Create Management Report");
            System.out.print("\n4 - Return to Main Menu");
            System.out.print("\nEnter menu option here: ");

            menuOption = input.nextInt();
            input.nextLine();
            System.out.print("\n");

            if (1 > menuOption || 4 < menuOption)
                System.out.print("***Option out of range***\n");

        } while (1 > menuOption || 4 < menuOption);

        return menuOption;
    }

        public static int pvdrReportsMenu () {
        int menuOption = 0;
        Scanner input = new Scanner(System.in); // Fix for input errors

        do {
            System.out.print("\nPlease choose from the following options:\n");
            System.out.print("\n1 - Create Member Report");
            System.out.print("\n2 - Create Provider Report");
            System.out.print("\nEnter menu option here: ");

            menuOption = input.nextInt();
            input.nextLine();
            System.out.print("\n");

            if (1 > menuOption || 2 < menuOption)
                System.out.print("***Option out of range***\n");

        } while (1 > menuOption || 2 < menuOption);

        return menuOption;
    }
}
