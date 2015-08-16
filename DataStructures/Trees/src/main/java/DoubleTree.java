/**
 * Created by chanumolu on 7/5/15.
 */

/**
 * @link : http://www.geeksforgeeks.org/double-tree/
 * Double Tree
 * Write a program that converts a given tree to its Double tree. To create Double tree of the given tree, create a new
 * duplicate for each node, and insert the duplicate as the left child of the original node.
 */
public class DoubleTree {

    public static Node doubleTree(Node root) {
        if (null == root)
            return null;

        // left and right sub trees
        root.left = doubleTree(root.left);
        root.right= doubleTree(root.right);

        // process this node.
        Node tmp = new Node(root.data);
        tmp.left= root.left;
        root.left = tmp;
        return root;

    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);

        System.out.println("Inorder traversal of the original tree is ");
        TreeTraversals.inorder(root);
        System.out.println("Double Tree: ");
        TreeTraversals.inorder(doubleTree(root));
    }
}
