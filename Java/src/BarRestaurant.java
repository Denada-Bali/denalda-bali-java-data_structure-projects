
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author GjejevetePC
 */
public class BarRestaurant {

    private static ArrayList<Item> items = new ArrayList<Item>();
    private static ArrayList<Table> tableList = new ArrayList<Table>();

    public int CreateTable(String Username) {
        Table tb = new Table();
        tb.setId(tableList.size() + 1);
        tb.setUsername(Username);
        tableList.add(tb);
        System.out.printf("Table %d was created \n", tb.getId());
        return tb.getId();
    }

    public void PrintItemsOnTable(int tableid) {

        Table selectedTable = GetTableByID(tableid);
        if (selectedTable != null) {
            ArrayList<Item> listItems = GetTableByID(tableid).getListOfItems();

            System.out.println("Items in table");
            for (int i = 0; i < listItems.size(); i++) {
                System.out.printf("%d - %s - %.2f  \n", listItems.get(i).getId(), listItems.get(i).getName(), listItems.get(i).getPrice());
            }
        } else {
            System.out.printf("Table id not found");
        }

    }

    public void PrintItemsWithDiscountTable(int tableid) {
        Double amount = 0.0;
        Table selectedTable = GetTableByID(tableid);
        if (selectedTable != null) {
            ArrayList<Item> listItems = GetTableByID(tableid).getListOfItems();

            System.out.println("Items in table");
            for (int i = 0; i < listItems.size(); i++) {
                System.out.printf("%d - %s - %.2f  \n", listItems.get(i).getId(), listItems.get(i).getName(), listItems.get(i).getPrice());
                amount = amount + listItems.get(i).getPrice();
            }

            Double amountDiscount = amount - (amount * 0.1);
            System.out.printf("Total Amount: %.2f \n", amount);
            System.out.printf("Total Amount with discount: %.2f \n", amountDiscount);

        } else {
            System.out.printf("Table id not found");
        }

    }

    public void DeleteItemFromTable(int id, int tableid) {
        Item itm = GetItemByID(id);
        if (itm != null) {

            ArrayList<Item> listItems = GetTableByID(tableid).getListOfItems();
            GetTableByID(tableid).setTotalAmount(GetTableByID(tableid).getTotalAmount() - itm.getPrice());
            listItems.remove(itm);
            System.out.println("Item removed");
        } else {
            System.out.printf("Item not found");
        }
    }

    public Item GetItemByID(int id) {
        for (Item element : items) {
            if (element.getId() == id) {
                return element;
            }
        }
        return null;
    }

    public int GetItemIndexByID(int id) {

        for (int i = 0; i < items.size(); i++) {

            if (items.get(i).getId() == id) {
                return i;
            }
        }
        return 0;
    }

    public Table GetTableByID(int id) {

        for (Table element : tableList) {
            if (element.getId() == id) {
                return element;
            }
        }
        return null;
    }

    public int GetTablesForUsername(String username) {

        int tableCount = 0;
        for (Table element : tableList) {
            if (element.getUsername() == username) {
                tableCount = tableCount + 1;

            }
        }
        return tableCount;
    }

    public double GetTotalAmountTablesForUsername(String username) {

        int tableCount = 0;
        double totalAmount = 0.0;
        for (Table element : tableList) {
            if (element.getUsername() == username) {
                tableCount = tableCount + 1;
                totalAmount = totalAmount + element.getTotalAmount();

            }
        }
        return totalAmount;
    }

    public int GetTotalNumberOfItemsProcessedForUsername(String username) {

        int itemProcecessed = 0;

        for (Table element : tableList) {
            if (element.getUsername() == username) {
                itemProcecessed = itemProcecessed + element.getListOfItems().size();

            }
        }
        return itemProcecessed;
    }

    public double GetTotalAmountsOfItemsProcessedForUsername(String username) {

        double totalAmount = 0.0;
        for (Table element : tableList) {
            if (element.getUsername() == username) {

                for (Item itm : element.getListOfItems()) {
                    totalAmount = totalAmount + itm.getPrice();
                }

            }
        }
        return totalAmount;
    }

    public void InserItemInTable(int tableid, int itemid) {
        Item selectedItem = GetItemByID(itemid);
        if (selectedItem != null) {

            GetTableByID(tableid).AddItemsOnList(selectedItem);
            GetTableByID(tableid).setTotalAmount(GetTableByID(tableid).getTotalAmount() + selectedItem.getPrice());
            System.out.printf("%s was added on table %d \n", selectedItem.getName(), tableid);
        } else {
            System.out.printf("Item was not found");
        }
    }

    public void OverallTable(int id, String Username) {
        Table tb = new Table();
        for (Table element : tableList) {
            if (element.getId() == id) {
                tb.setUsername(Username);
                System.out.printf("Number of table %d created by %s \n", tb.getUsername());
            }
        }
    }

    public void populateMenu() {

        items.add(new Item("Bruschetta", 1, 9, 1));
        items.add(new Item("French Fries", 2, 6, 1));
        items.add(new Item("Pizza Bread", 3, 4.95, 1));
        items.add(new Item("Garlic Bread", 4, 2.50, 1));
        items.add(new Item("Marinara Sauce", 5, 3.95, 1));
        items.add(new Item("Meat Sauce", 6, 6.95, 1));

        items.add(new Item("Pepperoni Pizza", 7, 6, 2));
        items.add(new Item("Cheese Pizza", 8, 6.5, 2));
        items.add(new Item("Deluxe Pizza", 9, 12, 2));
        items.add(new Item("Chicken Supreme Pizza", 10, 12, 2));
        items.add(new Item("Margarita", 11, 10, 2));
        items.add(new Item("Tuna and Sweetcorn Flatbread", 12, 8, 2));

        items.add(new Item("Waffles", 13, 11, 2));
        items.add(new Item("Cheesy Cake", 14, 15, 2));
        items.add(new Item("Tiramisu", 15, 5.75, 2));
        items.add(new Item("Vanilla Cheesecake", 16, 12, 2));
        items.add(new Item("Panna Cotta", 17, 8, 2));
        items.add(new Item("Cannoli", 18, 4, 2));

        items.add(new Item("Water", 19, 1, 2));
        items.add(new Item("Pepsi ", 20, 2.85, 2));
        items.add(new Item("7up Free ", 21, 2.85, 2));
        items.add(new Item("Apple Juice ", 22, 3.25, 2));
        items.add(new Item("Dom Perignon ", 23, 179, 2));
        items.add(new Item("Jack Daniels ", 24, 130, 2));
    }

    public void RestaurantMenu() {

        System.out.print("------ Items ------ \n");
        for (int i = 0; i < items.size(); i++) {
            System.out.printf("%d - %s - %.2f \n", items.get(i).getId(), items.get(i).getName(), items.get(i).getPrice());
        }
    }
}
