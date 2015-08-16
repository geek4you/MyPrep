/**
 * Created by chanumolu on 7/11/15.
 */

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @link : http://www.geeksforgeeks.org/iterative-postorder-traversal/
 *
 * TODO: good problem
 */
public class IterativePostOrder2Stacks {

    public static void iterativePostOrder(Node root) {

        if (null == root)
            return;

        Deque<Node> stack1 = new ArrayDeque<Node>();
        Deque<Node> stack2 = new ArrayDeque<Node>();

        stack1.push(root);

        while (!stack1.isEmpty()) {
            Node tmp = stack1.pop();
            stack2.push(tmp);
            if (null != tmp.left)
                stack1.push(tmp.left);
            if (null != tmp.right)
                stack1.push(tmp.right);
        }

        while (!stack2.isEmpty()) {
            System.out.println(stack2.pop().data);
        }
    }


    public static void main(String[] args) {

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        iterativePostOrder(root);
    }
}
