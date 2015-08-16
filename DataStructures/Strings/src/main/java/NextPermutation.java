/**
 * Created by chanumolu on 8/11/15.
 */

/**
 * EPL
 * Page 202
 * <p>
 * Given array A of integers representing a permutaion, update A to represent the inverse permutation using only constant
 * additional storage
 */
public class NextPermutation {

    public static int[] nextPermutation(int[] arr) {
        int k = arr.length - 2;
        while (k >= 0 && arr[k] >= arr[k + 1]) {
            --k;
        }
        if (k == -1)
            return arr; // arr is last permutation

        // swap the smallest entry after index k that is greater than arr[k]
        // we exploit the fact that arr[k+1 : arr.length-1] is decreasing so if we search in reverse order, the first entry
        // that is greater than arr[k] is the smallest entry
        for (int i = arr.length - 1; i > k; --i) {
            if (arr[i] > arr[k]) {
                swap(arr, i, k);
                break;
            }
        }

        // since arr[k+1 : arr.length-1] is in decreasing order, we can build the smallest dictionary ordering of this
        // subarray by reversing it.
        reverse(arr, k + 1, arr.length - 1);

        return arr;
    }

    public static void swap(int[] st, int i, int j) {
        int x = st[i];
        st[i] = st[j];
        st[j] = x;
    }

    public static void reverse(int[] arr, int l, int h) {
        int i = l;
        int j = h;

        while (i < j) {
            swap(arr, i, j);
            ++i;
            --j;
        }
    }

    public static void main(String[] args) {
        int arr[] = {1, 0, 3, 2};
        arr = nextPermutation(arr);

        for(int i : arr){
            System.out.print(i+" ");
        }
    }

}
