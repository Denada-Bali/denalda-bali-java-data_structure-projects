
import java.util.ArrayList;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author GjejevetePC
 */
public class Restaurant {

    private boolean exit = false;
    private int option;
    Scanner input = new Scanner(System.in);

    private BarRestaurant bar = null;
    private User currentUser;
    private MainDatabase main = new MainDatabase();
    public static ArrayList<User> accounts = new ArrayList<>();
    private Waiter w = new Waiter();
    private static int SelectedTable = 1;

    public void start() {
        bar = new BarRestaurant();
        bar.populateMenu();
        do {
            printMenu();
            Action();

            System.out.println();
        } while (!exit);
    }

    public void Login() {
        System.out.print("Login as: \n"
                + "\t1- Manager \n "
                + "\t2- Waiter \n ");
        int type = input.nextInt();
        if (type == 1) {
            login();
        } else {
            loginAsWaiter();
        }
    }

    private void printMenu() {
        System.out.print("Menu\n"
                + "Choose an option:\n"
                + "\t1 - New table \n"
                + "\t2 - Insert item in table \n"
                + "\t3 - Remove item from table \n"
                + "\t4 - Modify item in table \n"
                + "\t5 - Print information for current table\n"
                + "\t6 - Print information for table with a certain ID\n"
                + "\t7 - Apply discount to table with 10%\n"
                + "\t8 - Overall number of tables for the waiter with a certain username\n"
                + "\t9 - Total amount of all tables processed by the waiter with a certain username \n"
                + "\t10 - Total number of all items processed by the waiter with a certain username  \n"
                + "\t11 - Total amount of all items of the current day \n"
                + "\t12 - Switch program from one waiter to another waiter\n"
                + "\t13 - Switch program from Waiter to Manager and vice-versa\n"
                + "\t14 - Exit\n"
                + "Select an option: ");

        option = input.nextInt();
    }

    private void Action() {
        switch (option) {
            case 1:
                bar = new BarRestaurant();
                SelectedTable = bar.CreateTable(currentUser.getUsername());
                break;
            case 2:
                NewItem();
                break;
            case 3:
                removeItem();
                break;
            case 4:
                ModifyItemInTable();
                break;
            case 5:
                bar = new BarRestaurant();
                bar.PrintItemsOnTable(SelectedTable);
                break;
            case 6:
                PrintSpecificTable();
                break;
            case 7:
                applyDiscountToTable();
                break;
            case 8:
                PrintOverallNrOfTablesForWaiterID();
                break;
            case 9:
                PrintTotalAmountOfTablesForWaiterID();
                break;
            case 10:
                PrintTotalNrOfItemsForWaiterID();
                break;
            case 11:
                PrintTotalNrOfItemForDay();
                break;
            case 12:
                SwitchWaiter();
                break;
            case 13:
                SwitchToManager();
                break;
            case 14:
                exit();
                break;
            default:
                System.out.println("Wrong Input. Enter a number between 1 and 13.");
                break;
        }
    }

    private void login() {
        boolean isAuthenticated = false;

        input.nextLine();
        System.out.println("LOG IN");
        do {
            System.out.println();
            System.out.println("Username: ");
            String username = input.nextLine();
            System.out.println("Password: ");
            String password = input.nextLine();
            currentUser = main.AuthenticateUser(username, password);

            if (currentUser != null) {
                System.out.println("Logging In");
                currentUser = main.getAccount(username);
                isAuthenticated = true;
            } else {
                System.out.println("Invalid Username or Password\n");
                isAuthenticated = false;
            }
        } while (!isAuthenticated);

    }

    private void loginAsWaiter() {
        boolean isAuthenticated = false;

        input.nextLine();
        System.out.println("LOG IN");
        do {
            System.out.println();
            System.out.println("Username: ");
            String username = input.nextLine();
            System.out.println("Password: ");
            String password = input.nextLine();
            currentUser = main.AuthenticateUser(username, password);

            if (currentUser != null) {
                if (currentUser.getUserType() == 2) {
                    System.out.println("Logging In");
                    currentUser = main.getAccount(username);
                    isAuthenticated = true;
                } else {
                    System.out.println("User logged in is not waiter\n");
                    isAuthenticated = false;
                }
            } else {
                System.out.println("Invalid Username or Password\n");
                isAuthenticated = false;
            }
        } while (!isAuthenticated);

    }

    private void NewItem() {

        System.out.println("★★★★★ Welcome to our Restaurant! ★★★★★ \n");
        bar = new BarRestaurant();
        bar.RestaurantMenu();
        System.out.println("Enter ID of food \n");
        int ID = input.nextInt();
        bar.InserItemInTable(SelectedTable, ID);

    }

    private void removeItem() {
        bar = new BarRestaurant();
        bar.PrintItemsOnTable(SelectedTable);
        System.out.println("Enter ID item to delete \n");
        int ID = input.nextInt();
        bar.DeleteItemFromTable(ID, SelectedTable);
        System.out.println("Printing remaining items in table \n");
        bar.PrintItemsOnTable(SelectedTable);

    }

    private void ModifyItemInTable() {
        bar = new BarRestaurant();
        bar.PrintItemsOnTable(SelectedTable);
        System.out.println("Enter ID item to modify \n");
        int ID = input.nextInt();
        bar.DeleteItemFromTable(ID, SelectedTable);

        System.out.println("Enter the id item to add \n");
        bar.RestaurantMenu();
        int idAdd = input.nextInt();
        bar.InserItemInTable(SelectedTable, idAdd);
        bar.PrintItemsOnTable(SelectedTable);

    }

    private void PrintSpecificTable() {
        System.out.println("Enter Table id \n");
        int ID = input.nextInt();
        bar = new BarRestaurant();
        bar.PrintItemsOnTable(ID);
    }

    private void applyDiscountToTable() {
        System.out.println("Applying 10% discount for table");

        bar.PrintItemsWithDiscountTable(SelectedTable);
    }

    private void applyDiscount() {
        System.out.println("Applying 10% discount for loyal customer");
        System.out.print("Enter normal discount rate for CompanyCustomer: ");
        double discount = input.nextDouble();
        System.out.print("Enter Company discount rate for CompnayCustomer: ");
        double CompanyDiscount = input.nextDouble();
        main.applyDiscounts(10, discount, CompanyDiscount);
    }

    private void PrintTotalAmountOfTablesForWaiterID() {
        if (currentUser.getUserType() == 1) {
            System.out.println("Select the waiter to print tables \n");
            ArrayList<User> waiters = main.PrintWaiterList();

            for (int i = 0; i < waiters.size(); i++) {
                System.out.printf("%d - %s \n", waiters.get(i).getID(), waiters.get(i).getName());
            }

            int ID = input.nextInt();
            User selectedWaiter = main.GetUserByID(ID);
            bar = new BarRestaurant();
            double tablesAmount = bar.GetTotalAmountTablesForUsername(selectedWaiter.getUsername());

            System.out.printf("Amount processed by waiter %s = %.2f  \n", selectedWaiter.getUsername(), tablesAmount);
        } else {
            System.out.println("Permision denied. Please login as manager \n");
        }
    }

    private void PrintOverallNrOfTablesForWaiterID() {
        if (currentUser.getUserType() == 1) {
            System.out.println("Select the waiter to print tables \n");
            ArrayList<User> waiters = main.PrintWaiterList();

            for (int i = 0; i < waiters.size(); i++) {
                System.out.printf("%d - %s \n", waiters.get(i).getID(), waiters.get(i).getName());
            }

            int ID = input.nextInt();
            User selectedWaiter = main.GetUserByID(ID);
            bar = new BarRestaurant();
            int tables = bar.GetTablesForUsername(selectedWaiter.getUsername());

            System.out.printf("Waiter %s has  %d tables \n", selectedWaiter.getUsername(), tables);
        } else {
            System.out.println("Permision denied. Please login as manager \n");
        }
    }

    private void PrintTotalNrOfItemsForWaiterID() {
        if (currentUser.getUserType() == 1) {
            System.out.println("Select the waiter to print tables \n");
            ArrayList<User> waiters = main.PrintWaiterList();

            for (int i = 0; i < waiters.size(); i++) {
                System.out.printf("%d - %s \n", waiters.get(i).getID(), waiters.get(i).getName());
            }

            int ID = input.nextInt();
            User selectedWaiter = main.GetUserByID(ID);
            bar = new BarRestaurant();
            int items = bar.GetTotalNumberOfItemsProcessedForUsername(selectedWaiter.getUsername());

            System.out.printf("Waiter %s has processed  %d items in all tables \n", selectedWaiter.getUsername(), items);
        } else {
            System.out.println("Permision denied. Please login as manager \n");
        }
    }

    private void PrintTotalNrOfItemForDay() {
        if (currentUser.getUserType() == 1) {
            System.out.println("Select the waiter to print tables \n");
            ArrayList<User> waiters = main.PrintWaiterList();

            for (int i = 0; i < waiters.size(); i++) {
                System.out.printf("%d - %s \n", waiters.get(i).getID(), waiters.get(i).getName());
            }

            int ID = input.nextInt();
            User selectedWaiter = main.GetUserByID(ID);
            bar = new BarRestaurant();
            double itemsAmount = bar.GetTotalAmountsOfItemsProcessedForUsername(selectedWaiter.getUsername());

            System.out.printf("Waiter %s total items amount processed =  %.2f  \n", selectedWaiter.getUsername(), itemsAmount);
        } else {
            System.out.println("Permision denied. Please login as manager \n");
        }
    }

    private void SwitchWaiter() {

        if (currentUser.getUserType() == 1) {
            System.out.println("Currently Loggedin as Manager");
            System.out.println("Switch to Waiter");
            loginAsWaiter();
        } else if (currentUser.getUserType() == 2) {
            System.out.println("Currently Loggedin as " + currentUser.getName());
            System.out.println("Login as other waiter");
            loginAsWaiter();
        }

    }

    private void SwitchToManager() {

        if (currentUser.getUserType() == 1) {
            System.out.println("Currently Loggedin as Manager");
            System.out.println("Switch to Waiter");
        } else {
            System.out.println("Currently Loggedin as Waiter");
            System.out.println("Switch to Manager");
        }

        login();
    }

    private void exit() {
        System.out.println("Closing the Program.");
        exit = true;
    }

}
