/**
 * Created by chanumolu on 7/14/15.
 */

/**
 * Find_Duplicates_In_BST.
 * <p>
 * Usualy, bst is defined as: if an element is less than the value of
 * current node then it goes left. If it's larger than the value of
 * current node then it goes right.
 * <p>
 * Let's redefine it: if an element is equal or larger than the value of
 * current node then it goes right.
 * <p>
 * For example, a bst is generated with such rule might look like:
 * <p>
 * 1
 * / \
 * 0   1
 * <p>
 * Question, given the root of the bst, check if this tree has duplicates
 * elements.
 */

public class FindDuplicatesInBST {

    public static void printDuplicates(Node root) {
        if (null == root)
            return;

        printDuplicatesUtil(root.left, root.data);
        printDuplicatesUtil(root.right, root.data);
    }

    public static void printDuplicatesUtil(Node root, int carry) {
        if (null == root)
            return;

        if (root.data == carry)
            System.out.println(root.data);

        // TODO: both conditions are different
        printDuplicatesUtil(root.left, carry);
        printDuplicatesUtil(root.right, root.data);
    }

    public static void main(String[] args) {
        Node root;
        // Test case 1.
        System.out.println("Test1:");
        root = new Node(1);
        root.right = new Node(1);
        printDuplicates(root);

        // Test case 2.
        System.out.println("Test2:");
        root = new Node(1);
        root.left = new Node(0);
        root.right = new Node(2);
        root.right.right = new Node(2);
        printDuplicates(root);

        // Test case 3.
        root = new Node(1);
        root.right = new Node(4);
        root.right.right = new Node(8);
        root.right.right.left = new Node(7);
        root.right.right.left.left = new Node(4);
        System.out.println("Test3");
        printDuplicates(root);

    }
}
