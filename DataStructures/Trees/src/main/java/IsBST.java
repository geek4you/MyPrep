/**
 * Created by chanumolu on 7/3/15.
 */

/**
 * @link : http://www.geeksforgeeks.org/a-program-to-check-if-a-binary-tree-is-bst-or-not/
 * check if binary tree is BST or not
 */
public class IsBST {


    /**
     * This method is wrong. Seems right but wrong
     */
    public static boolean isBstWrong(Node root) {
        if (null == root)
            return true;

        if (null != root.left && root.left.data > root.data)
            return false;

        if (null != root.right && root.right.data < root.data)
            return false;

        return isBstWrong(root.left) && isBstWrong(root.right);
    }


    /**
     * Track min and max values
     */
    public static boolean isBst1(Node root) {
        if (null == root)
            return true;

        return isBst1Util(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public static boolean isBst1Util(Node root, int min, int max) {
        if (null == root)
            return true;

        if (root.data > min && root.data < max) {
            return isBst1Util(root.left, min, root.data) && isBst1Util(root.right, root.data, max);
        }

        return false;
    }

    /**
     * 1) Do In-Order Traversal of the given tree and store the result in a temp array.
     * 2) Check if the temp array is sorted in ascending order, if it is, then the tree is BST.
     * <p>
     * Time Complexity: O(n)
     * <p>
     *
     * OPTIMIZATION METHOD  IS  WRONG !!
     *
     * We can avoid the use of Auxiliary Array.
     * While doing In-Order traversal, we can keep track of previously visited node.
     * If the value of the currently visited node is less than the previous value,
     * then tree is not BST.  this is for space optimization.
     */
    public static boolean isBst2(Node root) {
        if(null == root)
            return true;

        return isBSt2Util(root, null);
    }

    public static boolean isBSt2Util(Node root, Node prev){
        if(null == root)
            return true;

        // check for left sub tree.
        if(!isBst2(root.left))
            return false;

        // in inorder traversal of BST always prev node value is less than current
        // Allows only distinct valued nodes
        if(null != prev && prev.data >= root.data)
          return false;

        prev = root;

        // right subtree
        return isBst2(root.right);
    }


    public static void main(String[] args) {
        Node root = new Node(3);
        root.left = new Node(2);
        root.right = new Node(5);
        root.left.left = new Node(1);
        root.left.right = new Node(4);

        Node root1 = new Node(5);
        root1.left = new Node(3);
        root1.right = new Node(6);
        root1.left.left = new Node(2);
        root1.left.right = new Node(4);
        System.out.println(isBst2(root));
    }
}
