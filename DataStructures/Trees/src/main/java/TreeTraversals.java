/**
 * Created by chanumolu on 7/1/15.
 */

/**
 * ALl tree traversals take O(n) time
 */
public class TreeTraversals {

    // left , root, right
    public static void inorder(Node root) {
        if (null == root)
            return;
        inorder(root.left);
        System.out.println(root.data);
        inorder(root.right);
    }

    // root, left , right
    public static void preorder(Node root) {
        if (null == root)
            return;

        System.out.println(root.data);
        preorder(root.left);
        preorder(root.right);

    }

    public static void postorder(Node root) {
        if (null == root)
            return;

        postorder(root.left);
        postorder(root.right);
        System.out.println(root.data);
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);

        System.out.println("\n Preorder traversal of binary tree is \n");
        preorder(root);

        System.out.println("\n Inorder traversal of binary tree is \n");
        inorder(root);

        System.out.println("\n Postorder traversal of binary tree is \n");
        postorder(root);

    }
}
