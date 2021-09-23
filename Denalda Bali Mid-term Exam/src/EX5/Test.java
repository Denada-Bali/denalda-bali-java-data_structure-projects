/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EX5;

/**
 *
 * @author denalda bali
 */
public class Test {

    public static void main(String[] args) throws ArrayQueue.UnderflowException, ListQueue.UnderflowException {

        testQueueArray();

    }

    public static void testQueueArray() throws ListQueue.UnderflowException {
        ListQueue<Integer> inti = new ListQueue<Integer>();
//Add nodes to the list  
        Integer i1 = new Integer(5);
        Integer i2 = new Integer(24);
        Integer i3 = new Integer(9);
        Integer i4 = new Integer(6);
        Integer i5 = new Integer(8);
        Integer i6 = new Integer(4);
        Integer i7 = new Integer(1);
        Integer i8 = new Integer(8);
        Integer i9 = new Integer(3);
        Integer i10 = new Integer(6);

        inti.enqueue(i1);
        inti.enqueue(i2);
        inti.enqueue(i3);
        inti.enqueue(i4);
        inti.enqueue(i5);
        inti.enqueue(i6);
        inti.enqueue(i7);
        inti.enqueue(i8);
        inti.enqueue(i9);
        inti.enqueue(i10);

        System.out.println("Show Elements");
        inti.showElements();

        System.out.println("Show Inverse");
        inti.showInverse();

        inti.enqueue(i2);

        System.out.println("Add an item x to rear of queue.");
        inti.showElements();

        inti.dequeue();

        System.out.println("Remove an item from front of queue.");
        inti.showElements();

        System.out.println("Checks if queue is empty or not.");

        if (inti.isEmpty()) {
            System.out.println("Queue is Empty");
        } else {
            System.out.println("Queue is not Empty");
            inti.makeEmpty();
        }
        if (inti.isEmpty()) {
            System.out.println("Now, queue is Empty");
        } else {
            System.out.println("Queue is not Empty");
        }
    }
}
