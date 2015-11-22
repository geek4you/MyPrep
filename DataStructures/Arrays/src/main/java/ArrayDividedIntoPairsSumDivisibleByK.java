/**
 * Created by chanumolu on 11/9/15.
 */

/**
 * Check if an array can be divided into pairs whose sum is divisible by k
 Given an array of integers and a number k, write a function that returns true if given array can be divided into pairs
 such that sum of every pair is divisible by k.

 Examples:

 Input: arr[] = {9, 7, 5, 3}, k = 6
 Output: True
 We can divide array into (9, 3) and (7, 5).
 Sum of both of these pairs is a multiple of 6.

 Input: arr[] = {92, 75, 65, 48, 45, 35}, k = 10
 Output: True
 We can divide array into (92, 48), (75, 65) and
 (45, 35). Sum of all these pairs is a multiple of 10.

 Input: arr[] = {91, 74, 66, 48}, k = 10
 Output: False

 */

import java.util.HashMap;
import java.util.Map;

/**
 * An Efficient Solution is to use Hashing.

 1) If length of  given array is odd, return false. An odd
 length array cannot be divided in pairs.
 2) Traverse input array array and count occurrences of
 all remainders.
 freq[arr[i] % k]++
 3) Traverse input array again.
 a) Find remainder of current element.
 b) If remainder divides k into two halves, then
 there must be even occurrences of it as it forms
 pair with itself only.
 c) Else, number of occurrences of current remainder
 must be equal to number of occurrences of "k -
 current remainder".
 Time complexity of above algorithm is O(n).

 Time: O(n)
 */
public class ArrayDividedIntoPairsSumDivisibleByK {

    // Returns true if arr[0..n-1] can be divided into pairs
    // with sum divisible by k.
    static boolean arrayDividedIntoPairs(int[] arr, int k) {
        int n = arr.length;
        // An odd length array cannot be divided into pairs
        if (n % 2 != 0)
            return false;

        // Create a frequency array to count occurrences
        // of all remainders when divided by k.
        Map<Integer, Integer> freq = new HashMap<Integer, Integer>();
        // Count occurrences of all remainders
        for (int i = 0; i < n; i++) {
            if (freq.containsKey(arr[i] % k)) {
                freq.put(arr[i] % k, freq.get(arr[i] % k) + 1);
            } else {
                freq.put(arr[i] % k, 1);
            }
        }

        // Traverse input array and use freq[] to decide
        // if given array can be divided in pairs
        for (int i = 0; i < n; i++) {
            // Remainder of current element
            int rem = arr[i] % k;

            // If remainder with current element divides
            // k into two halves.
            if (2 * rem == k) {
                // Then there must be even occurrences of
                // such remainder
                if (freq.get(rem) % 2 != 0)
                    return false;
            }

            // Else number of occurrences of remainder
            // must be equal to number of occurrences of
            // k - remainder
            else if (freq.get(rem) != freq.get(k - rem))
                return false;
        }

        return true;
    }

    public static void main(String[] args) {
        int arr[] =  {92, 75, 65, 48, 45, 35};
        int k = 10;
        System.out.println(arrayDividedIntoPairs(arr,k));
    }
}
