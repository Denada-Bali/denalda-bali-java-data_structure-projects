/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EX3;

import java.util.Scanner;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author denalda bali
 */
public class HTML {
    
 public static void main(String[] args) throws ListStackH.UnderflowException {
        
TestisValid();

    }

public static void TestisValid() throws ListStackH.UnderflowException {  
    Scanner input = new Scanner(System.in);
	    System.out.println("Check the HTML Program Tags: ");
	    String expression= input.next();
	    
	    System.out.println(isValid(expression));
	    input.close();

    
}
public static boolean isValid(String s) throws ListStackH.UnderflowException {
		char arr[] = s.toCharArray();
		ListStackH<Character> myCh = new ListStackH<Character>();
                Stack<Integer> stack = new Stack<Integer>(); 
		for (Character ch : arr) {
			if (ch == '<' || ch == '<'+'/' || ch == '>') {
				myCh.push(ch);
			} else if (ch == '>') {
				if (myCh.isEmpty() || myCh.peek() != '<') {
					return false;
				} 
				myCh.pop();
			} else if (ch == '/'+'>') {
				if (myCh.isEmpty() ||  myCh.peek() != '<') 
					return false;
				myCh.pop();	
			} else if (ch == '<') {
				if (myCh.isEmpty() ||  myCh.peek() != '<') 
					return false;
				myCh.pop();	
			} else if (ch == '>'+'/') {
				if (myCh.isEmpty() ||  myCh.peek() != '<') 
					return false;
				myCh.pop();
		} else if (ch == '>'+'/') {
				if (myCh.isEmpty() ||  myCh.peek() != '>') 
					return false;
				myCh.pop();
	                     
	}          
    }return stack.isEmpty();
 }
}












	   /*	public static boolean isStringValidHTMLTag(String stringValue) {
		// regex variable to check that string is valid or not
		String regex = "<(\"[^\"]\"|'[^']'|[^'\">])*>";

		// it will com the regex
		Pattern patternObj = Pattern.compile(regex);

		// if value is null tham it will return false
		if (stringValue == null) {
			return false;
		}

		// it will find the match between given string and regex
		Matcher matcherObj = patternObj.matcher(stringValue);

		// it will return if the string matched with regex
		return matcherObj.matches();
	}

	public static void main(String[] args) {
		// First Input
		String firstString = "<input value = '>'>";
	
		// Second Input
		String secondString = "br/>";
		
		// Third Input
		String thirdString = "<'br/>";
	

		// Forth Input
		String forthString = "<input value => >";


	    Scanner input = new Scanner(System.in);
	    System.out.println("Enter String: ");
	    String expression= input.next();
	    
	    System.out.println(isStringValidHTMLTag(expression));
	    input.close();

	}

}*/
