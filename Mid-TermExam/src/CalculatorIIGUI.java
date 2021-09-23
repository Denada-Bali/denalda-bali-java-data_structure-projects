/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author GjejevetePC
 */
import java.util.Scanner;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class CalculatorIIGUI {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int num1, num2, result, selection; // Declare variables type int
        double result1;                    // Declare variables of doubletype for float and intigers numbers
        selection = getMenuselection();   //Function call to select operation from menu 

        while (selection != 9) {  //I have call a cycle While where selection is not equal with 9 
            // I have create the object of CalculatorIIGUITest using new CalculatorIIGUITest
            CalculatorIIGUITest calc = new CalculatorIIGUITest();

            if (selection == 1) {
                String number1 = JOptionPane.showInputDialog("Enter first number:  ");
                String number2 = JOptionPane.showInputDialog("Enter second number:  ");
                num1 = Integer.parseInt(number1);
                num2 = Integer.parseInt(number2);
                result = calc.add(num1, num2);   // I have call class method for addition 
                JOptionPane.showMessageDialog(null, +num1 + " + " + num2 + " = " + result, "The answer ", JOptionPane.PLAIN_MESSAGE);

            } else if (selection == 2) {
                String number1 = JOptionPane.showInputDialog("Enter first number:  ");
                String number2 = JOptionPane.showInputDialog("Enter second number:  ");
                num1 = Integer.parseInt(number1);
                num2 = Integer.parseInt(number2);
                result = calc.mult(num1, num2); // I have call class method for multiplication
                JOptionPane.showMessageDialog(null, +num1 + " * " + num2 + " = " + result, "The Result ", JOptionPane.PLAIN_MESSAGE);

            } else if (selection == 3) {
                String number1 = JOptionPane.showInputDialog("Enter first number:  ");
                String number2 = JOptionPane.showInputDialog("Enter second number:  ");
                num1 = Integer.parseInt(number1);
                num2 = Integer.parseInt(number2);
                if (num2 == 0) {
                    JOptionPane.showMessageDialog(null, +num1 + " / " + num2 + " = Undefined");
                } else {
                    result1 = calc.div(num1, num2); // I have call class method for division
                    JOptionPane.showMessageDialog(null, +num1 + " / " + num2 + " = " + result1, "The Result ", JOptionPane.PLAIN_MESSAGE);
                }
            } else if (selection == 4) {
                String number1 = JOptionPane.showInputDialog("Enter first number:  ");
                String number2 = JOptionPane.showInputDialog("Enter second number:  ");
                num1 = Integer.parseInt(number1);
                num2 = Integer.parseInt(number2);
                result = calc.sub(num1, num2); // I have call class method for substraction
                JOptionPane.showMessageDialog(null, +num1 + " - " + num2 + " = " + result, "The Result ", JOptionPane.PLAIN_MESSAGE);

            } else if (selection == 5) {
                String number1 = JOptionPane.showInputDialog("Enter base:  ");
                String number2 = JOptionPane.showInputDialog("Enter exponent:  ");
                num1 = Integer.parseInt(number1);
                num2 = Integer.parseInt(number2);
                result = calc.pow(num1, num2); // I have call class method for power
                JOptionPane.showMessageDialog(null, +num1 + "^ " + num2 + " = " + result, "The Result ", JOptionPane.PLAIN_MESSAGE);

            } else if (selection == 6) {
                String number1 = JOptionPane.showInputDialog("Enter one number:  ");
                num1 = Integer.parseInt(number1);
                result1 = Math.sin(Math.toRadians(num1));// I have call class method for sin
                JOptionPane.showMessageDialog(null, "sin " + num1 + "°" + " = " + result1, "The Result ", JOptionPane.PLAIN_MESSAGE);

            } else if (selection == 7) {
                String number1 = JOptionPane.showInputDialog("Enter one number:  ");
                num1 = Integer.parseInt(number1);
                result1 = Math.cos(Math.toRadians(num1)); // I have call class method for cos
                JOptionPane.showMessageDialog(null, "cos " + num1 + "°" + " = " + result1, "The Result ", JOptionPane.PLAIN_MESSAGE);

            } else if (selection == 8) {
                String number1 = JOptionPane.showInputDialog("Enter number :  ");
                String number2 = JOptionPane.showInputDialog("Enter base :  ");
                num1 = Integer.parseInt(number1);
                num2 = Integer.parseInt(number2);
                result1 = calc.logb(num1, num2); // I have call class method for logarithmic function
                JOptionPane.showMessageDialog(null, "Logarithm " + num1 + " with base " + num2 + " = " + result1, "The Result ", JOptionPane.PLAIN_MESSAGE);
            }
            //The function here returns the menu of choice after first selection
            selection = getMenuselection();
        }
    }
// here I have create a function that prints a menu and returns a value corresponding to the menu choice

    private static int getMenuselection() {
        Scanner input = new Scanner(System.in);
        //ImageIcon is an implementation of the Icon interface, icon is object 
        ImageIcon icon = new ImageIcon("src/exit-icon1.png"); // the location where the icon is placed 
        int selection;
        String choice = JOptionPane.showInputDialog("Menu of Choice\n1-Addition \n2-Multiplication\n3-Division "
                + "\n4-Substraction \n5-Power \n6-sin\n7-cos\n8-log\nPress (-1) to exit");
        selection = Integer.parseInt(choice);

        // I have use a cycle if-else. If user press -1, program will closed 
        // and if it press a wrong choice, program will print the mesage bellow and will return the menu of choice  
        if (selection == -1) {                                                                 // I called the icon here
            JOptionPane.showMessageDialog(null, "Thank You !", " Exit...", JOptionPane.INFORMATION_MESSAGE, icon);
            System.exit(0);
        } else if (selection > 8 || selection < 1) {
            JOptionPane.showMessageDialog(null, "Wrong Choice !", " Oops! ", JOptionPane.ERROR_MESSAGE);
            // Here I have call again the function because if the user press a wronge choice, program will print again menu of choice 
            selection = getMenuselection();
        }
        return selection;
    }
}
