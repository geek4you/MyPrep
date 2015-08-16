/**
 * Created by chanumolu on 7/1/15.
 */
public class MinimumValueBST {

    public static int min(Node root){
        if(null == root){
            return -1;
        }

        Node current = root;

        while (current.left!=null)
            current = current.left;

        return current.data;
    }

}
