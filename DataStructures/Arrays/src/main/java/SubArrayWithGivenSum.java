/**
 * Created by chanumolu on 11/3/15.
 */

/**
 * Find subarray with given sum
 * Given an unsorted array of nonnegative integers, find a continous subarray which adds to a given number.
 * <p>
 * Examples:
 * <p>
 * Input: arr[] = {1, 4, 20, 3, 10, 5}, sum = 33
 * Ouptut: Sum found between indexes 2 and 4
 * <p>
 * Input: arr[] = {1, 4, 0, 0, 3, 10, 5}, sum = 7
 * Ouptut: Sum found between indexes 1 and 4
 * <p>
 * Input: arr[] = {1, 4}, sum = 0
 * Output: No subarray found
 * There may be more than one subarrays with sum as the given sum. The following solutions print first such subarray.
 */
public class SubArrayWithGivenSum {

    static boolean subArray(int[] arr, int sum) {
        int start = 0;
        int currSum = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            currSum = currSum + arr[i];
            if(currSum==sum){
                System.out.printf("Sum found between indexes %d and %d",start,i);
                return true;
            }else if(currSum>sum){
                currSum = currSum-arr[start];
                start = start+1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int arr[] = {15, 2, 4, 8, 9, 5, 10, 23};
        int sum = 14;
        subArray(arr,sum);
    }
}
