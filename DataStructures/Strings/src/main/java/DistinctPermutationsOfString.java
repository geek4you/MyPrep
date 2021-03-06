/**
 * Created by chanumolu on 8/11/15.
 */

import java.util.*;

public class DistinctPermutationsOfString {

    public static void permutations(char[] arr){
        Map<String,Integer> map = new HashMap<String,Integer>();
        Arrays.sort(arr);
        map.put(new String(arr), 1);
        while(nextPermutation(arr)){
            map.put(new String(arr), 1);
        }

        for(String i : map.keySet())
            System.out.println(i);
    }

    public static boolean nextPermutation(char[] arr) {

        int k = arr.length - 2;

        // find longest decreasing suffix
        // the only difference from next permutation is use arr[k]>=arr[k+1]
        while (k >= 0 && arr[k] >= arr[k + 1]) {
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

    public static void swap(char[] st, int i, int j) {
        char x = st[i];
        st[i] = st[j];
        st[j] = x;
    }

    public static void main(String[] args) {

        char[] arr = {'A','B','C','A'};
        permutations(arr);
    }
}
