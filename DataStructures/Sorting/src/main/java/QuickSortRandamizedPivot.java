/**
 * Created by chanumolu on 8/9/15.
 */

import java.util.Random;

/**
 *

 */
public class QuickSortRandamizedPivot {

    /*
     partition method for arr[p..q]
     returns pivot.
    */
    public static int partition(int[] arr, int p, int q) {

        int i = p, j = q;
        int tmp;
        int pivot = arr[(p + q) / 2];

        while (i <= j) {
            while (arr[i] < pivot)
                i++;
            while (arr[j] > pivot)
                j--;
            if (i <= j) {
                tmp = arr[i];
                arr[i] = arr[j];
                arr[j] = tmp;
                i++;
                j--;
            }
        };

        return i;

    }

    public static void quickSort(int[] arr, int p, int q) {

        if (p < q) {
            int r = partition(arr, p, q);
            if (p < r - 1)
                quickSort(arr, p, r - 1);
            if (r < q)
                quickSort(arr, r, q);


        }

    }


    public static void main(String[] args) {

        int[] arry = {10, 2, 3, 40, 32, 1, 0, 43, 100, 5};
        quickSort(arry, 0, arry.length - 1);

        for (int i : arry) {
            System.out.print(i + " ");
        }

    }
}
