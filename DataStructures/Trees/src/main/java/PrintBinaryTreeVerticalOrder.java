/**
 * Created by chanumolu on 7/14/15.
 */

import java.util.*;

/**
 * Print a Binary Tree in Vertical Order | Set 1
 * Given a binary tree, print it vertically. The following example illustrates vertical order traversal.
 * <p>
 * 1
 * /    \
 * 2      3
 * / \    / \
 * 4   5  6   7
 * \   \
 * 8   9
 * <p>
 * <p>
 * The output of print this tree vertically will be:
 * 4
 * 2
 * 1 5 6
 * 3 8
 * 7
 * 9
 * <p>
 * sol: use hashmap(HashMap<horizontalDist,LinkedList>  and store all the nodes for the vertical height
 * print them
 * <p>
 * <p>
 * An efficient solution based on hash map is discussed. We need to check the Horizontal Distances from root for all nodes.
 * If two nodes have the same Horizontal Distance (HD), then they are on same vertical line. The idea of HD is simple.
 * HD for root is 0, a right edge (edge connecting to right subtree) is considered as +1 horizontal distance and a left
 * edge is considered as -1 horizontal distance. For example, in the above tree, HD for Node 4 is at -2, HD for Node 2 is -1,
 * HD for 5 and 6 is 0 and HD for node 7 is +2.
 * <p>
 * We can do inorder traversal of the given Binary Tree. While traversing the tree, we can recursively calculate HDs.
 * We initially pass the horizontal distance as 0 for root. For left subtree, we pass the Horizontal Distance as Horizontal
 * distance of root minus 1. For right subtree, we pass the Horizontal Distance as Horizontal Distance of root plus 1.
 * For every HD value, we maintain a list of nodes in a hasp map. Whenever we see a node in traversal, we go to the hash
 * map entry and add the node to the hash map using HD as a key in map.
 */
public class PrintBinaryTreeVerticalOrder {

    static void printBinaryTreeVerticleOrder(Node root, int hd, Map<Integer, List<Node>> map) {
        if (null == root)
            return;

        printBinaryTreeVerticleOrder(root.left, hd - 1, map);
        if (map.containsKey(hd)) {
            map.get(hd).add(root);
        } else {
            List<Node> l = new ArrayList<Node>();
            l.add(root);
            map.put(hd, l);
        }
        printBinaryTreeVerticleOrder(root.right, hd + 1, map);
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
        root.right.right.right = new Node(9);

        Map<Integer, List<Node>> map = new HashMap<Integer, List<Node>>();
        printBinaryTreeVerticleOrder(root,0,map);

        for(Map.Entry e : map.entrySet()){
            System.out.println((((List)e.getValue()).toString()));
        }
    }

}


