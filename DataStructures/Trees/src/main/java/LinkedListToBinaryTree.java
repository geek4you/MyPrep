/**
 * Created by chanumolu on 7/11/15.
 */

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @link : http://www.geeksforgeeks.org/given-linked-list-representation-of-complete-tree-convert-it-to-linked-representation/
 * <p>
 * Construct Complete Binary Tree from its Linked List Representation
 * Given Linked List Representation of Complete Binary Tree, construct the Binary tree. A complete binary tree can be represented
 * in an array in the following approach.
 * <p>
 * If root node is stored at index i, its left, and right children are stored at indices 2*i+1, 2*i+2 respectively.
 * Suppose tree is represented by a linked list in same way, how do we convert this into normal linked representation of binary
 * tree where every node has data, left and right pointers? In the linked list representation, we cannot directly access the
 * children of the current node unless we traverse the list.
 * <p>
 * 10 -> 12 ->15 ->25 ->30 -> 36
 * <p>
 * The above linked list represents the following binary tree
 * <p>
 * 10
 * /       \
 * 12        15
 * /.\        /
 * 25   30    36
 * <p>
 * <p>
 * We are mainly given level order traversal in sequential access form. We know head of linked list is always is root
 * of the tree. We take the first node as root and we also know that the next two nodes are left and right children of
 * root. So we know partial Binary Tree. The idea is to do Level order traversal of the partially built Binary Tree
 * using queue and traverse the linked list at the same time. At every step, we take the parent node from queue, make
 * next two nodes of linked list as children of the parent node, and enqueue the next two nodes to queue.
 * <p>
 * 1. Create an empty queue.
 * 2. Make the first node of the list as root, and enqueue it to the queue.
 * 3. Until we reach the end of the list, do the following.
 * ………a. Dequeue one node from the queue. This is the current parent.
 * ………b. Traverse two nodes in the list, add them as children of the current parent.
 * ………c. Enqueue the two nodes into the queue.
 */
public class LinkedListToBinaryTree {

    public static Node linkedListToTree(LNode head) {
        // base case
        if (null == head)
            return null;

        // queue to store the parent nodes
        Deque<Node> queue = new ArrayDeque<Node>();

        // 1.) The first node is always the root node, and add it to the queue
        Node root = new Node(head.data);
        queue.push(root);

        // advance the pointer to the next node
        LNode current = head.next;

        // until the end of linked list is reached, do the following steps
        while (null != current) {
            // 2.a) take the parent node from the queue and remove it from queue
            Node parent = queue.poll();

            // 2.c) take next two nodes from the linked list. We will add
            // them as children of the current parent node in step 2.b. Push them
            // into the queue so that they will be parents to the future nodes
            Node leftChild = new Node(current.data);
            queue.push(leftChild);
            Node rightChild = null;
            current = current.next;
            if (null != current) {
                rightChild = new Node(current.data);
                queue.push(rightChild);
                current = current.next;
            }

            // 2.b) assign the left and right children of parent
            parent.left = leftChild;
            parent.right = rightChild;
        }

        return root;
    }

    public static void main(String[] args) {
        LNode head = new LNode(10);
        head.next = new LNode(12);
        head.next.next = new LNode(15);
        head.next.next.next = new LNode(25);
        head.next.next.next.next = new LNode(30);
        head.next.next.next.next.next = new LNode(36);

        Node root = linkedListToTree(head);

        TreeTraversals.inorder(root);
        System.out.println("PRE-ORDER");
        TreeTraversals.preorder(root);

    }
}

class LNode {
    int data;
    LNode next;

    LNode(int data) {
        this.data = data;
        next = null;
    }
}
