/**
 * Created by chanumolu on 7/11/15.
 */

/**
 * @link : http://www.geeksforgeeks.org/full-and-complete-binary-tree-from-given-preorder-and-postorder-traversals/
 * <p>
 * Construct Full Binary Tree from given preorder and postorder traversals
 * Given two arrays that represent preorder and postorder traversals of a full binary tree, construct the binary tree.
 */

// TODO: catch the mistake
public class CompleteBinaryTreeFromPreAndPostOrderTraversal {

    /**
     * @param preIndex index in pre arry
     * @param lpost    low index in post arry
     * @param hpost    high index in post arry
     */
    public static Node constructTree(int[] pre, int[] post, IntegerHolder preIndex, int lpost, int hpost) {

        // base case
        if (preIndex.val >= pre.length - 1 || lpost > hpost)
            return null;

        // The first node in preorder traversal is root. So take the node at
        // preIndex from preorder and make it root, and increment preIndex
        Node root = new Node(pre[preIndex.val++]);

        // If the current subarry has only one element, no need to recur
        if (lpost == hpost)
            return root;

        // Search the next element of pre[] in post[]
        int i;
        for (i = 1; i <= hpost; ++i)
            if (pre[preIndex.val] == post[i])
                break;

        // Use the index of element found in postorder to divide postorder array in
        // two parts. Left subtree and right subtree
        if (i <= hpost)
        {
            root.left = constructTree (pre, post, preIndex, lpost, i);
            root.right = constructTree(pre, post, preIndex, i + 1, hpost);
        }

        return root;

    }

    public static void main(String[] args) {
        int pre[] = {1, 2, 4, 8, 9, 5, 3, 6, 7};
        int post[] = {8, 9, 4, 5, 2, 6, 7, 3, 1};

        TreeTraversals.inorder(constructTree(pre,post,new IntegerHolder(0),0,post.length-1));
        System.out.println("Post:");
        TreeTraversals.postorder(constructTree(pre,post,new IntegerHolder(0),0,post.length-1));
    }
}

class IntegerHolder {
    int val;

    IntegerHolder(int val) {
        this.val = val;
    }
}
