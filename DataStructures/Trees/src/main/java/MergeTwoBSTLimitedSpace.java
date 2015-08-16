/**
 * Created by chanumolu on 7/9/15.
 */

import java.util.ArrayDeque;
import java.util.Deque;

/**Time Complexity: O(m+n)
 Auxiliary Space: O(height of the first tree + height of the second tree)
 * @link : http://www.geeksforgeeks.org/merge-two-bsts-with-limited-extra-space/
 * <p>
 * Given two Binary Search Trees(BST), print the elements of both BSTs in sorted form. The expected time complexity is O(m+n) where m is the number of nodes in first tree and n is the number of nodes in second tree. Maximum allowed auxiliary space is O(height of the first tree + height of the second tree).
 * <p>
 * Examples:
 * <p>
 * First BST
 * 3
 * /     \
 * 1       5
 * Second BST
 * 4
 * /   \
 * 2       6
 * Output: 1 2 3 4 5 6
 * <p>
 * <p>
 * First BST
 * 8
 * / \
 * 2   10
 * /
 * 1
 * Second BST
 * 5
 * /
 * 3
 * /
 * 0
 * Output: 0 1 2 3 5 8 10
 */
public class MergeTwoBSTLimitedSpace {


    public static void mergeBsts(Node root1, Node root2) {

        if (null == root1 && null == root2) {
            return;
        }

        if (null == root1) {
            TreeTraversals.inorder(root2);
            return;
        }

        if (null == root2) {
            TreeTraversals.inorder(root1);
            return;
        }

        Deque<Node> stack1 = new ArrayDeque<Node>();
        Deque<Node> stack2 = new ArrayDeque<Node>();

        Node current1 = root1;
        Node current2 = root2;

        while (current1 != null || current2 != null || !stack1.isEmpty() || !stack2.isEmpty()) {
            // first reach the left most child in both trees
            if(current1!=null || current2!=null){
                if(current1!=null){
                    stack1.push(current1);
                    current1 = current1.left;
                }

                if(current2!=null){
                    stack2.push(current2);
                    current2 = current2.left;
                }

            }else {
                if(stack1.isEmpty() || stack2.isEmpty()){
                    if(stack1.isEmpty()){
                        current2 = stack2.pop();
                        current2.left = null;
                        TreeTraversals.inorder(current2);
                        return;
                    }else{
                        current1 = stack1.pop();
                        current1.left = null;
                        TreeTraversals.inorder(current1);
                        return;
                    }

                }

                // Pop an element from both stacks and compare the
                // popped element
                current1 = stack1.pop();
                current2 = stack2.pop();

                // If element of first tree is smaller, then print it
                // and push the right subtree. If the element is larger,
                // then we push it back to the corresponding stack.
                if(current1.data<current2.data){
                    System.out.println(current1.data);
                    current1 = current1.right;
                    stack2.push(current2);
                    current2 = null;
                }else{
                    System.out.println(current2.data);
                    current2 = current2.right;
                    stack1.push(current1);
                    current1 = null;
                }
            }
        }


    }

    public static void main(String[] args) {
        /* Let us create the following tree as first tree
            3
          /  \
         1    5
     */
        Node root1 = new Node(3);
        root1.left = new Node(1);
        root1.right = new Node(5);
 
    /* Let us create the following tree as second tree
            4
          /  \
         2    6
     */
        Node root2 = new Node(4);
        root2.left = new Node(2);
        root2.right = new Node(6);

        // Print sorted nodes of both trees
        mergeBsts(root1, root2);
    }
}
