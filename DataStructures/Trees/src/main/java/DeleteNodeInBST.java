/**
 * Created by chanumolu on 11/15/15.
 */

/**
 * Delete a node in BST
 * <p>
 * Three possible cases:
 * case1 : Node has no children i.e leaf (just remove the link from the parent. No additional work needed)
 * case2 : Node has one child (remove the node and attach parent to the child)
 * case 3: Node has two children (Two possible solutions. Can follow any one of it)
 * a)  i) Find the minimum in the right subtree ii) Copy the value in targetted node iii) delete duplicate from right sub tree.
 * b)  i) Find the max in the left subtree. ii) Copy the value in targetted node iii) delete the duplicate from left sub tree.
 */
public class DeleteNodeInBST {

    static Node deleteInBST(Node root, int data) {
        if (null == root)
            return null;

        // if data node is present in left subtree
        if (data < root.data) {
            root.left = deleteInBST(root.left, data);
        } else

            // if data node is present in right subtree
            if (data > root.data) {
                root.right = deleteInBST(root.right, data);
            } else

                // if this is the node to be deleted
                if (root.data == data) {
                    //case1: no child
                    if (root.left == null && null == root.right) {
                        return null;
                    } else

                        // case2: one child
                        // check for left child. only right child is present
                        if (null == root.left) {
                            Node tmp = root;
                            root = root.right;
                            tmp.right = null;
                            return root;
                        } else if (null == root.right) { // check for right child. only left child is present
                            Node tmp = root;
                            root = root.left;
                            tmp.left = null;
                            return root;
                        } else {

                            // case3: Two children present
                            // get the min value in the right sub tree
                            Node tmp = findMin(root.right);
                            // copy the data in the min node to the node supposed to be deleted.
                            root.data = tmp.data;
                            // now delete the duplicate node
                            root.right = deleteInBST(root.right, tmp.data);
                        }
                }

        return root;
    }

    /**
     * Returns the min element node in the tree
     *
     * @return
     */
    static Node findMin(Node root) {
        if (null == root)
            return null;

        Node current = root;
        while (current.left != null) {
            current = current.left;
        }

        return current;
    }

    public static void main(String[] args) {


        /**
         *                      12
         *                  /        \
         *                5           15
         *              /  \        /    \
         *             3    7      13     17
         *            /      \
         *           1        9
         */

        Node root = new Node(12);
        root.left = new Node(5);
        root.left.left = new Node(3);
        root.left.left.left = new Node(1);
        root.left.right = new Node(7);
        root.left.right.right = new Node(9);
        root.right = new Node(15);
        root.right.left = new Node(13);
        root.right.right = new Node(17);

        System.out.println("Level Order before deletion : ");
        LevelOrderTraversal.bfs(root);
        System.out.println("Level Order After Delettion : ");
        root = deleteInBST(root,15);
        LevelOrderTraversal.bfs(root);

    }
}
