/**
 * Created by chanumolu on 7/1/15.
 */
public class CountLeafNodes {

    public static int leafNodes(Node root){

        if(null == root)
            return 0;

        if(null == root.left && null == root.right)
            return 1;

        return leafNodes(root.left) + leafNodes(root.right);
    }

}
