

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author GjejevetePC
 */
import java.lang.Math;
import javax.swing.JPanel;

// here I have create the class
public class CalculatorIIGUITest extends JPanel {

    // I have create methods for all actions
    int add(int x, int y) // Where public is modifier, int is return-type, add is method name and (int x, int y) are parameter-list
    {
        int z;
        z = x + y;        // and here is body of the method 
        return z;
    }

    public int mult(int x, int y) {
        int z;
        z = x * y;
        return z;
    }

    public double div(double x, double y) {
        double z;
        z = x / y;
        return z;
    }

    public int sub(int x, int y) {
        int z;
        z = x - y;
        return z;
    }

    public int pow(int base, int exponent) {
        int result;
        result = (int) Math.pow(base, exponent);
        return result;
    }

    public double sin(double x) {
        return Math.toRadians(x);
    }

    public double cos(double x) {
        return Math.toRadians(x);
    }

    public double logb(double base, double num) {
        return Math.log(base) / Math.log(num);
    }
}
