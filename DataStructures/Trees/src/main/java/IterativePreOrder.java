/**
 * Created by chanumolu on 7/11/15.
 */

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @link : http://www.geeksforgeeks.org/iterative-preorder-traversal/
 */
public class IterativePreOrder {

    public static void iterativePreOrder(Node root) {

        if (null == root)
            return;

        Deque<Node> stack = new ArrayDeque<Node>();

        Node current = root;

        stack.push(current);

        while (!stack.isEmpty()) {
            Node tmp = stack.pop();
            System.out.println(tmp.data);
            if (null != tmp.right)
                stack.push(tmp.right);
            if (null != tmp.left)
                stack.push(tmp.left);
        }

    }

    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(8);
        root.right = new Node(2);
        root.left.left = new Node(3);
        root.left.right = new Node(5);
        root.right.left = new Node(2);

        iterativePreOrder(root);
    }
}
