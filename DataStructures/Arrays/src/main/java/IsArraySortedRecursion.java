
/**
 * Created by Pradeep on 3/30/15.
 */

/**
 * Time = O(n)
 * Space = O(n)
 */
public class IsArraySortedRecursion {
    public static boolean isSorted(int[] arry,int n){
        if(n==1)
            return true;
        else if(arry[n-1]>arry[n-2])
            return isSorted(arry,n-1);
        else
            return  false;
    }

    public static void main(String[] args) {
        int[] arry = {1,2,3,4,5};
        System.out.println(isSorted(arry,5));
    }
}
