/**
 * Created by chanumolu on 7/12/15.
 */

/**
 * @link : http://www.geeksforgeeks.org/print-nodes-dont-sibling-binary-tree/
 *
 * Given a Binary Tree, print all nodes that don’t have a sibling (a sibling is a node that has same parent.
 * In a Binary Tree, there can be at most one sibling). Root should not be printed as root cannot have a sibling.
 *
 * This is a typical tree traversal question. We start from root and check if the node has one child, if yes then print
 * the only child of that node. If node has both children, then recur for both the children.
 */
public class PrintNodesWithoutSiblings {

    public static void printNodesWithoutSiblings(Node root){

        if(null == root)
            return;

        if(null == root.left && null==root.right)
            return;

        if(null == root.left || null == root.right){
            if(null == root.left)
                System.out.println(root.right.data);
            else
                System.out.println(root.left.data);
        }

        printNodesWithoutSiblings(root.left);
        printNodesWithoutSiblings(root.right);

    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.right = new Node(4);
        root.right.left = new Node(5);
        root.right.left.left = new Node(6);

        printNodesWithoutSiblings(root);
    }
}
