/**
 * Created by chanumolu on 7/7/15.
 */
public class PrintAncestorsOfGivenNode {

    public static boolean printAncestors(Node root, int key) {
        if (null == root)
            return false;

        if (root.data == key)
            return true;

        boolean left = printAncestors(root.left, key);
        boolean right = printAncestors(root.right, key);

        if (left || right) {
            System.out.println(root.data);
            return true;
        }

        return false;

    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.left.left.left = new Node(7);

        printAncestors(root,5);
    }
}
