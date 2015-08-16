/**
 * Created by chanumolu on 8/13/15.
 */

/**
 * Given an array of unique integers whose first two numbers are decreasing and last two numbers are increasing, find a
 * number in the array which is local minima. A number in the array is called local minima if it is smaller than both
 * its left and right numbers. For example in the array 9,7,2,8,5,6,3,4
 * 2 is a local minima as it is smaller than its left and right number 7 and 8. Similarly 5 is another local minima as it
 * is between 8 and 6, both larger than 5. You need to find any one of the local minima.
 *
 *
 *
 * We will solve this problem in O(log n) time by divide and conquer method. We will first check the mid index of the
 * array. If it is smaller than its left and right, then it is the answer. If it is bigger than the left number then
 * from start to left we have a subproblem, and as we proved already that starting with decreasing and ending with
 * increasing sequence array will have to have a local minima, we can safely go to the left subarray. Otherwise if mid
 * is bigger than its right, then we go to the right subarray. This way we guarantee a O(log n) algorithm to find any
 * of the local minima present in the array.

 */
public class LocalMinimum {

    public static void main(String[] args)
    {
        int[] arr = {64, 14, 52, 27, 71, 19, 63, 1, 16, 57};
        for (int num : arr)
            System.out.print(num + ", ");
        System.out.println();
        int minima = findLocalMinima(arr);
        System.out.println(minima);
    }

    private static int findLocalMinima(int[] arr)
    {
        return findLocalMinima(arr, 0, arr.length);
    }

    private static int findLocalMinima(int[] arr, int start, int end)
    {
        int mid = (start + end) / 2;

        if (mid - 2 < 0 && mid + 1 >= arr.length)
            return -1;
        if (arr[mid - 2] > arr[mid - 1] && arr[mid - 1] < arr[mid])
            return arr[mid - 1];
        if (arr[mid - 1] > arr[mid - 2])
            return findLocalMinima(arr, start, mid);
        else
            return findLocalMinima(arr, mid, end);
    }


}
