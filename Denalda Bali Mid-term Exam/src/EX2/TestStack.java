/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EX2;

import java.util.Locale;
import java.util.Scanner;
import java.util.Stack;

/**
 *
 * @author denalda bali
 */
public class TestStack {

    public static void main(String[] args) throws ArrayStack.UnderflowException, ListStack.UnderflowException {

        TestParenthesis();
    }

    public static void TestParenthesis() throws ListStack.UnderflowException {
        Scanner input = new Scanner(System.in);
        System.out.println("Check Parenthesis: ");
        String inputParenthesis = input.next();

        System.out.println(CheckParenthesis(inputParenthesis));

    }

    public static boolean CheckParenthesis(String s) throws ListStack.UnderflowException {
        char arr[] = s.toCharArray();
        ListStack<Character> myCh = new ListStack<Character>();
        Stack<Integer> stack = new Stack<Integer>();
        for (Character ch : arr) {
            if (ch == '{' || ch == '[' || ch == '(') {
                myCh.push(ch);
            } else if (ch == ']') {
                if (myCh.isEmpty() || myCh.peek() != '[' ) {
                    return false;
                }
                myCh.pop();
            }  else if (ch == ')') {
                  if (myCh.isEmpty() || myCh.peek() != '(' ) {
                    return false;
                }
                myCh.pop();
            }  else if (ch == '}') {
                  if (myCh.isEmpty() || myCh.peek() != '{' ) {
                    return false;
                }
                myCh.pop();
            } 
        
    }return stack.isEmpty();
}
}
    

