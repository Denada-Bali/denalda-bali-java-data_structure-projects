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
public class ListStack<AnyType> {

    public boolean isEmpty() {
        return Head == null;
    }

    public void makeEmpty() {
        Head = null;
    }

    public void push(AnyType x) { //Insert a new item into the stack.
        Head = new ListNode<AnyType>(x, Head);
    }

    public void pop() throws UnderflowException { //Remove  inserted item from the stack.
        if (isEmpty()) {
            throw new UnderflowException("ListStack pop");
        }
        Head = Head.next;
    }

    public AnyType top() throws UnderflowException { //Get the inserted item in the stack. Does not alter the stack.
        if (isEmpty()) {
            throw new UnderflowException("ListStack top");
        }
        return Head.element;
    }

    public void showElements() { //showElements The elements are shown from first one to the top of the stack
        ListNode<AnyType> temp = new ListNode<AnyType>(null, null);
        temp = Head;
        while (!(temp == null)) {
            AnyType el = temp.element;
            System.out.println(el.toString());
            temp = temp.next;
        }
        temp = null;
    }

    public void showInverse() { //showInverse Show the elements in inverse order.
        ListNode<AnyType> temp = new ListNode<AnyType>(null, null);
        temp = Head;
        ListStack<AnyType> inverse = new ListStack<AnyType>();
        while (!(temp == null)) {
            AnyType elem = temp.element;
            inverse.push(elem);
            temp = temp.next;
        }
        inverse.showElements();
        temp = null;
    }

    private ListNode<AnyType> Head = null;

    private static class UnderflowException extends Exception {

        public UnderflowException(String err) {
            super(err);
        }
    }
}
