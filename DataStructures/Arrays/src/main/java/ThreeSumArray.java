/**
 * Created by chanumolu on 11/3/15.
 */

import java.util.Arrays;

/**
 * Find a triplet that sum to a given value
 * Given an array and a value, find if there is a triplet in array whose sum is equal to the given value.
 * If there is such a triplet present in array, then print the triplet and return true. Else return false.
 * For example, if the given array is {12, 3, 4, 1, 6, 9} and given sum is 24, then there is a triplet (12, 3 and 9)
 * present in array whose sum is 24.
 * <p>
 * A simple method is to generate all possible triplets and compare the sum of every triplet with the given value.
 * The following code implements this simple method using three nested loops.
 * <p>
 * Time complexity of the method 1 is O(n^3). The complexity can be reduced to O(n^2) by sorting the array first, and then using method 1 of this post in a loop.
 * 1) Sort the input array.
 * 2) Fix the first element as A[i] where i is from 0 to array size – 2. After fixing the first element of triplet,
 */
public class ThreeSumArray {

    static boolean threeSum(int[] arr, int sum) {
        // sort the array
        Arrays.sort(arr);

        // fix the first elem and find the other two
        for (int i = 0; i < arr.length - 2; i++) {
            int l = i + 1; // first elem in the remaining elements
            int r = arr.length - 1; // last elem in the remaining elements

            while (l < r) {
                if (arr[i] + arr[l] + arr[r] == sum) {
                    System.out.printf("%d , %d , %d adds up to given %d !!", arr[i], arr[l], arr[r], sum);
                    return true;
                }else if(arr[i]+arr[l]+arr[r]<sum){
                    l++;
                }else{
                    r--;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int arr[] = {1, 4, 45, 6, 10, 8};
        int sum = 22;
        threeSum(arr,sum);
    }

}
