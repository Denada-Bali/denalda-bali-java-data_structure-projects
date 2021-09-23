/**
* 
* 1. Write a program to check if a given string is a palindrome or not, using the data structures  
* you have learnt till now (stacks, queues and linked lists). 
* A palindrome is a word that reads the same forward and backward, for example RADAR. 
* Modify the program in order to determine palindrome sentences too, when the spaces are ignored. 
* For example, the sentence I PREFER PI is a palindrome if you ignore the blank characters.
* 
*/
package EX1;

import java.util.Scanner;
import java.util.LinkedList;
public class TestPalindrome {

/**
 *
 * @author denalda bali
 */
    public static void main(String[] args) throws ArrayStack.UnderflowException {
        
TestArrayStack();

    }
      public static void TestArrayStack() throws ArrayStack.UnderflowException {  
     LinkedList<String> myList = new LinkedList<String>();//declare your list
        
    
	Scanner input = new Scanner(System.in); 
	String inputString;      
      	System.out.print("Check if is Palindrome : ");
        inputString = input.next( );
        inputString = inputString.replaceAll("\\s+", "");
        
	if (isPalindrome( inputString )){
		System.out.println("Yes! Is palindrome.");
	}
	else{
		System.out.println("No! Is not palindrome.");
      	}
   }

   public static boolean isPalindrome(String input) throws ArrayStack.UnderflowException 
   {   
   ArrayStack MyStack = new ArrayStack();
      ArrayStack<Character> str = new ArrayStack<Character>( );
      char letter;
      int i;
      
      for (i = 0; i < input.length( ); i++)
      {
	 letter = input.charAt(i);

         str.push(letter);
      }    
      
      while (! MyStack.isEmpty())
      { 
       MyStack.pop();
           return false;
      } 
      return true; 
   }
      }

 