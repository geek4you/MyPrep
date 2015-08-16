/**
 * Created by chanumolu on 7/1/15.
 */
public class MirrorOfTree {

    public static Node mirror(Node root) {
        if (null == root)
            return null;

        Node mroot = new Node(root.data);
        mroot.left = mirror(root.right);
        mroot.right = mirror(root.left);

        return mroot;
    }

    public static void mirrorInPlace(Node root) {
        if (null == root)
            return;

        Node tmp = root.left;
        root.left = root.right;
        root.right = tmp;

        mirrorInPlace(root.left);
        mirrorInPlace(root.right);
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        TreeTraversals.preorder(root);
        System.out.println();
        mirrorInPlace(root);

        TreeTraversals.preorder(root);
        //Node mroot = mirror(root);

        //TreeTraversals.inorder(mroot);
    }
}
