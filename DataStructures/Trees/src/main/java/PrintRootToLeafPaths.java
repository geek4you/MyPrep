/**
 * Created by chanumolu on 7/1/15.
 */

import java.util.ArrayList;
import java.util.List;

/**
 * http://www.geeksforgeeks.org/given-a-binary-tree-print-out-all-of-its-root-to-leaf-paths-one-per-line/
 * Given a binary tree, print out all of its root-to-leaf paths one per line.
 */
public class PrintRootToLeafPaths {
    public static void printPaths(Node root) {
        if (null == root) {
            return;
        }

        printPathUtil(root, new ArrayList<Integer>(), 0);
    }

    public static void printPathUtil(Node root, ArrayList<Integer> list, int index){

        if(null == root)
            return;

        // add the node to the list
        list.add(index,root.data);
        index++;

        // print list if leaf node
        if(null == root.left && null == root.right){
            for(int i =0 ; i<index;i++)
                System.out.print(list.get(i));
            System.out.println();
        }

        // recursively proceed
        printPathUtil(root.left, list, index);
        printPathUtil(root.right, list, index);
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);

        printPaths(root);
    }
}
