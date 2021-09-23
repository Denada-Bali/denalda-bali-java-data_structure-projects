/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trees;

import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author Denalda Bali
 */
public class Trees {

    int k;      // key variable will used to enter numbers. 
    int data;     // variable that will used to count the dublicates.
    Node left;       // left and right node.
    Node right;

    public void tree(Trees t) {
        //createNewNode(int itm);

        System.out.println(inorder(t));
    }

    private boolean inorder(Trees t) {
        if (t != null) {
            inorder(t.left);    // left
            System.out.print(t.k + "(" + t.data + ") ");  // node
            inorder(t.right); // right
        }
        return false;
    }

    static class Node { // Node declaration 

        int k;      // key variable will used to enter numbers. 
        int data;     // variable that will used to count the dublicates.
        Node left;       // left and right node.
        Node right;

    };

    static Node createNewNode(int itm) { // Is a function to create a new Binary Search Tree Node 

        Node t = new Node();
        t.k = itm;
        t.left = t.right = null;
        t.data = 1;
        return t;

    }

// In-order traversal: 7, 7, 7, 8, 8, 8, 11, 14, 14, 14, 14, 18
    static void inorder(Node root) { // Is a function to do in-order traversal of Binary Search Tree

        if (root != null) {
            inorder(root.left);    // left
            System.out.print(root.k + "(" + root.data + ") ");  // node
            inorder(root.right); // right
        }
    }

// Pre-order traversal: 14, 8, 7, 7, 7, 11, 8, 8, 18, 14, 14, 14
    static void preorder(Node root) {// Is a function to do pre-order traversal of Binary Search Tree

        if (root == null) {
            return;
        }
        System.out.print(root.k + "(" + root.data + ") ");  // node
        preorder(root.left);    //left
        preorder(root.right);   //right
    }

// Post-order traversal: 7, 7, 7, 8, 8, 11, 8, 14, 14, 14, 18, 14
    static void postorder(Node root) { // Is a function to do post-order traversal of Binary Search Tree
        if (root == null) {
            return;
        }
        postorder(root.left); // left
        postorder(root.right); // right
        System.out.print(root.k + "(" + root.data + ") ");  // node       
    }

// Level order traversal: 14, 8, 18, 7, 11, 14, null, 7, null, 8, null, null, 14, 7, null, 8, null, null, 14 
    static void levelorder(Node root) {  //this function will print all values in Level order using Queue in Binary Tree

        if (root == null) {
            return;
        }

        Queue<Node> q = new LinkedList<Node>();
        q.add(root);                // This condition add the root 

        while (!q.isEmpty()) {    //This while loop will remove values from the queue 
            // as long as there are more values left to remove. 
            Node top = q.remove();
            System.out.print(top.k + "(" + top.data + ") ");  // node

            if (top.left != null) {
                q.add(top.left);            // left
            }
            if (top.right != null) {
                q.add(top.right);          //right
            }
        }
    }

    /*  
 *                       14       
 *                      /  \                  
 *                     /    \
 *                    8      18             
 *                   / \     /                
 *                  /   \   /  
 *                 7    11 14            
 *                /     /    \
 *               /     /      \
 *              7     8        14
 *             /     /          \
 *            /     /            \
 *           7     8              14
 *                            
     */
    static Node insert(Node node, int key) { //this function insert a new Node with given key in Binary Search Tree

        if (node == null) {
            return createNewNode(key);  // If the tree is empty, return a new Node 
        }
        if (key == node.k) // If key already exists in Binary Search Tree, increment data and return 
        {
            (node.data)++;
            return node;
        }

        if (key < node.k) {      // if key is smaller, should be inserted to left

            node.left = insert(node.left, key);
        } else {                                        //if key is greater, should be inserted to right
            node.right = insert(node.right, key);
        }

        return node;                // This function returns the node pointer unchanged.
    }

    // This function return  the Node with minimum key value found in that tree.
    static int MinimumValue(Node node) {
        Node current = node;

        while (current.left != null) { //This loop finds the leaf on the leftmost 

            current = current.left;
        }

        return (current.data);

    }

    /*                    14       
 *                       /  \                  
 *                      /    \
 *                     8      18             
 *                    / \     /                
 *                   /   \   /  
 *                  7    11 14            
 *                 /     /    \
 *                /     /      \
 *               7     8        14
 *              /     /          
 *             /     /           
 *            7     8                    
     */
//This function deletes a given key and returns root of modified tree
    static Node RemoveOnlyOneCopyOfExistingDuplicates(Node root, int key) {

        if (root == null) {
            return root; // base case 
        }
        if (key < root.k) {      //This condition show that if the key to be deleted is smaller
            //than the root key, then it lies in left subtree
            root.left = RemoveOnlyOneCopyOfExistingDuplicates(root.left, key);
        } else if (key > root.k) {         //This condition show that the key to be deleted is greater 
            //than the root's key, then it lies in right subtree
            root.right = RemoveOnlyOneCopyOfExistingDuplicates(root.right, key);
        } else {                          // This condition show that if key is same as root key

            if (root.data > 1) {            // So, If key is present more than once time, it decrement data and return

                (root.data)--;
                return root;

            } else if (root.data == 1) {
                System.out.print(root.k + "(" + root.data + ") ");  // node
            }

            if (root.left == null) {            //These conditions, deletes the Nodes,Nodes with only one child or no child 

                Node t = root.right;
                root = null;
                return t;
            } else if (root.right == null) {
                Node t = root.left;
                root = null;
                return t;
            }
            //   Node t = MinimumValue(root.right);    // Node with two children will get the inorder successor 
            //which is smallest in the right subtree

            //    root.k = t.k;  //this condition will copy the inorder successor in content to this Node 
            //      root.right = RemoveOnlyOneCopyOfExistingDuplicates(root.right, t.k);  // this condition will delete the inorder successor 
        }
        return root;
    }

    static Node ReturnNumberOfDuplicate(Node root, int key) {

        if (root != null) {
            ReturnNumberOfDuplicate(root.left, key);    // checks the left subtree

            if (key == root.k) {   //This condition show that if the input key is equal with actual node 

                System.out.print(root.k + "(" + root.data + ") "); // the program will print key with number of the duplicates 
                root.left = ReturnNumberOfDuplicate(root.left, key);
                root.right = ReturnNumberOfDuplicate(root.right, key);

                ReturnNumberOfDuplicate(root.right, key);   //checks the right subtree
            }
        }
        return root;
    }

    /*                    14       
 *                       /  \                  
 *                      /    \
 *                     8      18             
 *                    / \     /                
 *                   /   \   /  
 *                  7    11 14            
 *                 /         \
 *                /           \
 *               7             14
 *              /               \
 *             /                 \
 *            7                   14                     
     */
    static Node RemoveAllExistingDuplicatesOfEelement(Node root, int key) {

        if (root != null) {
            RemoveAllExistingDuplicatesOfEelement(root.left, key);  // checks the left subtree

            if (key < root.k || key > root.k) {   //This condition show that if the key less then or greater then root.k

                System.out.print(root.k + "(" + root.data + ") "); // the program will print the root with the duplicates 

                root.right = RemoveAllExistingDuplicatesOfEelement(root.right, key);
            } else if (root.data != 1) {
                System.out.print(root.k + "(" + (root.data / root.data) + ") ");

                RemoveAllExistingDuplicatesOfEelement(root.right, key);   //checks the right subtree
            }
        }
        return root;
    }

    /*
  *           14       
  *          /  \                  
  *         /    \
  *        8     18             
  *       / \                  
  *      /   \    
  *     7     11                
     */
    public void RemoveAllExistingDuplicates(Node root) {

        if (root != null) {
            RemoveAllExistingDuplicates(root.left);  // checks the left subtree
            if (root.data == 1) {     // if count of duplicates is equal than 1. 
                System.out.print(root.k + "(" + root.data + ") "); // the program will print the root with the duplicates
            } else if (root.data > 1) { // if count of duplicates is greater than 1.
                System.out.print(root.k + "(" + (root.data / root.data) + ") ");

                RemoveAllExistingDuplicates(root.right);   //checks the right subtree
            }
        }
    }

    public void PrintDuplicate(Node root) {

        if (root != null) {
            PrintDuplicate(root.left);  // checks the left subtree
            if (root.data > 1) {     // if count of duplicates is greater than 1. 
                System.out.print(root.k + "(" + root.data + ") "); // the program will print the root with the duplicates 
            } else {                                               //node
                PrintDuplicate(root.right);   //checks the right subtree
            }
        }
    }

    public void PrintNoDuplicates(Node root) {

        if (root != null) {
            PrintNoDuplicates(root.left);   // checks the left subtree
            if (root.data == 1) {          // if count of duplicates is equal with 1
                System.out.print(root.k + "(" + root.data + ") "); //the program will print numbers that do not have duplicates 
            } else {
                PrintNoDuplicates(root.right); // checks the right subtree
            }
        }
    }

    /*  
 *                       14       
 *                      /  \                  
 *                     /    \
 *                    8      18             
 *                   / \     /                
 *                  /   \   /  
 *                 8    11 14            
 *                /     /    \
 *               /     /      \
 *              8     8        14
 *             /     /          \
 *            /     /            \
 *           8     8              14
 *                            
     */
 
    public void ReplaceDuplicatesOfElement(Node root, int x, int y, int z) {
        if (root == null) {                   // z is the duplicate number 
            return;
        }
        if (root.k == x) {
            root.k = y;
            root.data += z;
            System.out.print(root.k + "(" + root.data + ") ");

            return;
        }
        if (root.k < x) {
            ReplaceDuplicatesOfElement(root.right, x, y, z);

        } else {
            ReplaceDuplicatesOfElement(root.left, x, y, z);
        }
        System.out.print("is the result of finding & replacing element " + x + " with element " + y);
    }

    public void replceDuplicateInorderTraversal(Node root) {
        if (root != null) {
            replceDuplicateInorderTraversal(root.left);
            System.out.print(root.k + "(" + root.data + ") ");
            replceDuplicateInorderTraversal(root.right);
        }
    }

    int count[] = {0};

    public Integer showNumberOfDublicate(Node root) {  // show number that are repeated in the tre

        if (root == null) {
            return null;
        }

        if (root.data > 1) { // checks if count of duplicates is greater than 1.
            count[0] = count[0] + root.data;      // count will be added to root.data
        }
        showNumberOfDublicate(root.left);   // checks the left subtree
        showNumberOfDublicate(root.right);  // checks the right subtree

        return count[0];      // return count 0
    }
}
