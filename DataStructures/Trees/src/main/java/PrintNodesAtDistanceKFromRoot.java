/**
 * Created by chanumolu on 7/5/15.
 */

/**
 * http://www.geeksforgeeks.org/print-nodes-at-k-distance-from-root/
 * Print nodes at k distance from root
 * Given a root of a tree, and an integer k. Print all the nodes which are at k distance from root.
 * <p>
 * For example, in the below tree, 4, 5 & 8 are at distance 2 from root.
 * 1
 * /   \
 * 2      3
 * /  \    /
 * 4     5  8
 */
public class PrintNodesAtDistanceKFromRoot {

    public static void printNodesDistK(Node root, int k) {

        if (null == root || k < 0)
            return;

        if (k == 0)
            System.out.println(root.data);

        printNodesDistK(root.left, k - 1);
        printNodesDistK(root.right, k - 1);

    }


    public static void main(String[] args) {
        Node root = new Node(1);
        root.left        = new Node(2);
        root.right       = new Node(3);
        root.left.left  = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(8);

        printNodesDistK(root,2);
    }
}
