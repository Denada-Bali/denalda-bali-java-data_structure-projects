/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EX4;

import java.util.HashMap;

/**
 *
 * @author Denalda bali
 */
public class Test {

    public static void main(String[] args) {
        testLinkedList();
    }

    public static void testLinkedList() {
        LinkedList<Integer> R = new LinkedList<Integer>();
        //Add nodes to the list  
        Integer i1 = new Integer(4);
        Integer i2 = new Integer(2);
        Integer i3 = new Integer(2);
        Integer i4 = new Integer(5);
        Integer i5 = new Integer(2);
        Integer i6 = new Integer(3);
        Integer i7 = new Integer(2);
        Integer i8 = new Integer(3);
        Integer i9 = new Integer(1);
        Integer i10 = new Integer(5);
        Integer i11 = new Integer(2);

        R.GivenSequence(i1);
        R.GivenSequence(i2);
        R.GivenSequence(i3);
        R.GivenSequence(i4);
        R.GivenSequence(i5);
        R.GivenSequence(i6);
        R.GivenSequence(i7);
        R.GivenSequence(i8);
        R.GivenSequence(i9);
        R.GivenSequence(i10);
        R.GivenSequence(i11);

        System.out.println("Given Sequence  ");
        R.showList();

        System.out.println("Remove all odd counts ");
        R.RemoveEvenNumber();

        System.out.println("Remove all even counts ");
        R.RemoveOddNumber();

    }

}
