/**
 * Created by chanumolu on 7/13/15.
 */

/**
 * Given a binary tree, a complete path is defined as a path from root to a leaf. The sum of all nodes on that path is defined as the sum of that path. Given a number K, you have to remove (prune the tree) all nodes which don’t lie in any path with sum>=k.
 * <p>
 * Note: A node can be part of multiple paths. So we have to delete it only in case when all paths from it have sum less than K.
 * <p>
 * Consider the following Binary Tree
 * 1
 * /      \
 * 2        3
 * /   \     /  \
 * 4     5   6    7
 * / \    /       /
 * 8   9  12      10
 * / \           \
 * 13  14         11
 * /
 * 15
 * <p>
 * For input k = 20, the tree should be changed to following
 * (Nodes with values 6 and 8 are deleted)
 * 1
 * /      \
 * 2        3
 * /   \        \
 * 4     5        7
 * \    /       /
 * 9  12      10
 * / \           \
 * 13  14         11
 * /
 * 15
 * <p>
 * For input k = 45, the tree should be changed to following.
 * 1
 * /
 * 2
 * /
 * 4
 * \
 * 9
 * \
 * 14
 * /
 * 15
 * <p>
 * <p>
 * We strongly recommend you to minimize the browser and try this yourself first.
 * <p>
 * The idea is to traverse the tree and delete nodes in bottom up manner. While traversing the tree, recursively calculate
 * the sum of nodes from root to leaf node of each path. For each visited node, checks the total calculated sum against given
 * sum “k”. If sum is less than k, then free(delete) that node (leaf node) and return the sum back to the previous node.
 * Since the path is from root to leaf and nodes are deleted in bottom up manner, a node is deleted only when all of its
 * descendants are deleted. Therefore, when a node is deleted, it must be a leaf in the current Binary Tree.
 */
public class RemoveNodesWhichDontLieInAnyPathWithSumGreaterThanK {

    public static Node removeNodes(Node root, int k) {
        if (null == root)
            return null;


        return removeNodesUtil(root, k, new IntergerHolder1(0));
    }

    public static Node removeNodesUtil(Node root, int k, IntergerHolder1 sum) {

        if (null == root)
            return null;

        // Post order traversal
        // Initialize left and right sums as sum from root to
        // this node (including this node)
        IntergerHolder1 lsum = new IntergerHolder1(sum.val + root.data);
        IntergerHolder1 rsum = lsum;

        // Recursively prune left and right subtrees
        root.left = removeNodesUtil(root.left, k, lsum);
        root.right = removeNodesUtil(root.right, k, rsum);

        // After the recursion finished, lsum reprensents the max path value
        // from the root of this root to curNode.left to every leaf.

        // Get the maximum of left and right sums
        sum.val = Math.max(lsum.val, rsum.val);

        // If maximum is smaller than k, then this node
        // must be deleted
        if (sum.val < k) {
            return null;
        }

        return root;

    }


    public static void main(String[] args) {
        int k = 45;
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        root.left.left.left = new Node(8);
        root.left.left.right = new Node(9);
        root.left.right.left = new Node(12);
        root.right.right.left = new Node(10);
        root.right.right.left.right = new Node(11);
        root.left.left.right.left = new Node(13);
        root.left.left.right.right = new Node(14);
        root.left.left.right.right.left = new Node(15);

        System.out.println("Tree before truncation");
        LevelOrderTraversal.bfs(root);
        System.out.println("Tree after truncation");
        LevelOrderTraversal.bfs(removeNodes(root, k));
    }
}

// This wrapper is simulating pointer.
// int is primitive type and Integer is immutable so neither of them can
// be used for call by referrence. You can create int[] {0} but it will
// confuse people.
class IntergerHolder1 {
    int val;

    IntergerHolder1(int val) {
        this.val = val;
    }
}
