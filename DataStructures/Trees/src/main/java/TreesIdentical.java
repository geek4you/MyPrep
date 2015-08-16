/**
 * Created by chanumolu on 7/1/15.
 */

/**
 * @link : http://www.geeksforgeeks.org/write-c-code-to-determine-if-two-trees-are-identical/
 *
 * Two trees are identical when they have same data and arrangement of data is also same.

 To identify if two trees are identical, we need to traverse both trees simultaneously, and while traversing we need to
 compare data and children of the trees.
 */
public class TreesIdentical {

    public static boolean identical(Node root1 , Node root2){

        if(null == root1 && null == root2)
            return true;

        if(null == root1 || null == root2)
            return false;

        if(root1.data == root2.data){
            return (identical(root1.left,root2.left) && identical(root1.right,root2.right));
        }
        return false;
    }


    public static void main(String[] args) {
        Node root1 = new Node(1);
        Node root2 = new Node(1);
        root1.left = new Node(2);
        root1.right = new Node(3);
        root1.left.left  = new Node(4);
        root1.left.right = new Node(5);

        root2.left = new Node(2);
        root2.right = new Node(3);
        root2.left.left = new Node(4);
        root2.left.right = new Node(6);

        System.out.println(identical(root1, root2));
    }
}
