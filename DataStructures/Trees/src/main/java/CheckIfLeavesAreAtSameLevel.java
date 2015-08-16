/**
 * Created by chanumolu on 7/12/15.
 */

/**
 * @link : http://www.geeksforgeeks.org/check-leaves-level/
 * <p>
 * Check if all leaves are at same level
 * Given a Binary Tree, check if all leaves are at same level or not.
 * <p>
 * 12
 * /    \
 * 5       7
 * /          \
 * 3            1
 * Leaves are at same level
 * <p>
 * 12
 * /    \
 * 5       7
 * /
 * 3
 * Leaves are Not at same level
 * <p>
 * <p>
 * 12
 * /
 * 5
 * /   \
 * 3     9
 * /      /
 * 1      2
 * Leaves are at same level
 *
 * TODO: Find mistake
 */
public class CheckIfLeavesAreAtSameLevel {

    public static int leftMostLeafLevel(Node root) {
        if (null == root)
            return 0;

        Node current = root;
        int count = 0;
        while (null != current) {
            current = current.left;
            count++;
        }

        return count;
    }

    public static boolean checkLeafNodesSameLvl(Node root) {

        if (null == root)
            return true;

        int lvl = leftMostLeafLevel(root);

        return checkLeafNodesSameLvlUtil(root, lvl);
    }

    public static boolean checkLeafNodesSameLvlUtil(Node root, int lvl) {
        if (null == root)
            return true;

        // check for leaf node
        if (null == root.left && null == root.right) {
            if (lvl == 0)
                return true;
            else
                return false;
        }

        return checkLeafNodesSameLvlUtil(root.left, lvl - 1) && checkLeafNodesSameLvlUtil(root.right, lvl - 1);

    }

    public static void main(String[] args) {
        Node root = new Node(12);
        root.left = new Node(5);
        root.left.left = new Node(3);
        root.left.right = new Node(9);
        root.left.left.left = new Node(1);
        root.left.right.left = new Node(1);

        System.out.println(checkLeafNodesSameLvl(root));
    }
}
