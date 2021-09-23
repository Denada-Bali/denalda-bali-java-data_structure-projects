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
import java.util.Comparator;

public class ArrayQueue<AnyType> {

    public ArrayQueue() { //Construct the queue.
        theArray = (AnyType[]) new Object[DEFAULT_CAPACITY];
        makeEmpty();
    }

    private ArrayQueue(int length) { // another constructor which specifies size of queue as parameter.
        theArray = (AnyType[]) new Object[length];
        makeEmpty();
    }

    public boolean isEmpty() { //Test if the queue is logically empty.
        return currentSize == 0;
    }

    public void makeEmpty() { //this methode make the queue logically empty.
        currentSize = 0;
        front = 0;
        back = -1;
    }

    public AnyType dequeue() throws UnderflowException { // dequeue help to return and remove the least recently inserted item from the queue.
        if (isEmpty()) {                             //return the least recently inserted item in the queue.
            throw new UnderflowException("ArrayQueue dequeue");
        }    //UnderflowException if the queue is empty
        currentSize--;

        AnyType returnValue = theArray[front];
        front = increment(front);
        return returnValue;
    }

    public void enqueue(AnyType x) { // enqueue help to insert a new item into the queue.
        if (currentSize == theArray.length) { // x is a parameter  to insert the item
            doubleQueue();
        }
        back = increment(back);
        theArray[back] = x;
        currentSize++;
    }

    private int increment(int x) { //is Internal method and incremented with wraparound.
        if (++x == theArray.length) { // parameter x is index in theArray's range 
            x = 0;
        }
        return x; // the return statement return x+1, or 0 if x is at the end of theArray.
    }

    private int decrement(int x) {
        if (x == 0) {          //// parameter x is index in theArray's range 
            x = theArray.length - 1;
        } else {
            x--;
        }
        return x;
    }

    private void doubleQueue() { //Internal method to expand theArray.
        AnyType[] newArray;

        newArray = (AnyType[]) new Object[theArray.length * 2];

        // help to copy elements that are logically in the queue
        for (int i = 0; i < currentSize; i++, front = increment(front)) {
            newArray[i] = theArray[front];
        }

        theArray = newArray;
        front = 0;
        back = currentSize - 1;
    }

    //// Exercise 3
    /**
     *
     */
    public void showElements() { // All elements are shows in the queue in FIFO (First in First out) order
        int temp = front;
        for (int i = 0; i < currentSize; i++, front = increment(front)) {
            System.out.println(theArray[front].toString());
        }
        front = temp;
    }

    public void showInverse() { // the methode inverse all elements
        int temp = back;
        for (int i = currentSize; i > 0; i--, back = decrement(back)) {
            System.out.println(theArray[back].toString());
        }
        back = temp;
    }

    private AnyType[] theArray;
    private int currentSize;
    private int front;
    private int back;

    private static final int DEFAULT_CAPACITY = 10;

    static class UnderflowException extends Exception {

        public UnderflowException(String err) {
            super(err);
        }
    }
}
