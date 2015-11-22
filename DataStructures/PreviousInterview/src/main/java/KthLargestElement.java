/**
 * Created by chanumolu on 11/15/15.
 * <p>
 * Has many implementatioins like sorting, heap based solutions etc.
 * <p>
 * This one take the min time i.e O(n) and O(1) space
 * <p>
 * Based on Quicksort partition method
 * <p>
 * 1) Pick a pivot and scan the array to put pivot in position
 * 2) if pivot==k, return
 * 3) if pivot<k, check the right half only (all left are less than pivot, so cannot be the solution)
 * 4)if pivot > k, check the left half only ( all the right are larger than pivot , so cannot be our solution)
 */

/**
 * Has many implementatioins like sorting, heap based solutions etc.
 * <p>
 * This one take the min time i.e O(n) and O(1) space
 * <p>
 * Based on Quicksort partition method
 * <p>
 * 1) Pick a pivot and scan the array to put pivot in position
 * 2) if pivot==k, return
 * 3) if pivot<k, check the right half only (all left are less than pivot, so cannot be the solution)
 * 4)if pivot > k, check the left half only ( all the right are larger than pivot , so cannot be our solution)
 */

/**
 * https://www.youtube.com/watch?v=pdmZpAJ2uBM
 */
public class KthLargestElement {

    public static int findKthLargest(int[] nums, int k) {
        if (k < 1 || nums == null) {
            return 0;
        }

        return getKth(nums.length - k + 1, nums, 0, nums.length - 1);
    }

    public static int getKth(int k, int[] nums, int start, int end) {

        int pivot = nums[end];

        int left = start;
        int right = end;

        while (true) {

            while (nums[left] < pivot && left < right) {
                left++;
            }

            while (nums[right] >= pivot && right > left) {
                right--;
            }

            if (left == right) {
                break;
            }

            swap(nums, left, right);
        }

        swap(nums, left, end);

        if (k == left + 1) {
            return pivot;
        } else if (k < left + 1) {
            return getKth(k, nums, start, left - 1);
        } else {
            return getKth(k, nums, left + 1, end);
        }
    }

    public static void swap(int[] nums, int n1, int n2) {
        int tmp = nums[n1];
        nums[n1] = nums[n2];
        nums[n2] = tmp;
    }

    public static void main(String[] args) {
        int[] arr = {3, 2, 1, 5, 6, 4};
        int k = 2;
        System.out.println(findKthLargest(arr, k));
    }
}
