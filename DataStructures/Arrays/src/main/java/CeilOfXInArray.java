/**
 * Created by chanumolu on 6/24/15.
 */

/**
 * @link http://www.geeksforgeeks.org/search-floor-and-ceil-in-a-sorted-array/
 */
public class CeilOfXInArray {
    public static int ceil(int[] arry, int x){
        return binarySearch(arry,0,arry.length-1,x);
    }

    public static int binarySearch(int[] arry, int low, int high, int key){
        if(low>high)
            return -1;
        if(arry[low]>key)
            return low;
        if(arry[high]<key)
            return -1;

        int mid = (low+high)/2;

        if(arry[mid]==key)
            return mid;
        else if(arry[mid]<key){
            // ceiling should be mid+1 or in [mid+1..high]
            if(mid+1 <= high && arry[mid+1]>key)
                return mid+1;
            else
                return binarySearch(arry,mid+1,high,key);
        }else{
            // ceiling should be mid or in [low..mid]
            if(mid-1 >= low && arry[mid-1]<key)
                return mid;
            else
                return binarySearch(arry,low,mid,key);
        }
    }

    public static void main(String[] args) {
        int[] ary = {1, 2, 8, 10, 10, 12, 19};
        System.out.println("Ceiling : " + ceil(ary, 3));
    }
}
