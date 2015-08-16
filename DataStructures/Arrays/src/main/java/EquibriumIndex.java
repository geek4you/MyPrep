/**
 * Created by chanumolu on 6/27/15.
 */

/**
 * @link : http://www.geeksforgeeks.org/equilibrium-index-of-an-array/
 * Equilibrium index of an array is an index such that the sum of elements at lower indexes is equal to the sum of
 * elements at higher indexes. For example, in an arrya A:
 * <p>
 * A[0] = -7, A[1] = 1, A[2] = 5, A[3] = 2, A[4] = -4, A[5] = 3, A[6]=0
 * <p>
 * 3 is an equilibrium index, because:
 * A[0] + A[1] + A[2] = A[4] + A[5] + A[6]
 * <p>
 * sol:
 * 1) Initialize leftsum  as 0
 * 2) Get the total sum of the array as sum
 * 3) Iterate through the array and for each index i, do following.
 * a)  Update sum to get the right sum.
 * sum = sum - arr[i]
 * // sum is now right sum
 * b) If leftsum is equal to sum, then return current index.
 * c) leftsum = leftsum + arr[i] // update leftsum for next iteration.
 * 4) return -1 // If we come out of loop without returning then
 * // there is no equilibrium index
 */
public class EquibriumIndex {

    public static int equibriumIndex(int[] arry) {

        int sum = 0;

        for (int i : arry)
            sum = sum + i;


        int leftSum = 0;

        for (int i = 0; i < arry.length; i++) {
            sum = sum - arry[i];
            if (leftSum == sum) {
                return i;
            }
            leftSum = leftSum + arry[i];
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] arry = {-7, 1, 5, 2, -4, 3, 0};
        System.out.println("Index of equibrium point: " + equibriumIndex(arry));
    }
}
