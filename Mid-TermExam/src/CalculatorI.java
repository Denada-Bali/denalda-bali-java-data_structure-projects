
import java.util.Scanner;  // I have call the scanner class 


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author GjejevetePC
 */
public class CalculatorI {

    public static void main(String[] args) {
        // I have declare the object and I have initialize with predefined standard input object
        Scanner input = new Scanner(System.in);
        int num1, num2, nr1, nr2, result, selection;    // I have declare variables 
        double result1;

        selection = getMenuselection(); //Here I have call the function
        //I have call a cycle While  that allows code to be executed repeatedly based on a given Boolean condition.
        // That in my case selection is not equal with 9 
        while (selection != 9) {
// I have create the object of CalculatorITest using new CalculatorITest
            CalculatorITest calc = new CalculatorITest();
//I have call a cycle if-else for "selection" , for each "selection " the program will require the corresponding type of input that user will chose 
            if (selection == 1) {
                System.out.println("Enter two number:   ");
                num1 = input.nextInt();
                num2 = input.nextInt();
                result = calc.add(num1, num2);  // I have call class method for addition 
                System.out.println("Answer of: " + num1 + " + " + num2 + " = " + result);

            } else if (selection == 2) {
                System.out.println("Enter two number:   ");
                num1 = input.nextInt();
                num2 = input.nextInt();
                result = calc.mult(num1, num2); // I have call class method for multiplication
                System.out.println("Answer of: " + num1 + " * " + num2 + " = " + result);

            } else if (selection == 3) {
                System.out.println("Enter two number:   ");
                num1 = input.nextInt();
                num2 = input.nextInt();
                if (num2 == 0) { // if condition to print Undefined mesage for division by zero 
                    System.out.println(+num1 + " / " + num2 + " = Undefined");
                } else {
                    result1 = calc.div(num1, num2);// I have call class method for division
                    System.out.println("Answer of: " + num1 + " / " + num2 + " = " + result1);
                }
            } else if (selection == 4) {
                System.out.println("Enter two number:   ");
                num1 = input.nextInt();
                num2 = input.nextInt();
                result = calc.sub(num1, num2);// I have call class method for substraction
                System.out.println("Answer of: " + num1 + " - " + num2 + " = " + result);

            } else if (selection == 5) {
                System.out.println("Enter base and exponent:   ");
                num1 = input.nextInt();
                num2 = input.nextInt();
                result = calc.pow(num1, num2);// I have call class method for power
                System.out.println("Answer of: " + num1 + " ^ " + num2 + " = " + result);

            } else if (selection == 6) {

                System.out.println("Enter one number:   ");
                num1 = input.nextInt();
                result1 = Math.sin(Math.toRadians(num1)); // I have call class method for sin
                System.out.printf("Answer of sin " + num1 + "°" + " =  %.1f", result1);

            } else if (selection == 7) {
                System.out.println("Enter one number: ");
                num1 = input.nextInt();
                result1 = Math.cos(Math.toRadians(num1)); // I have call class method for cos
                System.out.printf("Answer of cos " + num1 + "°" + " =  %.1f", result1);

            } else if (selection == 8) {
                System.out.println("Enter number and base:   ");
                num1 = input.nextInt();
                num2 = input.nextInt();
                result1 = calc.logb(num1, num2); // I have call class method for logarithmic function 
                System.out.printf("Logarithm " + num1 + " with base " + num2 + " = %.2f", result1);
                System.out.println("\n");
            }
            //The function here returns the menu of choice after first selection          
            selection = getMenuselection();
        }
    }

    // here I have create a function that prints a menu and returns a value corresponding to the menu choice
    private static int getMenuselection() {
        Scanner input = new Scanner(System.in);
        int selection;
        System.out.println("\nMenu of choice: ");
        System.out.println(" 1-Addition ");
        System.out.println(" 2-Multiplication");
        System.out.println(" 3-Division  ");
        System.out.println(" 4-Substraction ");
        System.out.println(" 5-Power ");
        System.out.println(" 6-sin ");
        System.out.println(" 7-cos ");
        System.out.println(" 8-log ");
        System.out.println("Press -1 to end the program ");
        selection = input.nextInt();
        System.out.println("****************************************");

        // I have used if-else cycle, if user press -1 program will closed 
        // and if it press a wrong choice, program will print the mesage bellow and will return the menu of choice    
        if (selection == -1) {
            System.out.println("The Program is Closed \n");
            System.exit(0);
        } else if (selection > 8 || selection < 1) {
            System.out.println(" Wrong Choice! Try Again.. \n ");
            // Here I have call again the function because if the user press a wronge choice, program will print again menu of choice 
            selection = getMenuselection();
        }
        return selection;
    }
}
