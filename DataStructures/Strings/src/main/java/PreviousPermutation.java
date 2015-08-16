/**
 * Created by chanumolu on 8/11/15.
 */

/**
 * From EPL
 * <p>
 * Page: 204
 */
public class PreviousPermutation {


    public static int[] prevPermutation(int[] arr) {
        int k = arr.length - 2;

        while (k >= 0 && !(arr[k] > arr[k + 1])) {
            --k;
        }

        if (k == -1) // this is the first permutation in dictionary order
            return arr;

        // swap all till last
        while (k < arr.length - 1) {
            swap(arr, k, k + 1);
            ++k;
        }

        return arr;

    }

    public static void swap(int[] st, int i, int j) {
        int x = st[i];
        st[i] = st[j];
        st[j] = x;
    }

    public static void main(String[] args) {
        int arr[] = {5, 4, 3, 6};
        arr = prevPermutation(arr);

        for (int i : arr) {
            System.out.print(i + " ");
        }

        int arr1[] = {6, 2, 1, 5, 3, 4, 0};
        arr1 = prevPermutation(arr1);
        System.out.println();
        for(int i : arr1){
            System.out.print(i + " ");
        }
    }
}
