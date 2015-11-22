/**
 * Created by chanumolu on 6/17/15.
 */

/**
 * @link http://www.geeksforgeeks.org/check-for-majority-element-in-a-sorted-array/
 * Check for Majority Element in a sorted array
 * <p>
 * Question: Write a C function to find if a given integer x appears more than n/2 times in a sorted array of n integers.
 * <p>
 * Basically, we need to write a function say isMajority() that takes an array (arr[] ), array’s size (n) and a number
 * to be searched (x) as parameters and returns true if x is a majority element (present more than n/2 times).
 * <p>
 * Examples:
 * <p>
 * Input: arr[] = {1, 2, 3, 3, 3, 3, 10}, x = 3
 * Output: True (x appears more than n/2 times in the given array)
 * <p>
 * Input: arr[] = {1, 1, 2, 4, 4, 4, 6, 6}, x = 4
 * Output: False (x doesn't appear more than n/2 times in the given array)
 * <p>
 * Input: arr[] = {1, 1, 1, 2, 2}, x = 1
 * Output: True (x appears more than n/2 times in the given array)
 * <p>
 * Method1: Linear search : O(n)
 * Method2: Binary search : O(logn)
 */
public class CheckForMajorityElementSortedArray {

    public static boolean isMajority(int[] arr, int x) {
        // get the index of the first occuring x in arr
        int index = binarySearch(arr, 0, arr.length - 1, x);

        System.out.println("index : "+ index);

        if (index == -1)
            return false;

        if ((index + (arr.length) / 2 < arr.length) && (arr[index + (arr.length) / 2] == x)) {
            return true;
        }

        return false;
    }

    public static int binarySearch(int[] arr, int l, int h, int x) {

        if (l <= h) {
            int mid = (l + h) / 2;

            /* Check if arr[mid] is the first occurrence of x.
            arr[mid] is first occurrence if x is one of the following
            is true:
            (i) mid == 0 and arr[mid] == x
            (ii) arr[mid-1] < x and ar */
            if ((mid == 0 || x > arr[mid - 1]) && arr[mid] == x) {
                return mid;
            } else if (arr[mid] < x) {
                return binarySearch(arr, mid + 1, h, x);
            } else {
                return binarySearch(arr, l, mid - 1, x);
            }
        } else
            return -1;
    }

    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 3, 3, 3, 10};
        int x = 3;

        System.out.println(isMajority(arr,x));
    }
}
