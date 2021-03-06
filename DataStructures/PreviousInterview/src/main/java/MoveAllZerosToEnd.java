/**
 * Created by chanumolu on 10/28/15.
 */


/**
 * Ooyala Interview
 */

/**
 * Given an array, shift all the zeros to the right of the array, without disrupting order of the non zero elements
 *
 * Move all zeroes to end of array
 Given an array of random numbers, Push all the zero’s of a given array to the end of the array. For example,
 if the given arrays is {1, 9, 8, 4, 0, 0, 2, 7, 0, 6, 0}, it should be changed to {1, 9, 8, 4, 2, 7, 6, 0, 0, 0, 0}.
 The order of all other elements should be same. Expected time complexity is O(n) and extra space is O(1).

 There can be many ways to solve this problem. Following is a simple and interesting way to solve this problem.
 Traverse the given array ‘arr’ from left to right. While traversing, maintain count of non-zero elements in array.
 Let the count be ‘count’. For every non-zero element arr[i], put the element at ‘arr[count]’ and increment ‘count’.
 After complete traversal, all non-zero elements have already been shifted to front end and ‘count’ is set as index of
 first 0. Now all we need to do is that run a loop which makes all elements zero from ‘count’ till end of the array.

 */
public class MoveAllZerosToEnd {

    // Function which pushes all zeros to end of an array.
    static void pushZerosToEnd(int arr[], int n)
    {
        int count = 0;  // Count of non-zero elements

        // Traverse the array. If element encountered is
        // non-zero, then replace the element at index 'count'
        // with this element
        for (int i = 0; i < n; i++)
            if (arr[i] != 0)
                arr[count++] = arr[i]; // here count is
        // incremented

        // Now all non-zero elements have been shifted to
        // front and 'count' is set as index of first 0.
        // Make all elements 0 from count to end.
        while (count < n)
            arr[count++] = 0;
    }

    /*Driver function to check for above functions*/
    public static void main (String[] args)
    {
        int arr[] = {1, 9, 8, 4, 0, 0, 2, 7, 0, 6, 0, 9};
        int n = arr.length;
        pushZerosToEnd(arr, n);
        System.out.println("Array after pushing zeros to the back: ");
        for (int i=0; i<n; i++)
            System.out.print(arr[i]+" ");
    }
}
