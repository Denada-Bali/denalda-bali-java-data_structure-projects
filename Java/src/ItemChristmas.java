
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
    public class ItemChristmas extends Item {

    public ItemChristmas(String name, int id, double price) {
        super(name, id, price);
    }
     public static double calculateChristmasDiscount ( double ItemPrice, int discount, double ChDiscount ){ 
    	Scanner input =new Scanner(System.in);
        discount=10/100;
        
    System.out.println("Discount Precent: ");
    int discoutn2=input.nextInt();
    double  finalPrice = (ItemPrice * discount *ChDiscount ) / 100;
    
      System.out.println(ItemPrice + " = " + discount);
    System.out.println(" Total = " + finalPrice );
    return finalPrice;
     }

  
     
  public void printInfo(){
        System.out.println(toString());
    }  
}

