/**
 * Created by chanumolu on 7/11/15.
 */

/**
 * @link :http://www.geeksforgeeks.org/remove-bst-keys-outside-the-given-range/
 * <p>
 * Remove BST keys outside the given range
 * Given a Binary Search Tree (BST) and a range [min, max], remove all keys which are outside the given range.
 * The modified tree should also be BST. For example, consider the following BST and range [-10, 13].
 * <p>
 * TODO: nice problem
 */
public class RemoveBSTKeysOutsideGivenRange {

    // do bottom up approach
    public static Node removeKeysOutsideOfRange(Node root, int low, int high) {

        // base case
        if (null == root)
            return null;

        root.left = removeKeysOutsideOfRange(root.left,low,high);
        root.right = removeKeysOutsideOfRange(root.right,low,high);

        if (root.data >= low && root.data <= high)
            return root;

        if (root.data < low)
            return root.right;

        if (root.data > high)
            return root.left;

        return null;
    }


    public static void main(String[] args) {
        Node root = new Node(6);
        root.left = new Node(-13);
        root.right = new Node(14);
        root.left.right = new Node(-8);
        root.right.left = new Node(13);
        root.right.left.left = new Node(7);
        root.right.right = new Node(15);

        TreeTraversals.inorder(removeKeysOutsideOfRange(root,-10,13));
    }
}
