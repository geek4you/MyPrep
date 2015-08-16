/**
 * Created by chanumolu on 7/12/15.
 */

/**
 * @link : http://www.geeksforgeeks.org/difference-between-sums-of-odd-and-even-levels/
 * <p>
 * Given a a Binary Tree, find the difference between the sum of nodes at odd level and the sum of nodes at even level. Consider root as level 1, left and right children of root as level 2 and so on.
 * <p>
 * For example, in the following tree, sum of nodes at odd level is (5 + 1 + 4 + 8) which is 18. And sum of nodes at even level is (2 + 6 + 3 + 7 + 9) which is 27. The output for following tree should be 18 – 27 which is -9.
 * <p>
 * 5
 * /   \
 * 2     6
 * /  \     \
 * 1    4     8
 * /     / \
 * 3     7   9
 *
 *
 * A straightforward method is to use level order traversal. In the traversal, check level of current node, if it is odd,
 * increment odd sum by data of current node, otherwise increment even sum. Finally return difference between odd sum and
 * even sum. See following for implementation of this approach.

C implementation of level order traversal based approach to find the difference.

The problem can also be solved using simple recursive traversal. We can recursively calculate the required difference as,
value of root’s data subtracted by the difference for subtree under left child and the difference for subtree under right
child. Following is C implementation of this approach.
 */
public class DifferenceBwtSumOfEvenAndOddLevelNodes {

    int getLevelDiff(Node root)
    {
        // Base case
        if (root == null)
            return 0;

        // Difference for root is root's data - difference for left subtree
        // - difference for right subtree
        return root.data - getLevelDiff(root.left) - getLevelDiff(root.right);
    }
}
