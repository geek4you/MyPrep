/**
 * Created by chanumolu on 11/2/15.
 */

import java.util.Arrays;

/**
 * Maximum Length Bitonic Subarray
 * Given an array A[0 … n-1] containing n positive integers, a subarray A[i … j] is bitonic if there is a k with
 * i <= k <= j such that A[i] <= A[i + 1] ... <= A[k] >= A[k + 1] >= .. A[j – 1] > = A[j].
 * Write a function that takes an array as argument and returns the length of the maximum length bitonic subarray.
 * Expected time complexity of the solution is O(n)
 * <p>
 * Simple Examples
 * 1) A[] = {12, 4, 78, 90, 45, 23}, the maximum length bitonic subarray is {4, 78, 90, 45, 23} which is of length 5.
 * <p>
 * 2) A[] = {20, 4, 1, 2, 3, 4, 2, 10}, the maximum length bitonic subarray is {1, 2, 3, 4, 2} which is of length 5.
 * <p>
 * Extreme Examples
 * 1) A[] = {10}, the single element is bitnoic, so output is 1.
 * <p>
 * 2) A[] = {10, 20, 30, 40}, the complete array itself is bitonic, so output is 4.
 * <p>
 * 3) A[] = {40, 30, 20, 10}, the complete array itself is bitonic, so output is 4.
 * <p>
 * Solution
 * Let us consider the array {12, 4, 78, 90, 45, 23} to understand the soultion.
 * 1) Construct an auxiliary array inc[] from left to right such that inc[i] contains length of the nondecreaing subarray
 * ending at arr[i].
 * For for A[] = {12, 4, 78, 90, 45, 23}, inc[] is {1, 1, 2, 3, 1, 1}
 * <p>
 * 2) Construct another array dec[] from right to left such that dec[i] contains length of nonincreasing subarray starting
 * at arr[i].
 * For A[] = {12, 4, 78, 90, 45, 23}, dec[] is {2, 1, 1, 3, 2, 1}.
 * <p>
 * 3) Once we have the inc[] and dec[] arrays, all we need to do is find the maximum value of (inc[i] + dec[i] – 1).
 * For {12, 4, 78, 90, 45, 23}, the max value of (inc[i] + dec[i] – 1) is 5 for i = 3.
 */
public class MaximumBitonicArray {

    static int maxLenBitonicArray(int[] arr) {
        int[] incr = new int[arr.length];
        int[] decr = new int[arr.length];

        // create the incr array
        incr[0] = 1;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > arr[i-1]) {
                incr[i] = incr[i - 1] + 1;
            } else {
                incr[i] = 1;
            }
        }

        // create the decr array
        decr[arr.length - 1] = 1;
        for (int i = arr.length - 2; i >= 0; i--) {
            if (arr[i] > arr[i+1]) {
                decr[i] = decr[i + 1] + 1;
            } else {
                decr[i] = 1;
            }
        }

        System.out.println("Original Array: ");
        System.out.println(Arrays.toString(arr));
        System.out.println("Incr Array: ");
        System.out.println(Arrays.toString(incr));
        System.out.println("Decr Array: ");
        System.out.println(Arrays.toString(decr));

        // get the max bitonic array length
        int maxLen = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            int len = incr[i]+decr[i]-1;
            if(len>maxLen)
                maxLen= len;
        }
        return maxLen;

    }

    public static void main(String[] args) {
        int arr[] = {12, 4, 78, 90, 45, 23};
        System.out.println(maxLenBitonicArray(arr)) ;
    }
}
