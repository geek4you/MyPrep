/**
 * Created by chanumolu on 7/14/15.
 */

/**
 *
 * @link : http://www.geeksforgeeks.org/sum-numbers-formed-root-leaf-paths/
 * Given a binary tree, where every node value is a Digit from 1-9 .Find the sum of all the numbers which are formed
 * from root to leaf paths.
 * <p>
 * For example consider the following Binary Tree.
 * <p>
 * 6
 * /      \
 * 3          5
 * /   \          \
 * 2     5          4
 * /   \
 * 7     4
 * There are 4 leaves, hence 4 root to leaf paths:
 * Path                    Number
 * 6->3->2                   632
 * 6->3->5->7               6357
 * 6->3->5->4               6354
 * 6->5>4                    654
 * Answer = 632 + 6357 + 6354 + 654 = 13997
 * <p>
 * The idea is to do a preorder traversal of the tree. In the preorder traversal, keep track of the value calculated till
 * the current node, let this value be val. For every node, we update the val as val*10 plus node’s data.
 */
public class SumAllNumbersThatAreFormedFromRootToLeafPaths {

    // A wrapper function over treePathsSumUtil()
    public static int treePathsSum(Node root) {
        // Pass the initial value as 0 as there is nothing above root
        return treePathsSumUtil(root, 0);
    }

    public static int treePathsSumUtil(Node root, int val) {
        // base
        if (null == root)
            return 0;

        // update val
        val = val * 10 + root.data;

        // if current node is leaf, return the current value of val
        if (null == root.left && null == root.right)
            return val;

        // recur sum of values for left and right subtree
        return treePathsSumUtil(root.left, val) +
                treePathsSumUtil(root.right, val);
    }

    public static void main(String[] args) {
        Node root = new Node(6);
        root.left = new Node(3);
        root.right = new Node(5);
        root.right.right = new Node(7);
        root.left.left = new Node(2);
        root.left.right = new Node(5);
        root.right.right = new Node(4);
        root.left.right.left = new Node(7);
        root.left.right.right = new Node(4);

        System.out.println(treePathsSum(root));
    }
}
