/**
 * Created by chanumolu on 7/14/15.
 */

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @link : http://www.geeksforgeeks.org/find-next-right-node-of-a-given-key/
 * <p>
 * Find next right node of a given key
 * Given a Binary tree and a key in the binary tree, find the node right to the given key. If there is no node on right
 * side, then return NULL. Expected time complexity is O(n) where n is the number of nodes in the given binary tree.
 * <p>
 * For example, consider the following Binary Tree. Output for 2 is 6, output for 4 is 5. Output for 10, 6 and 5 is NULL.
 * <p>
 * 10
 * /      \
 * 2         6
 * /   \         \
 * 8      4          5
 */
public class NextRightNodeOfGivenKey {

    public static Node nextRight(Node root, int key) {
        if (null == root)
            return null;

        Deque<Node> queue = new ArrayDeque<Node>();
        queue.add(root);

        while (!queue.isEmpty()) {

            int ncount = queue.size();

            for (int i = ncount; i > 0; i--) {
                Node tmp = queue.poll();
                if (tmp.data == key) {
                    if (i > 1) {
                        return queue.poll();
                    }

                }

                if (null != tmp.left)
                    queue.add(tmp.left);
                if (null != tmp.right)
                    queue.add(tmp.right);
            }
        }

        return null;
    }

    public static void main(String[] args) {

        // Let us create binary tree given in the above example
        Node root = new Node(10);
        root.left = new Node(2);
        root.right = new Node(6);
        root.right.right = new Node(5);
        root.left.left = new Node(8);
        root.left.right = new Node(4);

        System.out.println("10: " + nextRight(root, 10));
        System.out.println("2: " + nextRight(root, 2).data);
        System.out.println("6: " + nextRight(root, 6));
        System.out.println("5: " + nextRight(root, 5));
        System.out.println("8: " + nextRight(root, 8).data);
        System.out.println("4: " + nextRight(root, 4).data);


    }
}
