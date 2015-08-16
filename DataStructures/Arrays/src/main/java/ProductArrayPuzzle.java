/**
 * Created by chanumolu on 6/23/15.
 */

/**
 * @link http://www.geeksforgeeks.org/a-product-array-puzzle/
 * A Product Array Puzzle
 * Given an array arr[] of n integers, construct a Product Array prod[] (of same size) such that prod[i] is equal to the
 * product of all the elements of arr[] except arr[i]. Solve it without division operator and in O(n).
 * <p>
 * Example:
 * arr[] = {10, 3, 5, 6, 2}
 * prod[] = {180, 600, 360, 300, 900}
 */
public class ProductArrayPuzzle {

    public static int[] productArryPuzzle(int[] ary) {

        int[] left = new int[ary.length];
        int[] right = new int[ary.length];

        left[0] = 1;
        right[ary.length-1] = 1;

        for (int i = 1; i < left.length; i++) {
            left[i] = left[i - 1] * ary[i - 1];
        }

        for (int i = right.length - 2; i >= 0; i--) {
            right[i] = right[i + 1] * ary[i + 1];
        }

        int[] returnAry = new int[ary.length];

        for (int i = 0; i < returnAry.length; i++) {
            returnAry[i] = left[i] * right[i];
        }

        return returnAry;
    }

    public static void main(String[] args) {
        int[] ary = {10, 3, 5, 6, 2};
        int[] arry = productArryPuzzle(ary);
        for(int i : arry){
            System.out.print(i+" ");
        }
    }
}
