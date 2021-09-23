/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author GjejevetePC
 */
public class CustomerEmployee extends Customer {
     private double discount;
    private double CustomerDiscount;
    private int individualID;
    public static int count = 0;
    private int CustomerID;
     public int Points = 0;
    public double  Bouns = 0; 
    
    public CustomerEmployee() {
      
    }

    
    public CustomerEmployee (String name, String surname, String address, String phoneNumber, double discount, double companyDiscount, int companyID) {
	super(name, surname, address, phoneNumber);
        this.discount = discount;
        this.CustomerDiscount = CustomerDiscount;
        this.CustomerID = CustomerID;
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

    public double getCustomerDiscount() {
        return CustomerDiscount;
    }

    public void setCustomerDiscount(double customerDiscount) {
        this.CustomerDiscount = customerDiscount;
    }

    public int getCustomerID() {
        return CustomerID;
    }

    public void setCustomerID(int customerID) {
        this.CustomerID = customerID;
    }
    
    public double getTotalDiscount(){
        return (discount + CustomerDiscount);
    }

    public double getBouns() {
        return Bouns;
    }

    public void setBouns(double Bouns) {
        this.Bouns = Bouns;
    }

    public int getPoints() {
        return Points;
    }

    public void setPoints(int Points) {
        this.Points = Points;
    }
    
 public double GetBonus(int points)
    {
        double remainder = 0;
        remainder = points/500;
        
        double bonus = remainder * 50;
        
        return bonus;
    }    
    
     public double GetBonus()
    {
        double remainder = 0;
        remainder = getPoints()/500;
        
        double bonus = remainder *50;
        
        return bonus;
    }
    
    
    @Override
    public String toString(){
        return super.toString() + " / Individual ID: " + individualID
                + " / Costumer Employee ID: " + CustomerID
                + " / Total Discount: " + getTotalDiscount() 
                + " / Type: Costumer Employee ";
    }

    
    @Override
    public String printInfo(){
        return toString();
    }
}
