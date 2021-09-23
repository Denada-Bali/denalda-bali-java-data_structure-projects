
import java.util.ArrayList;
import java.util.Date;
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
public class TableFidelity extends Table {
    private final int id = 0;
    private double netAmount;
    private double totalAmount;
     private double VAT;
    private ArrayList<Item> listOfItems;
    public static int count = 0;
     public int Points = 0;

     public TableFidelity() { // Empty Constructor- is needed to create a new instance via reflection by your persistence framework. 
      
    }
     //Constructor- is used to initialize the state of an object.
        public TableFidelity(final double netAmount, final double totalAmount, final double vAT, final ArrayList<Item> listOfItems) {

        super();

        this.netAmount = netAmount;
        this.totalAmount = totalAmount;
        VAT = vAT;
        this.listOfItems = listOfItems;
    }
     
    public int getPoints() {
        return Points;
    }

    public void setPoints(int Points) {
        this.Points = Points;
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
     
      public double GetPoints(int points){
      
         double bonus = 0;
         bonus =  points / 10;
         
          return bonus;
      }
     public double GetPoints()
     {    
      double bonus = 0;
      bonus= GetPoints()/10;
      
       return bonus;
     }
    
}
