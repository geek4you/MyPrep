/**
 * Created by chanumolu on 8/10/15.
 */

import java.util.Arrays;

/**
 * @link : http://www.geeksforgeeks.org/write-a-c-program-to-print-all-permutations-of-a-given-string/
 * BackTracking Algorithm
 * print all permutations of a given string
 * <p>
 * <p>
 * explanation : https://www.youtube.com/watch?v=MQcwxQK2DPA
 * <p>
 * Time Complexity: O(n*n!)
 */
public class PermutationsOfString {

    /* Function to print permutations of string
   This function takes three parameters:
   1. String
   2. Starting index of the string
   3. Ending index of the string. */
    public static void permute(char[] arr, int start, int end) {
        int i;
        if (start == end)
            System.out.println(new String(arr));
        else {
            for (i = start; i <= end; i++) {
                swap(arr, start, i);
                permute(arr, start + 1, end);
                swap(arr, start, i); //backtrack
            }
        }
    }

    public static void swap(char[] st, int i, int j) {
        char x = st[i];
        st[i] = st[j];
        st[j] = x;
    }

    public static void main(String[] args) {
        String str = "prade";
        //permute(str.toCharArray(), 0, 4);
        permutations(str.toCharArray());
    }


    /**
     * From EPL
     */

    public static void permutations(char[] arr){
        Arrays.sort(arr);
        System.out.println(arr);
        while(nextPermutation(arr)){
            System.out.println(arr);
        }
    }

    public static boolean nextPermutation(char[] arr) {

        int k = arr.length - 2;

        // find longest decreasing suffix
        while (k >= 0 && arr[k] > arr[k + 1]) {
            --k;
        }

        if (k == -1) // this is last
            return false;

        for (int i = arr.length - 1; i > k; --i) {
            if (arr[i] > arr[k]) {
                swap(arr, k, i);
                break;
            }

        }

        reverse(arr, k + 1, arr.length - 1);
        return true;

    }

    public static void reverse(char[] arr, int l, int h) {
        int i = l;
        int j = h;

        while (i < j) {
            swap(arr, i, j);
            ++i;
            --j;
        }
    }
}


