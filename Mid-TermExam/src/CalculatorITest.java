/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author GjejevetePC
 */
// here I have create the class
public class CalculatorITest {

    // I have create methods for all actions as, addition, multiplication,division, 
    // substraction, power,sin,cos and logarithmic function.
    // Where public is modifier, int is return-type, add is method name and (int x, int y) are parameter-list 
    public int add(int x, int y) {
        return x + y;      // and here is body of the method 
    }

    public int mult(int x, int y) {
        return x * y;
    }

    public double div(double x, double y) {
        return x / y;
    }

    public int sub(int x, int y) {
        return x - y;
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
