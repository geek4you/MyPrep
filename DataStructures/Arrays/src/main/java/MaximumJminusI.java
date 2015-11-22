/**
 * Created by chanumolu on 11/2/15.
 * <p>
 * <p>
 * Given an array arr[], find the maximum j – i such that arr[j] > arr[i]
 */

import java.util.Arrays;

/**
 * Algorithm:
 * <p>
 * To solve this problem, we need to get two optimum indexes of arr[]: left index i and right index j.
 * For an element arr[i], we do not need to consider arr[i] for left index if there is an element smaller than arr[i]
 * on left side of arr[i]. Similarly, if there is a greater element on right side of arr[j] then we do not need to
 * consider this j for right index. So we construct two auxiliary arrays LMin[] and RMax[] such that LMin[i] holds the
 * smallest element on left side of arr[i] including arr[i], and RMax[j] holds the greatest element on right side of
 * arr[j] including arr[j]. After constructing these two auxiliary arrays, we traverse both of these arrays from left
 * to right. While traversing LMin[] and RMa[] if we see that LMin[i] is greater than RMax[j], then we must move ahead
 * in LMin[] (or do i++) because all elements on left of LMin[i] are greater than or equal to LMin[i]. Otherwise we must
 * move ahead in RMax[j] to look for a greater j – i value.
 */
public class MaximumJminusI {

    public static int maxIndexDiff(int[] arr) {

        int[] lMin = new int[arr.length];
        int[] rMax = new int[arr.length];

        // Construct LMin[] such that LMin[i] stores the minimum value from (arr[0], arr[1], ... arr[i])
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (min > arr[i]) {
                min = arr[i];
                lMin[i] = min;
            } else {
                lMin[i] = min;
            }
        }

        // Construct RMax[] such that RMax[j] stores the maximum value from (arr[j], arr[j+1], ..arr[n-1])
        int max = Integer.MIN_VALUE;
        for (int i = arr.length - 1; i >= 0; i--) {
            if (max < arr[i]) {
                max = arr[i];
                rMax[i] = max;
            } else {
                rMax[i] = max;
            }
        }

        System.out.println("Original: ");
        System.out.println(Arrays.toString(arr));
        System.out.println("LMin: ");
        System.out.println(Arrays.toString(lMin));
        System.out.println("RMax: ");
        System.out.println(Arrays.toString(rMax));

        // Traverse both arrays from left to right to find optimum j - i
        // This process is similar to merge() of MergeSort
        int i = 0, j = 0, maxDiff = -1;

        while (j < arr.length && i < arr.length) {
            if (lMin[i] < rMax[j]) {
                maxDiff = (maxDiff > (j - i)) ? maxDiff : (j - i); // max(maxDiff, j - i);
                j = j + 1;
            } else
                i = i + 1;
        }
        return maxDiff;
    }

    public static void main(String[] args) {
        int arr[] = {9, 2, 3, 4, 5, 6, 7, 8, 18, 0};
        System.out.println(maxIndexDiff(arr));
    }
}
