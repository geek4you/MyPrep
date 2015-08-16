/**
 * Created by chanumolu on 8/4/15.
 */

/**
 * @link : http://www.geeksforgeeks.org/interval-tree/
 *
 *
 */
public class IntervalTree {

    // root of interval tree
    ITNode root;

    public IntervalTree(ITNode root) {
        this.root = root;
    }

    static void inorder(ITNode root)
    {
        if (root == null) return;

        inorder(root.left);

        System.out.println( "[" + root.interval.start + ", " + root.interval.end + "]"
                + " max = " + root.max );

        inorder(root.right);
    }

    // A utility function to insert a new Interval Search Tree Node
    // This is similar to BST Insert.  Here the low value of interval
    // is used tomaintain BST property
    static ITNode insert(ITNode root, Interval i)
    {
        // Base case: Tree is empty, new node becomes root
        if (root == null)
            return new ITNode(i);

        // Get low value of interval at root
        int l = root.interval.start;

        // If root's low value is smaller, then new interval goes to
        // left subtree
        if (i.start < l)
            root.left = insert(root.left, i);

            // Else, new node goes to right subtree.
        else
            root.right = insert(root.right, i);

        // Update the max value of this ancestor if needed
        if (root.max < i.end)
            root.max = i.end;

        return root;
    }
}
