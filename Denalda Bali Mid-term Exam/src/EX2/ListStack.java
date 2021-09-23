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
public class ListStack<AnyType> {

    public boolean isEmpty() {
        return Head == null;
    }

    public void makeEmpty() {
        Head = null;
    }

    public void push(AnyType x) {
        Head = new ListNode<AnyType>(x, Head);
    }

    public void pop() throws UnderflowException {
        if (isEmpty()) {
            throw new UnderflowException("ListStack pop");
        }
        Head = Head.next;
    }

    public AnyType top() throws UnderflowException {
        if (isEmpty()) {
            throw new UnderflowException("ListStack top");
        }
        return Head.element;
    }
    
        public AnyType peek()throws UnderflowException {
		if (isEmpty()) {
			throw new UnderflowException("ListStack top");
		}
		return Head.element;
        }

    public void showElements() {
        if (Head == null) {
            System.out.println("The Stack is empty!");
        } else {
            ListNode<AnyType> temp = new ListNode<AnyType>(null, null);
            temp = Head;
            while (temp != null) {
                AnyType e = temp.element;
                System.out.println(e.toString());
                temp = temp.next;
            }
            temp = null;
        }
    }

    private ListNode<AnyType> Head = null;

    public static class UnderflowException extends Exception {

        public UnderflowException(String err) {
            super(err);
        }
    }
}

class ListNode<AnyType> {

    public ListNode(AnyType theElement) {
        this(theElement, null);
    }

    public ListNode(AnyType theElement, ListNode<AnyType> n) {
        element = theElement;
        next = n;
    }

    public AnyType element;
    public ListNode next;

}
