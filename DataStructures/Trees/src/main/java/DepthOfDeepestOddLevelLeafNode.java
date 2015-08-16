/**
 * Created by chanumolu on 7/12/15.
 */

/**
 * @link : http://www.geeksforgeeks.org/find-depth-of-the-deepest-odd-level-node/
 *
 * The idea is to recursively traverse the given binary tree and while traversing, maintain a variable “level” which
 * will store the current node’s level in the tree. If current node is leaf then check “level” is odd or not. If level
 * is odd then return it. If current node is not leaf, then recursively find maximum depth in left and right subtrees,
 * and return maximum of the two depths.
 */
public class DepthOfDeepestOddLevelLeafNode {

    public static int depthOfDeepestLeafNode(Node root) {
        if (null == root)
            return 0;
        return depthOfDeepestLeafNodeUtil(root, 1);

    }

    public static int depthOfDeepestLeafNodeUtil(Node root, int lvl) {
        if (null == root)
            return 0;


        // If this node is a leaf and its level is odd, return its level
        if((lvl%2!=0) & null == root.left && null == root.right){
            return lvl;
        }

        // If not leaf, return the maximum value from left and right subtrees
        return Math.max(depthOfDeepestLeafNodeUtil(root.left,lvl+1),depthOfDeepestLeafNodeUtil(root.right,lvl+1));

    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.right.left = new Node(5);
        root.right.right = new Node(6);
        root.right.left.right = new Node(7);
        root.right.right.right = new Node(8);
        root.right.left.right.left = new Node(9);
        root.right.right.right.right = new Node(10);
        root.right.right.right.right.left = new Node(11);

        System.out.println(depthOfDeepestLeafNode(root));
    }


}
