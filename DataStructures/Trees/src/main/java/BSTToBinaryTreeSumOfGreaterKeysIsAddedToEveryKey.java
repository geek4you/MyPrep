/**
 * Created by chanumolu on 7/11/15.
 */

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @link : http://www.geeksforgeeks.org/convert-bst-to-a-binary-tree/
 *
 * Given a Binary Search Tree (BST), convert it to a Binary Tree such that every key of the original BST is changed to
 * key plus sum of all greater keys in BST.

Examples:

Input: Root of following BST
5
/   \
2     13

Output: The given BST is converted to following Binary Tree
18
/   \
20     13
 */


/**
 * Solution: Do reverse Inoorder traversal. Keep track of the sum of nodes visited so far. Let this sum be sum.
 * For every node currently being visited, first add the key of this node to sum, i.e. sum = sum + node->key.
 * Then change the key of current node to sum, i.e., node->key = sum.
 When a BST is being traversed in reverse Inorder, for every key currently being visited, all keys that are already
 visited are all greater keys.
 */
// TODO: very interesting . Try again!!
public class BSTToBinaryTreeSumOfGreaterKeysIsAddedToEveryKey {

    public static Node convert(Node root){

        if(null == root)
            return null;

        // revserse inorder

        Deque<Node> stack = new ArrayDeque<Node>();

        Node current = root;
        int sum =0;
        boolean done = false;
        while(!done){
            if(null != current){
                stack.push(current);
                current = current.right;
            }else if(!stack.isEmpty()){
                Node tmp = stack.pop();
                sum = sum + tmp.data;
                tmp.data = sum;
                current = tmp.left;
            }else{
                done = true;
            }
        }

        return root;
    }

    public static void main(String[] args) {
        Node root = new Node(5);
        root.left = new Node(2);
        root.right = new Node(13);

        TreeTraversals.inorder(convert(root));
    }
}
