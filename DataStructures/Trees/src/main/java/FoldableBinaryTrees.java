/**
 * Created by chanumolu on 7/6/15.
 */

/**
 * @link : http://www.geeksforgeeks.org/foldable-binary-trees/
 * A tree can be folded if left and right subtrees of the tree are structure wise mirror image of each other.
 * An empty tree is considered as foldable.
 * Consider the below trees:
 * (a) and (b) can be folded.
 * (c) and (d) cannot be folded.
 * <p>
 * (a)
 *      10
 *    /    \
 *   7      15
 *    \    /
 *    9  11
 * <p>
 * (b)
 *      10
 *     /  \
 *    7    15
 *   /      \
 *  9       11
 * <p>
 * (c)
 *       10
 *      /  \
 *     7   15
 *    /    /
 *   5   11
 * <p>
 * (d)
 * <p>
 *      10
 *     /   \
 *    7     15
 *   /  \    /
 *  9   10  12
 */
public class FoldableBinaryTrees {

    public static boolean isFoldable(Node root){
        if(null == root)
            return true;

        return isFoldableUtil(root.left, root.right);
    }

    public static boolean isFoldableUtil(Node root1, Node root2) {

        if (null == root1 && null == root2)
            return true;

        if (null == root1 || null == root2)
            return false;


        // move down
        return isFoldableUtil(root1.left, root2.right) && isFoldableUtil(root1.right, root2.left);
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.right.left = new Node(4);
        root.left.right = new Node(5);

        System.out.println("isFoldable: "+isFoldable(root));
    }
}
