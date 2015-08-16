/**
 * Created by chanumolu on 7/14/15.
 */

import java.util.ArrayList;
import java.util.List;

/**
 * @link : http://www.geeksforgeeks.org/print-nodes-distance-k-leaf-node/
 * <p>
 * Print all nodes that are at distance k from a leaf node
 * Given a Binary Tree and a positive integer k, print all nodes that are distance k from a leaf node.
 * <p>
 * Here the meaning of distance is different from previous post. Here k distance from a leaf means k levels higher
 * than a leaf node. For example if k is more than height of Binary Tree, then nothing should be printed. Expected
 * time complexity is O(n) where n is the number nodes in the given Binary Tree.
 * <p>
 * The idea is to traverse the tree. Keep storing all ancestors till we hit a leaf node. When we reach a leaf node, we
 * print the ancestor at distance k. We also need to keep track of nodes that are already printed as output.
 * For that we use a boolean array visited[].
 */
public class PrintNodesAtDistKFromLeafNode {

    public static void printKDistantfromLeaf(Node root, int k) {
        List<Integer> path = new ArrayList<Integer>();
        List<Boolean> visited = new ArrayList<Boolean>();
        kDistantFromLeafUtil(root, path, visited, 0, k);
    }


    /* This function prints all nodes that are distance k from a leaf node
   path -. Store ancestors of a node
   visited -. Stores true if a node is printed as output.
   A node may be k distance away from many leaves, we want to print it once */
    public static void kDistantFromLeafUtil(Node root, List<Integer> path, List<Boolean> visited, int pathLen, int k) {

        // base case
        if (null == root)
            return;

        /* append this Node to the path  */
        path.add(pathLen, root.data);
        visited.add(pathLen, false);
        pathLen++;

        /* it's a leaf, so print the ancestor at distance k only
       if the ancestor is not already printed  */
        if (root.left == null && root.right == null &&
                pathLen - k - 1 >= 0 && visited.get(pathLen - k - 1) == false) {
            System.out.println(path.get(pathLen - k - 1));
            visited.add(pathLen - k - 1, true);
            return;
        }

        /* If not leaf node, recur for left and right subtrees */
        kDistantFromLeafUtil(root.left, path, visited, pathLen, k);
        kDistantFromLeafUtil(root.right, path, visited, pathLen, k);

    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        root.right.left.right = new Node(8);

        printKDistantfromLeaf(root,2);
    }

}

