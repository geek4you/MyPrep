/**
 * Created by chanumolu on 7/8/15.
 */

import java.util.*;

/**
 * @link : http://www.geeksforgeeks.org/binary-tree-to-binary-search-tree-conversion/
 */
public class BinaryTreeToBinarySearchTreeConversion {

    public static Node binaryToBinarySearchTree(Node root) {
        if (null == root)
            return null;

        List<Integer> l = new ArrayList<Integer>();

        // get the inoder sequence into list
        treeToInorderArray(root, l);

        // sort the inorder list
        Collections.sort(l);

        // construct a BST out of it.
        return inorderToBST(l,0,l.size()-1);

    }

    public static void treeToInorderArray(Node root, List<Integer> list) {

        if (null == root)
            return;

        Node current = root;
        Deque<Node> stack = new ArrayDeque<Node>();

        boolean done = false;
        while (!done) {
            if (current != null) {
                stack.push(current);
                current = current.left;
            } else if (!stack.isEmpty()) {
                current = stack.pop();
                list.add(current.data);
                current = current.right;
            } else {
                done = true;
            }
        }

    }

    public static Node inorderToBST(List<Integer> list, int low, int high) {

        if (low > high)
            return null;

        // get mid
        int mid = (high + low) / 2;
        Node root = new Node(list.get(mid));

        // construct left and right sub trees
        root.left = inorderToBST(list, low, mid - 1);
        root.right = inorderToBST(list, mid + 1, high);

        return root;
    }

    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(30);
        root.right = new Node(15);
        root.left.left = new Node(20);
        root.right.right = new Node(5);

        System.out.println("BST inorder: ");
        TreeTraversals.inorder(binaryToBinarySearchTree(root));
    }
}
