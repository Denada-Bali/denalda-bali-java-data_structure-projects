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


public class LoyalCustomer extends Customer{
    private double discount;
    private int individualID;
    public static int count = 0;
    public int Points = 0;
    public double  Bouns = 0; 

    public LoyalCustomer() { // Empty Constructor- is needed to create a new instance via reflection by your persistence framework. 
      
    }

    //Constructor- is used to initialize the state of an object.
   
  public LoyalCustomer (String name, String surname, String address, String phoneNumber, double discount) {
	super(name, surname, address, phoneNumber);
        this.discount = discount;
        individualID = ++count;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public int getIndividualID() {
        return individualID;
    }
    
    public double getTotalDiscount(){
        return this.getDiscount();
    }

    public int getPoints() {
        return Points;
    }

    public void setPoints(int Points) {
        this.Points = Points;
    }

    public double getBouns() {
        return Bouns;
    }

    public void setBouns(double Bouns) {
        this.Bouns = Bouns;
    }
    
  
    public double GetBonus(int points)
    {
        double remainder = 0;
        remainder = points/100;
        
        double bonus = remainder * 50;
        
        return bonus;
    }
    
      public double GetBonus()
    {
        double remainder = 0;
        remainder = getPoints()/100;
        
        double bonus = remainder * 50;
        
        return bonus;
    }
    
    
    
    @Override
    public String toString(){
        return super.toString() + " / Individual ID: " + individualID
                + " / Discount: " + discount
                + " / Type: Loyal Costumer";
    }
    
   // @Override
    public String printInfo(){
        return toString();
    }
}


