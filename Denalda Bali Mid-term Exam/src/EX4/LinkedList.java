/*
 * To change this license tail, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EX4;

/**
 *
 * @author denalda bali
 */
import java.util.List;

/**
 * LinkedList class implements a doubly-linked list.
 */
public class LinkedList<AnyType> {

    /**
     * Construct an empty LinkedList.
     */
    public LinkedList() {

        header = new Node<AnyType>(null, null, null);
        tail = new Node<AnyType>(null, header, null);
        header.next = tail;

        theSize = 0;
        count++;
    }

    public int size() {
        return theSize;
    }

    public boolean isEmpty() {
        return header == null;
    }

    public void add(int idx, AnyType x) {
        Node<AnyType> p = getNode(idx, 0, size());
        Node<AnyType> newNode = new Node<AnyType>(x, p.prev, p);
        newNode.prev.next = newNode;
        p.prev = newNode;
        theSize++;
        count++;
    }

    public AnyType get(int idx) {
        return getNode(idx).data;
    }

    public void GivenSequence(AnyType element) {

        add(0, element);
    }

    // Shows all the elements of the list.
    public void showList() {
        for (int i = 0; i < this.theSize; i++) {
            System.out.println(getNode(i).data.toString());
        }
    }

    public void RemoveOddNumber() {
        for (int i = 1; i < this.theSize; i += 2) {
                System.out.println(getNode(i).data.toString());
        }
    }

    public void RemoveEvenNumber() {
        for (int i = 0; i <= this.theSize; i += 2) {
            System.out.println(getNode(i).data.toString());
        }
    }

    public void remove(int index1, int index2) {
        for (int i = index1; i <= index2; i++) {
            remove(index2);
        }
    }

    private Node<AnyType> getNode(int idx) {
        return getNode(idx, 0, size() - 1);
    }

    private Node<AnyType> getNode(int idx, int lower, int upper) {
        Node<AnyType> p;

        if (idx < lower || idx > upper) {
            throw new IndexOutOfBoundsException("getNode index: " + idx + "; size: " + size());
        }

        if (idx < size() / 2) {
            p = header.next;
            for (int i = 0; i < idx; i++) {
                p = p.next;
            }
        } else {
            p = tail;
            for (int i = size(); i > idx; i--) {
                p = p.prev;
            }
        }

        return p;
    }

    public AnyType remove(int idx) {
        return remove(getNode(idx));
    }

    private AnyType remove(Node<AnyType> p) {
        p.next.prev = p.prev;
        p.prev.next = p.next;
        theSize--;
        count++;

        return p.data;
    }

    //  This is the doubly-linked list node.
    private static class Node<AnyType> {

        public Node(AnyType d, Node<AnyType> p, Node<AnyType> n) {
            data = d;
            prev = p;
            next = n;
        }

        public AnyType data;
        public Node<AnyType> prev;
        public Node<AnyType> next;

    }
    private final Node<AnyType> NOT_FOUND = null;

    private int theSize;
    private Node<AnyType> header;
    private Node<AnyType> tail;
    private int count = 0;

}
