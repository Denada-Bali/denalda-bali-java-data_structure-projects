
import java.util.ArrayList;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author GjejevetePC
 */
public class TableCompany extends Table {
    
   private final int id = 0;
   private double netAmount;  
   private double totalAmount;    
   private double VAT;
   private ArrayList<Item> listOfItems;
   public static int count = 0;
   private double NumberOfTimesServed;
   
     public TableCompany() {  // Empty Constructor- is needed to create a new instance via reflection by your persistence framework. 
      
    }
     //Constructor- is used to initialize the state of an object.
        public TableCompany(final double netAmount, final double totalAmount, final double vAT, final ArrayList<Item> listOfItems,final double NumberOfTimesServed) {

        super(); //Superclass constructor to initialize the instance variables inherited from the superclass

        this.netAmount = netAmount;
        this.totalAmount = totalAmount;
        VAT = vAT;
        this.listOfItems = listOfItems;
        this.NumberOfTimesServed = NumberOfTimesServed;
    }

    public double getNetAmount() {
        return netAmount;
    }

    public void setNetAmount(double netAmount) {
        this.netAmount = netAmount;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public double getVAT() {
        return VAT;
    }

    public void setVAT(double VAT) {
        this.VAT = VAT;
    }

    public ArrayList<Item> getListOfItems() {
        return listOfItems;
    }

    public void setListOfItems(ArrayList<Item> listOfItems) {
        this.listOfItems = listOfItems;
    }

    public double getNumberOfTimesServed() {
        return NumberOfTimesServed;
    }

    public void setNumberOfTimesServed(double NumberOfTimesServed) {
        this.NumberOfTimesServed = NumberOfTimesServed;
    }
    
    
     public double NumberOfTimesServed(int items){
     
     double FreeTable = 0;
     FreeTable = items/3;
     return FreeTable;
     }
     
    public double NumberOfTimesServed(){
         double FreeTable = 0;
          FreeTable = NumberOfTimesServed()/3;
           return FreeTable;
    }
}
