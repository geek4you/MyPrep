import java.util.Arrays;

/**
 * Created by chanumolu on 6/17/15.
 */
public class MergeSort {

    // Function to merge the two haves arr[l..m] and arr[m+1..h] of array arr[]
    private static void merge(int[] arry, int l, int m, int h) {
        // l = low, m = mid , h = high

        //create 2 temp arrays
        int n1 = m - l + 1;
        int n2 = h - m;
        int[] tmp1 = new int[n1];
        int[] tmp2 = new int[n2];

        // Copy data to temp arrays
        for (int i = 0; i < tmp1.length; i++)
            tmp1[i] = arry[l + i];
        for (int i = 0; i < tmp2.length; i++)
            tmp2[i] = arry[m + 1 + i];

        // merge temp arrays back into array
        int i = 0, j = 0, k = l;
        while (i < n1 && j < n2) {
            if (tmp1[i] < tmp2[j]) {
                arry[k] = tmp1[i];
                i++;
                k++;
            } else {
                arry[k] = tmp2[j];
                j++;
                k++;
            }
        }

        // merge the remaining arrays
        while (i < n1) {
            arry[k] = tmp1[i];
            i++;
            k++;
        }
        while (j < n2) {
            arry[k] = tmp2[j];
            j++;
            k++;
        }
    }

    private static void mergeSort(int[] arry, int low, int high) {
        if (low < high) {
            int mid = (low + high) / 2;
            mergeSort(arry, low, mid);
            mergeSort(arry,mid+1,high);
            merge(arry,low,mid,high);
        }
    }

    public static void main(String[] args) {
        int[] arry = {20, 16, 3, 5, 1 , 12 , 2 , 1 };
        mergeSort(arry,0,arry.length-1);
        System.out.println(Arrays.toString(arry));
    }

}
