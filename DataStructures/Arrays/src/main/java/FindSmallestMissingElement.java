/**
 * Created by chanumolu on 11/1/15.
 * <p>
 * Find the smallest missing number
 * Given a sorted array of n integers where each integer is in the range from 0 to m-1 and m > n.
 * Find the smallest number that is missing from the array.
 * <p>
 * Examples
 * Input: {0, 1, 2, 6, 9}, n = 5, m = 10
 * Output: 3
 * <p>
 * Input: {4, 5, 10, 11}, n = 4, m = 12
 * Output: 0
 * <p>
 * Input: {0, 1, 2, 3}, n = 4, m = 5
 * Output: 4
 * <p>
 * Input: {0, 1, 2, 3, 4, 5, 6, 7, 10}, n = 9, m = 11
 * Output: 8
 */

/**
 * Find the smallest missing number
 Given a sorted array of n integers where each integer is in the range from 0 to m-1 and m > n.
 Find the smallest number that is missing from the array.

 Examples
 Input: {0, 1, 2, 6, 9}, n = 5, m = 10
 Output: 3

 Input: {4, 5, 10, 11}, n = 4, m = 12
 Output: 0

 Input: {0, 1, 2, 3}, n = 4, m = 5
 Output: 4

 Input: {0, 1, 2, 3, 4, 5, 6, 7, 10}, n = 9, m = 11
 Output: 8
 */

/**
 * Algo: Modified binary search tree
 * In the standard Binary Search process, the element to be searched is compared with the middle element and on the
 * basis of comparison result, we decide whether to search is over or to go to left half or right half.
 In this method, we modify the standard Binary Search algorithm to compare the middle element with its index and make
 decision on the basis of this comparison.

 …1) If the first element is not same as its index then return first index
 …2) Else get the middle index say mid
 …………a) If arr[mid] greater than mid then the required element lies in left half.
 …………b) Else the required element lies in right half.
 */
public class FindSmallestMissingElement {

    static void findSmallestMissingElem(int[] arr) {
        if (arr[0] != 0)
            System.out.println(0);
        else
            System.out.println(findSmallestMissingElemUtil(arr,0,arr.length-1));
    }

    static int findSmallestMissingElemUtil(int[] arr, int l, int h) {

        if(l>h)
            return h+1;

        if(l != arr[l])
            return l;

        int mid = (l+h)/2;

        if(arr[mid] > mid)
            return findSmallestMissingElemUtil(arr,l,mid);
        else
            return findSmallestMissingElemUtil(arr,mid+1,h);
    }

    public static void main(String[] args) {
        int arr[] = {0, 1, 2, 3, 4, 5, 6, 7, 10};
        findSmallestMissingElem(arr);
    }
}
