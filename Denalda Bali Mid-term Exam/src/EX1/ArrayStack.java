/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EX1;

/**
 *
 * @author denalda bali
 */
public class ArrayStack<AnyType> {

    public ArrayStack() {
        theArray = (AnyType[]) new Object[DEFAULT_CAPACITY];
        Head = -1;
    }

    public ArrayStack(int size) {
        theArray = (AnyType[]) new Object[size];
        Head = -1;
    }

    public void push(AnyType x) {
        if (Head + 1 == theArray.length) {
            doubleArray();
        }
        theArray[++Head] = x;
    }

    public boolean isEmpty() {
        return Head == -1;
    }

    public void pop() throws UnderflowException {
        if (isEmpty()) {
            throw new UnderflowException("ArrayStack pop");
        }
        Head--;
    }

    private void doubleArray() {
        AnyType[] newArray;
        newArray = (AnyType[]) new Object[theArray.length * 2];

        for (int i = 0; i < theArray.length; i++) {
            newArray[i] = theArray[i];
        }

        theArray = newArray;
    }
                 
    private AnyType[] theArray;
    private int Head;

    private static final int DEFAULT_CAPACITY = 3;

    static class UnderflowException extends Exception {

        public UnderflowException(String err) {
            super(err);
        }
    }
 }
