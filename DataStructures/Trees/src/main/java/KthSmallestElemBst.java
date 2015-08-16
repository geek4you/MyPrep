/**
 * Created by chanumolu on 7/6/15.
 */

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @link : http://www.geeksforgeeks.org/find-k-th-smallest-element-in-bst-order-statistics-in-bst/
 * <p>
 * Find k-th smallest element in BST (Order Statistics in BST)
 * Given root of binary search tree and K as input, find K-th smallest element in BST.
 */
public class KthSmallestElemBst {

    // inorder traversal should return the kth elem
    public static int kthElem(Node root, int k ) {

        if (null == root)
            return -1;

        int count = 0;
        int returnVal = -1;
        Deque<Node> stack = new ArrayDeque<Node>();

        Node current = root;
        boolean done = false;
        while (!done) {
            if(current!=null){
                stack.push(current);
                current = current.left;
            }else if(!stack.isEmpty()){
                count ++;
                current = stack.pop();
                if(count==k)
                    return current.data;
                current = current.right;
            }else{
                done = true;
            }


        }

        return -1;
    }

    public static void main(String[] args) {
        Node root = new Node(20);
        root.left = new Node(8);
        root.right = new Node(22);
        root.left.left = new Node(4);
        root.left.right = new Node(12);
        root.left.right.left = new Node(10);
        root.left.right.right = new Node(14);
        System.out.println(kthElem(root, 5));
    }

}
