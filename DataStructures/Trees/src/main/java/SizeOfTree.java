/**
 * Created by chanumolu on 7/1/15.
 */
public class SizeOfTree {

    public static int size(Node root){
        if(null==root)
            return 0;
        return size(root.left)+1+size(root.right);
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);

        System.out.println("size: "+size(root));
    }
}
