/**
 * Created by chanumolu on 7/12/15.
 */

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Print ancestors of a given binary tree node without recursion
 * Given a Binary Tree and a key, write a function that prints all the ancestors of the key in the given binary tree.
 * <p>
 * It is clear that we need to use a stack based iterative traversal of the Binary Tree. The idea is to have all ancestors
 * in stack when we reach the node with given key. Once we reach the key, all we have to do is, print contents of stack.
 * How to get all ancestors in stack when we reach the given node? We can traverse all nodes in Postorder way. If we take
 * a closer look at the recursive postorder traversal, we can easily observe that, when recursive function is called for a
 * node, the recursion call stack contains ancestors of the node. So idea is do iterative Postorder traversal and stop the
 * traversal when we reach the desired node.
 *
 * TODO: complete this
 *
 */
public class IterativePrintAncestors {

    public static void printAncestors(Node root, int key) {

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

        while(!stack2.isEmpty()){
            Node tmp = stack2.pop();
            if(tmp.data == key){
                break;
            }else{
                System.out.print(tmp.data+" ");
            }

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
        root.left.left.left = new Node(8);
        root.left.right.right = new Node(9);
        root.right.right.left = new Node(10);

        for (int key = 1; key <= 10; key++) {
            System.out.print(key + ": ");
            printAncestors(root, key);
            System.out.println();
        }
    }
}

