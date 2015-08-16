/**
 * Created by chanumolu on 7/4/15.
 */

/**
 * @link : http://www.geeksforgeeks.org/diameter-of-a-binary-tree/
 *
 * The diameter of a tree (sometimes called the width) is the number of nodes on the longest path between two leaves in
 * the tree. The diagram below shows two trees each with diameter nine, the leaves that form the ends of a longest path
 * are shaded (note that there is more than one path in each tree of length nine, but no path longer than nine nodes).
 *
 * The diameter of a tree T is the largest of the following quantities:

 * the diameter of T’s left subtree
 * the diameter of T’s right subtree
 * the longest path between leaves that goes through the root of T (this can be computed from the heights of the
 * subtrees of T)
 *
 * TODO: try to avoid calculating height for every level
 */
public class DiameterOfTree {


    // height is the largest depth from root
    public static int diameter(Node root){
        // use post order traversal as you need to come from down to up.
        if(null == root)
            return 0;

        // get the diameters of left and right subtrees
        int lDiameter = diameter(root.left);
        int rDiameter = diameter(root.right);

        // get left and right heights
        int lh = HeightOfTree.height(root.left);
        int rh = HeightOfTree.height(root.right);

        return max(lDiameter, rDiameter, (lh+rh+1));
    }

    public static int max(int a, int b, int c){
        if(a>=b&&a>=c)
            return a;
        if(b>c)
            return b;
        return c;
    }

    public static void main(String[] args) {
        Node root = new Node(50);
        root.left = new Node(7);
        root.right = new Node(2);
        root.left.left = new Node(3);
        root.left.right = new Node(5);
        root.right.left = new Node(1);
        root.right.right = new Node(30);
        System.out.println("Diameter: "+diameter(root));
    }
}
