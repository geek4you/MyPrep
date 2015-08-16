/**
 * Created by chanumolu on 6/16/15.
 */

/**
 * @link http://www.geeksforgeeks.org/largest-sum-contiguous-subarray/
 * Largest Sum Contiguous Subarray
 * Write an efficient C program to find the sum of contiguous subarray within a one-dimensional array of numbers which has
 * the largest sum.
 * <p>
 * Kadane’s Algorithm:
 * <p>
 * Initialize:
 * max_so_far = 0
 * max_ending_here = 0
 * <p>
 * Loop for each element of the array
 * (a) max_ending_here = max_ending_here + a[i]
 * (b) if(max_ending_here < 0)
 * max_ending_here = 0
 * (c) if(max_so_far < max_ending_here)
 * max_so_far = max_ending_here
 * return max_so_far
 * Explanation:
 * Simple idea of the Kadane's algorithm is to look for all positive contiguous segments of the array
 * (max_ending_here is used for this). And keep track of maximum sum contiguous segment among all positive segments
 * (max_so_far is used for this). Each time we get a positive sum compare it with max_so_far and update max_so_far if it
 * is greater than max_so_far
 * <p>
 * Lets take the example:
 * {-2, -3, 4, -1, -2, 1, 5, -3}
 * <p>
 * max_so_far = max_ending_here = 0
 * <p>
 * for i=0, a[0] = -2
 * max_ending_here = max_ending_here + (-2)
 * Set max_ending_here = 0 because max_ending_here < 0
 * <p>
 * for i=1, a[1] = -3
 * max_ending_here = max_ending_here + (-3)
 * Set max_ending_here = 0 because max_ending_here < 0
 * <p>
 * for i=2, a[2] = 4
 * max_ending_here = max_ending_here + (4)
 * max_ending_here = 4
 * max_so_far is updated to 4 because max_ending_here greater than max_so_far which was 0 till now
 * <p>
 * for i=3, a[3] = -1
 * max_ending_here = max_ending_here + (-1)
 * max_ending_here = 3
 * <p>
 * for i=4, a[4] = -2
 * max_ending_here = max_ending_here + (-2)
 * max_ending_here = 1
 * <p>
 * for i=5, a[5] = 1
 * max_ending_here = max_ending_here + (1)
 * max_ending_here = 2
 * <p>
 * for i=6, a[6] = 5
 * max_ending_here = max_ending_here + (5)
 * max_ending_here = 7
 * max_so_far is updated to 7 because max_ending_here is greater than max_so_far
 * <p>
 * for i=7, a[7] = -3
 * max_ending_here = max_ending_here + (-3)
 * max_ending_here = 4
 */
public class LargestSumContiguousSubArray {

    private static int max(int x, int y) {
        return x > y ? x : y;
    }

    private static int largestSum(int[] ary) {
        int maxTillNow = ary[0];
        int maxEndingHere = ary[0];

        for (int i = 1; i <= ary.length - 1; i++) {
            maxEndingHere = max(ary[i], maxEndingHere + ary[i]);
            maxTillNow = max(maxEndingHere,maxTillNow);
        }

        return maxTillNow;
    }

    public static void main(String[] args) {
        int[] ary = {-2, -3, 4, -1, -2, 1, 5, -3};
        System.out.println("Sum: " + largestSum(ary));
    }
}
