/**
 * Created by chanumolu on 7/4/15.
 */

/**
 * @link : http://www.geeksforgeeks.org/convert-an-arbitrary-binary-tree-to-a-tree-that-holds-children-sum-property/
 * <p>
 * Given an arbitrary binary tree, convert it to a binary tree that holds Children Sum Property. You can only increment data values in any node (You cannot change structure of tree and cannot decrement value of any node).
 * <p>
 * For example, the below tree doesn’t hold the children sum property, convert it to a tree that holds the property.
 * <p>
 * 50
 * /     \
 * /         \
 * 7             2
 * / \             /\
 * /     \          /   \
 * 3        5      1      30
 */
public class ConvertChildrenSumProperty {

    public static void convertCSP(Node root) {

        if (null == root)
            return;

        // check if leaf node
        if (null == root.left && null == root.right)
            return;

        // traverse using postorder as you want to come from down to up.
        convertCSP(root.left);
        convertCSP(root.right);

        //check the sums
        int lChild = 0, rChild = 0;
        if (null != root.left)
            lChild = root.left.data;
        if (null != root.right)
            rChild = root.right.data;

        int diff =  (lChild + rChild) - root.data;

        if (diff == 0) // we re good
            return;
        else if (diff > 0) // increment the parent
            root.data += diff;
        else // increment the children
            increment(root, Math.abs(diff));

    }

    public static void increment(Node root, int diff) {

        if (null == root)
            return;
        // try to increment the left child first
        if (null != root.left) {
            root.left.data += diff;
            increment(root.left, diff);
        } else if (null != root.right) { // increment right child as left child doesn't exist
            root.right.data += diff;
            increment(root.right, diff);
        } else // if not both its leaf node.
            return;

    }

    public static void main(String[] args) {
        Node root = new Node(50);
        root.left = new Node(7);
        root.right = new Node(2);
        root.left.left = new Node(3);
        root.left.right = new Node(5);
        root.right.left = new Node(1);
        root.right.right = new Node(30);

        System.out.println("Tree: ");
        TreeTraversals.preorder(root);
        System.out.println("After modifying: ");
        convertCSP(root);
        TreeTraversals.preorder(root);
    }
}
