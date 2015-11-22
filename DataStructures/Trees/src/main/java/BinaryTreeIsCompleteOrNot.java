/**
 * Created by chanumolu on 7/11/15.
 */

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @link : http://www.geeksforgeeks.org/check-if-a-given-binary-tree-is-complete-tree-or-not/
 * <p>
 * Check whether a given Binary Tree is Complete or not
 * <p>
 * Check whether a given Binary Tree is Complete or not | Set 1 (Iterative Solution)
 * Given a Binary Tree, write a function to check whether the given Binary Tree is Complete Binary Tree or not.
 * <p>
 * A complete binary tree is a binary tree in which every level, except possibly the last, is completely filled, and all
 * nodes are as far left as possible
 * <p>
 * <p>
 * level order traversal post can be easily modified to check whether a tree is Complete or not. To understand the approach,
 * let us first define a term ‘Full Node’. A node is ‘Full Node’ if both left and right children are not empty (or not NULL).
 * The approach is to do a level order traversal starting from root. In the traversal, once a node is found which is NOT a Full Node,
 * all the following nodes must be leaf nodes.
 * Also, one more thing needs to be checked to handle the below case: If a node has empty left child, then the right child must be empty.
 * <p>
 *          1
 *       /   \
 *      2     3
 *      \
 *       4
 */


public class BinaryTreeIsCompleteOrNot {

    public static boolean isCompleteTree(Node root) {
        if (null == root)
            return true;

        Deque<Node> queue = new ArrayDeque<Node>();

        Node current = root;
        queue.add(current);
        // Create a flag variable which will be set true
        // when a non full node is seen
        boolean flag = false;
        while (!queue.isEmpty()) {

            current = queue.poll();
            /* Check if left child is present*/
            if (current.left != null) {

                //enqueue
                queue.add(current.left);
                // If we have seen a non full node, and we see a node
                // with non-empty left child, then the given tree is not
                // a complete Binary Tree
                if (flag)
                    return false;
            } else {
                // If this a non-full node, set the flag as true
                flag = true;
            }

            if (current.right != null) {
                // enqueue
                queue.add(current.right);
                // If we have seen a non full node, and we see a node
                // with non-empty right child, then the given tree is not
                // a complete Binary Tree
                if (flag)
                    return false;
            } else {
                // If this a non-full node, set the flag as true
                flag = true;
            }

        }
        // if we reach here it is complete binary tree.
        return true;
    }

    public static void main(String[] args) {
        /* Let us construct the following Binary Tree which
      is not a complete Binary Tree
            1
          /   \
         2     3
        / \     \
       4   5     6
    */

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.right = new Node(6);

        if (isCompleteTree(root) )
            System.out.println("Complete Binary Tree");
        else
            System.out.println("NOT Complete Binary Tree");

    }
}
