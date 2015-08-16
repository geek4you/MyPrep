/**
 * Created by chanumolu on 7/5/15.
 */

/**
 * @link : http://www.geeksforgeeks.org/root-to-leaf-path-sum-equal-to-a-given-number/
 * Given a binary tree and a number, return true if the tree has a root-to-leaf path such that adding up all the values
 * along the path equals the given number. Return false if no such path can be found.
 */
public class PathSum {

    public static boolean isPathSum(Node root, int x) {
        if (null == root)
            return x==0;

        return isPathUtil(root, 0, x);

    }

    public static boolean isPathUtil(Node root, int sum, int x) {

        if (null == root)
            if (sum == x)
                return true;

        // check for leaf node
        if (null == root.left && null == root.right) {
            if ((sum + root.data) == x)
                return true;
        }

        return isPathUtil(root.left, sum + root.data, x) || isPathUtil(root.right, sum + root.data, x);
    }

    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(8);
        root.right = new Node(2);
        root.left.left = new Node(3);
        root.left.right = new Node(5);
        root.right.left = new Node(2);

        System.out.println("isPath: "+isPathSum(root,21));

    }
}
