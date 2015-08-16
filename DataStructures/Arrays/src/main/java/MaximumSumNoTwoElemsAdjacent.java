/**
 * Created by chanumolu on 6/17/15.
 */

/**
 * @link http://www.geeksforgeeks.org/maximum-sum-such-that-no-two-elements-are-adjacent/
 * Maximum sum such that no two elements are adjacent
Question: Given an array of positive numbers, find the maximum sum of a subsequence with the constraint that no 2
numbers in the sequence should be adjacent in the array. So 3 2 7 10 should return 13 (sum of 3 and 10) or 3 2 5 10 7
should return 15 (sum of 3, 5 and 7).Answer the question in most efficient way.

Algorithm:
Loop for all elements in arr[] and maintain two sums incl and excl where incl = Max sum including the previous element
and excl = Max sum excluding the previous element.

Max sum excluding the current element will be max(incl, excl) and max sum including the current element will be excl +
current element (Note that only excl is considered because elements cannot be adjacent).

At the end of the loop return max of incl and excl.
 */
public class MaximumSumNoTwoElemsAdjacent {

    //TODO : What if negative elements are present.
    private static int maxSum(int[] ary) {
        // max sum including previous element
        int incl = ary[0];
        // max sum excluding previous element
        int excl = 0;
        int excl_new = 0;

        for (int i = 1; i < ary.length; i++) {
            // current max excluding i
            excl_new = (incl > excl)? incl: excl;

            // current max including i
            incl = excl + ary[i];

            excl = excl_new;
        }

        return (incl > excl)? incl: excl;

    }

    public static void main(String[] args) {
        int arr[] = {5, 5, 10, 100, 10, 5};
        System.out.printf("Max sum no two elemets adjacent: "+maxSum(arr));
    }
}
