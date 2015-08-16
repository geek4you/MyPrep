import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created by chanumolu on 7/4/15.
 */
public class InorderWithoutRecurssion {


    // using stack
    public static void inOrder1(Node root) {
        if (null == root)
            return;

        Deque<Node> stack = new ArrayDeque<Node>();
        Node current = root;
        boolean done = false;

        while (!done) {
            // Reach the left most node of the current node
            if (current != null) {
                // place pointer to a tree node on the stack before traversing the node's left subtree
                stack.push(current);
                current = current.left;
            }else{
                //backtrack from the empty subtree and visit the tNode
                // at the top of the stack; however, if the stack is empty,
                // you are done
                if(stack.size()!=0){
                    current = stack.pop();
                    System.out.println(current.data);
                    //we have visited the node and its left subtree.
                    // Now, it's right subtree's turn
                    current = current.right ;
                }else{
                    done = true;
                }
            }
        }
    }

    //TODO: morris inorder traversal without stack

    public static void main(String[] args) {
        Node root = new Node(50);
        root.left = new Node(7);
        root.right = new Node(2);
        root.left.left = new Node(3);
        root.left.right = new Node(5);
        root.right.left = new Node(1);
        root.right.right = new Node(30);

        inOrder1(root);
    }
}
