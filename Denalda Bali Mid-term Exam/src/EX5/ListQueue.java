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

public class ListQueue<AnyType> {

    public ListQueue() { //Construct the queue.
        front = back = null;
    }

    public void enqueue(AnyType x) { // enqueue help to insert a new item into the queue. 
        if (isEmpty()) // Make a queue of one element
        {
            back = front = new ListNode<AnyType>(x);
        } else // Regular case
        {
            back = back.next = new ListNode<AnyType>(x);
        }
    }

    public AnyType dequeue() throws UnderflowException { //dequeue help to return and remove the least recently inserted item from the queue.
        if (isEmpty()) {
            throw new UnderflowException("ListQueue dequeue");
        }

        AnyType returnValue = front.element;
        front = front.next;
        return returnValue;
    }

    public void makeEmpty() {//Make the queue logically empty.
        front = null;
        back = null;
    }

    public boolean isEmpty() { //Test if the queue is logically empty.
        return front == null;
    }

    private ListNode<AnyType> front;
    private ListNode<AnyType> back;

    static class UnderflowException extends Exception {

        public UnderflowException(String err) {
            super(err);
        }
    }

    //// Exercise 3
    public void showElements() {
        ListNode<AnyType> ownFront = front;
        while (front != null) {
            System.out.println(front.element);
            front = front.next;
        }
        front = ownFront;
    }

    public void showInverse() {

        ListQueue<AnyType> clone = this.clone();
        ListNode<AnyType> byNode = clone.front;
        ListNode<AnyType> middNode, fNode;

        middNode = byNode.next;
        fNode = middNode.next;

        byNode.next = null;

        while (fNode != null) {
            middNode.next = byNode;

            byNode = middNode;
            middNode = fNode;
            fNode = fNode.next;
        }
        
        middNode.next = byNode;
        clone.front = middNode;
        clone.showElements();
        clone = null;
    }

    public ListQueue<AnyType> clone() {
        ListQueue<AnyType> clone = new ListQueue<AnyType>();
        ListNode<AnyType> ownFront = front;
        while (front != null) {
            clone.enqueue(front.element);
            front = front.next;
        }
        front = ownFront;
        return clone;
    }
}
// Basic node stored in a linked list.
// Note that this class is not accessible outside
// of package 
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
