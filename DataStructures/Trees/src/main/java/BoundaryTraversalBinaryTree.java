/**
 * Created by chanumolu on 7/11/15.
 */

/**
 * @link : http://www.geeksforgeeks.org/boundary-traversal-of-binary-tree/
 * Given a binary tree, print boundary nodes of the binary tree Anti-Clockwise starting from the root.
 */

// TODO: interesting problem
public class BoundaryTraversalBinaryTree {

    public static void printBoundary(Node root) {
        if (null == root)
            return;

        printLeftNodesTopToBottom(root);

        printLeafNodesLeftToRight(root);

        printRightNodesBottomToTop(root.right);

    }

    // A function to print all left boundry nodes, except a leaf node.
    // Print the nodes in TOP DOWN manner
    public static void printLeftNodesTopToBottom(Node root) {

        if (null == root)
            return;

        Node current = root;

        if (current.left != null) {
            // to ensure top down order, print the node
            // before calling itself for left subtree
            System.out.println(current.data);
            printLeftNodesTopToBottom(current.left);
        } else if (current.right != null) {
            System.out.println(current.data);
            printLeftNodesTopToBottom(current.right);
        }
        // do nothing if it is a leaf node, this way we avoid
        // duplicates in output

    }

    // A simple function to print leaf nodes of a binary tree
    public static void printLeafNodesLeftToRight(Node root) {

        if (null == root)
            return;

        printLeafNodesLeftToRight(root.left);

        if (null == root.left && null == root.right) {
            System.out.println(root.data);
        }

        printLeafNodesLeftToRight(root.right);
    }

    // A function to print all right boundry nodes, except a leaf node
    // Print the nodes in BOTTOM UP manner
    public static void printRightNodesBottomToTop(Node root) {

        if (null == root)
            return;

        if (root.right != null) {
            // to ensure bottom up order, first call for right
            //  subtree, then print this node
            printRightNodesBottomToTop(root.right);
            System.out.println(root.data);
        } else if (root.left != null) {
            printRightNodesBottomToTop(root.left);
            System.out.println(root.data);
        }
        // do nothing if it is a leaf node, this way we avoid
        // duplicates in output

    }

    public static void main(String[] args) {
        Node root = new Node(20);
        root.left = new Node(8);
        root.left.left = new Node(4);
        root.left.right = new Node(12);
        root.left.right.left = new Node(10);
        root.left.right.right = new Node(14);
        root.right = new Node(22);
        root.right.right = new Node(25);

        printBoundary(root);
    }

}
