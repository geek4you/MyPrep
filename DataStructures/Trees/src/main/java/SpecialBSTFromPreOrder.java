/**
 * Created by chanumolu on 7/11/15.
 */

/**
 * Construct a special tree from given preorder traversal
 * Given an array ‘pre[]’ that represents Preorder traversal of a spacial binary tree where every node has either 0 or 2
 * children. One more array ‘preLN[]’ is given which has only two possible values ‘L’ and ‘N’. The value ‘L’ in ‘preLN[]’
 * indicates that the corresponding node in Binary Tree is a leaf node and value ‘N’ indicates that the corresponding node
 * is non-leaf node. Write a function to construct the tree from the given two arrays.
 * <p>
 * Example:
 * <p>
 * Input:  pre[] = {10, 30, 20, 5, 15},  preLN[] = {'N', 'N', 'L', 'L', 'L'}
 * Output: Root of following tree
 * 10
 * /  \
 * 30   15
 * /  \
 * 20   5
 */
public class SpecialBSTFromPreOrder {

    public static Node buildTree(int[] pre, char[] pre_ln, IntHolder index) {

        //System.out.printf("Index Val:"+index.val);
        int tmp_index = index.val;
        // base case
        if (index.val == pre.length){
            return null;
        }

        // Allocate memory for this node and increment index for
        // subsequent recursive calls
        Node root = new Node(pre[index.val]);
        index.val++;

        // If this is an internal node, construct left and right subtrees and link the subtrees
        if (pre_ln[tmp_index] == 'N') {
            root.left = buildTree(pre, pre_ln, index);
            root.right = buildTree(pre, pre_ln, index);
        }

        return root;

    }

    public static void main(String[] args) {
        int pre[] = {10, 30, 20, 5, 15};
        char preLN[] = {'N', 'N', 'L', 'L', 'L'};
        Node root = buildTree(pre,preLN,new IntHolder(0));
        TreeTraversals.inorder(root);
        System.out.println("Preorder: ");
        TreeTraversals.preorder(root);
    }
}

// class to hold integer so that I can pass this object in recursion to simulate pass by reference behavior
class IntHolder {
    int val;

    IntHolder(int val) {
        this.val = val;
    }
}
