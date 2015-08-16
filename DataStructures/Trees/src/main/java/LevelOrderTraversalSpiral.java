import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created by chanumolu on 7/3/15.
 */
public class LevelOrderTraversalSpiral {

    public static void printSpiralLevelOrder(Node root) {
        if (null == root)
            return;

        Deque<Node> stack1 = new ArrayDeque<Node>();
        Deque<Node> stack2 = new ArrayDeque<Node>();

        // if flag is true go left to right
        boolean flag = true;

        stack1.push(root);

        while (stack1.size() != 0 || stack2.size() != 0) {
            // left to right from stack1
            if (flag) {
                while (stack1.size() != 0) {
                    Node tmp = stack1.pop();
                    System.out.println(tmp.data);
                    if (null != tmp.left)
                        stack2.add(tmp.left);
                    if (null != tmp.right)
                        stack2.add(tmp.right);
                }
                flag = false;
            } else { // right to left from stack2
                while (stack2.size() != 0) {
                    Node tmp = stack2.pop();
                    System.out.println(tmp.data);
                    if (null != tmp.right)
                        stack1.add(tmp.right);
                    if (null != tmp.left)
                        stack1.add(tmp.left);
                }
                flag = true;
            }
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

        printSpiralLevelOrder(root);
    }
}
