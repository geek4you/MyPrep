/**
 * Created by chanumolu on 7/12/15.
 */

/**
 * @link : http://www.geeksforgeeks.org/tree-isomorphism-problem/
 * <p>
 * Write a function to detect if two trees are isomorphic. Two trees are called isomorphic if one of them can be
 * obtained from other by a series of flips, i.e. by swapping left and right children of a number of nodes.
 * Any number of nodes at any level can have their children swapped. Two empty trees are isomorphic.
 * <p>
 * <p>
 * We simultaneously traverse both trees. Let the current internal nodes of two trees being traversed be n1 and n2 respectively.
 * There are following two conditions for subtrees rooted with n1 and n2 to be isomorphic.
 * 1) Data of n1 and n2 is same.
 * 2) One of the following two is true for children of n1 and n2
 * ……a) Left child of n1 is isomorphic to left child of n2 and right child of n1 is isomorphic to right child of n2.
 * ……b) Left child of n1 is isomorphic to right child of n2 and right child of n1 is isomorphic to left child of n2.
 */
public class TwoTreesIsomorphic {

    public static boolean isIsomorphic(Node root1, Node root2) {
        if (null == root1 && null == root2)
            return true;

        if (null == root1 || null == root2)
            return false;

        if (root1.data == root2.data) {
            return (isIsomorphic(root1.left, root2.right) && isIsomorphic(root1.right, root2.left)) ||
                    (isIsomorphic(root1.left, root2.left) && isIsomorphic(root1.right, root2.right));
        }

        return false;
    }

    public static void main(String[] args) {
        Node n1 = new Node(1);
        n1.left        = new Node(2);
        n1.right       = new Node(3);
        n1.left.left  = new Node(4);
        n1.left.right = new Node(5);
        n1.right.left  = new Node(6);
        n1.left.right.left = new Node(7);
        n1.left.right.right = new Node(8);

        Node n2 = new Node(1);
        n2.left         = new Node(3);
        n2.right        = new Node(2);
        n2.right.left   = new Node(4);
        n2.right.right   = new Node(5);
        n2.left.right   = new Node(6);
        n2.right.right.left = new Node(8);
        n2.right.right.right = new Node(7);

        System.out.println(isIsomorphic(n1,n2));
    }
}
