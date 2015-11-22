/**
 * Created by chanumolu on 11/2/15.
 */

/**
 * Find the minimum distance between two numbers
 * Given an unsorted array arr[] and two numbers x and y, find the minimum distance between x and y in arr[].
 * The array might also contain duplicates. You may assume that both x and y are different and present in arr[].
 * <p>
 * Examples:
 * Input: arr[] = {1, 2}, x = 1, y = 2
 * Output: Minimum distance between 1 and 2 is 1.
 * <p>
 * Input: arr[] = {3, 4, 5}, x = 3, y = 5
 * Output: Minimum distance between 3 and 5 is 2.
 * <p>
 * Input: arr[] = {3, 5, 4, 2, 6, 5, 6, 6, 5, 4, 8, 3}, x = 3, y = 6
 * Output: Minimum distance between 3 and 6 is 4.
 * <p>
 * Input: arr[] = {2, 5, 3, 5, 4, 4, 2, 3}, x = 3, y = 2
 * Output: Minimum distance between 3 and 2 is 1.
 * <p>
 * <p>
 * Algorithm:
 * <p>
 * 1) Traverse array from left side and stop if either x or y is found. Store index of this first occurrence in a
 * variable say prev
 * 2) Now traverse arr[] after the index prev. If the element at current index i matches with either x or y then check
 * if it is different from arr[prev]. If it is different then update the minimum distance if needed. If it is same then
 * update prev i.e., make prev = i.
 */
public class MinimumDistanceBetweenNumbers {

    static int minDist(int[] arr, int x, int y) {
        int prev = -1;
        // get the first occurance of x or y
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] == x || arr[i] == y) {
                prev = i;
                break;
            }
        }

        // traverse the remaining now
        int minDiff = Integer.MAX_VALUE;
        for (int i = prev + 1; i < arr.length - 1; i++) {
            if (arr[i] == x || arr[i] == y) {
                if (arr[prev] == arr[i]) {
                    prev = i;
                } else {
                    minDiff = i - prev;
                    prev = i;
                }
            }
        }

        return minDiff;
    }

    public static void main(String[] args) {
        int arr[] = {3, 5, 4, 2, 6, 3, 0, 0, 5, 4, 8, 3};
        System.out.println(minDist(arr, 2, 8));
    }

}
