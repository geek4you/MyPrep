/**
 * Created by chanumolu on 7/4/15.
 */

/**
 * @link : http://www.geeksforgeeks.org/check-for-children-sum-property-in-a-binary-tree/
 * <p>
 * Given a binary tree, write a function that returns true if the tree satisfies below property.
 * <p>
 * For every node, data value must be equal to sum of data values in left and right children.
 * Consider data value as 0 for NULL children
 */
public class ChildrenSumProperty {

    public static boolean isSumProperty(Node root) {

        if (null == root)
            return true;

        // initialize both sums to zero
        int lchild = 0;
        int rChild = 0;

        // check if leaf node
        if (null == root.left && null == root.right)
            return true;

        // check if node doesnot have left child
        if (null != root.left)
            lchild = root.left.data;

        if (null != root.right)
            rChild = root.right.data;

        return (root.data == (lchild + rChild)) && isSumProperty(root.left) && isSumProperty(root.right);
    }

    public static void main(String[] args) {
        Node root  = new Node(10);
        root.left         = new Node(8);
        root.right        = new Node(2);
        root.left.left   = new Node(3);
        root.left.right  = new Node(5);
        root.right.right = new Node(2);

        System.out.println(isSumProperty(root));
    }
}
