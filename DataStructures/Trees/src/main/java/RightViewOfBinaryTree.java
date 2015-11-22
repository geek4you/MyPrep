/**
 * Created by chanumolu on 11/10/15.
 */

/**
 * Print Right View of a Binary Tree
 * Given a Binary Tree, print Right view of it. Right view of a Binary Tree is set of nodes visible when tree is visited from Right side.
 * <p>
 * Right view of following tree is 1 3 7 8
 * <p>
 *              1
 *          /     \
 *         2        3
 *      /   \     /  \
 *      4     5   6    7
 *      \
 *      8
 */

/*
Method 1:

The Right view contains all nodes that are last nodes in their levels. A simple solution is to do level order traversal
and print the last node in every level.
 */

/*
 * Method 2:
  The problem can also be solved using simple recursive traversal. We can keep track of level of a node by passing a
  parameter to all recursive calls. The idea is to keep track of maximum level also. And traverse the tree in a manner
  that right subtree is visited before left subtree. Whenever we see a node whose level is more than maximum level so
  far, we print the node because this is the last node in its level (Note that we traverse the right subtree before left
   subtree). Following is C implementation of this approach.
 */
public class RightViewOfBinaryTree {

    // Recursive function to print right view of a binary tree.
    static void rightView(Node root, int level, IntegerHolder maxLevel) {

        // base case
        if (null == root)
            return;

        if (maxLevel.maxLevel < level){
            System.out.println(root.data);
            maxLevel.maxLevel = level;
        }

        rightView(root.right, level + 1, maxLevel);
        rightView(root.left, level + 1, maxLevel);
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.left.left.right = new Node(8);

        rightView(root,1,new IntegerHolder(0));
    }

    static class IntegerHolder{
        int maxLevel ;

        public IntegerHolder(int maxLevel) {
            this.maxLevel = maxLevel;
        }
    }
}
