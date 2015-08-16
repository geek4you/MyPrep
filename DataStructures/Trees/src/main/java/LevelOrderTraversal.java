/**
 * Created by chanumolu on 7/3/15.
 */

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @link : http://www.geeksforgeeks.org/level-order-tree-traversal/
 * Breadth first search
 * <p>
 * Time: O(n)
 */
public class LevelOrderTraversal {

    public static void bfs(Node root) {
        if (null == root) {
            return;
        }

        Queue<Node> queue = new ArrayDeque<Node>();
        queue.add(root);

        while (queue.size() != 0) {
            Node tmp = queue.poll();
            System.out.println(tmp.data);
            if (tmp.left != null)
                queue.add(tmp.left);
            if (tmp.right != null)
                queue.add(tmp.right);
        }
    }

    public static void main(String[] args) {
        Node root = new Node(20);
        root.left = new Node(8);
        root.right = new Node(22);
        root.left.left = new Node(4);
        root.left.right = new Node(12);
        root.left.right.left = new Node(10);
        root.left.right.right = new Node(14);

        bfs(root);
    }

}
