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
    }


}
