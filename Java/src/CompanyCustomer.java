/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author GjejevetePC
 */
public class CompanyCustomer extends Customer{
    private double discount;
    private double companyDiscount;
    private int individualID;
    public static int count = 0;
    private int companyID;
     public int Points = 0;
    public double  Bouns = 0; 
    
    public CompanyCustomer() {
      
    }

    
    public CompanyCustomer (String name, String surname, String address, String phoneNumber, double discount, double companyDiscount, int companyID) {
	super(name, surname, address, phoneNumber);
        this.discount = discount;
        this.companyDiscount = companyDiscount;
        this.companyID = companyID;
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

    public double getCompanyDiscount() {
        return companyDiscount;
    }

    public void setCompanyDiscount(double companyDiscount) {
        this.companyDiscount = companyDiscount;
    }

    public int getCompanyID() {
        return companyID;
    }

    public void setCompanyID(int companyID) {
        this.companyID = companyID;
    }
    
    public double getTotalDiscount(){
        return (discount + companyDiscount);
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
        remainder = points/300;
        
        double bonus = remainder * 100;
        
        return bonus;
    }    
    
     public double GetBonus()
    {
        double remainder = 0;
        remainder = getPoints()/300;
        
        double bonus = remainder *100;
        
        return bonus;
    }
    
    
    @Override
    public String toString(){
        return super.toString() + " / Individual ID: " + individualID
                + " / Company ID: " + companyID
                + " / Total Discount: " + getTotalDiscount() 
                + " / Type: Company Costumer";
    }

    
    @Override
    public String printInfo(){
        return toString();
    }
}


