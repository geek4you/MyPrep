/**
 * Created by chanumolu on 7/14/15.
 */

/**
 * @link :
 * <p>
 * Given a Binary Tree, find the deepest leaf node that is left child of its parent. For example, consider the following
 * tree. The deepest left leaf node is the node with value 9.
 * <p>
 * 1
 * /   \
 * 2     3
 * /      /  \
 * 4      5    6
 * \     \
 * 7     8
 * /       \
 * 9         10
 * <p>
 * The idea is to recursively traverse the given binary tree and while traversing, maintain “level” which will store the
 * current node’s level in the tree. If current node is left leaf, then check if its level is more than the level of deepest
 * left leaf seen so far. If level is more then update the result. If current node is not leaf, then recursively find maximum
 * depth in left and right subtrees, and return maximum of the two depths
 */
public class DeepestLeftLeafNode {

    public static Node deepestLeftLEaf(Node root) {
        if(null == root)
            return null;

        //deepestLeftLeafNodeUtil(root,0,new IntHolder1(0),)
        return null;
    }

    public static Node deepestLeftLeafNodeUtil(Node root, int lvl, int maxLvl, Node leftLeaf, boolean leftChild) {

        if(null == root)
            return leftLeaf;



        return null;
    }
}

// int holder to simulate pointer behavior
class IntHolder1 {

    int val;

    IntHolder1(int val) {
        this.val = val;
    }
}