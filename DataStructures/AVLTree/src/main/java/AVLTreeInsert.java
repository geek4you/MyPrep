/**
 * Created by chanumolu on 8/7/15.
 */


/**
 * @link : http://www.geeksforgeeks.org/avl-tree-set-1-insertion/
 * <p>
 * a) Left Left Case
 * <p>
 * T1, T2, T3 and T4 are subtrees.
 * z                                      y
 * / \                                   /   \
 * y   T4      Right Rotate (z)          x      z
 * / \          - - - - - - - - ->      /  \    /  \
 * x   T3                               T1  T2  T3  T4
 * / \
 * T1   T2
 * b) Left Right Case
 * <p>
 * z                               z                           x
 * / \                            /   \                        /  \
 * y   T4  Left Rotate (y)        x    T4  Right Rotate(z)    y      z
 * / \      - - - - - - - - ->    /  \      - - - - - - - ->  / \    / \
 * T1   x                          y    T3                    T1  T2 T3  T4
 * / \                        / \
 * T2   T3                    T1   T2
 * c) Right Right Case
 * <p>
 * z                                y
 * /  \                            /   \
 * T1   y     Left Rotate(z)       z      x
 * /   \   - - - - - - - ->    / \    / \
 * T2     x                     T1  T2 T3  T4
 * / \
 * T3  T4
 * d) Right Left Case
 * <p>
 * z                            z                            x
 * / \                          / \                          /  \
 * T1   y   Right Rotate (y)    T1   x      Left Rotate(z)   z      y
 * / \  - - - - - - - - ->     /  \   - - - - - - - ->  / \    / \
 * x   T4                      T2   y                  T1  T2  T3  T4
 * / \                              /  \
 * T2   T3                           T3   T4
 */
public class AVLTreeInsert {


    // A utility function to right rotate subtree rooted with y
    // See the diagram given above.
    public static AVLNode rightRotate(AVLNode z) {
        AVLNode y = z.left;
        AVLNode T3 = y.right;

        // rotate
        y.right = z;
        z.left = T3;

        // update heights
        int zleft_height = null != z.left ? z.left.height : 0;
        int zright_height = null != z.right ? z.right.height : 0;
        z.height = Math.max(zleft_height, zright_height) + 1;

        int yleft_height = null != y.left ? y.left.height : 0;
        int yright_height = null != y.right ? y.right.height : 0;
        y.height = Math.max(yleft_height, yright_height) + 1;

        return y;
    }

    // A utility function to left rotate subtree rooted with x
    // See the diagram given above.
    public static AVLNode leftRotate(AVLNode z) {
        AVLNode y = z.right;
        AVLNode T3 = y.left;

        // rotate
        y.left = z;
        z.right = T3;

        // update heights
        int zleft_height = null != z.left ? z.left.height : 0;
        int zright_height = null != z.right ? z.right.height : 0;
        z.height = Math.max(zleft_height, zright_height) + 1;

        int yleft_height = null != y.left ? y.left.height : 0;
        int yright_height = null != y.right ? y.right.height : 0;
        y.height = Math.max(yleft_height, yright_height) + 1;

        return y;
    }

    // Get Balance factor of node N
    public static int getBalance(AVLNode node) {
        if (node == null)
            return 0;
        int left_height = null != node.left ? node.left.height : 0;
        int right_height = null != node.right ? node.right.height : 0;
        return left_height - right_height;
    }


    public static AVLNode insert(AVLNode root, int key) {

        // procees key with normal BST insert
        if (null == root)
            return new AVLNode(key);

        if (key <= root.data)
            root.left = insert(root.left, key);
        else
            root.right = insert(root.right, key);

        /* 2. Update height of this ancestor node */
        int left_height = null != root.left ? root.left.height : 0;
        int right_height = null != root.right ? root.right.height : 0;
        root.height = Math.max(left_height, right_height) + 1;

        // get inbalabce
        int balance = getBalance(root);

        // If this node becomes unbalanced, then there are 4 cases
        //  Left Left Case
        if (balance > 1 && null != root.left && key < root.left.data)
            return rightRotate(root);

        // Right Right Case
        if (balance < -1 && null != root.right && key > root.right.data)
            return leftRotate(root);

        // Left Right Case
        if (balance > 1 && null != root.left && key > root.left.data) {
            root.left = leftRotate(root.left);
            return rightRotate(root);
        }

        // Right Left Case
        if (balance < -1 && null != root.right && key < root.right.data) {
            root.right = rightRotate(root.right);
            return leftRotate(root);
        }

    /* return the (unchanged) node pointer */
        return root;


    }

    public static void preOrder(AVLNode root) {
        if (root != null) {
            System.out.println(root.data);
            preOrder(root.left);
            preOrder(root.right);
        }
    }

    public static void main(String[] args) {
        AVLNode root = null;

  /* Constructing tree given in the above figure */
        root = insert(root, 10);
        root = insert(root, 20);
        root = insert(root, 30);
        root = insert(root, 40);
        root = insert(root, 50);
        root = insert(root, 25);

        System.out.println("Pre-order: ");
  /* The constructed AVL Tree would be
            30
           /  \
         20   40
        /  \     \
       10  25    50
  */
        preOrder(root);

    }

}
