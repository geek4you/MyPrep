/**
 * Created by chanumolu on 7/7/15.
 */

/**
 * @link : http://www.geeksforgeeks.org/how-to-determine-if-a-binary-tree-is-balanced/
 * <p>
 * How to determine if a binary tree is height-balanced?
 * A tree where no leaf is much farther away from the root than any other leaf. Different balancing schemes allow different
 * definitions of “much farther” and different amounts of work to keep them balanced.
 * <p>
 * Consider a height-balancing scheme where following conditions should be checked to determine if a binary tree is balanced.
 * An empty tree is height-balanced. A non-empty binary tree T is balanced if:
 * 1) Left subtree of T is balanced
 * 2) Right subtree of T is balanced
 * 3) The difference between heights of left subtree and right subtree is not more than 1.
 */
public class BinaryTreeHeightBalanced {

    public static boolean isHeightBalanced(Node root) {

        if (null == root)
            return true;

        return Math.abs(HeightOfTree.height(root.left) - HeightOfTree.height(root.right)) < 2 &&
                (isHeightBalanced(root.left) && isHeightBalanced(root.right));
    }

    /* Takes O(n) time */
    /*Above implementation can be optimized by calculating the height in the same recursion rather than calling a height()
     function separately. Thanks to Amar for suggesting this optimized version. This optimization reduces time complexity to O(n). */

    /* The function returns true if root is balanced else false
   The second parameter is to store the height of tree.
   Initially, we need to pass a pointer to a location with value
   as 0. We can also write a wrapper over this function */
    public static boolean isBalanced(Node root, IntegerObject height) {

        /* lh --> Height of left subtree
           rh --> Height of right subtree */
        IntegerObject lh = new IntegerObject(0);
        IntegerObject rh = new IntegerObject(0);

        /* l will be true if left subtree is balanced
        and r will be true if right subtree is balanced */
        boolean l = false, r = false;

        if (root == null) {
            height.height = 0;
            return true;
        }

        /* Get the heights of left and right subtrees in lh and rh
            And store the returned values in l and r */
        l = isBalanced(root.left, lh);
        r = isBalanced(root.right, rh);

        /* Height of current node is max of heights of left and
            right subtrees plus 1*/
        height.height = (lh.height > rh.height ? lh : rh).height + 1;

        /* If difference between heights of left and right
            subtrees is more than 2 then this node is not balanced
            so return 0 */
        if ((lh.height - rh.height >= 2) || (rh.height - lh.height >= 2))
            return false;

        /* If this node is balanced and left and right subtrees
            are balanced then return true */
        else return l && r;
    }

    public static void main(String[] args) {
        Node root1 = new Node(1);
        root1.left = new Node(2);
        root1.right = new Node(3);
        root1.left.left = new Node(4);
        root1.left.right = new Node(5);
        root1.left.left.left = new Node(8);

        Node root2 = new Node(1);
        root2.left = new Node(2);
        root2.right = new Node(3);
        root2.left.left = new Node(4);
        root2.left.right = new Node(5);

        System.out.println(isHeightBalanced(root1));
        System.out.println(isHeightBalanced(root2));

        System.out.println(isBalanced(root1, new IntegerObject(0)));
        System.out.println(isBalanced(root2, new IntegerObject(0)));
    }

    static class IntegerObject {
        int height;

        public IntegerObject(int height) {
            this.height = height;
        }
    }


}
