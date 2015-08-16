/**
 * Created by chanumolu on 6/22/15.
 */

/**
 * Inversion Count for an array indicates – how far (or close) the array is from being sorted.
 * If array is already sorted then inversion count is 0. If array is sorted in reverse order that inversion count is the maximum.
 * Formally speaking, two elements a[i] and a[j] form an inversion if a[i] > a[j] and i < j
 * <p>
 * Example:
 * The sequence 2, 4, 1, 3, 5 has three inversions (2, 1), (4, 1), (4, 3).
 */
public class CountInversions {

    public static int countInversions(int[] ary) {

        return mergeSort(ary, 0, ary.length - 1);

    }

    public static int mergeSort(int[] ary, int low, int high) {

        if (low >= high)
            return 0;

        int invCount = 0;
        int mid = (low + high) / 2;

        invCount = mergeSort(ary, low, mid) + mergeSort(ary, mid + 1, high) + merge(ary, low, mid, high);

        return invCount;

    }

    public static int merge(int[] ary, int low, int mid, int high) {

        int n1 = mid - low + 1;
        int n2 = high - mid;
        // tmp arrays
        int[] tmp1 = new int[n1];
        int[] tmp2 = new int[n2];

        // copy into tmp arrays
        for (int i = 0; i < n1; i++) {
            tmp1[i] = ary[low + i];
        }
        for (int j = 0; j < n2; j++) {
            tmp2[j] = ary[mid + j + 1];
        }

        // merge temp arrays back to the array
        int i = 0, j = 0, k = low;
        int invCount = 0;
        while (i < n1 && j < n2) {
            if (tmp1[i] < tmp2[j]) {
                ary[k++] = tmp1[i];
                i++;
            } else {
                invCount += (n1 - i);
                ary[k++] = tmp2[j];
                j++;
            }
        }

        // left over arrays
        while (i < n1)
            ary[k++] = tmp1[i++];
        while (j < n2)
            ary[k++] = tmp2[j++];


        return invCount;
    }

    public static void main(String[] args) {
        int[] ary = {2, 4, 1, 3, 5 ,1};
        System.out.println("Inversions count : "+countInversions(ary));
    }
}
