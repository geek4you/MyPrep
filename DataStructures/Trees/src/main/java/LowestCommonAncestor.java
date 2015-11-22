/**
 * Created by chanumolu on 7/1/15.
 */

/**
 * @link : http://www.geeksforgeeks.org/lowest-common-ancestor-in-a-binary-search-tree/
 * <p>
 * this can be used to find distance between two nodes in BST
 * <p>
 * We can recursively traverse the BST from root. The main idea of the solution is, while traversing from top to
 * bottom, the first node n we encounter with value between n1 and n2, i.e., n1 < n < n2 or same as one of the n1 or
 * n2, is LCA of n1 and n2 (assuming that n1 < n2). So just recursively traverse the BST in, if node's value is greater
 * than both n1 and n2 then our LCA lies in left side of the node, if it's is smaller than both n1 and n2, then LCA
 * lies on right side. Otherwise root is LCA (assuming that both n1 and n2 are present in BST)
 */

/**
 * Method 2:
 *
 * calculate the list of ancestors for each node
 find the common prefix
 the last element from the common prefix is the lowest common ancestor
 */
public class LowestCommonAncestor {

    public static Node lca(Node root, int x, int y) {

        if (null == root)
            return null;

        // if both x and y are smaller than root
        if (root.data > x && root.data > y)
            return lca(root.left, x, y);

        // both greater than x and y
        if (root.data < x && root.data < y)
            return lca(root.right, x, y);

        return root;
    }

    public static void main(String[] args) {
        Node root = new Node(20);
        root.left = new Node(8);
        root.right = new Node(22);
        root.left.left = new Node(4);
        root.left.right = new Node(12);
        root.left.right.left = new Node(10);
        root.left.right.right = new Node(14);
        System.out.println("LCA: "+lca(root,8,14).data);
    }
}
