/**
 * Created by chanumolu on 11/7/15.
 */

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * IMPORTANT: check this problems before this: SubArrayWithSumZero
 * Find the length of longest continuous subarray within an array (containing at least one number) whose sum equals zero.
 * <p>
 * For example, given the array [1,0,-1,2],
 * <p>
 * The longest continuous subarray of zero-sum is [1,0,-1] , which has length = 3.
 */
public class LongestContinuousSubArrayWithSumZero {

    public static int longestContinousZeroSumSubArray(int[] nums) {
        int n = nums.length, max = 0;

        // accumulate the nums
        for (int i = 1; i < n; i++) {
            nums[i] += nums[i - 1];
        }

        System.out.println("Array after accumulating the sums: ");
        System.out.println(Arrays.toString(nums));

        Map<Integer, Integer> map = new HashMap<Integer, Integer>();

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];

            if (num == 0)
                max = Math.max(max, i + 1);
            else if (map.containsKey(num))
                max = Math.max(max, i - map.get(num));
            else
                map.put(num, i);
        }

        return max;
    }

    public static void main(String[] args) {
        int[] arr = {1, 0, -1, 2};
        longestContinousZeroSumSubArray(arr);
    }
}
