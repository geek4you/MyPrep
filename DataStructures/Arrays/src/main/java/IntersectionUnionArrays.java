/**
 * Created by chanumolu on 6/23/15.
 */

/**
 * @link http://www.geeksforgeeks.org/find-union-and-intersection-of-two-unsorted-arrays/
 *
 */

/**
 * Normal method for intersection takes O(N+M) time
 * The following method takes: O(min(NlogM , MlogN)) time
 * Binary Search for intersection works better if one of the array is small
 * Another approach that is useful when difference between sizes of two given arrays is significant.
 The idea is to iterate through the shorter array and do a binary search for every element of short array in big array
 (note that arrays are sorted). Time complexity of this solution is O(min(mLogn, nLogm)).
 This solution works better than the above approach when ratio of larger length to smaller is more than logarithmic order.
 */
public class IntersectionUnionArrays {
}
