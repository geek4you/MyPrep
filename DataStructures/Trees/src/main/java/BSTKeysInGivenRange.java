/**
 * Created by chanumolu on 7/7/15.
 */

/*
@link : http://www.geeksforgeeks.org/print-bst-keys-in-the-given-range/

Print BST keys in the given range
Given two values k1 and k2 (where k1 < k2) and a root pointer to a Binary Search Tree. Print all the keys of tree in
range k1 to k2. i.e. print all x such that k1<=x<=k2 and x is a key of given BST. Print all the keys in increasing order.

For example, if k1 = 10 and k2 = 22, then your function should print 12, 20 and 22.
 */
public class BSTKeysInGivenRange {

    public static void printKeysInRange(Node root, int key1, int key2) {
        if (null == root)
            return;

        if (root.data > key1)
            printKeysInRange(root.left, key1, key2);

        if (root.data > key1 && root.data < key2)
            System.out.println(root.data);

        if (root.data < key2)
            printKeysInRange(root.right, key1, key2);

    }

    public static void main(String[] args) {
        Node root = new Node(20);
        root.left = new Node(8);
        root.right = new Node(22);
        root.left.left = new Node(4);
        root.left.right = new Node(12);

        printKeysInRange(root,10,25);
    }
}
