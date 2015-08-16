/**
 * Created by chanumolu on 7/6/15.
 */

/**
 * @link : http://www.geeksforgeeks.org/get-level-of-a-node-in-a-binary-tree/
 * <p>
 * Get Level of a node in a Binary Tree
 * Given a Binary Tree and a key, write a function that returns level of the key.
 */
public class LevelOfNode {

    public static int levelOfKey(Node root, int key) {

        if (null == root)
            return -1;

        return levelOfKeyUtil(root, key, 1);
    }

    public static int levelOfKeyUtil(Node root, int key, int level) {
        if (null == root)
            return -1;

        if (root.data == key)
            return level;

        int tmp = levelOfKeyUtil(root.left, key, level + 1);
        if (tmp != -1)
            return tmp;

        return levelOfKeyUtil(root.right, key, level + 1);

    }

    public static void main(String[] args) {
        Node root = new Node(3);
        root.left = new Node(2);
        root.right = new Node(5);
        root.left.left = new Node(1);
        root.left.right = new Node(4);

        for(int i =0 ; i<=5 ;i++){
            System.out.println("level of "+i+" : "+levelOfKey(root,i));
        }

    }
}
