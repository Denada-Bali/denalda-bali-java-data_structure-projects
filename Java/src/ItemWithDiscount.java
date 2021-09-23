
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
    public class ItemWithDiscount extends Item{

    public ItemWithDiscount(String name, int id, double price) {
        super(name, id, price);
    }
    
    public static double calculateDiscount( double ItemPrice, int discount ){ 
    	Scanner input =new Scanner(System.in);
        
    System.out.println("Discount Precent: ");
    int discoutn1=input.nextInt();
    double finalPrice = (ItemPrice * discount) / 100;
    
      System.out.println(ItemPrice + " = " + discount);
    System.out.println(" Total = " + finalPrice );
    return finalPrice;
    }
    public void printInfo(){
        System.out.println(toString());
    }
}
