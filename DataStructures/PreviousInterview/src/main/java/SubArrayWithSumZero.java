/**
 * Created by chanumolu on 11/7/15.
 */

import java.util.HashMap;

/**
 * We can also use hashing. The idea is to iterate through the array and for every element arr[i], calculate sum of
 * elements form 0 to i (this can simply be done as sum += arr[i]). If the current sum has been seen before, then there
 * is a zero sum array. Hashing is used to store the sum values, so that we can quickly store sum and find out whether
 * the current sum is seen before or not.

 Following is Java implementation of the above approach.
 */
public class SubArrayWithSumZero {

    static boolean isThereSubArrayWithSumZero(int arr[]){
        // Creates an empty hashMap hM
        HashMap<Integer, Integer> hM = new HashMap<Integer, Integer>();

        // Initialize sum of elements
        int sum = 0;

        // Traverse through the given array
        for (int i = 0; i < arr.length; i++)
        {
            // Add current element to sum
            sum += arr[i];

            // Return true in following cases
            // a) Current element is 0
            // b) sum of elements from 0 to i is 0
            // c) sum is already present in hash map
            if (arr[i] == 0 || sum == 0 || hM.get(sum) != null)
                return true;

            // Add sum to hash map
            hM.put(sum, i);

        }
        // We reach here only when there is no subarray with 0 sum
        return false;
    }

    public static void main(String arg[])
    {
        int arr[] = {4, 2, -3, 1, 6};
        if (isThereSubArrayWithSumZero(arr))
            System.out.println("Found a subarray with 0 sum");
        else
            System.out.println("No Subarray with 0 sum");
    }
}
