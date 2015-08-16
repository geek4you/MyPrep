/**
 * Created by chanumolu on 7/12/15.
 */

/**
 * @link : http://www.geeksforgeeks.org/print-left-view-binary-tree/
 * <p>
 * Print Left View of a Binary Tree
 * Given a Binary Tree, print left view of it. Left view of a Binary Tree is set of nodes visible when tree is visited from
 * left side. Left view of following tree is 12, 10, 25.
 * <p>
 * 12
 * /     \
 * 10       30
 * /    \
 * 25      40
 * The left view contains all nodes that are first nodes in their levels. A simple solution is to do level order traversal
 * and print the first node in every level.
 * <p>
 * The problem can also be solved using simple recursive traversal. We can keep track of level of a node by passing a
 * parameter to all recursive calls. The idea is to keep track of maximum level also. Whenever we see a node whose level
 * is more than maximum level so far, we print the node because this is the first node in its level (Note that we traverse
 * the left subtree before right subtree)
 */
public class LeftViewOfBinaryTree {

    public static void leftViewOfBinaryTree(Node root) {

        if (null == root)
            return;

        leftViewUtil(root,1,new InteHolder(0));

    }

    public static void leftViewUtil(Node root, int lvl, InteHolder maxLvl) {
        if (null == root)
            return;

        if (lvl > maxLvl.val) {
            System.out.println(root.data);
            maxLvl.val = lvl;
        }

        leftViewUtil(root.left, lvl + 1, maxLvl);
        leftViewUtil(root.right, lvl + 1, maxLvl);
    }

    public static void main(String[] args) {
        Node root = new Node(12);
        root.left = new Node(10);
        root.right = new Node(30);
        root.right.left = new Node(25);
        root.right.right = new Node(40);

        leftViewOfBinaryTree(root);
    }
}


class InteHolder {
    int val;

    InteHolder(int val) {
        this.val = val;
    }
}