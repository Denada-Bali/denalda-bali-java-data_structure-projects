/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trees;

import trees.Trees.Node;

/**
 *
 * @author Denalda Bali
 */
public class Test {

  

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {

        Trees MyTree = new Trees();
        Node root = null;

        root = MyTree.insert(root, 14);
        root = MyTree.insert(root, 8);
        root = MyTree.insert(root, 18);
        root = MyTree.insert(root, 7);
        root = MyTree.insert(root, 11);
        root = MyTree.insert(root, 8);
        root = MyTree.insert(root, 14);
        root = MyTree.insert(root, 14);
        root = MyTree.insert(root, 8);
        root = MyTree.insert(root, 7);
        root = MyTree.insert(root, 7);
        root = MyTree.insert(root, 14);
        
        System.out.print("Minimum value is " + MyTree.MinimumValue(root));

        System.out.print("\n+ Point 1\n");
        System.out.print("* Return number of duplicates of an element \n");
        MyTree.ReturnNumberOfDuplicate(root, 7);
        System.out.print("\n");

        System.out.print("\n+ Point 2\n");
        System.out.print("* Find and replace all duplicates of an element A with element B \n");
        System.out.print("- Before replace: ");
        MyTree.inorder(root);
        System.out.print("\n");        //root , A , B, Z                    
        MyTree.ReplaceDuplicatesOfElement(root, 8, 18, 1 ); //Last parameter(Z)is the duplicate number 
        System.out.print("\n");

        System.out.print("\n+ Point 3 \n");
        System.out.print("* Show all the tree together with the duplicates (pre-order, in-order,post-order, level-order)");
        System.out.print("\n  In-order Traversal \n");
        MyTree.inorder(root);
        System.out.print("\n");
        
        System.out.print("\n  Pre-order Traversal  \n");
        MyTree.preorder(root);
        System.out.print("\n");

        System.out.print("\n  Post-order Traversal \n");
        MyTree.postorder(root);
        System.out.print("\n");

        System.out.print("\n  Level-order Traversal \n");
        MyTree.levelorder(root);
        System.out.print("\n");

        System.out.print("\n+ Point 4 \n");
        System.out.print("* Remove all existing duplicates (leaving only one copy) of an element");
        System.out.print("\n Remove 8\n");
        MyTree.RemoveAllExistingDuplicatesOfEelement(root, 8);
        System.out.print("\n");

        System.out.print("\n+ Point 5\n");
        System.out.print("* Remove only one copy of the existing duplicates of an element ");
        System.out.print("\n Remove 14\n");
        MyTree.RemoveOnlyOneCopyOfExistingDuplicates(root, 14);
        MyTree.inorder(root);
        System.out.print("\n");

        System.out.print("\n+ Point 6\n");
        System.out.print("* Remove all existing duplicates (leaving only one copy) for all the duplicated elements in tree \n");
        MyTree.RemoveAllExistingDuplicates(root);
        System.out.print("\n");

        System.out.print("\n+ Point 7\n");
        System.out.print("* Print all elements that have duplicates together with the number of duplicates\n");
        MyTree.PrintDuplicate(root);
        System.out.print("\n");

        System.out.print("\n+ Point 8\n");
        System.out.print("* Print the number of all the duplicates in the tree\n");
        System.out.print("- The numbers that are repeated are: " + MyTree.showNumberOfDublicate(root));
        System.out.print("\n");

        System.out.print("\n+ Point 9\n");
        System.out.print("* Show only the nodes that have/do not have duplicates\n");
        System.out.print("- Nodes that do not have dublicates: ");
        MyTree.PrintNoDuplicates(root);
        System.out.print("\n- Nodes that have dublicates: ");
        MyTree.PrintDuplicate(root);
        System.out.print("\n");

    }
}