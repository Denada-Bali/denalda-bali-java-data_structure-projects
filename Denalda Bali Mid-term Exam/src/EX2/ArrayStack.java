/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EX2;

/**
 *
 * @author denalda bali
 */
public class ArrayStack<AnyType> {

    /**
     * Construct the stack.
     */
    public ArrayStack() {
        theArray = (AnyType[]) new Object[DEFAULT_CAPACITY];
        Header = -1;
    }

    public ArrayStack(int size) {
        theArray = (AnyType[]) new Object[size];
        Header = -1;
    }

    public boolean isEmpty() {
        return Header == -1;
    }

    public AnyType top() throws UnderflowException {
        if (isEmpty()) {
            throw new UnderflowException("ArrayStack top");
        }
        return theArray[Header];
    }

    public void pop() throws UnderflowException {
        if (isEmpty()) {
            throw new UnderflowException("ArrayStack pop");
        }
        Header--;
    }

    public void push(AnyType x) {
        if (Header + 1 == theArray.length) {
            doubleArray();
        }
        theArray[++Header] = x;
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
    private int Header;

    private static final int DEFAULT_CAPACITY = 3;

    static class UnderflowException extends Exception {

        public UnderflowException(String err) {
            super(err);
        }
    }
}
