/**
 * Created by chanumolu on 11/10/15.
 */

/**
 * http://www.geeksforgeeks.org/find-maximum-path-sum-two-leaves-binary-tree/
 * <p>
 * <p>
 * We can find the maximum sum using single traversal of binary tree. The idea is to maintain two values in recursive calls
 * 1) Maximum root to leaf path sum for the subtree rooted under current node.
 * 2) The maximum path sum between leaves (desired output).
 * <p>
 * For every visited node X, we find the maximum root to leaf sum in left and right subtrees of X.
 * We add the two values with X.data, and compare the sum with maximum path sum found so far.
 */
public class MaxPathSumBetweenTwoLeafNodesInBinaryTree {

    /**
     * A utility function to find the maximum sum between any
     * two leaves.This function calculates two values:
     * 1) Maximum path sum between two leaves which is stored
     * in res.
     * 2) The maximum root to leaf path sum which is returned.
     * If one side of root is empty, then it returns INT_MIN
     *
     * @param root
     * @param res
     * @return
     */

    static int maxPathSumUtil(Node root, IntegerHolder res) {
        // Base cases
        if (null == root)
            return 0;

        if (null == root.left && null == root.right)
            return root.data;

        // Find maximum sum in left and right subtree. Also
        // find maximum root to leaf sums in left and right
        // subtrees and store them in ls and rs
        int ls = maxPathSumUtil(root.left, res);
        int rs = maxPathSumUtil(root.right, res);

        // If both left and right children exist
        if (null != root.left && null != root.right) {
            // Update result if needed
            res.val = Math.max(res.val, ls + rs + root.data);

            // Return maxium possible value for root being
            // on one side
            return Math.max(ls, rs) + root.data;
        }

        // If any of the two children is empty, return
        // root sum for root being on one side
        return root.left == null ? rs + root.data : ls + root.data;
    }

    static int maxPathSum(Node root){
        IntegerHolder res = new IntegerHolder(Integer.MIN_VALUE);
        maxPathSumUtil(root, res);
        return res.val;
    }

    public static void main(String[] args) {
        Node root = new Node(-15);
        root.left = new Node(5);
        root.right = new Node(6);
        root.left.left = new Node(-8);
        root.left.right = new Node(1);
        root.left.left.left = new Node(2);
        root.left.left.right = new Node(6);
        root.right.left = new Node(3);
        root.right.right = new Node(9);
        root.right.right.right= new Node(0);
        root.right.right.right.left= new Node(4);
        root.right.right.right.right= new Node(-1);
        root.right.right.right.right.left= new Node(10);
        System.out.println(maxPathSum(root));
    }

    static class IntegerHolder {
        int val;

        public IntegerHolder(int val) {
            this.val = val;
        }
    }
}
