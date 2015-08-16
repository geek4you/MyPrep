/**
 * Created by chanumolu on 7/12/15.
 */

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @link : http://www.geeksforgeeks.org/iterative-method-to-find-height-of-binary-tree/
 */
public class IterativeHeightOfBinaryTree {


    public static int height(Node root) {

        if (null == root)
            return 0;

        Deque<Node> queue = new ArrayDeque<Node>();
        queue.add(root);

        int count = 0;
        while (!queue.isEmpty()) {

            int nodeCount = queue.size();

            while (nodeCount > 0) {
                Node tmp = queue.poll();
                if (null != tmp.left)
                    queue.add(tmp.left);
                if (null != tmp.right)
                    queue.add(tmp.right);
                nodeCount--;
            }

            count++;
        }

        return count;
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);

        System.out.println(height(root));
    }
}
