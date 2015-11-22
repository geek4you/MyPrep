/**
 * Created by chanumolu on 11/3/15.
 */

import java.util.Arrays;

/**
 * http://www.geeksforgeeks.org/reorder-a-array-according-to-given-indexes/
 * <p>
 * Reorder an array according to given indexes
 * Given two integer arrays of same size, “arr[]” and “index[]”, reorder elements in “arr[]” according to given index array. It is not allowed to given array arr’s length.
 * <p>
 * Example:
 * <p>
 * Input:  arr[]   = [10, 11, 12];
 * index[] = [1, 0, 2];
 * Output: arr[]   = [11, 10, 12]
 * index[] = [0,  1,  2]
 * <p>
 * Input:  arr[]   = [50, 40, 70, 60, 90]
 * index[] = [3,  0,  4,  1,  2]
 * Output: arr[]   = [40, 60, 90, 50, 70]
 * index[] = [0,  1,  2,  3,   4]
 * Expected time complexity O(n) and auxiliary space O(1)
 * <p>
 * Algorithm:
 * A Simple Solution is to use an auxiliary array temp[] of same size as given arrays.
 * Traverse the given array and put all elements at their correct place in temp[] using index[].
 * Finally copy temp[] to arr[] and set all values of index[i] as i.
 * <p>
 * <p>
 * We can solve it Without Auxiliary Array. Below is algorithm.
 * 1) Do following for every element arr[i]
 * a) While index[i] is not equal to i
 * (i)  Store array and index values of the target (or
 * correct) position where arr[i] should be placed.
 * The correct position for arr[i] is index[i]
 * (ii) Place arr[i] at its correct position. Also
 * update index value of correct position.
 * (iii) Copy old values of correct position (Stored in
 * step (i)) to arr[i] and index[i] as the while
 * loop continues for i.
 */
public class ReorderArrayAccordingToGivenIndexes {

    static void reorder(int[] arr, int[] index) {
        int i = 0;
        while (i < arr.length - 1) {
            if (index[i] != i) {
                // swap the index and the correspoting array elements to the position index[i]
                swap(arr,index[i],i);
                swap(index,i,index[i]);
            }else {
                i++;
            }
        }
    }

    static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) {
        int arr[] = {50, 40, 70, 60, 90};
        int index[] = {3,  0,  4,  1,  2};

        System.out.println("Array before reordering: ");
        System.out.println(Arrays.toString(arr));
        reorder(arr,index);
        System.out.println("Array after reordering: ");
        System.out.println(Arrays.toString(arr));
    }

}
