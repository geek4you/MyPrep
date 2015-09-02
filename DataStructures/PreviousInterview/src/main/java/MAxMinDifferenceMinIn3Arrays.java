/**
 * Created by chanumolu on 8/18/15.
 */

/*
Given 3 sorted arrays. Find(x,y,z), (where x is from 1st array, y is from 2nd array, and z is from 3rd array), such that
Max(x,y,z) - Min(x,y,z) is minimum.

  Time: O(n) since the arrays are already sorted.
  Time: O(nlogn) since the arrays are not sorted.
 */
public class MAxMinDifferenceMinIn3Arrays {

    public static int[] minGap(int[] arr1, int[] arr2, int[] arr3) {

        int i1 = 0, i2 = 0, i3 = 0;
        int x = 0, y = 0, z = 0;

        int diff = Integer.MAX_VALUE;
        int max, min;

        while (i1 < arr1.length && i2 < arr2.length && i3 < arr3.length) {

            max = max(arr1[i1], arr2[i2], arr3[i3]);
            min = min(arr1[i1], arr2[i2], arr3[i3]);

            if (diff > (max - min)) {
                diff = max - min;
                x = i1;
                y = i2;
                z = i3;
            }

            if (min == arr1[i1])
                i1++;
            if (min == arr2[i2])
                i2++;
            if (min == arr3[i3])
                i3++;

        }

        return new int[]{x, y, z, diff};
    }

    public static void main(String[] args) {
        int[] arr1 = {5, 7, 9, 11, 12, 20};
        int[] arr2 = {4, 5, 11, 14, 16, 20};
        int[] arr3 = {1, 3, 4, 8, 10, 20};

        //int[] arr1 = {1,4,12};
        //int [] arr2 ={2,10,11};
        //int[] arr3 = {10,11};
        int[] arr = minGap(arr1,arr2,arr3);

        System.out.println("X : "+arr1[arr[0]]);
        System.out.println("Y : "+arr2[arr[1]]);
        System.out.println("Z : "+arr3[arr[2]]);
        System.out.println("Max-Min: "+arr[3]);
    }

    public static int max(int a, int b, int c) {
        if (a > b && a > c)
            return a;
        else if (b > c)
            return b;
        else return c;
    }

    public static int min(int a, int b, int c) {
        if (a < b && a < c)
            return a;
        else if (b < c)
            return b;
        else
            return c;

    }
}
