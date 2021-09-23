import java.util.ArrayList;
import java.util.Date;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author GjejevetePC
 */
public class Table {
     
    private int id;
    private double netAmount;
    private double totalAmount;
    private double VAT;
    private ArrayList<Item> listOfItems;
    private Date dateAndTimeOfPurchase;
    private String addressOfTheRestaurant;
    private String nameOfCashier;
    private String Username;

    public String getUsername() {
        return Username;
    }

    public void setUsername(String Username) {
        this.Username = Username;
    }
    public Table() {

        super();
listOfItems = new ArrayList<>();
    

    }
//Constructor- is used to initialize the state of an object.
    public Table(final double netAmount, final double totalAmount, final double vAT, final ArrayList<Item> listOfItems,
            final Date dateAndTimeOfPurchase, final String addressOfTheRestaurant, final String nameOfCashier) {

        super();

        this.netAmount = netAmount;
        this.totalAmount = totalAmount;
        VAT = vAT;
        this.listOfItems = listOfItems;
        this.dateAndTimeOfPurchase = dateAndTimeOfPurchase;
        this.addressOfTheRestaurant = addressOfTheRestaurant;
        this.nameOfCashier = nameOfCashier;
    }
    
    public void AddItemsOnList(Item itm)
    {
        if(listOfItems == null)
        {
            listOfItems = new ArrayList<>();
         }
        else
        {
           listOfItems.add(itm);
           
        }
        
    }

    public double getNetAmount() {
        return netAmount;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public double getVAT() {
        return VAT;
    }

    public ArrayList<Item> getListOfItems() {
        return listOfItems;
    }

    public Date getDateAndTimeOfPurchase() {
        return dateAndTimeOfPurchase;
    }

    public String getAddressOfTheBarOrRestaurant() {
        return addressOfTheRestaurant;
    }

    public String getNameOfCashier() {
        return nameOfCashier;
    }

    public void setNetAmount(final double netAmount) {
        this.netAmount = netAmount;
    }

    public void setTotalAmount(final double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public void setVAT(final double vAT) {
        VAT = vAT;
    }

    public void setListOfItems(final ArrayList<Item> listOfItems) {
        this.listOfItems = listOfItems;
    }

    public void setDateAndTimeOfPurchase(final Date dateAndTimeOfPurchase) {
        this.dateAndTimeOfPurchase = dateAndTimeOfPurchase;
    }

    public void setAddressOfTheBarOrRestaurant(final String addressOfTheBarOrRestaurant) {
        this.addressOfTheRestaurant = addressOfTheBarOrRestaurant;
    }

    public void setNameOfCashier(final String nameOfCashier) {
        this.nameOfCashier = nameOfCashier;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setAddressOfTheRestaurant(String addressOfTheRestaurant) {
        this.addressOfTheRestaurant = addressOfTheRestaurant;
    }
}
