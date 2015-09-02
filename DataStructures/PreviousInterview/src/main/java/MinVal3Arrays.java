/**
 * Created by chanumolu on 8/18/15.
 */

import java.util.Arrays;

/**
 * Google Interview Questions: Given three arrays, A, B, and C, what is the best algorithm to find the minimum value of
 * |a−b|+|b−c|+|c−a|, where  a∈A,b∈B,c∈C?
 * <p>
 * <p>
 * Assuming that the arrays are not sorted, here is an nlogn algorithm.
 * <p>
 * Sort the arrays A, B and C. Let there sizes be n,m and p.
 * let i,j,k =0 points to the start indices of the 3 arrays.
 * ans = INT_MAX;
 * while(i < n && j<m && k<p)
 * ans = min(ans, abs(A[i] - B[j]) + abs(B[j] - C[k]) + abs(C[k]-A[i]))
 * increment the index of minumum of A[i], B[j], C[k]
 * return ans
 */
public class MinVal3Arrays {


    public static int minVal(int[] arr1, int[] arr2, int[] arr3) {

        // sort the arrays
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        Arrays.sort(arr3);

        int i1 = 0, i2 = 0, i3 = 0;
        int min = Integer.MAX_VALUE;

        while (i1 < arr1.length && i2 < arr2.length && i3 < arr3.length) {

            int diff = calMinSum(arr1[i1], arr2[i2], arr3[i3]);
            if(min > diff)
                min = diff;

            int minVal = min(arr1[i1],arr2[i2],arr3[i3]);
            if(minVal == arr1[i1])
                i1++;
            if(minVal == arr2[i2])
                i2++;
            if(minVal == arr3[i3])
                i3++;

        }

        return min;
    }

    public static int calMinSum(int a, int b, int c) {
        return Math.abs(a - b) + Math.abs(b - c) + Math.abs(c - a);
    }

    public static int min(int a, int b, int c) {
        if (a < b && a < c)
            return a;
        else if (b < c)
            return b;
        else
            return c;
    }

    public static void main(String[] args) {

    }
}
