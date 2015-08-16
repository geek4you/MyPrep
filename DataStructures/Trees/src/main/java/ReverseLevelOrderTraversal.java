/**
 * Created by chanumolu on 7/11/15.
 */

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @link : http://www.geeksforgeeks.org/reverse-level-order-traversal/
 */
public class ReverseLevelOrderTraversal {

    public static void reverseLvlOrder(Node root) {

        if (null == root)
            return;

        Deque<Node> stack = new ArrayDeque<Node>();
        Deque<Node> queue = new ArrayDeque<Node>();

        queue.push(root);

        while (!queue.isEmpty()) {
            Node tmp = queue.poll();
            stack.push(tmp);
            if (null != tmp.right)
                queue.add(tmp.right);
            if (null != tmp.left)
                queue.add(tmp.left);
        }

        while (!stack.isEmpty()){
            System.out.println(stack.pop().data);
        }
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left        = new Node(2);
        root.right       = new Node(3);
        root.left.left  = new Node(4);
        root.left.right = new Node(5);
        root.right.left  = new Node(6);
        root.right.right = new Node(7);

        reverseLvlOrder(root);
    }
}
