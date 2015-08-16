/**
 * Created by chanumolu on 6/24/15.
 */

/**
 * @link http://www.geeksforgeeks.org/search-floor-and-ceil-in-a-sorted-array/
 * <p>
 * Given a sorted array and a value x, the ceiling of x is the smallest element in array greater than or equal to x,
 * and the floor is the greatest element smaller than or equal to x. Assume than the array is sorted in non-decreasing
 * order. Write efficient functions to find floor and ceiling of x.
 * <p>
 * For example, let the input array be {1, 2, 8, 10, 10, 12, 19}
 * For x = 0:    floor doesn't exist in array,  ceil  = 1
 * For x = 1:    floor  = 1,  ceil  = 1
 * For x = 5:    floor  = 2,  ceil  = 8
 * For x = 20:   floor  = 19,  ceil doesn't exist in array
 * <p>
 * 1) Linear search O(n)
 * 2) Binary Search O(logn)
 */
public class FloorOfXInArray {

    public static int floor(int[] ary, int x) {
        return binarySearch(ary, 0, ary.length - 1, x);
    }

    public static int binarySearch(int[] arry, int low, int high, int key) {

        // x is lower than arry[low] then nothing
        if (arry[low] > key)
            return -1;

        // if x is larger than high then return high
        if (arry[high] < key)
            return high;

        int mid = (low + high) / 2;

        // if arry[mid] == key , return
        if (arry[mid] == key)
            return mid;

            //  If x is greater than arr[mid], then either arr[mid-1] is floor of x or floor lies in arr[low..mid-1]*/
        else if (arry[mid] > key) {
            if (mid - 1 >= low && arry[mid - 1] < key)
                return mid - 1;
            else
                return binarySearch(arry, low, mid, key);
        } else {
                if (mid + 1 <= high && arry[mid + 1] > key)
                    return mid;
                else
                    return binarySearch(arry, mid + 1, high, key);
        }

    }

    public static void main(String[] args) {
        int[] ary = {1, 2, 8, 10, 10, 12, 19};
        System.out.println("floor  : " + floor(ary, 120));
    }

}
