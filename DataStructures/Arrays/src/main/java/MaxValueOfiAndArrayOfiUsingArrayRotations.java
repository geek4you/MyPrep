/**
 * Created by chanumolu on 11/4/15.
 */

/**
 * Find maximum value of Sum( i*arr[i]) with only rotations on given array allowed
 * Given an array, only rotation operation is allowed on array. We can rotate the array as many times as we want.
 * Return the maximum possbile of summation of i*arr[i].
 * <p>
 * Example:
 * <p>
 * Input: arr[] = {1, 20, 2, 10}
 * Output: 72
 * We can 72 by rotating array twice.
 * {2, 10, 1, 20}
 * 20*3 + 1*2 + 10*1 + 2*0 = 72
 * <p>
 * Input: arr[] = {10, 1, 2, 3, 4, 5, 6, 7, 8, 9};
 * Output: 330
 * We can 330 by rotating array 9 times.
 * {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
 * 0*1 + 1*2 + 2*3 ... 9*10 = 330
 * <p>
 * We strongly recommend you to minimize your browser and try this yourself first.
 * <p>
 * A Simple Solution is to find all rotations one by one, check sum of every rotation and return the maximum sum.
 * Time complexity of this solution is O(n2).
 * <p>
 * We can solve this problem in O(n) time using an Efficient Solution.
 * Let Rj be value of i*arr[i] with j rotations. The idea is to calculate next rotation value from previous rotation,
 * i.e., calculate Rj from Rj-1. We can calculate initial value of result as R0, then keep calculating next rotation values.
 * <p>
 * How to efficiently calculate Rj from Rj-1?
 * This can be done in O(1) time. Below are details.
 * <p>
 * Let us calculate initial value of i*arr[i] with no rotation
 * R0 = 0*arr[0] + 1*arr[1] +...+ (n-1)*arr[n-1]
 * <p>
 * After 1 rotation arr[n-1], becomes first element of array,
 * arr[0] becomes second element, arr[1] becomes third element
 * and so on.
 * R1 = 0*arr[n-1] + 1*arr[0] +...+ (n-1)*arr[n-2]
 * <p>
 * R1 - R0 = arr[0] + arr[1] + ... + arr[n-2] - (n-1)*arr[n-1]
 * <p>
 * After 2 rotations arr[n-2], becomes first element of array,
 * arr[n-1] becomes second element, arr[0] becomes third element
 * and so on.
 * R2 = 0*arr[n-2] + 1*arr[n-1] +...+ (n?1)*arr[n-3]
 * <p>
 * R2 - R1 = arr[0] + arr[1] + ... + arr[n-3] - (n-1)*arr[n-2] + arr[n-1]
 * <p>
 * If we take a closer look at above values, we can observe
 * below pattern
 * <p>
 * Rj - Rj-1 = arrSum - n * arr[n-j]
 * <p>
 * Where arrSum is sum of all array elements, i.e.,
 * <p>
 * arrSum = ∑ arr[i]
 * i<=0<=n-1
 * Below is complete algorithm:
 * <p>
 * 1) Compute sum of all array elements. Let this sum be 'arrSum'.
 * <p>
 * 2) Compute R0 by doing i*arr[i] for given array.
 * Let this value be currVal.
 * <p>
 * 3) Initialize result: maxVal = currVal // maxVal is result.
 * <p>
 * // This loop computes Rj from  Rj-1
 * 4) Do following for j = 1 to n-1
 * ......a) currVal = currVal + arrSum-n*arr[n-j];
 * ......b) If (currVal > maxVal)
 * maxVal = currVal
 * <p>
 * 5) Return maxVal
 */
public class MaxValueOfiAndArrayOfiUsingArrayRotations {

    static int maxVal(int[] arr) {

        int sum = 0;
        int currentVal = 0;

        // cal R0
        for (int i = 0; i < arr.length - 1; i++) {
            sum = sum + arr[i];
            currentVal = currentVal + (i * arr[i]);
        }

        // cal remaining R values and return max
        int maxVal = Integer.MIN_VALUE;

        // Rj-R(j-1) = sum - n*arr[n-j] => Rj = R(j-1)+ sum - n*arr[n-j]
        for(int j=0 ; j<arr.length;j++){
            if(maxVal<currentVal)
                maxVal= currentVal;

            currentVal = currentVal + sum - (arr.length)*arr[arr.length-1-j];
        }

        return (maxVal>currentVal)?maxVal:currentVal;
    }

    public static void main(String[] args) {
        int arr[] = {10, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        System.out.printf("maxVal: "+maxVal(arr));
    }
}
