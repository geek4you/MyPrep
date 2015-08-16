/**
 * Created by chanumolu on 6/16/15.
 */


/**
 * @link: Search an element in a sorted and pivoted array
 * Question:
 * An element in a sorted array can be found in O(log n) time via binary search. But suppose I rotate the sorted array at
 * some pivot unknown to you beforehand. So for instance, 1 2 3 4 5 might become 3 4 5 1 2. Devise a way to find an
 * element in the rotated array in O(log n) time.
 * <p>
 * 3   4   5   2  1
 * <p>
 * Find the pivot point, divide the array in two sub-arrays and call binary search.
 * The main idea for finding pivot is – for a sorted (in increasing order) and pivoted array, pivot element is the only
 * only element for which next element to it is smaller than it.
 * Using above criteria and binary search methodology we can get pivot element in O(logn) time
 * <p>
 * Input arr[] = {3, 4, 5, 1, 2}
 * Element to Search = 1
 * 1) Find out pivot point and divide the array in two
 * sub-arrays. (pivot = 2) //Index of 5
 * 2) Now call binary search for one of the two sub-arrays.
 * (a) If element is greater than 0th element then
 * search in left array
 * (b) Else Search in right array
 * (1 will go in else as 1 < 0th element(3))
 * 3) If element is found in selected sub-array then return index
 * Else return -1.
 */
public class SearchInSortedPivotedArray {

    private static int findPivot(int[] ary, int low, int high) {
        if (low > high)
            return -1;

        if (low == high)
            return low;

        int mid = (low + high) / 2;
        if (mid < high && ary[mid] > ary[mid + 1])
            return mid;

        if (mid > low && ary[low] < ary[mid])
            return findPivot(ary, mid + 1, high);
        else
            return findPivot(ary, low, mid - 1);

    }

    private static int binarySearch(int[] ary, int low, int high, int key) {
        if (low > high)
            return -1;

        int mid = (low + high) / 2;

        if (ary[mid] == key)
            return mid;

        if(ary[mid]< key)
            return binarySearch(ary, mid+1, high, key);
        else
            return binarySearch(ary, low, mid-1,  key);
    }

    private static int searchInPivotedArray(int[] ary, int key){
        int pivot = findPivot(ary, 0, ary.length-1);
        System.out.println("Index of pivot: " + pivot+ " and pivot: "+ary[pivot]);
        if(ary[0]>key)
            return binarySearch(ary,pivot+1,ary.length-1,key);
        else
            return binarySearch(ary,0,pivot,key);
    }

    public static void main(String[] args) {
        int[] ary = {5, 6, 7, 8, 9, 10, 1, 2, 3};
        int index = searchInPivotedArray(ary,3);
        System.out.println("Element is at index: "+ index +"\nary["+index+"] : "+ary[index]);

    }


}
