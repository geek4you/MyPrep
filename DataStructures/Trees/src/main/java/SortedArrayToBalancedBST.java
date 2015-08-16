/**
 * Created by chanumolu on 7/8/15.
 */
public class SortedArrayToBalancedBST {

    public static Node sortedAryTOBalancedBST(int[] arry, int start, int end){

        // base case
        if(start>end)
            return null;


        // Get the middle element and make it root
        int mid = (start+end)/2;
        Node root = new Node(arry[mid]);

        // Recursively construct the left subtree and make it left child of root
        root.left = sortedAryTOBalancedBST(arry, start,mid-1);

        // Recursively construct the right subtree and make it right child of root
        root.right = sortedAryTOBalancedBST(arry,mid+1,end);

        return root;

    }

    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4, 5, 6, 7};
        System.out.println("Preorder: ");
        TreeTraversals.preorder(sortedAryTOBalancedBST(arr,0,arr.length-1));
    }
}
