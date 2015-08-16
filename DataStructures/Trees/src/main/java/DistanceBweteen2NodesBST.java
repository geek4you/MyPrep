/**
 * Created by chanumolu on 7/1/15.
 */


/**
 * Distance between 2 nodes in BST
 * <p>
 * hint: can use LCA for this.
 * <p>
 * Computation of lowest common ancestors may be useful, for instance, as part of a procedure for determining the
 * distance between pairs of nodes in a tree: the distance from n1 to n2 can be computed as the distance from the root
 * to n1, plus the distance from the root to n2, minus twice the distance from the root to their lowest common ancestor.
 * <p>
 * distance = (dist from root to node1) + (dist from root to node 2) - 2 * (distance of root from LCA)
 */


// TODO: check smallest distance between two nodes before seeing this. Looks like it is more correct answer.
public class DistanceBweteen2NodesBST {
    // find the lca of the two nodes in BST
    public static Node LCA(Node root, int x, int y) {
        if (null == root)
            return null;

        if (root.data == x || root.data == y)
            return root;

        if (root.data > x && root.data > y) {
            return LCA(root.left, x, y);
        }

        if (root.data < x && root.data < y) {
            return LCA(root.right, x, y);
        }

        // if not above then root.data is between x and y
        return root;
    }

    public static int distFromRootToNode(Node root, int x) {
        if (null == root)
            return -1;

        if (root.data == x)
            return 0;

        Node current = root;
        int count = 0;
        while (null != current) {
            if (current.data == x)
                break;
            count++;
            if (current.data > x)
                current = current.left;
            else
                current = current.right;

        }

        return count;

    }

    public static int dist2Nodes(Node root, int x, int y) {
        if (null == root)
            return -1;

        // find lowest common ancestor
        Node lca = LCA(root, x, y);
        System.out.println("Distance of root: " + root.data + " from x: " + x + " is " + distFromRootToNode(root, x));
        System.out.println("Distance of root: " + root.data + " from y: " + y + " is " + distFromRootToNode(root, y));
        System.out.println("Distance of root: " + root.data + " from lca: " + lca.data + " is " +
                distFromRootToNode(root, lca.data));
        //return (distFromRootToNode(root, x) + distFromRootToNode(root, y)) - (2*(distFromRootToNode(root,lca.data)));
        return (distFromRootToNode(lca,x)+distFromRootToNode(lca,y));
    }

    public static void main(String[] args) {
        Node root = new Node(20);
        root.left = new Node(8);
        root.right = new Node(22);
        root.left.left = new Node(4);
        root.left.right = new Node(12);
        root.left.right.left = new Node(10);
        root.left.right.right = new Node(14);
        System.out.println("LCA: " + LCA(root, 22, 14).data);

        System.out.println("Distance: " + dist2Nodes(root, 22, 14));
    }
}
