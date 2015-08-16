/**
 * Created by chanumolu on 8/7/15.
 */



public class AVLNode {

    int data;
    AVLNode left;
    AVLNode right ;
    int height;

    AVLNode(int data){
        this.data = data;
        left = null;
        right = null;
        height = 1;  // new node is initially added at leaf
    }

}
