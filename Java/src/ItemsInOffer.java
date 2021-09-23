
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
    public class ItemsInOffer extends Item {

    public ItemsInOffer(String name,int id, double price) {
        super(name, id, price);
    }

    public static double BuyMorePayLess(double price, int size) {
        Scanner input = new Scanner(System.in);

        System.out.println("Price of Item: ");
        price = input.nextInt();

        System.out.println("The quantity of Item: ");
        size = input.nextInt();

        if (size == 3) {
            double finalPrice = price + price;
            System.out.println("you get these for: " + finalPrice);

        } else if (size == 4) {
            double finalPrice = price + price + price;
            System.out.println("you get these for: " + finalPrice);

        } else if (size == 5) {
            double finalPrice = price + price + price;
            System.out.println("you get these for: " + finalPrice);

        } else if (size == 6) {
            double finalPrice = price + price + price + price + price;
            System.out.println("you get these for: " + finalPrice);

        } else if (size == 7) {
            double finalPrice = price + price + price + price + price + price;
            System.out.println("you get these for: " + finalPrice);
        }
        return price;
    }
}

