/**
 * Created by chanumolu on 7/4/15.
 */

/**
 * @link : http://www.geeksforgeeks.org/populate-inorder-successor-for-all-nodes/
 * <p>
 * Since it is difficult to keep track of the next node we can do a reverse inorder traversal and keep track of prev node.
 */
public class PopulateInorderSuccessor {

    public static void populateInorderSuccessor(BNode root) {
        if (null == root)
            return;

        reverseInorderSuccessorPopulate(root, null);
    }

    public static void reverseInorderSuccessorPopulate(BNode root, BNode prev) {

        if (null == root)
            return;

        // traverse the right child first (reverse inorder)
        reverseInorderSuccessorPopulate(root.right, prev);
        root.next = prev;
        prev = root;

        // traverse the left child
        reverseInorderSuccessorPopulate(root.left, prev);

    }

    public static void main(String[] args) {

        /* Constructed binary tree is
              10
            /   \
          8      12
        /
      3
    */
        BNode root = new BNode(10);
        root.left = new BNode(8);
        root.right = new BNode(12);
        root.left.left = new BNode(3);

        populateInorderSuccessor(root);

        System.out.println(root);
        System.out.println(root.left);
        System.out.println(root.right);
        System.out.println(root.left.left);
    }

}

class BNode {
    int data;
    BNode left;
    BNode right;
    BNode next;

    BNode(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
        this.next = null;
    }

    @Override
    public String toString() {
        int l = -1;
        int r = -1;
        if (null != this.left)
            l = left.data;

        if(null != this.right)
            r =  right.data;

        if(null != this.next)
            r =  next.data;

        return "BNode{" +
                "data=" + data +
                ", left=" + l +
                ", right=" + right +
                ", next=" + next +
                '}';
    }

}