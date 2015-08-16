/**
 * Created by chanumolu on 6/28/15.
 */

/**
 * Time : O(long)
 *
 * @link : http://www.geeksforgeeks.org/count-number-of-occurrences-in-a-sorted-array/
 * <p>
 * Count the number of occurrences in a sorted array
 * Given a sorted array arr[] and a number x, write a function that counts the occurrences of x in arr[].
 * Expected time complexity is O(Logn)
 * <p>
 * <p>
 * 1) Use Binary search to get index of the first occurrence of x in arr[]. Let the index of the first occurrence be i.
 * 2) Use Binary search to get index of the last occurrence of x in arr[]. Let the index of the last occurrence be j.
 * 3) Return (j – i + 1);
 *
 * TODO:
 */
public class NumberOfOccurencesArray {

    public static int numberOfOccurences(int[] arry, int key) {
        if (arry.length <= 0)
            throw new RuntimeException("No elems in arry!!");

        int i = first(arry, 0, arry.length - 1, key);
        if (i == -1)
            return -1;
        //int j = last(arry, key);
        System.out.println("First: " + i);
        return -1;

    }

    public static int first(int[] arry, int l, int h, int key) {
        if (h >= l) {
            int mid = (h + l) / 2;

            if ((mid == 0 || key > arry[mid - 1]) && arry[mid] == key)
                return mid;
            else if (key > arry[mid])
                return first(arry, (mid + 1), h, key);
            else
                return first(arry, l, (mid - 1), key);
        }
        return -1;
    }

    public static void main(String[] args) {
        int arr[] = {1, 1, 2, 2, 2, 2, 3};
        System.out.println(numberOfOccurences(arr, 4));
    }
}
