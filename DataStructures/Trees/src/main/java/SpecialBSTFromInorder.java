/**
 * Created by chanumolu on 7/11/15.
 */

/**
 * @link : http://www.geeksforgeeks.org/construct-binary-tree-from-inorder-traversal/
 * Given Inorder Traversal of a Special Binary Tree in which key of every node is greater than keys in left and right children, construct the Binary Tree and return root.
 * <p>
 * Examples:
 * <p>
 * Input: inorder[] = {5, 10, 40, 30, 28}
 * Output: root of following tree
 * 40
 * /   \
 * 10     30
 * /         \
 * 5          28
 */
public class SpecialBSTFromInorder {


    public static Node buildTree(int[] in, int beg, int end) {

        if (beg > end)
            return null;

        // only one number left in this array
        if (beg == end)
            return new Node(in[beg]);

        // find the max
        int maxIndex = findMax(in, beg,end);

        Node root = new Node(in[maxIndex]);

        root.left = buildTree(in, beg, maxIndex-1);
        root.right = buildTree(in, maxIndex+1,end);

        return root;
    }

    public static int findMax(int[] arr, int beg, int end) {
        int max = Integer.MIN_VALUE;
        int index = -1;
        for (int i = beg; i <=end; i++) {
            if(arr[i]>max){
                max =arr[i];
                index = i;
            }
        }
        return index;
    }

    public static void main(String[] args) {
        int inorder[] = {5, 10, 40, 30, 28};
        Node root = buildTree(inorder,0,inorder.length-1);
        TreeTraversals.inorder(root);
    }
}
